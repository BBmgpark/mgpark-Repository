package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p>Profile default : &#50545;ID
Profile company : &#50545;ID</p>
     */
    public static Object appid
     
    /**
     * <p>Profile default : &#44256;&#51221;&#46108; &#49884;&#44036;
Profile company : &#44256;&#51221;&#46108; &#49884;&#44036;</p>
     */
    public static Object fixedTime
     
    /**
     * <p>Profile default : apk path
Profile company : apk path</p>
     */
    public static Object apk
     
    /**
     * <p></p>
     */
    public static Object user_name
     
    /**
     * <p>Profile default : &#51060;&#47700;&#51068; &#50500;&#51060;&#46356;
Profile company : &#51060;&#47700;&#51068; &#50500;&#51060;&#46356;</p>
     */
    public static Object email_id
     
    /**
     * <p>Profile default : &#51060;&#47700;&#51068; &#54056;&#49828;&#50892;&#46300;
Profile company : &#51060;&#47700;&#51068; &#54056;&#49828;&#50892;&#46300;</p>
     */
    public static Object email_password
     
    /**
     * <p>Profile default : &#51088;&#46041;&#54868; &#44172;&#51221; (&#44592;&#47197;o)
Profile company : &#51088;&#46041;&#54868; &#44172;&#51221; (&#44592;&#47197;o)</p>
     */
    public static Object email_id_22
     
    /**
     * <p>Profile default : &#51088;&#46041;&#54868; &#44228;&#51221; (&#44592;&#47197;x)
Profile company : &#51088;&#46041;&#54868; &#44228;&#51221; (&#44592;&#47197;x)</p>
     */
    public static Object email_id_21
     
    /**
     * <p>Profile default : &#51665; &#51452;&#49548;
Profile company : &#51665; &#51452;&#49548;</p>
     */
    public static Object my_adress
     
    /**
     * <p>Profile default : &#51452;&#49548; &#51060;&#47492;
Profile company : &#54924;&#49324; &#51452;&#49548;</p>
     */
    public static Object adress_name
     
    /**
     * <p>Profile default : &#50864;&#54200;&#48264;&#54840;
Profile company : &#50864;&#54200;&#48264;&#54840;</p>
     */
    public static Object zip_code
     
    /**
     * <p>Profile default : &#49373;&#45380;&#50900;&#51068;
Profile company : &#49373;&#45380;&#50900;&#51068;</p>
     */
    public static Object user_birth_date
     
    /**
     * <p>Profile default : &#48337;&#50896;&#47749;
Profile company : &#48337;&#50896;&#47749;</p>
     */
    public static Object hospital_name
     
    /**
     * <p>Profile default : &#53440;&#51060;&#53952; &#47928;&#44396;
Profile company : &#53440;&#51060;&#53952; &#47928;&#44396;</p>
     */
    public static Object test_title
     
    /**
     * <p>Profile default : &#51032;&#49324;
Profile company : &#51032;&#49324;</p>
     */
    public static Object doctor
     
    /**
     * <p></p>
     */
    public static Object son
     
    /**
     * <p>Profile default : &#50696;&#50557;&#51068;
Profile company : &#50696;&#50557;&#51068;</p>
     */
    public static Object reservation_day
     
    /**
     * <p>Profile default : &#55092;&#45824;&#54256;&#48264;&#54840;
Profile company : &#55092;&#45824;&#54256;&#48264;&#54840;</p>
     */
    public static Object hp
     
    /**
     * <p>Profile default : &#50500;&#46308; &#49373;&#45380;&#50900;&#51068;
Profile company : &#50500;&#46308; &#49373;&#45380;&#50900;&#51068;</p>
     */
    public static Object son_birth_date
     
    /**
     * <p>Profile default : &#47560;&#51060;&#54168;&#51060;&#51648; &gt; &#48260;&#51204;&#51221;&#48372;
Profile company : &#47560;&#51060;&#54168;&#51060;&#51648; &gt; &#48260;&#51204;&#51221;&#48372;</p>
     */
    public static Object version
     
    /**
     * <p>Profile default : &#44032;&#51313;&#44288;&#47532; &#54868;&#47732; 
Profile company : &#44032;&#51313;&#44288;&#47532; &#54868;&#47732; </p>
     */
    public static Object son_info
     
    /**
     * <p>Profile default : &#52852;&#52852;&#50724; &#44228;&#51221; &#51088;&#45376;
Profile company : &#52852;&#52852;&#50724; &#44228;&#51221; &#51088;&#45376;</p>
     */
    public static Object kakao_son
     
    /**
     * <p>Profile company : &#51665; &#49345;&#49464;&#51452;&#49548;</p>
     */
    public static Object my_adress_detail
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += TestCaseMain.getParsedValues(RunConfiguration.getOverridingParameters(), selectedVariables)
    
            appid = selectedVariables['appid']
            fixedTime = selectedVariables['fixedTime']
            apk = selectedVariables['apk']
            user_name = selectedVariables['user_name']
            email_id = selectedVariables['email_id']
            email_password = selectedVariables['email_password']
            email_id_22 = selectedVariables['email_id_22']
            email_id_21 = selectedVariables['email_id_21']
            my_adress = selectedVariables['my_adress']
            adress_name = selectedVariables['adress_name']
            zip_code = selectedVariables['zip_code']
            user_birth_date = selectedVariables['user_birth_date']
            hospital_name = selectedVariables['hospital_name']
            test_title = selectedVariables['test_title']
            doctor = selectedVariables['doctor']
            son = selectedVariables['son']
            reservation_day = selectedVariables['reservation_day']
            hp = selectedVariables['hp']
            son_birth_date = selectedVariables['son_birth_date']
            version = selectedVariables['version']
            son_info = selectedVariables['son_info']
            kakao_son = selectedVariables['kakao_son']
            my_adress_detail = selectedVariables['my_adress_detail']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
