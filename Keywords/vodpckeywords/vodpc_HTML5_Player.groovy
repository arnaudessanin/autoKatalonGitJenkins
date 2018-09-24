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
import vodmobilekeywords.vodmobile_HTML5_Player as vodmobile_HTML5_Player

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.junit.After
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.interactions.Actions

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil as console

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

public class vodpc_HTML5_Player {

	private TestObject video = findTestObject('VOD Objects/PC/Video Player/zone de flux video/player')
	private WebDriver driver = DriverFactory.getWebDriver()
	private String avance_rapide = "a.tooltip.op-forward.stop-anchor.op-control"
	private String retour_rapide = "a.tooltip.op-rewind.stop-anchor.op-control"

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
		mouseOver(video)
		//verify menu is present
		if (WebUI.verifyElementInViewport(video_menu, attend, FailureHandling.CONTINUE_ON_FAILURE)){
			console.markPassed("barre de menu présent")
			//WebUI.delay(attend)
		}
		else{
			console.markFailed("barre de menu absent")
		}
		//WebUI.verifyElementPresent(video_menu, attend, FailureHandling.CONTINUE_ON_FAILURE)
		//console.markPassed("player menu is present")

		//verify flux video part is present
		if (WebUI.verifyElementInViewport(flux_video, attend, FailureHandling.CONTINUE_ON_FAILURE)){
			console.markPassed("flux vidéo présent")
			//WebUI.delay(attend)
		}
		else{
			console.markFailed("flux vidéo absent")
		}
		//WebUI.verifyElementPresent(flux_video, attend, FailureHandling.CONTINUE_ON_FAILURE)
		//console.markPassed("flux vidéo is present")

		//verify zone info program
		if(WebUI.verifyElementInViewport(zone_info_prog, attend, FailureHandling.CONTINUE_ON_FAILURE)){
			console.markPassed("zone info programme présent")
			//WebUI.delay(attend)
		}
		else{
			console.markFailed("zone info programme absent")
		}
		//WebUI.verifyElementPresent(zone_info_prog, attend, FailureHandling.CONTINUE_ON_FAILURE)
		//console.markPassed("zone info programme is present")

