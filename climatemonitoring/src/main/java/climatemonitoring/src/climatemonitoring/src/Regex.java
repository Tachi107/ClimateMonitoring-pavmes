//Giacomo Paviano 750742
//Alessandro Messuti 750734

package climatemonitoring.src;
import java.util.regex.*;


/** contiene metodi per la validazione di vari tipi di dati */
public  class Regex {
    
    /** regex email valida*/
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    /** regex password valida */
    public static final Pattern  VALIDPSW = Pattern.compile( "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()\u2013[{}]:;',?/*~$^+=<>]).{8,20}$");

    /** regex codice fiscale valido */
    public static final Pattern  VALIDcf = Pattern.compile("^([A-Z]{6}[0-9LMNPQRSTUV]{2}[ABCDEHLMPRST]{1}[0-9LMNPQRSTUV]{2}[A-Z]{1}[0-9LMNPQRSTUV]{3}[A-Z]{1})$|([0-9]{11})$", Pattern.CASE_INSENSITIVE);

    /** regex cap valido */
    public static final Pattern VALID_CAP = Pattern.compile("\\d{5}");

    /** regex solo caratteri */
    public static final Pattern VALID_ONLYCHARACTERS = Pattern.compile("^[a-zA-Z\\s]+$");

    /** regex latitudine valida */
    public static final Pattern VALID_LATITUDE = Pattern.compile("^-?([0-8]?[0-9]|90)(\\.\\d{1,6})?$");

    /** regex longitudine valida */
    public static final Pattern VALID_LONGITUDE = Pattern.compile("^-?((1?[0-7]?|[0-9]?[0-9])|180)(\\.\\d{1,6})?$");
    

    /**  
     * 
     *valida se una stringa è un indirizzo email valido utilizzando un'espressione regolare. */
    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr); 
        return matcher.matches();
    }

    /** valida se una stringa rappresenta una password valida che soddisfa determinati criteri, 
     * come contenere almeno una lettera maiuscola, una lettera minuscola, un carattere speciale, un numero e una lunghezza compresa tra 8 e 20 caratteri. */
    public static boolean validatePSW(String psw) {
        Matcher matcher = VALIDPSW.matcher(psw);
        return matcher.matches();
    }

    /** verifica se una stringa rappresenta un codice fiscale italiano valido utilizzando un'espressione regolare. */
    public static boolean validateCF(String cf) {
        Matcher matcher = VALIDcf.matcher(cf);
        return matcher.matches();
    }

    /** verifica se una stringa rappresenta un CAP  */
    public static boolean validateCAP(String cap){
        Matcher matcher = VALID_CAP.matcher(cap);
        return matcher.matches();
    }

    /** verifica se una stringa contiene solo caratteri alfabetici e spazi */
    public static boolean validateString(String str){
        Matcher matcher = VALID_ONLYCHARACTERS.matcher(str);
        return matcher.matches();
    }

    /** Questo metodo verifica se una stringa contiene solo cifre numeriche */
    public static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

    /** verifica se una stringa rappresenta una latitudine valida, con un intervallo tra -90 e 90 gradi e fino a 6 decimali. */
    public static boolean validateLatitude(String latitude) {
        Matcher matcher = VALID_LATITUDE.matcher(latitude);
        return matcher.matches();
    }

    /** verifica se una stringa rappresenta una longitudine valida, con un intervallo tra -180 e 180 gradi e fino a 6 decimali */
    public static boolean validateLongitude(String longitude) {
        Matcher matcher = VALID_LONGITUDE.matcher(longitude);
        return matcher.matches();
    }

    /** valida se il codice contiene da 1 a 9 cifre*/
    public static boolean validateCode(String code){
        return code.matches("\\d{1,9}");
    }
}
