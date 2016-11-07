/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.birtreport.viewer;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

import org.eclipse.birt.core.format.DateFormatter;
import org.eclipse.birt.core.format.NumberFormatter;
import org.eclipse.birt.core.format.StringFormatter;
import org.eclipse.birt.report.engine.api.IScalarParameterDefn;

import com.ibm.icu.util.TimeZone;
import com.ibm.icu.util.ULocale;


// TODO: Auto-generated Javadoc
/**
 * The Class ReportParameterConverter.
 */
public class ReportParameterConverter
{

	/** The format. */
	private String format = null;
	
	/** The u locale. */
	private ULocale uLocale = null;
	
	/** The time zone. */
	private TimeZone timeZone = TimeZone.getDefault();

	/** The string formatter. */
	private StringFormatter stringFormatter = null;
	
	/** The date formatter. */
	private DateFormatter dateFormatter = null;
	
	/** The number formatter. */
	private NumberFormatter numberFormatter = null;

	/**
	 * Instantiates a new report parameter converter.
	 *
	 * @param format the format
	 * @param locale the locale
	 */
	public ReportParameterConverter(String format, Locale locale)
	{
		this(format, ULocale.forLocale(locale));
	}

	/**
	 * Instantiates a new report parameter converter.
	 *
	 * @param format the format
	 * @param uLocale the u locale
	 */
	public ReportParameterConverter(String format, ULocale uLocale)
	{
		this(format, uLocale, null);
	}

	/**
	 * Instantiates a new report parameter converter.
	 *
	 * @param format the format
	 * @param uLocale the u locale
	 * @param timeZone the time zone
	 */
	public ReportParameterConverter(String format, ULocale uLocale, TimeZone timeZone)
	{
		this.format = format;
		this.uLocale = uLocale;
		if (timeZone != null)
		{
			this.timeZone = timeZone;
		}
	}

	/**
	 * Gets the string formatter.
	 *
	 * @return the string formatter
	 */
	private StringFormatter getStringFormatter()
	{
		if (stringFormatter == null && uLocale != null)
		{
			stringFormatter = new StringFormatter(uLocale);
			if (format != null)
			{
				stringFormatter.applyPattern(format);
			}
		}
		return stringFormatter;
	}

	/**
	 * Gets the number formatter.
	 *
	 * @return the number formatter
	 */
	private NumberFormatter getNumberFormatter()
	{
		if (numberFormatter == null && uLocale != null)
		{
			numberFormatter = new NumberFormatter(uLocale);
			if (format != null)
			{
				numberFormatter.applyPattern(format);
			}
		}
		return numberFormatter;
	}

	/**
	 * Gets the date formatter.
	 *
	 * @return the date formatter
	 */
	private DateFormatter getDateFormatter()
	{
		if (dateFormatter == null && uLocale != null)
		{
			dateFormatter = new DateFormatter(uLocale, timeZone);
			if (format != null)
			{
				dateFormatter.applyPattern(format);
			}
		}
		return dateFormatter;
	}


	/**
	 * Format.
	 *
	 * @param reportParameterObj the report parameter obj
	 * @return the string
	 */
	public String format(Object reportParameterObj)
	{
		String reportParameterValue = null;

		if (reportParameterObj != null && uLocale != null)
		{
			if (reportParameterObj instanceof String)
			{
				StringFormatter stringFormatter = getStringFormatter();
				if (stringFormatter != null)
				{
					reportParameterValue = stringFormatter.format((String) reportParameterObj);
				}
				else
				{
					reportParameterValue = reportParameterObj.toString();
				}
			}
			else if (reportParameterObj instanceof Date)
			{
				DateFormatter dateFormatter = getDateFormatter();
				if (dateFormatter != null)
				{
					reportParameterValue = dateFormatter.format((Date) reportParameterObj);
				}
				else
				{
					reportParameterValue = reportParameterObj.toString();
				}
			}
			else if (reportParameterObj instanceof Double)
			{
				NumberFormatter numberFormatter = getNumberFormatter();
				if (numberFormatter != null)
				{
					reportParameterValue = numberFormatter.format(((Double) reportParameterObj).doubleValue());
				}
				else
				{
					reportParameterValue = reportParameterObj.toString();
				}
			}
			else if (reportParameterObj instanceof BigDecimal)
			{
				NumberFormatter numberFormatter = getNumberFormatter();
				if (numberFormatter != null)
				{
					reportParameterValue = numberFormatter.format((BigDecimal) reportParameterObj);
				}
				else
				{
					reportParameterValue = reportParameterObj.toString();
				}
			}
			else if (reportParameterObj instanceof Boolean)
			{
				reportParameterValue = ((Boolean) reportParameterObj).toString();
			}
			else if (reportParameterObj instanceof Number)
			{
				NumberFormatter numberFormatter = getNumberFormatter();
				if (numberFormatter != null)
				{
					reportParameterValue = numberFormatter.format(((Number) reportParameterObj));
				}
				else
				{
					reportParameterValue = reportParameterObj.toString();
				}
			}
			else
			{
				reportParameterValue = (reportParameterObj.toString());
			}
		}

		return reportParameterValue;
	}

