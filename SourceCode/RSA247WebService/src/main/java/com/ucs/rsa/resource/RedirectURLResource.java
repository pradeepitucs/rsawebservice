package com.ucs.rsa.resource;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/redirecturl")
public class RedirectURLResource extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@RequestMapping("/citruspayresponse")
	public void redirectURL(HttpServletRequest req, HttpServletResponse res) {
		System.out.println(" HttpServletRequest " + req + " HttpServletResponse " + res);
	}
}
