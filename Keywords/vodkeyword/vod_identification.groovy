package vodkeyword
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

class vod_identification {

	/* Initialisation des Objets et variables
	 * Définir tous les objects nécessaires de la page
	 */

	// Test Object
	TestObject input_login = findTestObject('VOD Objects/PC/Identification page object/login_input')
	TestObject valider = findTestObject('VOD Objects/PC/Identification page object/btn_continuer')
	TestObject input_passwd = findTestObject('VOD Objects/PC/Identification page object/saissisez mot de passe input')
	TestObject user_error = findTestObject('VOD Objects/PC/Identification page object/Texte user compte error')
	TestObject passwd_error = findTestObject('VOD Objects/PC/Identification page object/Texte password error')
	TestObject error_id = findTestObject('VOD Objects/PC/Identification page object/error id')
	TestObject error_ou_pas = findTestObject('VOD Objects/PC/Identification page object/peut contenir error')

	//url for authentication
	String url_login = "https://login-tb1.staging.orange.fr/?return_url=https%3A%2F%2Fovo.qualif1.orange.fr%2F%23vod%2Fhome"
	int timeout = 5

	@Keyword
	def idVOD(String user, String passwd) {

		/*
		 *  
		 */

		//Open browser to authentication page
		WebUI.openBrowser(url_login)

		//Maximize window
		WebUI.maximizeWindow()

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

		//wait for page to load
		WebUI.waitForPageLoad(timeout)
	}

	@Keyword
	void androidAuth(String user, String passwd) {

		/*
		 * 
		 */

		//Open browser to authentication page
		WebUI.openBrowser(url_login)

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

		//wait for page to load
		WebUI.waitForPageLoad(timeout)

		if (WebUI.verifyElementVisible(findTestObject('Object Repository/VOD Objects/Mobile/Android/Identifications/Orange app screen to close'),FailureHandling.OPTIONAL)){

			//if element visible, close it
			WebUI.check(findTestObject('Object Repository/VOD Objects/Mobile/Android/Identifications/se souvenir de mon choix'))

			//continuer
			WebUI.click(findTestObject('Object Repository/VOD Objects/Mobile/Android/Identifications/continuer sur web'))
		}else{}

		if(WebUI.verifyElementVisible(findTestObject('Object Repository/VOD Objects/Mobile/Android/Identifications/banniere orange app'),FailureHandling.OPTIONAL)){

			//close orange app
			WebUI.click(findTestObject('Object Repository/VOD Objects/Mobile/Android/Identifications/close banner app'))

			//accepter cookies
			WebUI.click(findTestObject('Object Repository/VOD Objects/PC/Home Page/accepter cookie'))
		}else{}

	}

	@Keyword
	def menuConvergentVOD(String menu){

		/*
		 * Cette méthode permet de choisir le menu comvergeant que l'on souhaite accéder 
		 * en entrant le nom exacte. Seules sont disponibles les options : mes vidéos,
		 * mes favoris et mon compte prépayé.
		 * Les étapes du script: On attend que la page se charge puis on appelle la methode
		 * trouver_menu qui retourne l'objet permetant d'identifier le menu. Ensuite cet objet 
		 * est cliqué s'il existe. 
		 */

		//Menu convergeant Object
		TestObject tout_catalogue = findTestObject('VOD Objects/PC/Home Page apres Identification/Menu convergeant (mc)/mc tout le catalogue ')
		TestObject mes_video =  findTestObject('VOD Objects/PC/Home Page apres Identification/Menu convergeant (mc)/mc Mes videos')
		TestObject mes_favoris =  findTestObject('VOD Objects/PC/Home Page apres Identification/Menu convergeant (mc)/mc Mes favoris')
		TestObject mon_compte =  findTestObject('VOD Objects/PC/Home Page apres Identification/Menu convergeant (mc)/mc Mon compte prepaye')
		TestObject aide =  findTestObject('VOD Objects/PC/Home Page apres Identification/Menu convergeant (mc)/mc Aide')

		//mettre tous mes objets du menu convergeant dans une liste
		def menus = [
			mes_video,
			mes_favoris,
			mon_compte
		]

		try {

			WebUI.waitForPageLoad(timeout)
			//match menu with Object we have
			TestObject menu_choisi = trouver_menu(menu, menus)
			//verification
			if (menu_choisi != null) {
				//click on this menu
				WebUI.click(menu_choisi)
				console.markPassed("Menu convergeant '"+menu+"' accessed")
			}
		} catch (Exception e) {
			console.markErrorAndStop("Web page is not loading, check your connection or menu chosen does not exist")
		}

	}

