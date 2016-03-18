package com.company.service;


import com.company.dao.News;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ���� on 15.03.2016.
 */
@Service("newsService")
@Transactional
public class NewsService {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    /**
     * Retrieves all persons
     *
     * @return a list of persons
     */
    public List getAll() {
        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        return session.createCriteria(News.class).list();
    }

    /**
     * Retrieves a single person
     */
    public News get(Integer id) {
        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Retrieve existing person first
        return session.get(News.class, id);
    }
    /**
     * Adds a new person
     */
    public void add(News news) {
        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Save
        session.save(news);
    }

    /**
     * Deletes an existing person
     * @param id the id of the existing person
     */
    public void delete(Integer id) {
        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Retrieve existing person first
        News news = session.get(News.class, id);
        if (news != null) {
            // Delete
            session.delete(news);
        }
    }

    /**
     * Edits an existing person
     */
    public void edit(News news) {
        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        News existingNews = session.get(News.class, news.getId());

        // Assign updated values to this person
        existingNews.setName(news.getName());
        existingNews.setText(news.getText());
        existingNews.setCategory(news.getCategory());
        // Save updates
        session.save(existingNews);
    }
}
