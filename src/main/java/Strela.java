import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class Strela {
    public static void main(String[] args) {

        // Otići na http://www.strela.co.rs/, kliknuti na dugme Prodavnica u headeru, izabrati opciju Lukovi -
        // Bows iz leve navigacije, potom kliknuti na luk koji se zove Samick Sage, i onda proveriti da
        // ime tog luka na njegovoj stranici zaista sadrži reč Samick.

        System.setProperty("webdriver.chrome.driver", "D:\\Sandra\\kurs_qa\\hromdriver\\chromedriver_win32" +
                "\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        driver.navigate().to(" http://www.strela.co.rs/");
        WebElement shopBtn = driver.findElement(By.xpath("//*[@id=\"ctl00_RadMenu1\"]/ul/li[2]"));
        shopBtn.click();
        WebElement archBtn = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_GrupeRadTreeView\"]/ul/li[1]/div/span[3]"));
        archBtn.click();
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ctl00_MainContent_ListView1_ctrl35_Panel1\"]/figure/a/img")));
        WebElement sageBtn = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_ListView1_ctrl35_Panel1\"]/figure/a/img"));
        sageBtn.click();

        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_MainContent_ItemListView_ctrl0_ItemNazivLabel")));
        WebElement titleBtn= driver.findElement(By.id("ctl00_MainContent_ItemListView_ctrl0_ItemNazivLabel"));
        String checkingTitle = titleBtn.getText();

        if (checkingTitle.contains("Samick")) {
            System.out.println("Ime tog luka zaista sadrzi rec Samick");
        } else{
            System.out.println("Ime tog luka ne sadrzi rec Samick");

            }
        }

    }








