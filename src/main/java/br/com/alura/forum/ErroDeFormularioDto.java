package br.com.alura.forum;

public class ErroDeFormularioDto {

    private String campo;
    private String erro; //enviando a mensagem do erro

    public ErroDeFormularioDto(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }
}
