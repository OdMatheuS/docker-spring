package br.com.bytewizards.api.entity.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

public record CadastroDistribuicaoDto(
        @NotNull
        Long idOng,
        @NotNull
        EnderecoDto endereco,
        @NotNull
        LocalDate data,
        @NotBlank
        @Pattern(regexp = "\\d{2}:\\d{2}")
        String horaInicio,
        @NotBlank
        @Pattern(regexp = "\\d{2}:\\d{2}")
        String horaFim,
        @NotNull
        Long idDoacao,
        @NotNull
        Double quantidade
) {
}
