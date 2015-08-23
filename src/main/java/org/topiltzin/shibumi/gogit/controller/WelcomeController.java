package org.topiltzin.shibumi.gogit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController extends AbstractBaseController {

	@RequestMapping("/home")
	public String home(Model model) {

		if (logger.isDebugEnabled()) {
			logger.debug("home");
		}

		model.addAttribute("message", "Welcome Topiltzin!");
		return "home";
	}

}
