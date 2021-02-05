package it.matrimonio.simoeleti.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Oggetto {

    @Id
    private String nome;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private Byte[] immagine;

    private double prezzoTotale;
    private double prezzoPagato;
    private double prezzoRimasto;

    public String getNome() {
        return nome;
    }

    public Byte[] getImmagine() {
        return immagine;
    }

    public double getPrezzoTotale() {
        return prezzoTotale;
    }

    public double getPrezzoPagato() {
        return prezzoPagato;
    }

    public double getPrezzoRimasto() {
        return prezzoRimasto;
    }
}
