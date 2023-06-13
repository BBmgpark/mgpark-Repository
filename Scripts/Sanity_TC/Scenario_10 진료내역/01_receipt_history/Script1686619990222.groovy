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

'STEP - 진료내역 메뉴 선택'
Mobile.tap(findTestObject('04_home/btn_menu_history'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 화면으로 이동'
Mobile.verifyElementText(findTestObject('05_receipt_history/txt_title'), '진료내역', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [리뷰 관리] 버튼 선택'
Mobile.tap(findTestObject('05_receipt_history/btn_review'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 리뷰 관리 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '리뷰 관리', FailureHandling.CONTINUE_ON_FAILURE)

//AUTO-56 TC 리뷰 반영
'STEP - 리뷰 존재 시 리스트 노출, 존재 하지 않을 시 안내 문구 노출'
if(Mobile.waitForElementPresent(findTestObject('05_receipt_history/area_rvReviewList'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) == true)
{
	'기대결과 - 리뷰 상태 이미지 노출'
	Mobile.verifyElementVisible(findTestObject('05_receipt_history/img_ivReviewState'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'기대결과 - 병원명 노출'
	Mobile.verifyElementVisible(findTestObject('05_receipt_history/txt_tvReviewHospitalTitle'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}
else
{
	'기대결과 - 리뷰 리스트 없는 경우 안내문구 노출'
	Mobile.verifyElementVisible(findTestObject('00_common/txt_class_text_view', [('text') : '똑닥으로 진료 받고\n병원 리뷰를 남겨주세요.']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
}
//

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 화면으로 이동'
Mobile.verifyElementText(findTestObject('05_receipt_history/txt_title'), '진료내역', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [전체대상] 필터 선택'
Mobile.tap(findTestObject('05_receipt_history/btn_filter', [('text') : '전체대상']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료대상 필터 노출'
Mobile.verifyElementVisible(findTestObject('00_common/txt_class_text_view', [('text'): '진료대상 필터']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

//진료내역 목록 1개 존재하는 필터 선택 {자녀}
'STEP - 가족 {삭제금지} 필터 선택'
Mobile.tap(findTestObject('05_receipt_history/txt_family_filter', [('text') : '삭제금지']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [확인] 버튼 선택'
Mobile.tap(findTestObject('00_common/txt_class_text_view', [('text'): '확인']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 화면에 삭제금지 | 본인 이름 목록 노출'
Mobile.verifyElementVisible(findTestObject('05_receipt_history/txt_reception_name', [('text') : '삭제금지']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //자녀
Mobile.verifyElementVisible(findTestObject('05_receipt_history/txt_user_name', [('text') : GlobalVariable.user_name]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //본인
//

//진료내역 없는 필터 선택 {테스트}
'STEP - 진료대상 [삭제금지] 필터 선택'
Mobile.tap(findTestObject('05_receipt_history/btn_filter', [('text') : '삭제금지']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료대상 필터 노출'
Mobile.verifyElementVisible(findTestObject('00_common/txt_class_text_view', [('text'): '진료대상 필터']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 가족 {테스트} 필터 선택'
Mobile.tap(findTestObject('05_receipt_history/txt_family_filter', [('text') : '테스트']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [확인] 버튼 선택'
Mobile.tap(findTestObject('00_common/txt_class_text_view', [('text'): '확인']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 화면에 "설정하신 필터 내역이 없습니다." 안내문구 노출'
Mobile.verifyElementVisible(findTestObject('05_receipt_history/txt_none_list'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [전체내역 보기] 버튼 선택'
Mobile.tap(findTestObject('05_receipt_history/btn_full_history'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료대상 필터 "전체대상"으로 변경'
Mobile.verifyElementVisible(findTestObject('05_receipt_history/btn_filter', [('text') : '전체대상']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

//본인 필터 선택 
'STEP - [전체대상] 필터 선택'
Mobile.tap(findTestObject('05_receipt_history/btn_filter', [('text') : '전체대상']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료대상 필터 노출'
Mobile.verifyElementVisible(findTestObject('00_common/txt_class_text_view', [('text'): '진료대상 필터']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - 본인 필터 선택'
Mobile.tap(findTestObject('05_receipt_history/txt_family_filter', [('text') : GlobalVariable.user_name]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [확인] 버튼 선택'
Mobile.tap(findTestObject('00_common/txt_class_text_view', [('text'): '확인']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 화면에 본인 이름 목록 노출'
Mobile.verifyElementVisible(findTestObject('05_receipt_history/txt_reception_name', [('text') : GlobalVariable.user_name]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - {삭제금지} 이름 목록 미노출'
Mobile.verifyElementNotVisible(findTestObject('05_receipt_history/txt_reception_name', [('text') : '삭제금지']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

//바로접수 동작 확인
'STEP - 화면 스크롤 이동'
Mobile.scrollToText('바로접수')

'STEP - [바로접수] 버튼 선택'
Mobile.tap(findTestObject('05_receipt_history/btn_common_view', [('text') : '바로접수']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 접수하기 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('11_receipt/txt_receipt_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //접수하기 {병원명}

'STEP - [X] 이전 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [네] 버튼 선택'
Mobile.tap(findTestObject('11_receipt/btn_confirm'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 화면으로 이동'
Mobile.verifyElementText(findTestObject('05_receipt_history/txt_title'), '진료내역', FailureHandling.CONTINUE_ON_FAILURE)
//

//시간예약 동작 확인
'STEP - 화면 스크롤 이동'
Mobile.scrollToText('시간예약')

'STEP - [시간예약] 버튼 선택'
Mobile.tap(findTestObject('05_receipt_history/btn_common_view', [('text') : '시간예약']), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 예약하기 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('11_receipt/txt_reservation_title'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //예약하기 {병원명}

'STEP - [X] 이전 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [네] 버튼 선택'
Mobile.tap(findTestObject('11_receipt/btn_confirm'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 화면으로 이동'
Mobile.verifyElementText(findTestObject('05_receipt_history/txt_title'), '진료내역', FailureHandling.CONTINUE_ON_FAILURE)
//

//AUTO-57 TC 리뷰 반영
'STEP - 병원 목록 선택'
Mobile.tap(findTestObject('05_receipt_history/txt_hospital_name'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 상세 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '진료내역 상세', FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 유저 정보 노출'
Mobile.verifyElementVisible(findTestObject('11_receipt/txt_name', [('text') : GlobalVariable.user_name]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //이름

'기대결과 - 진료정보 노출'
Mobile.verifyElementText(findTestObject('05_receipt_history/txt_detail_hospital'), GlobalVariable.hospital_name, FailureHandling.CONTINUE_ON_FAILURE) //병원명
Mobile.verifyElementText(findTestObject('05_receipt_history/txt_office'), '진료실', FailureHandling.CONTINUE_ON_FAILURE) //진료실명

'기대결과 - 결제정보 노출'
Mobile.verifyElementText(findTestObject('05_receipt_history/txt_detail_methodValue'), '직접결제', FailureHandling.CONTINUE_ON_FAILURE) //진료실명
//

'STEP - [<-] 이전 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 진료내역 화면으로 이동'
Mobile.verifyElementText(findTestObject('05_receipt_history/txt_title'), '진료내역', FailureHandling.CONTINUE_ON_FAILURE)
//

'최근앱 삭제'
AndroidDriver<MobileElement> driver = MobileDriverFactory.getDriver()
driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH))
Mobile.tap(findTestObject('00_common_data_delete/btn_all_delete'), 2, FailureHandling.CONTINUE_ON_FAILURE)