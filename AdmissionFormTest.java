package com.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions; // Added for Headless mode
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Alert;
import java.time.Duration;

public class AdmissionFormTest {
    public static void main(String[] args) {
        
        // 1. Setup Chrome Options for Jenkins Compatibility
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); // Runs without a visible window
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        // 2. Initialize Driver with Options
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        try {
            // 3. Open the local HTML file 
            System.out.println("Starting Test: Opening Form...");
            driver.get("file:///C:/devops_CA2/index.html"); 
            driver.manage().window().maximize();

            // 4. Student Name
            WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("studentName")));
            nameField.sendKeys("Parth Parkhi");

            // 5. Email ID
            driver.findElement(By.id("emailId")).sendKeys("parth.test@example.edu");

            // 6. Mobile Number
            driver.findElement(By.id("mobileNumber")).sendKeys("9876543210");

            // 7. Department Dropdown
            Select deptDropdown = new Select(driver.findElement(By.id("department")));
            deptDropdown.selectByValue("CS");

            // 8. Gender Radio Button
            WebElement genderMale = driver.findElement(By.id("male"));
            if (!genderMale.isSelected()) {
                genderMale.click();
            }

            // 9. Feedback Comments (Minimum 10 words for JS validation)
            String feedback = "The course content is very helpful and the faculty is excellent for students.";
            driver.findElement(By.id("comments")).sendKeys(feedback);

            // 10. Click Submit
            System.out.println("Submitting the Feedback Form...");
            driver.findElement(By.id("submitBtn")).click();

            // 11. Handle the "Form Submitted Successfully!" Alert
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            System.out.println("Alert Message received: " + alertText);
            
            alert.accept(); 

            // Final check to confirm success
            if(alertText.contains("Successfully")) {
                System.out.println("SUCCESS: Registration Test Completed.");
            } else {
                System.out.println("FAILURE: Form did not submit correctly.");
            }

        } catch (Exception e) {
            System.out.println("ERROR: Test failed due to: " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.quit();
            System.out.println("Browser closed.");
        }
    }
}