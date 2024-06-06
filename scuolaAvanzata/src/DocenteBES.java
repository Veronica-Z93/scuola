public class DocenteBES extends Persona {
    
    private int materiaInsegnata;

    private String nomeStudenteBES;

    
    // costruttore personalizzato
    public DocenteBES (String nome, String cognome, int annoDiNascita, int materiaInsegnata, String nomeStudenteBES) {
        super(nome, cognome, annoDiNascita);
        setAnnoDiNascita(annoDiNascita);
        setMateriaInsegnata(materiaInsegnata);
        setNomeStudenteBES(nomeStudenteBES);
    }

    public DocenteBES () {} // rigenero il costruttore predefinito qualora il main() non usi quello personalizzato

    //inizio incapsulamento per inserimento studenti BES
    public void setNomeStudenteBES(String nomeStudenteBES) {
        //regola: nome + cognome almeno 8 caratteri
        boolean dati = true;
        do {
            if(nomeStudenteBES.length() >= 7 && nomeStudenteBES.length() <=50 ) {
                this.nomeStudenteBES = nomeStudenteBES;
                dati = false;
            } else {
                System.out.println("I nomi inseriti non sono validi. Devono esserci almeno 7 caratteri e possono essere al massimo 3 studenti:");
                nomeStudenteBES = inputL.nextLine();
            }
        } while(dati);
    }

    public String getNomeStudenteBES() { return nomeStudenteBES; }
    //fine incapsulamento 2

    public void gestioneStudentiBES() {
        

        
        /* 
        int numeroStudentiBES = Scuola.getStudentiBES().size();

        // Controllo se ci sono più di 3 studenti BES
        if (numeroStudentiBES > 3) {
            System.out.println("Attenzione! Il docente BES ha già 3 studenti assegnati.");
            System.out.println("Gli studenti assegnati al docente BES sono:");
            for (int i = 0; i < 3; i++) {
                System.out.println(Scuola.getStudentiBES().get(i));
            }
        } else {
            
            }*/
        }

    

    // inizio incapsulamento
    public void setAnnoDiNascita(int annoDiNascita) {
        // regola: docenti nati tra il 1963 e il 1993
        boolean dati = true;
        do {
            if (annoDiNascita >= 1963 && annoDiNascita <= 1993) {
                this.annoDiNascita = annoDiNascita;
                dati = false;
            }
        } while (dati);
    }

    public int getAnnoDiNascita() {
        return annoDiNascita;
    }

    public void setMateriaInsegnata(int materiaInsegnata) {
        // regola: 1 = italiano, 2 = matematica e scienze, 3 = inglese, 4 = musica, 5 = arte, 6 = storia e geografia, 7 = educazione fisica
        boolean dati = true;

        do {
            switch (materiaInsegnata) {
                case 1:
                    this.materiaInsegnata = materiaInsegnata;
                    dati = false;
                    break;

                case 2:
                    this.materiaInsegnata = materiaInsegnata;
                    dati = false;
                    break;

                case 3:
                    this.materiaInsegnata = materiaInsegnata;
                    dati = false;
                    break;

                case 4:
                    this.materiaInsegnata = materiaInsegnata;
                    dati = false;
                    break;

                case 5:
                    this.materiaInsegnata = materiaInsegnata;
                    dati = false;
                    break;

                case 6:
                    this.materiaInsegnata = materiaInsegnata;
                    dati = false;
                    break;

                case 7:
                    this.materiaInsegnata = materiaInsegnata;
                    dati = false;
                    break;

                default:
                    System.out.println("Immissione errata, reinserisci una materia insegnata tra le seguenti: 1 = italiano, 2 = matematica e scienze, 3 = inglese, 4 = musica, 5 = arte, 6 = storia e geografia, 7 = educazione fisica.");
                    materiaInsegnata = inputN.nextInt();
            }

        } while (dati);
    }

    public int getMateriaInsegnata() {
        return materiaInsegnata;
    }
    // fine incapsulamento

    public String toString() {
        // regola: 1 = italiano, 2 = matematica e scienze, 3 = inglese, 4 = musica, 5 = arte, 6 = storia e geografia, 7 = educazione fisica
        String result = "Il docente per bisogni educativi speciali " + getNome().toUpperCase() + " " + getCognome().toUpperCase() + ", nato nell'anno " + getAnnoDiNascita() + ", insegna ";

        switch (getMateriaInsegnata()) {
            case 1:
                result += "ITALIANO.";
                break;

            case 2:
                result += "MATEMATICA e SCIENZE.";
                break;

            case 3:
                result += "INGLESE.";
                break;

            case 4:
                result += "MUSICA.";
                break;

            case 5:
                result += "ARTE.";
                break;

            case 6:
                result += "STORIA e GEOGRAFIA.";
                break;

            case 7:
                result += "EDUCAZIONE FISICA.";
                break;
        }

        String result2 = " Sono stati correttamente assegnati i seguenti studenti BES:" + getNomeStudenteBES().toUpperCase();
        return result + result2;
    }
}
