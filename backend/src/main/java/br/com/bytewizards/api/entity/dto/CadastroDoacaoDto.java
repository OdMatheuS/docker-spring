package br.com.bytewizards.api.entity.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public record CadastroDoacaoDto(
        @NotBlank
        Long idDoador,
        @NotBlank
        Long IdAlimento,
        LocalDate dataValidade,
        @NotNull
        Double quantidade

) {
}
