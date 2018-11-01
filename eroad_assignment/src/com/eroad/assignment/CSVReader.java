package com.eroad.assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class CSVReader {
    private static final String CSV_DELIMITER = ",";
	private String dateTimeUTC;
	private String latitude;
	private String longitude;

	public CSVReader () {}

	/**
	* Setter for dateTimeUTC
	*
	* @param String - dateTime
	*/
	public void setDateTimeUTC (String dateTime) {
		this.dateTimeUTC = dateTime;
	}

	public String getDateTimeUTC () {
		return this.dateTimeUTC;
	}

	/**
	* Setter for latitude
	*
	* @param String - latitude
	*/
	public void setLatitude (String latitude) {
		this.latitude = latitude;
	}

	public String getLatitude () {
		return this.latitude;
	}

	/**
	* Setter for longitude
	*
	* @param String - longitude
	*/
	public void setLongitude (String longitude) {
		this.longitude = longitude;
	}

	public String getLongitude () {
		return this.longitude;
	}

	public List<CSVReader> readFromCSV (String csvFileName) {
		List<CSVReader> csvReaderList = new ArrayList<> ();

        String line = "";

        try (BufferedReader br = new BufferedReader(new FileReader (csvFileName))) {
            while ((line = br.readLine ()) != null) {
				CSVReader tmpCsvReader = new CSVReader ();
                String[] inputData = line.split (CSV_DELIMITER);
                tmpCsvReader.setDateTimeUTC (inputData[0]);
                tmpCsvReader.setLatitude (inputData[1]);
                tmpCsvReader.setLongitude (inputData[2]);

                csvReaderList.add (tmpCsvReader);
            }
        } catch (IOException e) {
            e.printStackTrace ();
        }

        return csvReaderList;
	}

    public static void main (String[] args) {
		if (args.length < 1) {
			System.err.println ("Need to pass input CSV file");
			System.exit (1);
		}

        final String csvFile = args [0];

        List<CSVReader> csvReaderList = new CSVReader ().readFromCSV (csvFile);

        for (CSVReader csv : csvReaderList) {
			System.out.println ("UTC: " + csv.getDateTimeUTC ());
			System.out.println ("Lat: " + csv.getLatitude ());
			System.out.println ("Long: " + csv.getLongitude ());
		}
    }
}