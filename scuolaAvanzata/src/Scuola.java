import java.util.ArrayList;
import java.util.Scanner;

public class Scuola {
    private static ArrayList<Studente> studenti = new ArrayList<>();
    private static ArrayList<Docente> docenti = new ArrayList<>();
    private static ArrayList<SocioClub> sociClub = new ArrayList<>();

    private static ArrayList<StudenteBES> studentiBES = new ArrayList<>();
    private static ArrayList<DocenteBES> docentiBES = new ArrayList<>();

   
    Scanner inputN = new Scanner(System.in); // numeri
    Scanner inputL = new Scanner(System.in); // lettere

    public boolean apertura = true;
    
    //utilizzato per la matricola univoca: siccome l'arraylist studenti è private, uso il getter per usarlo anche in studente
    public static ArrayList<Studente> getStudenti() { return studenti; }
    public static ArrayList<StudenteBES> getStudentiBES() { return studentiBES; }

    public void menuScuola() {
        System.out.println("Cosa vuoi fare?");
        System.out.println("1. Inserimento studenti o docenti");
        System.out.println("2. Inserimento soci club");
        System.out.println("3. Visualizza elenco studenti");
        System.out.println("4. Visualizza elenco docenti");
        System.out.println("5. Visualizza elenco soci club di pallavolo");
        System.out.println("6. Inserimento studenti con Bisogni Educativi Speciali o docenti per studenti con Bisogni Educativi Speciali");
        System.out.println("7. Visualizza elenco docente BES");
        System.out.println("8. Visualizza elenco studenti BES");
        System.out.println("9. Termina programma");
        System.out.println("Digita il numero della tua scelta: ");
        int sceltaMenu = inputN.nextInt();

        switch (sceltaMenu) {
            case 1:
                System.out.println("Vuoi inserire uno studente (S), un docente (D) o uscire (M)?");
                char scelta = inputL.nextLine().toUpperCase().charAt(0);
                switch (scelta) {
                    case 'S':
                        System.out.println("**** Programma inserimento STUDENTE ****");
                        System.out.println("Inserisci il nome dello studente (almeno 3 lettere):");
                        String n = inputL.nextLine(); // n = nome
                        System.out.println("Inserisci il cognome dello studente (almeno 3 lettere):");
                        String c = inputL.nextLine();
                        int aN;
                        do {
                        System.out.println("Inserisci l'anno di nascita dello studente (compreso tra 2012 e 2017 inclusi)");
                        aN = inputN.nextInt();
                        if (aN < 2012 || aN > 2017) {
                            System.out.println("Inserimento studente nella scuola elementare non consentito!");
                            System.out.println("Sto tornando al menù principale...");
                            return;
                        }
                        } while (aN < 2012 || aN > 2017);
                        System.out.println("Inserisci la classe dello studente digitando il numero corrispondente alla tua scelta (1 = prima, 2 = seconda, 3 = terza, 4 = quarta, 5 = quinta):");
                        int cl = inputN.nextInt();
                        System.out.println("Inserisci la sezione dello studente (A oppure B):");
                        char s = inputL.nextLine().toUpperCase().charAt(0);
                        System.out.println("Inserisci l'anno di rilascio dell'ultimo certificato medico (si ricorda che deve essere stato effettuato o nel 2022 o nel 2023 per essere valido): ");
                        int aR = inputN.nextInt();
                        System.out.println("Inserisci il cognome del medico che ha rilasciato il certificato: ");
                        String cM = inputL.nextLine();
                        // creo istanza studente e passo gli input nel costruttore
                        Studente studente = new Studente(n, c, aN, cl, s, aR, cM);
                        studenti.add(studente); // aggiungo all'arrayList
                        System.out.println("Matricola generata: " + studente.generaMatricola()); //prova  
                        break;

                    case 'D':
                        System.out.println("**** Programma inserimento DOCENTE ****");
                        System.out.println("Inserisci il nome del docente (almeno 3 lettere):");
                        String no = inputL.nextLine(); // n = nome
                        System.out.println("Inserisci il cognome del docente (almeno 3 lettere):");
                        String co = inputL.nextLine();
                        int aNN;
                        do {
                            System.out.println("Inserisci l'anno di nascita del docente (compreso tra 1963 e 1993 inclusi)");
                            aNN = inputN.nextInt();
                            if (aNN < 1963 || aNN > 1993) {
                                System.out.println("Inserimento docente nella scuola elementare non consentito!");
                                System.out.println("Sto tornando al menù principale...");
                                return;
                            }
                        } while (aNN < 1963 || aNN > 1993);
                        System.out.println("Seleziona la materia di insegnamento del docente BES (1 = italiano, 2 = matematica e scienze, 3 = inglese, 4 = musica, 5 = arte, 6 = storia e geografia, 7 = educazione fisica):");
                        int mi = inputN.nextInt();
                        // creo istanza studente e passo gli input nel costruttore
                        Docente docente = new Docente(no, co, aNN, mi);
                        // docente.displayInfo();
                        docenti.add(docente); // aggiungo all'arrayList
                        break;

                    case 'M':
                        System.out.println("Stai tornando al menù principale...");
                        aperturaScuola();
                        break;

                    default:
                        System.out.println("Scelta non valida. Riprova!");
                        break;
                }

                break;

            case 2:
                SocioClub socioClub = new SocioClub();
                System.out.println("**** Programma inserimento SOCIO CLUB ****");
                System.out.println("Inserisci il nome del socio club (almeno 3 lettere):");
                socioClub.setNome(inputL.nextLine());
                System.out.println("Inserisci il cognome del socio club (almeno 3 lettere):");
                socioClub.setCognome(inputL.nextLine());
                System.out.println("Inserisci l'anno di rilascio dell'ultimo certificato medico (si ricorda che deve essere stato effettuato o nel 2022 o nel 2023 per essere valido):");
                socioClub.setAnnoRilascio(inputN.nextInt());
                System.out.println("Inserisci il cognome del medico che ha rilasciato il certificato: ");
                socioClub.setCognomeMedico(inputL.nextLine());
                sociClub.add(socioClub);
                break;

            case 3:
                if (studenti.isEmpty()) {
                    System.out.println("Non hai inserito ancora nessuno studente!");
                } else {
                    System.out.println("L'elenco studenti è: ");
                    for (Studente studente : studenti)
                        System.out.println(studente); // mostra il toString con le info Richieste
                }
                break;

            case 4:
                if (docenti.isEmpty()) {
                    System.out.println("Non hai inserito ancora nessun docente!");
                } else {
                    System.out.println("L'elenco docenti è: ");
                    for (Docente docente : docenti)
                        System.out.println(docente);
                }
                break;

            case 5:
                if (sociClub.isEmpty()) {
                    System.out.println("Non hai inserito ancora nessun socio del club di pallavolo!");
                } else {
                    System.out.println("L'elenco soci del club di pallavolo è: ");
                    for (SocioClub socio : sociClub)
                        socio.displayInfo();
                }
                break;

            case 6: 
                System.out.println("Vuoi inserire uno studente BES (S), un docente BES (D) o uscire (M)?");
                char scelta2 = inputL.nextLine().toUpperCase().charAt(0);
                switch (scelta2) {
                    case 'S':
                        System.out.println("**** Programma inserimento STUDENTE BES ****");
                        System.out.println("Inserisci il nome dello studente (almeno 3 lettere):");
                        String n = inputL.nextLine(); // n = nome
                        System.out.println("Inserisci il cognome dello studente (almeno 3 lettere):");
                        String c = inputL.nextLine();
                        int aN;
                        do {
                        System.out.println("Inserisci l'anno di nascita dello studente BES (compreso tra 2012 e 2017 inclusi)");
                        aN = inputN.nextInt();
                        if (aN < 2012 || aN > 2017) {
                            System.out.println("Inserimento studente BES nella scuola elementare non consentito!");
                            System.out.println("Sto tornando al menù principale...");
                            return;
                        }
                        } while (aN < 2012 || aN > 2017);
                        System.out.println("Inserisci la classe dello studente BES digitando il numero corrispondente alla tua scelta (1 = prima, 2 = seconda, 3 = terza, 4 = quarta, 5 = quinta):");
                        int cl = inputN.nextInt();
                        System.out.println("Inserisci la sezione dello studente BES (A oppure B):");
                        char s = inputL.nextLine().toUpperCase().charAt(0);
                        System.out.println("Inserisci l'anno di rilascio dell'ultimo certificato medico (si ricorda che deve essere stato effettuato o nel 2022 o nel 2023 per essere valido): ");
                        int aR = inputN.nextInt();
                        System.out.println("Inserisci il cognome del medico che ha rilasciato il certificato: ");
                        String cM = inputL.nextLine();
                        //Assegno docente BES
                        System.out.println("Assegna allo studente un docente BES inserendo nome e cognome:");
                        String DB = inputL.nextLine(); 
                        // creo istanza studente e passo gli input nel costruttore
                        StudenteBES studenteBES = new StudenteBES(n, c, aN, cl, s, aR, cM, DB);
                        studentiBES.add(studenteBES); // aggiungo all'arrayList
                        System.out.println("Matricola generata: " + studenteBES.generaMatricola()); 
                        break;

                    case 'D':
                        System.out.println("**** Programma inserimento DOCENTE BES ****");
                        System.out.println("Inserisci il nome del docente BES (almeno 3 lettere):");
                        String no = inputL.nextLine(); // n = nome
                        System.out.println("Inserisci il cognome del docente BES (almeno 3 lettere):");
                        String co = inputL.nextLine();
                        int aNN;
                        do {
                            System.out.println("Inserisci l'anno di nascita del docente BES (compreso tra 1963 e 1993 inclusi)");
                            aNN = inputN.nextInt();
                            if (aNN < 1963 || aNN > 1993) {
                                System.out.println("Inserimento docente BES nella scuola elementare non consentito!");
                                System.out.println("Sto tornando al menù principale...");
                                return;
                            }
                        } while (aNN < 1963 || aNN > 1993);
                        System.out.println("Seleziona la materia di insegnamento del docente (1 = italiano, 2 = matematica e scienze, 3 = inglese, 4 = musica, 5 = arte, 6 = storia e geografia, 7 = educazione fisica):");
                        int mi = inputN.nextInt();
                        System.out.println("Assegna al docente BES 3 studenti BES inserendone nome e cognome, separati da una virgola:");
                        String SB = inputL.nextLine();
                        // creo istanza studente e passo gli input nel costruttore
                        DocenteBES docenteBES = new DocenteBES(no, co, aNN, mi, SB);
                        docentiBES.add(docenteBES); // aggiungo all'arrayList
                        break;
                    }
                break;

            case 7: 
                if (docentiBES.isEmpty()) {
                    System.out.println("Non ci sono docenti BES inseriti.");
                    System.out.println("Stai tornando al menù principale...");
                    return;
                } else {
                    System.out.println("L'elenco docenti è: ");
                    for (DocenteBES docenteBES : docentiBES) 
                    System.out.println(docenteBES); 
                }

                break;

            case 8:
                if (studentiBES.isEmpty() ) {
                    System.out.println("Non ci sono studenti con Bisogni Educativi Speciali inseriti.");
                    System.out.println("Stai tornando al menù principale...");
                    return;
                } else {
                    for (StudenteBES studenteBS : studentiBES) {
                        System.out.println(studenteBS);
                    }     
                }

                break;
                       
            case 9:
                chiusuraScuola();
                break;

            default:
                System.out.println("Scelta inserita non valida!");
                break;
        }
    }

    public void aperturaScuola() {
        boolean messaggioApertura = false;

        while (apertura) {
            if (!messaggioApertura) {
                System.out.println("*** SCUOLA ELEMENTARE JAVA ***");
                messaggioApertura = true;
            }
            menuScuola();
        }
    }

    public void chiusuraScuola() {
        System.out.println("Vuoi davvero chiudere il programma? Digita 1 per si, 2 per no");
        int risposta = inputN.nextInt();
        if (risposta == 1) {
            System.out.println("Sto chiudendo il programma...");
            apertura = false;
            System.out.println("Programma chiuso. Arrivederci!");
        } else if (risposta == 2) {
            System.out.println("Operazione annullata. Il programma resta in esecuzione.");
        } else {
            System.out.println("Opzione non valida. Il programma resta in esecuzione.");
        }
        if (apertura) {
            aperturaScuola();
        }
    }
}
