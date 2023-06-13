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
import internal.GlobalVariable
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.By
import org.openqa.selenium.Keys as Keys
import io.appium.java_client.MobileElement
import io.appium.java_client.android.nativekey.AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.AppiumDriver
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.MobileElement

'STEP - 똑닥 앱 실행'
Mobile.startExistingApplication(GlobalVariable.appid)

'STEP - 홈 검색 영역 선택'
Mobile.tap(findTestObject('04_home/area_view_search_bar'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 검색어 입력'
Mobile.setText(findTestObject('09_search/input_search'), '내과', GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
'STEP - [검색] 버튼 선택'
Mobile.tap(findTestObject('09_search/btn_search'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
'STEP - 검색 결과 첫번째 리스트 선택'
Mobile.tap(findTestObject('09_search/btn_result_plus'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
'기대결과 - 검색 영역에 검색어 노출'
Mobile.verifyElementText(findTestObject('09_search/input_search'), '내과', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [필터] 버튼 선택'
Mobile.tap(findTestObject('09_search/btn_filter'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 필터 화면으로 이동'
Mobile.verifyElementText(findTestObject('09_search/txt_page_title'), '필터', FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('09_search/txt_filter_sub_title', [('text') : '똑닥 서비스']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //똑닥 서비스
Mobile.verifyElementVisible(findTestObject('09_search/txt_filter_single_title', [('text') : '자동결제']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //자동결제
Mobile.verifyElementVisible(findTestObject('09_search/txt_filter_single_title', [('text') : '비대면진료']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //비대면진료
Mobile.verifyElementVisible(findTestObject('09_search/txt_filter_single_title', [('text') : '모바일 서류']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //실손보험 청구
Mobile.verifyElementVisible(findTestObject('09_search/txt_filter_single_title', [('text') : '주차장']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //주차장
Mobile.verifyElementVisible(findTestObject('09_search/txt_filter_single_title', [('text') : '전문의']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //전문의
Mobile.verifyElementVisible(findTestObject('09_search/txt_filter_sub_title', [('text') : '설립 연차']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //설립 연차
Mobile.scrollToText('병원 정보', FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('09_search/txt_filter_sub_title', [('text') : '병원 정보']), GlobalVariable.fixedTime,FailureHandling.CONTINUE_ON_FAILURE) //병원 정보
Mobile.scrollToText('병원 시설', FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('09_search/txt_filter_sub_title', [('text') : '병원 시설']), GlobalVariable.fixedTime,FailureHandling.CONTINUE_ON_FAILURE) //병원 장비
Mobile.scrollToText('병원 장비', FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('09_search/txt_filter_sub_title', [('text') : '병원 장비']), GlobalVariable.fixedTime,FailureHandling.CONTINUE_ON_FAILURE) //병원 장비
Mobile.verifyElementText(findTestObject('00_common/btn_confirmBtn'), '필터 적용', FailureHandling.CONTINUE_ON_FAILURE) //[필터 적용] 버튼

'STEP - 주차장 체크박스 선택'
Mobile.scrollToText('주차장', FailureHandling.CONTINUE_ON_FAILURE)
Mobile.tap(findTestObject('09_search/txt_filter_single_title', [('text') : '주차장']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [필터 적용] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_confirmBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색 화면으로 이동'
Mobile.verifyElementText(findTestObject('09_search/input_search'), '내과', FailureHandling.CONTINUE_ON_FAILURE)

String[] medical_department = ['내과', '소아청소년과', '이비인후과'] //진료과목 리스트

'STEP - [진료과목] 버튼 선택'
for(i=0; i<=2; i++)
{	
'STEP - [진료과목] 필터 선택'
Mobile.tap(findTestObject('09_search/btn_medical_department'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
'기대결과 - 진료과목 바텀 시트 노출'
Mobile.verifyElementText(findTestObject('09_search/txt_bottom_seat_title'), '진료과목', FailureHandling.CONTINUE_ON_FAILURE)
	
'STEP - [더보기] 버튼 선택'
Mobile.tap(findTestObject('09_search/btn_bottom_seat_more'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 진료과목 선택'
Mobile.tap(findTestObject('09_search/txt_medical_department_filter_list', [('text') : medical_department[i]]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //변수 적용

'기대결과 - 필터 적용된 검색 결과 노출'
Mobile.verifyElementText(findTestObject('09_search/txt_main_medical_department'), medical_department[i], FailureHandling.CONTINUE_ON_FAILURE) //대표 진료과목
Mobile.verifyElementVisible(findTestObject('09_search/txt_badge', [('text') : '주차장']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //주차장 뱃지

'STEP - 화면 스크롤 이동'
Mobile.swipe(45, 1200, 45, 600)

'기대결과 - 병원 리스트 확인'
Mobile.verifyElementText(findTestObject('09_search/txt_main_medical_department'), medical_department[i], FailureHandling.CONTINUE_ON_FAILURE) //대표 진료과목
Mobile.verifyElementVisible(findTestObject('09_search/txt_badge', [('text') : '주차장']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //주차장 뱃지

'STEP - 화면 스크롤 이동'
Mobile.swipe(45, 1200, 45, 600)

'기대결과 - 병원 리스트 확인'
Mobile.verifyElementText(findTestObject('09_search/txt_main_medical_department'), medical_department[i], FailureHandling.CONTINUE_ON_FAILURE) //대표 진료과목
Mobile.verifyElementVisible(findTestObject('09_search/txt_badge', [('text') : '주차장']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //주차장 뱃지

'STEP - 화면 스크롤 이동'
Mobile.swipe(45, 1200, 45, 600)

'기대결과 - 병원 리스트 확인'
Mobile.verifyElementText(findTestObject('09_search/txt_main_medical_department'), medical_department[i], FailureHandling.CONTINUE_ON_FAILURE) //대표 진료과목
Mobile.verifyElementVisible(findTestObject('09_search/txt_badge', [('text') : '주차장']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //주차장 뱃지

'STEP - 화면 스크롤 이동'
Mobile.swipe(45, 1200, 45, 600)

'기대결과 - 병원 리스트 확인'
Mobile.verifyElementText(findTestObject('09_search/txt_main_medical_department'), medical_department[i], FailureHandling.CONTINUE_ON_FAILURE) //대표 진료과목
Mobile.verifyElementVisible(findTestObject('09_search/txt_badge', [('text') : '주차장']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //주차장 뱃지
}

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('04_home/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //홈 메뉴(활성화)
Mobile.verifyElementVisible(findTestObject('04_home/area_view_search_bar'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //검색 바

'최근앱 삭제'
AndroidDriver<MobileElement> driver = MobileDriverFactory.getDriver()
driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH))
Mobile.tap(findTestObject('00_common_data_delete/btn_all_delete'), 2, FailureHandling.CONTINUE_ON_FAILURE)

