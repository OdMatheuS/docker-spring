package br.com.bytewizards.api.entity.dto;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public record AtualizarDistribuicaoDto(
        @NotBlank
        Long id,
        EnderecoDto endereco,
        LocalDate data,
        String horaInicio,
        String horaFim

) {
}
