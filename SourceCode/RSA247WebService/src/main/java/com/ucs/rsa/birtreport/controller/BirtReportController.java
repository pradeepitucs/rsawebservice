/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.birtreport.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ucs.rsa.birtreport.viewer.ReportProcessor;



/**
 * The Class BirtReportController.
 */
@Controller
@RequestMapping("/")
public class BirtReportController extends HttpServlet
{

	/** The processor. */
	private ReportProcessor processor;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.GenericServlet#init()
	 */
	@Override
	public void init()
	{
		processor = ReportProcessor.getReportProcessor();
		processor.initilizeBirtEngine();
		System.out.println("Engine Initilized!!");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("processing report complete");
		processor.processReport(request, response);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	@RequestMapping("/newReports")
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		init();
		doGet(request, response);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.GenericServlet#destroy()
	 */
	@Override
	public void destroy()
	{
		processor.shutDownBirtEngine();
	}

}
