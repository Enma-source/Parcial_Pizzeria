import javax.swing.*;
import java.awt.*;

public class Ejemplo1_Ventana extends JFrame {

    private Orden[] ordenesPendientes = new Orden[5];
    private Orden[] ordenesEntregadas = new Orden[100];

    private int cantidadPendientes = 0;
    private int cantidadEntregadas = 0;
    private int numeroOrden = 1;

    private JTextArea areaInformacion;

    public Ejemplo1_Ventana() {

        setTitle("Pizzeria");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());

        JLabel titulo = new JLabel(
                "SISTEMA DE PIZZERIA",
                SwingConstants.CENTER
        );

        titulo.setFont(new Font("Arial", Font.BOLD, 24));

        panelPrincipal.add(titulo, BorderLayout.NORTH);

        // Area donde se muestran las ordenes
        areaInformacion = new JTextArea();

        areaInformacion.setEditable(false);
        areaInformacion.setFont(
                new Font("Monospaced", Font.PLAIN, 14)
        );

        JScrollPane scroll = new JScrollPane(areaInformacion);

        panelPrincipal.add(scroll, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();

        JButton botonCrear = new JButton("Crear Orden");
        JButton botonVer = new JButton("Ver Ordenes");
        JButton botonEntregar = new JButton("Entregar Orden");
        JButton botonSalir = new JButton("Salir");

        panelBotones.add(botonCrear);
        panelBotones.add(botonVer);
        panelBotones.add(botonEntregar);
        panelBotones.add(botonSalir);

        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        add(panelPrincipal);

        botonCrear.addActionListener(e -> crearOrden());

        botonVer.addActionListener(e -> verOrdenes());

        botonEntregar.addActionListener(e -> entregarOrden());

        botonSalir.addActionListener(e -> System.exit(0));
    }

    private void crearOrden() {

        if (cantidadPendientes >= 5) {

            JOptionPane.showMessageDialog(
                    this,
                    "La cocina esta saturada.\n" +
                    "No se pueden agregar mas ordenes pendientes."
            );

            return;
        }

        String nombreCliente = JOptionPane.showInputDialog(
                this,
                "Nombre del cliente:"
        );

        if (nombreCliente == null) {
            return;
        }

        String cantidadTexto = JOptionPane.showInputDialog(
                this,
                "Cantidad de pizzas:"
        );

        if (cantidadTexto == null) {
            return;
        }

        int cantidadPizzas = Integer.parseInt(cantidadTexto);

        Pizza[] pizzas = new Pizza[cantidadPizzas];


        // Crear cada pizza
        for (int i = 0; i < cantidadPizzas; i++) {

            JOptionPane.showMessageDialog(
                    this,
                    "Creando Pizza " + (i + 1)
            );

            pizzas[i] = crearPizza(i + 1);

            if (pizzas[i] == null) {
                return;
            }
        }


        Orden nuevaOrden = new Orden(
                numeroOrden,
                pizzas,
                nombreCliente,
                true
        );

        ordenesPendientes[cantidadPendientes] = nuevaOrden;

        cantidadPendientes++;
        numeroOrden++;

        JOptionPane.showMessageDialog(
                this,
                "Orden creada correctamente.\n" +
                "Numero de orden: " +
                nuevaOrden.getNumero()
        );

        verOrdenes();
    }

