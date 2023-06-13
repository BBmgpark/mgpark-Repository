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
import java.util.Calendar as Calendar
import java.util.Date as Date
import java.time.DayOfWeek as DayOfWeek
import java.time.LocalDate;
import io.appium.java_client.android.nativekey.AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.AppiumDriver
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.MobileElement


'STEP - 똑닥 앱 실행'
Mobile.startExistingApplication(GlobalVariable.appid)

'STEP - 홈 검색 버튼 선택'
Mobile.tap(findTestObject('04_home/area_view_search_bar'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 검색 영역 선택'
Mobile.tap(findTestObject('09_search/input_search'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 병원 검색어 입력'
Mobile.setText(findTestObject('09_search/input_search'), GlobalVariable.hospital_name, GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [검색] 버튼 선택'
Mobile.tap(findTestObject('09_search/btn_search'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 검색 결과 첫번째 리스트 [+] 버튼 선택'
Mobile.tap(findTestObject('09_search/btn_result_plus'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 검색 결과 병원 목록 선택'
Mobile.tap(findTestObject('09_search/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'건강검진 사용 병원인 경우'
if(Mobile.waitForElementPresent(findTestObject('10_hospital_detail/btn_right', [('text') : '접수/예약']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) == true)
{
'STEP - [접수/예약] 버튼 선택'
Mobile.tap(findTestObject('10_hospital_detail/btn_right', [('text') : '접수/예약']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [날짜를 선택할게요.] 버튼 선택'
Mobile.tap(findTestObject('11_receipt/btn_reservation'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'건강검진 미사용 병원인 경우'
if(Mobile.waitForElementPresent(findTestObject('10_hospital_detail/btn_right', [('text') : '시간예약']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) == true)
{
'STEP - [시간예약] 버튼 선택'
Mobile.tap(findTestObject('10_hospital_detail/btn_right', [('text') : '시간예약']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

//예외처리
'예약 패널티 현황 안내 팝업 노출되는 경우 [확인] 버튼 선택'
if(Mobile.waitForElementPresent(findTestObject('00_common/txt_tvtitle', [('text') : '예약 페널티 현황 안내']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) == true)
{
'STEP - [확인] 버튼 선택'
Mobile.tap(findTestObject('00_common/txt_tvConfirm'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP - 예약하기 화면 진료대상 본인 선택'
Mobile.tap(findTestObject('11_receipt/txt_name', [('text') : GlobalVariable.user_name]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

//예외처리 - 주민등록 뒷자리 미입력 상태인 경우
if(Mobile.waitForElementPresent(findTestObject('11_receipt/txt_transmission_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) == true)
{
	Mobile.tap(findTestObject('11_receipt/input_back_number'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - 주민번호 뒷자리 "1111111" 입력'
	for(i = 1; i <= 7; i++)
	{
		Mobile.tap(findTestObject('12_family/btn_keypad_number_1'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	}
	
	Mobile.tap(findTestObject('11_receipt/btn_finish'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

//예외처리 - 간편결제 또는 비대면 진료 미사용 병원인 경우 진료방식 선택영역 미노출
if(Mobile.waitForElementPresent(findTestObject('11_receipt/txt_setting', [('text') : '방문진료']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) == true)
{
	'STEP - 진료방식 방문진료 선택'
	Mobile.tap(findTestObject('11_receipt/txt_setting', [('text') : '방문진료']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP - 진료실 선택'
Mobile.tap(findTestObject('11_receipt/txt_name', [('text') : '진료실']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 진료실 공지 노출 시 팝업 닫기'
if(Mobile.waitForElementPresent(findTestObject('00_common/txt_tvConfirm'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE))
{
	'STEP - [확인] 버튼 선택'
	Mobile.tap(findTestObject('00_common/txt_tvConfirm'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'스크롤 이동'
Mobile.scrollToText('일반진료')

'STEP - 진료방식 일반진료 선택'
Mobile.tap(findTestObject('11_receipt/txt_general'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [날짜/시간 선택] 버튼 선택'
Mobile.tap(findTestObject('11_receipt/btn_date_time_select'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'현재일 숫자형 정의'
LocalDate now = LocalDate.now()
int today = now.getDayOfMonth()
int tomorrow = today + 1

'STEP - 오늘 날짜 선택'
Mobile.tap(findTestObject('11_receipt/btn_day', [('text') : today]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 오늘 예약 불가능한 경우 내일 날짜 선택'
if(Mobile.waitForElementPresent(findTestObject('11_receipt/txt_tv_reservation_time_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) == false)
{
	'STEP - 다음 날짜 선택'
	Mobile.tap(findTestObject('11_receipt/btn_day', [('text') : tomorrow]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP - 예약 시간 선택'
Mobile.tap(findTestObject('11_receipt/txt_reservation_minute'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [다음] 버튼 선택'
Mobile.tap(findTestObject('11_receipt/btn_next'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 간편결제 사용하는 병원의 경우 결제 방식 [직접결제] 선택'
if(Mobile.waitForElementPresent(findTestObject('11_receipt/txt_payment_list_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) == true)
{
	'STEP - [병원에서 직접결제] 버튼 선택'
	Mobile.tap(findTestObject('11_receipt/btn_direct'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - [다음] 버튼 선택'
	Mobile.tap(findTestObject('11_receipt/btn_next'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP - [고유식별정보의 수집 및 이용 동의] 체크'
Mobile.tap(findTestObject('11_receipt/txt_cb_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [동의하고 예약하기] 버튼 선택'
Mobile.tap(findTestObject('11_receipt/btn_complete_reservation'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 사전문진 화면 노출 시 화면 닫기'
if(Mobile.waitForElementPresent(findTestObject('11_receipt/btn_question_close'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) == true)
{
	'STEP - [x] 버튼 선택'
	Mobile.tap(findTestObject('11_receipt/btn_question_close'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - [종료하기] 버튼 선택'
	Mobile.tap(findTestObject('11_receipt/btn_question_cancel'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'기대결과 - 예약이 완료되고, 홈 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('04_home/btn_menu_home'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //홈
Mobile.verifyElementVisible(findTestObject('04_home/area_vp_progress'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //영역
Mobile.verifyElementText(findTestObject('04_home/txt_tvHospitalTitle'), GlobalVariable.hospital_name, FailureHandling.CONTINUE_ON_FAILURE) //병원명

//예약취소
'STEP - 개인화 영역 선택'
Mobile.tap(findTestObject('04_home/txt_tvHospitalTitle'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [예약취소] 버튼 선택'
Mobile.tap(findTestObject('05_receipt_history/btn_detail_reservation_cancel'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [예약취소] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_positiveTxt'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [<-] 이전 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 예약 취소, 홈 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('04_home/btn_menu_home'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //홈
Mobile.verifyElementNotVisible(findTestObject('04_home/area_vp_progress'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //개인화

'STEP - 최근앱 삭제'
AndroidDriver<MobileElement> driver = MobileDriverFactory.getDriver()
driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH))
Mobile.tap(findTestObject('00_common_data_delete/btn_all_delete'), 2, FailureHandling.CONTINUE_ON_FAILURE)

