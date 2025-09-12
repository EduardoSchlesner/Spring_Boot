package br.com.alura.forum.controller.dto;

public class TokenDto {

    private String token;
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public String getToken() {
        return token;
    }

    public TokenDto(String token, String tipo) {
        this.token = token;
        this.tipo = tipo;
    }
}
