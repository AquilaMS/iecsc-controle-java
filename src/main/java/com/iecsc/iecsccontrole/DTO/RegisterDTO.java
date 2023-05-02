package com.iecsc.iecsccontrole.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegisterDTO {

    private String value;
    private String registerType;

    @Override
    public String toString() {
        return "RegisterDTO{" +
                "value='" + value + '\'' +
                ", registerType='" + registerType + '\'' +
                '}';
    }
}
