package qc.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class MyListeners implements ITestListener {
	ExtentReports TestReports;
	ExtentTest Test;
	public String ReportName = "Test Report";
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("This is the start of " + result.getName());
		System.out.println("------------------------------------------------------------");
//		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println(context.getName() + " is started");
		System.out.println("------------------------------------------------------------");
		TestReports = QC_ExtentReports.CreateReport(ReportName);
		Test = TestReports.startTest(context.getName());
//		ITestListener.super.onStart(context);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName() + " test has succeeded, congratulations!");
		System.out.println("------------------------------------------------------------");
		Test.log(LogStatus.PASS, result.getName() + " has passed!", Test.addScreenCapture(
				"C:/Users/Jordan Liu/eclipse-workspace/qc-maven-project001/Screenshots/Stock"));
//		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
//		String ReportName = "Stock";
		System.out.println(result.getName() + " test has failed, please check again!");
		System.out.println("------------------------------------------------------------");
		Test.log(LogStatus.FAIL, result.getName() + " has failed!", Test.addScreenCapture(
				"C:/Users/Jordan Liu/eclipse-workspace/qc-maven-project001/Screenshots/Stock"));
//		ITestListener.super.onTestFailure(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getName() + " test has been skipped, please check why!");
		System.out.println("------------------------------------------------------------");
		Test.log(LogStatus.SKIP, result.getName() + " has skipped!");
//		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println(context.getName() + " has ended and is finished!");
		System.out.println("------------------------------------------------------------");
		System.out.println("TestReport has been GENERATED!");
		TestReports.endTest(Test);
		TestReports.flush();
//		ITestListener.super.onFinish(context);
	}
}
