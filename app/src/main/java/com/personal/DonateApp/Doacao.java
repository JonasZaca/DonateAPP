package com.personal.DonateApp;

import androidx.annotation.NonNull;

import java.math.BigDecimal;

public class Doacao {
    private Long id;
    private String tipoDoacao;
    private Double valor;
    private Long qtdProduto;
    private String tipoProduto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoDoacao() {
        return tipoDoacao;
    }

    public void setTipoDoacao(String tipoDoacao) {
        this.tipoDoacao = tipoDoacao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Long getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(Long qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }
}
