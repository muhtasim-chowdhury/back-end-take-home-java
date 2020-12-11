package com.example.demo;

import java.time.LocalDateTime;

public class Request {
	private String body;
	private String status;
	private String detail;
	private final LocalDateTime createdTimeStamp = LocalDateTime.now();
	private LocalDateTime modifiedTimeStamp = LocalDateTime.now();

	public String getBody() {
		return body;
	}
}