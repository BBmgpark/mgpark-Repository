import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
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

'STEP - 자녀추가 선택'
Mobile.tap(findTestObject('14_healthy_feed/txt_filter_list_name', [('text') : '자녀추가 (12세 미만)']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 자녀추가 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '자녀추가', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 자녀 이름 입력'
Mobile.setText(findTestObject('12_family/input_add_family_name'), GlobalVariable.son, GlobalVariable.fixedTime)

'STEP - 주민번호 앞자리 입력'
Mobile.setText(findTestObject('12_family/input_add_ssn_front_number'), GlobalVariable.son_birth_date, GlobalVariable.fixedTime)

'STEP - 주민번호 뒷자리 영역 선택'
Mobile.tap(findTestObject('12_family/input_add_ssn_back_number'), GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE)

'STEP - 주민번호 뒷자리 입력'
for(i = 1; i <= 7; i++)
{
	Mobile.tap(findTestObject('12_family/btn_keypad_number_3'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'스크롤 이동'
Mobile.scrollToText('고유식별정보의 수집 및 이용 동의')

'STEP - 자녀 대리 접수 동의 체크 선택'
Mobile.tap(findTestObject('12_family/btn_add_use', [('text') : '자녀 대리 접수 동의']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 고유식별정보의 수집 및 이용 동의 체크 선택'
Mobile.tap(findTestObject('12_family/btn_add_use', [('text') : '고유식별정보의 수집 및 이용 동의']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [완료] 버튼 선택'
Mobile.tap(findTestObject('12_family/btn_add_complet'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 건강피드 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '건강피드', FailureHandling.CONTINUE_ON_FAILURE)
//

'STEP - 자녀 필터 선택'
Mobile.tap(findTestObject('14_healthy_feed/txt_child_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 추가된 자녀 선택'
Mobile.tap(findTestObject('14_healthy_feed/txt_filter_list_name', [('text') : GlobalVariable.son]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

//건강피드 TAB에서 키 등록
'STEP - [+] 버튼 선택'
Mobile.tap(findTestObject('14_healthy_feed/btn_add'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [키 등록] 선택'
Mobile.tap(findTestObject('14_healthy_feed/txt_add', [('text') : '키 등록']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 성장관리 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '성장관리', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 키 입력 영역 선택'
Mobile.tap(findTestObject('14_healthy_feed/txt_growth'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 키 직접 입력 팝업 노출'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '키 직접 입력', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 키 입력'
Mobile.setText(findTestObject('14_healthy_feed/input_number'), '50', GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [확인] 선택'
Mobile.tap(findTestObject('14_healthy_feed/btn_positive'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 등록한 키 데이터 노출'
Mobile.verifyElementText(findTestObject('14_healthy_feed/txt_growth'), '50cm', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [등록 완료] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_confirmBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 성장관리 tab 화면 노출'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '건강피드', FailureHandling.CONTINUE_ON_FAILURE) //page title
Mobile.verifyElementVisible(findTestObject('14_healthy_feed/btn_left_switch'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //키 스위치 상태
Mobile.verifyElementVisible(findTestObject('14_healthy_feed/btn_right'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //몸무게 

'기대결과 - 등록한 키 데이터 노출'
Mobile.verifyElementVisible(findTestObject('14_healthy_feed/txt_height_weight', [('text') : '50cm']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //50cm 문구 포함
//

//키 등록 (성장관리)
'STEP - [+] 버튼 선택'
Mobile.tap(findTestObject('14_healthy_feed/btn_add'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [키 등록] 선택'
Mobile.tap(findTestObject('14_healthy_feed/txt_add', [('text') : '키 등록']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 성장관리 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '성장관리', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 키 입력 영역 선택'
Mobile.tap(findTestObject('14_healthy_feed/txt_growth'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 키 직접 입력 팝업 노출'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '키 직접 입력', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 키 입력'
Mobile.setText(findTestObject('14_healthy_feed/input_number'), '60', GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [확인] 선택'
Mobile.tap(findTestObject('14_healthy_feed/btn_positive'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 등록한 키 데이터 노출'
Mobile.verifyElementText(findTestObject('14_healthy_feed/txt_growth'), '60cm', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [등록 완료] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_confirmBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 건강피드 화면 성장관리 tab 노출'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '건강피드', FailureHandling.CONTINUE_ON_FAILURE) //page title
Mobile.verifyElementVisible(findTestObject('14_healthy_feed/btn_left_switch'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //키 스위치 상태
Mobile.verifyElementVisible(findTestObject('14_healthy_feed/btn_right'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //몸무게

'기대결과 - 등록한 키 데이터 노출'
Mobile.verifyElementVisible(findTestObject('14_healthy_feed/txt_height_weight', [('text') : '60cm']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //60cm 문구 포함
//

//몸무게 등록 (건강피드)
'STEP - 건강피드 tab 선택'
Mobile.tap(findTestObject('14_healthy_feed/btn_tab', [('text') : '건강피드']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [+] 버튼 선택'
Mobile.tap(findTestObject('14_healthy_feed/btn_add'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [몸무게 등록] 선택'
Mobile.tap(findTestObject('14_healthy_feed/txt_add', [('text') : '몸무게 등록']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 성장관리 화면 노출'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '성장관리', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 몸무게 입력 영역 선택'
Mobile.tap(findTestObject('14_healthy_feed/txt_growth'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 몸무게 직접 입력 팝업 노출'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '몸무게 직접 입력', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 몸무게 입력'
Mobile.setText(findTestObject('14_healthy_feed/input_number'), '5', GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [확인] 선택'
Mobile.tap(findTestObject('14_healthy_feed/btn_positive'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 등록한 몸무게 데이터 노출'
Mobile.verifyElementText(findTestObject('14_healthy_feed/txt_growth'), '5kg', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [등록 완료] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_confirmBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 성장관리 tab에 등록한 몸무게 노출'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '건강피드', FailureHandling.CONTINUE_ON_FAILURE) //page title
Mobile.verifyElementVisible(findTestObject('14_healthy_feed/btn_left'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //키 
Mobile.verifyElementVisible(findTestObject('14_healthy_feed/btn_right_switch'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //몸무게 스위치 상태
Mobile.verifyElementVisible(findTestObject('14_healthy_feed/txt_height_weight', [('text') : '5kg']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //50cm 문구 포함
//

//몸무게 등록 (성장관리)
'STEP - [+] 버튼 선택'
Mobile.tap(findTestObject('14_healthy_feed/btn_add'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [몸무게 등록] 선택'
Mobile.tap(findTestObject('14_healthy_feed/txt_add', [('text') : '몸무게 등록']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 성장관리 화면 노출'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '성장관리', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 몸무게 입력 영역 선택'
Mobile.tap(findTestObject('14_healthy_feed/txt_growth'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 몸무게 직접 입력 팝업 노출'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '몸무게 직접 입력', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 몸무게 입력'
Mobile.setText(findTestObject('14_healthy_feed/input_number'), '10', GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [확인] 선택'
Mobile.tap(findTestObject('14_healthy_feed/btn_positive'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 등록한 몸무게 데이터 노출'
Mobile.verifyElementText(findTestObject('14_healthy_feed/txt_growth'), '10kg', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [등록 완료] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_confirmBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 성장관리 tab에 등록한 몸무게 노출'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '건강피드', FailureHandling.CONTINUE_ON_FAILURE) //page title
Mobile.verifyElementVisible(findTestObject('14_healthy_feed/btn_left'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //키
Mobile.verifyElementVisible(findTestObject('14_healthy_feed/btn_right_switch'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //몸무게 스위치 상태
Mobile.verifyElementVisible(findTestObject('14_healthy_feed/txt_height_weight', [('text') : '10kg']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //50cm 문구 포함
//

//홈 화면 이동
'STEP - [<-] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'최근앱 삭제'
AndroidDriver<MobileElement> driver = MobileDriverFactory.getDriver()
driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH))
Mobile.tap(findTestObject('00_common_data_delete/btn_all_delete'), 2, FailureHandling.CONTINUE_ON_FAILURE)