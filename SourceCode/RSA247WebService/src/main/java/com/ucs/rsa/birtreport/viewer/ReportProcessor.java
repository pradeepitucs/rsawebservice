/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.birtreport.viewer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ucs.rsa.birtreport.factory.BirtEngineFactory;


// TODO: Auto-generated Javadoc
/**
 * The Class ReportProcessor.
 */
public class ReportProcessor
{

	/** The birt engine factory. */
	private BirtEngineFactory birtEngineFactory;

	/** The report renderer. */
	private ReportRenderer reportRenderer;

	/** The report processor. */
	private static ReportProcessor reportProcessor = null;

	/**
	 * Instantiates a new report processor.
	 */
	private ReportProcessor()
	{
	}

	/**
	 * Initilize birt engine.
	 *
	 * @return true, if successful
	 */
	public boolean initilizeBirtEngine()
	{
		boolean isInitialized = true;
		reportRenderer = new ReportRenderer();
		reportRenderer.setBirtEngine(this.getBitEngineFactory().getEngine());

		System.out.println("Bit Engine Successfully Started.");

		return isInitialized;
	}

	/**
	 * Gets the bit engine factory.
	 *
	 * @return the bit engine factory
	 */
	private BirtEngineFactory getBitEngineFactory()
	{
		birtEngineFactory = BirtEngineFactory.getBirtEngineFactory();
		return birtEngineFactory;
	}


	/**
	 * Shut down birt engine.
	 */
	public void shutDownBirtEngine()
	{
		birtEngineFactory.destroy();
	}

	/**
	 * Process report.
	 *
	 * @param request
	 *           the request
	 * @param response
	 *           the response
	 */
	public void processReport(HttpServletRequest request, HttpServletResponse response)
	{
		reportRenderer.processReportDesignDocAndRenderReport(request, response);
	}

	/**
	 * Gets the report processor.
	 *
	 * @return the report processor
	 */
	public static ReportProcessor getReportProcessor()
	{
		if (reportProcessor != null)
		{
			return reportProcessor;
		}
		reportProcessor = new ReportProcessor();
		return reportProcessor;
	}
}
