package com.recsee.report.exception;

public class FileContentFormatException extends Exception {

	public FileContentFormatException() {
		super("읽을 내용이 없거나 읽을 수 없는 내용 형식입니다.");
	}
	
	
}
