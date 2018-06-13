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


WebUI.callTestCase(findTestCase('YouTube Tests/HomePage/HomePage_and_Search'), [('T_OUT') : 5, ('Search') : 'Atos', ('web_site') : 'https://www.youtube.com'], 
    FailureHandling.STOP_ON_FAILURE)

'Get result number'
TestObject result_number = findTestObject('Object Repository/YouTube Objects/HomePage/search_reseult')

'Test that object is present'
if (WebUI.verifyElementPresent(result_number, 2, FailureHandling.CONTINUE_ON_FAILURE)) {
    'Get texte'
	String rslt = WebUI.getText(result_number)
    println (rslt)
	println("Resultats : "+ rslt - 'Environ')
} else {
    println('Result not available')
}

'click on vidéo link'
TestObject video_link = findTestObject('Object Repository/YouTube Objects/HomePage/video_link')
WebUI.verifyElementPresent(video_link, 1, FailureHandling.STOP_ON_FAILURE)
WebUI.click(video_link)

'delay of 5 secs'
WebUI.delay(5)



