import java.util.Scanner;

public abstract class Persona {
    private String nome;
    private String cognome;
    protected int annoDiNascita; //definito nelle sottoclassi

    Scanner inputN = new Scanner(System.in); //numeri
    Scanner inputL = new Scanner(System.in); //lettere

    //costruttore personalizzato
    public Persona(String nome, String cognome, int annoDiNascita) {
        setNome(nome);
        setCognome(cognome);
    }
    
    public Persona() {}

    //Inizio incapsulamento
    public void setNome(String nome) {
        //regola: nome maggiore di 3 lettere, non so se ci sono nomi di due lettere
        boolean dati = true;
        do {
            if(nome.length() >= 3 ) {
                this.nome = nome;
                dati = false;
            } else {
                System.out.println("Il nome inserito non è valido. Deve avere almeno 3 caratteri, reinseriscilo:");
                nome = inputL.nextLine();
            }
        } while(dati);
    }

    public String getNome() { return nome; }

    public void setCognome(String cognome) {
        //regola: nome maggiore di 3 lettere, non so se ci sono nomi di due lettere
        boolean dati = true;
        do {
            if(cognome.length() >= 3 ) {
                this.cognome = cognome;
                dati = false;
            } else {
                System.out.println("Il cognome inserito non è valido. Deve avere almeno 3 caratteri, reinseriscilo:");
                cognome = inputL.nextLine();
            }
        } while(dati);
    }

    public String getCognome() { return cognome; }

    public abstract void setAnnoDiNascita(int annoDiNascita);

    public abstract int getAnnoDiNascita();
    //fine incapsulamento

    //mostro info in comune
    public void displayInfo() {
        System.out.println("Nome: " + getNome());
        System.out.println("Cognome: " + getCognome());
        System.out.println("Anno di nascita: " + getAnnoDiNascita());
    }
}