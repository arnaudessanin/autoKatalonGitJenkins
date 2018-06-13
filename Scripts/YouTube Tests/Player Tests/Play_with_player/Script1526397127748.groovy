import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
//get selenium api
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor

WebUI.callTestCase(findTestCase('YouTube Tests/HomePage/GetSearch_Result'), [:], FailureHandling.STOP_ON_FAILURE)

/*
'get web driver'
WebDriver driver = DriverFactory.getWebDriver()
WebElement video = driver.findElement(By.cssSelector("video.video-stream.html5-main-video"))
//TestObject video = findTestObject('Object Repository/YouTube Objects/VideoPlayer Objects/Player')
JavascriptExecutor js = (JavascriptExecutor) driver;

'Control player'
WebUI.delay(5)
js.executeScript("arguments[0].pause();", video);

'Control player'
WebUI.delay(5)

'Set current time'
js.executeScript("arguments[0].currentTime=120;", video);
WebUI.delay(5)
js.executeScript("arguments[0].play();", video);
WebUI.delay(5)
*/
'Get test object player'
TestObject video = findTestObject('Object Repository/YouTube Objects/VideoPlayer Objects/Player')

//that web element will be used to control the video
'find that test object in the current web page and save it as a web element'
WebElement player = WebUiCommonHelper.findWebElement(video, 2)

WebUI.delay(5)

'write js script to control the player'
String script = 'arguments[0].pause();var t = arguments[0].currentTime;arguments[0].currentTime=t+120;'

'execute that script'
WebUI.executeJavaScript(script, Arrays.asList(player))

WebUI.delay(5)

/*
'Script to get wether the player is in pause or play mode '
String script1 = "return arguments[0].paused"
'save the state in a variable'
Boolean curt = WebUI.executeJavaScript(script1, Arrays.asList(player))
println curt
if (curt) {
	println "Vidéo en pause"
	String script2 = "arguments[0].play();"
	WebUI.executeJavaScript(script2, Arrays.asList(player))
	WebUI.delay(5)
}
*/
'Verify button play and pause is present'
TestObject btn_pp = findTestObject('Object Repository/YouTube Objects/VideoPlayer Objects/btn_play_pause')

if (WebUI.verifyElementPresent(btn_pp, 1, FailureHandling.CONTINUE_ON_FAILURE)) {
    //verifier que l'icone du bouton est bien en mode pause
    //pour cela il faut obtenir l'attribut aria-label de l'objet btn_pp
    def attribute = WebUI.getAttribute(btn_pp, 'aria-label')

    println(attribute)

    if (attribute == 'Pause') {
        println('Vidéo en lecture')
    } else {
        println('Vidéo en Pause')
    }
}

'Close browser'
WebUI.closeBrowser()

