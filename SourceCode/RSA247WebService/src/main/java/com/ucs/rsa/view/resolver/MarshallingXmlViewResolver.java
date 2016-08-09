package com.ucs.rsa.view.resolver;



import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Marshaller;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.xml.MarshallingView;

public class MarshallingXmlViewResolver implements ViewResolver {

	private Marshaller marshaller;

	@Autowired
	public MarshallingXmlViewResolver(Marshaller marshaller) {
		this.marshaller = marshaller;
	}

	/**
	 * Get the view to use.
	 * 
	 * 
	 */
	@Override
	public View resolveViewName(String viewName, Locale locale)
			throws Exception {
		MarshallingView view = new MarshallingView();
		view.setMarshaller(marshaller);
		return view;
	}
}