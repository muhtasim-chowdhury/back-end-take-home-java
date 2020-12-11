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
	public String getStatus() {
		return this.status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDetail() {
		return this.detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public LocalDateTime getCreatedTimeStamp() {
		return this.createdTimeStamp;
	}
	public LocalDateTime getModifiedTimeStamp() {
		return this.modifiedTimeStamp;
	}
	public void setModifiedTimeStamp(LocalDateTime mTS) {
		this.modifiedTimeStamp = mTS;
	}
	public String toString() {
		return "Body: " + body + "\nStatus: " + status + "\nDetail: " + detail + "\nCTS: " + createdTimeStamp + "\nMTS: " + modifiedTimeStamp;
	}
}