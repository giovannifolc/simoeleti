package it.matrimonio.simoeleti.dtos;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class RegaloDTO {

    @NotEmpty
    private String nomePartecipante;
    @NotEmpty
    private String emailPartecipante;
    @Positive
    private Double quota;
    @NotNull
    private String oggettoId;

}
