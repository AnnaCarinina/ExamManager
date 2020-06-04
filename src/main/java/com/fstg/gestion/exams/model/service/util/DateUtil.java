package com.fstg.gestion.exams.model.service.util;

import java.sql.Timestamp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtil {

		public static boolean debloquer(Date date) {
			Date currentDate = new Date();
			long diff =  currentDate.getTime()- date.getTime();
            Long diffMinutes = diff/(60*1000)%60;
			
            return diffMinutes > 15? true: false;
			}
		
		public static Date parse(String dateAsString) {
			LocalDateTime localDateTime = LocalDateTime.parse(dateAsString);
			Timestamp timestamp = Timestamp.valueOf(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
			Date date = new Date(timestamp.getTime());
			return date;
		}
	

}
