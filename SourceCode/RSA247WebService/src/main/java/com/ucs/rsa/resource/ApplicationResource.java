/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.resource;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ucs.rsa.model.UserModel;


/**
 * The Class ApplicationResource.
 */
@Controller
@RequestMapping("/")
public class ApplicationResource
{

	/**
	 * home & loggedIn are used to remove logic from the jsp.
	 *
	 * @param model
	 *           the model
	 * @param locale
	 *           the locale
	 * @return the model and view (home.jsp)
	 */
	@RequestMapping(value = "/", method =
	{ RequestMethod.GET })
	public ModelAndView home(Model model, Locale locale)
	{
		if (getCurrentUser(model, locale) != null)
		{

			return new ModelAndView("logged_in");
		}
		return new ModelAndView("home");
	}

	/**
	 * Aboutus.
	 *
	 * @param model
	 *           the model
	 * @param locale
	 *           the locale
	 * @return the model and view
	 */
	@RequestMapping(value = "/aboutus", method =
	{ RequestMethod.GET })
	public ModelAndView aboutus(Model model, Locale locale)
	{
		return new ModelAndView("aboutus");
	}

	/**
	 * Contactus.
	 *
	 * @param model
	 *           the model
	 * @param locale
	 *           the locale
	 * @return the model and view
	 */
	@RequestMapping(value = "/contactus", method =
	{ RequestMethod.GET })
	public ModelAndView contactus(Model model, Locale locale)
	{
		return new ModelAndView("contactus");
	}

	/**
	 * Page not found.
	 *
	 * @param model
	 *           the model
	 * @param locale
	 *           the locale
	 * @return the model and view
	 */
	@RequestMapping(value = "/page_not_found", method =
	{ RequestMethod.GET })
	public ModelAndView pageNotFound(Model model, Locale locale)
	{
		return new ModelAndView("page_not_found");
	}

	/**
	 * Logged in.
	 *
	 * @param model
	 *           the model
	 * @param locale
	 *           the locale
	 * @return the model and view
	 */
	@RequestMapping(value = "logged_in", method =
	{ RequestMethod.GET })
	public ModelAndView loggedIn(Model model, Locale locale)
	{
		return new ModelAndView("logged_in");
	}

	/**
	 * Sign in.
	 *
	 * @param model
	 *           the model
	 * @param locale
	 *           the locale
	 * @return the model and view
	 */
	@RequestMapping(value = "login", method =
	{ RequestMethod.GET })
	public ModelAndView login(Model model, Locale locale)
	{
		return new ModelAndView("login");
	}

	/**
	 * Sign up.
	 *
	 * @param model
	 *           the model
	 * @param locale
	 *           the locale
	 * @return the model and view
	 */
	@RequestMapping(value = "sign_up", method =
	{ RequestMethod.GET })
	public ModelAndView signUp(Model model, Locale locale)
	{
		return new ModelAndView("sign_up");
	}

	/**
	 * Gets the current user.
	 *
	 * @param model
	 *           the model
	 * @param locale
	 *           the locale
	 * @return the current user if he's logged in, null otherwise
	 */
	public UserModel getCurrentUser(Model model, Locale locale)
	{

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (auth != null && UserModel.class.isAssignableFrom(auth.getPrincipal().getClass()))
		{

			return (UserModel) auth.getPrincipal();
		}

		return null;
	}

	/**
	 * Catch all the exceptions (exceptions and its subclasses).
	 *
	 * @param exception
	 *           the exception
	 * @param request
	 *           the request
	 * @return the view "exceptionHandler.jsp"
	 */
	@ExceptionHandler(Exception.class)
	protected ModelAndView exceptionHandler(Exception exception, HttpServletRequest request)
	{
		request.setAttribute("exception", exception);
		return new ModelAndView("exception_handled");
	}

	/**
	 * Throws an exception, used to check if the exception handler is working well.
	 *
	 * @param model
	 *           the model
	 * @param locale
	 *           the locale
	 * @return nothing, just throws an exception
	 */
	@RequestMapping(value = "exception")
	public String exceptionTest(Model model, Locale locale)
	{
		throw new NullPointerException();
	}

	@RequestMapping(value = "reports", method =
	{ RequestMethod.GET })
	public ModelAndView reports(Model model, Locale locale)
	{
		return new ModelAndView("newReports");
	}
}
