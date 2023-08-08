import java.util.regex.*;


public  class Regex {
    
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static final Pattern  VALIDPSW = Pattern.compile( "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()\u2013[{}]:;',?/*~$^+=<>]).{8,20}$");

    public static final Pattern  VALIDcf = Pattern.compile("^([A-Z]{6}[0-9LMNPQRSTUV]{2}[ABCDEHLMPRST]{1}[0-9LMNPQRSTUV]{2}[A-Z]{1}[0-9LMNPQRSTUV]{3}[A-Z]{1})$|([0-9]{11})$", Pattern.CASE_INSENSITIVE);



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
}