    private Pizza crearPizza(int numeroPizza) {

        String masa = JOptionPane.showInputDialog(
                this,
                "Pizza " + numeroPizza +
                "\nIngrese el tipo de masa:"
        );

        if (masa == null) {
            return null;
        }

        String[] opcionesSalsa = {
                "PICANTE",
                "ALFREDO",
                "TOMATE"
        };

        String salsaSeleccionada = (String)
                JOptionPane.showInputDialog(
                        this,
                        "Seleccione la salsa:",
                        "Pizza " + numeroPizza,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        opcionesSalsa,
                        opcionesSalsa[0]
                );

        if (salsaSeleccionada == null) {
            return null;
        }

        Salsa salsa = null;

        switch (salsaSeleccionada) {

            case "PICANTE":
                salsa = Salsa.PICANTE;
                break;

            case "ALFREDO":
                salsa = Salsa.ALFREDO;
                break;

            case "TOMATE":
                salsa = Salsa.TOMATE;
                break;
        }

        Ingrediente[] ingredientes = new Ingrediente[3];

        int cantidadIngredientes = 0;


        while (cantidadIngredientes < 3) {

            String[] opciones;

            if (cantidadIngredientes == 0) {

                opciones = new String[]{
                        "PEPPERONI",
                        "JAMON",
                        "HONGOS",
                        "CARNE",
                        "SALCHICHA"
                };

            } else {

                opciones = new String[]{
                        "PEPPERONI",
                        "JAMON",
                        "HONGOS",
                        "CARNE",
                        "SALCHICHA",
                        "NINGUNO"
                };
            }


            String ingredienteSeleccionado =
                    (String) JOptionPane.showInputDialog(
                            this,
                            "Seleccione ingrediente " +
                            (cantidadIngredientes + 1) +
                            ":",
                            "Pizza " + numeroPizza,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            opciones,
                            opciones[0]
                    );


            if (ingredienteSeleccionado == null) {
                return null;
            }


            if (ingredienteSeleccionado.equals("NINGUNO")) {
                break;
            }


            switch (ingredienteSeleccionado) {

                case "PEPPERONI":

                    ingredientes[cantidadIngredientes] =
                            Ingrediente.PEPPERONI;

                    break;


                case "JAMON":

                    ingredientes[cantidadIngredientes] =
                            Ingrediente.JAMON;

                    break;


                case "HONGOS":

                    ingredientes[cantidadIngredientes] =
                            Ingrediente.HONGOS;

                    break;


                case "CARNE":

                    ingredientes[cantidadIngredientes] =
                            Ingrediente.CARNE;

                    break;


                case "SALCHICHA":

                    ingredientes[cantidadIngredientes] =
                            Ingrediente.SALCHICHA;

                    break;
            }

            cantidadIngredientes++;
        }


        return new Pizza(
                masa,
                salsa,
                ingredientes
        );
    }

    private void verOrdenes() {

        areaInformacion.setText("");

        areaInformacion.append(
                "========== ORDENES PENDIENTES ==========\n\n"
        );


        if (cantidadPendientes == 0) {

            areaInformacion.append(
                    "No hay ordenes pendientes.\n"
            );

        } else {

            for (int i = 0;
                 i < cantidadPendientes;
                 i++) {

                mostrarOrden(
                        ordenesPendientes[i]
                );
            }
        }


        areaInformacion.append(
                "\n========== ORDENES ENTREGADAS ==========\n\n"
        );


        if (cantidadEntregadas == 0) {

            areaInformacion.append(
                    "No hay ordenes entregadas.\n"
            );

        } else {

            for (int i = 0;
                 i < cantidadEntregadas;
                 i++) {

                mostrarOrden(
                        ordenesEntregadas[i]
                );
            }
        }
    }

    private void mostrarOrden(Orden orden) {

        areaInformacion.append(
                "----------------------------------------\n"
        );

        areaInformacion.append(
                "Orden #" + orden.getNumero() + "\n"
        );

        areaInformacion.append(
                "Cliente: " +
                orden.getNombreCliente() + "\n"
        );

        areaInformacion.append(
                "Estado: " +
                (orden.getPendiente()
                        ? "PENDIENTE"
                        : "ENTREGADA")
                + "\n"
        );


        Pizza[] pizzas = orden.getPizzas();


        for (int i = 0; i < pizzas.length; i++) {

            Pizza pizza = pizzas[i];

            areaInformacion.append(
                    "\nPizza " + (i + 1) + "\n"
            );

            areaInformacion.append(
                    "  Masa: " +
                    pizza.getMasa() + "\n"
            );

            areaInformacion.append(
                    "  Salsa: " +
                    pizza.getSalsa() + "\n"
            );

            areaInformacion.append(
                    "  Ingredientes:\n"
            );


            Ingrediente[] ingredientes =
                    pizza.getIngredientes();


            for (int j = 0;
                 j < ingredientes.length;
                 j++) {

                if (ingredientes[j] != null) {

                    areaInformacion.append(
                            "    - " +
                            ingredientes[j] +
                            "\n"
                    );
                }
            }
        }

        areaInformacion.append("\n");
    }

