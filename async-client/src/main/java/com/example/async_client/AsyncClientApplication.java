package com.example.async_client;

import com.example.async_client.client.FluxClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class AsyncClientApplication {
	public AsyncClientApplication(){
		System.out.println("Hello World");
	}

	public static void main(String[] args) {
		SpringApplication.run(AsyncClientApplication.class, args);
	}

	@Bean
	WebClient webClient(WebClient.Builder builder){
		return builder.baseUrl("http://localhost:8080").build();
	}

	@Bean
	CommandLineRunner commandLineRunner(FluxClient client){
		return args -> {
			Flux<Long> flux = client.getValues();
			flux.subscribe(System.out::println);
		};
	}

}
