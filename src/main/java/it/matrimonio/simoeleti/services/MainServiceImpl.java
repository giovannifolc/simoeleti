package it.matrimonio.simoeleti.services;

import it.matrimonio.simoeleti.entities.Oggetto;
import it.matrimonio.simoeleti.entities.RSVP;
import it.matrimonio.simoeleti.entities.Regalo;
import it.matrimonio.simoeleti.repositories.OggettoRepository;
import it.matrimonio.simoeleti.repositories.RSVPRepository;
import it.matrimonio.simoeleti.repositories.RegaloRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MainServiceImpl implements MainService {

    @Autowired
    OggettoRepository oggettoRepository;

    @Autowired
    RSVPRepository rsvpRepository;

    @Autowired
    RegaloRepository regaloRepository;

    @Override
    public List<Oggetto> getOggetti() {
        return oggettoRepository.findAll();
    }

    @Override
    public Oggetto getOggetto(String oggettoId) {
        if(oggettoRepository.existsById(oggettoId)){
            return oggettoRepository.getOne(oggettoId);
        }else{
            return null;
        }
    }

    @Override
    public List<RSVP> getAllRSVP() {
        return rsvpRepository.findAll();
    }

    @Override
    public RSVP getRSVP(Long RSVPId) {
        if(rsvpRepository.existsById(RSVPId)){
            return rsvpRepository.getOne(RSVPId);
        }else{
            return null;
        }
    }

    @Override
    public void addRegalo(Regalo regalo) {
        if(isRegalabile(regalo) && !regaloRepository.existsById(regalo.getId())){
            regaloRepository.save(regalo);
            aggiornaSoldiOggetto(regalo);
        }
    }

    private void aggiornaSoldiOggetto(Regalo regalo) {
        Oggetto oggetto = regalo.getOggetto();
        oggetto.setPrezzoPagato(oggetto.getPrezzoPagato() + regalo.getQuota());
        oggetto.setPrezzoRimasto(oggetto.getPrezzoRimasto() - regalo.getQuota());
        oggettoRepository.save(oggetto);
    }

    @Override
    public boolean isRegalabile(Regalo regalo) {
        if(regalo.getOggetto().getPrezzoRimasto() < regalo.getQuota()){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public void addRSVP(RSVP rsvp) {
        if(!rsvpRepository.existsById(rsvp.getId())) {
            rsvpRepository.save(rsvp);
        }
    }

    @Override
    public void addOggetto(Oggetto oggetto) {
        if(!oggettoRepository.existsById(oggetto.getNome())){
            oggettoRepository.save(oggetto);
        }
    }
}
