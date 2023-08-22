package climatemonitoring.src;
public class Indirizzo {
    public String via, comune, provincia, numeroCivico;
    public int cap;

    public Indirizzo(String via, String numeroCivico, String comune, String provincia, int cap){
        this.via = via; 
        this.numeroCivico = numeroCivico;
        this.comune = comune;
        this.provincia = provincia;
        this.cap = cap;
    }

    public String toString(){
        return String.format("%s %s, %s, %s, %d", via, numeroCivico, comune, provincia, cap);
    }
}
