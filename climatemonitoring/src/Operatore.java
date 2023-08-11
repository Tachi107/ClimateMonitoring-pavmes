public class Operatore {
    
    public String nome, cognome, psw, centromonitoraggio, email;
    public String cf;
    public int userid;

    public Operatore(String nome, String cognome, String cf, String email, String psw, String centromonitoraggio)
    {
        this.nome = nome;
        this.cognome = cognome;
        this.email=email;
        this.psw=psw;
        this.cf=cf;
        this.centromonitoraggio = centromonitoraggio;
    }
    public String toString(){
        return String.format("%s,%s,%s,%s,%s,%s", nome,cognome,cf,email,psw,centromonitoraggio);
    }
}
