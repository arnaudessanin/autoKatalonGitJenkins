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

public class vodmobile_MesVideos {

	int timeout = 5
	TestObject mes_video =  findTestObject('VOD Objects/Mobile/Android/Home page authen/Mes video')
	String menu = "Mes vidéos"

	@Keyword
	def totalVideos(){
	}

	@Keyword
	void gotoMesVideos(){

		try {
			//wait for page to load
			WebUI.waitForPageLoad(timeout)

			//Click on menu toggle (car mobile)
			WebUI.click(findTestObject('Object Repository/VOD Objects/Mobile/Android/Home page authen/menu convergeant'))

			//verify element visible
			WebUI.verifyElementVisible(mes_video)

			//click on mes videos
			WebUI.click(mes_video)

			console.markPassed("Menu convergeant "+menu+" accessed")

			'If button accepter cookie is visible, click on it'
			if (WebUI.verifyElementInViewport(findTestObject('VOD Objects/PC/Home Page/accepter cookie'), 5,FailureHandling.OPTIONAL)){

				WebUI.click(findTestObject('VOD Objects/PC/Home Page/accepter cookie'))
			}

		} catch (Exception e) {

			console.markErrorAndStop("Web page is not loading, check your connection or menu "+menu+" chosen does not exist")
		}

		WebUI.click(findTestObject('Object Repository/VOD Objects/Mobile/Android/Mes videos/lire'))

	}

	@Keyword
	def accesUtilisateurNonAuthentifie(){

		WebUI.navigateToUrl("https://ovo.qualif1.orange.fr/#vod/home")

		//wait for page to load
		WebUI.waitForPageLoad(timeout)

		//Click on menu toggle (car mobile)
		WebUI.click(findTestObject('Object Repository/VOD Objects/Mobile/Android/Home page authen/menu convergeant'))

		//verify element visible
		WebUI.verifyElementVisible(mes_video)

		//click on mes videos
		WebUI.click(mes_video)

		//wait for page to load
		WebUI.waitForPageLoad(timeout)

		if(WebUI.verifyMatch("Identifiez-vous", WebUI.getText(findTestObject('Object Repository/VOD Objects/PC/Identification page object/Texte Identifiez-vous')), false)){
			console.markPassed("Utilisateur redirigé vers la page d'authentification")
		}

	}

}
