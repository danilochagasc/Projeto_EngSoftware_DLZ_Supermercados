package com.dlz.backend.model.Cliente;

public enum ClientePermissao {
    ADMIN("ADMIN"),

    USER("USER");

    private String permissao;

    ClientePermissao(String permissao) {
        this.permissao = permissao;
    }

    public String getPermissao() {
        return permissao;
    }
}
