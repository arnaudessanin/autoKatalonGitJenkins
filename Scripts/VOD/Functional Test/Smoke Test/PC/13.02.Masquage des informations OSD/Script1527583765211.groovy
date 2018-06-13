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
import com.kms.katalon.core.util.KeywordUtil as console

//Prerequis 
//***** Description: Avoir un contenu lou� ou achet� en cours de validit� dans "Mes Vid�os"
//					 ou lancer la bande annonce d'un contenu
//***** Expected: Afficher le player IB **** 
'Prerequis'

'Open browser'
WebUI.openBrowser('')

'maximize window'
WebUI.maximizeWindow()

'play content'
CustomKeywords.'vodkeyword.vod_identification.playVODContenu'(GlobalVariable.angry_bird_cover)

'Verifier que le player est lancé'
TestObject video = findTestObject('VOD Objects/PC/Video Player/player')

'Verifier que le player est lancé'
if (CustomKeywords.'vodkeyword.vod_identification.IsVODPlayingOnFirstTime'(video)) {
    //if it plays the first time it opens
    console.markPassed('Player IB is opened and video is playing')
} else {
    console.markFailedAndStop('Player IB not opened')
}

//STEP 2
//**** Description: Utiliser sa souris (deplacement au dessus du player, ou clic sur des controles) *****
//**** Expected : Des informations (les diff�rentes barres) sont affich�es au-dessus de la video **** 
'STEP 2'

'mouse hover on play button'
WebUI.mouseOver(findTestObject('VOD Objects/PC/Video Player/Barre de control player/play button'))

'delay 1s'
WebUI.delay(1)

'Check player structure'
CustomKeywords.'vodkeyword.vod_identification.PlayerVOD_Structure'()

//STEP 3
//**** Description: Faire en sorte que le curseur survole la barre d'information programme ou la barre 
//                  de controle.
//**** Expected : Des informations sont affichees au-dessus de la video
'STEP 3'

'delay 5s'
WebUI.delay(5)

'mouse hover on menu'
WebUI.mouseOver(findTestObject('VOD Objects/PC/Video Player/Barre menu player/barre menu'))

'delay 1s'
WebUI.delay(1)

'Check player structure'
CustomKeywords.'vodkeyword.vod_identification.PlayerVOD_Structure'()

//STEP 4
//**** Description: Laisser passer 5 secondes concecutives pendant laquelle:
//                  - l'utilisateur ne joue pas avec la souris,
//	                - et le curseur ne survole ni la barre de menu, ni la barre d'information, 
//                    ni la barre de controle
//**** Expected : Verifier que la barre de menu, la zone info programme et la bare de controle 
//                s'efaccent automatiquement. L'ensemble de la zone player est alors dediée à 
//                jouer le flux video. 
'STEP 4'

'mouse hover on menu'
WebUI.mouseOver(findTestObject('VOD Objects/PC/Video Player/Barre menu player/barre menu'))

'delay 7s'
WebUI.delay(6)

'Verify barre menu not present'
WebUI.verifyElementPresent(findTestObject('VOD Objects/PC/Video Player/Barre menu player/barre menu masquage'), 
    1, FailureHandling.CONTINUE_ON_FAILURE)

'Verify barre de control not present'
WebUI.verifyElementPresent(findTestObject('VOD Objects/PC/Video Player/Barre de control player/barre de control masquage'), 
    1, FailureHandling.CONTINUE_ON_FAILURE)

'Verifiy zip not present'
WebUI.verifyElementPresent(findTestObject('VOD Objects/PC/Video Player/Zone Info Prog/zone info prog masquage'), 
    1, FailureHandling.CONTINUE_ON_FAILURE)

'Close browser'
WebUI.closeBrowser()
