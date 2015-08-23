package org.topiltzin.shibumi.gogit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController extends AbstractBaseController {

	@RequestMapping("/")
	public String index() {

		if (logger.isDebugEnabled()) {
			logger.debug("index");
		}

		return "index";
	}

}
