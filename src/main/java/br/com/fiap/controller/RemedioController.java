package br.com.fiap.controller;

import br.com.fiap.model.dto.RemedioDTO;
import br.com.fiap.model.entity.Remedio;
import br.com.fiap.model.repository.RemedioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drogaria")
public class RemedioController {
    @Autowired
    private RemedioRepository remedioRepository;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid RemedioDTO remedioDTO){
        try {
            Remedio remedio = new Remedio(remedioDTO);
            remedioRepository.save(remedio);
            return ResponseEntity.status(HttpStatus.CREATED).body(remedio);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao salvar remédio");
        }
    }

    @GetMapping
    public ResponseEntity<List<Remedio>> consultar(){
        List<Remedio> remedios = remedioRepository.findAll();
        return ResponseEntity.ok(remedios);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<?> consultarPorCodigo(Long codigo){
        Remedio remedio = remedioRepository.findByCodigo(codigo);
        if (remedio != null) {
            return ResponseEntity.status(HttpStatus.OK).body(remedio);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Remédio não encontrado");
        }
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<String> excluir(@PathVariable Long codigo){
        if(remedioRepository.existsById(codigo)) {
            remedioRepository.deleteById(codigo);
            return ResponseEntity.ok("Remédio deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Remédio não encontrado!");
        }
    }


}
