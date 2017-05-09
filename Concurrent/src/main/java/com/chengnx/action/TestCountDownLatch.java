package com.chengnx.action;

import java.util.concurrent.CountDownLatch;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TestCountDownLatch {

	private static Log log = LogFactory.getLog(TestCountDownLatch.class);

	public static void main(String[] args) {

		CountDownLatch latch = new CountDownLatch(5);

		for (int i = 0; i < 5; i++) {
			final String index = "thread " + i;
			Thread childThread = new Thread(index) {
				@Override
				public void run() {

					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					log.info("子线程 "+Thread.currentThread().getName() + " 已完成！");
					latch.countDown();

				}
			};
			childThread.start();
		}
		
		try {
			// 等待所有子线程业务完成
			latch.await();
			log.info("所有子线程业务完成，主线程继续运行！");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