	@Keyword
	def androidmenuConvergentVOD(String menu){

		/*
		 * Cette méthode permet de choisir le menu comvergeant que l'on souhaite accéder
		 * en entrant le nom exacte. Seules sont disponibles les options : mes vidéos,
		 * mes favoris et mon compte prépayé.
		 * Les étapes du script: On attend que la page se charge, on clique sur le menu toggle (car mobile)
		 *  puis on appelle la methode trouver_menu qui retourne l'objet permettant d'identifier le menu
		 *  Ensuite cet objet est cliqué s'il existe.
		 */

		//Menu convergeant Object
		TestObject tout_catalogue = findTestObject('VOD Objects/Mobile/Android/Home page authen/')
		TestObject mes_video =  findTestObject('VOD Objects/Mobile/Android/Home page authen/Mes video')
		TestObject mes_favoris =  findTestObject('VOD Objects/Mobile/Android/Home page authen/Mes favoris')
		TestObject mon_compte =  findTestObject('VOD Objects/Mobile/Android/Home page authen/Mon compte prepaye')
		TestObject aide =  findTestObject('VOD Objects/Mobile/Android/Home page authen/Aide')

		//mettre tous mes objets du menu convergeant dans une liste
		def menus = [
			mes_video,
			mes_favoris,
			mon_compte
		]

		try {

			WebUI.waitForPageLoad(timeout)

			//Click on menu toggle (car mobile)
			WebUI.click(findTestObject('Object Repository/VOD Objects/Mobile/Android/Home page authen/menu convergeant'))

			//match menu with Object we have
			TestObject menu_choisi = trouver_menu(menu, menus)
			//verification
			if (menu_choisi != null) {
				//click on this menu
				WebUI.click(menu_choisi)
				console.markPassed("Menu convergeant '"+menu+"' accessed")
				WebUI.waitForPageLoad(timeout)
			}
		} catch (Exception e) {
			console.markErrorAndStop("Web page is not loading, check your connection or menu chosen does not exist")
		}
	}

	TestObject trouver_menu(String menu, def menus){

		/*
		 * 
		 */

		for (int i = 0; i<menus.size(); i++) {
			//get current texte
			String t = WebUI.getText(menus[i])
			//compare with what we have in parametre
			if (menu == t) {
				return menus[i]
			}
		}
		return null
	}

	@Keyword
	def PlayerVOD_Structure(){

		/*
		 * Cette méthode permet de vérifier la structure du player.
		 * Les 4 parties sont: menu player, flux video, zone info programme, et barre de contrôle.
		 * Les étapes du script: on defini les objets permettant d'identifier les différentes parties
		 * du player puis on verifie que ces parties sont présentes avec la méthode verifyElementPresent().
		 * On verifie si l'element est présent alors on passe, sinon on fail 
		 */

		TestObject video_menu = findTestObject('VOD Objects/PC/Video Player/Barre menu player/barre menu')
		TestObject flux_video = findTestObject('VOD Objects/PC/Video Player/zone de flux video/player')
		TestObject zone_info_prog = findTestObject('VOD Objects/PC/Video Player/Zone Info Prog/zone info programme')
		TestObject barre_controle = findTestObject('VOD Objects/PC/Video Player/Barre de control player/barre de control')
		int attend = 1

		//verify menu is present
		if (WebUI.verifyElementInViewport(video_menu, attend, FailureHandling.CONTINUE_ON_FAILURE)){
			console.markPassed("player menu is displayed")
			//WebUI.delay(attend)
		}
		else{
			console.markFailed("player menu is not displayed")
		}
		//WebUI.verifyElementPresent(video_menu, attend, FailureHandling.CONTINUE_ON_FAILURE)
		//console.markPassed("player menu is present")

		//verify flux video part is present
		if (WebUI.verifyElementInViewport(flux_video, attend, FailureHandling.CONTINUE_ON_FAILURE)){
			console.markPassed("flux vidéo is displayed")
			//WebUI.delay(attend)
		}
		else{
			console.markFailed("flux vidéo is not displayed")
		}
		//WebUI.verifyElementPresent(flux_video, attend, FailureHandling.CONTINUE_ON_FAILURE)
		//console.markPassed("flux vidéo is present")

		//verify zone info program
		if(WebUI.verifyElementInViewport(zone_info_prog, attend, FailureHandling.CONTINUE_ON_FAILURE)){
			console.markPassed("zone info programme is displayed")
			//WebUI.delay(attend)
		}
		else{
			console.markFailed("zone info programme is not displayed")
		}
		//WebUI.verifyElementPresent(zone_info_prog, attend, FailureHandling.CONTINUE_ON_FAILURE)
		//console.markPassed("zone info programme is present")

		//verify flux barre de control
		if(WebUI.verifyElementInViewport(barre_controle, attend, FailureHandling.CONTINUE_ON_FAILURE)){
			console.markPassed("barre de control is displayed")
			//WebUI.delay(attend)
		}
		else{
			console.markFailed("barre de control is not displayed")
		}
		//WebUI.verifyElementPresent(barre_controle, attend, FailureHandling.CONTINUE_ON_FAILURE)
		//console.markPassed("barre de control is present")
	}

