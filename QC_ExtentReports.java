package qc.utils;

import com.relevantcodes.extentreports.ExtentReports;

public class QC_ExtentReports {

	public static ExtentReports TestReports;

	public static ExtentReports CreateReport(String FileName) {
		TestReports = new ExtentReports(
				"C:/Users/Jordan Liu/eclipse-workspace/qc-maven-project001/QC-TestReports/"+FileName+".html");
		return TestReports;
	}
}
