package com.hernandez;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        ArrayList<Cuenta> cuentas = new ArrayList();
        Scanner lector = new Scanner(System.in);
        System.out.println("*****************");
        System.out.println("\tBienvenido");
        System.out.println("*****************");

        while (true) {
            System.out.println("1. Crear una cuenta");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Mostrar información de una cuenta");
            System.out.println("5. Mostrar Cuentas");
            System.out.println("6. Salir");
            int opcion = LectorDeDatos.solicitarEntero("Ingrese una opcion");
            switch (opcion) {

                case 1:
                    System.out.println("Creando una cuenta**");
                    Random rand = new Random();
                    int numeroCuenta = rand.nextInt(1000);
                    System.out.println("Su numero de cuenta es :" + numeroCuenta);
                    System.out.println("\t 1 Cuenta de ahorro");
                    System.out.println("\t 2 Cuenta a largo plazo");
                    int tipoCuenta = LectorDeDatos.solicitarEntero("Especifique el tipo de cuenta que desea crear");
                    double saldo = LectorDeDatos.solicitarFlotante("Ingrese saldo inicial: ");

                    if (tipoCuenta == 1) {
                        CuentaAhorro nuevaCuenta = new CuentaAhorro();
                        nuevaCuenta.numCuenta = numeroCuenta;
                        nuevaCuenta.saldo = saldo;
                        cuentas.add(nuevaCuenta);
                    } else if (tipoCuenta == 2) {
                        CuentaLargoPlazo nuevaCuenta = new CuentaLargoPlazo();
                        nuevaCuenta.saldo = saldo;
                        cuentas.add(nuevaCuenta);
                    } else {
                        System.out.println("Tipo de cuenta no existe");
                    }
                    System.out.println("La cuenta ha sido creada!");

                    break;

                case 2:
                    if (cuentas.isEmpty()) {
                        System.out.println("***** No hay cuentas creadas ******");
                    } else {
                        System.out.println("**** Deposito ****");
                    }
                    while (true) {
                        int numCuentaDep = LectorDeDatos.solicitarEntero("Ingrese el numero de cuenta: ");
                        int i = 0;
                        for (Cuenta c : cuentas) {
                            if (numCuentaDep == c.numCuenta) {
                                double monto = LectorDeDatos.solicitarFlotante("Ingrese la cantidad que desea depositar: ");
                                if (c.depositar(monto) == false) {
                                    System.out.println("Ha excedido el saldo maximo de la cuenta");
                                    i = 2;
                                } else {
                                    System.out.println("El deposito se realizo con exito!");
                                    i = 1;
                                }
                            }
                        }
                        if (i == 0) {
                            System.out.println("El numero de cuenta no existe");
                        } else if (i == 1) {
                            break;
                        }
                    }
                    break;

                case 3:
                    if (cuentas.isEmpty()) {
                        System.out.println("****No hay cuentas creadas*****");
                    } else {
                        System.out.println("****** Retiro ******");
                    }
                    while (true) {
                        int numCuentaRet = LectorDeDatos.solicitarEntero("Ingrese el numero de cuenta: ");
                        int i = 0;
                        for (Cuenta c : cuentas) {
                            if (numCuentaRet == c.numCuenta) {
                                double monto = LectorDeDatos.solicitarFlotante("Ingrese la cantidad a retirar: ");
                                if (c.retirar(monto) == false) {
                                    System.out.println("La capacidad sobrepasa el limíte");
                                    i = 2;
                                } else {
                                    System.out.println("El retiro se realizo con exito!");
                                    i = 1;
                                }
                            }
                        }
                        if (i == 0) {
                            System.out.println("El numero de cuenta no existe");
                        } else if (i == 1) {
                            break;
                        }
                    }
                    break;

                case 4:
                    if (cuentas.isEmpty()) {
                        System.out.println("***No hay cuentas creadas****");
                    } else {
                        System.out.println("** Informacion **");
                    }
                    while (true) {
                        int nCuenta = LectorDeDatos.solicitarEntero("Ingrese el numero de cuenta: ");
                        int i = 0;
                        for (Cuenta c : cuentas) {
                            String tipo = "";
                            if (nCuenta == c.numCuenta) {
                                i = 1;
                                if (c instanceof CuentaAhorro)
                                    tipo = "Cuenta de Ahorro";
                                else if (c instanceof CuentaLargoPlazo)
                                    tipo = "Cuenta a Largo Plazo";

                                System.out.println("N#: " + c.numCuenta);
                                System.out.println("Saldo: " + c.saldo);
                                System.out.println("Tipo de cuenta: " + tipo);
                            }
                        }
                        if (i == 0)
                            System.out.println("El numero de cuenta no existe");

                        if (nCuenta == -1) {
                            break;
                        }
                    }
                    break;

                case 5:
                    //Numero de cuenta- Tipo de cuenta
                    System.out.println("** Mostrando Cuentas **");
                    if (cuentas.isEmpty()) {
                        System.out.println("***No hay cuentas***");

                    } else {
                        System.out.println("****Mostrando cuentas***");
                    }
                    for (Cuenta c : cuentas) {
                        String tipo = "";
                        if (c instanceof CuentaAhorro)
                            tipo = "Cuenta de Ahorro";
                        else if (c instanceof CuentaAhorro)
                            tipo = "Cuenta a Largo Plazo";

                        System.out.println(c.numCuenta + " - " + tipo);
                    }
                    System.out.println();
                    break;

                case 6:
                    System.out.println("Gracias!!!");
                    break;
                default:
                    System.out.println("Opcion valida");
            }

            if (opcion == 6) {
                break;
            }
        }
    }



}
