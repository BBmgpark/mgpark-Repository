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
import io.appium.java_client.android.nativekey.AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.AppiumDriver
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.MobileElement

'STEP - 똑닥 앱 실행'
Mobile.startExistingApplication(GlobalVariable.appid)

//찜한목록 진입
'STEP - 찜한 목록 [☆] 버튼 선택'
Mobile.tap(findTestObject('04_home/btn_frame_favorite'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.delay(1)

'기대결과 - 찜한 목록 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '찜한 목록', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime)

'기대결과 - 홈 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('04_home/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //홈 메뉴(활성화)
//

//병원 찾기
'STEP - [☆]  홈 찜한 목록 버튼 선택'
Mobile.tap(findTestObject('04_home/btn_frame_favorite'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 찜한 목록 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '찜한 목록', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [병원 찾기] 버튼 선택'
Mobile.tap(findTestObject('08_favorits/btn_find_hospital'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('04_home/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //홈 메뉴(활성화)
//

//약국 찾기
'STEP - [☆]  홈 찜한 목록 버튼 선택'
Mobile.tap(findTestObject('04_home/btn_frame_favorite'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 찜한 목록 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '찜한 목록', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 찜한 약국 tab 선택'
Mobile.tap(findTestObject('08_favorits/txt_tab_drugstore'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 찜한 약국 TAB 화면 노출'
Mobile.verifyElementText(findTestObject('08_favorits/txt_empty_title'), '찜한 약국이 없어요.', FailureHandling.CONTINUE_ON_FAILURE) //타이틀
Mobile.verifyElementVisible(findTestObject('08_favorits/btn_find_drugstore'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //[약국 찾기] 버튼

'STEP - [약국 찾기] 버튼 선택'
Mobile.tap(findTestObject('08_favorits/btn_find_drugstore'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 네이버 지도 화면으로 이동'
if(GlobalVariable.adress_name == '상동')
{
'기대결과 - "상동 약국" 타이틀 노출'
Mobile.verifyElementText(findTestObject('00_common/txt_toolbarText'), '상동 약국', FailureHandling.CONTINUE_ON_FAILURE)
}
else
{
'기대결과 - "여의도동 약국" 타이틀 노출'
Mobile.verifyElementText(findTestObject('00_common/txt_toolbarText'), '여의도동 약국', FailureHandling.CONTINUE_ON_FAILURE)
}

'기대결과 - [현위치] 버튼 노출'
Mobile.verifyElementVisible(findTestObject('00_common/btn_userLocationBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - [연중무휴] 버튼 노출'
Mobile.verifyElementVisible(findTestObject('00_common/btn_layout'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

//홈
'STEP - 뒤로가기 버튼 선택'
Mobile.pressBack(FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('04_home/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //홈 메뉴(활성화)
//

'최근앱 삭제'
AndroidDriver<MobileElement> driver = MobileDriverFactory.getDriver()
driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH))
Mobile.tap(findTestObject('00_common_data_delete/btn_all_delete'), 2, FailureHandling.CONTINUE_ON_FAILURE)
