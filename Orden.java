public class Orden {

    private int numero;
    private Pizza[] pizzas;
    private String nombreCliente;
    private boolean pendiente;

    public Orden(int numero, Pizza[] pizzas, String nombreCliente, boolean pendiente) {
        this.numero = numero;
        this.pizzas = pizzas;
        this.nombreCliente = nombreCliente;
        this.pendiente = pendiente;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Pizza[] getPizzas() {
        return pizzas;
    }

    public void setPizzas(Pizza[] pizzas) {
        this.pizzas = pizzas;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public boolean getPendiente() {
        return pendiente;
    }

    public void setPendiente(boolean pendiente) {
        this.pendiente = pendiente;
    }
}