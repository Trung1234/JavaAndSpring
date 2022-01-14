package com.trungnt.model;

/**
 * Created by My PC on 05/11/2017.
 */
public class Student {
	private String name;
	private int id, score;
	
	public Student(String name, int id, int score) {
		this.name = name;
		this.id = id;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
	
	public int getScore() {
		return score;
	}
	
	@Override
	public String toString() {
		return "id='" + id + '\'' +
				", ten=" + name +
				", diem=" + score
				;
	}
}
