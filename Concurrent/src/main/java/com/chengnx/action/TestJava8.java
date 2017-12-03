package com.chengnx.action;

import java.util.Arrays;
import java.util.List;

public class TestJava8 {

	public static void main(String[] args) {

		new Thread(new Runnable() {

			@Override
			public void run() {
				
				System.out.println("Test......");

			}

		}).start();
		
		new Thread(() -> System.out.println("Test2......")).start();
		
		List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
		
		features.forEach(feature -> System.out.println(feature));
		features.forEach(TestJava8::print);

	}
	
	public static void print(String str){
		System.out.println(str);
	}

}
