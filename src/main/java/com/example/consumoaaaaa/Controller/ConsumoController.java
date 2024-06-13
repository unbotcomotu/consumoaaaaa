package com.example.consumoaaaaa.Controller;

import com.example.consumoaaaaa.Dao.PokemonDao;
import com.example.consumoaaaaa.Entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class ConsumoController {
    private PokemonDao pokemonDao;

    public ConsumoController(PokemonDao pokemonDao) {
        this.pokemonDao = pokemonDao;
    }

    @GetMapping("caso1")
    public ResponseEntity<HashMap<String, Object>> probarCaso1(@RequestParam(value = "nombre", required = false) String nombre) {
        HashMap<String, Object> lista = pokemonDao.caso1(nombre);
        return ResponseEntity.ok(lista);
    }

    @PostMapping("registrarUsuario")
    public ResponseEntity<HashMap<String, Object>> registrarUsuario(@RequestParam(value = "nombre", required = false) String nombre,
                                                                    @RequestParam(value = "contrasena", required = false) String contrasena,
                                                                    @RequestParam(value = "correo", required = false) String correo) {
        HashMap<String, Object> response = new HashMap<>();
        User user = new User();
        user.setNombre(nombre);
        user.setPassword(contrasena);
        user.setUsername(correo);
        pokemonDao.insertarUsuario(user);
        response.put("status", "success");
        return ResponseEntity.ok(response);
    }
}