import org.junit.Before;
import org.openqa.selenium.Keys;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

public class SMCApproval_Insert {
	private WebDriver driver;
	
	@Before
	public void abrirNavegador() {
		System.setProperty("webdriver.chrome.driver", "C:\\Arquivos de Programas\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}
		
	@Test
	public void testeNavegador() {	

		driver.get("https://lakeone.stategrid.com.br/portal/home");
			
		WebElement inputEmail = driver.findElement(By.id("username"));
		WebElement inputSenha = driver.findElement(By.id("password"));
		WebElement botaoLogin = driver.findElement(By.id("submitLogin"));
		
		inputEmail.sendKeys("rafael.lavinas@stategrid.com.br");
		inputSenha.sendKeys("Sgbh2@20");
		botaoLogin.click();
		
		int i;
		
		String[][] aDados = {
					{"Teste de SMC Approval","SGBH112122","ADM","Ramon Haddad"},
					{"Teste de SMC Approval","SGBH112122","ADM","Wang Yusheng"},
					{"Teste de SMC Approval","SGBH112122","ADM","Sun Tao"},
					{"Teste de SMC Approval","SGBH112122","ADM","Chang Zhongjiao"},
					};		

		for (i = 0; i < aDados.length; i++) {
			
			driver.get("https://lakeone.stategrid.com.br/portal/p/1/pageworkflowview?processID=SMC%20Approval");
	
			try {
				
			    WebElement tabAttach = driver.findElement(By.id("tab-attachments"));
			    tabAttach.click();
			    
			    List<WebElement> butButtons = driver.findElements(By.className("btn-default"));
			    butButtons.get(1).click();
			    
			    Thread.sleep(3000);
			    
			    List<WebElement> pathRFA = driver.findElements(By.className("findDocument-description"));
			    pathRFA.get(0).click();
			    
			    Thread.sleep(3000);
			    
			    WebElement docEmail = driver.findElement(By.id("jqg_ecm-finddocument-table_999597"));
			    docEmail.click();
			    
			    WebElement docRFA = driver.findElement(By.id("jqg_ecm-finddocument-table_999598"));
			    docRFA.click();
			    
			    WebElement butSelAt = driver.findElement(By.id("panel-button-wcmid7-0"));
			    butSelAt.click();
			    			
				driver.switchTo().frame("workflowView-cardViewer");
				
				WebElement txtSubject = driver.findElement(By.name("txtSubject"));
				WebElement txtSCMCode = driver.findElement(By.name("txtSCMCode"));
				WebElement txtDepto = driver.findElement(By.name("txtDepto"));
				WebElement txtVP = driver.findElement(By.name("txtVP"));
				txtSubject.sendKeys(aDados[i][0]);
				txtSCMCode.sendKeys(aDados[i][1]);
				txtDepto.sendKeys(aDados[i][2]);
				txtVP.sendKeys(aDados[i][3]);
				
				List<WebElement> txtReqsUsers = driver.findElements(By.className("select2-search__field"));
				txtReqsUsers.get(0).click();
			    new Actions(driver).sendKeys("Accounting Validation").perform();
			    Thread.sleep(1000);
			    List<WebElement> oReqs = driver.findElements(By.tagName("strong"));
			    oReqs.get(1).click();
			    
			    txtReqsUsers.get(1).click();
			    new Actions(driver).sendKeys("Accounting Validation").perform();
			    Thread.sleep(1000);
			    List<WebElement> oUsers = driver.findElements(By.tagName("strong"));
			    oUsers.get(1).click();
			    
			    WebElement txtTipos = driver.findElement(By.name("txtTipos"));
			    txtTipos.sendKeys("Others (Outros)");
			    
			    WebElement txtJustification = driver.findElement(By.name("txtJustification"));
			    txtJustification.sendKeys("Teste do SMC Vote");
			    
			    WebElement butEnviar = driver.findElement(By.id("butEnviar"));
			    butEnviar.click();
			    
			    Thread.sleep(10000);
			    driver.switchTo().defaultContent();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
