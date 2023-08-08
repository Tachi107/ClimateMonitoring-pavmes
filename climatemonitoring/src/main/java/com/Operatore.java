package com;

public class Operatore {
    
    public String nome, cognome, psw, centromonitoraggio, email;
    public char[] cf = new char[16];
    public int userid;

    public Operatore(String nome, String cognome, String psw, String centromonitoraggio, String email, char[] cf)
    {
       
        if(Regex.validateEmail(email)&&Regex.validatePSW(psw)&&Regex.validateCF(cf))
        {
            this.email=email;
            this.psw=psw;
            this.cf=cf;
        }
        else
        {
            System.err.println("EMAIL e/o PASSWORD e/o CF NON VALIDI \n ricaricamento del modulo in corso...");
            //ricaricamneto del modulo
        }
        
    }

    

}
