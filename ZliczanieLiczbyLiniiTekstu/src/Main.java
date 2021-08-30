import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {


    final File folder = new File(filePathFromUser());
    int total = listFilesForFolder(folder);
    System.out.println("\nTOTAL: " + total);

    }

    private static String filePathFromUser() {
        System.out.println("podaj ścieżkę folderu, w którym zliczamy liczbę wierszy w plikach");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static int listFilesForFolder(final File folder) throws FileNotFoundException {
        int total = 0;
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                total = total + listFilesForFolder(fileEntry);
            } else {
                total = total + Integer.parseInt(countLines(fileEntry.getAbsolutePath()));
                System.out.println(fileEntry.getName() + "  -->    " + countLines(fileEntry.getAbsolutePath()));
            }
        }
        return total;
    }

    private static String countLines(String absolutePath) throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(absolutePath));
        long i = bufferedReader.lines().count();
        return Long.toString(i);

    }
}
