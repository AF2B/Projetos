package com.af2b.backend;

import java.util.Arrays;

import com.af2b.backend.Repository.CategoryRepository;
import com.af2b.backend.Repository.ProductRepository;
import com.af2b.backend.domain.Category;
import com.af2b.backend.domain.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner{

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category category1 = new Category(null, "Informática");
		Category category2 = new Category(null, "Escritório");

		Product product1 = new Product(null, "Computador", 2000.00);
		Product product2 = new Product(null, "Impressora", 1299.00);
		Product product3 = new Product(null, "Mouse", 120.00);
		
		category1.getProducts().addAll(Arrays.asList(product1, product2));
		category2.getProducts().addAll(Arrays.asList(product1, product3));

		categoryRepository.saveAll(Arrays.asList(category1, category2));
		productRepository.saveAll(Arrays.asList(product1, product2, product3));
	}

}
