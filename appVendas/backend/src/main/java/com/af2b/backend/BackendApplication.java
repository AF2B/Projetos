package com.af2b.backend;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import com.af2b.backend.Repository.AddressRepository;
import com.af2b.backend.Repository.CategoryRepository;
import com.af2b.backend.Repository.CityRepository;
import com.af2b.backend.Repository.ClientRepository;
import com.af2b.backend.Repository.PaymentRepository;
import com.af2b.backend.Repository.ProductRepository;
import com.af2b.backend.Repository.RequestRepository;
import com.af2b.backend.Repository.StateRepository;
import com.af2b.backend.domain.Address;
import com.af2b.backend.domain.Category;
import com.af2b.backend.domain.City;
import com.af2b.backend.domain.Client;
import com.af2b.backend.domain.Payment;
import com.af2b.backend.domain.PaymentWithBoleto;
import com.af2b.backend.domain.PaymentWithCard;
import com.af2b.backend.domain.Product;
import com.af2b.backend.domain.Request;
import com.af2b.backend.domain.State;
import com.af2b.backend.domain.enums.ClientType;
import com.af2b.backend.domain.enums.PaymentState;

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
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private RequestRepository requestRepository;
	@Autowired
	private PaymentRepository paymentRepository;

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

		Client client1 = new Client(null, "André", "dev_andre.filipe@outlook.com", "123.456.789-10", ClientType.PF);
		client1.getPhones().addAll(Arrays.asList("(81)99737-9986"));

		Address address1 = new Address(null, "Rua Teste", "66", "Apto 301", "Teste", "38250270", client1, city1);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		Request request1 = new Request(null, sdf.parse("23/06/2022 05:40pm"), client1, address1);
		Request request2 = new Request(null, sdf.parse("24/06/2022 02:00pm"), client1, address1);

		Payment payment1 = new PaymentWithCard(null, PaymentState.QUITADO, request2, 1);
		Payment payment2 = new PaymentWithBoleto(null, PaymentState.QUITADO, request1, sdf.parse("23/06/2022 12:30pm"), sdf.parse("23/06/2022 12:31pm"));

		request1.setPayment(payment2);
		request2.setPayment(payment1);
		
		category1.getProducts().addAll(Arrays.asList(product1, product2, product3));
		category2.getProducts().addAll(Arrays.asList(product2));

		product1.getCategories().addAll(Arrays.asList(category1));
		product2.getCategories().addAll(Arrays.asList(category1, category2));
		product3.getCategories().addAll(Arrays.asList(category1));

		state1.getCities().addAll(Arrays.asList(city1));
		state2.getCities().addAll(Arrays.asList(city2));

		client1.getAddress().addAll(Arrays.asList(address1));
		client1.getRequest().addAll(Arrays.asList(request1, request2));

		categoryRepository.saveAll(Arrays.asList(category1, category2));
		productRepository.saveAll(Arrays.asList(product1, product2, product3));
		stateRepository.saveAll(Arrays.asList(state1, state2));
		cityRepository.saveAll(Arrays.asList(city1, city2));
		clientRepository.saveAll(Arrays.asList(client1));
		addressRepository.saveAll(Arrays.asList(address1));
		requestRepository.saveAll(Arrays.asList(request1, request2));
		paymentRepository.saveAll(Arrays.asList(payment1, payment2));
	}

}
