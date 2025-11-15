package com.senai.ResourceScheduleSA.dtos;

public class UsuarioSessaoDto {

    private String nome;

    private Long id;

    public UsuarioSessaoDto() {
    }

    public UsuarioSessaoDto(Long id, String nome ) {
        this.id = id;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}