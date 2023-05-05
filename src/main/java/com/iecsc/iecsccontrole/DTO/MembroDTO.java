package com.iecsc.iecsccontrole.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MembroDTO {

    private String name;
    private String estado_civil;
    private String data_nascimento;

    public void clearFields(){
        this.name = "";
        this.data_nascimento = "";
        this.estado_civil = "";
    }

    @Override
    public String toString() {
        return "" +
                "name='" + name + '\'' +
                ", estadoCivil='" + estado_civil + '\'' +
                ", dataNascimento='" + data_nascimento + '\'';
    }
}
