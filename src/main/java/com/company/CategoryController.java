package com.company;

import com.company.dao.Category;
import com.company.dao.News;
import com.company.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * Created by julia on 17.03.2016.
 */

@Controller
public class CategoryController {

    @Resource(name="categoryService")
    private CategoryService categoryService;

    @RequestMapping(value = "/categories/", method = RequestMethod.GET)
    public String getNews(Model model) {

        model.addAttribute("items", categoryService.getAll());
        return "categories/list";
    }

    @RequestMapping(value = "/category/add", method = RequestMethod.GET)
    public String getAdd(Model model) {

        model.addAttribute("entity", new Category());

        return "categories/getAdd";

    }

    @RequestMapping(value = "/category/add", method = RequestMethod.POST)
    public String add (@ModelAttribute("entity") Category category) {
        categoryService.add(category);

        return "categories/addedCategory";
    }

    @RequestMapping(value = "/category/edit", method = RequestMethod.GET)
    public String getEdit (@RequestParam(value="id", required=true) Integer id, Model model) {
        model.addAttribute("categoryAttribute", categoryService.get(id));
        return "categories/editCategory";
    }

    @RequestMapping(value = "/category/edit", method = RequestMethod.POST)
    public String edit (@ModelAttribute("categoryAttribute") Category category,
                        @RequestParam(value="id", required=true) Integer id,
                        Model model) {
        category.setId(id);
        categoryService.edit(category);
        model.addAttribute("id", id);

        return "categories/editedCategory";
    }

    @RequestMapping(value = "/category/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value="id", required=true) Integer id, Model model) {
        categoryService.delete(id);
        model.addAttribute("id", id);
        return "categories/deletedCategory";
    }


}
