public class Entrega {
    private String hora;
    private String dataE;
    private int NumVen;
    private String Placa;
    private int CodMot;

    public Entrega(String hora, String dataE, int NumVen, String Placa, int CodMot) {
        this.hora = hora;
        this.dataE = dataE;
        this.NumVen = NumVen;
        this.Placa = Placa;
        this.CodMot = CodMot;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDataE() {
        return dataE;
    }

    public void setDataE(String dataE) {
        this.dataE = dataE;
    }

    public int getNumVen() {
        return NumVen;
    }

    public void setNumVen(int NumVen) {
        this.NumVen = NumVen;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String Placa) {
        this.Placa = Placa;
    }

    public int getCodMot() {
        return CodMot;
    }

    public void setCodMot(int CodMot) {
        this.CodMot = CodMot;
    }
    
}
