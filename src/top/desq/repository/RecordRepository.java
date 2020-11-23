package top.desq.repository;

import top.desq.model.Record;

import java.util.List;

/**
 * Repository for {@link Record}.
 *
 * @author Aleksandr Vashchenko
 * @version 1.0
 */
public interface RecordRepository {

    void save(Record record);

    List<Record> getAll();

}
