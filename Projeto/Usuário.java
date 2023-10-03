public class Usuário {
    private int idUsuario;
    private String nomeUsuario;
    private UserType tipoUsuario;

    public Usuário(int idUsuario, String nomeUsuario, UserType tipoUsuario) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.tipoUsuario = tipoUsuario;
    }
}
