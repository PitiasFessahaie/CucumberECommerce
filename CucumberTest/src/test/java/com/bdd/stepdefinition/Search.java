package com.bdd.stepdefinition;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.bdd.helper.Driver;
import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Search {
	public static WebDriver driver = null;

	@Given("^I open a browser$")
	public void iOpenABrowser() throws Throwable {
		driver = Driver.startDriver();
	}

	@When("^I navigate to www\\.google\\.com$")
	public void iNavigateToWwwGoogleCom() throws Throwable {
		driver.get("https://www.google.com/");
		
	}

	@When("^I search Soccer ball$")
	public void iSearchSoccerBall() throws Throwable {
		driver.findElement(By.name("q")).sendKeys("ball");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

	}

	@Then("^I expect to see the ball result$")
	public void iExpectToSeeTheBallResult() throws Throwable {
		System.out.println(driver.getTitle());
		assertEquals(driver.getTitle(), "ball - Google Search");

	}
	@When("^I search \"([^\"]*)\" in the Search$")
	public void iSearchInTheSearch(String items) throws Throwable {
	    driver.findElement(By.name("q")).sendKeys(items);
	    
	}

	@When("^I submit the search button$")
	public void iSubmitTheSearchButton() throws Throwable {
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}

	@Then("^I expect search results \"([^\"]*)\"$")
	public void iExpectSearchResults(String expect) throws Throwable {
	    assertEquals(driver.getTitle(),expect);
	}

	@cucumber.api.java.After
	public void endTest(Scenario scenario){
		if (scenario.isFailed()) {
			String tempName = scenario.getName().replaceAll(" ", "_");
			String testName = tempName+".png";
			String imagePath = "target/screenshot/";
			File file = new File(imagePath);
			if(!file.exists()) {
				file.mkdir();
			}
			String imageAbsolutePath = file.getAbsolutePath();
			try {
				File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);				
				Files.copy(src, new File(imageAbsolutePath+"/"+testName));
				System.out.println("Generating A ScreenShots.....");
				System.out.println(imageAbsolutePath+"/"+testName);
					
				
				// --- Adding screenshot directly to the cucumber report
				//byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				//scenario.embed(screenshot, "image/png");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		if(driver != null){
			driver.close();
			System.out.println("closing browser..");
		}

	}

}
