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

//동네 인기 병원
'STEP - {동네 인기 병원} 컨텐츠 선택'
Mobile.tap(findTestObject('04_home/02_contents/txt_local_hospital'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색 화면으로 이동, 인기 병원 검색 리스트 노출'
Mobile.verifyElementText(findTestObject('09_search/input_search'), '인기 많은 똑닥 병원', FailureHandling.CONTINUE_ON_FAILURE) //검색어
Mobile.verifyElementText(findTestObject('09_search/txt_sort_type'), '인기순', FailureHandling.CONTINUE_ON_FAILURE) //sort 타입
Mobile.verifyElementVisible(findTestObject('09_search/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //검색결과 병원명

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('04_home/02_contents/txt_local_hospital'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

//지금 문연 병원
'STEP - {지금 문연 병원} 컨텐츠 선택'
Mobile.tap(findTestObject('04_home/02_contents/txt_open_hospital'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색 화면으로 이동, 검색 필터 적용'
Mobile.verifyElementText(findTestObject('09_search/input_search'), '지금문연병원', FailureHandling.CONTINUE_ON_FAILURE) //검색어
Mobile.verifyElementText(findTestObject('09_search/txt_sort_type'), '관련순', FailureHandling.CONTINUE_ON_FAILURE) //sort 타입
Mobile.verifyElementVisible(findTestObject('09_search/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //병원명
Mobile.verifyElementVisible(findTestObject('09_search/btn_filter_open_on'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //[진료중] 필터 버튼 ON

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('04_home/02_contents/txt_open_hospital'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

//똑닥 엄마들 추천
'STEP - {똑닥 엄마들 추천} 컨텐츠 선택'
Mobile.tap(findTestObject('04_home/02_contents/img_mom_recommend'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색 화면으로 이동, 검색 필터 적용'
Mobile.verifyElementText(findTestObject('09_search/input_search'), '똑닥 엄마들 추천 병원', FailureHandling.CONTINUE_ON_FAILURE) //검색어
Mobile.verifyElementText(findTestObject('09_search/txt_sort_type'), '거리순', FailureHandling.CONTINUE_ON_FAILURE) //sort 타입
Mobile.verifyElementVisible(findTestObject('09_search/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //병원명

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('04_home/02_contents/img_mom_recommend'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

//진료과로 병원 찾기
'STEP - 화면 스크롤 이동'
Mobile.scrollToText('소아청소년과')

'STEP - {소아청소년과} 진료과 컨텐츠 선택'
Mobile.tap(findTestObject('04_home/02_contents/txt_find_hospital_paediatrics'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색 화면으로 이동, 검색 필터 적용'
Mobile.verifyElementText(findTestObject('09_search/input_search'), '소아청소년과', FailureHandling.CONTINUE_ON_FAILURE) //검색어
Mobile.verifyElementText(findTestObject('09_search/btn_medical_department'), '소아청소년과', FailureHandling.CONTINUE_ON_FAILURE) //진료과목 필터 문구
Mobile.verifyElementText(findTestObject('09_search/txt_sort_type'), '관련순', FailureHandling.CONTINUE_ON_FAILURE) //sort 타입
Mobile.verifyElementVisible(findTestObject('09_search/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //병원명

'기대결과 - 병원 리스트 확인'
Mobile.verifyElementText(findTestObject('09_search/txt_main_medical_department'), '소아청소년과', FailureHandling.CONTINUE_ON_FAILURE) //대표 진료과목

'STEP - 화면 스크롤 이동'
Mobile.swipe(45, 1200, 45, 600)

'기대결과 - 병원 리스트 확인'
Mobile.verifyElementText(findTestObject('09_search/txt_main_medical_department'), '소아청소년과', FailureHandling.CONTINUE_ON_FAILURE) //대표 진료과목

'STEP - 화면 스크롤 이동'
Mobile.swipe(45, 1200, 45, 600)

'기대결과 - 병원 리스트 확인'
Mobile.verifyElementText(findTestObject('09_search/txt_main_medical_department'), '소아청소년과', FailureHandling.CONTINUE_ON_FAILURE) //대표 진료과목

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('04_home/02_contents/txt_find_hospital_paediatrics'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

//이런 병원 찾고 계신가요?
'STEP - 화면 스크롤 이동'
Mobile.scrollToText('똑닥 예약 병원')

'STEP - [똑닥 예약 병원] 컨텐츠 선택'
Mobile.tap(findTestObject('04_home/02_contents/txt_like_hospital_reservation'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색 화면으로 이동, 검색 필터 적용'
Mobile.verifyElementText(findTestObject('09_search/input_search'), '똑닥 예약 병원', FailureHandling.CONTINUE_ON_FAILURE) //검색어
Mobile.verifyElementText(findTestObject('09_search/txt_sort_type'), '관련순', FailureHandling.CONTINUE_ON_FAILURE) //sort 타입
Mobile.verifyElementVisible(findTestObject('09_search/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //병원명

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('04_home/02_contents/txt_like_hospital_reservation'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

//영유아 검진 예약하기
'STEP - [영유아 검진 예약하기] 컨텐츠 선택'
Mobile.tap(findTestObject('04_home/02_contents/img_infant_check-up'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 검색 화면으로 이동, 검색 필터 적용'
Mobile.verifyElementText(findTestObject('09_search/input_search'), '영유아검진', FailureHandling.CONTINUE_ON_FAILURE) //검색어
Mobile.verifyElementText(findTestObject('09_search/txt_sort_type'), '관련순', FailureHandling.CONTINUE_ON_FAILURE) //sort 타입
Mobile.verifyElementVisible(findTestObject('09_search/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //병원명 영역
Mobile.verifyElementVisible(findTestObject('09_search/txt_badge', [('text') : '영유아검진']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //영유아검진 뱃지

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('04_home/02_contents/img_infant_check-up'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

'STEP - 최상단 스크롤 이동'
Mobile.scrollToText('질병, 진료과, 병원을 검색해보세요.')

'STEP - 최근앱 삭제'
AndroidDriver<MobileElement> driver = MobileDriverFactory.getDriver()
driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH))
Mobile.tap(findTestObject('00_common_data_delete/btn_all_delete'), 2, FailureHandling.CONTINUE_ON_FAILURE)

