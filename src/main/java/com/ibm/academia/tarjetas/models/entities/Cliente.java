package com.ibm.academia.tarjetas.models.entities;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.ibm.academia.tarjetas.enums.NombreTarjetas;
import com.ibm.academia.tarjetas.enums.Preferencias;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="clientes", schema = "tarjetas")
public class Cliente implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 873485395320312469L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	
	@NotNull
	@NotEmpty
	@Column(name="nombre")
	private String nombre;
	
	@NotNull
	@NotEmpty
	@Min(value = 18, message = "Edad mínima es de 18")
    @Max(value = 75, message = "Edad máxima 75")
	@Column(name="edad")
    private Integer edad;
	
	@NotNull
	@NotEmpty
	@Min(value = 7000, message = "El salario minimo es de $7,000")
	@Column(name="salario_mensual")
	private Double salarioMensual;
	
	@NotNull
	@NotEmpty
	@Column(name="preferencias")
	@Enumerated(EnumType.STRING)
	private Preferencias preferencias;
	
	@Column(name="tarjeta_asignada")
	@Enumerated(EnumType.STRING)
	private NombreTarjetas tarjetaAsignada;
	
	
	@Column(name="fecha_alta")
    private Date fechaAlta;

    @Column(name="fecha_modificacion")
    private Date fechaModificacion;
   
    

    @PrePersist
    private void antesPersistir(){
    	
        this.fechaAlta = new Date();      
    }
      
    @PreUpdate
    private void antesActualizar(){
        this.fechaModificacion = new Date();
    }

    
	public Cliente(Long id, @NotNull @NotEmpty String nombre,
			@NotNull @NotEmpty @Min(value = 18, message = "Edad mínima es de 18") @Max(value = 75, message = "Edad máxima 75") Integer edad,
			@NotNull @NotEmpty @Min(value = 7000, message = "El salario minimo es de $7,000") Double salarioMensual,
			@NotNull @NotEmpty Preferencias preferencias) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.salarioMensual = salarioMensual;
		this.preferencias = preferencias;
	}

	

}
