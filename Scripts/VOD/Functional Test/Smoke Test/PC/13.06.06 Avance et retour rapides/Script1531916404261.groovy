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

CustomKeywords.'vodpckeywords.vodpc_connection.connectUser'(GlobalVariable.user_compte, GlobalVariable.password)

/*
 * Prérequis : Etre dans l'un des cas suivants:
 * 				- être en fin de processus d'achat ou de location de contenu
 * 				- avoir auparavant loué ou acheté un contenu et le lancer depuis "Mes vidéos" (il est donc encore
 * 					encours de validité)
 * 				- lancer la bande annonce d'un contenu
 * 	Expected : Suite à l'un des actions, le player IB est affiché
 *
 */

CustomKeywords.'vodpckeywords.vodpc_HTML5_Player.playVODContenu'(GlobalVariable.angry_bird_cover)

'Prerequis: Ouvrir une bande annonce --> Verifier que le player IB est lancé'
CustomKeywords.'vodpckeywords.vodpc_HTML5_Player.playerIB_opened'()

/*
 * Step 2 : Etre en lecture à vitesse normale. Activer la touche avance rapide(par un clic ou un focus + entrée)
 * 	Expected : Vérifier que :
 * 				- la lecture passe à la prémière vitesse accélerée en avant
 * 				- un élément de feedback s'affiche au centre du player, contenant le label 
 * 				COMMON_PLAYER_FAST_FORWARD_FEEDBACK suivi de la nouvelle vitesse de lecture.  
 */
'Step 2 : Etre en lecture à vitesse normale. Activer la touche avance rapide --> la lecture passe à la prémière vitesse accélerée en avant'
CustomKeywords.'vodpckeywords.vodpc_HTML5_Player.avance_et_retour_rapides'("step2")

/*
 * Step 3 : Etre en lecture à prémière vitesse accélérée en avant. Activer la touche avance rapide(par un clic ou un focus + entrée)
 * 	Expected : Vérifier que :
 * 				- la lecture passe à la vitesse supérieure accélerée en avant
 * 				- un élément de feedback s'affiche au centre du player, contenant le label
 * 				COMMON_PLAYER_FAST_FORWARD_FEEDBACK suivi de la nouvelle vitesse de lecture.
 */
'Step 3 : Etre en lecture à prémière vitesse accélérée en avant. Activer la touche avance rapide -->  la lecture passe à la vitesse supérieure accélerée en avant'
CustomKeywords.'vodpckeywords.vodpc_HTML5_Player.avance_et_retour_rapides'("step3")

/*
 * Step 4 : Continuer jusqu'a atteindre la vitesse avant maximale. Activer la touche avance rapide(par un clic ou un focus + entrée)
 * 	Expected : Vérifier que :
 * 				- la lecture revient sur la prémière vitesse accélerée en avant
 * 				- un élément de feedback s'affiche au centre du player, contenant le label
 * 				COMMON_PLAYER_FAST_FORWARD_FEEDBACK suivi de la nouvelle vitesse de lecture.
 */
'Step 4 : Continuer jusqu\'a atteindre la vitesse avant maximale. Activer la touche avance rapide -->  la lecture revient sur la prémière vitesse accélerée en avant'
CustomKeywords.'vodpckeywords.vodpc_HTML5_Player.avance_et_retour_rapides'("step4")

/*
 * Step 5 : Etre en lecture accélérée en arrière. Activer la touche avance rapide(par un clic ou un focus + entrée)
 * 	Expected : Vérifier que :
 * 				- la lecture passe à la prémière vitesse accélerée en arrière
 * 				- un élément de feedback s'affiche au centre du player, contenant le label
 * 				COMMON_PLAYER_FAST_FORWARD_FEEDBACK suivi de la nouvelle vitesse de lecture.
 */
'Step 5 : Etre en lecture accélérée en arrière. Activer la touche avance rapide --> la lecture passe à la prémière vitesse accélerée en arrière'
CustomKeywords.'vodpckeywords.vodpc_HTML5_Player.avance_et_retour_rapides'("step5")

