package com.ibm.academia.tarjetas.models.dto;

import com.ibm.academia.tarjetas.enums.NombreTarjetas;
import com.ibm.academia.tarjetas.enums.Preferencias;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TarjetaDTO 
{
	
	private Long id;
    private NombreTarjetas nombreTarjeta;
    private Preferencias preferencias;
    private Double salarioMinimo;
    private Double salarioMaximo;
    private Double edadMinima;
    private Double edadMaxima;

}
