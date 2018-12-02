import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.CapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import java.lang.Thread.sleep
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    val driver = initDriver()

    try {
        driver.get("https://www.baidu.com/")
        driver.findElement(By.id("kw")).click()
        driver.findElement(By.id("kw")).sendKeys("Kotlin")
        driver.findElement(By.id("su")).click()

        sleep(3000)

        // 百度搜索 Kotlin，自动翻10页
        for (i in 1..10) {
            driver.executeScript("scrollTo(0,2000)")
            sleep(3000)
            val e = driver.findElementByPartialLinkText("""下一页""")
            e.click()
        }

        sleep(7000)
    } catch (e: Exception) {
        e.printStackTrace()
    }

    driver.quit()
}

fun initDriver(): ChromeDriver {
    System.setProperty("webdriver.chrome.driver", "chromedriver")// 设置 webdriver 路径到系统环境变量中
    val capabilities = DesiredCapabilities.chrome()
    // SSL Certificate
    capabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true)
    capabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true)

    val headless = false
    var driver = ChromeDriver(chromeOptions(headless))
    val sessionId = driver.sessionId
    println("sessionId=${sessionId}")
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS)
    return driver
}


fun chromeOptions(headless: Boolean): ChromeOptions {
    val options = ChromeOptions()
    if (headless) {
        options.addArguments("headless")
    }
    return options
}
