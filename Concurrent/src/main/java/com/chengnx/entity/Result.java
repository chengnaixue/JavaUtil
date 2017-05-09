package com.chengnx.entity;

/**
 * 选手某一次跑步的成绩
 * @author chengnaixue
 *
 */
public class Result {
	
	/**
	 * 本次赛跑的用时
	 */
	private float time;

	public Result(float presentTime) {
		this.time = presentTime;
	}

	public float getTime() {
		return time;
	}

	public void setTime(float time) {
		this.time = time;
	}

}
