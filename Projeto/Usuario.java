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
}
