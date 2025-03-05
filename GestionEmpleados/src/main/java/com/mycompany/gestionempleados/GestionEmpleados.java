/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gestionempleados;

/**
 *
 * @author DELL
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Clase pública que contiene el método main
public class GestionEmpleados {

    // Clase Empleado
    static class Empleado {
        private String nombre;
        private int edad;
        private double salario;

        // Constructor
        public Empleado(String nombre, int edad, double salario) {
            this.nombre = nombre;
            this.edad = edad;
            this.salario = salario;
        }

        // Métodos para obtener los atributos
        public String getNombre() {
            return nombre;
        }

        public int getEdad() {
            return edad;
        }

        public double getSalario() {
            return salario;
        }

        // Métodos para establecer los atributos
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setEdad(int edad) {
            if (edad > 0) {
                this.edad = edad;
            } else {
                System.out.println("Edad no válida.");
            }
        }

        public void setSalario(double salario) {
            if (salario >= 0) {
                this.salario = salario;
            } else {
                System.out.println("Salario no válido.");
            }
        }

        // Método para imprimir la información del empleado
        public void imprimirInfo() {
            System.out.println("Nombre: " + nombre);
            System.out.println("Edad: " + edad);
            System.out.println("Salario: " + salario);
        }
    }

    // Clase GestorEmpleados
    static class GestorEmpleados {
        private List<Empleado> empleados;

        // Constructor
        public GestorEmpleados() {
            empleados = new ArrayList<>();
        }

        // Método para agregar un empleado a la lista
        public void agregarEmpleado(Empleado empleado) {
            empleados.add(empleado);
        }

        // Método para mostrar todos los empleados
        public void mostrarEmpleados() {
            if (empleados.isEmpty()) {
                System.out.println("No hay empleados registrados.");
            } else {
                System.out.println("\nDetalles de los empleados:");
                for (Empleado empleado : empleados) {
                    empleado.imprimirInfo();
                    System.out.println("---------------");
                }
            }
        }
    }

    // Método main que es la entrada del programa
    public static void main(String[] args) {
        GestorEmpleados gestor = new GestorEmpleados();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\nSistema de Gestión de Empleados");
            System.out.println("1. Agregar empleado");
            System.out.println("2. Mostrar empleados");
            System.out.println("3. Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    // Agregar empleado
                    System.out.print("Ingrese el nombre del empleado: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese la edad del empleado: ");
                    int edad = scanner.nextInt();
                    System.out.print("Ingrese el salario del empleado: ");
                    double salario = scanner.nextDouble();

                    Empleado empleado = new Empleado(nombre, edad, salario);
                    gestor.agregarEmpleado(empleado);
                    System.out.println("Empleado agregado exitosamente.");
                    break;

                case 2:
                    // Mostrar empleados
                    gestor.mostrarEmpleados();
                    break;

                case 3:
                    // Salir
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }

        } while (opcion != 3);

        scanner.close();
    }
}
