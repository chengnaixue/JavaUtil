package com.chengnx.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.chengnx.entity.Performance;
import com.chengnx.entity.Student;

public class TestAtomicReference {
	
	private static Log log = LogFactory.getLog(TestAtomicReference.class);
	
	public static void main(String[] args){
		Student student = new Student();
		Performance performance = new Performance();
		performance.setPerformance(98);
		student.setPerformace(performance);
		
	}

}
