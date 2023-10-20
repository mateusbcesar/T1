package Projeto;

public class Usuario {
    private int idUsuario;
    private String nomeUsuario;
    private TipoDeUsuário tipoUsuario;

    public Usuario(int idUsuario, String nomeUsuario, TipoDeUsuário tipoUsuario) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.tipoUsuario = tipoUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public TipoDeUsuário getTipoUsuario() {
        return tipoUsuario;
    }

    public void setIdUsuario(int novoIdUsuario) {
        this.idUsuario = novoIdUsuario;
    }

    public void setNomeUsuario(String novoNomeUsuario) {
        this.nomeUsuario = novoNomeUsuario;
    }

    public void setTipoUsuario(TipoDeUsuário novoTipoUsuario) {
        this.tipoUsuario = novoTipoUsuario;
    }
}
