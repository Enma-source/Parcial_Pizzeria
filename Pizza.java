public class Pizza {

    private String masa;
    private Salsa salsa;
    private Ingrediente[] ingredientes;
    private Ingrediente ingrediente;

    public Pizza(String masa, Salsa salsa, Ingrediente[] ingredientes) {
        this.masa = masa;
        this.salsa = salsa;
        this.ingredientes = ingredientes;
    }

    public Pizza(String masa, Salsa salsa, Ingrediente ingrediente) {
        this.masa = masa;
        this.salsa = salsa;
        this.ingrediente = ingrediente;
    }

    public String getMasa() {
        return masa;
    }

    public void setMasa(String masa) {
        this.masa = masa;
    }

    public Salsa getSalsa() {
        return salsa;
    }

    public void setSalsa(Salsa salsa) {
        this.salsa = salsa;
    }

    public Ingrediente[] getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(Ingrediente[] ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }
} 
