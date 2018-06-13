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

//Pr�requis
// **** Description : Etre dans l'un des cas suivants:
// - Avoir une vid�o lou�e ou achet�e en cours de validit� 
// - ou lancer une bande annonce d'un contenu disposant avec cover (Angry Bird)
// - disposer d'un contenu sans cover
// - " " " non �pisode 
// - " " " ayant un code CSA 1
// - " " " " " " " " " diff�rent de 1
// **** Expected : A la suite de l'une de ces actions, le player IB s'afiche

'Open browser'
WebUI.openBrowser("")

'Maximize windows'
WebUI.maximizeWindow()

'Play VOD content angry bird'
CustomKeywords.'vodkeyword.vod_identification.playVODContenu'(GlobalVariable.angry_bird_cover)

'definir le tag video'
TestObject video = findTestObject('VOD Objects/PC/Video Player/player')

'Check if player IB has started'
if (CustomKeywords.'vodkeyword.vod_identification.IsVODPlayingOnFirstTime'(video)) {
	console.markPassed("Player IB is opened and video is playing")
}
else{
	console.markFailedAndStop("Player IB not opened")
}

//STEP 2
//**** Description: Consulter la barre info programme d'un contenu ayant une cover *****
//**** Expected : Verifier que la barre info programme contient a gauche la cover de cette video
//				  Les informations sont a droite de cette cover (a commencer par le titre) ****

'Zone Info Programme: Verification cover, titre et genre'
CustomKeywords.'vodkeyword.vod_identification.zip_verif_cover_titre_genre'()

//STEP 3
//**** Description: Consulter la barre info programme d'un contenu n'ayant pas de cover *****
//**** Expected : Verifier que la barre info programme contient a gauche Les informations   
//				   de cette vidéo (a commencer par le titre) ****

'Lancer un contenu sans cover'
CustomKeywords.'vodkeyword.vod_identification.playVODContenu'(GlobalVariable.jeune_et_jolie_sans_cover)

'delay 5s'
WebUI.delay(5)

'Verifier qu il n y a pas de cover'
CustomKeywords.'vodkeyword.vod_identification.zip_verif_cover_titre_genre'()



