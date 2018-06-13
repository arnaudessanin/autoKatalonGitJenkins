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

//STEP 1
//***** Description: Etant donné un utilisateur EW, lorsqu'il se connecte
//***** Expected: Vérifier que l'utilisateur est connecté ****

'Connexion utilisateur EW '
CustomKeywords.'vodkeyword.vod_identification.idVOD'(user_compte, password)

//STEP 2
// **** Description: Afficher le composant Mes vidéos (user EW)
// **** Expected: vérifier qu'un texte en surimpression de l'image est affiché avec:
//					- Titre << Voir et revoir vos vidéos louées ou achetées >>
//					- les libellés << Retrouvez et visionnez les vidéos louées ou achetées sur ordinateur, TV, 
//					  tablette, smartphone et Clé TV. >>
//					- et << Téléchargez-les sur le lectur VOD Orange pour les visionner sans connexion. >>
'Affichage composant Mes vidéos'
CustomKeywords.'vodkeyword.vod_identification.menuConvergentVOD'('Mes vidéos')

'Verification texte en surimpression '
String titre_banner = WebUI.getText(findTestObject('VOD Objects/PC/Menu Convergeant Mes videos/titre banner-marketing'))
String titre1 = WebUI.getText(findTestObject('VOD Objects/PC/Menu Convergeant Mes videos/titre1 banner-marketing'))
String titre2 = WebUI.getText(findTestObject('VOD Objects/PC/Menu Convergeant Mes videos/titre2 banner-marketing'))

'Verify match'
WebUI.verifyMatch(titre_banner, "Voir et revoir vos vidéos louées ou achetées" , false)

WebUI.verifyMatch(titre1, "Retrouvez et visionnez les vidéos louées ou achetées sur ordinateur, TV, tablette, smartphone et Clé TV." , false)

WebUI.verifyMatch(titre2, "Téléchargez-les sur le lecteur VOD Orange pour les visionner sans connexion." , false)

'close browser'
WebUI.closeBrowser()


 


