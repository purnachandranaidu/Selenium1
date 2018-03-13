package riico;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class riicoplots {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		driver.get("http://164.100.222.97/mapserver2015/fusion/riicoweb/dashboard.php?d=1282");
		driver.findElement(By.id("username")).sendKeys("riico");
		driver.findElement(By.id("pwd")).sendKeys("RIIC0");
		driver.findElement(By.name("login")).click();
		driver.switchTo().frame("TaskPane_IFRAME");
		try
		{
			Thread.sleep(5000);
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		driver.findElement(By.xpath("html/body/div[2]/div[1]/label[18]")).click();
		int size = driver.findElements(By.xpath(".//*[@id='plotdelReport']/tbody/tr")).size();
		for(int i=1; i<=size; i++) {
			WebElement descEle = driver.findElement(By.xpath(".//*[@id='plotdelReport']/tbody/tr[" + i + "]/td[6]"));
			String desc = descEle.getText();
			System.out.println(desc);
			WebElement statusEle = driver.findElement(By.xpath(".//*[@id='plotdelReport']/tbody/tr[" + i + "]/td[8]/select"));
			Select select = new Select(statusEle);
			String selection = select.getFirstSelectedOption().getText();
			if("plot".equalsIgnoreCase(desc) && "select".equalsIgnoreCase(selection)) {
				select.selectByIndex(8);
				break;
/*			} else if("open".equalsIgnoreCase(desc) && "select".equalsIgnoreCase(selection)) {
				select.selectByIndex(8);
				break;*/
			}
		}
		
//		List<WebElement> elements = driver.findElements(By.xpath(".//*[@id='plotdelReport']/tbody"));
//		for(WebElement element : elements) {
/*			Select select = new Select(element);
			String selection = select.getFirstSelectedOption().getText();
			if("select".equalsIgnoreCase(selection)) {
				select.selectByIndex(8);				
				break;
			}*/
//			System.out.println(element.getText());
//		}
/*		WebElement iacat = driver.findElement(By.id("pcs_C10-626"));
		Select se1 = new Select(iacat);
		se1.selectByIndex(8);
		String selection = se1.getFirstSelectedOption().getText();
		System.out.println(selection);*/
	}

}
