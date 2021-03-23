package Homework;

import MyLibrary.ArrayTools;
import Vanoce.Stromecek;

import java.util.*;

/**
 * Trida nacita vyber ulohy uzivatele a vykresluje menu
 */
public class SemestralniPrace {
    public static Scanner sc = new Scanner(System.in);


    /**
     * @param args nacita vyber uzivatele
     */
    public static void main(String[] args) {
        String vyber;
        while (true) {
            drawMenu();
            vyber = sc.nextLine();
            if (vyber.equals("1")) {
                HledaniSekvence.vstup();
            } else if (vyber.equals("2")) {
                Stromecek.drawTree();
            }

        }


    }


    /**
     * Kresleni menu
     */
    private static void drawMenu() {
        System.out.println("*  *  *  *  *  *  *  *  *   *");
        System.out.println("*                           *");
        System.out.println("*       Vyber zadani        *");
        System.out.println("* 1) Semestralni prace      *");
        System.out.println("* 2) Vanocni uloha          *");
        System.out.println("*                           *");
        System.out.println("*   *  *  *  *  *  *  *  *  *");

    }
}
