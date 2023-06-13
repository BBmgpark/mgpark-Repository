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
import java.awt.Toolkit
import java.awt.datatransfer.DataFlavor
import io.appium.java_client.android.nativekey.AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.AppiumDriver
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.MobileElement

'STEP - 똑닥 앱 실행'
Mobile.startExistingApplication(GlobalVariable.appid)

'STEP - 마이페이지 메뉴 선택'
Mobile.tap(findTestObject('04_home/btn_menu_mypage'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 가족관리 메뉴 선택'
Mobile.tap(findTestObject('06_mypage/btn_family'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 가족관리 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '가족관리', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [+] 공유계정 추가 버튼 선택'
Mobile.tap(findTestObject('12_family/btn_add'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 공유계정 추가 화면으로 이동 '
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '공유계정 추가', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [초대코드 생성하기] 버튼 선택'
Mobile.tap(findTestObject('12_family/btn_common', [('text') : '초대코드 생성하기']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 초대코드 바텀 시트 노출'
Mobile.verifyElementText(findTestObject('12_family/txt_view_title'), '초대코드', FailureHandling.CONTINUE_ON_FAILURE)

'초대코드 변수 저장'
invite_code = Mobile.getText(findTestObject('12_family/txt_invite_code'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [x] 버튼 선택'
Mobile.tap(findTestObject('12_family/btn_invite_code_close'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 가족관리 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '가족관리', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

//로그아웃
'STEP - [수정] 버튼 선택'
Mobile.tap(findTestObject('06_mypage/btn_edit'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [로그아웃] 버튼 선택'
Mobile.tap(findTestObject('06_mypage/btn_logout'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 로그아웃 [확인] 버튼 선택'
Mobile.tap(findTestObject('06_mypage/btn_logout_confirm'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

//마이페이지 카카오 계정 로그인
'STEP - 마이페이지 [로그인] 버튼 선택'
Mobile.tap(findTestObject('06_mypage/btn_login'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [카카오로 시작하기] 버튼 선택'
Mobile.tap(findTestObject('02_onboarding/btn_onboarding_kakao_login'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [카카오톡으로 간편로그인] 버튼 선택'
Mobile.tap(findTestObject('00_common/txt_class_text_view', [('text') : '카카오톡으로 간편로그인']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

//카카오 계정으로 초대코드 입력하여 가족연동
'STEP - 가족관리 메뉴 선택'
Mobile.tap(findTestObject('06_mypage/btn_family'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 자녀 리스트가 있는 경우 첫번째 자녀 이름 저장'
if(Mobile.waitForElementPresent(findTestObject('12_family/txt_rv_child'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) == true)
{
	GlobalVariable.kakao_son = Mobile.getText(findTestObject('12_family/txt_kakao_son_name'), GlobalVariable.fixedTime)
}
else
{
	GlobalVariable.kakao_son = 'no'
}

'STEP - [+] 공유계정 추가 버튼 선택'
Mobile.tap(findTestObject('12_family/btn_add'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 공유계정 추가 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '공유계정 추가', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [공유받은 초대코드 입력하기] 버튼 선택'
Mobile.tap(findTestObject('12_family/btn_common', [('text') : '공유받은 초대코드 입력하기']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 초대 코드 입력'
Mobile.setText(findTestObject('12_family/input_invitation_code'), invite_code, GlobalVariable.fixedTime)

'STEP - [확인] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_tvCommonButtonView'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 가족 연동 완료 팝업 노출'
Mobile.verifyElementText(findTestObject('12_family/txt_view_title'), GlobalVariable.user_name+'님과 연동이 완료되었습니다.', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [확인] 버튼 선택'
Mobile.tap(findTestObject('12_family/btn_common_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 공유 연동 계정에 [대표] 뱃지 노출'
Mobile.verifyElementVisible(findTestObject('12_family/txt_badge_2'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 공유 연동 계정 이름 노출'
Mobile.verifyElementText(findTestObject('12_family/txt_family_name'), GlobalVariable.user_name, FailureHandling.CONTINUE_ON_FAILURE)

//연동된 자녀 확인
'기대결과 - 이메일 계정 연동된 자녀 목록 노출'
Mobile.verifyElementVisible(findTestObject('12_family/txt_name', [('text') : GlobalVariable.son]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //이름
Mobile.verifyElementVisible(findTestObject('12_family/txt_birthday', [('text') : GlobalVariable.son_info]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //생년월일

'기대결과 - 카카오 계정 가족 리스트가 있는 경우 연동 자녀 노출'
if(GlobalVariable.kakao_son != 'no')
{
	Mobile.verifyElementVisible(findTestObject('12_family/txt_name', [('text') : GlobalVariable.kakao_son]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) 
}
//

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

//로그아웃
'STEP - [수정] 버튼 선택'
Mobile.tap(findTestObject('06_mypage/btn_edit'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [로그아웃] 버튼 선택'
Mobile.tap(findTestObject('06_mypage/btn_logout'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 로그아웃 [확인] 버튼 선택'
Mobile.tap(findTestObject('06_mypage/btn_logout_confirm'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

//qa22 계정 로그인
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
//

//가족 연동 확인
'STEP - 마이페이지 메뉴 선택'
Mobile.tap(findTestObject('04_home/btn_menu_mypage'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 가족관리 메뉴 선택'
Mobile.tap(findTestObject('06_mypage/btn_family'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 가족 연동 완료 팝업 노출'
Mobile.verifyElementText(findTestObject('12_family/txt_view_title'), GlobalVariable.user_name+'님과 연동이 완료되었습니다.', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [확인] 버튼 선택'
Mobile.tap(findTestObject('12_family/btn_common_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 가족관리 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '가족관리', FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('12_family/txt_badge_1'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //본인 계정에 [대표] 뱃지 노출
Mobile.verifyElementText(findTestObject('12_family/txt_family_name'), GlobalVariable.user_name, FailureHandling.CONTINUE_ON_FAILURE) //가족연동 계정 이름 노출
Mobile.verifyElementVisible(findTestObject('12_family/btn_family_delete'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //가족연동 계정에 [x] 버튼 노출

'기대결과 - 이메일 게정 연동된 자녀 목록 노출'
Mobile.verifyElementVisible(findTestObject('12_family/txt_name', [('text') : GlobalVariable.son]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //이름
Mobile.verifyElementVisible(findTestObject('12_family/txt_birthday', [('text') : GlobalVariable.son_info]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //생년월일

'기대결과 - 카카오 계정 가족 리스트가 있는 경우 연동 자녀 노출'
if(GlobalVariable.kakao_son != 'no')
{
	Mobile.verifyElementVisible(findTestObject('12_family/txt_name', [('text') : GlobalVariable.kakao_son]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}
//

//자녀 삭제(qa22_아들)
'STEP - 자녀 선택'
Mobile.tap(findTestObject('12_family/txt_name', [('text') : GlobalVariable.son]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [편집] 버튼 선택'
Mobile.tap(findTestObject('12_family/btn_edit'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 가족 관리 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '가족 관리', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [삭제] 버튼 선택'
Mobile.tap(findTestObject('12_family/btn_delete'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 확인 팝업 [삭제] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_positiveTxt'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 가족 관리 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '가족관리', FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 자녀 정보 미노출'
Mobile.verifyElementNotVisible(findTestObject('12_family/txt_name', [('text') : GlobalVariable.son]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //이름
//

//계정 연동 해제
'STEP - [x] 공유계정 해제 버튼 선택'
Mobile.tap(findTestObject('12_family/btn_family_delete'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 공유계정 해지하기 바텀시트 노출'
Mobile.verifyElementText(findTestObject('12_family/txt_view_title'), '공유계정 해지하기', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [아니오] 버튼 선택'
Mobile.tap(findTestObject('12_family/btn_common', [('text') : '아니요']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 바텀시트 닫히고, 가족관리 화면 노출'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '가족관리', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [x] 공유계정 해제 버튼 선택'
Mobile.tap(findTestObject('12_family/btn_family_delete'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [네, 해지 하겠습니다.] 버튼 선택'
Mobile.tap(findTestObject('12_family/btn_common', [('text') : '네, 해지 하겠습니다.']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 가족 계정 연동 해제 상태 노출'
Mobile.verifyElementVisible(findTestObject('12_family/btn_add'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //[+] 공유계정 추가 버튼 노출
//

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'최근앱 삭제'
AndroidDriver<MobileElement> driver = MobileDriverFactory.getDriver()
driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH))
Mobile.tap(findTestObject('00_common_data_delete/btn_all_delete'), 2, FailureHandling.CONTINUE_ON_FAILURE)


