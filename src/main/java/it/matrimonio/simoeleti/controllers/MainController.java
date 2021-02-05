package it.matrimonio.simoeleti.controllers;

import it.matrimonio.simoeleti.dtos.RSVPDTO;
import it.matrimonio.simoeleti.dtos.RegaloDTO;
import it.matrimonio.simoeleti.dtos.RegaloWrapperDTO;
import it.matrimonio.simoeleti.entities.Oggetto;
import it.matrimonio.simoeleti.entities.Regalo;
import it.matrimonio.simoeleti.repositories.OggettoRepository;
import it.matrimonio.simoeleti.services.MainServiceImpl;
import it.matrimonio.simoeleti.services.NotificationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/API/")
public class MainController {

    @Autowired
    NotificationServiceImpl notificationService;

    @Autowired
    MainServiceImpl mainService;

    @Autowired
    OggettoRepository oggettoRepository;

    @PostMapping("RSVP")
    public void sendRsvp(@RequestBody @Valid RSVPDTO rsvpdto, BindingResult br){
        if (br.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        try {
            notificationService.sendMessageRSVP(rsvpdto);
        }catch(Exception e){
            System.out.println("Errore");
        }
    }

    @GetMapping("oggetti")
    public List<Oggetto> getOggettiListaNozze(){
        return mainService.getOggetti();
    }

    @PostMapping("regalo")
    public void addRegalo(@RequestBody @Valid RegaloWrapperDTO regaloWrapperDTO, BindingResult br){
        if (br.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        try {
            for(int i=0; i<regaloWrapperDTO.getRegali().size(); i++){
                RegaloDTO regaloDTO = (regaloWrapperDTO.getRegali()).get(i);
                Regalo regalo = Regalo.builder()//modelMapper.map(regaloDTO, Regalo.class);
                        .nomePartecipante(regaloDTO.getNomePartecipante())
                        .emailPartecipante(regaloDTO.getEmailPartecipante())
                        .oggetto(oggettoRepository.getOne(regaloDTO.getOggettoId()))
                        .quota(regaloDTO.getQuota())
                        .build();
                mainService.addRegalo(regalo);
                notificationService.sendMessageRegalo(regalo);
            }

        }catch(Exception e){
            System.out.println("Errore");
        }
    }
}
