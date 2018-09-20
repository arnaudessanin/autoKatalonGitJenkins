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

//WebUI.callTestCase(findTestCase('VOD/Functional Test/Smoke Test/PC/13.01.Structure du player'), [:], FailureHandling.STOP_ON_FAILURE)

/*
 * Prérequis : Etre dans l'un des cas suivants:
 * 				- être en fin de processus d'achat ou de location de contenu
 * 				- avoir auparavant loué ou acheté un contenu et le lancer depuis "Mes vidéos" (il est donc encore
 * 					encours de validité)
 * 				- lancer la bande annonce d'un contenu
 */

'Prerequis: Lancer la bande annonce d\'un contenu'
CustomKeywords.'vodmobilekeywords.vodmobile_HTML5_Player.playVODContenu'(GlobalVariable.angry_bird_cover)

/*
 * Step2: le player IB VOD s'affiche --> verifier que le player IB VOD s'affiche
 *
 */

'STEP 2 : Le player IB VOD s\'affiche --> vérifier que le player IB VOD s\'affiche'
CustomKeywords.'vodpckeywords.vodpc_HTML5_Player.playerIB_opened'()

/*
 * Step3: Il est composé de quatre grandes zones:
 * 			- la barre de menus, qui permet d'accéder aux différents écrans du player
 * 			- la zone de visualisation du flux
 * 			- la zone info programme qui affiche des informations liées au programme en cours
 * 			- la barre de contrôle, qui permet à l'utilisateur de contôler le player
 * 		Expected: vérifier qu'il est composé de ces quatre zones citées ci-dessus
 */

'STEP 3 : vérifier qu\'il est composé de : barre de menus, zone de flux, zone info programme, barre de contrôle'
CustomKeywords.'vodpckeywords.vodpc_HTML5_Player.PlayerVOD_Structure'()

WebUI.delay(5)

