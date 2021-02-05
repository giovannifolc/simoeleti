package it.matrimonio.simoeleti.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
public class Regalo {
    @Id
    @GeneratedValue
    private Long id;

    private String nomePartecipante;
    private String emailPartecipante;
    private Double quota;

    @ManyToOne
    @JoinColumn(name="oggetto_id")
    private Oggetto oggetto;


    public Long getId() {
        return id;
    }

    public String getNomePartecipante() {
        return nomePartecipante;
    }

    public String getEmailPartecipante() {
        return emailPartecipante;
    }

    public Double getQuota() {
        return quota;
    }

    public Oggetto getOggetto() {
        return oggetto;
    }
}
