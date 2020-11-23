package top.desq.service.impl;

import top.desq.model.Query;
import top.desq.model.Record;
import top.desq.repository.RecordRepository;
import top.desq.service.QueryService;
import top.desq.util.Util;

import java.util.function.Predicate;

/**
 * Implementation of {@link QueryService} interface.
 *
 * @author Aleksandr Vashchenko
 * @version 1.0
 */
public class QueryServiceImpl implements QueryService {

    private final RecordRepository repository;

    public QueryServiceImpl(RecordRepository repository) {
        this.repository = repository;
    }

    /**
     * Filter {@link Record} objects & get average time.
     *
     * @param line
     * @return {@link String}
     */
    @Override
    public String query(String line) {
        Query query = create(line);

        int average = (int) repository.getAll().stream().
                filter(getFilterPredicate(query, "service")
                        .and(getFilterPredicate(query, "question"))
                        .and(getFilterPredicate(query, "response"))
                        .and(getFilterPredicate(query, "date"))
                )
                .mapToInt(Record::getTime)
                .average().orElse(Double.NaN);

        return average > 0 ? String.valueOf(average) : "-";
    }

    /**
     * Create {@link Query} object.
     *
     * @param line
     * @return {@link Query}
     */
    private Query create(String line) {
        final String[] array = line.split(" ");

        if (array[4].contains("-")) {
            final String[] dateRange = array[4].split("-");
            return new Query(array[0], array[1], array[2], array[3], Util.parseDate(dateRange[0]), Util.parseDate(dateRange[1]));
        }

        return new Query(array[0], array[1], array[2], array[3], Util.parseDate(array[4]));
    }

    /**
     * Get {@link Predicate} by type.
     *
     * @param query
     * @param type
     * @return {@link Predicate}
     */
    private Predicate<Record> getFilterPredicate(Query query, String type) {
        switch (type) {
            case "service":
                return e -> e.getServiceType().startsWith(query.getServiceType())
                        || query.getServiceType().equals("*");
            case "question":
                return e -> e.getQuestionType().startsWith(query.getQuestionType())
                        || query.getQuestionType().equals("*");
            case "response":
                return e -> e.getResponseType().equals(query.getResponseType());
            case "date":
                return query.hasDateRange()
                        ? e -> e.getDate().compareTo(query.getFromDate()) >= 0
                        && e.getDate().compareTo(query.getToDate()) <= 0
                        : e -> e.getDate().equals(query.getDate());
            default:
                return e -> true;
        }
    }

}
