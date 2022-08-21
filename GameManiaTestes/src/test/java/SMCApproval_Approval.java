import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SMCApproval_Approval {
private WebDriver driver;
private WebDriver driver2;
	
	@Before
	public void abrirNavegador() {
		System.setProperty("webdriver.chrome.driver", "C:\\Arquivos de Programas\\chromedriver\\chromedriver.exe");
	}
		
	@Test
	public void testeNavegador() {
		
		int i;
		
		String[][] aDados = {
					{"wang.yusheng@stategrid.com.br","Sgbh2@20"},
					{"ramon.haddad@stategrid.com.br","Sgbh2@20"},
					{"sun.tao@stategrid.com.br","Sgbh2@20"},
					{"chang.zhongjiao@stategrid.com.br","Sgbh2@20"}
					};

		for (i = 0; i < aDados.length; i++) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://lakeone.stategrid.com.br/portal/p/1/smc-vote-list");
			
			WebElement inputEmail = driver.findElement(By.id("username"));
			WebElement inputSenha = driver.findElement(By.id("password"));
			WebElement botaoLogin = driver.findElement(By.id("submitLogin"));
			
			inputEmail.sendKeys(aDados[i][0]);
			inputSenha.sendKeys(aDados[i][1]);
			botaoLogin.click();
	
			try {
				
				//WebElement but01 = driver.findElement(By.id("btnTarg1"));
				
				//but01.click();
				
			    //List<WebElement> cLinks = driver.findElements(By.xpath("//a[@href='/portal/']"));
			    
			    List<WebElement> cLinks = driver.findElements(By.className("_alinks"));
		    
				driver2 = new ChromeDriver();
				driver2.manage().window().maximize();
			    for (int j = 0; j < cLinks.size(); j++) {
					driver2.get(cLinks.get(j).getAttribute("href"));
					if (j == 0) {
						WebElement inputEmail2 = driver2.findElement(By.id("username"));
						WebElement inputSenha2 = driver2.findElement(By.id("password"));
						WebElement botaoLogin2 = driver2.findElement(By.id("submitLogin"));
						
						inputEmail2.sendKeys(aDados[i][0]);
						inputSenha2.sendKeys(aDados[i][1]);
						botaoLogin2.click();
					}
			    	driver2.switchTo().frame("workflowView-cardViewer");
			    	WebElement btnMeeting = driver2.findElement(By.id("btnMeeting"));
			    	btnMeeting.click();
			    	
			    	WebElement btAprovaApproval = driver2.findElement(By.id("btAprovaApproval"));
			    	btAprovaApproval.click();
			    	
			    	Thread.sleep(10000);
			    }
			    driver2.close();
		    	driver.close();
			    
			    Thread.sleep(5000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
