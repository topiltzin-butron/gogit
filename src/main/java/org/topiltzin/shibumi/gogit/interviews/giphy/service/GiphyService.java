package org.topiltzin.shibumi.gogit.interviews.giphy.service;

import org.topiltzin.shibumi.gogit.interviews.giphy.dto.SearchTerm;
import org.topiltzin.shibumi.gogit.interviews.giphy.exception.GiphyException;

public interface GiphyService {

	String API_URL = "http://api.giphy.com/v1/gifs/search?q=KEYWORD&api_key=dc6zaTOxFJmzC&limit=1&offset=0";

	String KEYWORD = "KEYWORD";

	String getGif(final SearchTerm searchTerm) throws GiphyException;

}
