package qc_api_client

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import com.kms.katalon.core.util.KeywordUtil as console

import javax.ws.rs.client.Client
import javax.ws.rs.client.ClientBuilder
import javax.ws.rs.client.Entity
import javax.ws.rs.client.WebTarget
import javax.ws.rs.core.Response


public class ClientApi {

	Client client = ClientBuilder.newClient();
	String run_id;

	String connect_url = "http://localhost:8001/katalon-qc/almapi/connect/post"
	String getall_url = "http://localhost:8001/katalon-qc/almapi/test/getall/"
	String createRun_url = "http://localhost:8001/katalon-qc/almapi/test/run/"
	String validateTest = "http://localhost:8001/katalon-qc/almapi/test/validate/"
	String validateStep = "http://localhost:8001/katalon-qc/almapi/run/validate/run/"
	String getallSteps_url = "http://localhost:8001/katalon-qc/almapi/run/steps/"

	@Keyword
	def testHttpClientAuthentication(String username, String password){

		String url = connect_url;
		String xml = "<alm-authentication><user>"+username+"</user><password>"+password+"</password></alm-authentication>"

		WebTarget target = client.target(url);

		Response response = target.request().post(Entity.xml(xml));

		String output = response.readEntity(String.class);

		if(response.getStatus() == 200){

			console.markPassed(output)
			testHttpClientGetAllTest(GlobalVariable.cycle_id)
		}
		else{

			console.markFailed(output)
		}
	}

	def testHttpClientGetAllTest(String cycle_id){

		String url = getall_url+cycle_id;

		WebTarget target = client.target(url);

		Response response = target.request().get();

		if(response.getStatus() == 200){
			println "got all test"
		}
		else{
			println "does not work"
		}
	}

	@Keyword
	def testHttpClientCreateTestRun(String cycle_id, String position){

		String url = createRun_url+cycle_id+"/"+position;

		WebTarget target = client.target(url);

		Response response = target.request().post(null);

		String output = response.readEntity(String.class);

		if(response.getStatus() == 200){

			console.markPassed(output)

			return output.split()[5]

			//return run_id;
		}
		else{

			console.markFailed(output)
			return null;
		}
	}

	@Keyword
	def testHttpClientValidateTest(String cycle_id, String status){

		String url = validateTest+cycle_id+"/"+status;

		WebTarget target = client.target(url);

		Response response = target.request().post(null);

		String output = response.readEntity(String.class);

		if(response.getStatus() == 200){

			console.markPassed(output)
		}
		else{

			console.markFailed(output)
		}
	}

	@Keyword
	def testHttpClientValidateStep(String run_id, String position, String status){

		String url = validateStep+run_id+"/step/"+position+"/"+status;

		WebTarget target = client.target(url);

		Response response = target.request().post(null);

		String output = response.readEntity(String.class);

		if(response.getStatus() == 200){

			console.markPassed(output)

		}
		else{

			console.markFailed(output)
			//return null;
		}
	}

	@Keyword
	def testHttpClientGetAllTestSteps(String run_id){

		String url = getallSteps_url+run_id;

		WebTarget target = client.target(url);

		Response response = target.request().get();
		
		String output = response.readEntity(String.class);

		if(response.getStatus() == 200){
			return output
		}
		else{
			return "no test steps"
		}
	}
}

