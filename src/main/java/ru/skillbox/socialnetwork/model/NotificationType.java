package ru.skillbox.socialnetwork.model;

import ru.skillbox.socialnetwork.model.enumeration.NameNotificationType;

import javax.persistence.*;

/**
 * тип оповещения
 */
@Entity
public class NotificationType {

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    /**
     * код типа
     */
    @Column(name = "code")
    private int code;

    /**
     * Имя
     */
    @Column(name = "name")
    private NameNotificationType name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public NameNotificationType getName() {
        return name;
    }

    public void setName(NameNotificationType name) {
        this.name = name;
    }
}