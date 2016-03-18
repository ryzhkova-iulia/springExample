package com.company.dao;

import org.hibernate.annotations.OptimisticLockType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by ���� on 14.03.2016.
 */
@Entity
public class News implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "date_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date = new Date();

    @Column(name = "NAME", nullable = false, length = 255)
    private String name;

    @Column(name = "DETAIL_TEXT", nullable = false)
    private String text;

    @ManyToOne()
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
