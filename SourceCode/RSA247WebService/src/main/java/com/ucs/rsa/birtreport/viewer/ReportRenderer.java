/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.birtreport.viewer;

import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.birt.report.engine.api.EXCELRenderOption;
import org.eclipse.birt.report.engine.api.EngineConstants;
import org.eclipse.birt.report.engine.api.HTMLRenderOption;
import org.eclipse.birt.report.engine.api.HTMLServerImageHandler;
import org.eclipse.birt.report.engine.api.IGetParameterDefinitionTask;
import org.eclipse.birt.report.engine.api.IPDFRenderOption;
import org.eclipse.birt.report.engine.api.IParameterDefnBase;
import org.eclipse.birt.report.engine.api.IRenderOption;
import org.eclipse.birt.report.engine.api.IRenderTask;
import org.eclipse.birt.report.engine.api.IReportDocument;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunTask;
import org.eclipse.birt.report.engine.api.IScalarParameterDefn;
import org.eclipse.birt.report.engine.api.PDFRenderOption;
import org.eclipse.birt.report.engine.api.RenderOption;
import org.eclipse.birt.report.engine.api.ReportParameterConverter;


// TODO: Auto-generated Javadoc
/**
 * The Class ReportRenderer.
 */
public class ReportRenderer
{

	/** The Constant PARAM_ISNULL. */
	public static final String PARAM_ISNULL = "__isnull";

	/** The Constant UTF_8_ENCODE. */
	public static final String UTF_8_ENCODE = "UTF-8";

	/** The birt engine. */
	private IReportEngine birtEngine;

	/** The report name request parameter. */
	private String reportNameRequestParameter = "ReportName";

	/** The report format request parameter. */
	private String reportFormatRequestParameter = "ReportFormat";

	/** The render options. */
	private IRenderOption renderOptions;

	/**
	 * Sets the render options.
	 *
	 * @param ro
	 *           the new render options
	 */
	public void setRenderOptions(IRenderOption ro)
	{
		this.renderOptions = ro;
	}

