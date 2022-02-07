package simplilearn.assignmentTestNG;

import org.openqa.selenium.By;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import simplilearn.assignmentTestNG.container.BaseContainer;
import simplilearn.assignmentTestNG.container.PagesDataForStockManagementAndJenkins;

@Listeners(qc.utils.MyListeners.class)
public class stockManagementAndJenkins extends BaseContainer {
	PagesDataForStockManagementAndJenkins PagesDataForSM;

	@BeforeClass
	public void MultipleEnv() throws InterruptedException {
		Driver.get(PagesDataForSM.URL);
		Thread.sleep(2000);
	}

	public String ProductName001 = "Table Matters - Cereal Cup Collection";
	public String ScreenshotName = "Stock";
	
	@Test
	public void StockCheck() throws InterruptedException {
		PagesDataForSM = new PagesDataForStockManagementAndJenkins(Driver);
		PagesDataForSM.InputDataToSearch();
		PagesDataForSM.ScrollDown();
		PagesDataForSM.ListOfItemsInPage();
		PagesDataForSM.ChooseProduct(ProductName001);
		PagesDataForSM.CheckStockAvailable();
		PagesDataForSM.TakeScreenShot01(ScreenshotName);
		Thread.sleep(2000);
		Driver.quit();
	}
}
