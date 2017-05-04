package entity;

import annotation.Mapping;

public class Student {

	private String name;
	private int age;
	private double balance;

	@Mapping("other")
	private String theone;

	public String getTheone() {
		return theone;
	}

	public void setTheone(String theone) {
		this.theone = theone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "name : " + this.getName() + ", age : " + this.getAge()
				+ ", balance : " + this.getBalance() + ", theone : "
				+ this.getTheone();
	}

}
