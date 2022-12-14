import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteLogin {

	private WebDriver driver;
		
	@Before
	public void abrirNavegador() {
		System.setProperty("webdriver.chrome.driver", "C:\\Arquivos de Programas\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}
		
	@Test
	public void testeNavegador() {	

		driver.get("http://localhost:4200/login");
			
		WebElement inputEmail = driver.findElement(By.id("edtEmail"));
		WebElement inputSenha = driver.findElement(By.id("edtSenha"));
		WebElement botaoLogin = driver.findElement(By.id("butEnviar"));
				
		String[] listaSenhas = {"senha1", "senha2", "senha3", "carlos123"};
		for (int tentativa = 0; tentativa < listaSenhas.length; tentativa++) {
			try {
				inputEmail.clear();
				inputSenha.clear();
					
				inputEmail.sendKeys("carlos@email.com");
				inputSenha.sendKeys(listaSenhas[tentativa]);
				botaoLogin.click();
						
				Thread.sleep(3000);
						
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}	
}
