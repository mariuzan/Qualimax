package app.bussines.v1.qualimax.data.model;

public class Ponto {
    private int id;
    private String nomePonto;
    private String telefonePonto;
    private String emailPonto;
    private String cnpjPonto;

    public Ponto(String nomePonto, String telefonePonto, String emailPonto, String cnpjPonto) {
        this.nomePonto = nomePonto;
        this.telefonePonto = telefonePonto;
        this.emailPonto = emailPonto;
        this.cnpjPonto = cnpjPonto;
    }

    public String getNomePonto() {
        return nomePonto;
    }

    public void setNomePonto(String nomePonto) {
        this.nomePonto = nomePonto;
    }

    public String getTelefonePonto() {
        return telefonePonto;
    }

    public void setTelefonePonto(String telefonePonto) {
        this.telefonePonto = telefonePonto;
    }

    public String getEmailPonto() {
        return emailPonto;
    }

    public void setEmailPonto(String emailPonto) {
        this.emailPonto = emailPonto;
    }

    public String getCnpjPonto() {
        return cnpjPonto;
    }

    public void setCnpjPonto(String cnpjPonto) {
        this.cnpjPonto = cnpjPonto;
    }
}
