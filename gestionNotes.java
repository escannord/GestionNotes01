import  java.util.InputMismatchException;
import java.util.Scanner;
public class gestionNotes {
    public static double  NOTE_MIN_RATTRAP=7;
    public static double  NOTE_MIN_ADMIS=10;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // systeme d'entrée
        double max = 0;
        double min = 20;
        double moyenne = 0;
        int nb_sup_moy = 0;
        int nb_admis = 0;
        int nb_recall = 0;
        int nb_rattrap=0;

        System.out.print("Entrer le nombre d'etudiants : ");
        int nb = sc.nextInt();

        //liste des notes de tout les etudiants
        Double[] notes=new Double[nb];


        /* 
         * boucle d'entrée des notes
         */
        for (int i = 0; i < nb; i++) {
            boolean valid = false;
            do { 
                System.out.print("entrez la note "+(i+1)+" : ");
                try {
                    notes[i] = sc.nextDouble();
                    valid = true;
                } 
                catch (InputMismatchException e) {
                    System.out.println("note invalide reessayer (elle doit etre un double)");
                    valid = false;
                }
                
                if(notes[i]>20 || notes[i]<0){
                    System.out.println("note invalide reessayer (elle doit être comprise entre 0 et 20)");
                }
            } while (notes[i]>20 || notes[i]<0 || !valid);
            
        }

        /* 
         * recherche des notes max et min
         */
        for (int i = 0; i < nb; i++) {
            if (notes[i] > max) {
                max = notes[i];
            }
            if (notes[i] < min) {
                min = notes[i];
            }
        }

        /* 
         * calcul de la moyenne de la classe
         */
        double somme = 0;
        for (int i = 0; i < nb; i++) {
            somme += notes[i];
        }
        moyenne = somme / nb;

        /* 
         * etudiants ayant une note superieure ou egale a la moyenne
         */
        for (int i = 0; i < nb; i++) {
            if (notes[i] >= moyenne) {
                nb_sup_moy++;
            }
        }

        /* 
         * calcul du nombre d'etudiants admis/recaller 
         */
        for (int i = 0; i < nb; i++) {
            if (notes[i] >= NOTE_MIN_ADMIS) {
                nb_admis++;
            }

            if (notes[i] < NOTE_MIN_RATTRAP) {
                nb_recall++;
            }
        }
        nb_rattrap=nb-nb_admis-nb_recall;

        /* 
         * affichage des resultats
         */
        System.out.println("\n Affichage des resultats" );
        System.out.println("La note du premier est : " + max);
        System.out.println("La note du dernier est : " + min);
        System.out.println("La moyenne est : " + moyenne);
        System.out.println("Nombre d'etudiants avec une note superieure ou egale a la moyenne : " + nb_sup_moy);
        System.out.println("Nombre d'etudiants admis : " + nb_admis);
        System.out.println("Nombre d'etudiants rattrapé : " + nb_rattrap);
        System.out.println("Nombre d'etudiants recallé : " + nb_recall);
    }

}