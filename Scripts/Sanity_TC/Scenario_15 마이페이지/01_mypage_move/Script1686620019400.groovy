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

'STEP - 마이페이지 메뉴 진입'
Mobile.tap(findTestObject('04_home/btn_menu_mypage'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

//알림 페이지 이동
'STEP - 병원 알림 버튼 선택'
Mobile.tap(findTestObject('06_mypage/btn_alarm'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 병원 알림 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '병원 알림', FailureHandling.CONTINUE_ON_FAILURE)

//AUTO-59
'STEP - 병원 알림 리스트가 없는 경우 안내 문구 화면 노출'
if(Mobile.waitForElementPresent(findTestObject('06_mypage/txt_hospitalPushList'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) == false)
{
	Mobile.verifyElementText(findTestObject('06_mypage/txt_emptyTitleTxt'), '병원 알림 내역이 없습니다.', FailureHandling.CONTINUE_ON_FAILURE)
}
//AUTO-59

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

//설정 페이지 이동
'STEP - 설정 버튼 선택'
Mobile.tap(findTestObject('06_mypage/btn_setting'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 알림 및 동의 설정 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '알림 및 동의 설정', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

//실손보험 청구 페이지 이동
'STEP - 실손보험 청구 선택'
Mobile.tap(findTestObject('06_mypage/txt_insurance'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 실손보험 청구 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '실손보험 청구', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

//모바일 서류보관함 페이지 이동
'STEP - 모바일 서류보관함 선택'
Mobile.tap(findTestObject('06_mypage/txt_document'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

if(Mobile.waitForElementPresent(findTestObject('06_mypage/btn_document'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE))
{
	'STEP - [모바일 서류 받기] 버튼 선택'
	Mobile.tap(findTestObject('06_mypage/btn_document'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'STEP - 모바일 서류 자동발급 설정 성공 팝업 [확인] 버튼 선택'
	Mobile.tap(findTestObject('06_mypage/btn_document_confirm'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
	
	'기대결과 - 모바일 서류보관함 화면 노출'
	Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '모바일 서류보관함', FailureHandling.CONTINUE_ON_FAILURE)	
}
else
{
	'기대결과 - 모바일 서류보관함 화면으로 이동'
	Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '모바일 서류보관함', FailureHandling.CONTINUE_ON_FAILURE)
}

'STEP - [설정] 버튼 선택'
Mobile.tap(findTestObject('06_mypage/btn_document_option'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 모바일 서류 자동발급 설정 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '모바일 서류 자동발급 설정', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 모바일 서류보관함 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '모바일 서류보관함', FailureHandling.CONTINUE_ON_FAILURE)

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

//결제수단 관리 페이지 이동
'STEP - 결제수단 관리 선택'
Mobile.tap(findTestObject('06_mypage/txt_payment'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 결제수단 관리 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '결제수단 관리', FailureHandling.CONTINUE_ON_FAILURE) //타이틀
Mobile.verifyElementVisible(findTestObject('06_mypage/btn_payments_start'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //[자동결제 시작하기] 버튼

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

//복약관리 페이지 이동
'STEP - 복약 관리 선택'
Mobile.tap(findTestObject('06_mypage/txt_medicine'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 복약 관리 화면으로 이동'
Mobile.verifyElementText(findTestObject('00_common/txt_titleTxt'), '복약 관리', FailureHandling.CONTINUE_ON_FAILURE) //타이틀
Mobile.verifyElementVisible(findTestObject('06_mypage/btn_prescription'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //[처방전 등록] 버튼

'STEP - [<-] 뒤로가기 버튼 선택'
Mobile.tap(findTestObject('00_common/btn_backBtn'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

'STEP - 화면 스크롤 이동'
Mobile.scrollToText('약관 보기')

//1:1 채팅 상담 페이지 이동
'STEP - [1:1 채팅 상담] 버튼 선택'
Mobile.tap(findTestObject('06_mypage/btn_consulting'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)

'기대결과 - 똑닥 고객센터 화면으로 이동'
Mobile.verifyElementVisible(findTestObject('06_mypage/txt_service_center'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) 

'뒤로가기'
Mobile.pressBack(FailureHandling.CONTINUE_ON_FAILURE)
//

//'STEP - 화면 스크롤 이동'
//Mobile.scrollToText('약관 보기')
//
////공지사항 페이지 이동 (x) 진입 시간 1분 걸림 
//'STEP - [공지사항] 버튼 선택'
//Mobile.tap(findTestObject('06_mypage/btn_noti'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//
//'기대결과 - 공지사항 화면 노출'
//Mobile.verifyElementVisible(findTestObject('06_mypage/txt_noti'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE) //[처방전 등록] 버튼
//
//'STEP - [<-] 뒤로가기 버튼 선택'
//Mobile.tap(findTestObject('00_common/btn_webview_back'), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
////

'STEP - 화면 스크롤 이동'
Mobile.scrollToText('약관 보기')

//버전정보 확인
'기대결과 - 버전 정보 노출'
Mobile.verifyElementVisible(findTestObject('06_mypage/txt_noti', [('text') : GlobalVariable.version]), GlobalVariable.fixedTime, FailureHandling.CONTINUE_ON_FAILURE)
//

'최근앱 삭제'
AndroidDriver<MobileElement> driver = MobileDriverFactory.getDriver()
driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH))
Mobile.tap(findTestObject('00_common_data_delete/btn_all_delete'), 2, FailureHandling.CONTINUE_ON_FAILURE)