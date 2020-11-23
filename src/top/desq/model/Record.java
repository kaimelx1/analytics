package top.desq.model;

import java.util.Date;

/**
 * Simple domain object that represents a Record.
 *
 * @author Aleksandr Vashchenko
 * @version 1.0
 */
public class Record extends BaseEntity {

    private final int time;

    public Record(String type, String serviceType, String questionType, String responseType, Date date, int time) {
        super(type, serviceType, questionType, responseType, date);
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Record{" +
                "type='" + getType() + '\'' +
                ", serviceType='" + getServiceType() + '\'' +
                ", questionType='" + getQuestionType() + '\'' +
                ", responseType='" + getResponseType() + '\'' +
                ", date=" + getDate() +
                ", time=" + time +
                '}';
    }
}
