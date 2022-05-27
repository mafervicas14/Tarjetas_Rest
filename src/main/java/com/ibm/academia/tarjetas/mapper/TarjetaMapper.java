package com.ibm.academia.tarjetas.mapper;

import com.ibm.academia.tarjetas.models.dto.TarjetaDTO;
import com.ibm.academia.tarjetas.models.entities.Tarjeta;

public class TarjetaMapper 
{

	public static TarjetaDTO mapTarjeta(Tarjeta tarjeta)
    {
        TarjetaDTO tarjetaDTO = new TarjetaDTO();
        tarjetaDTO.setId(tarjeta.getId());
        tarjetaDTO.setNombreTarjeta(tarjeta.getNombreTarjeta());
        tarjetaDTO.setPreferencias(tarjeta.getPreferencias());
        tarjetaDTO.setSalarioMinimo(tarjeta.getSalarioMinimo());
        tarjetaDTO.setSalarioMaximo(tarjeta.getSalarioMaximo());
        tarjetaDTO.setEdadMinima(tarjeta.getEdadMinima());
        tarjetaDTO.setEdadMaxima(tarjeta.getEdadMaxima());
        return tarjetaDTO;
    }
	
}
