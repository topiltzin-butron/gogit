package org.topiltzin.shibumi.gogit.interviews.giphy.service.impl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.topiltzin.shibumi.gogit.interviews.giphy.dto.SearchTerm;
import org.topiltzin.shibumi.gogit.interviews.giphy.exception.GiphyException;
import org.topiltzin.shibumi.gogit.interviews.giphy.service.GiphyService;
import org.topiltzin.shibumi.gogit.service.AbstractBaseService;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GiphyServicePojoImpl extends AbstractBaseService implements
		GiphyService {

	@Override
	public String getGif(final SearchTerm searchTerm) throws GiphyException {
		if (logger.isDebugEnabled()) {
			logger.debug("searchTerm: " + searchTerm);
		}

		String term = searchTerm.getTerm();
		try {
			term = URLEncoder.encode(term, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new GiphyException("Cannot encode term.", e);
		}

		String apiUrl = API_URL.replace(KEYWORD, term);

		URL url = null;
		URLConnection urlConnection = null;
		InputStreamReader inputStreamReader = null;
		ObjectMapper mapper = new ObjectMapper();
		String gifURL = null;

		try {
			url = new URL(apiUrl);
			urlConnection = url.openConnection();

			if (urlConnection != null) {
				inputStreamReader = new InputStreamReader(
						urlConnection.getInputStream());

				JsonNode root = mapper.readTree(inputStreamReader);

				List<JsonNode> data = root.findValues("data");

				if (data != null && !data.isEmpty()) {
					JsonNode dataContent = data.get(0);
					JsonNode images = dataContent.get(0).get("images");
					JsonNode image = images.get("downsized");
					gifURL = image.path("url").asText();
				}
			}

		} catch (MalformedURLException e) {
			throw new GiphyException("URL malformed: " + apiUrl, e);
		} catch (IOException e) {
			throw new GiphyException("Cannot open connection", e);
		} finally {
			if (inputStreamReader != null) {
				try {
					inputStreamReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return gifURL;
	}

}
