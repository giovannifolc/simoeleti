package it.matrimonio.simoeleti.services;

import it.matrimonio.simoeleti.dtos.RSVPDTO;
import it.matrimonio.simoeleti.dtos.RegaloDTO;
import it.matrimonio.simoeleti.entities.RSVP;
import it.matrimonio.simoeleti.entities.Regalo;
import it.matrimonio.simoeleti.repositories.OggettoRepository;
import it.matrimonio.simoeleti.repositories.RSVPRepository;
import it.matrimonio.simoeleti.repositories.RegaloRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public class NotificationServiceImpl implements NotificationService{

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RSVPRepository rsvpRepository;

    @Autowired
    private RegaloRepository regaloRepository;

    @Autowired
    private OggettoRepository oggettoRepository;

    String destinatario = "letizia.aghemo@gmail.com";

    @Override
    public void sendMessageRSVP(RSVPDTO rsvpDTO) {
        if(rsvpDTO == null){
            return;
        }
        RSVP rsvp = RSVP.builder().nome(rsvpDTO.getNome())
            .cognome(rsvpDTO.getCognome())
            .email(rsvpDTO.getEmail())
            .adulti(rsvpDTO.getAdulti())
            .bambini(rsvpDTO.getBambini())
            .intolleranze(rsvpDTO.getIntolleranze())
            .build();//modelMapper.map(rsvpDTO, RSVP.class);
        rsvpRepository.save(rsvp);
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setTo(destinatario);
            helper.setSubject("RSVP di " + rsvp.getNome() + " " + rsvp.getCognome());
            String body = "Conferma di partecipazione\n" +
                    "Nome: " + rsvp.getNome() + "\n" +
                    "Cognome: " + rsvp.getCognome() + "\n" +
                    "Email: " + rsvp.getEmail() + "\n" +
                    "Adulti: " + rsvp.getAdulti() + "\n" +
                    "Bambini: " + rsvp.getBambini() + "\n" +
                    "Intolleranze: " + rsvp.getIntolleranze() + "\n";
            helper.setText(body, true);

        javaMailSender.send(message);

        } catch (MessagingException ignored) {

        }
    }

    @Override
    public void sendMessageRegalo(Regalo regalo) {
        if (regalo == null) {
            return;
        }

        regaloRepository.save(regalo);
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setTo(destinatario);
            helper.setSubject("Regalo di " + regalo.getNomePartecipante() + " " + regalo.getEmailPartecipante());
            String body = regalo.getNomePartecipante() + " ti ha fatto un regalo!\n" +
                    "Ti ha regalato: " + regalo.getOggetto().getNome() + "\n" +
                    "Quota di partecipazione: " + regalo.getQuota() + "\n" +
                    "Prezzo totale dell'oggetto: " + regalo.getOggetto().getPrezzoTotale() + "\n" +
                    "Prezzo rimasto dell'oggetto: " + regalo.getOggetto().getPrezzoRimasto() + "\n" +
                    "Puoi rispondergli alla mail: " + regalo.getEmailPartecipante() + "\n";
            helper.setText(body, true);

            //javaMailSender.send(message);
        } catch (Exception e) {
            System.out.println("Errore " + e.getMessage());
        }
    }


}
