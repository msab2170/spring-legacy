package com.recsee.report.dto;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FileReadResult {
	
	private int successCount;
	
	private String data;
	
	private int failCount;
	
	private List<ReadFailLine> failList;
	
	public FileReadResult() {
		this.successCount = 0;
		this.failCount = 0;
		this.failList = new ArrayList<>();
	}
	
	public void readSuccess() {
		this.successCount++;
	}
	
	public void toJson() { 
		this.data = new Gson().toJson(failList); 
	}
	
	public void addFailLine(int lineNum, String lineContent) {
		this.failList.add(new ReadFailLine(lineNum, lineContent));
		this.failCount++;
	}
	
	@Override
	public String toString() {
		return "FileReadResult [successCount=" + successCount + ", failCount=" + failCount + ", failList=" + failList
				+ "]";
	}
	
	
}
