// 6. Z podanego folderu wypisz pliki posortowane zgodnie z nazwą
// 7. Z podanego folderu wypisz pliki posortowane zgodnie z datą utworzenia
// 8. Z podanego folderu wypisz pliki posortowane zgodnie z rozmairem

import java.io.File;
import java.text.SimpleDateFormat;


public class Sortowanie {


    public static void main(String[] args) throws Exception {


        File folder = new File("C:\\Users\\jakub\\Desktop\\doPrzeszukania");

        poNazwie(folder);
        System.out.println();
        poRozmiarze(folder);
        System.out.println();
        poDacie(folder);

    }

    private static void poNazwie(File folder) {

        File[] plikiArr = folder.listFiles();
//        Arrays.sort(plikiArr, (a, b) -> a.compareTo(b));

        File temp;
        boolean isSorted = true;
        int j = 1;
        while (isSorted) {
            isSorted = false;
            for (int i = 0; i < plikiArr.length - j; i++) {
                if (plikiArr[i].compareTo(plikiArr[i + 1]) > 0) {
                    temp = plikiArr[i];
                    plikiArr[i] = plikiArr[i + 1];
                    plikiArr[i + 1] = temp;
                    isSorted = true;
                }
            }
            j++;
        }

        for (File plik : plikiArr) {
            System.out.println(plik.getName());
        }

    }

    private static void poRozmiarze(File folder) {

        File[] plikiArr = folder.listFiles();
//        Arrays.sort(plikiArr, (a, b) -> Long.compare(a.length(), b.length()));

        File temp;
        boolean isSorted = true;
        int j = 1;
        while (isSorted) {
            isSorted = false;
            for (int i = 0; i < plikiArr.length - j; i++) {
                if (plikiArr[i].length() > plikiArr[i + 1].length()) {
                    temp = plikiArr[i];
                    plikiArr[i] = plikiArr[i + 1];
                    plikiArr[i + 1] = temp;
                    isSorted = true;
                }
            }
            j++;
        }

        for (File plik : plikiArr) {
            System.out.println(plik.length() + "\t\t" + plik.getName());
        }
    }


    private static void poDacie(File folder) {

        File[] plikiArr = folder.listFiles();
//        Arrays.sort(plikiArr, (a, b) -> Long.compare(a.lastModified(), b.lastModified()));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        File temp;
        boolean isSorted = true;
        int j = 1;
        while (isSorted) {
            isSorted = false;
            for (int i = 0; i < plikiArr.length - j; i++) {
                if (plikiArr[i].lastModified() > plikiArr[i + 1].lastModified()) {
                    temp = plikiArr[i];
                    plikiArr[i] = plikiArr[i + 1];
                    plikiArr[i + 1] = temp;
                    isSorted = true;
                }
            }
            j++;
        }

        for (File plik : plikiArr) {
            System.out.println(sdf.format(plik.lastModified()) + "\t\t" + plik.getName());
        }
    }

}
