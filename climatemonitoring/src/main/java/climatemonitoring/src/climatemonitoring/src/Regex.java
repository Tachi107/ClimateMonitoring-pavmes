package climatemonitoring.src;
import java.util.regex.*;


public  class Regex {
    
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static final Pattern  VALIDPSW = Pattern.compile( "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()\u2013[{}]:;',?/*~$^+=<>]).{8,20}$");

    public static final Pattern  VALIDcf = Pattern.compile("^([A-Z]{6}[0-9LMNPQRSTUV]{2}[ABCDEHLMPRST]{1}[0-9LMNPQRSTUV]{2}[A-Z]{1}[0-9LMNPQRSTUV]{3}[A-Z]{1})$|([0-9]{11})$", Pattern.CASE_INSENSITIVE);

    public static final Pattern VALID_CAP = Pattern.compile("\\d{5}");

    public static final Pattern VALID_ONLYCHARACTERS = Pattern.compile("^[a-zA-Z\\s]+$");

    public static final Pattern VALID_LATITUDE = Pattern.compile("^-?([0-8]?[0-9]|90)(\\.\\d{1,6})?$");

    public static final Pattern VALID_LONGITUDE = Pattern.compile("^-?((1?[0-7]?|[0-9]?[0-9])|180)(\\.\\d{1,6})?$");
    

    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr); 
        return matcher.matches();
    }
    public static boolean validatePSW(String psw) {
        Matcher matcher = VALIDPSW.matcher(psw);
        return matcher.matches();
    }
    public static boolean validateCF(String cf) {
        Matcher matcher = VALIDcf.matcher(cf);
        return matcher.matches();
    }

    public static boolean validateCAP(String cap){
        Matcher matcher = VALID_CAP.matcher(cap);
        return matcher.matches();
    }

    public static boolean validateString(String str){
        Matcher matcher = VALID_ONLYCHARACTERS.matcher(str);
        return matcher.matches();
    }
    public static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

    public static boolean validateLatitude(String latitude) {
        Matcher matcher = VALID_LATITUDE.matcher(latitude);
        return matcher.matches();
    }

    public static boolean validateLongitude(String longitude) {
        Matcher matcher = VALID_LONGITUDE.matcher(longitude);
        return matcher.matches();
    }


}
