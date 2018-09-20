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
CustomKeywords.'vodpckeywords.vodpc_MesFavoris.gotoMesFavoris'()
/*
 * Prérequis : Etant donné un utilisateur ayant demandé la suppression de tous ses favoris
 *  Expected : 
 */

/*
 * Step 1 : Lorsqu'il clique sur le bouton de confirmation  
 *  Expected : Vérifier alors que tous les favoris sont supprimés et la pop-in disparaît.
 */
'Step 1 : Lorsqu\'il clique sur le bouton de confirmation --> Vérifier alors que tous les favoris sont supprimés et la pop-in disparaît.'
CustomKeywords.'vodpckeywords.vodpc_MesFavoris.clickBoutonPopinConfirmation'()



