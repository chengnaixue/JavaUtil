package com.chengnx.action;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import com.chengnx.entity.Entity;

public class MyCallableThread<V extends Entity> implements Callable<V> {

	private V resultEntity;
	
	public MyCallableThread(V param) {
		this.resultEntity = param;
	}
	
	/**
	 * @see java.util.concurrent.Callable#call()
	 */
	@Override
	public V call() throws Exception {
		try {
			// 等待一段时间，模拟业务执行过程
			synchronized (this) {
				this.wait(5000);
			}
			// 设置返回结果
			this.resultEntity.setStatus(1);
		} catch (Exception e) {
			// 执行错误了，也设置
			this.resultEntity.setStatus(-1);
		}

		return this.resultEntity;
	}
	
	public static void main(String[] args) throws Exception{
		
		MyCallableThread<Entity> callableThread = new MyCallableThread<Entity>(new Entity());
		
		// Callable需要在线程池中执行
		ExecutorService es = Executors.newFixedThreadPool(10);
		Future<Entity> future = es.submit(callableThread);
		
		// main线程会在这里等待，直到callableThread任务执行完成
        Entity result = future.get();
        System.out.println("The result is " + result.getStatus());
		
        // 停止线程池工作
        es.shutdown();
        es.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
	}

}
