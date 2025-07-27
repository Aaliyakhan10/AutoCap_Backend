package com.doftec.AutoCap.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class AiConfig {

    @Value("${api-key}")
    private String apiKey;
    @Bean
  public RestClient restClient(){
        return RestClient.builder()
                .baseUrl("https://openrouter.ai/api/v1")
                .defaultHeader("Authorization","Bearer "+apiKey)
                .build();
    }
}
