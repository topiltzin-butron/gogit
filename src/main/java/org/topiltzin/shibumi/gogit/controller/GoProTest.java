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

public class GoProTest {

	public static void main(String[] args) throws Exception {
		GoProTest goProTest = new GoProTest();
		
		String startCapture = "http://10.5.5.9:80/bacpac/SH?t=goprotopy&p=%01";
		String stopCapture = "http://10.5.5.9:80/bacpac/SH?t=goprotopy&p=%00";
		String turnOn = "http://10.5.5.9:80/bacpac/PW?t=goprotopy&p=%01";
		String turnOff = "http://10.5.5.9:80/bacpac/PW?t=goprotopy&p=%00";
		
		String command = stopCapture;
		goProTest.executeCommand(command);
	}

	public void executeCommand(String command) throws Exception {

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
