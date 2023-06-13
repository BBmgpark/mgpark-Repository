import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

'설정'
Mobile.startExistingApplication('com.android.settings')

Mobile.delay(1)

Mobile.swipe(45, 2000, 45, 500)
Mobile.swipe(45, 2000, 45, 500)

'애플리케이션'
Mobile.tap(findTestObject('00_common_data_delete/txt_textview', [('text') : '애플리케이션']), 2)

Mobile.delay(1)

'검색'
Mobile.tap(findTestObject('00_common_data_delete/btn_search'), 2)

'똑닥 검색'
Mobile.setText(findTestObject('00_common_data_delete/input_search'), '똑닥', 2)

'똑닥 선택'
Mobile.tap(findTestObject('00_common_data_delete/txt_title', [('text') : '똑닥']), 2)

'저장공간'
Mobile.tap(findTestObject('00_common_data_delete/txt_title', [('text') : '저장공간']), 2)

'데이터삭제'
Mobile.tap(findTestObject('00_common_data_delete/btn_data_delete'), 2)

if(Mobile.waitForElementPresent(findTestObject('00_common_data_delete/btn_delete'), 2) == true)
{
'삭제'
Mobile.tap(findTestObject('00_common_data_delete/btn_delete'), 2)
}