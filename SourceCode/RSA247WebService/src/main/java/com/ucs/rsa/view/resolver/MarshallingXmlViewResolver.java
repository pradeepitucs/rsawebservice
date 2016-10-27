/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.view.resolver;



import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Marshaller;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.xml.MarshallingView;


/**
 * The Class MarshallingXmlViewResolver.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
public class MarshallingXmlViewResolver implements ViewResolver
{

	/** The marshaller. */
	private Marshaller marshaller;

	/**
	 * Instantiates a new marshalling xml view resolver.
	 *
	 * @param marshaller
	 *           the marshaller
	 */
	@Autowired
	public MarshallingXmlViewResolver(Marshaller marshaller)
	{
		this.marshaller = marshaller;
	}

	/**
	 * Get the view to use.
	 *
	 * @param viewName
	 *           the view name
	 * @param locale
	 *           the locale
	 * @return the view
	 * @throws Exception
	 *            the exception
	 */
	@Override
	public View resolveViewName(String viewName, Locale locale) throws Exception
	{
		MarshallingView view = new MarshallingView();
		view.setMarshaller(marshaller);
		return view;
	}
}
