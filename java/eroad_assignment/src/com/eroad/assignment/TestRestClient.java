package com.eroad.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import java.util.List;
import com.eroad.assignment.CSVReader;
import com.eroad.assignment.JsonReader;

public class TestRestClient {
	private static final String BASE_GET_URL = "http://api.geonames.org/timezoneJSON?lat=";

	public static String getDataFromGeoNames (String webserviceURL) {
		DefaultHttpClient httpClient = null;
		String output = null;

		try {
			httpClient = new DefaultHttpClient ();
			HttpGet getRequest = new HttpGet (webserviceURL);
			getRequest.addHeader ("accept", "application/json");

			HttpResponse response = httpClient.execute (getRequest);

			if (response.getStatusLine ().getStatusCode () != 200) {
				throw new RuntimeException ("Failed : HTTP error code : "
				+ response.getStatusLine ().getStatusCode ());
			}

			try (BufferedReader br = new BufferedReader (new InputStreamReader (response.getEntity ().getContent ()))) {
				while ((output = br.readLine()) != null) {
					System.out.println(output);
				}
			} catch (IOException e) {
				e.printStackTrace ();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (httpClient != null) {
				httpClient.getConnectionManager ().shutdown ();
			}
		}

		return output;
	}

	public static void main(String[] args) {
		if (args.length < 1) {
			System.err.println ("Need to pass input CSV file");
			System.exit (1);
		}

		final String csvFile = args [0];
		List<CSVReader> csvReaderList = new CSVReader ().readFromCSV (csvFile);

		for (CSVReader csv : csvReaderList) {
			String webURL = BASE_GET_URL + csv.getLatitude ()
										+ "&lng=" + csv.getLongitude ()
										+ "&username=demo";

			String jsonString = getDataFromGeoNames (webURL);
			String output = csv.getDateTimeUTC () + ", " +
							csv.getLatitude () + ", " +
							csv.getLongitude () + ", " +
							JsonReader.parseAndSendDataFromJSON (jsonString);

			System.out.println (output);
		}
	}
}