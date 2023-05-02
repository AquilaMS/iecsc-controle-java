package com.iecsc.iecsccontrole.Utils;

import lombok.Getter;

@Getter
public enum RegisterType {

    ENTRADA_DIZIMO,
    ENTRADA_OFERTA,
    ENTRADA_VENDA,
    ENTRADA_CAMPANHA,
    SAIDA_COMPRA,
    SAIDA_CONTA_LUZ,
    SAIDA_CONTA_AGUA,
    SAIDA_VENDA;

    public RegisterType[] valuesArray(){
        return RegisterType.values();
    }
}
