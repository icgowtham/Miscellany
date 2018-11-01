import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import java.util.List;

public class TestRestClient {
	private static final String GET_URL = "http://api.geonames.org/timezoneJSON?lat=-44.490947&lng=171.220966&username=demo";

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
				while ((output = br.readLine ()) != null) {
					System.out.println (output);
				}
			} catch (IOException e) {
				e.printStackTrace ();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace ();
		} catch (IOException e) {
			e.printStackTrace ();
		} finally {
			if (httpClient != null) {
				httpClient.getConnectionManager ().shutdown ();
			}
		}

		return output;
	}

	public static void main (String[] args) {
		final String latitude = "-33.912167";
		final String longitude = "151.215820";
		String webURL = "http://api.geonames.org/timezoneJSON?lat=" + latitude
						+ "&lng=" + longitude
						+ "&username=demo";

		String output = getDataFromGeoNames (webURL);
		System.out.println (output);
	}
}