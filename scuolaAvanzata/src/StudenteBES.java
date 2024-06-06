public class StudenteBES extends Persona {
    private int classe;
    private char sezione;
    private int annoRilascio;
    private String cognomeMedico;

    public int numeroProgressivo = 0;
    public String matricola;


    //assegno docente BES

    private String nomeDocenteBES;

    //costruttore personalizzato
    public StudenteBES (String nome, String cognome, int annoDiNascita, int classe, char sezione, int annoRilascio, String cognomeMedico, String nomeDocenteBES) {
        super(nome, cognome, annoDiNascita);
        setAnnoDiNascita(annoDiNascita);
        setClasse(classe);
        setSezione(sezione);
        setAnnoRilascio(annoRilascio);
        setCognomeMedico(cognomeMedico);
        setDocenteBES(nomeDocenteBES);
        this.matricola = generaMatricola();
    } 

    public StudenteBES () {} // rigenero il costruttore predefinito qualora il main() non usi quello personalizzato

    //inizio incapsulamento per docente BES
    public void setDocenteBES(String nomeDocenteBES) {
        //regola: nome e cognome con + di 6 lettere
        boolean dati = true;
        do {
            if(nomeDocenteBES.length() >= 6 && nomeDocenteBES.length() <= 20) {
                this.nomeDocenteBES = nomeDocenteBES;
                dati = false;
            } else {
                System.out.println("Il nome inserito non è valido. Deve avere almeno 3 caratteri, reinseriscilo:");
                nomeDocenteBES = inputL.nextLine();
            }
        } while(dati);
    }

    public String getDocenteBES() { return nomeDocenteBES; }
    //fine incapsulamento per docente

    //inizio incapsulamento
    public void setAnnoDiNascita(int annoDiNascita) {
        //regola: studenti dalla prima alla quinta elementare età da 5 a 11 anni(eventualità bocciati) 2012 a 2017
        boolean dati = true;
        do {
            if (annoDiNascita >= 2012 && annoDiNascita <= 2017 ) {
                this.annoDiNascita = annoDiNascita;
                dati = false;
                numeroProgressivo++;                
            } 
        } while (dati);
    }

    public int getAnnoDiNascita() { return annoDiNascita; }

    public void setClasse(int classe) {
        //regola: classe 1 = prima, 2 = seconda, 3 = terza, 4 = quarta, 5 = quinta
        boolean dati = true;

        do { 
            switch(classe) {
                case 1: 
                    this.classe = classe;
                    dati = false;
                    break;
                
                case 2:
                    this.classe = classe;
                    dati = false;
                    break;

                case 3:
                    this.classe = classe;
                    dati = false;
                    break;

                case 4:
                    this.classe = classe;
                    dati = false;
                    break;

                case 5:
                    this.classe = classe;
                    dati = false;
                    break;

                default:
                System.out.println("Immissione errata, reinserisci una classe tra le seguenti: 1 = prima, 2 = seconda, 3 = terza, 4 = quarta, 5 = quinta");
                classe = inputN.nextInt();
            }

        } while (dati);
    }

    public int getClasse() { return classe; }

    public void setSezione(char sezione) {
        //regola: sezioni 'A' e 'B'
        boolean dati = true;

        do {
            switch(sezione) {
                case 'A', 'B':
                    this.sezione = sezione;
                    dati = false;
                    break;
                default:
                    System.out.println("Sezioni presenti in questa scuola: A = sezione A e B = sezione B; reinserisci:");
                    sezione = inputL.nextLine().toUpperCase().charAt(0);
            }
        } while(dati);
    }
    
    public char getSezione() { return sezione; }
    

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

    
    //con questo generaMatricola() il numero progressivo è in ordine, quindi 001, 002, 003...
    public String generaMatricola() {
        //prende ultime due cifre anno di nascita
        String ultimeDueCifreAnno = String.format("%02d", getAnnoDiNascita() % 100);
        //numero progressivo diventa una stringa di tre cifre
        numeroProgressivo = Scuola.getStudentiBES().size();
        String numeroProgressivoString = String.format("%03d", numeroProgressivo);
        //Genera Matricola con le info
        matricola = ultimeDueCifreAnno + numeroProgressivoString + getSezione();
    
        return matricola;
    }


    //Info 
    public String toString() {
        return "Lo studente " + getNome().toUpperCase() + " " + getCognome().toUpperCase() + ", con numero matricola " + matricola + ", nato nell'anno " + getAnnoDiNascita() + ", è iscritto alla classe " + getClasse()+ "° sezione " + getSezione() + ". \nL'anno di rilascio del certificato medico di " + getNome().toUpperCase() + " " + getCognome().toUpperCase() + " è il " + getAnnoRilascio() + " e il cognome del medico che lo ha rilasciato è " + getCognomeMedico().toUpperCase() + ". \nIl docente per Bisogni Educativi Assegnati è: " + getDocenteBES().toUpperCase();
    }


}

