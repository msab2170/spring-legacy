package com.recsee.report.exception;

public class FileFormatException extends Exception{

	public FileFormatException() {
		super("업로드 가능한 파일형식이 아닙니다.(.dbfile)");

	}
}
