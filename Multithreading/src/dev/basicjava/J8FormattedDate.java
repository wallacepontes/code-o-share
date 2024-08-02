package dev.basicjava;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class J8FormattedDate {

	public static void main(String[] args) {
		// Get the current date
        LocalDate currentDate = LocalDate.now();

        // Define the date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Format the current date
        String formattedDate = currentDate.format(formatter);

        // Output the formatted date
        System.out.println(formattedDate);
        
        //
        beforeJ8();

	}
	
	private static void beforeJ8() {
		// Get the current date
        Date currentDate = new Date();

        // Define the date format
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        // Format the current date
        String formattedDate = formatter.format(currentDate);

        // Output the formatted date
        System.out.println(formattedDate);
	}

}
