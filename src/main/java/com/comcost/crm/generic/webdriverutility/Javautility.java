package com.comcost.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebDriver;

/*
 * JavaUtility class:
 * Provides common reusable Java helper methods like random numbers, system date, and required date.
 */

public class Javautility {

	WebDriver driver = null;
	
	/*
     * Generates a random integer up to the specified bound.
     */

	public int getRandomNumber() {

		Random random = new Random();
		int randomnumber = random.nextInt(1000);

		return randomnumber;
	}

	/*
     * Returns the current system date in default format.
     */
	public String getSystemDateYYYYDDMM() {

		Date dateobj = new Date();
		SimpleDateFormat saf = new SimpleDateFormat("yyyy-MM-dd");
		String date = saf.format(dateobj);
		return date;

	}

	
	 /*
     * Returns a required date by adding/subtracting specified number of days from current date.
     */
	public String getRequiredDateYYYYMMDD(int days) {

		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, days);

		String reqDate = sim.format(cal.getTime());
		return reqDate;

	}

}
