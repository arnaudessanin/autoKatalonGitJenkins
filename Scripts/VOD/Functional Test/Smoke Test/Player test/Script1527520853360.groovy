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
//Added
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper

'Open a video'
WebUI.openBrowser('https://ovo.qualif1.orange.fr/#vod/movieDescription/ASTERIXETCLW0093597')
WebUI.waitForPageLoad(10, FailureHandling.STOP_ON_FAILURE)

'Play video'
WebUI.verifyElementClickable(findTestObject('VOD Objects/PC/Video Player/button regarder'), FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('VOD Objects/PC/Video Player/button regarder'))

String bm_masq = WebUI.getAttribute(findTestObject('VOD Objects/PC/Video Player/Barre menu player/barre menu show'), "class")

println bm_masq
'write js script to control the player'
//When using script, use 'argument[0]' to identify video player
//String script = 'arguments[0].pause();var t = arguments[0].currentTime;arguments[0].currentTime=t+20;'
TestObject video = findTestObject('VOD Objects/PC/Video Player/player')

//CustomKeywords.'vodkeyword.vod_identification.PlayerVODManip'(video, script)

//String script2 = 'arguments[0].play();'
//CustomKeywords.'vodkeyword.vod_identification.PlayerVODManip'(video, script2)

'delay 7s'
WebUI.delay(10)

def H = WebUI.getElementHeight(video).intdiv(2)
def W = WebUI.getElementWidth(video).intdiv(2)

'print H and W'
println H
println W

'Mouse hovering'
WebUI.mouseOverOffset(video, W, -H)
//WebUI.mouseOver(video)
'delay 3s'
WebUI.delay(5)

CustomKeywords.'vodkeyword.vod_identification.PlayerVODManip'(video, 'arguments[0].pause();')
CustomKeywords.'vodkeyword.vod_identification.PlayerVODManip'(video, 'var t = arguments[0].currentTime;arguments[0].currentTime=t;')
//WebUI.delay(2)
WebUI.verifyElementClickable(findTestObject('VOD Objects/PC/Video Player/Barre de control player/play button'))
WebUI.click(findTestObject('VOD Objects/PC/Video Player/Barre de control player/play button'))
'Test if barre menu is hidden or not'
WebUI.delay(3)
//String bm_masq = WebUI.getAttribute(findTestObject('VOD Objects/PC/Video Player/Barre menu player/barre menu show'), "class")

//println bm_masq
CustomKeywords.'vodkeyword.vod_identification.waitVideoToLoad'(video)

'Close Browser'
WebUI.closeBrowser()
