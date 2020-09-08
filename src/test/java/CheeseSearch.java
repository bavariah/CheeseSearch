        import org.junit.jupiter.api.Assertions;
        import org.junit.jupiter.api.Test;
        import org.openqa.selenium.By;
        import org.openqa.selenium.Keys;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
        import java.time.Duration;

public class CheeseSearch {


    @Test
    public void CheeseSearch() {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            driver.get("https://google.com/ncr");
            driver.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);       // By Name "q" Selector for input search
            WebElement firstResult = wait.until(presenceOfElementLocated(By.id("result-stats")));
            String result = firstResult.getAttribute("textContent").split(" ")[1];          // Select Text, Split to get number of results
            Assertions.assertEquals("777", result, "There is too much cheese on the internet");
        }
        finally {
            driver.quit();
        }
    }
}