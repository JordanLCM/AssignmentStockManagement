package simplilearn.assignmentTestNG.container;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PagesDataForStockManagementAndJenkins extends BaseContainer {

	public PagesDataForStockManagementAndJenkins(WebDriver Driver) {
		PageFactory.initElements(Driver, this);
	}

	public static String URL = "https://shopee.sg/";

	@FindBy(tagName = "input")
	public WebElement SearchBar;
	@FindBy(xpath = "//button[@type='button']")
	public WebElement SearchButton;
	@FindBy(xpath = "//body/div[@id='main']/div/div/div/div/div/div[2]/div[2]/div[1]/div[1]/label[1]/div[1]/i[1]")
	public WebElement Category;
	@FindBy(xpath = "//body//div[@id='main']//div//div//div[3]//div[2]//div[1]//div[1]//label[1]//div[1]//i[1]")
	public WebElement ShippedFrom;
	@FindBy(xpath = "//div[8]//div[2]//div[1]//div[1]//label[1]//div[1]//i[1]")
	public WebElement ShopeeMall;

	public void InputDataToSearch() throws InterruptedException {
		Actions Act = new Actions(Driver);
		Act.moveByOffset(30, 30).click().build().perform();
		Thread.sleep(1000);
		SearchBar.clear();
		SearchBar.click();
		SearchBar.sendKeys("cups");
		Thread.sleep(1000);
		SearchButton.click();
		Thread.sleep(1000);
		Category.click();
		Thread.sleep(1000);
		ShippedFrom.click();
		Thread.sleep(1000);
		ShopeeMall.click();
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		
	}

	public void ScrollDown() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) Driver;
		js.executeScript("window.scrollBy(0,1000)", "");
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(1000,2000)", "");
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(2000,3000)", "");
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(3000,-4000)", "");
		Thread.sleep(1000);
	}

	@FindBy(xpath = "//div[@class='row shopee-search-item-result__items']")
	public WebElement ListOfItems;

	public void ListOfItemsInPage() throws InterruptedException {
		int Num = 1;
		List<WebElement> Rows = ListOfItems.findElements(By.className("_2x8wqR"));
		for (WebElement RowElement : Rows) {
			System.out.println("------------------------------");
			System.out.println(Num++ + " - " + RowElement.getText());
		}
		System.out.println("------------------------------");
	}

	public void ChooseProduct(String ProductName) throws InterruptedException {
		WebElement ProductToClick = Driver.findElement(By.xpath("//div[contains(text(),'" + ProductName + "')]"));
		System.out.println(ProductToClick.getText());
		ProductToClick.click();
		Thread.sleep(2000);
	}
	
	@FindBy(css = "body > div:nth-child(2) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1)")
	public WebElement AmountSold;
	@FindBy(css = "body > div:nth-child(2) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2)")
	public WebElement StockLeft;
	
	public void CheckStockAvailable() {
		String AmtSold = AmountSold.getText();
		System.out.println("Product sold : " + AmtSold);
		System.out.println("------------------------------");
		String SL = StockLeft.getText();
		System.out.println("Product available : " + SL);
	}
	
	public void TakeScreenShot01(String FileName) {
		File ScreenShot01 = ((TakesScreenshot) Driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(ScreenShot01,
					new File("C:/Users/Jordan Liu/eclipse-workspace/qc-maven-project001/Screenshots/" + FileName +""));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
