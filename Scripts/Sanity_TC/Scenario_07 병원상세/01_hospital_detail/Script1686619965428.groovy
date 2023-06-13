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

'Chrome App'
Mobile.startExistingApplication('com.android.chrome')

Mobile.delay(2)

Mobile.switchToWebView()

'병원 어드민 진입'
WebUI.navigateToUrl('https://hospital.ddocdoc.com')

'[병원관리자 로그인] 버튼 선택'
WebUI.sendKeys(findTestObject('10_hospital_detail/01_pc_web/btn_admin_login'), Keys.chord(Keys.ENTER) , FailureHandling.CONTINUE_ON_FAILURE)

'아이디 입력'
WebUI.setText(findTestObject('10_hospital_detail/01_pc_web/input_id'), 'ddocdocProduction3', FailureHandling.CONTINUE_ON_FAILURE)

'비밀번호 입력'
WebUI.setText(findTestObject('10_hospital_detail/01_pc_web/input_password'), 'ddocdocProduction3', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.sendKeys(findTestObject('10_hospital_detail/01_pc_web/input_password'), Keys.chord(Keys.ENTER) , FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1)

'똑닥 팝업 병원 주소 활용 노출 유무 체크 or 리얼 환경 팝업 체크'
if (WebUI.waitForElementPresent(findTestObject('10_hospital_detail/01_pc_web/btn_close'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE))
{
	'[닫기] 선택'
	WebUI.click(findTestObject('10_hospital_detail/01_pc_web/btn_close'), FailureHandling.CONTINUE_ON_FAILURE)
}

'병원정보 화면 이동'
WebUI.navigateToUrl('https://hospital.ddocdoc.com/hospital-info/setup')

WebUI.delay(1)

'병원정보 저장'
main_department = WebUI.getText(findTestObject('10_hospital_detail/01_pc_web/txt_main_department')) //대표진료과목
department = WebUI.getText(findTestObject('10_hospital_detail/01_pc_web/txt_department_list')) //진료과목
subject_item = WebUI.getText(findTestObject('10_hospital_detail/01_pc_web/txt_department_item_list')) //진료항목
subject_item_count = WebUI.getText(findTestObject('10_hospital_detail/01_pc_web/txt_department_item_count')) //진료항목 개수
hospital_intro = WebUI.getAttribute(findTestObject('10_hospital_detail/01_pc_web/txt_hospital_note'), 'value') //소개
hospital_img = WebUI.waitForElementPresent(findTestObject('10_hospital_detail/01_pc_web/img_hospital'), GlobalVariable.fixedTime) //병원 이미지
hospital_clinic_time_img = WebUI.waitForElementPresent(findTestObject('10_hospital_detail/01_pc_web/img_clinic_time'), GlobalVariable.fixedTime) //진료시간표 이미지
parking = WebUI.waitForElementPresent(findTestObject('10_hospital_detail/01_pc_web/txt_parking'), GlobalVariable.fixedTime) //주차장



'의사정보 화면 이동'
WebUI.navigateToUrl('https://hospital.ddocdoc.com/hospital-info/doctors')

'의사정보 저장'
doctor = WebUI.waitForElementPresent(findTestObject('10_hospital_detail/01_pc_web/btn_doctor_add'), GlobalVariable.fixedTime)



if (doctor == true)
{GlobalVariable.doctor = false}
else
{GlobalVariable.doctor = true}

'병원 공지사항 화면 이동'
WebUI.navigateToUrl('https://hospital.ddocdoc.com/hospital-info/notices')

'공지사항 목록이 없는 경우 신규 등록'
if(WebUI.waitForElementPresent(findTestObject('10_hospital_detail/01_pc_web/btn_delete'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) == false) //삭제버튼
{
	WebUI.click(findTestObject('10_hospital_detail/01_pc_web/btn_notice_add'), FailureHandling.CONTINUE_ON_FAILURE) //[공지사항 등록]
	WebUI.setText(findTestObject('10_hospital_detail/01_pc_web/input_notice_title'), GlobalVariable.test_title, FailureHandling.CONTINUE_ON_FAILURE) //제목
	WebUI.setText(findTestObject('10_hospital_detail/01_pc_web/input_note'), GlobalVariable.test_title, FailureHandling.CONTINUE_ON_FAILURE) //내용
	WebUI.click(findTestObject('10_hospital_detail/01_pc_web/btn_save'), FailureHandling.CONTINUE_ON_FAILURE) //[저장]
	WebUI.click(findTestObject('10_hospital_detail/01_pc_web/btn_confirm'), FailureHandling.CONTINUE_ON_FAILURE) //[확인]
}

'공지사항 저장'
hospital_notice = WebUI.waitForElementPresent(findTestObject('10_hospital_detail/01_pc_web/txt_hospital_notice'), GlobalVariable.fixedTime) //대표 공지사항

WebUI.closeBrowser()

Mobile.switchToNative()

'STEP - 똑닥 앱 실행'
Mobile.startExistingApplication(GlobalVariable.appid)

'STEP - 최상단 스크롤 이동'
Mobile.scrollToText('질병, 진료과, 병원을 검색해보세요.')

'STEP - 홈 검색 영역 선택'
Mobile.tap(findTestObject('04_home/area_view_search_bar'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 병원 검색어 입력'
Mobile.setText(findTestObject('09_search/input_search'), GlobalVariable.hospital_name, GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [검색] 버튼 선택'
Mobile.tap(findTestObject('09_search/btn_search'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 검색 결과 첫번째 리스트 [+] 버튼 선택'
Mobile.tap(findTestObject('09_search/btn_result_plus'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 검색결과 목록 선택'
Mobile.tap(findTestObject('09_search/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 병원상세 화면으로 이동'
Mobile.verifyElementText(findTestObject('10_hospital_detail/txt_page_title'), GlobalVariable.hospital_name, FailureHandling.CONTINUE_ON_FAILURE) //page title

'기대결과 - 병원상세 공지사항 노출'
Mobile.verifyElementVisible(findTestObject('10_hospital_detail/txt_notice', [('text') : hospital_notice]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //공지사항

'기대결과 - 병원 이미지 확인'
if(hospital_img == true)
{
	Mobile.verifyElementVisible(findTestObject('10_hospital_detail/img_hospital'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}
else
{
	Mobile.verifyElementNotVisible(findTestObject('10_hospital_detail/img_hospital'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}	

'기대결과 - 대표 진료과목'
Mobile.verifyElementVisible(findTestObject('10_hospital_detail/txt_view', [('text') : main_department]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 병원 주소'
Mobile.verifyElementVisible(findTestObject('10_hospital_detail/txt_view', [('text') : 'Silicon Valley']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 주차장 뱃지'
if (parking == true)
{
	Mobile.verifyElementVisible(findTestObject('10_hospital_detail/txt_view', [('text') : '주차장']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}
else
{
	Mobile.verifyElementNotVisible(findTestObject('10_hospital_detail/txt_view', [('text') : '주차장']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'[공유하기] 버튼 선택'
Mobile.tap(findTestObject('10_hospital_detail/btn_share'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 공유하기 바텀 시트 노출'
Mobile.verifyElementVisible(findTestObject('10_hospital_detail/btn_common', [('text') : '카카오톡 공유 카카오톡으로 공유']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) 
Mobile.verifyElementVisible(findTestObject('10_hospital_detail/btn_common', [('text') : '클립보드 복사 URL 링크 복사']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) 

'[취소] 버튼 선택'
Mobile.tap(findTestObject('10_hospital_detail/btn_common', [('text') : '취소']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 화면 스크롤 이동'
Mobile.scrollToText('병원정보')

'[병원정보] tab 선택'
Mobile.tap(findTestObject('10_hospital_detail/txt_view', [('text') : '병원정보']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

//병원소개 영역
'기대결과 - 병원소개 영역으로 이동'
Mobile.verifyElementVisible(findTestObject('10_hospital_detail/txt_view', [('text') : '병원소개']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

'[진료안내] tab 선택'
Mobile.tap(findTestObject('10_hospital_detail/txt_view', [('text') : '진료안내']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료과목 영역으로 이동'
Mobile.verifyElementVisible(findTestObject('10_hospital_detail/txt_view', [('text') : '진료과목']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

//병원리뷰
'STEP - 화면 스크롤 이동'
Mobile.swipe(45, 484, 45, 1190)

'STEP - 병원리뷰 영역 [?] 정보 더보기 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_more'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 방문 병원 리뷰 통계 바텀 시트 노출'
Mobile.verifyElementVisible(findTestObject('10_hospital_detail/txt_view', [('text') : '방문 병원 리뷰 통계']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [확인] 버튼 선택'
Mobile.tap(findTestObject('10_hospital_detail/btn_review_confirm'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

'[진료정보] tab 선택'
Mobile.tap(findTestObject('10_hospital_detail/txt_view', [('text') : '진료정보']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료 항목 영역으로 이동'
Mobile.verifyElementVisible(findTestObject('10_hospital_detail/txt_view', [('text') : '진료 항목']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

if(Mobile.waitForElementPresent(findTestObject('10_hospital_detail/btn_doctor_history'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE))
{
	'STEP - [약력보기] 버튼 선택'
	Mobile.tap(findTestObject('10_hospital_detail/btn_doctor_history'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'기대결과 - 의사명 노출'
	Mobile.verifyElementVisible(findTestObject('10_hospital_detail/txt_view', [('text') : '똑닥']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

	
	'기대결과 - 의사 약력 문구 노출'
	Mobile.verifyElementVisible(findTestObject('10_hospital_detail/txt_view', [('text') : '의사 약력']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - [확인] 버튼 선택'
	Mobile.tap(findTestObject('10_hospital_detail/btn_doctor_confirm'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}
	
'STEP - 개인정보 처리업무 위탁 정보 공개 문구 선택'
Mobile.tap(findTestObject('10_hospital_detail/btn_privacy'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 개인정보 처리 위탁 문서 노출'
Mobile.verifyElementVisible(findTestObject('10_hospital_detail/txt_view', [('text') : '개인정보 처리 위탁']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'back key'
Mobile.pressBack()

'기대결과 - 병원상세 화면 노출'
Mobile.verifyElementText(findTestObject('10_hospital_detail/txt_page_title'), GlobalVariable.hospital_name, FailureHandling.CONTINUE_ON_FAILURE) //page title

'건강검진 사용 유무에 따른 버튼 확인'
if(Mobile.waitForElementPresent(findTestObject('10_hospital_detail/btn_left', [('text') : '건강검진']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) == true)
{	
	'STEP - [건강검진] 좌측 버튼 선택'
	Mobile.tap(findTestObject('10_hospital_detail/btn_left', [('text') : '건강검진']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
		
	'기대결과 - 국가건강검진 화면 노출'
	Mobile.verifyElementText(findTestObject('10_hospital_detail/txt_checkup'), GlobalVariable.hospital_name, FailureHandling.CONTINUE_ON_FAILURE) 
	
	'STEP - [X] 뒤로가기 버튼 선택'
	Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - [네] 버튼 선택'
	Mobile.tap(findTestObject('00_common/btn_positiveTxt'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - [접수/예약] 우측 버튼 선택'
	Mobile.tap(findTestObject('10_hospital_detail/btn_right', [('text') : '접수/예약']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'기대결과 - "일반진료" 바텀 시트 노출'
	Mobile.verifyElementText(findTestObject('11_receipt/txt_view_title'), '일반진료', FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - [x] 버튼 선택'
	Mobile.tap(findTestObject('10_hospital_detail/btn_close'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}
else
{
	'STEP - [바로접수] 좌측 버튼 선택'
	Mobile.tap(findTestObject('10_hospital_detail/btn_left', [('text') : '바로접수']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'기대결과 - 접수하기 화면 노출'
	Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '접수하기 ([TEST] 똑닥가정의학과의원)', FailureHandling.CONTINUE_ON_FAILURE)
	
	'back key'
	Mobile.pressBack()
	
	'STEP - [네] 버튼 선택'
	Mobile.tap(findTestObject('00_common/btn_positiveTxt'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - [시간예약] 우측 버튼 선택'
	Mobile.tap(findTestObject('10_hospital_detail/btn_right', [('text') : '시간예약']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'기대결과 - 접수하기 화면 노출'
	Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '예약하기 ([TEST] 똑닥가정의학과의원)', FailureHandling.CONTINUE_ON_FAILURE)
	
	'back key'
	Mobile.pressBack()
	
	'STEP - [네] 버튼 선택'
	Mobile.tap(findTestObject('00_common/btn_positiveTxt'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_webview_back'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'최근앱 삭제'
AndroidDriver<MobileElement> driver = MobileDriverFactory.getDriver()
driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH))
Mobile.tap(findTestObject('00_common_data_delete/btn_all_delete'), 2, FailureHandling.CONTINUE_ON_FAILURE)
