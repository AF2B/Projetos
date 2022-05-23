package com.af2b.backend;

import java.util.Arrays;

import com.af2b.backend.Repository.CategoryRepository;
import com.af2b.backend.Repository.CityRepository;
import com.af2b.backend.Repository.ProductRepository;
import com.af2b.backend.Repository.StateRepository;
import com.af2b.backend.domain.Category;
import com.af2b.backend.domain.City;
import com.af2b.backend.domain.Product;
import com.af2b.backend.domain.State;

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
	@Autowired
	private StateRepository stateRepository;
	@Autowired
	private CityRepository cityRepository;

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

		State state1 = new State(null, "Pernambuco");
		State state2 = new State(null, "Minas Gerais");

		City city1 = new City(null, "Recife", state1);
		City city2 = new City(null, "Uberlândia", state2);
		
		category1.getProducts().addAll(Arrays.asList(product1, product2, product3));
		category2.getProducts().addAll(Arrays.asList(product2));

		product1.getCategories().addAll(Arrays.asList(category1));
		product2.getCategories().addAll(Arrays.asList(category1, category2));
		product3.getCategories().addAll(Arrays.asList(category1));

		state1.getCities().addAll(Arrays.asList(city1));
		state2.getCities().addAll(Arrays.asList(city2));

		categoryRepository.saveAll(Arrays.asList(category1, category2));
		productRepository.saveAll(Arrays.asList(product1, product2, product3));
		stateRepository.saveAll(Arrays.asList(state1, state2));
		cityRepository.saveAll(Arrays.asList(city1, city2));
	}

}
