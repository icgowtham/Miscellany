import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

class InputDataBean {
	private String dateTimeUTC;
	private String latitude;
	private String longitude;

	public InputDataBean () {}

	public String getDateTimeUTC () {
		return this.dateTimeUTC;
	}

	public void setDateTimeUTC (String dateTimeUTC) {
		this.dateTimeUTC = dateTimeUTC;
	}

	public String getLatitude () {
		return this.latitude;
	}

	public void setLatitude (String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude () {
		return this.longitude;
	}

	public void setLongitude (String longitude) {
		this.longitude = longitude;
	}
}

public class CSVReader {
	private static final String CSV_DELIMITER = ",";

	public CSVReader () {}

	public List<InputDataBean> readFromCSV (String csvFileName) {
		List<InputDataBean> inputDataBeanList = new ArrayList<> ();
		String line = "";

		try (BufferedReader br = new BufferedReader(new FileReader (csvFileName))) {
			while ((line = br.readLine ()) != null) {
				InputDataBean tmpIdb = new InputDataBean ();
				String[] inputData = line.split (CSV_DELIMITER);
				tmpIdb.setDateTimeUTC (inputData[0]);
				tmpIdb.setLatitude (inputData[1]);
				tmpIdb.setLongitude (inputData[2]);

				inputDataBeanList.add (tmpIdb);
			}
		} catch (IOException e) {
			e.printStackTrace ();
		}

		return inputDataBeanList;
	}

	public static void main (String[] args) {
		final String csvFile = "input.csv";
		List<InputDataBean> inputDataBeanList = new CSVReader ().readFromCSV (csvFile);

		for (InputDataBean idb : inputDataBeanList) {
			System.out.println ("UTC: " + idb.getDateTimeUTC ());
			System.out.println ("Lat: " + idb.getLatitude ());
			System.out.println ("Long: " + idb.getLongitude ());
		}
	}
}
