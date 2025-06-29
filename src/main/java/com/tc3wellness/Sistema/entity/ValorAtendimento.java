package com.tc3wellness.Sistema.entity;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValorAtendimento {
    private final int quantidadeCentavos;
    private static final BigDecimal CEM_DECIMAL = BigDecimal.valueOf(100);

    public BigDecimal ValorAtendimentoReais() {
        return BigDecimal.valueOf(quantidadeCentavos).divide(CEM_DECIMAL);
    }

    public int valorEmCentavos() {
        return quantidadeCentavos;
    }

    public ValorAtendimento (BigDecimal valorEmReal){
        this.quantidadeCentavos = valorEmReal.multiply(CEM_DECIMAL).intValue();
    }

}
