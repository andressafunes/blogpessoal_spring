package com.generation.blogpessoal.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;


@Entity // Informa que essa classe será usada como modelo para criação da tabela no DB
@Table (name = "tb_temas") // Criando a tabela definindo o nome expecifico (CREATE TABLE tb_tema)

public class Tema {
	
	@Id // É a identificação da chave primaria no DB ( PRIMARY KEY (id))
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Auto incremento DB (AUTO_INCREMENT)
	private Long id;
	
	@NotBlank(message = "O atributo descrição é obrigatório") // Informa que o campo não pode ser vazio
	private String descricao;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tema", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value = "tema", allowSetters = true)
	private List<Postagem> postagem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}


}
