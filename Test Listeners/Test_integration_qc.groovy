import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.testng.annotations.AfterMethod

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

class Test_integration_qc {
	
	/**
	 * Executes before every test suite starts.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	String user = "A505517"
	String password = "7acyFOI//"
	//initialiser cette variable qui servira de compteur
	int position_of_test_in_test_suite
	String run_id;
	String number_of_test_steps;
	
	
	@BeforeTestSuite
	def sampleBeforeTestSuite(TestSuiteContext testSuiteContext) {
		
		//initialiser cette variable qui servira de compteur pour les tests du test suite
		position_of_test_in_test_suite = 0
		
		//authentification et création d'une session sur QC
		CustomKeywords.'qc_api_client.ClientApi.testHttpClientAuthentication'(user, password)

		
	}
	
	/**
	 * Executes before every test case starts.
	 * @param testCaseContext related information of the executed test case.
	 */
	@BeforeTestCase
	def sampleBeforeTestCase(TestCaseContext testCaseContext) {
		//incrementer
		position_of_test_in_test_suite++
		
		// get test position
		String position = GlobalVariable.positions[position_of_test_in_test_suite - 1]
		
		//get test run id after creating the test run
		run_id = CustomKeywords.'qc_api_client.ClientApi.testHttpClientCreateTestRun'(GlobalVariable.cycle_id,position)
		
		println run_id
		//get all test run steps created
		//trouver un moyen de recupérer les numéros des steps et les mettre à jour sur QC
		number_of_test_steps = CustomKeywords.'qc_api_client.ClientApi.testHttpClientGetAllTestSteps'(run_id)
		
		WebUI.openBrowser("")
		


	}

	/**
	 * Executes after every test case ends.
	 * @param testCaseContext related information of the executed test case.
	 */
	@AfterTestCase
	def sampleAfterTestCase(TestCaseContext testCaseContext) {
	
		String status = testCaseContext.getTestCaseStatus()
		String cycle_id = GlobalVariable.cycle_id
		//String position = GlobalVariable.positions[position_of_test_in_test_suite - 1]
		
		if(status != "PASSED"){
			status = "failed"
		}
		else{
			
			for(int i=1;i<=Integer.parseInt(number_of_test_steps);i++){
				//trouver un moyen de recupérer les numéros des steps et les mettre à jour sur QC
				CustomKeywords.'qc_api_client.ClientApi.testHttpClientValidateStep'(run_id, String.valueOf(i), status)
			}
			
		}
		
		CustomKeywords.'qc_api_client.ClientApi.testHttpClientValidateTest'(cycle_id,status)
		
		WebUI.closeBrowser()
	}
	
	

	
}