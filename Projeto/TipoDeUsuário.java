package Projeto;

public class TipoDeUsuário {
    private String funcionario;
    private String administrador;

    public TipoDeUsuário() {
        this.funcionario = null;
        this.administrador = null;
    }

    public void setTipoUsuário(String tipoDeUsuário) {
        if (tipoDeUsuário == "funcionario") {
            this.funcionario = tipoDeUsuário;
        } else if (tipoDeUsuário == "administrador") {
            this.administrador = tipoDeUsuário;
        }
    }

    public String getTipoDeUsuário() {
        if (this.funcionario != null) {
            return this.funcionario;
        } else if (this.administrador != null) {
            return this.administrador;
        } else {
            return null;
        }
    }
}
