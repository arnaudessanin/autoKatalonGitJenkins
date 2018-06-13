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
import io.appium.java_client.android.AndroidKeyCode as AndroidKeyCode
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('www.google.com')

WebUI.waitForPageLoad(3)

WebUI.verifyElementVisible(findTestObject('Mobile/chrome web/input search'))

WebUI.setText(findTestObject('Mobile/chrome web/input search'), 'appium')

'press enter'
//CustomKeywords.'mobile.android.pressKey'(AndroidKeyCode.ENTER)
WebUI.sendKeys(findTestObject('Mobile/chrome web/input search'), Keys.chord(Keys.ENTER))

WebUI.waitForPageLoad(3)

WebUI.verifyElementClickable(findTestObject('Mobile/chrome web/appium link'))

WebUI.click(findTestObject('Mobile/chrome web/appium link'))

WebUI.waitForPageLoad(3)

WebUI.closeBrowser()

