package com.ibm.academia.tarjetas.models.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.ibm.academia.tarjetas.enums.NombreTarjetas;
import com.ibm.academia.tarjetas.enums.Preferencias;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
@Table(name="tarjetas", schema = "tarjetas")
public class Tarjeta implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4375508986192393536L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name="nombre_tarjeta")
	@Enumerated(EnumType.STRING)
	private NombreTarjetas nombreTarjeta;
	
	@NotNull
	@NotEmpty
	@Column(name="preferencias")
	@Enumerated(EnumType.STRING)
	private Preferencias preferencias;
	

	@NotNull
	@NotEmpty
	@Positive(message = "Debe ser mayor a 0")
	@Column(name="salario_minimo")
	private Double salarioMinimo;
	
	@NotNull
	@NotEmpty
	@Positive(message = "Debe ser mayor a 0")
	@Column(name="salario_maximo")
	private Double salarioMaximo;
	
	@NotNull
	@NotEmpty
	@Min(value = 18, message = "Edad mínima es de 18")
	@Positive(message = "Debe ser mayor a 0")
	@Column(name="edad_minima")
	private Double edadMinima;
	
	@NotNull
	@NotEmpty
	@Max(value = 75, message = "Edad máxima 75")
	@Column(name="edad_maxima")
	private Double edadMaxima;
	

}
