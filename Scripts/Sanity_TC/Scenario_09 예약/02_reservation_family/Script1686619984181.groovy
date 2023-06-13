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
import java.time.LocalDate;
import io.appium.java_client.android.nativekey.AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.AppiumDriver
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.MobileElement

'STEP - 똑닥 앱 실행'
Mobile.startExistingApplication(GlobalVariable.appid)

'STEP - 검색 영역 선택'
Mobile.tap(findTestObject('04_home/area_view_search_bar'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 병원 검색어 입력'
Mobile.setText(findTestObject('09_search/input_search'), GlobalVariable.hospital_name, GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [검색] 버튼 선택'
Mobile.tap(findTestObject('09_search/btn_search'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 검색 결과 첫번째 리스트 [+] 버튼 선택'
Mobile.tap(findTestObject('09_search/btn_result_plus'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 검색 결과 병원 선택'
Mobile.tap(findTestObject('09_search/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

//건강검진 
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

'기대결과 - 예약하기 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '예약하기 ([TEST] 똑닥가정의학과의원)', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 생성된 자녀 {아들}가 없으면 자녀 추가'
if(Mobile.waitForElementPresent(findTestObject('11_receipt/txt_name', [('text') : GlobalVariable.son]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) == false)
{
'STEP - [자녀추가] 버튼 선택'
Mobile.tap(findTestObject('11_receipt/btn_add_child'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 자녀추가 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '자녀추가', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 가족 이름 입력'
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
}

'STEP - 진료대상 가족 선택'
Mobile.tap(findTestObject('11_receipt/txt_name', [('text') : GlobalVariable.son]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'주민등록번호가 입력되지 않은 경우'
if(Mobile.waitForElementPresent(findTestObject('11_receipt/txt_transmission_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) == true)
{
'기대결과 - 주민등록번호 입력 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('11_receipt/txt_transmission_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //타이틀
	
'STEP - 주민번호 뒷자리 영역 선택'
Mobile.tap(findTestObject('11_receipt/input_back_number'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
'STEP - 주민번호 뒷자리 {3333333} 입력'
for(i = 1; i <= 7; i++)
{
	Mobile.tap(findTestObject('12_family/btn_keypad_number_3'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}
	
'STEP - [입력 완료] 버튼 선택'
Mobile.tap(findTestObject('11_receipt/btn_finish'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
'가족 접수 알림 팝업이 노출되는 경우 [확인] 버튼 선택'
if(Mobile.waitForElementPresent(findTestObject('00_common/btn_confirmBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) == true)
{
	Mobile.tap(findTestObject('00_common/btn_confirmBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}
	
'기대결과 - 예약하기 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '예약하기 ([TEST] 똑닥가정의학과의원)', FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP - 가족 접수 알림 팝업 노출 시 [확인] 버튼 선택'
if(Mobile.waitForElementPresent(findTestObject('11_receipt/txt_family_Noti'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) == true)
{
	Mobile.tap(findTestObject('00_common/btn_confirmBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
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

'STEP - 일반진료 선택'
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

'예약 날짜 시간 저장'
reservation = Mobile.getText(findTestObject('11_receipt/txt_reservation_time'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

//이전 페이지 이동
'STEP - [이전] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_prevBtn'), GlobalVariable.fixedTime, FailureHandling.STOP_ON_FAILURE)

'기대결과 - 예약하기 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('11_receipt/txt_description', [('text') : GlobalVariable.son]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //이름
Mobile.verifyElementVisible(findTestObject('11_receipt/txt_description', [('text') : '진료실/가정의학과']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //진료실
Mobile.verifyElementVisible(findTestObject('11_receipt/txt_description', [('text') : '일반진료']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //진료항목
Mobile.verifyElementVisible(findTestObject('11_receipt/btn_date_time_select'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //[날짜/시간 선택] 버튼
//

'STEP - [날짜/시간 선택] 버튼 선택'
Mobile.tap(findTestObject('11_receipt/btn_date_time_select'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 시간 선택 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('11_receipt/txt_time_select'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

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

'기대결과 - 예약완료 화면으로 이동'
Mobile.verifyElementText(findTestObject('11_receipt/txt_complete_page_title'), "예약 당일, 병원에 방문하면\n'똑닥으로 왔어요~' 라고 말해주세요.", FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [고유식별정보의 수집 및 이용 동의] 체크'
Mobile.tap(findTestObject('11_receipt/txt_cb_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [동의하고 예약하기] 버튼 선택'
Mobile.tap(findTestObject('11_receipt/btn_complete_reservation'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.delay(2)

'STEP - 사전문진 화면 노출 시 화면 닫기'
if(Mobile.waitForElementPresent(findTestObject('11_receipt/btn_question_close'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) == true)
{
	'STEP - [x] 버튼 선택'
	Mobile.tap(findTestObject('11_receipt/btn_question_close'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - [종료하기] 버튼 선택'
	Mobile.tap(findTestObject('11_receipt/btn_question_cancel'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'기대결과 - 홈 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('04_home/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 개인화 영역 노출'
Mobile.verifyElementVisible(findTestObject('04_home/area_vp_progress'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 개인화 영역 스와이프'
Mobile.swipe(1000, 700, 100, 700)

'기대결과 - 자녀 접수 카드 노출'
Mobile.verifyElementText(findTestObject('04_home/txt_tvHospitalTitle'), GlobalVariable.hospital_name, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 개인화 영역 선택'
Mobile.tap(findTestObject('04_home/txt_tvHospitalTitle'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 상세 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '진료내역 상세', FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('11_receipt/txt_name', [('text') : GlobalVariable.son]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //이름
Mobile.verifyElementText(findTestObject('05_receipt_history/txt_detail_hospital'), GlobalVariable.hospital_name, FailureHandling.CONTINUE_ON_FAILURE) //병원명
Mobile.verifyElementText(findTestObject('05_receipt_history/txt_office'), '진료실', FailureHandling.CONTINUE_ON_FAILURE) //진료실명

'기대결과 - 예약 일자 일치 확인'
reservation_complete = Mobile.getText(findTestObject('05_receipt_history/txt_receipt_day'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyEqual(reservation, GlobalVariable.son + '-' + reservation_complete, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 상세 [예약취소] 버튼 노출'
Mobile.verifyElementVisible(findTestObject('05_receipt_history/btn_detail_reservation_cancel'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [<-] 이전 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('04_home/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'최근앱 삭제'
AndroidDriver<MobileElement> driver = MobileDriverFactory.getDriver()
driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH))
Mobile.tap(findTestObject('00_common_data_delete/btn_all_delete'), 2, FailureHandling.CONTINUE_ON_FAILURE)
