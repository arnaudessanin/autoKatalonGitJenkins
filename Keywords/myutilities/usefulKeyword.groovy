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

import internal.GlobalVariable

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
}
