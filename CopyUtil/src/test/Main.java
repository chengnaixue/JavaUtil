package test;

import util.CopyUtil;
import entity.Person;
import entity.Student;

public class Main {
	
	public static void main(String[] args){
		Person per = new Person();
		per.setName("mac");
		per.setAge(15);
		per.setBalance(123.67);
		per.setOther("hello");
		
		Student stu = CopyUtil.copyObject(per, Student.class);
		System.out.println(stu.toString());
		
	}

}
