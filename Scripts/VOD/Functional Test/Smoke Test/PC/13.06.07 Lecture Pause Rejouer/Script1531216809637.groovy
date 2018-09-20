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
 *              - NE PAS LANCER la bande-annonce d'un contenu
 * 	Expected : Suite à l'un des actions, le player IB est affiché
 *
 */
CustomKeywords.'vodpckeywords.vodpc_connection.connectUser'(GlobalVariable.user_compte, GlobalVariable.password)
CustomKeywords.'vodpckeywords.vodpc_HTML5_Player.playVODContenu'(GlobalVariable.angry_bird_cover)

'Prerequis: Ouvrir un contenu acheté --> Verifier que le player IB est lancé'
CustomKeywords.'vodpckeywords.vodpc_HTML5_Player.playerIB_opened'()

/*
 * Step 2 : Considérer le bouton central à trois états Lecture/Pause/Rejouer de la barre de contrôle. 
 * 			Lire une vidéo à vitesse normale (à tout moment de la vidéo, hors des 5 dernières minutes)
 *  Expected : Vérifier que l'icône est dans l'état Pause.  
 */

'Step 2 : Considérer le bouton central à trois états Lecture/Pause/Rejouer de la barre de contrôle --> Vérifier que l\'icône est dans l\'état Pause.'
CustomKeywords.'vodpckeywords.vodpc_HTML5_Player.vitesse_normale_avancer'(5, "normale")

/*
 * Step 3 : Toujours hors des 5 dernières minutes de la vidéo, passer en vitesse accélérée avant, puis arrière
 *  Expected : Vérifier que l'icône est dans l'état Lecture  
 */

'Step 3a : Toujours hors des 5 dernières minutes de la vidéo, passer en vitesse accélérée avant --> Vérifier que l\'icône est dans l\'état Lecture '
CustomKeywords.'vodpckeywords.vodpc_HTML5_Player.vitesse_normale_avancer'(5, "accelere avant") 

'Step 3b : Toujours hors des 5 dernières minutes de la vidéo, passer en vitesse accélérée arrière --> Vérifier que l\'icône est dans l\'état Lecture '
CustomKeywords.'vodpckeywords.vodpc_HTML5_Player.vitesse_normale_avancer'(5, "accelere arriere")

/*
 * Step 4 : Atteindre la plage des 5 dernières minutes de la vidéo. Etre en mode lecture.
 *  Expected : Vérifier que l'icône est dans l'état Rejouer
 */

'Step 4 : Atteindre la plage des 5 dernières minutes de la vidéo. Etre en mode lecture --> Vérifier que l\'icône est dans l\'état Rejouer'
CustomKeywords.'vodpckeywords.vodpc_HTML5_Player.vitesse_normale_avancer'(0, "normale")

/*
 * Step 5 : Toujours hors des 5 dernières minutes de la vidéo. passer en mode Pause.
 *  Expected : Vérifier que l'icône est dans l'état Lecture
 */

'Step 5 : Toujours hors des 5 dernières minutes de la vidéo. passer en mode Pause --> Vérifier que l\'icône est dans l\'état Lecture.'
CustomKeywords.'vodpckeywords.vodpc_HTML5_Player.vitesse_normale_avancer'(5, "normale pause")

/*
 * Step 6 : Toujours dans les 5 dernières minutes de la vidéo, passer en vitesse accélérée avant, puis arrière.
 *  Expected : Vérifier que l'icône est dans l'état Lecture
 */

'Step 6a : Toujours hors des 5 dernières minutes de la vidéo, passer en vitesse accélérée avant --> Vérifier que l\'icône est dans l\'état Lecture'
CustomKeywords.'vodpckeywords.vodpc_HTML5_Player.vitesse_normale_avancer'(0, "accelere avant")

'Step 6b : Toujours hors des 5 dernières minutes de la vidéo, passer en vitesse accélérée arrière --> Vérifier que l\'icône est dans l\'état Lecture'
CustomKeywords.'vodpckeywords.vodpc_HTML5_Player.vitesse_normale_avancer'(0, "accelere arriere")

/*
 * Step 7 : Toujours dans les 5 dernières minutes de la vidéo, passer en Pause (en appuyant sur espace).
 *  Expected : Vérifier que l'icône est dans l'état Rejouer
 */

'Step 7 : Toujours dans les 5 dernières minutes de la vidéo, passer en Pause (en appuyant sur espace) --> Vérifier que l\'icône est dans l\'état Rejouer'
CustomKeywords.'vodpckeywords.vodpc_HTML5_Player.vitesse_normale_avancer'(0, "normale espace")
