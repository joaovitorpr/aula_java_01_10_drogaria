package br.com.fiap.controller;

import br.com.fiap.model.dto.PokemonDTO;
import br.com.fiap.model.entity.Pokemon;
import br.com.fiap.model.repository.PokemonRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {
    @Autowired
    private PokemonRepository pokemonRepository;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid PokemonDTO pokemonDTO){
        try {
            Pokemon pokemon = new Pokemon(pokemonDTO);
            pokemonRepository.save(pokemon);
            return ResponseEntity.status(HttpStatus.CREATED).body(pokemon);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao salvar o pokemon");
        }
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<?> consultarPorCodigo(Long codigo){
        Pokemon pokemon = pokemonRepository.findByCodigo(codigo);
        if (pokemon != null) {
            return ResponseEntity.status(HttpStatus.OK).body(pokemon);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pokemon não encontrado");
        }
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<String>  excluir(@PathVariable Long codigo){
        if (pokemonRepository.existsById(codigo)) {
            pokemonRepository.deleteById(codigo);
            return ResponseEntity.ok("Pokemon solto com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pokemon não encontrado");
        }
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<String> atualizar(@PathVariable Long codigo, @RequestBody @Valid PokemonDTO pokemonDTO){
        try {
            Pokemon pokemon = new Pokemon(pokemonDTO);
            pokemon.setCodigo(codigo);
            pokemonRepository.save(pokemon);
            return ResponseEntity.ok("Informações do pokemon alteradas com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao atualizar informações do pokemon");
        }
    }


}
