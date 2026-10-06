import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Orden[] ordenesPendientes = new Orden[5];
        Orden[] ordenesEntregadas = new Orden[100];

        int cantidadPendientes = 0;
        int cantidadEntregadas = 0;
        int numeroOrden = 1;

        int opcion;

        do {

            System.out.println("\n==============================");
            System.out.println("         PIZZERIA");
            System.out.println("==============================");
            System.out.println("1. Crear orden");
            System.out.println("2. Ver ordenes");
            System.out.println("3. Entregar orden pendiente");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                
                case 1:

                    if (cantidadPendientes >= 5) {
                        System.out.println("\nLa cocina esta saturada.");
                        System.out.println("No se pueden agregar mas ordenes pendientes.");
                        break;
                    }

                    System.out.println("\n===== CREAR ORDEN =====");
                    System.out.println("Numero de orden: " + numeroOrden);

                    System.out.print("Nombre del cliente: ");
                    String nombreCliente = scanner.nextLine();

                    System.out.print("Cantidad de pizzas: ");
                    int cantidadPizzas = scanner.nextInt();
                    scanner.nextLine();

                    Pizza[] pizzas = new Pizza[cantidadPizzas];

                    for (int i = 0; i < cantidadPizzas; i++) {

                        System.out.println("\n--- PIZZA " + (i + 1) + " ---");

                        System.out.print("Tipo de masa: ");
                        String masa = scanner.nextLine();

                        System.out.println("\nSeleccione una salsa:");
                        System.out.println("1. PICANTE");
                        System.out.println("2. ALFREDO");
                        System.out.println("3. TOMATE");
                        System.out.print("Opcion: ");

                        int opcionSalsa = scanner.nextInt();

                        Salsa salsa = null;

                        switch (opcionSalsa) {
                            case 1:
                                salsa = Salsa.PICANTE;
                                break;
                            case 2:
                                salsa = Salsa.ALFREDO;
                                break;
                            case 3:
                                salsa = Salsa.TOMATE;
                                break;
                        }

                        Ingrediente[] ingredientes = new Ingrediente[3];

                        int cantidadIngredientes = 0;

                        while (cantidadIngredientes < 3) {

                            System.out.println("\nSeleccione ingrediente "
                                    + (cantidadIngredientes + 1) + ":");

                            System.out.println("1. PEPPERONI");
                            System.out.println("2. JAMON");
                            System.out.println("3. HONGOS");
                            System.out.println("4. CARNE");
                            System.out.println("5. SALCHICHA");

                            if (cantidadIngredientes > 0) {
                                System.out.println("6. NINGUNO");
                            }

                            System.out.print("Opcion: ");

                            int opcionIngrediente = scanner.nextInt();

                            if (opcionIngrediente == 6 &&
                                    cantidadIngredientes > 0) {
                                break;
                            }

                            switch (opcionIngrediente) {

                                case 1:
                                    ingredientes[cantidadIngredientes] =
                                            Ingrediente.PEPPERONI;
                                    cantidadIngredientes++;
                                    break;

                                case 2:
                                    ingredientes[cantidadIngredientes] =
                                            Ingrediente.JAMON;
                                    cantidadIngredientes++;
                                    break;

                                case 3:
                                    ingredientes[cantidadIngredientes] =
                                            Ingrediente.HONGOS;
                                    cantidadIngredientes++;
                                    break;

                                case 4:
                                    ingredientes[cantidadIngredientes] =
                                            Ingrediente.CARNE;
                                    cantidadIngredientes++;
                                    break;

                                case 5:
                                    ingredientes[cantidadIngredientes] =
                                            Ingrediente.SALCHICHA;
                                    cantidadIngredientes++;
                                    break;

                                default:
                                    System.out.println("Opcion no valida.");
                                    break;
                            }
                        }

                        scanner.nextLine();

                        pizzas[i] = new Pizza(
                                masa,
                                salsa,
                                ingredientes
                        );
                    }

                    // Crear orden
                    Orden nuevaOrden = new Orden(
                            numeroOrden,
                            pizzas,
                            nombreCliente,
                            true
                    );

                    ordenesPendientes[cantidadPendientes] = nuevaOrden;

                    cantidadPendientes++;
                    numeroOrden++;

                    System.out.println("\nOrden creada correctamente.");

                    break;

                case 2:

                    System.out.println("\n===== ORDENES PENDIENTES =====");

                    if (cantidadPendientes == 0) {

                        System.out.println("No hay ordenes pendientes.");

                    } else {

                        for (int i = 0; i < cantidadPendientes; i++) {

                            Orden orden = ordenesPendientes[i];

                            System.out.println("\n------------------------");
                            System.out.println(
                                    "Orden #" + orden.getNumero()
                            );

                            System.out.println(
                                    "Cliente: " +
                                    orden.getNombreCliente()
                            );

                            Pizza[] pizzasOrden = orden.getPizzas();

                            for (int j = 0; j < pizzasOrden.length; j++) {

                                Pizza pizza = pizzasOrden[j];

                                System.out.println(
                                        "\nPizza " + (j + 1)
                                );

                                System.out.println(
                                        "Masa: " +
                                        pizza.getMasa()
                                );

                                System.out.println(
                                        "Salsa: " +
                                        pizza.getSalsa()
                                );

                                System.out.println("Ingredientes:");

                                Ingrediente[] ingredientes =
                                        pizza.getIngredientes();

                                for (int k = 0;
                                     k < ingredientes.length;
                                     k++) {

                                    if (ingredientes[k] != null) {
                                        System.out.println(
                                                "- " +
                                                ingredientes[k]
                                        );
                                    }
                                }
                            }
                        }
                    }


                    System.out.println("\n===== ORDENES ENTREGADAS =====");

                    if (cantidadEntregadas == 0) {

                        System.out.println("No hay ordenes entregadas.");

                    } else {

                        for (int i = 0;
                             i < cantidadEntregadas;
                             i++) {

                            Orden orden =
                                    ordenesEntregadas[i];

                            System.out.println(
                                    "Orden #" +
                                    orden.getNumero() +
                                    " - " +
                                    orden.getNombreCliente()
                            );
                        }
                    }

                    break;

                case 3:

                    if (cantidadPendientes == 0) {

                        System.out.println(
                                "\nNo hay ordenes pendientes."
                        );

                        break;
                    }

                    System.out.println(
                            "\n===== ORDENES PENDIENTES ====="
                    );

                    // Mostrar todas las ordenes
                    for (int i = 0;
                         i < cantidadPendientes;
                         i++) {

                        Orden orden =
                                ordenesPendientes[i];

                        System.out.println(
                                "\n=========================="
                        );

                        System.out.println(
                                "Orden #" +
                                orden.getNumero()
                        );

                        System.out.println(
                                "Cliente: " +
                                orden.getNombreCliente()
                        );

                        Pizza[] pizzasOrden =
                                orden.getPizzas();

                        for (int j = 0;
                             j < pizzasOrden.length;
                             j++) {

                            Pizza pizza =
                                    pizzasOrden[j];

                            System.out.println(
                                    "\nPizza " + (j + 1)
                            );

                            System.out.println(
                                    "Masa: " +
                                    pizza.getMasa()
                            );

                            System.out.println(
                                    "Salsa: " +
                                    pizza.getSalsa()
                            );

                            System.out.println(
                                    "Ingredientes:"
                            );

                            Ingrediente[] ingredientes =
                                    pizza.getIngredientes();

                            for (int k = 0;
                                 k < ingredientes.length;
                                 k++) {

                                if (ingredientes[k] != null) {

                                    System.out.println(
                                            "- " +
                                            ingredientes[k]
                                    );
                                }
                            }
                        }
                    }

                    System.out.println(
                            "\n=========================="
                    );

                    System.out.print(
                            "Ingrese el numero de la orden a entregar: "
                    );

                    int numeroEntregar =
                            scanner.nextInt();

                    scanner.nextLine();

                    int posicion = -1;

                    // Buscar orden
                    for (int i = 0;
                         i < cantidadPendientes;
                         i++) {

                        if (ordenesPendientes[i].getNumero()
                                == numeroEntregar) {

                            posicion = i;
                            break;
                        }
                    }

                    if (posicion == -1) {

                        System.out.println(
                                "No existe esa orden pendiente."
                        );

                    } else {

                        Orden ordenEntregada =
                                ordenesPendientes[posicion];

                        ordenEntregada.setPendiente(false);

                        ordenesEntregadas[cantidadEntregadas] =
                                ordenEntregada;

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

                        System.out.println(
                                "\nOrden #" +
                                numeroEntregar +
                                " marcada como entregada."
                        );
                    }

                    break;

                case 4:

                    System.out.println(
                            "\nPrograma terminado."
                    );

                    break;


                default:

                    System.out.println(
                            "\nOpcion no valida."
                    );

                    break;
            }

        } while (opcion != 4);

        scanner.close();
    }
}