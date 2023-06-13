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

//앱 실행
'STEP - 똑닥 앱 실행'
Mobile.startExistingApplication(GlobalVariable.appid)
//

//주소 편집
'STEP - 홈 주소이름 선택'
Mobile.tap(findTestObject('04_home/txt_home_adress_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 주소 설정 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '주소 설정', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [편집] 버튼 선택'
Mobile.tap(findTestObject('07_adress_setting/btn_edit'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 주소 편집 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '주소 편집', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 주소 설정 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '주소 설정', FailureHandling.CONTINUE_ON_FAILURE)
//

//우리집 주소 편집
'STEP - [편집] 버튼 선택'
Mobile.tap(findTestObject('07_adress_setting/btn_edit'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 주소 편집 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '주소 편집', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 우리집 [수정] 버튼 선택'
Mobile.tap(findTestObject('07_adress_setting/btn_modify'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 주소 검색하기 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '주소 검색하기', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 주소 입력'
Mobile.setText(findTestObject('07_adress_setting/input_adress_search_adress'), '경기 시흥시 배곧전원로 12-1', GlobalVariable.fixedTime)

'STEP - [검색] 버튼 선택'
Mobile.tap(findTestObject('07_adress_setting/btn_adress_search'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 도로명 주소 선택'
Mobile.tap(findTestObject('07_adress_setting/txt_adress_road_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 상세주소 입력 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '상세주소 입력', FailureHandling.STOP_ON_FAILURE) //타이틀
Mobile.verifyElementVisible(findTestObject('07_adress_setting/txt_adress_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //"주소"
Mobile.verifyElementText(findTestObject('07_adress_setting/input_adress_detail_adress'), '경기 시흥시 배곧전원로 12-1 (배곧동) (15010)', FailureHandling.CONTINUE_ON_FAILURE) //편집한 주소
Mobile.verifyElementVisible(findTestObject('07_adress_setting/txt_adress_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //"상세주소 (선택)"
Mobile.verifyElementNotVisible(findTestObject('07_adress_setting/input_adress_detail_adress_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //{주소 이름}

'STEP - 상세주소 입력'
Mobile.setText(findTestObject('07_adress_setting/input_adress_detail_adress_detail'), '우리집 상세주소', GlobalVariable.fixedTime)

'STEP - [등록] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_tvCommonButtonView'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 주소 편집 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '주소 편집', FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 수정된 우리집 주소 정보 노출'
Mobile.verifyElementText(findTestObject('07_adress_setting/txt_adress'), '경기 시흥시 배곧전원로 12-1 (배곧동) 우리집 상세주소', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 주소 설정 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '주소 설정', FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 수정된 우리집 주소 정보 노출'
Mobile.verifyElementText(findTestObject('07_adress_setting/txt_adress'), '경기 시흥시 배곧전원로 12-1 (배곧동) 우리집 상세주소', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('04_home/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //홈 메뉴(활성화)
Mobile.verifyElementVisible(findTestObject('04_home/area_view_search_bar'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //검색 바

'STEP - 마이페이지 메뉴 선택'
Mobile.tap(findTestObject('04_home/btn_menu_mypage'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [수정] 버튼 선택'
Mobile.tap(findTestObject('06_mypage/btn_edit'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 개인정보 수정 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '개인정보 수정', FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 수정된 주소 정보 노출'
Mobile.verifyElementVisible(findTestObject('06_mypage/txt_adress', [('text') : '경기 시흥시 배곧전원로 12-1 (배곧동) 우리집 상세주소 (15010)']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

//마이페이지에서 주소 수정
'STEP - 주소 영역 선택'
Mobile.tap(findTestObject('06_mypage/txt_tv_title', [('text') : '주소']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 주소 영역 선택'
Mobile.tap(findTestObject('07_adress_setting/input_adress_search_adress'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 주소 입력'
Mobile.setText(findTestObject('07_adress_setting/input_adress_search_adress'), GlobalVariable.my_adress, GlobalVariable.fixedTime)

'STEP - [검색] 버튼 선택'
Mobile.tap(findTestObject('07_adress_setting/btn_adress_search'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 도로명 주소 선택'
Mobile.tap(findTestObject('07_adress_setting/txt_adress_road_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [등록] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_tvCommonButtonView'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 개인정보 수정 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '개인정보 수정', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [홈] 메뉴 선택'
Mobile.tap(findTestObject('04_home/btn_menu_home'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 홈 주소이름 선택'
Mobile.tap(findTestObject('04_home/txt_home_adress_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 주소 설정 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '주소 설정', FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 수정된 우리집 주소 정보 노출'
Mobile.verifyElementText(findTestObject('07_adress_setting/txt_adress'), GlobalVariable.my_adress, FailureHandling.CONTINUE_ON_FAILURE)
//

//주소 목록 선택 - 현위치 선택
'STEP - 주소설정 화면 [현위치에서 병원 찾기] 버튼 선택'
Mobile.tap(findTestObject('07_adress_setting/btn_current_location'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동, 주소이름 {현위치} 노출'
Mobile.verifyElementText(findTestObject('04_home/txt_home_adress_name'), GlobalVariable.adress_name, FailureHandling.CONTINUE_ON_FAILURE)
//

//주소 목록 선택 - 우리집 선택
'STEP - 홈 주소이름 영역 선택'
Mobile.tap(findTestObject('04_home/txt_home_adress_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 주소 설정 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '주소 설정', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 주소설정 화면 [우리집] 선택'
Mobile.tap(findTestObject('07_adress_setting/btn_my_home'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동, 주소이름 {우리집} 노출'
Mobile.verifyElementText(findTestObject('04_home/txt_home_adress_name'), '우리집', FailureHandling.CONTINUE_ON_FAILURE)
//

//주소 목록 선택 - 그 외
'STEP - 홈 주소이름 선택'
Mobile.tap(findTestObject('04_home/txt_home_adress_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 주소 설정 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '주소 설정', FailureHandling.CONTINUE_ON_FAILURE)

'등록한 주소 정보가 없는경우 주소 등록'
if(Mobile.waitForElementNotPresent(findTestObject('07_adress_setting/btn_different_adress_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE))
{
	'STEP - [다른 위치에서 병원 찾기] 버튼 선택'
	Mobile.tap(findTestObject('07_adress_setting/btn_different_location'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'기대결과 - 주소 검색하기 타이틀 노출'
	Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '주소 검색하기', FailureHandling.STOP_ON_FAILURE)
	
	'STEP - 주소 입력'
	Mobile.setText(findTestObject('07_adress_setting/input_adress_search_adress'), '경기 시흥시 배곧전원로 12-1', GlobalVariable.fixedTime)
	
	'STEP - [검색] 버튼 선택'
	Mobile.tap(findTestObject('07_adress_setting/btn_adress_search'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - 도로명 주소 선택'
	Mobile.tap(findTestObject('07_adress_setting/txt_adress_road_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'기대결과 - 상세주소 입력 타이틀 노출'
	Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '상세주소 입력', FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - 상세주소 입력'
	Mobile.setText(findTestObject('07_adress_setting/input_adress_detail_adress_detail'), '1234', GlobalVariable.fixedTime)
	
	'STEP - 주소이름 입력'
	Mobile.setText(findTestObject('07_adress_setting/input_adress_detail_adress_name'), 'TEST', GlobalVariable.fixedTime)
	
	'STEP - [등록] 버튼 선택'
	Mobile.tap(findTestObject('00_common/btn_tvCommonButtonView'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

Mobile.delay(2)

'STEP - 주소이름 {TEST} 선택'
Mobile.tap(findTestObject('07_adress_setting/btn_different_adress_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동, 주소이름 {TEST} 노출'
Mobile.verifyElementText(findTestObject('04_home/txt_home_adress_name'), 'TEST', FailureHandling.CONTINUE_ON_FAILURE)
//

'최근앱 삭제'
AndroidDriver<MobileElement> driver = MobileDriverFactory.getDriver()
driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH))
Mobile.tap(findTestObject('00_common_data_delete/btn_all_delete'), 2, FailureHandling.CONTINUE_ON_FAILURE)