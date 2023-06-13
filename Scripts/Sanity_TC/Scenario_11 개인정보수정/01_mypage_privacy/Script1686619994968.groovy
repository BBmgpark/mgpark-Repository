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

'STEP - 마이페이지 메뉴 선택'
Mobile.tap(findTestObject('04_home/btn_menu_mypage'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [수정] 버튼 선택'
Mobile.tap(findTestObject('06_mypage/btn_edit'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 개인정보 수정 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '개인정보 수정', FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 개인정보 확인'
Mobile.verifyElementVisible(findTestObject('06_mypage/txt_description', [('text') : GlobalVariable.user_name]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //이름
Mobile.verifyElementVisible(findTestObject('06_mypage/txt_description', [('text') : GlobalVariable.hp]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //휴대폰 번호
Mobile.verifyElementVisible(findTestObject('06_mypage/txt_description', [('text') : GlobalVariable.email_id_22]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //이메일

'STEP - 휴대폰 번호 선택'
Mobile.tap(findTestObject('06_mypage/txt_description', [('text') : GlobalVariable.hp]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 인증하기 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '인증하기', FailureHandling.CONTINUE_ON_FAILURE) //타이틀
Mobile.verifyElementText(findTestObject('00_common/btn_confirmBtn'), '본인 인증하기', FailureHandling.CONTINUE_ON_FAILURE) //버튼

'STEP - [본인 인증하기] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_confirmBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 휴대폰 인증 화면 노출'
Mobile.verifyElementVisible(findTestObject('00_common/txt_class_text_view', [('text') : '본인 인증하기']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //타이틀
Mobile.verifyElementVisible(findTestObject('00_common/txt_class_text_view', [('text') : '이용중이신 통신사를 선택해주세요.']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //안내

'STEP - back 버튼'
Mobile.pressBack()

'기대결과 - 개인정보 수정 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '개인정보 수정', FailureHandling.CONTINUE_ON_FAILURE)

//주소 편집
'STEP - 주소 영역 선택'
Mobile.tap(findTestObject('06_mypage/txt_tv_title', [('text') : '주소']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 주소 검색하기 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '주소 검색하기', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 주소 입력'
Mobile.setText(findTestObject('07_adress_setting/input_adress_search_adress'), '경기 시흥시 배곧전원로 12-1', GlobalVariable.fixedTime)

'STEP - [검색] 버튼 선택'
Mobile.tap(findTestObject('07_adress_setting/btn_adress_search'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 도로명 주소 선택'
Mobile.tap(findTestObject('07_adress_setting/txt_adress_road_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [등록] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_tvCommonButtonView'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 개인정보 수정 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '개인정보 수정', FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('06_mypage/txt_adress', [('text') : '경기 시흥시 배곧전원로 12-1 (배곧동)  (15010)']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //주소
//

//주소 원복
'STEP - 주소 영역 선택'
Mobile.tap(findTestObject('06_mypage/txt_tv_title', [('text') : '주소']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 주소 검색하기 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '주소 검색하기', FailureHandling.CONTINUE_ON_FAILURE)

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

'기대결과 - 수정된 주소 노출'
Mobile.verifyElementVisible(findTestObject('06_mypage/txt_adress', [('text') : '경기 부천시 부흥로 49 (상동, 백송마을)  (14591)']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

'STEP - [연동하기] 버튼 선택'
Mobile.tap(findTestObject('06_mypage/btn_kakao'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 카카오 계정 로그인 컨테이너 노출 노출'
Mobile.verifyElementVisible(findTestObject('06_mypage/btn_kakao_container'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //카카오톡으로 간편로그인
Mobile.verifyElementVisible(findTestObject('06_mypage/btn_other_container'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //다른 카카오계정으로 로그인

'STEP - [x] 버튼 선택'
Mobile.tap(findTestObject('06_mypage/btn_kakao_container_close'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 비밀번호 재설정 선택'
Mobile.tap(findTestObject('06_mypage/txt_password'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 비밀번호 재설정 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('06_mypage/txt_password_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //타이틀

'STEP - [x] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_close'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 개인정보 수정 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '개인정보 수정', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 개인정보 유효기간 변경 선택'
Mobile.tap(findTestObject('06_mypage/txt_edit_term'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 개인정보 유효기간 변경 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('06_mypage/txt_edit_term_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [완료] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_confirmBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 개인정보 수정 화면 노출'
Mobile.verifyElementText(findTestObject('06_mypage/txt_popup_title'), '개인정보 유효기간 변경 완료', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [완료] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_positiveTxt'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 개인정보 수정 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '개인정보 수정', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [<-] 이전 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'최근앱 삭제'
AndroidDriver<MobileElement> driver = MobileDriverFactory.getDriver()
driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH))
Mobile.tap(findTestObject('00_common_data_delete/btn_all_delete'), 2, FailureHandling.CONTINUE_ON_FAILURE)