	/**
	 * Process report design doc and render report.
	 *
	 * @param request
	 *           the request
	 * @param response
	 *           the response
	 */
	protected void processReportDesignDocAndRenderReport(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			String reportName = request.getParameter(this.reportNameRequestParameter);
			String format = request.getParameter(this.reportFormatRequestParameter);

			String pageNumber = request.getParameter("pageNumber");
			int currentPageNumber = 0;
			if (pageNumber != null && !pageNumber.equals(""))
			{
				currentPageNumber = Integer.valueOf(pageNumber);

			}

			String downloadFileName = reportName;

			String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath();

			ServletContext sc = request.getSession().getServletContext();
			if (format == null)
			{
				format = "html";
			}


			IReportRunnable runnable = null;

			runnable = birtEngine.openReportDesign(sc.getRealPath("/WEB-INF/reportdesigens") + "/" + reportName);

			IRunTask iRunTask = birtEngine.createRunTask(runnable);

			iRunTask.getAppContext().put(EngineConstants.APPCONTEXT_BIRT_VIEWER_HTTPSERVET_REQUEST, request);

			iRunTask.setParameterValues(discoverAndSetParameters(runnable, request));

			iRunTask.run(sc.getRealPath("/WEB-INF/reportdesigens") + "/temp.rptdocument");
			iRunTask.close();

			IReportDocument reportDoc = birtEngine
					.openReportDocument(sc.getRealPath("/WEB-INF/reportdesigens") + "/temp.rptdocument");
			IRenderTask iRenderTask = birtEngine.createRenderTask(reportDoc);

			response.setContentType(birtEngine.getMIMEType(format));
			IRenderOption options = null == this.renderOptions ? new RenderOption() : this.renderOptions;

			if (format.equalsIgnoreCase("html"))
			{

				HTMLRenderOption htmlOptions = new HTMLRenderOption(options);
				htmlOptions.setOutputFormat("html");
				htmlOptions.setOutputStream(response.getOutputStream());
				htmlOptions.setImageHandler(new HTMLServerImageHandler());
				htmlOptions.setHtmlPagination(true);
				htmlOptions.setBaseImageURL(baseUrl + "/images");
				htmlOptions.setImageDirectory(sc.getRealPath("/images"));
				htmlOptions.setSupportedImageFormats("PNG");
				htmlOptions.setEmbeddable(true);


				iRenderTask.setRenderOption(htmlOptions);

			}
			else if (format.equalsIgnoreCase("pdf"))
			{

				PDFRenderOption pdfOptions = new PDFRenderOption(options);
				pdfOptions.setSupportedImageFormats("PNG;GIF;JPG;BMP");

				pdfOptions.setOutputFormat("pdf");
				pdfOptions.setImageHandler(new HTMLServerImageHandler());
				pdfOptions.setBaseURL(baseUrl);
				//pdfOptions.setOutputFileName("my.pdf");
				pdfOptions.setOption(IPDFRenderOption.PAGE_OVERFLOW, IPDFRenderOption.FIT_TO_PAGE_SIZE);
				response.setHeader("Content-Disposition", "attachment; filename=" + downloadFileName + "." + format);
				pdfOptions.setOutputStream(response.getOutputStream());

				iRenderTask.setRenderOption(pdfOptions);
			}
			else if (format.equalsIgnoreCase("xls"))
			{

				EXCELRenderOption xlsOptions = new EXCELRenderOption(options);
				xlsOptions.setOutputFormat("xls");
				response.setHeader("Content-Disposition", "attachment; filename=" + downloadFileName + "." + format);
				xlsOptions.setImageHandler(new HTMLServerImageHandler());
				xlsOptions.setOutputStream(response.getOutputStream());
				//xlsOptions.setOption(IRenderOption.EMITTER_ID, "org.uguess.birt.report.engine.emitter.xls");
				xlsOptions.setOption(IRenderOption.EMITTER_ID, "org.eclipse.birt.report.engine.emitter.prototype.excel");
				iRenderTask.setRenderOption(xlsOptions);

			}
			else
			{

				response.setHeader("Content-Disposition", "attachment; filename=\"" + downloadFileName + "." + format + "\"");
				options.setOutputStream(response.getOutputStream());
				options.setOutputFormat(format);
				iRenderTask.setRenderOption(options);

			}

			long pageCount = iRenderTask.getTotalPage();
			if (currentPageNumber != 0)
			{
				if (pageCount >= currentPageNumber)
				{
					iRenderTask.setPageNumber(currentPageNumber);
				}
			}

			request.getSession().setAttribute("pageCount", pageCount);

			iRenderTask.render();
			iRenderTask.close();
			reportDoc.close();

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Discover and set parameters.
	 *
	 * @param report
	 *           the report
	 * @param request
	 *           the request
	 * @return the hash map
	 * @throws Exception
	 *            the exception
	 */
	protected HashMap discoverAndSetParameters(IReportRunnable report, HttpServletRequest request) throws Exception
	{

		HashMap<String, Object> parms = new HashMap<String, Object>();
		IGetParameterDefinitionTask task = birtEngine.createGetParameterDefinitionTask(report);

		@SuppressWarnings("unchecked")
		Collection<IParameterDefnBase> params = task.getParameterDefns(true);
		Iterator<IParameterDefnBase> iter = params.iterator();
		while (iter.hasNext())
		{
			IParameterDefnBase param = (IParameterDefnBase) iter.next();

			IScalarParameterDefn scalar = (IScalarParameterDefn) param;
			if (request.getParameter(param.getName()) != null && !request.getParameter(param.getName()).trim().equals(""))
			{
				parms.put(param.getName(), getParamValueObject(request, scalar));
			}
		}
		task.close();
		return parms;
	}

	/**
	 * Gets the param value object.
	 *
	 * @param request
	 *           the request
	 * @param parameterObj
	 *           the parameter obj
	 * @return the param value object
	 * @throws Exception
	 *            the exception
	 */
	protected Object getParamValueObject(HttpServletRequest request, IScalarParameterDefn parameterObj) throws Exception
	{
		String paramName = parameterObj.getName();
		String format = parameterObj.getDisplayFormat();
		if (doesReportParameterExist(request, paramName))
		{
			ReportParameterConverter converter = new ReportParameterConverter(format, request.getLocale());
			// Get value from http request
			String paramValue = getReportParameter(request, paramName, null);
			return converter.parse(paramValue, parameterObj.getDataType());
		}
		return null;
	}

	/**
	 * Gets the report parameter.
	 *
	 * @param request
	 *           the request
	 * @param name
	 *           the name
	 * @param defaultValue
	 *           the default value
	 * @return the report parameter
	 */
	public static String getReportParameter(HttpServletRequest request, String name, String defaultValue)
	{
		assert request != null && name != null;

		String value = getParameter(request, name);
		if (value == null || value.length() <= 0) // Treat
		// it as blank value.
		{
			value = ""; //$NON-NLS-1$
		}

		Map paramMap = request.getParameterMap();
		if (paramMap == null || !paramMap.containsKey(name))
		{
			value = defaultValue;
		}

		Set nullParams = getParameterValues(request, PARAM_ISNULL);

		if (nullParams != null && nullParams.contains(name))
		{
			value = null;
		}

		return value;
	}

	/**
	 * Does report parameter exist.
	 *
	 * @param request
	 *           the request
	 * @param name
	 *           the name
	 * @return true, if successful
	 */
	public static boolean doesReportParameterExist(HttpServletRequest request, String name)
	{
		assert request != null && name != null;

		boolean isExist = false;

		Map paramMap = request.getParameterMap();
		if (paramMap != null)
		{
			isExist = (paramMap.containsKey(name));
		}
		Set nullParams = getParameterValues(request, PARAM_ISNULL);
		if (nullParams != null && nullParams.contains(name))
		{
			isExist = true;
		}

		return isExist;
	}

	/**
	 * Gets the parameter.
	 *
	 * @param request
	 *           the request
	 * @param parameterName
	 *           the parameter name
	 * @return the parameter
	 */
	public static String getParameter(HttpServletRequest request, String parameterName)
	{

		if (request.getCharacterEncoding() == null)
		{
			try
			{
				request.setCharacterEncoding(UTF_8_ENCODE);
			}
			catch (UnsupportedEncodingException e)
			{
			}
		}
		return request.getParameter(parameterName);
	}

	/**
	 * Gets the parameter values.
	 *
	 * @param request
	 *           the request
	 * @param parameterName
	 *           the parameter name
	 * @return the parameter values
	 */
	public static Set getParameterValues(HttpServletRequest request, String parameterName)
	{
		Set<String> parameterValues = null;
		String[] parameterValuesArray = request.getParameterValues(parameterName);

		if (parameterValuesArray != null)
		{
			parameterValues = new LinkedHashSet<String>();

			for (int i = 0; i < parameterValuesArray.length; i++)
			{
				parameterValues.add(parameterValuesArray[i]);
			}
		}

		return parameterValues;
	}

	/**
	 * Sets the birt engine.
	 *
	 * @param birtEngine
	 *           the new birt engine
	 */
	public void setBirtEngine(IReportEngine birtEngine)
	{
		this.birtEngine = birtEngine;
	}


}
