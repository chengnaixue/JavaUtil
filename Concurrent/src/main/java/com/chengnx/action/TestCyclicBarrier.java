package com.chengnx.action;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TestCyclicBarrier {
	
	private static Log log = LogFactory.getLog(TestCyclicBarrier.class);
	
	public static void main(String[] args){
		
		final CyclicBarrier barrier = new CyclicBarrier(3);
		
		for(int i = 0; i < 5; i++){
			final String index = "thred " + i;
			Thread childThread = new Thread(index){
				@Override
				public void run(){
					log.info("线程 " + Thread.currentThread().getName() + " 已经准备好处理任务");
					try {
						barrier.await();
					} catch (InterruptedException | BrokenBarrierException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					log.info("线程 " + Thread.currentThread().getName() +" 处理完成！");
					
				}
			};
			childThread.start();
		}
		
	}

}
