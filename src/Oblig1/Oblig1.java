package Oblig1;////// Løsningsforslag Oblig 1 - 2019 ////////////////////////

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import java.util.NoSuchElementException;
import Hjelpemetoder.Sortering;


public class Oblig1 {
    private Oblig1() {
    }

    ///// Oppgave 1 //////////////////////////////////////

    /**
     * Det blir flest ombyttinger hvis tabellen er i synkende rekkefølge, da vil det alltid være ombyttinger for hver iterasjon
     * Det er færrest/ingen hvis tabellen er i stigende rekkefølge
     *
     */
    public static int maks(int[] a) {
        if(a.length <= 0)
            throw new NoSuchElementException("Tabellen er tom");
        for(int i = 1; i < a.length; i++) {
            if(a[i-1] > a[i]) {
                int temp = a[i];
                a[i] = a[i-1];
                a[i-1] = temp;
            }
        }
        return a[a.length - 1];
    }

    public static int ombyttinger(int[] a) {
        int ombyttinger = 0;
        if(a.length <= 0)
            throw new NoSuchElementException("Tabellen er tom");
        for(int i = 1; i < a.length; i++) {
            if(a[i-1] > a[i]) {
                int temp = a[i];
                a[i] = a[i-1];
                a[i-1] = temp;
                ombyttinger++;
            }
        }
        return ombyttinger;
    }

    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
        int antallUlike = 0;
        if (a.length <= 0){
            return antallUlike;
        }else {
            antallUlike = 1;
        }
        for (int  i = 1; i < a.length; i++){
            if (a[i-1] > a[i]){
                throw new IllegalStateException("Tabellen er ikke sortert stigende!");
            }
            if (a[i-1] != a[i]){
                antallUlike++;
            }
        }
        return antallUlike;
    }



    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        if(a.length == 0)
            return 0;

        int antLike = 0;

        for(int i = 0; i < a.length; i++)
        {
            for(int j = i + 1; j < a.length; j++)
            {
                if(a[j] == a[i])
                    antLike++;
            }
        }

        if(a.length - antLike < 0)
            return -1 * (a.length - antLike);

        return a.length - antLike;

    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {
         int antallOddetall = 0;
         int temp;
         for (int i = 0; i < a.length; i++){
             if ((Math.abs(a[i]) % 2) != 0){
                 temp = a[antallOddetall];
                 a[antallOddetall++] = a[i];
                 a[i] = temp;
             }
         }
         Hjelpemetoder.StorteringsMetoder.quickSort(a,0,antallOddetall-1);
         Hjelpemetoder.StorteringsMetoder.quickSort(a,antallOddetall,a.length-1);
    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {

        if(a.length <= 0)
            return;

        char tempLast = a[a.length - 1];

        for(int i = a.length - 1; i > 0; i--) {
            a[i] = a[i - 1];
        }
        a[0] = tempLast;
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {

    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        StringBuilder flettet = new StringBuilder();
        int lengde;

        //En bedre måte å gjøre det på
        //int lengde = (s.length() <= t.length()) ? t.length() : s.length();

        if (s.length() < t.length()){
            lengde = t.length();
        }else if (t.length() < s.length()){
            lengde = s.length();
        }else {
            lengde = s.length();
        }

        for (int i = 0; i < lengde; i++){
            if (s.length() > i){
                flettet.append(s.charAt(i));
            }
            if (t.length() > i){
                flettet.append(t.charAt(i));
            }
        }
        return flettet.toString();
    }

    /// 7b)
    public static String flett(String... s) {
        int lengste = 0;
        StringBuilder flettet = new StringBuilder();
        for (String strenger : s) {
            if (strenger.length() > lengste){
                lengste = strenger.length();
            }
        }
        for (int i = 0; i < lengste; i++){
            for (String strenger2 : s) {
                if (strenger2.length() > i){
                    flettet.append(strenger2,i,i+1);
                }
            }
        }
        return flettet.toString();
    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {

        int[] indekssortert = new int[a.length];

        if (a.length == 0) return indekssortert;

        int[] b = a.clone();

        Sortering.quickSort(b, 0, b.length - 1);

        int indeksretur = 0;

        for (int i = 0; i < b.length; i++) {
            if (i < b.length - 1)
            {
                if (b[i] != b[i + 1])
                {
                    for (int j = 0; j < a.length; j++)
                    {
                        if (b[i] == a[j])
                        {
                            indekssortert[indeksretur] = j;
                            indeksretur++;
                        }
                    }
                }

            }
            else
            {
                for (int j = 0; j < a.length; j++)
                {
                    if (b[i] == a[j])
                    {
                        indekssortert[indeksretur] = j;
                        indeksretur++;
                    }
                }
            }

        }
        return indekssortert;
    }

    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {
        if (a.length < 3){
            throw new NoSuchElementException("Tabellen må ha 3 eller flere elementer");
        }
        int minst = Integer.MAX_VALUE;
        int nestMinst = Integer.MAX_VALUE;
        int tredjeMinst = Integer.MAX_VALUE;

        int minstIndex = 0;
        int nestMinstIndex = 0;
        int tredjeMinstIndex = 0;

        for (int i = 0; i < a.length; i++){
            if (a[i] < minst){
                tredjeMinstIndex = nestMinstIndex;
                tredjeMinst = nestMinst;

                nestMinstIndex = minstIndex;
                nestMinst = minst;

                minstIndex = i;
                minst = a[i];
            }
            else if (a[i] < nestMinst){
                tredjeMinstIndex = nestMinstIndex;
                tredjeMinst = nestMinst;

                nestMinstIndex = i;
                nestMinst = a[i];
            }
            else if (a[i] < tredjeMinst){
                tredjeMinstIndex = i;
                tredjeMinst = a[i];
            }
        }
        return new int[]{minstIndex, nestMinstIndex, tredjeMinstIndex};
    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new NotImplementedException();
    }

    public static boolean inneholdt(String a, String b) {
        throw new NotImplementedException();
    }

}  // Oblig1.Oblig1
