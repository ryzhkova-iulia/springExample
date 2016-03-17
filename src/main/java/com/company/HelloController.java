package com.company;

import com.company.dao.News;
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

public class HelloController {

    @Resource(name="newsService")
    private NewsService newsService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getNews(Model model) {

        model.addAttribute("items", newsService.getAll());

        return "news/list";

    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAdd(Model model) {

        model.addAttribute("addNews", new News());

        return "news/getAdd";

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add (@ModelAttribute("addNews") News news) {
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
       return "news/editPage";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit (@ModelAttribute("newsAttribute") News news,
                        @RequestParam(value="id", required=true) Integer id,
                        Model model) {
        news.setId(id);
        newsService.edit(news);
        model.addAttribute("id", id);

        return "news/editedPage";
    }


}
