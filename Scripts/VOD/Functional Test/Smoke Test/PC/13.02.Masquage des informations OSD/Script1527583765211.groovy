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

/*
 * Prerequis : Avoir un contenu loué ou acheté en cours de validit� dans "Mes Videos" ou lancer la bande annonce d'un contenu
 * 		Expected: Afficher le player IB
 */
CustomKeywords.'vodpckeywords.vodpc_HTML5_Player.playVODContenu'(GlobalVariable.angry_bird_cover)

'Prerequis: Ouvrir une bande annonce --> Verifier que le player IB est lancé'
CustomKeywords.'vodpckeywords.vodpc_HTML5_Player.playerIB_opened'()

/*
 * STEP 2: Utiliser sa souris (deplacement au dessus du player, ou clic sur des controles)
 * 		Expected : Des informations (les différentes barres) sont affichées au-dessus de la video
 */

'STEP 2 : Affichage au dessus de la vidéo --> player menu, zone info programme, zone de flux, barre de controle'
CustomKeywords.'vodpckeywords.vodpc_HTML5_Player.PlayerVOD_Structure'()

/*
 * STEP 3 : Faire en sorte que le curseur survole la barre d'information programme ou la barre de controle.
 * 		Expected : Des informations sont affichees au-dessus de la video
 */

WebUI.delay(6)

'STEP 3: Survole barre info programme --> Affichage au dessus de la vidéo: player menu, zone info programme, zone de flux, barre de controle'
CustomKeywords.'vodpckeywords.vodpc_HTML5_Player.PlayerVOD_Structure'()

/*
 * Step 4 : Laisser passer 5 secondes concecutives pendant laquelle:
 * 			- l'utilisateur ne joue pas avec la souris,
 * 			- et le curseur ne survole ni la barre de menu, ni la barre d'information, ni la barre de controle
 * 		Expected : Verifier que la barre de menu, la zone info programme et la bare de controle s'efaccent automatiquement. 
 * 					L'ensemble de la zone player est alors dediée à jouer le flux video.
 */

'STEP 4: Laissez passer 5 sec --> vérifier que la barre de menu, la zone info programme et la barre de controle s\'efaccent automatiquement'
CustomKeywords.'vodpckeywords.vodpc_HTML5_Player.PlayerVOD_Structure_Masquee'()
