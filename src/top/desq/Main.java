package top.desq;

import top.desq.repository.impl.RecordRepositoryImpl;

import java.util.Scanner;

/**
 * Java application entry point.
 *
 * @author Aleksandr Vashchenko
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        try {
            App app = new App(new RecordRepositoryImpl());
            Scanner sc = new Scanner(System.in);

            System.out.println("How many lines you want to add? (please, enter only integer value)");
            int linesNumber = sc.nextInt();
            sc.nextLine();

            for (int i = 1; i <= linesNumber; i++) {
                System.out.println("Add " + i + " line, please.");
                app.readLine(sc.nextLine().trim()); // run analytics
            }

            app.printResult(linesNumber);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
