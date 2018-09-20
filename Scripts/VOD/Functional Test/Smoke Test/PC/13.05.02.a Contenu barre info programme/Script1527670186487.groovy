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
 * Prérequis : Etre dans l'un des cas suivants:
 * 				- être en fin de processus d'achat ou de location de contenu
 * 				- avoir auparavant loué ou acheté un contenu et le lancer depuis "Mes vidéos" (il est donc encore
 * 					encours de validité)
 * 				- lancer la bande annonce d'un contenu 
 * 				- Disposer d'un contenu avec cover
 * 				- disposer d'un contenu sans cover 
 * 				- disposer d'un contenu non épisode
 * 				- disposer d'un contenu ayant un code CSA 1
 * 				- disposer d'un contenu ayant un code différent de 1
 * 	Expected : Suite à l'un des actions, le player IB est affiché
 * 
 */ 
CustomKeywords.'vodpckeywords.vodpc_HTML5_Player.playVODContenu'(GlobalVariable.angry_bird_cover)

'Prerequis: Ouvrir une bande annonce --> Verifier que le player IB est lancé'
CustomKeywords.'vodpckeywords.vodpc_HTML5_Player.playerIB_opened'()

/*
 * Step 2: Consulter la barre info programme d'un contenu ayant une cover
 *  Expected : Verifier que la barre info programme contient a gauche la cover de cette video
 *			  Les informations sont a droite de cette cover (a commencer par le titre)
 */

'Step 2: consulter barre info programme d\'un contenu ayant une cover --> verification cover, titre et genre'
CustomKeywords.'vodpckeywords.vodpc_HTML5_Player.zip_verif_cover_titre_genre'("cover","titre","genre")

/*
 * Step 3 :  Consulter la barre info programme d'un contenu n'ayant pas de cover
 * 	Expected : Verifier que la barre info programme contient a gauche les informations de cette vidéo (a commencer par le titre)
 */
CustomKeywords.'vodkeyword.vod_identification.playVODContenu'(GlobalVariable.jeune_et_jolie_sans_cover)
WebUI.delay(15) // ce delay est indispensable puisque ce contenu a un code CSA différent de 1 donc il faut retarder de x sec

'Step 3: consulter barre info programme d\'un contenu n\'ayant pas une cover --> verification pas cover, titre et genre'
CustomKeywords.'vodpckeywords.vodpc_HTML5_Player.zip_verif_cover_titre_genre'("sans cover","titre","genre")

/*
 * Step 4 :  Consulter la barre info programme d'un contenu non épisode
 * 	Expected : Verifier que la la première ligne contient le titre de la vidéo
 */
CustomKeywords.'vodpckeywords.vodpc_HTML5_Player.playVODContenu'(GlobalVariable.angry_bird_cover)
WebUI.delay(5) // attendre un peu que la vidéo commence avant de chercher à savoir le titre

'Step 4: consulter barre info programme d\'un contenu non épisode --> verification du titre de la vidéo'
CustomKeywords.'vodpckeywords.vodpc_HTML5_Player.zip_verif_cover_titre_genre'("rien","titre","rien") 

/*
 * Step 5 : Consulter la barre info programme d'un contenu avec un code CSA différent de 1
 * 	Expected : Vérifier que l'icône CSA est affichée dans la barre d'info programme, à droite du titre
 */
CustomKeywords.'vodkeyword.vod_identification.playVODContenu'(GlobalVariable.jeune_et_jolie_sans_cover)
WebUI.delay(10) // ce delay est indispensable puisque ce contenu a un code CSA différent de 1 donc il faut retarder de x sec


'Step 5 : Vérifier que l\'icône CSA est affichée dans la barre d\'info programme, à droite du titre'
CustomKeywords.'vodpckeywords.vodpc_HTML5_Player.codeCSA_barre_info_programme'()

