package br.com.fiap.model.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

public record PokemonDTO(
        @NotBlank String nome,
        @NotNull @PositiveOrZero double altura,
        @NotNull @PositiveOrZero double peso,
        @NotBlank String categoria,
        @FutureOrPresent LocalDate dataDaCaptura,
        String urlimagem
){}
