package top.desq.model;

import java.util.Date;

/**
 * Simple domain object that represents a Query.
 *
 * @author Aleksandr Vashchenko
 * @version 1.0
 */
public class Query extends BaseEntity {

    private Date fromDate;
    private Date toDate;
    private boolean dateRange;

    public Query(String type, String serviceType, String questionType, String responseType, Date fromDate, Date toDate) {
        super(type, serviceType, questionType, responseType, null);
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.dateRange = true;
    }

    public Query(String type, String serviceType, String questionType, String responseType, Date date) {
        super(type, serviceType, questionType, responseType, date);
    }

    public Date getFromDate() {
        return fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public boolean hasDateRange() {
        return dateRange;
    }

    @Override
    public String toString() {
        return "Query{" +
                "type='" + getType() + '\'' +
                ", serviceType='" + getServiceType() + '\'' +
                ", questionType='" + getQuestionType() + '\'' +
                ", responseType='" + getResponseType() + '\'' +
                ", date=" + getDate() +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", dateRange=" + dateRange +
                '}';
    }
}
