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

'STEP - 똑닥 앱 실행'
Mobile.startExistingApplication(GlobalVariable.appid)

'STEP - 마이페이지 메뉴 선택'
Mobile.tap(findTestObject('04_home/btn_menu_mypage'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 이벤트/투표 메뉴 선택'
Mobile.tap(findTestObject('06_mypage/btn_event_vote'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 이벤트/투표 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('13_event_vote/txt_page_event'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 투표 TAB 선택'
Mobile.tap(findTestObject('13_event_vote/btn_tab_vote'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 투표 화면 노출'
if(Mobile.waitForElementPresent(findTestObject('13_event_vote/btn_vote'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) == true)
{
	Mobile.verifyElementNotVisible(findTestObject('13_event_vote/area_progressbar'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}
else
{
	Mobile.verifyElementVisible(findTestObject('13_event_vote/area_progressbar'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP - 이벤트 TAB 선택'
Mobile.tap(findTestObject('13_event_vote/btn_tab_event'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'스크롤 이동'
Mobile.scrollToText('지난 이벤트 보기', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [지난 이벤트 보기] 버튼 선택'
Mobile.tap(findTestObject('13_event_vote/btn_end_event'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 지난 이벤트 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('13_event_vote/txt_page_end_event'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [x] 버튼 선택'
Mobile.tap(findTestObject('13_event_vote/btn_close'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 이벤트/투표 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('13_event_vote/txt_page_event'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [<-] 이전 버튼 선택'
Mobile.tap(findTestObject('13_event_vote/btn_close'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 마이페이지 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('06_mypage/btn_event_vote'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 홈 메뉴 선택'
Mobile.tap(findTestObject('04_home/btn_menu_home'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)


