package Tables;
import org.openqa.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dynamictable {
     static WebDriver driver;
     
	public static void main(String[] args) {
		
		WebDriverManager .chromedriver ().setup();
		
		driver=new ChromeDriver ();
		
		driver.get("https://demo.guru99.com/test/web-table-element.php");
		
		WebElement Webtable =driver.findElement(By.xpath("//table[@class ='dataTable']//tbody"));
		
		List<WebElement> rows = Webtable.findElements(By.tagName("tr"));
		
		int rowsCount = rows.size();
		
		 driver.switchTo().frame("ccpa-consent-notice");
		 driver.switchTo().defaultContent();

		
		for(int i=0; i<rowsCount; i++) {
			
			List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
			
			int columnsCount = columns.size();
			
		for(int j =0;j<columnsCount; j++) {
			
			String cellText = columns.get(j).getText();
			
			if(cellText.equals("Colgate Palm.")) {
					
				
				if(cellText != ("Colgate Palm.")) {
					
					System.out.println("Company not aviliaible in the List");
				}
					
				System.out.println("Group : "+columns.get(1).getText());
				
				System.out.println("Prev Close (Rs) : "+columns.get(2).getText());
				
				System.out.println("Current Price (Rs) : "+columns.get(3).getText());
				
				System.out.println("% Change) : "+columns.get(4).getText());
				
				
			}
		
		  }
			
		}	
	}

}
