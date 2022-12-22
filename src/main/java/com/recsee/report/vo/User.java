package com.recsee.report.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class User {
	private String id;
	private String pwd;
	private String name;
	private String level;
	private String desc;
	private Timestamp regDate;
	
	public User(String[] arr) throws IllegalArgumentException{
		
		if(arr == null || arr.length < 6) {
			throw new IllegalArgumentException("배열이 6보다 적습니다.");
		}
		this.id = arr[0];
		this.pwd = arr[1];
		this.name = arr[2];
		this.level = arr[3];
		this.desc = arr[4];
		this.regDate = Timestamp.valueOf(arr[5]);
	}
}
