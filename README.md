# SwagLabs Hybrid Framework  

## 📌 Overview  
SwagLabs Hybrid Framework is a **Selenium-based test automation framework** designed to test SwagLabs efficiently. It combines **data-driven, keyword-driven, and modular approaches** for better test execution, scalability, and maintenance.  

## ✨ Features  
- ✅ **Track Log Files** – View execution logs for debugging (**Log4j**).  
- ✅ **Test Reports** – Generate detailed reports using **Extent Reports** and **TestNG**.  
- ✅ **Bug Screenshots** – Capture screenshots on test failures.  
- ✅ **Excel Data Handling** – Read and write test data using **Apache POI**.  
- ✅ **Email Notifications** – Send test reports via email after execution.  

## 🛠️ Technologies Used  
| Technology            | Purpose                           | Version  |
|----------------------|---------------------------------|---------|
| **Maven**           | Dependency & build management   | Latest  |
| **Selenium WebDriver** | Browser automation             | 4.15.0  |
| **TestNG**          | Test execution & reporting      | 7.8.0   |
| **Log4j**           | Logging framework               | 2.22.0  |
| **Extent Reports**  | HTML-based test reports         | 5.1.1   |
| **Apache POI**      | Excel file handling             | 5.2.5   |
| **Apache Commons**  | File handling utilities         | 2.13.0  |
| **Java Faker**      | Fake test data generation       | 1.0.2   |
| **Apache Commons Email** | Email notifications        | 1.6.0   |

```
## 📂 Project Structure  
# SwagLabs_HybridFramework

│── src/
│   ├── main/
│   │   ├── java/                   # Framework core & utilities
│   │   ├── resources/               # Config files, log4j, test data
│   ├── test/
│   │   ├── java/
│   │   │   ├── com.swagLabs.pageObjects/   # Page Object Model (POM)
│   │   │   │   ├── BasePage.java
│   │   │   │   ├── CheckoutCompletePage.java
│   │   │   │   ├── CheckoutOverviewPage.java
│   │   │   │   ├── CheckoutPage.java
│   │   │   │   ├── LoginPage.java
│   │   │   │   ├── LogoutPage.java
│   │   │   │   ├── ProductPage.java
│   │   │   │   ├── YourCartPage.java
│   │   │   ├── com.swagLabs.testBase/      # Base Test Class
│   │   │   │   ├── BaseClass.java
│   │   │   ├── com.swagLabs.testCases/     # Test Cases
│   │   │   │   ├── AddToCartFunctionalityTest.java
│   │   │   │   ├── CartContentsVerificationTest.java
│   │   │   │   ├── ContinueShoppingButton.java
│   │   │   │   ├── LoginPageElementVerification.java
│   │   │   │   ├── LoginPageFieldVerification.java
│   │   │   │   ├── LoginPageMissingCredentialsTest.java
│   │   │   │   ├── LoginPageTest.java
│   │   │   │   ├── LogoutButtonTest.java
│   │   │   │   ├── OrderSuccessTest.java
│   │   │   │   ├── ProductDetailsVerificationTest.java
│   │   │   │   ├── ProductRemovalFromCart.java
│   │   │   ├── com.swagLabs.utilities/     # Utility Classes
│   │   │   │   ├── ExtentReportManager.java
│   │   ├── resources/              # Test Data, Reports & Config
│   │   │   ├── log4j2.xml
│   │   │   ├── log4j2-back.xml
│── test-output/                     # Generated reports
│── logs/                             # Logs directory
│── screenshots/                      # Captured screenshots on failures
│── pom.xml                           # Maven dependencies & build configuration
│── README.md                         # Project documentation
```
## 📜 Reporting & Logging

- **Logs:** Available in the `/logs` directory.  
- **Test Reports:** View detailed test execution reports in the `/test-output` folder.  
- **Screenshots:** Captured on failures and stored in the `/screenshots` folder.  

## 👤 Author  
### Dinakar Reddy
