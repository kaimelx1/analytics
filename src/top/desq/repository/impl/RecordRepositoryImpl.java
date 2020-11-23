package top.desq.repository.impl;

import top.desq.model.Record;
import top.desq.repository.RecordRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of {@link RecordRepository} interface.
 *
 * @author Aleksandr Vashchenko
 * @version 1.0
 */
public class RecordRepositoryImpl implements RecordRepository {

    private final List<Record> repository = new ArrayList<>();

    /**
     * Save {@link Record} to {@link RecordRepository}.
     *
     * @param record
     */
    @Override
    public void save(Record record) {
        repository.add(record);
    }

    /**
     * Get all {@link Record} objects from {@link RecordRepository}.
     *
     * @return {@link List<Record>}
     */
    @Override
    public List<Record> getAll() {
        return repository;
    }
}
