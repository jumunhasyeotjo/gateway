package com.jumunhasyeotjo.gateway;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import reactor.core.publisher.Hooks;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@PostConstruct
	public void init() {
		// Reactor의 비동기 스레드 간에 MDC 정보를 자동으로 전파하도록 설정
		Hooks.enableAutomaticContextPropagation();
	}
}
