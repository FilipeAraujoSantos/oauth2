package com.github.arocketman.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario", initialValue = 1, allocationSize = 1)
@Table(name = "usuario")
public class Usuario{

	@Id
	@Column(name="id", nullable=false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
	private Long id;
	
	@Column(name="nome", nullable=false)
	private String nome;

	@Column(name="cpf", nullable=false, unique=true)
	private String cpf;

	@Column(name="senha", nullable=false)
	private String senha;
	
    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Role> roles;

	
    
    // Constructors
    public Usuario() {
	}
	
	public Usuario(String nome, String senha, List<Role> roles) {
		this.nome = nome;
		this.senha = senha;
		this.cpf = "12233344445";
		this.roles = roles;
	}

	
	// Get's & Set's
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
}
