package vodpckeywords

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

public class vodpc_MesVideos {

	int timeout = 15
	TestObject mes_video =  findTestObject('VOD Objects/PC/Home Page apres Identification/Menu convergeant (mc)/mc Mes videos')
	String menu = "Mes vidéos"

	@Keyword
	def totalVideos(){
	}

	@Keyword
	void gotoMesVideos(){

		try {
			//wait for page to load
			WebUI.waitForPageLoad(timeout)

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

	}

	@Keyword
	def composantMesVideo(){

		if(WebUI.verifyElementPresent(findTestObject('Object Repository/VOD Objects/PC/Menu Convergeant Mes videos/banner composant MesVideo'), 1)){
			console.markPassed("Banner du composant MesVidéos présent")
		}
		if(WebUI.verifyElementPresent(findTestObject('Object Repository/VOD Objects/PC/Menu Convergeant Mes videos/section Mes video composant MesVideo'), 1)){
			console.markPassed("Section "+WebUI.getText(findTestObject('Object Repository/VOD Objects/PC/Menu Convergeant Mes videos/section Mes video composant MesVideo'))+ " du composant MesVidéos présent")
		}
		if(WebUI.verifyElementPresent(findTestObject('Object Repository/VOD Objects/PC/Menu Convergeant Mes videos/mosaic composant MesVideo'), 1)){
			console.markPassed("Mosaïc du composant MesVidéos présent")
		}
	}

	@Keyword
	def accesUtilisateurNonAuthentifie(){

		WebUI.navigateToUrl("https://ovo.qualif1.orange.fr/#vod/home")

		//wait for page to load
		WebUI.waitForPageLoad(timeout)

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
