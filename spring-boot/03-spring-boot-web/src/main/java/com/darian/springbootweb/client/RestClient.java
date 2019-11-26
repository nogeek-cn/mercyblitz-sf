package com.darian.springbootweb.client;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

public class RestClient {
    public static void main(String[] args) {

        HttpClient client = HttpClientBuilder.create().build();

        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory(client));

        String context = restTemplate.getForObject("http://localhost:8888/html/demo3", String.class);
        System.out.println(context);

    }

}
