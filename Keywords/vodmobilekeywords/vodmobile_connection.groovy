package vodmobilekeywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject


import java.awt.List

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import com.kms.katalon.core.testobject.ConditionType

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.junit.After
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil as console

import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import myutilities.usefulKeyword as usefulKeyword


public class vodmobile_connection {

	//url for authentication
	String url_login = "https://login-tb1.staging.orange.fr/?return_url=https%3A%2F%2Fovo.qualif1.orange.fr%2F%23vod%2Fhome"

	// Test Object
	TestObject input_login = findTestObject('VOD Objects/PC/Identification page object/login_input')
	TestObject input_passwd = findTestObject('VOD Objects/PC/Identification page object/saissisez mot de passe input')
	TestObject valider = findTestObject('VOD Objects/PC/Identification page object/btn_continuer')
	int timeout = 5

	@Keyword
	void connectUser(String user, String passwd){

		/*
		 *
		 */

		//go to to authentication page
		WebUI.navigateToUrl(url_login)

		//set text
		WebUI.waitForElementPresent(input_login, timeout)
		WebUI.setText(input_login, user)

		//click on continuer
		WebUI.click(valider)

		//set password
		WebUI.waitForElementPresent(input_passwd, timeout)
		WebUI.setText(input_passwd, passwd)

		//click pour continuer
		WebUI.click(valider)

		//authen success
		console.markPassed("Authentication of client "+user+" is successful")
		
		// call infoPage() if ../info is present in url
		infoPage()

		//wait for page to load
		WebUI.waitForPageLoad(timeout)

		// ajouter dernièrement ************
		//WebUI.navigateToUrl("https://ovo.qualif1.orange.fr/#vod/home")

		//accepter cookies
		WebUI.click(findTestObject('Object Repository/VOD Objects/PC/Home Page/accepter cookie'))

		//close menu
		WebUI.click(findTestObject('Object Repository/VOD Objects/Mobile/Android/Home page authen/close menu TV app'))


	}
	
	void infoPage(){
		
		WebUI.delay(2)
		
		if(WebUI.getUrl() == "https://login-tb1.staging.orange.fr/info"){
			
			WebUI.navigateToUrl("https://ovo.qualif1.orange.fr/#vod/home")
		}
	}


}
