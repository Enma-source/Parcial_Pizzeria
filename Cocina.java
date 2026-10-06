public class Cocina {

    private Orden[] ordenesPendientes;
    private Orden[] ordenesEntregadas;
    private boolean saturado;
    private Orden orden;

    public Cocina(Orden[] oP, Orden[] oE, boolean saturado) {
        this.ordenesPendientes = oP;
        this.ordenesEntregadas = oE;
        this.saturado = saturado;
    }

    public Orden agregarOrden(Orden orden) {
        return orden;
    }

    public Orden entregarOrden(Orden orden) {
        return orden;
    }

    public Orden[] getOrdenesPendientes() {
        return ordenesPendientes;
    }

    public void setOrdenesPendientes(Orden[] ordenesPendientes) {
        this.ordenesPendientes = ordenesPendientes;
    }

    public Orden[] getOrdenesEntregadas() {
        return ordenesEntregadas;
    }

    public void setOrdenesEntregadas(Orden[] ordenesEntregadas) {
        this.ordenesEntregadas = ordenesEntregadas;
    }

    public boolean getSaturado() {
        return saturado;
    }

    public void setSaturado(boolean saturado) {
        this.saturado = saturado;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }
}