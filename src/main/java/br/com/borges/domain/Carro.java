package br.com.borges.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CARRO")
public class Carro implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "carro_seq")
	@SequenceGenerator(name="carro_seq", sequenceName = "sq_carro", initialValue = 1, allocationSize = 1)
    private Long id;
	
	@Column(name = "CODIGO", length = 10, nullable = false, unique = true)
	private String Codigo;
	
	@Column(name = "MODELO", length = 10, nullable = false)
	private String modelo;
	
	@ManyToOne
	@JoinColumn(name = "id_marca_fk")
	private Marca marca;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return Codigo;
	}

	public void setCodigo(String codigo) {
		Codigo = codigo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	

}
