package org.topiltzin.shibumi.gogit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.topiltzin.shibumi.gogit.interviews.giphy.dto.SearchTerm;
import org.topiltzin.shibumi.gogit.interviews.giphy.exception.GiphyException;
import org.topiltzin.shibumi.gogit.interviews.giphy.service.GiphyService;

@Controller
@RequestMapping("/interviews/giphy")
@Scope("prototype")
public class GiphyController extends AbstractBaseController {

	@Autowired
	private GiphyService giphyService;

	@ModelAttribute("searchTerm")
	public SearchTerm getSearchTerm() {
		return new SearchTerm();
	}

	@RequestMapping("")
	public String show(Model model) {

		return "interviews/giphy/show";
	}

	@RequestMapping("search")
	public String search(SearchTerm searchTerm, Model model)
			throws GiphyException {

		if (logger.isDebugEnabled()) {
			logger.debug("search");
		}

		String gifUrl = giphyService.getGif(searchTerm);
		model.addAttribute("gifUrl", gifUrl);

		return "interviews/giphy/result";
	}

}
