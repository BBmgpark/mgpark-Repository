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

//똑닥 앱 데이터 삭제
'데이터삭제 테스트케이스 불러오기'
Mobile.callTestCase(findTestCase('Sanity_TC/Scenario_00 데이터삭제/00_data_delete'), [:])
//

//앱 실행
'STEP - 똑닥 앱 실행'
Mobile.startExistingApplication(GlobalVariable.appid)

'기대결과 - 이용 권한 안내 화면 노출'
Mobile.verifyElementVisible(findTestObject('00_common/txt_tvTitle', [('text') : '똑닥 앱 이용을 위한 권한 안내']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //타이틀
Mobile.verifyElementVisible(findTestObject('00_common/btn_confirmBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //[확인]

'STEP - [확인] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_confirmBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

//권한 팝업 허용
'STEP - 알림팝업 > [허용] 버튼 선택'
Mobile.tap(findTestObject('01_permission/btn_permission_allow'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 위치정보 액세스 팝업 > [앱 사용 중에만 허용] 버튼 선택'
Mobile.tap(findTestObject('01_permission/btn_permission_location_allow_foreground_only'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 전화 허용 팝업 > [허용] 버튼 선택'
Mobile.tap(findTestObject('01_permission/btn_permission_allow'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

//온보딩 이메일 로그인
'STEP - 온보딩 화면 [이메일 로그인] 버튼 선택'
Mobile.tap(findTestObject('02_onboarding/btn_tvEmailLoginBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 이메일 로그인 화면 노출'
Mobile.verifyElementVisible(findTestObject('03_login/txt_tvLoginTitle'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //타이틀
Mobile.verifyElementVisible(findTestObject('03_login/btn_ivLoginClose'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //[x]

'STEP - 이메일 id 입력'
Mobile.setText(findTestObject('03_login/input_etEmail'), GlobalVariable.email_id_22, GlobalVariable.fixedTime)

'STEP - 이메일 password 입력'
Mobile.setText(findTestObject('03_login/input_etPassword'), GlobalVariable.email_password, GlobalVariable.fixedTime)

'STEP - [로그인하기] 버튼 선택'
Mobile.tap(findTestObject('03_login/btn_tvLoginConfirm'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'카카오 전환 유도 팝업 노출 시 [오늘 하루 보지 않기] 버튼 선택'
if (Mobile.waitForElementPresent(findTestObject('04_home/01_home_popup/btn_kakao_agree_skip'), GlobalVariable.fixedTime))
{
		Mobile.tap(findTestObject('04_home/01_home_popup/btn_kakao_agree_skip'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'마케팅 수신동의 팝업 노출 시 [좋아요] 선택'
if (Mobile.waitForElementPresent(findTestObject('04_home/01_home_popup/btn_maketing_common'), GlobalVariable.fixedTime))
{
		Mobile.tap(findTestObject('04_home/01_home_popup/btn_maketing_common'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'똑닥 어떠셨나요? 팝업 노출 시 [다시 보지 않기] 버튼 선택'
if (Mobile.waitForElementPresent(findTestObject('04_home/01_home_popup/btn_skip'), GlobalVariable.fixedTime))
{
		Mobile.tap(findTestObject('04_home/01_home_popup/btn_skip'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}

'기대결과 - 로그인 상태 홈 화면 노출'
Mobile.verifyElementVisible(findTestObject('04_home/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //홈 메뉴(활성화)
Mobile.verifyElementVisible(findTestObject('04_home/area_view_search_bar'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //검색 바
Mobile.verifyElementNotVisible(findTestObject('04_home/area_constraint_login'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //로그인 유도 미노출

'STEP- [마이페이지] 메뉴 선택'
Mobile.tap(findTestObject('04_home/btn_menu_mypage'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 로그인 상태 마이페이지 노출'
Mobile.verifyElementText(findTestObject('06_mypage/txt_name_title'), GlobalVariable.user_name, FailureHandling.CONTINUE_ON_FAILURE) //이름
Mobile.verifyElementVisible(findTestObject('06_mypage/btn_edit'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //[수정] 버튼
//

//로그아웃
'STEP - 마이페이지 [수정] 버튼 선택'
Mobile.tap(findTestObject('06_mypage/btn_edit'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [로그아웃] 버튼 선택'
Mobile.tap(findTestObject('06_mypage/btn_logout'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [확인] 버튼 선택'
Mobile.tap(findTestObject('06_mypage/btn_logout_confirm'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 로그아웃 상태 마이페이지 노출'
Mobile.verifyElementText(findTestObject('06_mypage/txt_name_title'), '마이페이지', FailureHandling.CONTINUE_ON_FAILURE) //타이틀
Mobile.verifyElementVisible(findTestObject('06_mypage/btn_login'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //[로그인]
//

//홈 <-> 로그인 페이지 이동
'STEP - [홈] 메뉴 선택'
Mobile.tap(findTestObject('04_home/btn_menu_home'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [시작하기] 버튼 선택'
Mobile.tap(findTestObject('04_home/btn_login'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 로그인 화면 노출'
Mobile.verifyElementVisible(findTestObject('02_onboarding/txt_onboarding_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //타이틀
Mobile.verifyElementVisible(findTestObject('03_login/btn_ivClose'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //[x]
Mobile.verifyElementVisible(findTestObject('02_onboarding/btn_onboarding_kakao_login'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //[카카오 로그인]
Mobile.verifyElementVisible(findTestObject('02_onboarding/btn_tvEmailLoginBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //[이메일 로그인]

'STEP - 로그인 화면 [x] 버튼 선택'
Mobile.tap(findTestObject('03_login/btn_ivClose'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('04_home/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //홈 메뉴(활성화)
Mobile.verifyElementVisible(findTestObject('04_home/area_view_search_bar'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //검색 바
//

//홈 이메일 로그인
'STEP - 홈 로그인 [시작하기] 버튼 선택'
Mobile.tap(findTestObject('04_home/btn_login'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [이메일 로그인] 버튼 선택'
Mobile.tap(findTestObject('02_onboarding/btn_tvEmailLoginBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 이메일 로그인 화면 노출'
Mobile.verifyElementVisible(findTestObject('03_login/txt_tvLoginTitle'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //타이틀

'STEP - 이메일 id 입력'
Mobile.setText(findTestObject('03_login/input_etEmail'), GlobalVariable.email_id_22, GlobalVariable.fixedTime)

'STEP - 이메일 password 입력'
Mobile.setText(findTestObject('03_login/input_etPassword'), GlobalVariable.email_password, GlobalVariable.fixedTime)

'STEP - [로그인하기] 버튼 선택'
Mobile.tap(findTestObject('03_login/btn_tvLoginConfirm'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 로그인 상태 홈 화면 노출'
Mobile.verifyElementVisible(findTestObject('04_home/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //홈 메뉴(활성화)
Mobile.verifyElementVisible(findTestObject('04_home/area_view_search_bar'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //검색 바
Mobile.verifyElementNotVisible(findTestObject('04_home/area_constraint_login'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //로그인 유도 미노출

'STEP- [마이페이지] 메뉴 선택'
Mobile.tap(findTestObject('04_home/btn_menu_mypage'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 로그인 상태 마이페이지 노출'
Mobile.verifyElementText(findTestObject('06_mypage/txt_name_title'), GlobalVariable.user_name, FailureHandling.CONTINUE_ON_FAILURE) //이름
Mobile.verifyElementVisible(findTestObject('06_mypage/btn_edit'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //[수정] 버튼
//

//로그아웃
'STEP - 마이페이지 [수정] 버튼 선택'
Mobile.tap(findTestObject('06_mypage/btn_edit'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [로그아웃] 버튼 선택'
Mobile.tap(findTestObject('06_mypage/btn_logout'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 로그아웃 [확인] 버튼 선택'
Mobile.tap(findTestObject('06_mypage/btn_logout_confirm'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 로그아웃 상태 마이페이지 노출'
Mobile.verifyElementText(findTestObject('06_mypage/txt_name_title'), '마이페이지', FailureHandling.CONTINUE_ON_FAILURE) //타이틀
Mobile.verifyElementVisible(findTestObject('06_mypage/btn_login'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //[로그인]
//

//마이페이지 <-> 로그인 페이지 이동
'STEP - 마이페이지 [로그인] 버튼 선택'
Mobile.tap(findTestObject('06_mypage/btn_login'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 로그인 화면 노출'
Mobile.verifyElementVisible(findTestObject('02_onboarding/txt_onboarding_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //타이틀
Mobile.verifyElementVisible(findTestObject('03_login/btn_ivClose'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //[x]

'STEP - 로그인 화면 [x] 버튼 선택'
Mobile.tap(findTestObject('03_login/btn_ivClose'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 마이페이지 화면으로 이동'
Mobile.verifyElementText(findTestObject('06_mypage/txt_name_title'), '마이페이지', FailureHandling.CONTINUE_ON_FAILURE) //타이틀
Mobile.verifyElementVisible(findTestObject('06_mypage/btn_login'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //[로그인]
//

//마이페이지 이메일 로그인
'STEP - 마이페이지 [로그인] 버튼 선택'
Mobile.tap(findTestObject('06_mypage/btn_login'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 로그인 화면 [이메일 로그인] 버튼 선택'
Mobile.tap(findTestObject('02_onboarding/btn_tvEmailLoginBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 이메일 id 입력'
Mobile.setText(findTestObject('03_login/input_etEmail'), GlobalVariable.email_id_22, GlobalVariable.fixedTime)

'STEP - 이메일 password 입력'
Mobile.setText(findTestObject('03_login/input_etPassword'), GlobalVariable.email_password, GlobalVariable.fixedTime)

'STEP - [로그인하기] 버튼 선택'
Mobile.tap(findTestObject('03_login/btn_tvLoginConfirm'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 로그인 상태 마이페이지 노출'
Mobile.verifyElementText(findTestObject('06_mypage/txt_name_title'), GlobalVariable.user_name, FailureHandling.CONTINUE_ON_FAILURE) //이름
Mobile.verifyElementVisible(findTestObject('06_mypage/btn_edit'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //[수정] 버튼
//

'최근앱 삭제'
AndroidDriver<MobileElement> driver = MobileDriverFactory.getDriver()
driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH))
Mobile.tap(findTestObject('00_common_data_delete/btn_all_delete'), 2, FailureHandling.CONTINUE_ON_FAILURE)






