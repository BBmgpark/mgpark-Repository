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

//체온 등록 (정상)
'STEP - [+] 버튼 선택'
Mobile.tap(findTestObject('14_healthy_feed/btn_add'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [체온 등록] 선택'
Mobile.tap(findTestObject('14_healthy_feed/txt_add', [('text') : '체온 등록']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 체온관리 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '체온관리', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 체온 입력 영역 선택'
Mobile.tap(findTestObject('14_healthy_feed/txt_temperature'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 체온 직접 입력 팝업 노출'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '체온 직접 입력', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 체온 입력'
Mobile.setText(findTestObject('14_healthy_feed/input_number'), '36', GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [확인] 선택'
Mobile.tap(findTestObject('14_healthy_feed/btn_positive'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 등록한 키 데이터 노출'
Mobile.verifyElementText(findTestObject('14_healthy_feed/txt_temperature'), '36°C', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [등록 완료] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_confirmBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 건강피드 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '건강피드', FailureHandling.CONTINUE_ON_FAILURE) 

'기대결과 - 등록한 체온 데이터 노출'
Mobile.verifyElementText(findTestObject('14_healthy_feed/txt_temperature_complete'), '36 ℃', FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 체온 상태 문구 노출'
Mobile.verifyElementText(findTestObject('14_healthy_feed/txt_temperature_state'), '정상 체온 상태', FailureHandling.CONTINUE_ON_FAILURE) 
//

//체온 등록 (미열)
'STEP - [+] 버튼 선택'
Mobile.tap(findTestObject('14_healthy_feed/btn_add'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [체온 등록] 선택'
Mobile.tap(findTestObject('14_healthy_feed/txt_add', [('text') : '체온 등록']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 체온관리 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '체온관리', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 체온 입력 영역 선택'
Mobile.tap(findTestObject('14_healthy_feed/txt_temperature'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 체온 직접 입력 팝업 노출'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '체온 직접 입력', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 체온 입력'
Mobile.setText(findTestObject('14_healthy_feed/input_number'), '38', GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [확인] 선택'
Mobile.tap(findTestObject('14_healthy_feed/btn_positive'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 등록한 체온 데이터 노출'
Mobile.verifyElementText(findTestObject('14_healthy_feed/txt_temperature'), '38°C', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [등록 완료] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_confirmBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 건강피드 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '건강피드', FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 등록한 체온 데이터 노출'
Mobile.verifyElementText(findTestObject('14_healthy_feed/txt_temperature_complete'), '38 ℃',FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 체온 상태 문구 노출'
Mobile.verifyElementText(findTestObject('14_healthy_feed/txt_temperature_state'), '미열 상태', FailureHandling.CONTINUE_ON_FAILURE)
//

//체온 등록 (고열)
'STEP - [+] 버튼 선택'
Mobile.tap(findTestObject('14_healthy_feed/btn_add'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [체온 등록] 선택'
Mobile.tap(findTestObject('14_healthy_feed/txt_add', [('text') : '체온 등록']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 체온관리 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '체온관리', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 체온 입력 영역 선택'
Mobile.tap(findTestObject('14_healthy_feed/txt_temperature'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 체온 직접 입력 팝업 노출'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '체온 직접 입력', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 체온 입력'
Mobile.setText(findTestObject('14_healthy_feed/input_number'), '39', GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [확인] 선택'
Mobile.tap(findTestObject('14_healthy_feed/btn_positive'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 등록한 체온 데이터 노출'
Mobile.verifyElementText(findTestObject('14_healthy_feed/txt_temperature'), '39°C', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [등록 완료] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_confirmBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 건강피드 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '건강피드', FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 등록한 체온 데이터 노출'
Mobile.verifyElementText(findTestObject('14_healthy_feed/txt_temperature_complete'), '39 ℃',FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 체온 상태 문구 노출'
Mobile.verifyElementText(findTestObject('14_healthy_feed/txt_temperature_state'), '고열 상태', FailureHandling.CONTINUE_ON_FAILURE)
//

//홈 화면 이동
'STEP - [<-] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'최근앱 삭제'
AndroidDriver<MobileElement> driver = MobileDriverFactory.getDriver()
driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH))
Mobile.tap(findTestObject('00_common_data_delete/btn_all_delete'), 2, FailureHandling.CONTINUE_ON_FAILURE)