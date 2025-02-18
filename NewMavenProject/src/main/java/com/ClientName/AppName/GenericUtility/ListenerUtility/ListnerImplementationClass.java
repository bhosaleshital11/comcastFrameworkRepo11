package com.ClientName.AppName.GenericUtility.ListenerUtility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import BaseClassUtility.BaseClassUtility;
import io.opentelemetry.sdk.trace.internal.ExtendedSpanProcessor;

public class ListnerImplementationClass implements ITestListener,ISuiteListener {
	public ExtentReports report;
	ExtentTest test;
	@Override
	
	public void onStart(ISuite suite) {
		System.out.println("Report Configuration");
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvancedReport/report.html");
		spark.config().setDocumentTitle("CRM Test suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		//add Env Information & create test
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS","Windows 11");
		report.setSystemInfo("Browser","Chrome - 100");
		
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report BackUp");
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+"========START============>");	
		 test=report.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO,result.getMethod().getMethodName()+"===>Started===>");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName());
		test.log(Status.PASS,result.getMethod().getMethodName()+"===>completed===>");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String testName = result.getMethod().getMethodName();
		String time= LocalDateTime.now().toString().replace(':', '-').replace(" ","_");
		TakesScreenshot edriver=(TakesScreenshot)BaseClassUtility.sdriver;
		   String filepath = edriver.getScreenshotAs(OutputType.BASE64);
		   
		 test.addScreenCaptureFromBase64String(filepath,"testName"+"_"+time);
		 test.log(Status.FAIL,result.getMethod().getMethodName()+"===>Failed===>");
		   
		  /* File dest=new File("./Screenshots/scrnshot"+testName+time+".png");
		   try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); */
		}

	

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getMethod().getMethodName());
	}

}
