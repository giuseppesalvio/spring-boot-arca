package com.arca.microservices.forex.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@RestController
public
class SessionController
{
	@GetMapping("/session/set")
	public
	void sessionSet(HttpSession session)
	{
		session.setAttribute("my-field", LocalDateTime.now());
	}

	@GetMapping("/session/get")
	public
	Object sessionGet(HttpSession session)
	{
		return session.getAttribute("my-field");
	}
}
