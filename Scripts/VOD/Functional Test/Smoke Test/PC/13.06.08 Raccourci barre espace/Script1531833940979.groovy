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
 * Step 2 : Le player lit un contenu a vitesse normale. Appuyer sur la barre espace du clavier
 * 	Expected : Vérifier que le player passe en Pause. 
 */
'Step 2 : Le player lit un contenu a vitesse normale. Appuyer sur la barre espace du clavier --> Vérifier que le player passe en Pause'
CustomKeywords.'vodpckeywords.vodpc_HTML5_Player.raccourci_barre_espace'("step2")

/*
 * Step 3 : Le player lit un contenu en vitesse accélérée. Appuyer sur la barre espace du clavier
 * 	Expected : Vérifier que le player repasse à vitesse normale.
 */
'Step 3 : Le player lit un contenu en vitesse accélérée. Appuyer sur la barre espace du clavier --> Vérifier que le player repasse à vitesse normale'
CustomKeywords.'vodpckeywords.vodpc_HTML5_Player.raccourci_barre_espace'("step3")

/*
 * Step 4 : Le player est en pause. Appuyer sur la barre espace du clavier
 * 	Expected : Vérifier que le player repasse à vitesse normale.
 */
'Step 4 : Le player est en pause. Appuyer sur la barre espace du clavier --> Vérifier que le player repasse à vitesse normale'
CustomKeywords.'vodpckeywords.vodpc_HTML5_Player.raccourci_barre_espace'("step4")

