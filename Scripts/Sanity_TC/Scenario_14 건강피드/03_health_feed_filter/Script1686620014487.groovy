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

'STEP - 마이페이지 메뉴 선택'
Mobile.tap(findTestObject('04_home/btn_menu_mypage'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 건강피드 선택'
Mobile.tap(findTestObject('06_mypage/btn_healthy_feed'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 건강피드 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '건강피드', FailureHandling.CONTINUE_ON_FAILURE)

//AUTO-61
'STEP - 자녀 필터 선택'
Mobile.tap(findTestObject('14_healthy_feed/txt_child_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 추가된 자녀 선택'
Mobile.tap(findTestObject('14_healthy_feed/txt_filter_list_name', [('text') : GlobalVariable.son]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

//키, 몸무게
'STEP - 보기 필터 선택'
Mobile.tap(findTestObject('14_healthy_feed/btn_filter'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 피드 필터 팝업 노출'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '피드 필터', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 성장 (키, 몸무게) 옵션 선택'
Mobile.tap(findTestObject('14_healthy_feed/txt_filter_list_name', [('text') : '성장 (키, 몸무게)']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 키/몸무게 피드 목록 노출'
Mobile.verifyElementText(findTestObject('14_healthy_feed/btn_filter'), '성장 (키, 몸무게)', FailureHandling.CONTINUE_ON_FAILURE) //보기 필터
Mobile.verifyElementVisible(findTestObject('14_healthy_feed/txt_feed_title', [('text') : '몸무게 10kg']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('14_healthy_feed/txt_feed_title', [('text') : '키 60cm']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

//체온
'STEP - 보기 필터 선택'
Mobile.tap(findTestObject('14_healthy_feed/btn_filter'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 체온 (체온, 해열제) 옵션 선택'
Mobile.tap(findTestObject('14_healthy_feed/txt_filter_list_name', [('text') : '체온 (체온, 해열제)']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 체온 피드 목록 노출'
Mobile.verifyElementText(findTestObject('14_healthy_feed/btn_filter'), '체온 (체온, 해열제)', FailureHandling.CONTINUE_ON_FAILURE) //보기 필터
Mobile.verifyElementVisible(findTestObject('14_healthy_feed/txt_feed_title', [('text') : '39 ℃']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('14_healthy_feed/txt_feed_title', [('text') : '38 ℃']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('14_healthy_feed/txt_feed_title', [('text') : '36 ℃']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

//성장 이벤트
'STEP - 보기 필터 선택'
Mobile.tap(findTestObject('14_healthy_feed/btn_filter'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 성장 이벤트 옵션 선택'
Mobile.tap(findTestObject('14_healthy_feed/txt_filter_list_name', [('text') : '성장 이벤트']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 보기 필터 "성장 이벤트" 노출'
Mobile.verifyElementText(findTestObject('14_healthy_feed/btn_filter'), '성장 이벤트', FailureHandling.CONTINUE_ON_FAILURE)
//

//핉터 리스트 진료완료, 처방전, 영유아검진, 사전문진  추후 진행여부 파악

'STEP - [<-] 이전 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

//등록된 가족 삭제
'등록한 {아들} 자녀 삭제'
Mobile.tap(findTestObject('06_mypage/btn_family'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //가족관리
Mobile.tap(findTestObject('12_family/txt_name_list', [('text') : GlobalVariable.son]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //아들 선택
Mobile.scrollToText('편집') //스크롤 이동
Mobile.tap(findTestObject('12_family/btn_edit'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //[편집]
Mobile.tap(findTestObject('12_family/btn_delete'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //[삭제]
Mobile.tap(findTestObject('00_common/btn_positiveTxt'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //삭제 확인
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //[이전] 버튼
//

'최근앱 삭제'
AndroidDriver<MobileElement> driver = MobileDriverFactory.getDriver()
driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH))
Mobile.tap(findTestObject('00_common_data_delete/btn_all_delete'), 2, FailureHandling.CONTINUE_ON_FAILURE)