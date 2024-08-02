package dev.basicjava;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class J8FormattedDate {

	public static void main(String[] args) {
		// Get the current date
        LocalDate currentDate = LocalDate.now();
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Define the date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Format the current date
        String formattedDate = currentDate.format(formatter);
        String formattedDateTime = currentDateTime.format(formatterTime);

        // Output the formatted date
        System.out.println(formattedDate);
     // Output the formatted date
        System.out.println(formattedDateTime);
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
