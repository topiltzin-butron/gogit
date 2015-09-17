package org.topiltzin.shibumi.gogit.controller;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("prototype")
@RequestMapping("/gopro")
public class GoProController extends AbstractBaseController {

	final String startCapture = "http://10.5.5.9:80/bacpac/SH?t=goprotopy&p=%01";
	final String stopCapture = "http://10.5.5.9:80/bacpac/SH?t=goprotopy&p=%00";
	final String turnOn = "http://10.5.5.9:80/bacpac/PW?t=goprotopy&p=%01";
	final String turnOff = "http://10.5.5.9:80/bacpac/PW?t=goprotopy&p=%00";

	
	@RequestMapping("turnOn")
	public String turnOn() throws Exception {
		executeCommand(turnOn);
		return "/gopro/show";
	}
	
	@RequestMapping("turnOff")
	public String turnOff() throws Exception {
		executeCommand(turnOff);
		return "/gopro/show";
	}
	
	@RequestMapping("startCapture")
	public String startCapture() throws Exception {
		executeCommand(startCapture);
		return "/gopro/show";
	}
	
	@RequestMapping("stopCapture")
	public String stopCapture() throws Exception {
		executeCommand(stopCapture);
		return "/gopro/show";
	}

	private void executeCommand(String command) throws Exception {

		HttpClient httpClient = new DefaultHttpClient();

		try {
			HttpGet httpGet = new HttpGet(command);
			System.out
					.println("Executing request: " + httpGet.getRequestLine());

			// Create a custom response handler
			ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

				@Override
				public String handleResponse(final HttpResponse response)
						throws ClientProtocolException, IOException {
					int status = response.getStatusLine().getStatusCode();
					if (status >= 200 && status < 300) {
						HttpEntity entity = response.getEntity();
						return entity != null ? EntityUtils.toString(entity)
								: null;
					} else {
						throw new ClientProtocolException(
								"Unexpected response status: " + status);
					}
				}

			};
			String responseBody = httpClient.execute(httpGet, responseHandler);
			System.out.println("----------------------------------------");
			System.out.println(responseBody);
		} finally {
			// httpClient.close();
		}

	}

}
