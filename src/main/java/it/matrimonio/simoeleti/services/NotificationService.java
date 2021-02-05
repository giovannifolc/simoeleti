package it.matrimonio.simoeleti.services;

import it.matrimonio.simoeleti.dtos.RSVPDTO;
import it.matrimonio.simoeleti.entities.Regalo;

public interface NotificationService {
    public void sendMessageRSVP(RSVPDTO rsvpDTO);
    public void sendMessageRegalo(Regalo regalo);
}
