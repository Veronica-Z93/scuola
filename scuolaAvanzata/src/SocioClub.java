import java.util.Scanner;

public class SocioClub  implements Certificato {
    private String nome;
    private String cognome;
    private int annoRilascio;
    private String cognomeMedico;

    Scanner inputN = new Scanner(System.in); //numeri
    Scanner inputL = new Scanner(System.in); //lettere

    //inizio incapsulamento
    public void setNome(String nome) {
        //regola: nome maggiore di 3 lettere
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
        //regola: nome maggiore di 3 lettere
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

    public void setAnnoRilascio(int annoRilascio) {
        // anno di rilascio può essere tra 2022 e 2023
        boolean dati = true;
        do {
            if (annoRilascio >= 2022 && annoRilascio <= 2023) {
                this.annoRilascio = annoRilascio;
                dati = false;
            } else {
                System.out.println("L'anno di rilascio del certificato medico deve essere o 2022 o 2023, reinseriscilo:");
                annoRilascio = inputN.nextInt();
            }
        } while (dati);
    }

    public int getAnnoRilascio() { return annoRilascio; }

    public void setCognomeMedico(String cognomeMedico) {
        boolean dati = true;
        do {
            if(cognomeMedico.length() >= 3 ) {
                this.cognomeMedico = cognomeMedico;
                dati = false;
            } else {
                System.out.println("Il nome del medico inserito non è valido. Deve avere almeno 3 caratteri, reinseriscilo:");
                cognomeMedico = inputL.nextLine();
            }
        } while(dati);
    }

    public String getCognomeMedico() { return cognomeMedico; }
    //fine incapsulamento

    public void displayInfo() {
        System.out.println("L'anno di rilascio del certificato medico del socio di club di pallavolo " + getNome().toUpperCase() + " " + getCognome().toUpperCase() + " è " + getAnnoRilascio() + " e il cognome del medico che l'ha validato è " + getCognomeMedico().toUpperCase() + ".");
    }


}
