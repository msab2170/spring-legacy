package com.recsee.report.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ReadFailLine {
	private int lineNum;
	private String lineContent;
}
