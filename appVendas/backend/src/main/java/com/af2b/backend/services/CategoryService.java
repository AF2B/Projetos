package com.af2b.backend.services;

import java.util.Optional;

import com.af2b.backend.Repository.CategoryRepository;
import com.af2b.backend.domain.Category;
import com.af2b.backend.services.Exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CategoryService
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public Category find(Integer id) {
        Optional<Category> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
            "Objeto não encontrado! id: " + id + ", Tipo: " + Category.class.getName()
        ));
        }
}