	/**
	 * Parses the.
	 *
	 * @param reportParameterValue the report parameter value
	 * @param parameterValueType the parameter value type
	 * @return the object
	 */
	public Object parse(String reportParameterValue, int parameterValueType)
	{
		Object parameterValueObj = null;

		if (reportParameterValue != null && uLocale != null)
		{
			switch (parameterValueType)
			{
				case IScalarParameterDefn.TYPE_STRING:
				{
					StringFormatter stringFormatter = getStringFormatter();
					if (stringFormatter == null)
					{
						parameterValueObj = null;
						break;
					}

					try
					{
						parameterValueObj = stringFormatter.parser(reportParameterValue);
					}
					catch (ParseException e)
					{
						parameterValueObj = reportParameterValue;
					}
					break;
				}

				case IScalarParameterDefn.TYPE_DATE_TIME:
				{
					parameterValueObj = parseDateTime(reportParameterValue);
					break;
				}

				case IScalarParameterDefn.TYPE_FLOAT:
				{
					NumberFormatter numberFormatter = getNumberFormatter();
					if (numberFormatter == null)
					{
						parameterValueObj = null;
						break;
					}

					try
					{
						Number num = numberFormatter.parse(reportParameterValue);

						if (num != null)
						{
							parameterValueObj = new Double(num.toString());
						}
					}
					catch (ParseException e)
					{
						numberFormatter.applyPattern("General Number");

						try
						{
							Number num = numberFormatter.parse(reportParameterValue);

							if (num != null)
							{
								parameterValueObj = new Double(num.toString());
							}
						}
						catch (ParseException ex)
						{
							parameterValueObj = null;
						}
					}

					break;
				}

				case IScalarParameterDefn.TYPE_DECIMAL:
				{
					NumberFormatter numberFormatter = getNumberFormatter();
					if (numberFormatter == null)
					{
						parameterValueObj = null;
						break;
					}

					try
					{
						Number num = numberFormatter.parse(reportParameterValue);

						if (num != null)
						{
							parameterValueObj = new BigDecimal(num.toString());
						}
					}
					catch (ParseException e)
					{
						numberFormatter.applyPattern("General Number");

						try
						{
							Number num = numberFormatter.parse(reportParameterValue);

							if (num != null)
							{
								parameterValueObj = new BigDecimal(num.toString());
							}
						}
						catch (ParseException ex)
						{
							parameterValueObj = null;
						}
					}

					break;
				}

				case IScalarParameterDefn.TYPE_BOOLEAN:
				{
					parameterValueObj = Boolean.valueOf(reportParameterValue);
					break;
				}

				case IScalarParameterDefn.TYPE_DATE:
				{
					try
					{
						parameterValueObj = java.sql.Date.valueOf(reportParameterValue);
					}
					catch (IllegalArgumentException ie)
					{
						parameterValueObj = parseDateTime(reportParameterValue);
						if (parameterValueObj != null)
						{
							parameterValueObj = new java.sql.Date(((Date) parameterValueObj).getTime());
						}
					}
					break;
				}

				case IScalarParameterDefn.TYPE_TIME:
				{
					try
					{
						parameterValueObj = java.sql.Time.valueOf(reportParameterValue);
					}
					catch (IllegalArgumentException ie)
					{
						parameterValueObj = parseDateTime(reportParameterValue);
						if (parameterValueObj != null)
						{
							parameterValueObj = new java.sql.Time(((Date) parameterValueObj).getTime());
						}
					}
					break;
				}

				case IScalarParameterDefn.TYPE_INTEGER:
				{
					NumberFormatter numberFormatter = getNumberFormatter();
					if (numberFormatter == null)
					{
						parameterValueObj = null;
						break;
					}

					try
					{
						Number num = numberFormatter.parse(reportParameterValue);

						if (num != null)
						{
							parameterValueObj = Integer.valueOf(num.intValue());
						}
					}
					catch (ParseException ex)
					{
						numberFormatter.applyPattern("General Number");

						try
						{
							Number num = numberFormatter.parse(reportParameterValue);

							if (num != null)
							{
								parameterValueObj = Integer.valueOf(num.intValue());
							}
						}
						catch (ParseException pex)
						{
							try
							{
								parameterValueObj = Integer.valueOf(reportParameterValue);
							}
							catch (NumberFormatException nfe)
							{
								parameterValueObj = null;
							}
						}
					}
				}
			}
		}

		return parameterValueObj;
	}

	/**
	 * Parses the date time.
	 *
	 * @param reportParameterValue the report parameter value
	 * @return the object
	 */
	protected Object parseDateTime(String reportParameterValue)
	{
		DateFormatter dateFormatter = getDateFormatter();
		if (dateFormatter == null)
		{
			return null;
		}

		try
		{
			return dateFormatter.parse(reportParameterValue);
		}
		catch (ParseException e)
		{
			dateFormatter = new DateFormatter("Short Date", uLocale);
			try
			{
				return dateFormatter.parse(reportParameterValue);
			}
			catch (ParseException ex)
			{
				dateFormatter = new DateFormatter("Medium Time", uLocale);
				try
				{
					return dateFormatter.parse(reportParameterValue);
				}
				catch (ParseException exx)
				{
					return null;
				}
			}
		}
	}

}
