package StepDefinition;


import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StepDefinitions {


        private final WebDriver driver = new ChromeDriver();

        @Given("I am on the Google search page")
        public void I_visit_google() {
            driver.get("https://www.google.com");
        }

        @When("I search for {string}")
        public void search_for(String query) {
            WebElement element = driver.findElement(By.name("q"));
            // Enter something to search for
            element.sendKeys(query);
            // Now submit the form. WebDriver will find the form for us from the element
            element.submit();
        }

        @Then("the page title should start with {string}")
        public void checkTitle(String titleStartsWith) {
            // Google's search is rendered dynamically with JavaScript
            // Wait for the page to load timeout after ten seconds
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver d) {
                    return d.getTitle().toLowerCase().startsWith(titleStartsWith);
                }
            });
        }

        @After()
        public void closeBrowser() {
            driver.quit();
        }
    }


