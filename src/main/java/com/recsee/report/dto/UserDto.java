package com.recsee.report.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {
	private String id;
	private String pwd;
	private String name;
	private String level;
	private String desc;
	private String expressDate;
	
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", pwd=" + pwd + ", name=" + name + ", level=" + level + ", desc=" + desc
				+ ", expressDate=" + expressDate + "]";
	}
	
	
}
