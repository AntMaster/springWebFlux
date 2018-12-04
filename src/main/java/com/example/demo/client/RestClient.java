package com.example.demo.client;

import com.example.demo.entity.User;
import org.springframework.http.MediaType;


public class RestClient {
    public static void main(final String[] args) {
      /*  final User user = new User();
        user.setUsername("Test");
        user.setEmail("test@example.org");
        final WebClient client = WebClient.create("http://localhost:8080/user");
        final Mono<User> createdUser = client.post()
                .uri("")
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(user), User.class)
                .exchange()
                .flatMap(response -> response.bodyToMono(User.class));
        System.out.println(createdUser.block());*/
    }
}