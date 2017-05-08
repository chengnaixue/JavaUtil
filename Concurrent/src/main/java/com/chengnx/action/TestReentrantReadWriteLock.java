package com.chengnx.action;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TestReentrantReadWriteLock {
	
	private static final Log log = LogFactory.getLog(TestReentrantReadWriteLock.class);	
	private final static ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
	
	public static void main(String[] args){
		
		Thread thread1 = new Thread("thread1") {
			@Override
            public void run() {
                WriteLock writeLock = rwLock.writeLock();
                writeLock.lock();
                try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					log.error(e.getMessage());
				}
                log.info(Thread.currentThread().getName()+" 做了一些写操作的事情。。。。");
                writeLock.unlock();
            }
        };


        Thread thread2 = new Thread("thread2") {
        	@Override
            public void run() {
                WriteLock writeLock = rwLock.writeLock();
                writeLock.lock();
                try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                log.info(Thread.currentThread().getName()+" 做了另一些写操作的事情。。。。");
                writeLock.unlock();
            }
        };

        Thread thread3 = new Thread("thread3") {
        	@Override
            public void run() {
                ReadLock readLock = rwLock.readLock();
                readLock.lock();
                try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                log.info(Thread.currentThread().getName()+" 做了一些读操作的事情。。。。");
                readLock.unlock();
            }
        };
        
        Thread thread4 = new Thread("thread4") {
        	@Override
            public void run() {
                ReadLock readLock = rwLock.readLock();
                readLock.lock();
                try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                log.info(Thread.currentThread().getName()+" 做了另一些读操作的事情。。。。");
                readLock.unlock();
            }
        };
        
        thread3.start();
        thread1.start();
        thread1.interrupt();
        thread4.start();
        thread2.start();
        
	}

}
