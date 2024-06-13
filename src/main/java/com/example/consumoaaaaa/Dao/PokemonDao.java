package com.example.consumoaaaaa.Dao;

import com.example.consumoaaaaa.Entity.User;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Component
public class PokemonDao {
    public HashMap<String,Object> caso1(String nombre){
        RestTemplate restTemplate=new RestTemplateBuilder()
                .basicAuthentication("joshfernandoy@gmail.com","ola")
                .build();
        ResponseEntity<Object>response=restTemplate.getForEntity("http://localhost:8080/listarLugaresEncuentroPokemon?nombre="+nombre, Object.class);
        HashMap<String,Object>hashMapResponse=(HashMap<String, Object>) response.getBody();
        return hashMapResponse;
    }

    public void insertarUsuario(User user){
        RestTemplate restTemplate=new RestTemplateBuilder()
                .basicAuthentication("joshfernandoy@gmail.com","ola")
                .build();
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String url="http://localhost:8080/registrarUsuario";
        HttpEntity<User>httpEntity=new HttpEntity<>(user,headers);
        restTemplate.postForEntity(url,httpEntity,User.class);
    }
}
