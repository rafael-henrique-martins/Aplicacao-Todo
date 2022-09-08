package com.rhmrmtm.todo.domain.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class TodoDTO {

    private Integer id;
    private String titulo;
    private String descricao;
    private LocalDateTime dataParaFInalizar;
    private Boolean finalizado = false;

    public TodoDTO() {}

    public TodoDTO(Integer id, String titulo, String descricao, LocalDateTime dataParaFInalizar, Boolean finalizado) {
        super();
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataParaFInalizar = dataParaFInalizar;
        this.finalizado = finalizado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataParaFInalizar() {
        return dataParaFInalizar;
    }

    public void setDataParaFInalizar(LocalDateTime dataParaFInalizar) {
        this.dataParaFInalizar = dataParaFInalizar;
    }

    public Boolean getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(Boolean finalizado) {
        this.finalizado = finalizado;
    }

}