/*
 * Step 6 : Appuyer sur le bouton Lecture quand la lecture est à l'une des vitesses avant
 * 	Expected : Vérifier que l'appui sur le bouton Lecture :
 * 				- Relance la lecture en marche avant à vitesse normale.
 * 				- un élément de feedback s'affiche au centre du player, rappelant le passage en lecture normale.
 * 				
 */
'Step 6 : Appuyer sur le bouton Lecture quand la lecture est à l\'une des vitesses avant --> lecture en marche avant à vitesse normale'
CustomKeywords.'vodpckeywords.vodpc_HTML5_Player.avance_et_retour_rapides'("step6")

/*
 * Step 7 : Etre en lecture à vitesse normale. Activer la touche retour rapide(par un clic ou un focus + entrée)
 * 	Expected : Vérifier que :
 * 				- la lecture passe à la prémière vitesse accélerée en arrière
 * 				- un élément de feedback s'affiche au centre du player, contenant le label
 * 				COMMON_PLAYER_FAST_REWIND_FEEDBACK suivi de la nouvelle vitesse de lecture.
 */
'Step 7 : Etre en lecture à vitesse normale. Activer la touche retour rapide --> la lecture passe à la prémière vitesse accélerée en arrière'
CustomKeywords.'vodpckeywords.vodpc_HTML5_Player.avance_et_retour_rapides'("step7")

/*
 * Step 8 : Etre en lecture à prémière vitesse accélérée en arrière. Activer la touche retour rapide(par un clic ou un focus + entrée)
 * 	Expected : Vérifier que :
 * 				- la lecture passe à la vitesse supérieure accélerée en arrière
 * 				- un élément de feedback s'affiche au centre du player, contenant le label
 * 				COMMON_PLAYER_FAST_REWIND_FEEDBACK suivi de la nouvelle vitesse de lecture.
 */
'Step 8 : Etre en lecture à prémière vitesse accélérée en arrière. Activer la touche arrière rapide -->  la lecture passe à la vitesse supérieure accélerée en arrière'
CustomKeywords.'vodpckeywords.vodpc_HTML5_Player.avance_et_retour_rapides'("step8")

/*
 * Step 9 : Continuer jusqu'a atteindre la vitesse arrière maximale. Activer la touche retour rapide(par un clic ou un focus + entrée)
 * 	Expected : Vérifier que :
 * 				- la lecture revient sur la prémière vitesse accélerée en arrière
 * 				- un élément de feedback s'affiche au centre du player, contenant le label
 * 				COMMON_PLAYER_FAST_REWIND_FEEDBACK suivi de la nouvelle vitesse de lecture.
 */
'Step 9 : Continuer jusqu\'a atteindre la vitesse en arrière maximale. Activer la touche retour rapide -->  la lecture revient sur la prémière vitesse accélerée en arrière'
CustomKeywords.'vodpckeywords.vodpc_HTML5_Player.avance_et_retour_rapides'("step9")

/*
 * Step 10 : Etre en lecture accélérée en arrière. Activer la touche retour rapide(par un clic ou un focus + entrée)
 * 	Expected : Vérifier que :
 * 				- la lecture passe à la prémière vitesse accélerée en arrière
 * 				- un élément de feedback s'affiche au centre du player, contenant le label
 * 				COMMON_PLAYER_FAST_REWIND_FEEDBACK suivi de la nouvelle vitesse de lecture.
 */
'Step 10 : Etre en lecture accélérée en arrière. Activer la touche retour rapide --> la lecture passe à la prémière vitesse accélerée en arrière'
CustomKeywords.'vodpckeywords.vodpc_HTML5_Player.avance_et_retour_rapides'("step10")

/*
 * Step 6 : Appuyer sur le bouton Lecture quand la lecture est à l'une des vitesses avant
 * 	Expected : Vérifier que l'appui sur le bouton Lecture :
 * 				- Relance la lecture en marche avant à vitesse normale.
 * 				- un élément de feedback s'affiche au centre du player, rappelant le passage en lecture normale.
 *
 */
'Step 6 : Appuyer sur le bouton Lecture quand la lecture est à l\'une des vitesses arrière --> lecture en marche avant à vitesse normale'
CustomKeywords.'vodpckeywords.vodpc_HTML5_Player.avance_et_retour_rapides'("step11")

