package com.company;

import com.company.dao.News;
import com.company.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.File;
import java.util.List;

/**
 * Created by Юлия on 12.03.2016.
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    public void printHello(ModelMap model) {
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        Session session = HibernateUtil.getSessionFactory().openSession();
        List newsList = session.createCriteria(News.class).list();

        model.addAttribute("message", "News list");
        model.addAttribute("items", newsList);




//        session.beginTransaction();



//        session.beginTransaction();
//
//        News news = new News();
//        news.setName("news1");
//        news.setText("first news");
//        session.save(news);
//
//        session.getTransaction().commit();
//        HibernateUtil.shutdown();
    }
}
