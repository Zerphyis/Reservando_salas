package ms_email.salas.salas.controller;

import ms_email.salas.salas.Salas;
import ms_email.salas.salas.model.ServiceSalas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/homesalas")
public class ControllerSalas {

@Autowired
private  ServiceSalas service;

        @PostMapping
        public ResponseEntity<Salas> criarSala(@RequestBody Salas sala) {
            return service.criandoSalas(sala);
        }

        @GetMapping
        public ResponseEntity<List<Salas>> listarSalas() {
            return service.listarSalas();
        }

        @GetMapping("/{id}")
        public ResponseEntity<Salas> buscarPorId(@PathVariable Long id) {
            return service.buscarSalaPorId(id);
        }

        @PutMapping("/atualizar/{id}")
        public ResponseEntity<Salas> atualizarSala(@PathVariable Long id, @RequestBody Salas salaAtualizada) {
            return service.atualizarSala(id, salaAtualizada);
        }

        @DeleteMapping("/deletar/{id}")
        public ResponseEntity<Void> deletarSala(@PathVariable Long id) {
            return service.deletarSala(id);
        }
    }


