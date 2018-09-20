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
import myutilities.usefulKeyword as usefulKeyword

public class vodpc_MesFavoris {

	int timeout = 5
	TestObject mes_favoris =  findTestObject('VOD Objects/PC/Home Page apres Identification/Menu convergeant (mc)/mc Mes favoris')
	String menu = "Mes favoris"

	@Keyword
	void gotoMesFavoris(){

		try {
			//wait for page to load
			WebUI.waitForPageLoad(timeout)

			//verify element visible
			WebUI.verifyElementVisible(mes_favoris)

			//click on mes videos
			WebUI.click(mes_favoris)

			console.markPassed("Menu convergeant "+menu+" accessed")

		} catch (Exception e) {

			console.markErrorAndStop("Web page is not loading, check your connection or menu "+menu+" chosen does not exist")
		}
	}

	@Keyword
	def clickBoutonPopinConfirmation(){

		popInConfirmation("tout supprimer")
		popin()
		//TestObject popin = findTestObject('Object Repository/VOD Objects/PC/Menu Convergeant Mes Favoris/popin')
		WebUI.delay(3)
		popin()
		if(WebUI.getText(findTestObject('Object Repository/VOD Objects/PC/Menu Convergeant Mes Favoris/nombre de favoris')) == ""){
			console.markPassed("Tous les favoris supprimés et la pop-in disparaît")
		}
		else{
			console.markFailed("Tous les favoris ne sont pas supprimés")
		}
	}

	@Keyword
	def clickBoutonPopinAnnuler(){

		popInConfirmation("annuler")

		WebUI.delay(3)

		if(WebUI.getText(findTestObject('Object Repository/VOD Objects/PC/Menu Convergeant Mes Favoris/nombre de favoris')) != ""){
			console.markPassed("Les favoris n'ont pas été supprimés et la popin disparaît")
		}
		else{
			console.markFailed("Tous les favoris sont supprimés")
		}
	}

	@Keyword
	def popInVerificationTexte(){

		WebUI.click(findTestObject('Object Repository/VOD Objects/PC/Menu Convergeant Mes Favoris/button tout supprimer'))
		WebUI.delay(3)
		//String confirmation = getTextInsideDiv("cssSelector", "div.modal-title > h2 > div")
		String confirmation = WebUI.getText(findTestObject('Object Repository/VOD Objects/PC/Menu Convergeant Mes Favoris/Popin tout supprimer/Confirmation'))
		println confirmation

	}

	def popInConfirmation(String choix){

		WebUI.click(findTestObject('Object Repository/VOD Objects/PC/Menu Convergeant Mes Favoris/button tout supprimer'))
		WebUI.delay(3)

		switch(choix){

			case "tout supprimer":
				WebUI.click(findTestObject('Object Repository/VOD Objects/PC/Menu Convergeant Mes Favoris/button confirmer supression'))
				break
			case "annuler":
				WebUI.click(findTestObject('Object Repository/VOD Objects/PC/Menu Convergeant Mes Favoris/button annuler supression'))
				break
			default:
				break
		}
	}

	void popin(){

		TestObject popin = findTestObject('Object Repository/VOD Objects/PC/Menu Convergeant Mes Favoris/popin')
		WebUI.delay(1)

		if (popinVisibleOrNot(popin)){
			console.markPassed("popin visible")
		}
		else{
			console.markPassed("popin non visible")
		}
	}

	@Keyword
	def ajouterFavoris(String contenu){

		//verifier si il y'a des favoris ou pas?
		if(!verifFavoris()){
			//si il n'y a pas de favoris
			WebUI.navigateToUrl(contenu)
			WebUI.waitForPageLoad(5)
			WebUI.click(findTestObject('Object Repository/VOD Objects/PC/Menu Convergeant Mes Favoris/button add favoris icone'))
			WebUI.delay(4)
			gotoMesFavoris()
		}


	}

	def verifFavoris(){

		if(WebUI.verifyElementVisible(findTestObject('Object Repository/VOD Objects/PC/Menu Convergeant Mes Favoris/button tout supprimer'), FailureHandling.OPTIONAL)){
			return true
		}
		else{
			return false
		}
	}

	Boolean popinVisibleOrNot(TestObject obj){

		Boolean r = false

		if(WebUI.verifyElementVisible(obj, FailureHandling.OPTIONAL)){
			r = true
		}
		return r

	}

	String getTextInsideDiv(String SelectorName, String Selector){

		switch(SelectorName){

			case "cssSelector" :
				String script = "return window.document.querySelector('"+Selector+"').textContent"
				return WebUI.executeJavaScript(script, null)
				break
			case "Id":
				return "à implémenter"
				break
			default:
				return "Selector not regognized"
				break
		}
	}
}
