package vodmobilekeywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

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

import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.ScreenOrientation
import io.appium.java_client.android.AndroidDriver

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

import com.kms.katalon.core.util.KeywordUtil as console

public class vodmobile_HTML5_Player {

	private AndroidDriver driver = DriverFactory.getWebDriver()

	@Keyword
	def changeMobileOrientation(String orientation){

		switch(orientation){
			case "landscape":
				driver.rotate(ScreenOrientation.LANDSCAPE);
				break
			default:
				driver.rotate(ScreenOrientation.PORTRAIT);
				break
		}
	}

	@Keyword
	void playVODContenu(String url){

		/*Cette methode permet d'ouvrir une url et de jouer le contenu.
		 * Pour cela, on navigue à l'url du contenu puis on verifie si le bouton play en forme
		 * de triangle est disponible sinon on utilise le boutton regarder.
		 * NB: Quand on ouvre une nouvelle session, le navigateur demande d'accepter les cookies
		 * il faut alors verifier si ce bouton est affiché et cliquer la dessus sinon le test
		 * echoue car une partie du player n'est pas visible
		 */

		'Open a video'
		WebUI.navigateToUrl(url)
		WebUI.waitForPageLoad(10, FailureHandling.STOP_ON_FAILURE)

		'If button accepter cookie is visible, click on it'
		if (WebUI.verifyElementInViewport(findTestObject('VOD Objects/PC/Home Page/accepter cookie'), 5,FailureHandling.OPTIONAL)){
			WebUI.click(findTestObject('VOD Objects/PC/Home Page/accepter cookie'))
		}

		'Play video'
		if (WebUI.verifyElementVisible(findTestObject('VOD Objects/PC/Video Player/zone de flux video/button regarder'), FailureHandling.OPTIONAL)){
			WebUI.click(findTestObject('VOD Objects/PC/Video Player/zone de flux video/button regarder'))
			WebUI.delay(5) // la vidéo prend du temps à se charger lorsqu'on appuie sur regarder
		}
		else if(WebUI.waitForElementVisible(findTestObject('VOD Objects/PC/Video Player/zone de flux video/play triangle'), 15, FailureHandling.OPTIONAL)){
			WebUI.click(findTestObject('VOD Objects/PC/Video Player/zone de flux video/play triangle'))
		}
		else{
			console.markFailedAndStop("La vidéo ne peut être jouée")
		}

		changeMobileOrientation("landscape")
	}
}
