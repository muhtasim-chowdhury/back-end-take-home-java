package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	private final AtomicLong counter = new AtomicLong();
	/* the state will be stored here in memory via map
	If you want to keep it stored even while this server is offline or shuts down,
	you can save it with a SQL database. The columns would be the id, body, status,
	detail, createdTimeStamp and ModifiedTimeStamp where each row in the SQL table 
	is information for a request  */
	private static Map<Long, Request> map = new HashMap<>();

	@PostMapping("/request")
	public String request(@RequestBody Request request) {
		String body = request.getBody();
		long id = counter.incrementAndGet();
		map.put(id, request);
		// stubbed out request
		fakeRequest("http://example.com/request", String.format("{" + 
		"\"body\":\"%s\","
		+ "\"callback\":\"/callback/%d\""
		+"}", body, id));
		return body;
	}
	@PostMapping("/callback/{id}")
	public ResponseEntity<String> started(@PathVariable(value = "id") Long id, @RequestBody String body) {
		Request request = map.get(id);
		request.setStatus(body);
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}

	public void fakeRequest(String url, String body) {}
}