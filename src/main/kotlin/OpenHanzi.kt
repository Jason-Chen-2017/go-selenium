fun main(args: Array<String>) {
    val driver = initDriver()
    // 笃初诚美，慎终宜令
    val wenZi = "荣业所基，籍甚无竟"
    val wenZiNew = wenZi.replace("，", "")

    wenZiNew.forEach {
        driver.executeScript("window.open('http://hanziyuan.net/#$it')", "")
    }

    Thread.sleep(5 * 1000 * 60)
    driver.quit()
}