		//verify flux barre de control
		if(WebUI.verifyElementInViewport(barre_controle, attend, FailureHandling.CONTINUE_ON_FAILURE)){
			console.markPassed("barre de contrôle présent")
			//WebUI.delay(attend)
		}
		else{
			console.markFailed("barre de contrôle absent")
		}
		//WebUI.verifyElementPresent(barre_controle, attend, FailureHandling.CONTINUE_ON_FAILURE)
		//console.markPassed("barre de control is present")
	}

	@Keyword
	void PlayerVOD_Structure_Masquee(){

		/*
		 * Quand le player est survolé et qu'on laisse passer 5secs, la zone info programme, la barre menu et la barre de controle
		 * disparaissent immédiatement. Du coup je capture les objets masqués (classe, id, etc..) et je verifie qu'ils sont bien
		 * présent.   
		 */
		mouseOver(video)
		WebUI.delay(5)
		if(WebUI.verifyElementPresent(findTestObject('VOD Objects/PC/Video Player/Barre menu player/barre menu masquage'), 1, FailureHandling.OPTIONAL)){
			console.markPassed("barre menu masquée")
		}
		else{
			console.markFailed("barre menu non masquée")
		}
		if(WebUI.verifyElementPresent(findTestObject('VOD Objects/PC/Video Player/Barre de control player/barre de control masquage'),
		1, FailureHandling.OPTIONAL)){
			console.markPassed("barre de contrôle masquée")
		}
		else{
			console.markFailed("barre de contrôle non masquée")
		}
		if(WebUI.verifyElementPresent(findTestObject('VOD Objects/PC/Video Player/Zone Info Prog/zone info prog masquage'), 1, FailureHandling.OPTIONAL)){
			console.markPassed("zone info programme masquée")
		}
		else{
			console.markFailed("zone info programme non masquée")
		}
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
		/*
		 try{
		 vodmobile_HTML5_Player.changeMobileOrientation2("landscape")
		 }
		 catch(Exception e){}*/

	}

	@Keyword
	void playerIB_opened(){

		/*
		 * Cette methode permet de verifier que le player est ouvert ou non. Elle utilise pour se faire une autre 
		 * methode IsVODPlayingOnFirstTime qui retourne un booléen lorsque le flux vidéo joue ou pas. 
		 */

		if (IsVODPlayingOnFirstTime(video)) {
			//if it plays the first time it opens
			console.markPassed('Player IB ouvert et vidéo en lecture')
		} else {
			console.markFailedAndStop('Player IB n\'est pas ouvert')
		}
	}

	@Keyword
	void zip_verif_cover_titre_genre(String type, String titre, String genre){

		/*
		 * Cette methode permet de vérifier si un contenu possède une cover ou non, un titre et un genre dans la barre info 
		 * programme.Il faudra ainsi passer en paramètre le type de vidéo (avec cover ou sans cover)
		 * fonctonnement du script : on localise la balise <image> et on extrait la source de l'image. Si la balise est
		 * presente et que la source est non nul (chaîne de caratère)alors la cover existe belle et bien, sinon pas de cover.
		 * On fait de même pour le titre et le genre. Pour le titre et le genre, on utilise la methode getTextInsideDiv() qui
		 * utilise du javascript pour retourner le texte dans un div. 
		 * 
		 * NB: si l'on veut seuelement le titre, on utilise le paramètre "rien". 
		 * 		Ex: zip_verif_cover_titre_genre("rien", "titre", "rien")
		 *
		 */

		'Objet image representant la cover ou le banner'
		TestObject image = findTestObject('VOD Objects/PC/Video Player/Zone Info Prog/image cover ou banner')

		switch(type){

			case "cover":
				'image source de la cover ou du banner'
				String image_src = WebUI.getAttribute(image, "src", FailureHandling.CONTINUE_ON_FAILURE)
				'verification barre info programme cover à gauche'
				if (WebUI.verifyElementPresent(image, 2, FailureHandling.CONTINUE_ON_FAILURE) && image_src != "" ){
					console.markPassed("La vidéo contient une cover à gauche dans la ZIP")
				}
				else{
					console.markFailed("Pas cover à gauche dans la ZIP")
				}
				break
			case "sans cover":
				if(WebUI.verifyElementNotPresent(image, 2, FailureHandling.CONTINUE_ON_FAILURE)){
					console.markPassed("Pas de cover à gauche dans la ZIP")
					break
				}
			default :
				break
		}

		switch(titre){

			case "titre":
			//Information à droite
				String title = getTextInsideDiv("cssSelector", "div.op-infoVideo-title")

				'Titre du contenu dans la ZIP'
				if (titre != "") {
					console.markPassed("la ZIP contient un titre à droite : "+title)
				}
				else{
					console.markFailed("La ZIP ne contient pas de titre pour ce contenu")
				}
				break

			default:
				break
		}

		switch(genre){

			case "genre":
			// Le genre du contenu
				String gen = getTextInsideDiv("cssSelector", "div.op-infoVideo-genre")
				if (genre != "") {
					console.markPassed("la ZIP contient un genre: "+gen)
				}
				else{
					console.markFailed("La ZIP ne contient pas de genre pour ce contenu")
				}
				break
			default:
				break

		}


	}

	@Keyword
	void codeCSA_barre_info_programme(){

		if(WebUI.verifyElementPresent(findTestObject('Object Repository/VOD Objects/PC/Video Player/Zone Info Prog/code csa'), 2)){
			console.markPassed("code CSA affiché dans la barre d'info programme")
		}
		else{
			console.markPassed("code CSA n'exite pas dans la barre d'info programme")
		}

	}

	@Keyword
	def vitesse_normale_avancer(int i , String type){

		/*
		 * Etre hors des 5 dernières minutes
		 */

		if(i == 5){
			//ici on est hors des 5 dernières minutes
			//pour eviter les verifications et autres, il faut mettre la video au milieu lol
			//mettre la vidéo au milieu
			int duree = (int) videoInfo("duration")/2
			//PlayerVODManip(video, "arguments[0].currentTime="+duree+";arguments[0].play();")
			PlayerVODManip(video, "arguments[0].currentTime="+duree+";")
			player_send_keyboard("play")
			//WebUI.delay(3) // pour laisser la vidéo jouer un peu afin de rendre l'automatisation plus soft.
			switch(type){

				case "normale":
				//verifier que lorsque la vidéo joue normalement, l'icone de trois états est dans l'état lecture
				// être dans l'état lecture signifie que l'icone affiche le boutton pause
				// attendre 5 sec
					WebUI.delay(5)
					etat_icone_lecture_hors5minutes()
					break

				case "normale pause":
					if(WebUI.verifyElementPresent(findTestObject('Object Repository/VOD Objects/PC/Video Player/Barre de control player/play or pause button'), 2)){
						// laisser un peu jouer la vidéo
						WebUI.delay(5)
						//la mettre en pause
						//PlayerVODManip(video, "arguments[0].pause();")
						player_send_keyboard("pause")
						//laisser javascript dans le navigateur changer les styles
						WebUI.delay(5)
						// regarder l'état de l'icône à trois états
						etat_icone_lecture_hors5minutes()
					}
					break

				case "accelere avant" :
				// on accélère en avant et on regarde l'état de l'icône en Lecture
					if(WebUI.verifyElementPresent(findTestObject('Object Repository/VOD Objects/PC/Video Player/Barre de control player/avance rapide'), 2)){
						// mouse over pour faire apparaître la barre de controle
						//WebUI.mouseOver(findTestObject('Object Repository/VOD Objects/PC/Video Player/Barre de control player/avance rapide'))
						mouseOver(video)
						// attendre 1 sec
						WebUI.delay(1)
						//cliquer sur avance rapide
						WebUI.click(findTestObject('Object Repository/VOD Objects/PC/Video Player/Barre de control player/avance rapide'))
						// attendre 2 sec
						WebUI.delay(2)
						//player_send_keyboard("avance rapide")
						// regarder l'état de l'icône à trois états
						etat_icone_lecture_hors5minutes()
					}
					break

				case "accelere arriere" :
				// on accélère en arrière et on regarde l'état de l'icône en Lecture
					if(WebUI.verifyElementPresent(findTestObject('Object Repository/VOD Objects/PC/Video Player/Barre de control player/retour rapide'), 2)){
						// mouse over pour faire apparaître la barre de controle
						//WebUI.mouseOver(findTestObject('Object Repository/VOD Objects/PC/Video Player/Barre de control player/retour rapide'))
						mouseOver(video)
						// attendre 1 sec
						WebUI.delay(1)
						//cliquer sur avance rapide
						WebUI.click(findTestObject('Object Repository/VOD Objects/PC/Video Player/Barre de control player/retour rapide'))
						// attendre 2 sec
						WebUI.delay(2)
						//player_send_keyboard("retour rapide")
						// regarder l'état de l'icône à trois états
						etat_icone_lecture_hors5minutes()
					}
					break

				default :
					break
			}
		}
		else{
			// ici on est dans les 5 dernières minutes
			// mettre la vidéo à 5 minutes de la fin
			int fin = (int) (videoInfo("duration") - 290)
			//PlayerVODManip(video, "arguments[0].currentTime="+fin+";arguments[0].play();")
			PlayerVODManip(video, "arguments[0].currentTime="+fin+";")
			player_send_keyboard("play")
			//WebUI.delay(3) // pour laisser la vidéo jouer un peu afin de rendre l'automatisation plus soft.
			switch(type){
				case "normale":
				//verifier que lorsque la vidéo joue normalement, l'icone de trois états est dans l'état lecture
				// être dans l'état lecture signifie que l'icone affiche le boutton pause
				// attendre 5 sec le temps que le code javascript change les styles des balises
					WebUI.delay(5)
					etat_icone_dans5minutes()
					break
				case "normale espace":
				//verifier que lorsque la vidéo joue normalement, l'icone de trois états est dans l'état lecture
				// être dans l'état lecture signifie que l'icone affiche le boutton pause
				// attendre 1 sec
					player_send_keyboard("espace")
				// attendre 1 sec
					WebUI.delay(5)
					etat_icone_dans5minutes()
					break
				case "accelere avant" :
				// on accélère en avant et on regarde l'état de l'icône en Lecture
					if(WebUI.verifyElementPresent(findTestObject('Object Repository/VOD Objects/PC/Video Player/Barre de control player/avance rapide'), 2)){
						// attendre 10 sec
						WebUI.delay(10)
						// mouse over pour faire apparaître la barre de controle
						mouseOver(video)
						//WebUI.mouseOver(findTestObject('Object Repository/VOD Objects/PC/Video Player/Barre de control player/avance rapide'))
						//WebUI.mouseOver(video)
						// attendre 1 sec
						WebUI.delay(1)
						//cliquer sur avance rapide
						WebUI.click(findTestObject('Object Repository/VOD Objects/PC/Video Player/Barre de control player/avance rapide'))
						// attendre 2 sec
						WebUI.delay(2)
						//player_send_keyboard("avance rapide")
						// regarder l'état de l'icône à trois états
						etat_icone_lecture_hors5minutes()
					}
					break
				case "accelere arriere" :
				// on accélère en arrière et on regarde l'état de l'icône en Lecture
					if(WebUI.verifyElementPresent(findTestObject('Object Repository/VOD Objects/PC/Video Player/Barre de control player/retour rapide'), 2)){
						// mouse over pour faire apparaître la barre de controle
						//WebUI.mouseOver(findTestObject('Object Repository/VOD Objects/PC/Video Player/Barre de control player/retour rapide'))
						mouseOver(video)
						// attendre 1 sec
						WebUI.delay(1)
						//cliquer sur avance rapide
						WebUI.click(findTestObject('Object Repository/VOD Objects/PC/Video Player/Barre de control player/retour rapide'))
						// attendre 2 sec
						WebUI.delay(2)
						//player_send_keyboard("retour rapide")
						// regarder l'état de l'icône à trois états
						etat_icone_lecture_hors5minutes()
					}
					break
				default:
					break
			}
		}

		//return videoInfo("duration")
	}

	void etat_icone_lecture_hors5minutes(){

		/*
		 * 
		 */

		String play_pause = WebUI.getAttribute(findTestObject('Object Repository/VOD Objects/PC/Video Player/Barre de control player/play or pause button'), "title")
		String replay_style = WebUI.getAttribute(findTestObject('Object Repository/VOD Objects/PC/Video Player/Barre de control player/replay button'), "style")
		//println replay_style
		if(play_pause == "Pause" && replay_style == "display: none;"){
			console.markPassed("l'icône à trois états est dans l'état Pause")
		}
		else if(play_pause == "Lecture" && replay_style == "display: none;"){
			console.markPassed("l'icône à trois états est dans l'état Lecture")
		}
	}

	void etat_icone_dans5minutes(){

		/* cette methode met la video dans les 5 dernière minutes et donne l'état de l'icone à trois états. 
		 * pour cette étapes, il faut ajouter des delays afin de prendre en compte le temps de changement des style 
		 * CSS par le navigateur. Ce temps je l'ai mis à 5 secondes. 
		 * fonctionement du script : après analyse, l'on remarque que les boutons (play, pause) et replay s'affiche 
		 * à tour de rôle. Lorsqu'on est hors des 5 dernières minutes, le bouton (play, pause) est affiché et dans le 
		 * cas contraire, c'est le bouton replay. Ainsi pour la vérification, il faut utiliser le style des balises. 
		 * Hors des 5 min, le style de la balise (play, pause) devient "display: none;" et celui de replay devient
		 * "display: inline;".  
		 */

		String play_pause_style = WebUI.getAttribute(findTestObject('Object Repository/VOD Objects/PC/Video Player/Barre de control player/play or pause button'), "style")
		String replay_style = WebUI.getAttribute(findTestObject('Object Repository/VOD Objects/PC/Video Player/Barre de control player/replay button'), "style")
		//println replay_style
		if(play_pause_style == "display: none;" && replay_style == "display: inline;"){
			console.markPassed("l'icône est dans l'état Rejouer")
		}
		else{
			console.markFailed("l'icône n'est pas dans l'état Rejouer")
		}

	}

	@Keyword
	def raccourci_barre_espace(String step){

		/*
		 * 
		 */
		switch(step){

			case "step2":
				player_send_keyboard("play")
				player_send_keyboard("espace")
			// test ----------
			//WebUI.verifyElementPresent(findTestObject('VOD Objects/PC/Video Player/zone de flux video/feedback play'), 1)
			//end test -----------
				WebUI.delay(3)
				if(videoInfo("play or pause")){
					console.markPassed("Le player est en Pause")
				}
				else{
					console.markFailed("Le player n'est pas en Pause")
				}
				break
			case "step3":
				player_send_keyboard("avance rapide")
				WebUI.delay(1)
				player_send_keyboard("espace")
				WebUI.delay(3)
				if(!videoInfo("play or pause")){
					console.markPassed("Le player est en vitesse normale")
				}
				else{
					console.markFailed("Le player n'est pas en vitesse normale")
				}
				break
			case "step4":
				player_send_keyboard("pause")
				WebUI.delay(1)
				player_send_keyboard("espace")
				WebUI.delay(3)
				if(!videoInfo("play or pause")){
					console.markPassed("Le player est en vitesse normale")
				}
				else{
					console.markFailed("Le player est en pause")
				}
			default:
				break

		}
	}

	@Keyword
	def avance_et_retour_rapides(String step){

		/*
		 *
		 */
		switch(step){

			case "step2":
				player_send_keyboard("avance rapide")
				String vitesse = WebUI.getText(findTestObject('Object Repository/VOD Objects/PC/Video Player/zone de flux video/feedback avance et retour rapide'))
				String texte =  WebUI.getText(findTestObject('Object Repository/VOD Objects/PC/Video Player/zone de flux video/feedback avance et retour rapide texte'))
				if(texte == "Avance rapide" && vitesse == "X 4"){
					console.markPassed("prémière vitesse accélerée en avant : "+vitesse)
				}
				WebUI.delay(1)
				break
			case "step3":
				player_send_keyboard("avance rapide")
				String vitesse = WebUI.getText(findTestObject('Object Repository/VOD Objects/PC/Video Player/zone de flux video/feedback avance et retour rapide'))
				String texte =  WebUI.getText(findTestObject('Object Repository/VOD Objects/PC/Video Player/zone de flux video/feedback avance et retour rapide texte'))
				if(texte == "Avance rapide" && vitesse == "X 8"){
					console.markPassed("vitesse supérieure accélerée en avant : "+vitesse)
				}
				WebUI.delay(1)
				break
			case "step4":
				avance_et_retour_rapides("step2")
				WebUI.delay(1)
				break
			case "step5":
				player_send_keyboard("retour rapide")
				String vitesse = WebUI.getText(findTestObject('Object Repository/VOD Objects/PC/Video Player/zone de flux video/feedback avance et retour rapide'))
				String texte =  WebUI.getText(findTestObject('Object Repository/VOD Objects/PC/Video Player/zone de flux video/feedback avance et retour rapide texte'))
				if(texte == "Retour rapide" && vitesse == "X 4"){
					console.markPassed("prémière vitesse accélerée en arrière : "+vitesse)
				}
				WebUI.delay(1)
				break
			case "step6":
			//player_send_keyboard("avance rapide")
				WebUI.delay(4)
				player_send_keyboard("play or pause button")
				if(WebUI.verifyElementVisible(findTestObject('Object Repository/VOD Objects/PC/Video Player/zone de flux video/feedback play'))){
					console.markPassed("lecture en marche avant à vitesse normale et affichage de feedback play")
				}
				else{
					console.markFailed("Pas d'affichage de feedback play")
				}
				WebUI.delay(5)
				break
			case "step7":
			//WebUI.delay(5)
				avance_et_retour_rapides("step5")
				break
			case "step8":
				player_send_keyboard("retour rapide")
				String vitesse = WebUI.getText(findTestObject('Object Repository/VOD Objects/PC/Video Player/zone de flux video/feedback avance et retour rapide'))
				String texte =  WebUI.getText(findTestObject('Object Repository/VOD Objects/PC/Video Player/zone de flux video/feedback avance et retour rapide texte'))
				if(texte == "Retour rapide" && vitesse == "X 8"){
					console.markPassed("vitesse supérieure accélerée en arrière : "+vitesse)
				}
				WebUI.delay(1)
				break
			case "step9":
				player_send_keyboard("avance rapide")
				player_send_keyboard("avance rapide")
				avance_et_retour_rapides("step7")
				WebUI.delay(1)
				break
			case "step10":
				player_send_keyboard("retour rapide")
				avance_et_retour_rapides("step7")
				WebUI.delay(1)
				break
			case "step11":
				avance_et_retour_rapides("step6")
				break
			default:
				break

		}
	}


	def videoInfo(String option){

		/*
		 * 
		 */

		switch(option) {
			case "duration":
				String script = 'return arguments[0].duration;'
				return PlayerVODManip(video, script)
				break
			case "play or pause":
				String script = "return arguments[0].paused;"
				return PlayerVODManip(video, script)
				break
			default:
				break
		}

	}

	def player_send_keyboard(String keyboard){

		/*
		 * Les actions que peuvent effectuer le player
		 */
		String cssVideoTag = "//div[@class=\"op-video\"]//video"

		switch(keyboard){

			case "play":
				if(videoInfo("play or pause")){
					PlayerVODManip(video, "arguments[0].play();")
				}
				break
			case "play or pause button":
				mouseOver(video)
				WebUI.click(findTestObject('Object Repository/VOD Objects/PC/Video Player/Barre de control player/play or pause button'))
				break
			case "pause":
				if(!videoInfo("play or pause")){
					PlayerVODManip(video, "arguments[0].pause();")
				}
				break
			case "espace":
				WebUI.delay(3)
				WebElement video_tag = driver.findElement(By.xpath(cssVideoTag))
				video_tag.sendKeys(Keys.SPACE)
				break
			case "avance rapide":
				mouseOver(video)
				WebUI.click(findTestObject('Object Repository/VOD Objects/PC/Video Player/Barre de control player/avance rapide'))
				break
			case "retour rapide":
				mouseOver(video)
				WebUI.click(findTestObject('Object Repository/VOD Objects/PC/Video Player/Barre de control player/retour rapide'))
				break
			default:
				break
		}

	}

	def mouseOver(TestObject object){

		/*
		 * 
		 */

		String javaScript = "var evObj = document.createEvent('MouseEvents');" +
				"evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
				"arguments[0].dispatchEvent(evObj);";
		PlayerVODManip(object, javaScript)
	}

	String getTextInsideDiv(String SelectorName, String Selector){

		switch(SelectorName){

			/*
			 * exemple d'utilisation : getTextInsideDiv("cssSelector", "div.op-infoVideo-title")
			 */
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
