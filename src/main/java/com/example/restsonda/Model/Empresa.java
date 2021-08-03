package com.example.restsonda.Model;


import javax.persistence.*;

@Entity
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String email;

    @Column
    private String empresa;

    @Column
    private String cnpj;
    
    

	public Empresa() {
		
	}


	public Empresa(Long id, String nome, String email, String empresa, String cnpj) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.empresa = empresa;
		this.cnpj = cnpj;
	}


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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Empresa empresa = (Empresa) o;

        return id.equals(empresa.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}