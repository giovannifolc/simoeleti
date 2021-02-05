package it.matrimonio.simoeleti.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Builder
public class RSVP {
    @Id
    @GeneratedValue
    private Long id;

    private String nome;
    private String cognome;
    private String email;
    private int adulti;
    private int bambini;
    private String intolleranze;


    public RSVP(String nome, String cognome, String email, int adulti, int bambini, String intolleranze) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.adulti = adulti;
        this.bambini = bambini;
        this.intolleranze = intolleranze;
    }
}
