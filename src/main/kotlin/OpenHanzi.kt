







fun main(args: Array<String>) {
    val driver = initDriver()
    var wenZi = "人之初，性本善。性相近，习相远"
    wenZi = wenZi.replace("，", "")
    wenZi = wenZi.replace("。", "")

    wenZi.forEach {
        driver.executeScript("window.open('http://hanziyuan.net/#$it')", "")
    }

    Thread.sleep(5 * 1000 * 60)
    driver.quit()
}