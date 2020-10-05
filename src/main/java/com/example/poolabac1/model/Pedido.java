package com.example.poolabac1.model;

import java.time.LocalDate;

public class Pedido {
    private int codigo;
    private double valor;
    private String descricao;
    private String cliente;
    private LocalDate data;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Pedido [cliente=" + cliente + ", codigo=" + codigo + ", data=" + data
            + ", descricao=" + descricao + ", valor=" + valor + "]";
    } 
}