	@Keyword
	def PlayerVODManip(TestObject video_tag, String script){

		/* Cette méthode permet de manipuler le player identifié par le tag <video></video>
		 * NB: Ceci n'est valable qu'en html5
		 * Etapes du script: je prends en paramètre le tag video et le script à exécuter.
		 * puis avec ce tag video, je le transforme en player et j'exécute le script javascript.
		 * NB: les scripts pour manipuler le player doivent utiliser 'argument[0]' pour l'identifier
		 * Ex: String script = 'argument[0].play()' permet de jouer la video. 
		 * 
		 */

		//that web element will be used to control the video
		'find that test object in the current web page and save it as a web element'
		WebElement player = WebUiCommonHelper.findWebElement(video_tag, 2)

		'execute that script'
		WebUI.executeJavaScript(script, Arrays.asList(player))
	}

	@Keyword
	boolean IsVODPlayingOnFirstTime(TestObject video_tag){
		/*
		 * Cette methode vérifie que un contenu lancé a bien commencé. 
		 * Pour cela le player doit s'ouvrir (1) et le flux doit se lancer (2).
		 * Ces deux conditions doivent être vérifiées : (1) et (2).
		 * Les étapes du script : la vidéos est lancé et je la retarde de xxs
		 * puis dans un script je retourne le temps présent de la vidéo. Après je 
		 * compare cela à 0 et je retourne true ou false
		 * 
		 */
		//script to get the current time
		String script = 'return arguments[0].currentTime;'

		//retarder de 15s
		WebUI.delay(15)

		def is_playing = PlayerVODManip(video_tag, script)

		//verifier le retour du current time
		if (is_playing != 0){
			return true
		}
		else{
			return false
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
		WebUI.waitForPageLoad(5, FailureHandling.STOP_ON_FAILURE)

		'If button accepter cookie is visible, click on it'
		if (WebUI.verifyElementInViewport(findTestObject('VOD Objects/PC/Home Page/accepter cookie'), 5,FailureHandling.OPTIONAL)){

			WebUI.click(findTestObject('VOD Objects/PC/Home Page/accepter cookie'))
		}

		'Play video'
		if (WebUI.verifyElementVisible(findTestObject('VOD Objects/PC/Video Player/zone de flux video/button regarder'), FailureHandling.OPTIONAL)){
			WebUI.click(findTestObject('VOD Objects/PC/Video Player/zone de flux video/button regarder'))
		}
		else{
			WebUI.click(findTestObject('VOD Objects/PC/Video Player/zone de flux video/play triangle'))
		}

	}

	@Keyword
	void zip_verif_cover_titre_genre(){

		/*
		 * 
		 */

		'Objet image representant la cover ou le banner'
		TestObject image = findTestObject('VOD Objects/PC/Video Player/Zone Info Prog/image cover ou banner')

		'image source de la cover ou du banner'
		String image_src = WebUI.getAttribute(image, "src", FailureHandling.CONTINUE_ON_FAILURE)

		'verification barre info programme cover à gauche'
		if (WebUI.verifyElementPresent(image, 2, FailureHandling.CONTINUE_ON_FAILURE) && image_src != "" ){
			console.markPassed("La vidéo contient une cover à gauche dans la ZIP")
		}
		else{
			console.markFailed("Pas cover à gauche dans la ZIP")
		}

		//Information à droite
		String titre = getTextInsideDiv("cssSelector", "div.op-infoVideo-title")

		'Titre du contenu dans la ZIP'
		if (titre != "") {
			console.markPassed("la ZIP contient un titre à droite : "+titre)
		}
		else{
			console.markFailed("La ZIP ne contient pas de titre pour ce contenu")
		}

		// Le genre du contenu
		String genre = getTextInsideDiv("cssSelector", "div.op-infoVideo-genre")
		if (genre != "") {
			console.markPassed("la ZIP contient un genre: "+genre)
		}
		else{
			console.markFailed("La ZIP ne contient pas de genre pour ce contenu")
		}

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
