package com.company.service;

import com.company.dao.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by julia on 17.03.2016.
 */

@Service("categoryService")
@Transactional
public class CategoryService {
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public List getAll() {
        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        return session.createCriteria(Category.class).list();
    }

    /**
     * Retrieves a single person
     */
    public Category get(Integer id) {
        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Retrieve existing person first
        return session.get(Category.class, id);
    }

    /**
     * Adds a new person
     */
    public void add(Category category) {
        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Save
        session.save(category);
    }

    /**
     * Deletes an existing person
     *
     * @param id the id of the existing person
     */
    public void delete(Integer id) {
        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Retrieve existing person first
        Category category = session.get(Category.class, id);

        // Delete
        session.delete(category);
    }

    /**
     * Edits an existing person
     */
    public void edit(Category category) {
        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        Category existingCategory = session.get(Category.class, category.getId());

        // Assign updated values to this person
        existingCategory.setName(category.getName());
        // Save updates
        session.save(existingCategory);
    }
}
