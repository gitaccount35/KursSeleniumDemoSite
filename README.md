# KursSeleniumDemoSite

UI automation tests for [seleniumdemo.com](http://seleniumdemo.com/), built with Java, Selenium WebDriver, and TestNG. The tests exercise account registration, login, and the product checkout journey in a real browser. WebDriverManager is used to set up the browser driver, and the test suite writes an ExtentReports HTML report to `index.html`.

## Requirements

- JDK 25
- Maven
- Microsoft Edge (default) or Firefox

The browser is selected in `src/test/resources/config.properties` with `browser.name`: use `Edge` for Microsoft Edge, or another value for Firefox.

## Run the tests

```bash
mvn test
```

The tests open `http://seleniumdemo.com/` and run in a browser window. They require an internet connection and may be affected by changes or availability of the demo site. The login scenarios use an existing demo account; the successful registration scenario creates a new account with a generated email address.

## Test coverage

| Test class | Test method | What it tests |
|---|---|---|
| `RegistrationTest` | `registrationOnSiteTest` | Registers a new user and verifies that the account dashboard is displayed. |
| `RegistrationTest` | `registExistingUserOnSiteTest` | Attempts to register an already-registered email and verifies the duplicate-account error. |
| `LoginTest` | `LoginTestFunction` | Logs in with valid credentials and verifies that the dashboard is displayed. |
| `LoginTest` | `LoginIncorrectPasswordTest` | Attempts to log in with an incorrect password and verifies the authentication error. |
| `BuyingProductTest` | `BuyingProduct` | Adds “Java Selenium WebDriver” to the cart, completes checkout, and verifies the order confirmation. |

`testng.xml` groups the test classes into registration, login, and purchase suites.
