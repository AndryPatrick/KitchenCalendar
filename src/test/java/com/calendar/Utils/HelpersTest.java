package com.calendar.Utils;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.calendar.service.bean.TimeBean;
import com.calendar.utils.Helpers;

class HelpersTest {

	Helpers help = new Helpers();

	@Test
	void testGererMois() {

		assertEquals("janvier", help.gererMois(1));
		assertEquals("décembre", help.gererMois(12));
	}

	@Test
	void testGetLastDayOfMonth() {
		assertEquals(31, help.getLastDayOfMonth(LocalDate.parse("2021-03-12")));
	}

	@Test
	void testIterationDate() {

		List<String> list1 = Arrays.asList("01/03/2021", "02/03/2021", "03/03/2021", "04/03/2021", "05/03/2021",
				"06/03/2021", "07/03/2021", "08/03/2021", "09/03/2021", "10/03/2021", "11/03/2021", "12/03/2021",
				"13/03/2021", "14/03/2021", "15/03/2021", "16/03/2021", "17/03/2021", "18/03/2021", "19/03/2021",
				"20/03/2021", "21/03/2021", "22/03/2021", "23/03/2021", "24/03/2021", "25/03/2021", "26/03/2021",
				"27/03/2021", "28/03/2021", "29/03/2021", "30/03/2021", "31/03/2021");

		TimeBean timeBean1 = new TimeBean();
		timeBean1.setLastDayOfMonth(28);
		timeBean1.setNumberDay(timeBean1.getLastDayOfMonth());
		timeBean1.setStrDay("25");
		timeBean1.setStrMonth("02");
		timeBean1.setYear(2021);
		List<String> list = help.iterationDate(timeBean1);
		String val1 = list.get(0);
		String val2 = help.iterationDate(timeBean1).get(0);

		assertEquals(list.get(27), list.get(27));
		assertEquals(list.get(0), help.iterationDate(timeBean1).get(0));

	}

	@Test
	void testConvertionNumberOnString() {
		assertEquals("02", help.convertionNumberOnString("2"));
		assertEquals("09", help.convertionNumberOnString("9"));
		assertEquals("31", help.convertionNumberOnString("31"));
	}

	@Test
	void testGetNumberDaysOfMonth() {
		assertEquals(19, help.getNumberDaysOfMonth(LocalDate.parse("2021-03-12")));
		assertEquals(2, help.getNumberDaysOfMonth(LocalDate.parse("2021-03-29")));
	}

	@Test
	void testExtractDate() {
		List<String> list1 = Arrays.asList("01/02/2021", "02/02/2021", "03/02/2021", "04/02/2021", "05/02/2021",
				"06/02/2021", "07/02/2021", "08/02/2021", "09/02/2021", "10/02/2021", "11/02/2021", "12/02/2021",
				"13/02/2021", "14/02/2021", "15/02/2021", "16/02/2021", "17/02/2021", "18/02/2021", "19/02/2021",
				"20/02/2021", "21/02/2021", "22/02/2021", "23/02/2021", "24/02/2021", "25/02/2021", "26/02/2021",
				"27/02/2021", "28/02/2021");
		List<String> listIteration = new ArrayList<>();
		TimeBean timeBean1 = new TimeBean();
		timeBean1.setLastDayOfMonth(28);
		timeBean1.setNumberDay(timeBean1.getLastDayOfMonth());
		timeBean1.setStrDay("25");
		timeBean1.setStrMonth("02");
		timeBean1.setYear(2021);
		listIteration = help.extractDate(timeBean1);
		String val1 = list1.get(0);
		String val2 = listIteration.get(0);

		assertEquals(list1.get(0), listIteration.get(0));

	}

	@Test
	void testGetDateBetweenToDate() {
		List<String> listDate = Arrays.asList("01/02/2021", "02/02/2021", "03/02/2021", "04/02/2021", "05/02/2021",
				"06/02/2021", "07/02/2021", "08/02/2021", "09/02/2021", "10/02/2021", "11/02/2021", "12/02/2021",
				"13/02/2021", "14/02/2021", "15/02/2021", "16/02/2021", "17/02/2021", "18/02/2021", "19/02/2021",
				"20/02/2021", "21/02/2021", "22/02/2021", "23/02/2021", "24/02/2021", "25/02/2021", "26/02/2021",
				"27/02/2021", "28/02/2021");
		List<String> listDate2 = Arrays.asList("01/03/2021", "02/03/2021", "03/03/2021", "04/03/2021", "05/03/2021",
				"06/03/2021", "07/03/2021", "08/03/2021", "09/03/2021", "10/03/2021", "11/03/2021", "12/03/2021",
				"13/03/2021", "14/03/2021", "15/03/2021", "16/03/2021", "17/03/2021", "18/03/2021", "19/03/2021",
				"20/03/2021", "21/03/2021", "22/03/2021", "23/03/2021", "24/03/2021", "25/03/2021", "26/03/2021",
				"27/03/2021", "28/03/2021", "29/03/2021", "30/03/2021", "31/03/2021");
		List<String> listExtract = help.getDateBetweenToDate(LocalDate.parse("2021-02-20"),
				LocalDate.parse("2021-03-11"));
		List<String> listExtract1 = help.getDateBetweenToDate(LocalDate.parse("2021-02-24"),
				LocalDate.parse("2021-03-11"));

		String val1 = listDate.get(0);
		String val2 = listDate2.get(0);
		String val3 = listExtract.get(0);

		int val4 = listExtract.size();
		int val5 = listExtract1.size();

		String val6 = null;

		assertEquals(20, val4); // du 20 février au 11 mars
		assertEquals(16, val5); // du 24 février au 11 mars

	}

}
