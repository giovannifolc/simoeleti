package it.matrimonio.simoeleti.services;

import it.matrimonio.simoeleti.entities.Oggetto;
import it.matrimonio.simoeleti.entities.RSVP;
import it.matrimonio.simoeleti.entities.Regalo;

import java.util.List;

public interface MainService {
    public List<Oggetto> getOggetti();
    public Oggetto getOggetto(String oggettoId);
    public List<RSVP> getAllRSVP();
    public RSVP getRSVP(Long RSVPId);
    public void addRegalo(Regalo regalo);
    public boolean isRegalabile(Regalo regalo);
    public void addRSVP(RSVP rsvp);
    public void addOggetto(Oggetto oggetto);

}
