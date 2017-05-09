package com.chengnx.entity;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * 学生类
 * @author chengnaixue
 *
 */
public class Student {
	
	private String name;
	private volatile Performance performace;
	
	/**
	 * 学生成绩“更改器”
	 */
	private AtomicReferenceFieldUpdater<Student, Performance> performance_updater =
			AtomicReferenceFieldUpdater.newUpdater(Student.class, Performance.class, "performance");
	
	public Student(){	
	}
	
	public Student(String name,Integer performance){
		this.name = name;
		this.performace = new Performance();
		this.performace.setPerformance(performance);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Performance getPerformace() {
		return performace;
	}
	public void setPerformace(Performance performace) {
		//this.performace = performace;
		performance_updater.set(this, performace);
	}

}
