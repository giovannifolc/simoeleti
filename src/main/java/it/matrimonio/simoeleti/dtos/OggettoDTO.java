package it.matrimonio.simoeleti.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class OggettoDTO {

    @NotEmpty
    String nome;

    @NotNull
    Byte[] immagine;

    @Positive
    double prezzoTotale;

    @Positive
    double prezzoPagato;

    @Positive
    double prezzoRimasto;
}
