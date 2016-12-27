/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.birtreport.factory;

import java.io.File;

import org.eclipse.birt.core.exception.BirtException;
import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportEngineFactory;



/**
 * A factory for creating BirtEngine objects.
 */
public class BirtEngineFactory
{

	/**
	 * Checks if is singleton.
	 *
	 * @return true, if is singleton
	 */
	public boolean isSingleton()
	{
		return true;
	}

	/** The birt engine. */
	private IReportEngine birtEngine;

	/** The resolved directory. */
	File _resolvedDirectory;

	/** The log level. */
	private java.util.logging.Level logLevel;

	/** The birt engine factory. */
	private static BirtEngineFactory birtEngineFactory;


	/**
	 * Instantiates a new birt engine factory.
	 */
	private BirtEngineFactory()
	{

	}

	/**
	 * Gets the birt engine factory.
	 *
	 * @return the birt engine factory
	 */
	public static BirtEngineFactory getBirtEngineFactory()
	{
		if (birtEngineFactory == null)
		{
			birtEngineFactory = new BirtEngineFactory();
		}
		return birtEngineFactory;
	}

	/**
	 * Destroy.
	 */
	public void destroy()
	{

		try
		{

			birtEngine.destroy();
			Platform.shutdown();
			System.out.println("Engine successfully destroyed and platform is shutdown!!");

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Sets the log level.
	 *
	 * @param ll
	 *           the new log level
	 */
	public void setLogLevel(java.util.logging.Level ll)
	{
		this.logLevel = ll;
	}

	/**
	 * Sets the log directory.
	 *
	 * @param f
	 *           the new log directory
	 */
	public void setLogDirectory(java.io.File f)
	{

		if (!f.exists())
		{
			f.mkdirs();
		}
		this._resolvedDirectory = f;
	}

	/**
	 * Gets the engine.
	 *
	 * @return the engine
	 */
	public IReportEngine getEngine()
	{

		if (birtEngine != null)
		{

		}

		EngineConfig config = getEngineConfig();

		try
		{
			Platform.startup(config);
		}
		catch (BirtException e)
		{
			e.printStackTrace();
		}

		IReportEngineFactory factory = (IReportEngineFactory) Platform
				.createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY);
		IReportEngine be = factory.createReportEngine(config);
		this.birtEngine = be;

		return be;
	}

	/**
	 * Gets the engine config.
	 *
	 * @return the engine config
	 */
	public EngineConfig getEngineConfig()
	{
		EngineConfig config = new EngineConfig();
		return config;
	}


	/**
	 * Gets the object type.
	 *
	 * @return the object type
	 */
	public Class<?> getObjectType()
	{
		return IReportEngine.class;
	}


}
