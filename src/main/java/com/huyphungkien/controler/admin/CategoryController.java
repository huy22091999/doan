package com.huyphungkien.controler.admin;

import com.huyphungkien.model.CategoryDto;
import com.huyphungkien.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {
    @Autowired
    private CategoryService cs;
    @GetMapping("")
    public String getAll(Model model){
        model.addAttribute("categorys",cs.getAll());
        return "/admin/category/list";
    }
    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("dto",new CategoryDto());
        model.addAttribute("i",4);
        return "/admin/category/add";
    }
    @PostMapping("/save")
    public ModelAndView save(CategoryDto dto){
        cs.save(dto);
        return new ModelAndView("redirect:/admin/category");
    }



}
