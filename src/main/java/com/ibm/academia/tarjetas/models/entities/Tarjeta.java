package com.ibm.academia.tarjetas.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ibm.academia.tarjetas.enums.NombreTarjetas;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
@Table(name="tarjetas")
public class Tarjeta 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name="nombre_tarjeta")
	@Enumerated(EnumType.STRING)
	private NombreTarjetas nombreTarjeta;
	

}
