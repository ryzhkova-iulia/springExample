package com.company;

import com.company.dao.Category;
import com.company.dao.News;
import com.company.service.CategoryService;
import com.company.service.NewsService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * Created by ���� on 12.03.2016.
 */
@Controller

public class NewsController {

    @Resource(name="newsService")
    private NewsService newsService;

    @Resource(name="categoryService")
    private CategoryService categoryService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getNews(Model model) {

        model.addAttribute("items", newsService.getAll());

        return "news/list";

    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAdd(Model model) {

        model.addAttribute("item", new News());
        model.addAttribute("categories", categoryService.getAll());

        return "news/getNews";

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add (@ModelAttribute("item") News news, @RequestParam Integer categoryId) {

        if (categoryId > 0) {
            Category category = categoryService.get(categoryId);
            if (category != null) {
                news.setCategory(category);
            }
        }

        newsService.add(news);

        return "news/addedNews";
    }

   @RequestMapping(value = "/delete", method = RequestMethod.GET)
   public String delete(@RequestParam(value="id", required=true) Integer id, Model model) {
       newsService.delete(id);
       model.addAttribute("id", id);
       return "news/deletedNews";
    }

   @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String getEdit (@RequestParam(value="id", required=true) Integer id, Model model) {
       model.addAttribute("newsAttribute", newsService.get(id));
       model.addAttribute("categories", categoryService.getAll());
       return "news/editNews";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit (@ModelAttribute("newsAttribute") News news,
                        @RequestParam(value="id", required=true) Integer id,
                        @RequestParam Integer categoryId,
                        Model model) {
        news.setId(id);

        if (categoryId > 0) {
            Category category = categoryService.get(categoryId);
            if (category != null) {
                news.setCategory(category);
            }
        }

        newsService.edit(news);
        model.addAttribute("id", id);

        return "news/editedNews";
    }


}
