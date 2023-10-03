package Projeto;

public class Usuario {
    private int idUsuario;
    private String nomeUsuario;
    private UserType tipoUsuario;

    public Usuario(int idUsuario, String nomeUsuario, UserType tipoUsuario) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.tipoUsuario = tipoUsuario;
    }
}