package it.matrimonio.simoeleti.dtos;

import it.matrimonio.simoeleti.entities.Regalo;
import lombok.Data;

import java.util.List;

@Data
public class RegaloWrapperDTO {

    List<RegaloDTO> regali;

    public List<RegaloDTO> getRegali(){
        return regali;
    }
}
