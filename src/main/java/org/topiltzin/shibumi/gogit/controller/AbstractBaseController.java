package org.topiltzin.shibumi.gogit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractBaseController {

	/*
	 * We will add all the common or standard methods in a Controller eg. 1. Get
	 * the logger object for each Controller class 2. Access the session object
	 */

	protected Logger logger = Logger.getLogger(getClass());

	@Autowired
	private HttpServletRequest request;

	// Standard access to request
	protected HttpServletRequest getRequest() {
		return request;
	}

	// Standard access to session
	protected HttpSession getSession() {
		HttpServletRequest request = getRequest();
		if (request != null) {
			return request.getSession();
		}
		return null;
	}

}