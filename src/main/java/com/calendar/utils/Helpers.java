package com.calendar.utils;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

import com.calendar.service.bean.TimeBean;

public class Helpers {

	// Gérer mois en français
	public String gererMois(int month) {
		String currentMonth = null;

		switch (month) {
		case 1:
			currentMonth = "janvier";
			break;

		case 2:
			currentMonth = "février";
			break;

		case 3:
			currentMonth = "mars";
			break;

		case 4:
			currentMonth = "avril";
			break;

		case 5:
			currentMonth = "mai";
			break;

		case 6:
			currentMonth = "juin";
			break;

		case 7:
			currentMonth = "juillet";
			break;

		case 8:
			currentMonth = "aout";
			break;

		case 9:
			currentMonth = "septembre";
			break;

		case 10:
			currentMonth = "octobre";
			break;

		case 11:
			currentMonth = "novembre";
			break;

		case 12:
			currentMonth = "décembre";
			break;

		default:
			break;
		}

		return currentMonth;
	}

	// avoir le dernier jour d'un mois
	public int getLastDayOfMonth(LocalDate date) {
		LocalDate lastDayOfMonth = null;
		YearMonth yearMonth = YearMonth.of(date.getYear(), date.getMonthValue());
		lastDayOfMonth = yearMonth.atEndOfMonth();
		return lastDayOfMonth.getDayOfMonth();
	}

	// boucle pour avoir la date
	public List<String> iterationDate(TimeBean timeBean) {
		List<String> listDate = new ArrayList<>();
		if (timeBean.getLastDayOfMonth() == timeBean.getNumberDay()) {
			for (int i = 1; i <= timeBean.getNumberDay(); i++) {
				String dateOfMonth;

				dateOfMonth = convertionNumberOnString(String.valueOf(i)) + "/" + timeBean.getStrMonth() + "/"
						+ timeBean.getYear();
				listDate.add(dateOfMonth);
			}
		} else {
			for (int i = timeBean.getDay(); i <= timeBean.getLastDayOfMonth(); i++) {
				String dateOfMonth;

				dateOfMonth = convertionNumberOnString(String.valueOf(i)) + "/" + timeBean.getStrMonth() + "/"
						+ timeBean.getYear();
				listDate.add(dateOfMonth);
			}
		}
		return listDate;
	}

	// itération d'une date jusqu'à une date donnée
	public List<String> iterationDateFromOneDateToAnotherDate(TimeBean timeBean1, TimeBean timeBean2) {
		List<String> listDate = new ArrayList<>();
		for (int i = timeBean1.getDay(); i <= timeBean1.getLastDayOfMonth(); i++) {
			String dateOfMonth;

			dateOfMonth = convertionNumberOnString(String.valueOf(i)) + "/" + timeBean1.getStrMonth() + "/"
					+ timeBean1.getYear();
			listDate.add(dateOfMonth);
		}
		for (int i = 1; i <= timeBean2.getDay(); i++) {
			String dateOfMonth;

			dateOfMonth = convertionNumberOnString(String.valueOf(i)) + "/" + timeBean2.getStrMonth() + "/"
					+ timeBean2.getYear();
			listDate.add(dateOfMonth);
		}

		return listDate;
	}

	// convertion de la date type entier en String
	public String convertionNumberOnString(String value) {

		if (value.length() == 1)
			value = "0" + value;
		else
			value = "" + value;

		return value;
	}

	// avoir le nombre de jour si le calendrier ne commence pas du premier mois
	public int getNumberDaysOfMonth(LocalDate date) {
		int numberDay = 0;
		numberDay = getLastDayOfMonth(date) - date.getDayOfMonth();

		return numberDay;
	}

	// Extraction de la date sous forme jj/mm/yyyy
	public List<String> extractDate(TimeBean time) {
		// TimeBean time = new TimeBean();

		// time.setMonth(date.getDayOfMonth());
		// time.setNumberDay(getLastDayOfMonth(date));
		// time.setYear(date.getYear());
		// time.setStrMonth(convertionNumberOnString(String.valueOf(date.getMonthValue())));

		// la méthode itération extraire en type date

		return iterationDate(time);
	}

	// Liste des jours entre deux dates
	public List getDateBetweenToDate(LocalDate date1, LocalDate date2) {
		TimeBean time1 = getValueOfDate(date1);
		TimeBean time2 = getValueOfDate(date2);

		List<String> listeDate = new ArrayList<>();

		// listeDate.addAll(extractDate(time1));
		// listeDate.addAll(extractDate(time2));
		listeDate.addAll(iterationDateFromOneDateToAnotherDate(time1, time2));

		return listeDate;
	}

	public TimeBean getValueOfDate(LocalDate date) {
		TimeBean time = new TimeBean();
		time.setNumberDay(getNumberDaysOfMonth(date));
		time.setDay(date.getDayOfMonth());
		time.setLastDayOfMonth(getLastDayOfMonth(date));
		time.setStrMonth(convertionNumberOnString(String.valueOf(date.getMonthValue())));
		time.setMonth(date.getMonthValue());
		time.setYear(date.getYear());
		time.setStrDay(convertionNumberOnString(String.valueOf(date.getDayOfMonth())));
		return time;
	}
}
