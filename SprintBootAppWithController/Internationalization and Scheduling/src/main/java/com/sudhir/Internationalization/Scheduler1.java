package com.sudhir.Internationalization;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler1 {

	//@Scheduled(cron = "9 * 11 * * ?")  //fire the job at 11:09 and repeat after 1 min
	//@Scheduled(fixedRate = 1000)  //fire the job after application starts and repeat every sec
	@Scheduled(fixedDelay = 1000, initialDelay = 5000) //fire the job after 5 sec when application starts and repeat every sec
	public void cronJobSch() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
		Date now = new Date();
		String strDate = sdf.format(now);
		System.out.println("Java cron job expression"+strDate);
	}
	
}