    private void entregarOrden() {

        if (cantidadPendientes == 0) {

            JOptionPane.showMessageDialog(
                    this,
                    "No hay ordenes pendientes."
            );

            return;
        }

        String[] opciones =
                new String[cantidadPendientes];


        for (int i = 0;
             i < cantidadPendientes;
             i++) {

            opciones[i] =
                    "Orden #" +
                    ordenesPendientes[i].getNumero() +
                    " - " +
                    ordenesPendientes[i].getNombreCliente();
        }


        String seleccion =
                (String) JOptionPane.showInputDialog(
                        this,
                        "Seleccione la orden que desea entregar:",
                        "Ordenes Pendientes",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        opciones,
                        opciones[0]
                );


        if (seleccion == null) {
            return;
        }


        int posicion = -1;

        for (int i = 0;
             i < cantidadPendientes;
             i++) {

            if (seleccion.equals(opciones[i])) {

                posicion = i;
                break;
            }
        }


        if (posicion == -1) {
            return;
        }


        Orden ordenSeleccionada =
                ordenesPendientes[posicion];

        String resumen =
                crearResumenOrden(
                        ordenSeleccionada
                );


        int confirmar =
                JOptionPane.showConfirmDialog(
                        this,
                        resumen +
                        "\n¿Marcar esta orden como entregada?",
                        "Confirmar entrega",
                        JOptionPane.YES_NO_OPTION
                );


        if (confirmar != JOptionPane.YES_OPTION) {
            return;
        }

        ordenSeleccionada.setPendiente(false);

        ordenesEntregadas[cantidadEntregadas] =
                ordenSeleccionada;

        cantidadEntregadas++;

        for (int i = posicion;
             i < cantidadPendientes - 1;
             i++) {

            ordenesPendientes[i] =
                    ordenesPendientes[i + 1];
        }

        ordenesPendientes[
                cantidadPendientes - 1
        ] = null;


        cantidadPendientes--;


        JOptionPane.showMessageDialog(
                this,
                "Orden #" +
                ordenSeleccionada.getNumero() +
                " entregada correctamente."
        );


        verOrdenes();
    }

    private String crearResumenOrden(Orden orden) {

        String resumen = "";

        resumen +=
                "Orden #" +
                orden.getNumero() +
                "\n";

        resumen +=
                "Cliente: " +
                orden.getNombreCliente() +
                "\n\n";


        Pizza[] pizzas = orden.getPizzas();


        for (int i = 0;
             i < pizzas.length;
             i++) {

            Pizza pizza = pizzas[i];

            resumen +=
                    "Pizza " +
                    (i + 1) +
                    "\n";

            resumen +=
                    "Masa: " +
                    pizza.getMasa() +
                    "\n";

            resumen +=
                    "Salsa: " +
                    pizza.getSalsa() +
                    "\n";

            resumen +=
                    "Ingredientes:\n";


            Ingrediente[] ingredientes =
                    pizza.getIngredientes();


            for (int j = 0;
                 j < ingredientes.length;
                 j++) {

                if (ingredientes[j] != null) {

                    resumen +=
                            "- " +
                            ingredientes[j] +
                            "\n";
                }
            }

            resumen += "\n";
        }


        return resumen;
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            Ejemplo1_Ventana ventana = new Ejemplo1_Ventana();

            ventana.setVisible(true);
        });
    }
}