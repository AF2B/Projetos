package com.af2b.backend.resources;

import java.util.ArrayList;
import java.util.List;

import com.af2b.backend.domain.Category;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * CategoryResource
 */
@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    @RequestMapping(method = RequestMethod.GET)
    public List<Category> list() {

        Category category1 = new Category(1, "Informática");
        Category category2 = new Category(2, "Escritório");

        List<Category> list = new ArrayList<>();
        list.add(category1);
        list.add(category2);
        
        return list;
    }
}