package top.desq.model;

import java.util.Date;

/**
 * Base abstract entity.
 *
 * @author Aleksandr Vashchenko
 * @version 1.0
 */
public abstract class BaseEntity {

    private final String type;
    private final String serviceType;
    private final String questionType;
    private final String responseType;
    private final Date date;

    public BaseEntity(String type, String serviceType, String questionType, String responseType, Date date) {
        this.type = type;
        this.serviceType = serviceType;
        this.questionType = questionType;
        this.responseType = responseType;
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public String getServiceType() {
        return serviceType;
    }

    public String getQuestionType() {
        return questionType;
    }

    public String getResponseType() {
        return responseType;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "type='" + type + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", questionType='" + questionType + '\'' +
                ", responseType='" + responseType + '\'' +
                ", date=" + date +
                '}';
    }
}
