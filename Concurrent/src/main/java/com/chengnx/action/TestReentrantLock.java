package com.chengnx.action;

import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLock {
	
	private final static ReentrantLock lock = new ReentrantLock();
	
	public static void main(String[] args){
		
		Thread t1 = new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				lock.lock();
				System.out.println("in the t1 thread");
				lock.unlock();

			}
		};
		
		Thread t2 = new Thread() {
			@Override
			public void run() {
				lock.lock();
				System.out.println("in the t2 thread");
				lock.unlock();

			}
		};
		
		t1.start();
		t2.start();
		
	}

}
