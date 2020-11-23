package top.desq;

import top.desq.repository.RecordRepository;
import top.desq.service.impl.QueryServiceImpl;
import top.desq.service.impl.RecordServiceImpl;
import top.desq.util.Util;

import java.util.StringJoiner;

/**
 * Application class.
 *
 * @author Aleksandr Vashchenko
 * @version 1.0
 */
public class App {

    private final RecordServiceImpl recordService;
    private final QueryServiceImpl queryService;
    private final StringJoiner result = new StringJoiner("\n");
    private final StringJoiner log = new StringJoiner("\n");

    public App(RecordRepository repository) {
        this.recordService = new RecordServiceImpl(repository);
        this.queryService = new QueryServiceImpl(repository);
    }

    /**
     * Read input line to run analytic process.
     *
     * @param line
     */
    public void readLine(String line) {
        if (Util.validateLine(line)) {
            log.add(line);
            run(line);
        } else {
            log.add(line + " (invalid line)");
            System.out.println("You entered invalid line.");
        }
    }

    /**
     * Run analytic process.
     *
     * @param line
     */
    private void run(String line) {
        if (line.startsWith("C")) {
            recordService.store(line);

        } else if (line.startsWith("D")) {
            result.add(queryService.query(line));
        }
    }

    /**
     * Print analytic results.
     *
     * @param linesNumber
     */
    public void printResult(int linesNumber) {
        System.out.println("\nInput:");
        System.out.println(linesNumber);
        System.out.println(log);
        System.out.println("\nOutput:");
        System.out.println(result);
    }
}
