package com.company;

////// Løsningsforslag Oblig 1 - 2019 ////////////////////////

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;


public class Oblig1 {
    private Oblig1() {
    }

    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int[] a) {
        if(a.length == 0) {
            throw new NoSuchElementException("Tomt array");
        }
        for(int i = 0; i < a.length - 1; i++) {
            if(a[i] > a[i+1]) {
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
            }
        }
        return a[a.length-1];

        /*
        Svar på spørsmålene i oppgave 1:
        1) Når blir det flest ombyttinger - Det er når det største tallet er fremst
        2) Når blir det færrest - Det er når det tabellen allerede er sortert stigende
        3) Hvor mange blir det i gjennomsnitt? - Gjennomsnittstilfellet i en usortert tabell vil være
        det harmoniske tallet. Hn - 1 = log(n) - 0,423 som er tilnærmet log(n) (= 2.23 med n = 5)
        Det er antall ganger vi i gjennomsnitt vil gå inn i if-setningen. Det blir 3 ganger i mitt array.
         */
    }

    public static int ombyttinger(int[] a) {
        if(a.length == 0) {
            throw new NoSuchElementException("Tomt array");
        }
        int counter = 0;
        for(int i = 0; i < a.length - 1; i++) {
            if(a[i] > a[i+1]) {
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
                counter++;
            }
        }
        return counter;
        /*
        Tror metoden er dårligere enn tidligere da, ombyttingene vi gjør er en større operasjon enn den vanlige.
         */
    }

    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
        if(a.length == 0) {
            return 0;
        }

        int antallUlike = 1;
        int tall = a[0];
        for(int i = 0; i < a.length; i++) {
            if(a[i] < tall) {
                throw new IllegalStateException("Tabellen er ikke sortert!");
            }
            else if(a[i] > tall) {
                tall = a[i];
                antallUlike++;
            }
        }

        return antallUlike;
    }


    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        if(a.length == 0) {
            return 0;
        }

        int antallUlike = 0;



        for(int i = 0; i < a.length; i++) {
            boolean add = true;
            for(int j = i - 1; j >= 0; j--) {
                if (a[j] == a[i]) {
                    add = false;
                }
            }
            if(add) {
                antallUlike++;
            }

        }

        return antallUlike;
    }

    private static void bytt(int[] a, int fra, int til) {
        int temp = a[fra];
        a[fra] = a[til];
        a[til] = temp;
    }

    private static int parterTall(int[] a, int v, int h) {
        int skilleverdi = a[h];

        int indeks = (v - 1);

        for(int i = v; i < h; i++) {
            if(a[i] <= skilleverdi) {
                indeks++;

                int temp = a[indeks];
                a[indeks] = a[i];
                a[i] = temp;
            }
        }
        int temp = a[indeks + 1];
        a[indeks + 1] = a[h];
        a[h] = temp;

        return indeks + 1;
    }

    public static void quickSort(int[] a, int v, int h) {
        if(v >= h) {
            return;
        }

        int partisjons_indeks = parterTall(a,v,h);

        quickSort(a,v,partisjons_indeks - 1);
        quickSort(a, partisjons_indeks + 1, h);
    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {

        //Sorterer først
        quickSort(a,0, a.length-1);

        int indeks = 0;

        //alle partall går til høyre
        for(int i = 0; i < a.length; i++) {
            if(a[i] % 2 != 0) {
                int temp = a[indeks];
                a[indeks] = a[i];
                a[i] = temp;

                indeks++;
            }
        }

        //sorterer partallene i listen
        quickSort(a,indeks, a.length - 1);


    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        throw new NotImplementedException();
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {
        throw new NotImplementedException();
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        throw new NotImplementedException();
    }

    /// 7b)
    public static String flett(String... s) {
        throw new NotImplementedException();
    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {
        throw new NotImplementedException();
    }


    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {
        throw new NotImplementedException();
    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new NotImplementedException();
    }

    public static boolean inneholdt(String a, String b) {
        throw new NotImplementedException();
    }

}  // Oblig1
