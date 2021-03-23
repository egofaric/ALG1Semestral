package Homework;

import java.util.*;

/**
 * Tato trida hleda sekvenci v posloupnosti
 *
 * @author egopok
 *
 */

public class HledaniSekvence {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
       vstup();
    }

    /**
     *
     * Trida nacita posloupnost a sekvenci ze standartniho vstupu
     *
     *
     */

    public static void vstup() {
        boolean run = true;
        while (run) {
            System.out.println("Pokracovat ve spracovani (a/n):");
            String identifikator = sc.nextLine();

            if (identifikator.equals("a") || identifikator.equals("A")) {
                System.out.println("Zadej prvni posloupnost:");
//                Posloupnost posloupnost = new Posloupnost();
                ArrayList<Integer> posloupnost1 = nactiPosloupnost();
                System.out.println("Hledana Sekvence:");
//                Posloupnost sekvence = new Posloupnost();
                ArrayList<Integer> sekvence1 = nactiPosloupnost();

                int vysledek = najdiSekvenci(posloupnost1, sekvence1);
                vypis(vysledek);
//                vypis(posloupnost1, sekvence1);


            }

            else if (identifikator.equals("n") || identifikator.equals("N")) {
              run= false;
            }

        }
    }


    /**
     * Metoda vypise, zda posloupnost obsahuje zadanou sekvenci
     * @param vysledek vstupni sekvence
     */
    private static void vypis(int vysledek){
//        int vysledek = najdiSekvenci(posloupnost, sekvence);
        if (vysledek >= 0) {
            System.out.println("Sekvence nalezena na pozici " + vysledek);
        } else {
            System.out.println("Sekvence nenalezena");
        }
    }


    /**
     * Trida vytvori posloupnost
     */
//    private static class Posloupnost {

        /**
         * Metoda nacte posloupnost ze standartniho vstupu
         * @return posloupnost
         */
        private static ArrayList<Integer> nactiPosloupnost() {
            ArrayList<Integer> posloupnost = new ArrayList<>();
            while (true) {

                int vstupPosloupnosti = sc.nextInt();
                if (vstupPosloupnosti < 0) {
                    break;
                }

                posloupnost.add(vstupPosloupnosti);
            }
            return (posloupnost);

        }
//    }

    /**
     * Metoda hleda zadanou sekvenci v posloupnosti
     * @param posloupnost zadana posloupnost
     * @param sekvence hledana sekvence
     * @return index, kde sekvence byla nalezena v posloupnosti, nebo -1, v pripade, jestli sekvence nebyla
     * nalezena
     */
    private static int najdiSekvenci(ArrayList<Integer> posloupnost, ArrayList<Integer> sekvence) {

        // Pokud je nektera z posloupnosti prazdna, return false
        if (posloupnost.size() == 0 || sekvence.size() == 0) {
            return -1;
        }

        // Pokud sekvence je vetsi nez posloupnost, return false
        else if (sekvence.size() > posloupnost.size()) {
            return -1;
        }

        else {
            for (int i = 0; i < posloupnost.size(); i++) {
                // Zkontroluj, zda i-ty prvek posloupnosti je stejny jako prvni prvek sekvence
                if (posloupnost.get(i).equals(sekvence.get(0))) {    //posloupnost.get(i) == sekvence.get(0)

                    boolean sekvenceNalezena = true;
                    boolean run = true;
                    for (int j = 0; j < sekvence.size() && run; j++) {
                        // Pokud prvky jsou mimo posloupnosti nebo prvky nejsou stejne, vyjdi z cyklu
                        if (posloupnost.size() <= i + j || !sekvence.get(j).equals(posloupnost.get(i + j))) { //sekvence.get(j) != posloupnost.get(i + j)
                            sekvenceNalezena = false;
                            run= false;
//                          break;
                        }
                    }

                    // Sekvence nalezena, vrat index
                    if (sekvenceNalezena) {
                        return i + 1;
                    }

                }
            }

    }

        // Vrat vychozi hodnotu
        return -1;
    }

}



