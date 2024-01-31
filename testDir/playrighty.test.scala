import com.microsoft.playwright.*
import com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat

class PlaywrightTest extends munit.FunSuite:

  var pw: Playwright = _
  var browser: Browser = _
  var page: Page = _

  override def beforeAll(): Unit =

    System.setProperty("playwright.driver.impl", "jsenv.DriverJar")
    pw = Playwright.create()
    browser = pw.chromium().launch();
    page = browser.newPage();
    ()
  end beforeAll

  test("can plot pie chart") {
    assert(true)
  }

  override def afterAll(): Unit =
    super.afterAll()
    pw.close()
    println("afterAll")

end PlaywrightTest
