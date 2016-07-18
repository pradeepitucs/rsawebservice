package com.ucs.rsa.web.resolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.ucs.rsa.common.dto.ExceptionDTO;
import com.ucs.rsa.common.exception.RSAException;

public class RSAExceptionResolver implements HandlerExceptionResolver {

	private int order;

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public ModelAndView resolveException(final HttpServletRequest iRequest, final HttpServletResponse iResponse,
			final Object iHandler, final Exception iException) {
		iException.printStackTrace();
		final ExceptionDTO anExceptionDTO = new ExceptionDTO();
		if (iException instanceof RSAException) {

			anExceptionDTO.setErrorKey(((RSAException) iException).getError().getKey());
			anExceptionDTO.setErrorMessage(((RSAException) iException).getError().getMessage());

			// anExceptionDTO.setErrorKey(((UPCException)
			// iException).getErrorKey());
			// anExceptionDTO.setErrorMessage(((UPCException)
			// iException).getErrorMessage());
		} else {
			anExceptionDTO.setErrorMessage(iException.getMessage());
		}
		return new ModelAndView("plist", "error", anExceptionDTO);
	}
}
