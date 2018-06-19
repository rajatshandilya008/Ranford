package table;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import TestBase.Base;

public class WebTable extends Base{
	
	static boolean status = false;
static WebDriver driver;
	public static void m1(String operation) {
		try {
			
			WebElement table = driver.findElement(getlocator("Branchtable"));

			List<WebElement> rows = table.findElements(getlocator("Branchrow"));
			for (WebElement rowDetails : rows) {
				rowDetails.getText();

			}

			String[] pagelinks = rows.get(rows.size() - 1).getText().split(" ");

			for (int l = 1; l < pagelinks.length; l++) {

				if (pagelinks[l].contains("...") && status == true) {
					driver.findElement(getlocator("...right")).click();
				} else {
					table.findElement(By.linkText(pagelinks[l])).click();
				}

				if (pagelinks[l].contains("...")) {
					status = true;
					m1(operation);
				}
				table = driver.findElement(getlocator("Branchtable"));
				//rows = table.findElements(By.tagName("tr"));
				List<WebElement> column = table.findElements(getlocator("Branchcolumn"));
				for (WebElement colDetails : column) {
					String text = colDetails.getText();

					if(text.contains("50"))
					{
						table.findElement(By.xpath("//*[@id=\"DG_bankdetails\"]/tbody/tr[4]/td[7]/a"));


					}}}}
		catch (Exception e) {

			e.printStackTrace();
		}
	}}
	
