package Projeto;

public class Funcionario extends Usuario {
    private Departamento departamento;

    public Funcionario(int idUsuario, String nomeUsuario, Departamento departamento, TipoDeUsuário tipoUsuario) {
        super(idUsuario, nomeUsuario, tipoUsuario);
        this.departamento = departamento;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento novoDepartamento) {
        this.departamento = novoDepartamento;
    }
}
