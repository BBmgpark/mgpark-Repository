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

'STEP - 개인화 영역 선택'
Mobile.tap(findTestObject('04_home/txt_tvHospitalTitle'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 상세 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '진료내역 상세', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [예약취소] 버튼 선택'
Mobile.tap(findTestObject('05_receipt_history/btn_detail_reservation_cancel'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 예약취소 팝업 노출'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '예약취소', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [예약취소] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_positiveTxt'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 상세 [시간예약] 버튼 노출'
Mobile.verifyElementVisible(findTestObject('05_receipt_history/btn_time_reservation'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 상세 [예약취소] 버튼 미노출'
Mobile.verifyElementNotVisible(findTestObject('05_receipt_history/btn_detail_reservation_cancel'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [<-] 이전 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('04_home/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 개인화 영역 선택'
Mobile.tap(findTestObject('04_home/txt_tvHospitalTitle'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 상세 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '진료내역 상세', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [예약취소] 버튼 선택'
Mobile.tap(findTestObject('05_receipt_history/btn_detail_reservation_cancel'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 예약취소 팝업 노출'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '예약취소', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [예약취소] 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_positiveTxt'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 상세 [시간예약] 버튼 노출'
Mobile.verifyElementVisible(findTestObject('05_receipt_history/btn_time_reservation'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 상세 [예약취소] 버튼 미노출'
Mobile.verifyElementNotVisible(findTestObject('05_receipt_history/btn_detail_reservation_cancel'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [<-] 이전 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('04_home/btn_menu_home_selected'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 진료내역 메뉴 선택'
Mobile.tap(findTestObject('04_home/btn_menu_history'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('05_receipt_history/txt_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementText(findTestObject('05_receipt_history/txt_hospital_name'), GlobalVariable.hospital_name, FailureHandling.CONTINUE_ON_FAILURE) //병원명
Mobile.verifyElementText(findTestObject('05_receipt_history/txt__deny_reason'), '본인 요청으로 예약이 취소되었어요.', FailureHandling.CONTINUE_ON_FAILURE) //취소사유
Mobile.verifyElementText(findTestObject('00_common/btn_tvCommonButtonView'), '시간예약', FailureHandling.CONTINUE_ON_FAILURE) //[시간예약] 버튼 노출

'STEP - 홈 메뉴 선택'
Mobile.tap(findTestObject('04_home/btn_menu_home'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 홈 화면에 개인화 영역 미노출'
Mobile.verifyElementNotVisible(findTestObject('04_home/area_vp_progress'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'등록한 {아들} 자녀 삭제'
Mobile.tap(findTestObject('04_home/btn_menu_mypage'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //마이페이지
Mobile.tap(findTestObject('06_mypage/btn_family'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //가족관리
Mobile.tap(findTestObject('12_family/txt_name_list', [('text') : '아들']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //아들 선택
Mobile.scrollToText('편집') //스크롤 이동
Mobile.tap(findTestObject('12_family/btn_edit'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //[편집]
Mobile.tap(findTestObject('12_family/btn_delete'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //[삭제]
Mobile.tap(findTestObject('00_common/btn_positiveTxt'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //삭제 확인
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) // 이전 버튼
Mobile.tap(findTestObject('04_home/btn_menu_home'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //홈 메뉴

'최근앱 삭제'
AndroidDriver<MobileElement> driver = MobileDriverFactory.getDriver()
driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH))
Mobile.tap(findTestObject('00_common_data_delete/btn_all_delete'), 2, FailureHandling.CONTINUE_ON_FAILURE)