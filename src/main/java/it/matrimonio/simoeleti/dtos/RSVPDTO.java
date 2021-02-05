package it.matrimonio.simoeleti.dtos;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Data
public class RSVPDTO {

    @NotEmpty
    private String nome;
    @NotEmpty
    private String cognome;
    @NotEmpty
    private String email;
    @Positive
    private int adulti;

    private int bambini;

    private String intolleranze;
}
