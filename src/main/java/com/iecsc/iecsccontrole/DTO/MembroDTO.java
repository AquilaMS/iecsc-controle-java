package com.iecsc.iecsccontrole.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MembroDTO {

    private String name;
    private String estadoCivil;
    private String dataNascimento;

    public void clearFields(){
        this.name = "";
        this.dataNascimento = "";
        this.estadoCivil = "";
    }

    @Override
    public String toString() {
        return "" +
                "name='" + name + '\'' +
                ", estadoCivil='" + estadoCivil + '\'' +
                ", dataNascimento='" + dataNascimento + '\'';
    }
}
