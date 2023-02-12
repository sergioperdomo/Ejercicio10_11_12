package com.example.Ejercicio10_11_12;

import com.example.Ejercicio10_11_12.entities.Laptop;
import com.example.Ejercicio10_11_12.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Ejercicio101112Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Ejercicio101112Application.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);

		// Crear un Laptop
		Laptop laptop0 = new Laptop(null, "Core i3",4, "Windows",760, 17);
		Laptop laptop1 = new Laptop(null, "Core i4",4, "Linux",300, 16);
		Laptop laptop2 = new Laptop(null, "Core i6",4, "Windows",450, 15);
		Laptop laptop3 = new Laptop(null, "Core i5",4, "Linux",700, 13);

		// Almacenar Laptos
		repository.save(laptop0);
		repository.save(laptop1);
		repository.save(laptop2);
		repository.save(laptop3);
	}
}
