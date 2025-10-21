package com.generation.blogpessoal.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity // Informa que essa classe será usada como modelo para criação da tabela no DB
@Table (name = "tb_postagens") // Criando a tabela definindo o nome expecifico (CREATE TABLE tb_postagens)

public class Postagem {
	
	@Id // É a identificação da chave primaria no DB ( PRIMARY KEY (id))
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Auto incremento DB (AUTO_INCREMENT)
	private Long id;
	
	@Column(length = 100) // Define do atributo tamanho no banco de dados
	@NotBlank(message = "O atributo titulo é obrigatório") // Informa que o campo não pode ser vazio
	@Size(min = 5, max = 100, message ="O atributo titulo deve conter no minimo 5 e no maximo 100 caracteres") // Defini a quantidade de caracteres para o atributo
	private String titulo;
	
	@Column(length = 1000) // Define do atributo tamanho no banco de dados
	@NotBlank(message = "O atributo texto é obrigatório") // Informa que o campo não pode ser vazio
	@Size(min = 10, max = 1000, message ="O atributo texto deve conter no minimo 5 e no maximo 100 caracteres") // Defini a quantidade de caracteres para o atributo
	private String texto;
	
	@UpdateTimestamp // Atualiza a data e a hora todas as vezes que for feito alguma alteração ou criação
	private LocalDateTime data;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;
	
    //Getters e Setters
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getTexto() {
		return texto;
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public LocalDateTime getData() {
		return data;
	}
	
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	
	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


}
