package myutilities

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import com.kms.katalon.core.testobject.ConditionType

import org.apache.http.client.HttpClient
import org.apache.http.impl.client.HttpClientBuilder
import org.apache.http.client.methods.HttpGet
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import internal.GlobalVariable
import com.kms.katalon.core.util.KeywordUtil as console

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public class usefulKeyword {

	@Keyword
	def screenShot(){

		/*
		 * 
		 */
		WebUI.takeScreenshot()
	}

	@Keyword
	String getTextInsideDiv(String SelectorName, String Selector){

		switch(SelectorName){

			case "cssSelector" :
				String script = "return window.document.querySelector('"+Selector+"').textContent"
				return WebUI.executeJavaScript(script, null)
				break
			case "Id":
				return "à implémenter"
				break
			default:
				return "Selector not regognized"
				break
		}
	}

	@Keyword
	static TestObject makeTO(String selectorName, String selector) {
		TestObject to = new TestObject()

		switch(selectorName){

			case "css":
				to.addProperty("css", ConditionType.EQUALS, selector)
				return to
				break
			case "xpath":
				to.addProperty("xpath", ConditionType.EQUALS, selector)
				return to
				break
			default:
				return null
				break
		}
	}

	@Keyword
	def testHttpClient(){

		try {

			// create HTTP Client
			HttpClient httpClient = HttpClientBuilder.create().build();

			// Create new getRequest with below mentioned URL
			HttpGet getRequest = new HttpGet("http://localhost:8000/katalon-qc/almapi/myresource");

			// Add additional header to getRequest which accepts application/xml data
			getRequest.addHeader("accept", "application/xml");

			// Execute your request and catch response
			HttpResponse response = httpClient.execute(getRequest);

			// Check for HTTP response code: 200 = success
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
			}

			// Get-Capture Complete application/xml body response
			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
			String output;
			System.out.println("============Output:============");

			// Simply iterate through XML response and show on console.
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
			console.markPassed("Session created with HP ALM QC")

		} catch (ClientProtocolException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

