package Projeto;

public class Empregado extends Usuário {
    private Departamento departamento;

    public Empregado(int idUsuario, String nomeUsuario, Departamento departamento, UserType tipoUsuario) {
        super(idUsuario, nomeUsuario, tipoUsuario.EMPLOYEE);
        this.departamento = departamento;
    }
}