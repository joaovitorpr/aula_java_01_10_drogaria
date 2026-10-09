package br.com.fiap.model.entity;


import br.com.fiap.model.dto.PokemonDTO;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "Pokemon")
@Table(name = "dddj_pokemon")
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nome;
    private double altura;
    private double peso;
    private String categoria;
    private LocalDate dataDeCaptura;
    private String urlImagem;

    public Pokemon(){}

    public Pokemon(PokemonDTO pokemonDTO){
        this.nome = pokemonDTO.nome();
        this.altura = pokemonDTO.altura();
        this.peso = pokemonDTO.peso();
        this.categoria = pokemonDTO.categoria();
        this.dataDeCaptura = pokemonDTO.dataDaCaptura();
        this.urlImagem = pokemonDTO.urlimagem();
    }

    public Long getCodigo() {
        return codigo;
    }
    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public LocalDate getDataDeCaptura() {
        return dataDeCaptura;
    }
    public void setDataDeCaptura(LocalDate dataDeCaptura) {
        this.dataDeCaptura = dataDeCaptura;
    }
    public String getUrlImagem() {
        return urlImagem;
    }
    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }
}
