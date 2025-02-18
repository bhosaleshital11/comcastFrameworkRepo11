package com.ClientName.AppName.GenericUtility.JavaUtility;



import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	//For Random Number
public int getRandomNum()
{
	Random random=new Random();
	int randomNo = random.nextInt(5000);
	return randomNo;
}
//To get System Date
public String getSystemDateYYYYDDMM() {
	 Date date = new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-DD");
	String sysdate=sdf.format(date);
	return sysdate;
}
// to get next --Days pass the parameter
public String getRequiredDateYYYYDDMM(int Days)
{
	SimpleDateFormat sim=new SimpleDateFormat("YYYY-DD-MM");
	Calendar cal=sim.getCalendar();
	cal.add(Calendar.DAY_OF_MONTH, Days);
	String reqDate=sim.format(cal.getTime());
	return reqDate;
}
}

