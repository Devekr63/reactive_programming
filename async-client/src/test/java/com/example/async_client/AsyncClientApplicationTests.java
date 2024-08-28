package com.example.async_client;

import com.example.async_client.client.FluxClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class AsyncClientApplicationTests {

	@Mock
	private WebClient webClient;

	@Mock
	private WebClient.RequestHeadersUriSpec requestHeadersUriSpec;

	@Mock
	private WebClient.RequestHeadersSpec requestHeadersSpec;

	@Mock
	private WebClient.ResponseSpec responseSpec;

	private FluxClient fluxClient;

	@BeforeEach
	void setup(){
		fluxClient = new FluxClient(webClient);
	}

	@Test
	void contextLoads() {
		Mockito.when(webClient.get()).thenReturn(requestHeadersUriSpec);
		Mockito.when(requestHeadersUriSpec.uri("/fluxstream")).thenReturn(requestHeadersSpec);
		Mockito.when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
		Mockito.when(responseSpec.bodyToFlux(Integer.class)).thenReturn(Flux.just(0,1,2,3));

		Flux<Integer> result = fluxClient.getFourValues();

		StepVerifier.create(result)
				.expectNext(0,1,2,3)
				.verifyComplete();
	}
}
