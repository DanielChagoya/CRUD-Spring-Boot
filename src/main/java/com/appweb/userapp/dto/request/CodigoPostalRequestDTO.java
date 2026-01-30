package com.appweb.userapp.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class CodigoPostalRequestDTO {

    @NotNull(message = "El código postal es obligatorio")
    @Min(value = 10000, message = "El código postal debe tener 5 dígitos")
    @Max(value = 99999, message = "El código postal debe tener 5 dígitos")
    private long cp;

    public long getCp() {return cp;}
    public void setCp(long cp) {this.cp = cp;}

}
