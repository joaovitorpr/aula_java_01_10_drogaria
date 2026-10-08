package br.com.fiap.model.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record RemedioDTO(
        @NotBlank String nome,
        //notblank: faz a validação para ver se o espaço não está em branco
        @NotNull @PositiveOrZero Double preco,
        //notnull: Faz a validação para que o valor não seja nulo
        //PositiveOrzero: Valida para  ver se o preço é positivo ou zero, não permitindo valores negativos
        @PastOrPresent LocalDate dataDeFabricacao,
        //PastOrPresent: aceita datas passadas e atuais, somente essas.
        @FutureOrPresent LocalDate dataDeValidade,
        //FutureOrPresent: Aceita datas futuras e atuais, somente essas.
        String urlImagem
) {
}
