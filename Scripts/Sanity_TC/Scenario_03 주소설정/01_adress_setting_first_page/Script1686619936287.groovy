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

//로그아웃
'STEP - 로그인 상태인 경우 로그아웃 진행'
if (Mobile.waitForElementNotPresent(findTestObject('04_home/btn_login'), GlobalVariable.fixedTime))
{
	'STEP - 홈 마이페이지 메뉴 선택'
	Mobile.tap(findTestObject('04_home/btn_menu_mypage'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - [수정] 버튼 선택'
	Mobile.tap(findTestObject('06_mypage/btn_edit'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - [로그아웃] 버튼 선택'
	Mobile.tap(findTestObject('06_mypage/btn_logout'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - 로그아웃 [확인] 버튼 선택'
	Mobile.tap(findTestObject('06_mypage/btn_logout_confirm'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - 홈 메뉴 선택'
	Mobile.tap(findTestObject('04_home/btn_menu_home'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}
//

//비로그인 상태 홈 주소이름 선택                             버그: [이메일 로그인] 버튼 미노출 -> 노출 되면 수정 필요함 (05/24)
'STEP - 홈 주소이름 선택'
Mobile.tap(findTestObject('04_home/txt_home_adress_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 로그인 유도 팝업 노출' 
Mobile.verifyElementText(findTestObject('00_common/txt_tv_title'), '로그인 후에\n서비스를 이용할 수 있어요.', FailureHandling.CONTINUE_ON_FAILURE) //타이틀

'STEP - [카카오로 시작하기] 버튼 선택'
Mobile.tap(findTestObject('02_onboarding/btn_onboarding_kakao_login'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [카카오톡으로 간편로그인] 버튼 선택'
Mobile.tap(findTestObject('00_common/txt_class_text_view', [('text') : '카카오톡으로 간편로그인']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 주소설정 화면 노출'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '주소 설정', FailureHandling.CONTINUE_ON_FAILURE) 
//

// 버그: [이메일 로그인] 버튼 미노출 -> 노출 되면 수정 필요함 (05/24)
////주소 미설정 계정으로 주소설정 화면 진입
//'STEP - [로그인] 버튼 선택'
//Mobile.tap(findTestObject('00_common/btn_positiveTxt'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//
//'STEP - qa21 이메일 로그인 진행'
//Mobile.tap(findTestObject('02_onboarding/btn_tvEmailLoginBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //[이메일 로그인]
//Mobile.setText(findTestObject('03_login/input_etEmail'), GlobalVariable.email_id_21, GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //이메일 id
//Mobile.setText(findTestObject('03_login/input_etPassword'), GlobalVariable.email_password, GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //이메일 pw
//Mobile.tap(findTestObject('03_login/btn_tvLoginConfirm'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //[로그인]
//
//'카카오 전환 유도 팝업 노출 시 닫기'
//if (Mobile.waitForElementPresent(findTestObject('04_home/01_home_popup/btn_kakao_agree_skip'), GlobalVariable.fixedTime))
//{
//		Mobile.tap(findTestObject('04_home/01_home_popup/btn_kakao_agree_skip'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//}
//
//'마케팅 수신동의 팝업 노출 시 [좋아요] 선택'
//if (Mobile.waitForElementPresent(findTestObject('04_home/01_home_popup/btn_maketing_common'), GlobalVariable.fixedTime))
//{
//		Mobile.tap(findTestObject('04_home/01_home_popup/btn_maketing_common'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//}
//
//'똑닥 어떠셨나요? 팝업 노출 시 [다시 보지 않기] 버튼 선택'
//if (Mobile.waitForElementPresent(findTestObject('04_home/01_home_popup/btn_skip'), GlobalVariable.fixedTime))
//{
//		Mobile.tap(findTestObject('04_home/01_home_popup/btn_skip'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//}
//
//'기대결과 - {우리집} 미설정 상태 주소설정 화면 노출'
//Mobile.verifyElementVisible(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //[뒤로가기]
//Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '주소 설정', FailureHandling.CONTINUE_ON_FAILURE) //타이틀
//Mobile.verifyElementNotVisible(findTestObject('07_adress_setting/btn_edit'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //[편집]
//Mobile.verifyElementVisible(findTestObject('07_adress_setting/txt_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //"어디에 있는 병원을 찾으세요?"
//Mobile.verifyElementVisible(findTestObject('07_adress_setting/btn_current_location'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //[현위치에서 병원 찾기]
//Mobile.verifyElementVisible(findTestObject('07_adress_setting/btn_my_home_find_hospital'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //[우리집 근처 병원 찾기]
//Mobile.verifyElementVisible(findTestObject('07_adress_setting/btn_different_location'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //[다른 위치에서 병원 찾기]
////

'STEP - 뒤로가기 [<-] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'똑닥 어떠셨나요? 팝업 노출 시 [다시 보지 않기] 버튼 선택'
if (Mobile.waitForElementPresent(findTestObject('04_home/01_home_popup/btn_skip'), GlobalVariable.fixedTime))
{
		Mobile.tap(findTestObject('04_home/01_home_popup/btn_skip'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'기대결과 - 홈 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('04_home/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //홈 메뉴(활성화)
Mobile.verifyElementVisible(findTestObject('04_home/area_view_search_bar'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //검색 바

//로그인 상태 주소설정 진입
'STEP - 홈 주소이름 선택'
Mobile.tap(findTestObject('04_home/txt_home_adress_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 주소설정 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '주소 설정', FailureHandling.CONTINUE_ON_FAILURE) //타이틀
	
//        버그: [이메일 로그인] 버튼 미노출 -> 노출 되면 수정 필요함 (05/24)
//'STEP - [우리집 근처 병원 찾기] 선택'
//Mobile.tap(findTestObject('07_adress_setting/btn_my_home_find_hospital'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//
//'기대결과 - 주소 검색하기 화면 노출'
//Mobile.verifyElementVisible(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //[뒤로가기]
//Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '주소 검색하기', FailureHandling.CONTINUE_ON_FAILURE) //타이틀
//	
//'STEP - [X] 버튼 선택'
//Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//
//'기대결과 - 주소 설정 화면으로 이동'
//Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '주소 설정', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [<-] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('04_home/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //홈 메뉴(활성화)
Mobile.verifyElementVisible(findTestObject('04_home/area_view_search_bar'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //검색 바
//

'최근앱 삭제'
AndroidDriver<MobileElement> driver = MobileDriverFactory.getDriver()
driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH))
Mobile.tap(findTestObject('00_common_data_delete/btn_all_delete'), 2, FailureHandling.CONTINUE_ON_FAILURE)
