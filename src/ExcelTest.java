import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExcelTest {
	
	
	
public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "E:\\SeleniumWorkspace\\popupExample\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); // chrome luanch
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/spthakre/Desktop/Offline%20Website/Offline%20Website/index.html");
		
		
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		
		driver.findElement(By.id("password")).sendKeys("123456");
		
		driver.findElement(By.xpath("//*[@id='form']/div[3]/div/button")).click();
		
		driver.findElement(By.xpath("/html/body/div[1]/aside/section/ul/li[3]/a")).click();		
		
		
		 //Get all rows
	    List<WebElement> rows = driver.findElements(By.tagName("tr"));
	   // assertEquals(3, rows.size());
	    
	    //Print data from each row
	    for (WebElement row : rows) {
	        List<WebElement> cols = row.findElements(By.tagName("td"));
	        for (WebElement col : cols) {
	            System.out.print(col.getText() + "\t");
	        }
	        System.out.println();
	    }
	
	
	
	
}


}
