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

Mobile.delay(2)

//검색
'현재 설정되어있는 주소 이름'
home_adress_name = Mobile.getText(findTestObject('04_home/txt_home_adress_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 홈 검색 영역 선택'
Mobile.tap(findTestObject('04_home/area_view_search_bar'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 진료과 검색어 입력'
Mobile.setText(findTestObject('09_search/input_search'), '소아청소년과', GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
'STEP - [검색] 버튼 선택'
Mobile.tap(findTestObject('09_search/btn_search'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
'STEP - 검색 결과 첫번째 리스트 선택'
Mobile.tap(findTestObject('09_search/btn_result_plus'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
'기대결과 - 검색 영역에 검색어 노출'
Mobile.verifyElementText(findTestObject('09_search/input_search'), '소아청소년과', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - sort 필터 선택'
Mobile.tap(findTestObject('09_search/txt_sort_type'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 정렬필터 바텀 시트 노출'
Mobile.verifyElementVisible(findTestObject('09_search/txt_sort_filter_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //타이틀
Mobile.verifyElementText(findTestObject('00_common/btn_confirmBtn'), '필터 적용', FailureHandling.CONTINUE_ON_FAILURE) //[필터 적용] 버튼

'STEP - 거리순 필터 선택'
Mobile.tap(findTestObject('09_search/txt_sort_filter_distance'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [필터 적용] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_confirmBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - sort 필터에 {거리순} 노출'
Mobile.verifyElementText(findTestObject('09_search/txt_sort_type'), '거리순', FailureHandling.CONTINUE_ON_FAILURE)
	
'기대결과 - 진료과 검색 결과 노출'
Mobile.verifyElementVisible(findTestObject('09_search/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //병원명 영역
Mobile.verifyElementVisible(findTestObject('09_search/txt_main_medical_department'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //대표진료과목 영역
//

//주소 편집
'STEP - 주소 버튼 선택'
Mobile.tap(findTestObject('09_search/btn_searchRegionBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 주소 설정 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '주소 설정', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [현위치에서 병원 찾기] 버튼 선택'
Mobile.tap(findTestObject('07_adress_setting/btn_current_location'), GlobalVariable.fixedTime)

'기대결과 - 검색 화면 주소 이름 현위치 노출'
if(GlobalVariable.adress_name == '상동')
{
	Mobile.verifyElementVisible(findTestObject('09_search/txt_search_adress_name', [('text') : '상동']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}
else if(GlobalVariable.adress_name == '여의도동')
{
	Mobile.verifyElementVisible(findTestObject('09_search/txt_search_adress_name', [('text') : '여의도동']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'기대결과 - 검색 결과 노출'
Mobile.verifyElementVisible(findTestObject('09_search/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //병원명 영역
Mobile.verifyElementVisible(findTestObject('09_search/area_complete_date'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //진료시간 영역
Mobile.verifyElementVisible(findTestObject('09_search/txt_main_medical_department'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //대표진료과목 영역

'STEP - 주소 이름 선택'
if(GlobalVariable.adress_name == '상동')
{
	Mobile.tap(findTestObject('09_search/txt_search_adress_name', [('text') : '상동']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}
else if(GlobalVariable.adress_name == '여의도동')
{
	Mobile.tap(findTestObject('09_search/txt_search_adress_name', [('text') : '여의도동']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'기대결과 - 주소 설정 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '주소 설정', FailureHandling.CONTINUE_ON_FAILURE)
	
'STEP - [우리집] 선택'
Mobile.tap(findTestObject('07_adress_setting/btn_my_home'), GlobalVariable.fixedTime)

'기대결과 - 검색 화면 주소 이름 우리집 노출'
Mobile.verifyElementVisible(findTestObject('09_search/txt_search_adress_name', [('text') : '우리집']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
'기대결과 - 검색 결과 노출'
Mobile.verifyElementVisible(findTestObject('09_search/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //병원명 영역
Mobile.verifyElementVisible(findTestObject('09_search/area_complete_date'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //진료시간 영역
Mobile.verifyElementVisible(findTestObject('09_search/txt_main_medical_department'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //대표진료과목 영역
	
'STEP - 주소 이름 선택'
Mobile.tap(findTestObject('09_search/txt_search_adress_name', [('text') : '우리집']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 주소 설정 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '주소 설정', FailureHandling.CONTINUE_ON_FAILURE)

'그 외 주소 없는 경우 추가'
if(Mobile.waitForElementNotPresent(findTestObject('07_adress_setting/btn_different_adress_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE))
{
	'STEP - [다른 위치에서 병원 찾기] 버튼 선택'
	Mobile.tap(findTestObject('07_adress_setting/btn_different_location'), GlobalVariable.fixedTime)
	
	'기대결과 - 주소 검색하기 타이틀 노출'
	Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '주소 검색하기', FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - 주소 입력'
	Mobile.setText(findTestObject('07_adress_setting/input_adress_search_adress'), '경기 시흥시 배곧전원로 12-1', GlobalVariable.fixedTime)
	
	'STEP - [검색] 버튼 선택'
	Mobile.tap(findTestObject('07_adress_setting/btn_adress_search'), GlobalVariable.fixedTime)
	
	'STEP - 도로명 주소 선택'
	Mobile.tap(findTestObject('07_adress_setting/txt_adress_road_name'), GlobalVariable.fixedTime)
	
	'기대결과 - 상세주소 입력 타이틀 노출'
	Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '상세주소 입력', FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - 상세주소 입력'
	Mobile.setText(findTestObject('07_adress_setting/input_adress_detail_adress_detail'), '1234', GlobalVariable.fixedTime)
	
	'STEP - 주소이름 입력'
	Mobile.setText(findTestObject('07_adress_setting/input_adress_detail_adress_name'), 'TEST', GlobalVariable.fixedTime)
	
	'STEP - [등록] 버튼 선택'
	Mobile.tap(findTestObject('00_common/btn_tvCommonButtonView'), GlobalVariable.fixedTime)
}
	
'STEP - 주소이름 {TEST} 선택'
Mobile.tap(findTestObject('07_adress_setting/btn_different_adress_name'), GlobalVariable.fixedTime)

'기대결과 - 검색 화면 주소 이름 {TEST} 노출'
Mobile.verifyElementVisible(findTestObject('09_search/txt_search_adress_name', [('text') : 'TEST']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
'기대결과 - 검색 결과 노출'
Mobile.verifyElementVisible(findTestObject('09_search/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //병원명 영역
Mobile.verifyElementVisible(findTestObject('09_search/area_complete_date'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //진료시간 영역
Mobile.verifyElementVisible(findTestObject('09_search/txt_main_medical_department'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //대표진료과목 영역
//

'최근앱 삭제'
AndroidDriver<MobileElement> driver = MobileDriverFactory.getDriver()
driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH))
Mobile.tap(findTestObject('00_common_data_delete/btn_all_delete'), 2, FailureHandling.CONTINUE_ON_FAILURE)