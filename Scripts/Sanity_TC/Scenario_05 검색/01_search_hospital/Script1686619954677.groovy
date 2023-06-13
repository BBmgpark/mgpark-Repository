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

'STEP - 홈 검색 영역 선택'
Mobile.tap(findTestObject('04_home/area_view_search_bar'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'back key (키보드 닫기)'
Mobile.pressBack()

'최근 검색어 존재 시 전체 삭제'
if(Mobile.waitForElementPresent(findTestObject('09_search/btn_all_delete'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE))
{
	Mobile.tap(findTestObject('09_search/btn_all_delete'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	Mobile.tap(findTestObject('00_common/btn_positiveTxt'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'기대결과 - 검색 화면 노출'
Mobile.verifyElementVisible(findTestObject('09_search/input_search'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

//병원 검색
'STEP - 검색 영역 선택'
Mobile.tap(findTestObject('09_search/input_search'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 병원 검색어 입력'
Mobile.setText(findTestObject('09_search/input_search'), GlobalVariable.hospital_name, GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [검색] 버튼 선택'
Mobile.tap(findTestObject('09_search/btn_search'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 검색 결과 첫번째 리스트 [+] 버튼 선택'
Mobile.tap(findTestObject('09_search/btn_result_plus'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 병원 검색 결과 노출'
Mobile.verifyElementVisible(findTestObject('09_search/btn_filter'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //[필터] 버튼
Mobile.verifyElementText(findTestObject('09_search/txt_sort_type'), '관련순', FailureHandling.CONTINUE_ON_FAILURE) //sort 타입
Mobile.verifyElementText(findTestObject('09_search/txt_hospital_name'), GlobalVariable.hospital_name, FailureHandling.CONTINUE_ON_FAILURE) //병원명

'기대결과 - [진료중] [지도보기] 버튼 노출'
Mobile.verifyElementVisible(findTestObject('09_search/btn_filter_open'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //[진료중]
Mobile.verifyElementVisible(findTestObject('09_search/btn_map'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //[지도보기]

'검색 결과 첫번째 병원 이름 저장'
hospital_name1 = Mobile.getText(findTestObject('09_search/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 병원 목록 선택'
Mobile.tap(findTestObject('09_search/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

//병원상세 요소 못찾아서 우선 제외
//'기대결과 - 병원상세 화면으로 이동'
//Mobile.verifyElementVisible(findTestObject('00_common/txt_class_text_view', [('text') : hospital_name1]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //page title
//
//'STEP - [<-] 병원 상세  뒤로가기 버튼 선택'
//Mobile.tap(findTestObject('00_common/btn_webview_back'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.pressBack()

'기대결과 - 검색 화면으로 이동'
Mobile.verifyElementText(findTestObject('09_search/input_search'), GlobalVariable.hospital_name, FailureHandling.CONTINUE_ON_FAILURE) //검색 인풋 문구

'STEP - [x] 검색어 삭제 버튼 선택'
Mobile.tap(findTestObject('09_search/btn_search_clear'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색어 삭제되고, 최근 검색어 노출' 
Mobile.verifyElementText(findTestObject('09_search/txt_recent_list'), GlobalVariable.hospital_name, FailureHandling.CONTINUE_ON_FAILURE) //최근 검색어
Mobile.verifyElementVisible(findTestObject('09_search/btn_all_delete'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //[전체삭제] 버튼

'STEP - [x] 최근 검색어 버튼 선택'
Mobile.tap(findTestObject('09_search/btn_recent_list_delete'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 삭제한 최근 검색어 미노출'
Mobile.verifyElementNotVisible(findTestObject('09_search/txt_recent_list'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

//질병 검색
String[] disease = ['감기', '장염']

for(i=0; i<=1; i++)
{
'STEP - 검색 영역 선택'
Mobile.tap(findTestObject('09_search/input_search'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 질병 검색어 입력'
Mobile.setText(findTestObject('09_search/input_search'), disease[i], GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [검색] 버튼 선택'
Mobile.tap(findTestObject('09_search/btn_search'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'검색 목록 첫번째 검색어 저장'
search_list = Mobile.getText(findTestObject('09_search/txt_search_list_first'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 검색 목록 첫번째 검색어 선택'
Mobile.tap(findTestObject('09_search/btn_result_plus'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색 인풋 영역에 검색어 노출'
Mobile.verifyElementText(findTestObject('09_search/input_search'), search_list, FailureHandling.CONTINUE_ON_FAILURE) 

'기대결과 - 질벙졍보 설명 영역 노출'
Mobile.verifyElementVisible(findTestObject('09_search/txt_disease_description'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('09_search/btn_see'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //[보기] 버튼

'기대결과 - 질병 검색 결과 노출'
Mobile.verifyElementVisible(findTestObject('09_search/btn_filter'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //[필터] 버튼
Mobile.verifyElementText(findTestObject('09_search/txt_sort_type'), '관련순', FailureHandling.CONTINUE_ON_FAILURE) //sort 타입
Mobile.verifyElementVisible(findTestObject('09_search/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //병원명 영역

'검색 결과 목록 첫번째 병원 이름 저장'
hospital_name2 = Mobile.getText(findTestObject('09_search/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
'STEP - 병원 목록 선택'
Mobile.tap(findTestObject('09_search/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

//병원상세 요소 못찾아서 보류
//'기대결과 - 병원상세 화면으로 이동'
//Mobile.verifyElementVisible(findTestObject('00_common/txt_class_text_view', [('text') : hospital_name2]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //page title
//
//'STEP - [<-] 병원상세 뒤로가기 버튼 선택'
//Mobile.tap(findTestObject('00_common/btn_webview_back'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.pressBack()

'기대결과 - 검색 화면으로 이동'
Mobile.verifyElementText(findTestObject('09_search/input_search'), search_list, FailureHandling.CONTINUE_ON_FAILURE) //검색 인풋 

'STEP - [x] 검색어 삭제 버튼 선택'
Mobile.tap(findTestObject('09_search/btn_search_clear'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색어 삭제되고, 최근 검색어 노출'
Mobile.verifyElementText(findTestObject('09_search/txt_recent_list'), search_list, FailureHandling.CONTINUE_ON_FAILURE) //검색어

'STEP - [x] 최근 검색어 삭제 버튼 선택'
Mobile.tap(findTestObject('09_search/btn_recent_list_delete'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 삭제한 최근 검색어 미노출'
Mobile.verifyElementNotVisible(findTestObject('09_search/txt_recent_list'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}
//

//진료과목 검색
String[] medical_department = ['내과', '소아청소년과']

'STEP - 진료과목으로 검색'
for(i=0; i<=1; i++)
{
'STEP - 검색 영역 선택'
Mobile.tap(findTestObject('09_search/input_search'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 진료과 검색어 입력'
Mobile.setText(findTestObject('09_search/input_search'), medical_department[i], GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
'STEP - [검색] 버튼 선택'
Mobile.tap(findTestObject('09_search/btn_search'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
'검색 목록 첫번째 검색어 저장'
search_list = Mobile.getText(findTestObject('09_search/txt_search_list_first'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
'STEP - 검색 결과 첫번째 검색어 선택'
Mobile.tap(findTestObject('09_search/btn_result_plus'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
'기대결과 - 진료과 검색 결과 목록 노출'
Mobile.verifyElementText(findTestObject('09_search/input_search'), search_list, FailureHandling.CONTINUE_ON_FAILURE) //검색 영역
Mobile.verifyElementVisible(findTestObject('09_search/btn_filter'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //[필터] 버튼
Mobile.verifyElementText(findTestObject('09_search/txt_sort_type'), '관련순', FailureHandling.CONTINUE_ON_FAILURE) //sort 타입
Mobile.verifyElementVisible(findTestObject('09_search/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //병원명 영역
Mobile.verifyElementVisible(findTestObject('09_search/txt_main_medical_department'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //대표진료과목 영역

'검색 결과 첫번째 병원 이름 저장'
hospital_name3 = Mobile.getText(findTestObject('09_search/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 병원 목록 선택'
Mobile.tap(findTestObject('09_search/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

//병원상세 요소 못찾아서 보류
//'기대결과 - 병원상세 화면으로 이동'
//Mobile.verifyElementVisible(findTestObject('00_common/txt_class_text_view', [('text') : hospital_name3]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //page title
//
//'STEP - [<-] 병원상세 뒤로가기 버튼 선택'
//Mobile.tap(findTestObject('00_common/btn_webview_back'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.pressBack()

'기대결과 - 검색 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('09_search/input_search'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [지도보기] 버튼 선택'
Mobile.tap(findTestObject('09_search/btn_map'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 병원 지도 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('09_search/area_naver_map'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //네이버 지도
Mobile.verifyElementVisible(findTestObject('09_search/area_hospital_map_list'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //바텀시트 영역
Mobile.verifyElementText(findTestObject('09_search/txt_map_hospital_name'), hospital_name3, FailureHandling.CONTINUE_ON_FAILURE) //검색 목록 첫번째 병원이름

'STEP - 병원 선택'
Mobile.tap(findTestObject('09_search/area_hospital_map_list'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

//병원상세 요소 못찾아서 보류
//'기대결과 - 병원상세 화면으로 이동'
//Mobile.verifyElementVisible(findTestObject('00_common/txt_class_text_view', [('text') : hospital_name]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//
//'STEP - [<-] 병원상세 뒤로가기 버튼 선택'
//Mobile.tap(findTestObject('00_common/btn_webview_back'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'back key'
Mobile.pressBack()

'기대결과 - 병원 지도 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('09_search/area_naver_map'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //네이버 지도

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색 화면으로 이동'
Mobile.verifyElementText(findTestObject('09_search/input_search'), search_list, FailureHandling.CONTINUE_ON_FAILURE) //검색 영역
	
'STEP - [x] 검색어 삭제 버튼 선택'
Mobile.tap(findTestObject('09_search/btn_search_clear'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
'기대결과 - 검색어 삭제되고, 최근 검색어 노출'
Mobile.verifyElementText(findTestObject('09_search/txt_recent_list'), search_list, FailureHandling.CONTINUE_ON_FAILURE) //검색어
	
'STEP - [x] 최근 검색어 삭제 버튼 선택'
Mobile.tap(findTestObject('09_search/btn_recent_list_delete'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 삭제한 최근 검색어 미노출'
Mobile.verifyElementNotVisible(findTestObject('09_search/txt_recent_list'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}
//

//홈
'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('04_home/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //홈 메뉴(활성화)
Mobile.verifyElementVisible(findTestObject('04_home/area_view_search_bar'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //검색 바
//

'최근앱 삭제'
AndroidDriver<MobileElement> driver = MobileDriverFactory.getDriver()
driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH))
Mobile.tap(findTestObject('00_common_data_delete/btn_all_delete'), 2, FailureHandling.CONTINUE_ON_FAILURE)
