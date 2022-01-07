package com.huyphungkien.controler.admin;

import com.huyphungkien.entity.TypePro;
import com.huyphungkien.model.ImageDto;
import com.huyphungkien.model.ProductDto;
import com.huyphungkien.model.TypeDto;
import com.huyphungkien.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/admin/product")
public class ProductController {
    @Autowired
    private ProductService ps;

    @GetMapping("")
    public String get(@RequestParam(name = "index")Optional<Integer> index, @RequestParam("size")Optional<Integer> size, Model model){
        int pIndex=index.orElse(1);
        int pSize=size.orElse(10);
        Pageable page= PageRequest.of(pIndex-1, pSize, Sort.by("name"));
        Page<ProductDto> p=ps.getPage(page);
        int total=p.getTotalPages();
        if(total>0) {
            int start=Math.max(1, pIndex-2);
            int end=Math.min(pIndex+2, total);
            List<Integer> listpage= IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
            model.addAttribute("numpage", listpage);
        }
        model.addAttribute("list", p);
        return"/admin/product/list";
    }
    @GetMapping("/add")
    public String add(Model model){
        List<ImageDto> images=new ArrayList<ImageDto>();
        for (int i=0;i<9;i++){
            images.add(new ImageDto());
        }
        List<TypeDto> types=new ArrayList<TypeDto>();
        for (int i=0;i<9;i++){
            types.add(new TypeDto());
        }
        ProductDto dto=new ProductDto();
        dto.setImages(images);
        dto.setTypes(types);
        model.addAttribute("dto",dto);
        return "/admin/product/add";
    }
    @PostMapping("/save")
    public ModelAndView save(ProductDto dto){
        ps.save(dto);
        return new ModelAndView("redirect:/admin/product");
    }
}
