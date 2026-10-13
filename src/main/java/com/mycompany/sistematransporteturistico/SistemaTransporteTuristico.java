package com.mycompany.sistematransporteturistico;

import java.util.ArrayList;
import java.util.Scanner; 

public class SistemaTransporteTuristico {

    public static String pedirPatente(Scanner scanner) {
    String patente;

    do {
        System.out.print("Patente: ");
        patente = scanner.nextLine();

        if (patente.isEmpty()) {
            System.out.println("Error: la patente no puede estar vacía.");
        }
    } while (patente.isEmpty());

    return patente;
}
    
    public static String pedirMarca(Scanner scanner) {
    String marca;

    do {
        System.out.print("Marca: ");
        marca = scanner.nextLine().trim();

        if (marca.isEmpty()) {
            System.out.println("Error: la marca no puede estar vacía.");
        }
    } while (marca.isEmpty());

    return marca;
}
    public static int pedirCapacidad(Scanner scanner) {
    int capacidad = 0;

    do {
        try {
            System.out.print("Capacidad de pasajeros: ");
            capacidad = Integer.parseInt(scanner.nextLine());

            if (capacidad <= 0) {
                System.out.println("Error: debe ser mayor a 0.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: ingrese un número entero.");
        }
    } while (capacidad <= 0);

    return capacidad;
}
    
    
    public static int pedirAnio(Scanner scanner) {
    int anio = 0;
    int anioActual =2026;

    do {
        try {
            System.out.print("Anio de fabricacion: ");
            anio = Integer.parseInt(scanner.nextLine());

            if (anio < 1990 || anio > anioActual) {
                System.out.println(
                    "Error: el anio debe estar entre 1990 y " + anioActual + "."
                );
            }

        } catch (NumberFormatException e) {
            System.out.println("Error: debe ingresar un anio numerico.");
        }

    } while (anio < 1990 || anio > anioActual);

    return anio;
}
    
    public static void main(String[] args) {
        
        
    ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            int opcion;
            
            do {
                System.out.println("\n MENU PRINCIPAL");
                System.out.println("1. Agregar vehiculo ");
                System.out.println("2. Mostrar todos los vehiculos ");
                System.out.println("3. Realizar servicios turisticos");
                System.out.println("4. Buscar vehiculo por patente ");
                System.out.println("5. Mostrar vehiculos con capacidad mayor a un valor ingresado  ");
                System.out.println("6. Mostrar vehiculos ordenados por anio de fabricacion descendente ");
                System.out.println("7. Mostrar vehiculos ordenados por capacidad de pasajeros descendente");
                System.out.println("8. Salir ");
                System.out.print("Selecciona una opcion: ");


                try {
                    opcion = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.print("Error: debe ingresar un numero.");
                    opcion = -1;
                }


                switch (opcion) {
                    case 1 -> {
                        System.out.println("\nSeleccione el tipo de vehiculo que quiere agregar:");
                        System.out.println("1. Colectivo turistico \n2. Van ejecutiva \n3. Lancha Turistica");
                        System.out.print("seleccione una opcion: ");
                        int tipoVehiculo = scanner.nextInt();
                         switch (tipoVehiculo) {
                            case 1 -> { System.out.println("\nHas seleccionado: Agregar Colectivo Turistico.");
                            scanner.nextLine();
                            String patente = pedirPatente(scanner);
                            String marca = pedirMarca(scanner);
                            int capacidadPasajeros = pedirCapacidad(scanner);
                            int anioFabricacion = pedirAnio(scanner);
                            
                        int cantidadPisos;
                            do {
                                System.out.print("Elija la cantidad de pisos (1 o 2): ");
                                cantidadPisos = scanner.nextInt();

                                if (cantidadPisos != 1 && cantidadPisos != 2) {
                                    System.out.println("Error: solo puede ingresar la cantidad 1 o 2.");
                                }

                            } while (cantidadPisos != 1 && cantidadPisos != 2);
                            scanner.nextLine();

                                ColectivoTuristico colectivo = new ColectivoTuristico(
                                        patente,
                                        marca,
                                        capacidadPasajeros,
                                        anioFabricacion,
                                        cantidadPisos);
                                
                                vehiculos.add(colectivo);
                                System.out.println("Vehiculo añadido exitosamente!");
                                    
                            }
                            case 2 -> { System.out.println("\nHas seleccionado: Agregar Van Ejecutiva.");
                            scanner.nextLine();
                            String patente = pedirPatente(scanner);
                            String marca = pedirMarca(scanner);
                            int capacidadPasajeros = pedirCapacidad(scanner);
                            int anioFabricacion = pedirAnio(scanner);
                            

                                do {
                                    System.out.println("¿La van tiene aire acondicionado?");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    System.out.print("Seleccione una opcion: ");

                                    opcion = Integer.parseInt(scanner.nextLine());
                                    if (opcion != 1 && opcion != 2) {
                                        System.out.println("Opción inválida. Ingrese 1 o 2.");
                                    }

                                } while (opcion != 1 && opcion != 2);

                                boolean aireAcondicionado = (opcion == 1);

                                VanEjecutiva van = new VanEjecutiva(
                                        patente,
                                        marca,
                                        capacidadPasajeros,
                                        anioFabricacion,
                                        aireAcondicionado
                                    );
                                
                                vehiculos.add(van);
                                System.out.println("Vehiculo añadido exitosamente!");
                            
                            }
                            case 3 -> { System.out.println("\nHas seleccionado: Agregar Lancha Turistica.");
                            scanner.nextLine();
                            String patente = pedirPatente(scanner);
                            String marca = pedirMarca(scanner);
                            int capacidadPasajeros = pedirCapacidad(scanner);
                            int anioFabricacion = pedirAnio(scanner);
                            
                            int opcionMotor;

                            do {
                                System.out.println("\n¿Que tipo de motor tiene la lancha? \n 1. Nafta \n 2. Diesel \n 3. Eléctrico  ");
                                System.out.print("Seleccione una opcion: ");

                                try {
                                    opcionMotor = Integer.parseInt(scanner.nextLine());

                                    if (opcionMotor < 1 || opcionMotor > 3) {
                                        System.out.println("Opcion invalida. Ingrese 1, 2 o 3.");
                                    }

                                } catch (NumberFormatException e) {
                                    opcionMotor = 0;
                                    System.out.println("Error: ingrese un numero.");
                                }

                            } while (opcionMotor < 1 || opcionMotor > 3);

                            LanchaTuristica.TipoMotor motor;

                            switch (opcionMotor) {
                                case 1 -> motor = LanchaTuristica.TipoMotor.NAFTA;
                                case 2 -> motor = LanchaTuristica.TipoMotor.DIESEL;
                                default -> motor = LanchaTuristica.TipoMotor.ELECTRICO;
                            }

                            LanchaTuristica lancha = new LanchaTuristica(
                                patente,
                                marca,
                                capacidadPasajeros,
                                anioFabricacion,
                                motor
                            );

                            vehiculos.add(lancha);

                            System.out.println("¡Lancha turistica aniadida exitosamente!");
                        }

                         
                            default -> System.out.println("\nTipo de vehiculo no valido. Vuelva a intentarlo ");
                            }}
                                                  
                    case 2 -> {
                         System.out.println("\nLISTA DE VEHICULOS");

                        if (vehiculos.isEmpty()) {
                            System.out.println("No hay vehiculos registrados.");
                        } else {
                            for (Vehiculo vehiculo : vehiculos) {
                                System.out.println("\n-------------------------");
                                vehiculo.mostrarDatos();

                                if (vehiculo instanceof VanEjecutiva van) {
                                    System.out.println("Aire acondicionado: "
                                            + (van.isAireAcondicionado() ? "Si" : "No"));

                                } else if (vehiculo instanceof LanchaTuristica lancha) {
                                    System.out.println("Tipo de motor: "
                                            + lancha.getTipoMotor());

                                } else if (vehiculo instanceof ColectivoTuristico colectivo) {
                                    System.out.println("Cantidad de pisos: "
                                            + colectivo.getCantidadPisos());
                                }
                            }   
                        }
                    }
                    case 3 -> { 
                            System.out.println("\nREALIZAR SERVICIO TURISTICO");

                        
                           System.out.println("""
                                              Seleccione el tipo de transporte en el que desea viajar:
                                              1. Colectivo turistico
                                              2. Van ejecutiva
                                              3. Lancha turistica
                                              Ingrese una opcion: """);

                            int tipoTransporte;

                            try {
                                tipoTransporte = Integer.parseInt(scanner.nextLine());
                            } catch (NumberFormatException e) {
                                tipoTransporte = 0;
                            }

                            if (tipoTransporte < 1 || tipoTransporte > 3) {
                                System.out.println("Opcion no valida.");
                                break;
                            }

                            Vehiculo vehiculoEncontrado = null;

                            for (Vehiculo vehiculo : vehiculos) {
                                if ((tipoTransporte == 1 && vehiculo instanceof ColectivoTuristico)
                                        || (tipoTransporte == 2 && vehiculo instanceof VanEjecutiva)
                                        || (tipoTransporte == 3 && vehiculo instanceof LanchaTuristica)) {

                                    vehiculoEncontrado = vehiculo;
                                    break;
                                }
                            }

                            if (vehiculoEncontrado == null) {
                                System.out.println("No hay vehiculos registrados de ese tipo.");
                                break;
                            }

                            String destino;

                            do {
                                System.out.print("Ingrese el destino turistico: ");
                                destino = scanner.nextLine().trim();

                                if (destino.isEmpty()) {
                                    System.out.println("El destino no puede estar vacio.");
                                }
                            } while (destino.isEmpty());

                            int pasajeros;

                            do {
                                pasajeros = pedirCapacidad(scanner);

                                if (pasajeros > vehiculoEncontrado.getCapacidadPasajeros()) {
                                    System.out.println("El vehiculo admite como maximo "
                                            + vehiculoEncontrado.getCapacidadPasajeros()
                                            + " pasajeros. Ingrese otra cantidad.");
                                }
                            } while (pasajeros > vehiculoEncontrado.getCapacidadPasajeros());

                            System.out.println(
                                """
                                
                                SERVICIO TURISTICO REGISTRADO
                                Tipo de vehiculo: """ + vehiculoEncontrado.getTipo() +
                                "\nPatente: " + vehiculoEncontrado.getPatente() +
                                "\nMarca: " + vehiculoEncontrado.getMarca() +
                                "\nDestino turistico: " + destino +
                                "\nCantidad de pasajeros: " + pasajeros +
                                "\nCapacidad maxima: " + vehiculoEncontrado.getCapacidadPasajeros() +
                                "\nEstado: Servicio confirmado."
                            );
                        }

                    
                    case 4 -> { 
                        System.out.println("\n buscar vehiculo por patente");
                         String patenteBuscada = pedirPatente(scanner);

                        boolean encontrado = false;

                        for (Vehiculo vehiculo : vehiculos) {
                            if (vehiculo.getPatente().equalsIgnoreCase(patenteBuscada)) {

                                System.out.println("\nVehiculo encontrado:");
                                vehiculo.mostrarDatos();

                                if (vehiculo instanceof VanEjecutiva van) {
                                    System.out.println("Aire acondicionado: "
                                            + (van.isAireAcondicionado() ? "Si" : "No"));

                                } else if (vehiculo instanceof LanchaTuristica lancha) {
                                    System.out.println("Tipo de motor: "
                                            + lancha.getTipoMotor());

                                } else if (vehiculo instanceof ColectivoTuristico colectivo) {
                                    System.out.println("Cantidad de pisos: "
                                            + colectivo.getCantidadPisos());
                                }

                                encontrado = true;
                                break;
                            }
                        }
                        if (!encontrado) {
                            System.out.println("No se encontro ningun vehiculo con la patente "
                                + patenteBuscada + ".");
    }
}
                   
                    case 5 -> { 
                        System.out.println("\n Mostrar vehiculos con capacidad mayor a un valor ingresado ");
                        

                            int capacidadMinima = pedirCapacidad(scanner);

                            boolean encontrado = false;

                            for (Vehiculo vehiculo : vehiculos) {
                                if (vehiculo.getCapacidadPasajeros() > capacidadMinima) {

                                    vehiculo.mostrarDatos();

                                    if (vehiculo instanceof VanEjecutiva van) {
                                        System.out.println("Aire acondicionado: " + (van.isAireAcondicionado() ? "Si" : "No"));

                                    } else if (vehiculo instanceof LanchaTuristica lancha) {
                                        System.out.println("Tipo de motor: "
                                                + lancha.getTipoMotor());

                                    } else if (vehiculo instanceof ColectivoTuristico colectivo) {
                                        System.out.println("Cantidad de pisos: "
                                                + colectivo.getCantidadPisos());
                                    }

                                    encontrado = true;
                                }
                            }

                            if (!encontrado) {
                                System.out.println("No hay vehiculos con capacidad mayor a " + capacidadMinima + " pasajeros.");
                                }
                            }

               
                    case 6 -> { 
                        System.out.println("\n  Mostrando vehiculos ordenados por anio de fabricacion descendente");
                            if (vehiculos.isEmpty()) {
                                System.out.println("NO HAY VEHICULOS REGISTRADOS.");
                            } else {
                                ArrayList<Vehiculo> vehiculosOrdenados =
                                        new ArrayList<>(vehiculos);

                                vehiculosOrdenados.sort(
                                        (v1, v2) -> Integer.compare(
                                                v2.getAnioFabricacion(),
                                                v1.getAnioFabricacion()
                                        )
                                );

                                for (Vehiculo vehiculo : vehiculosOrdenados) {
                                    System.out.println("\n-------------------------");
                                    vehiculo.mostrarDatos();
                                }
                            }
                        }
                    
                    case 7 -> { 
                        System.out.println("\n Mostrando vehiculos ordenados por capacidad de pasajeros descendente ");

                            if (vehiculos.isEmpty()) {
                                System.out.println("NO HAY VEHICULOS REGISTRADOS.");
                            } else {
                                ArrayList<Vehiculo> vehiculosOrdenados =
                                        new ArrayList<>(vehiculos);

                                vehiculosOrdenados.sort(
                                        (v1, v2) -> Integer.compare(
                                                v2.getCapacidadPasajeros(),
                                                v1.getCapacidadPasajeros()
                                        )
                                );

                                for (Vehiculo vehiculo : vehiculosOrdenados) {
                                    System.out.println("\n-------------------------");
                                    vehiculo.mostrarDatos();
                                }
                            }
                        }

                    case 8 -> {
                        System.out.println("\nSaliendo del programa... PROGRAMA FINALIZADO");
                        break;
                    }

                    default -> {
                        System.out.println("\nOpcion no valida. Intente de nuevo.");
                    }
                }
                
            } while (opcion != 8); 
        }
    } 
} 