package top.desq.service.impl;

import top.desq.model.Record;
import top.desq.repository.RecordRepository;
import top.desq.service.RecordService;
import top.desq.util.Util;

/**
 * Implementation of {@link RecordService} interface.
 *
 * @author Aleksandr Vashchenko
 * @version 1.0
 */
public class RecordServiceImpl implements RecordService {

    private final RecordRepository repository;

    public RecordServiceImpl(RecordRepository repository) {
        this.repository = repository;
    }

    /**
     * Put {@link Record} object to {@link RecordRepository}.
     *
     * @param line
     */
    @Override
    public void store(String line) {
        repository.save(create(line));
    }

    /**
     * Create {@link Record} object.
     *
     * @param line
     * @return {@link Record}
     */
    private Record create(String line) {
        final String[] array = line.split(" ");
        return new Record(array[0], array[1], array[2], array[3], Util.parseDate(array[4]), Integer.parseInt(array[5]));
    }

}
