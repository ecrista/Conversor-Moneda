package com.aluralatam.cursos.cambiomoneda.principal;

import com.aluralatam.cursos.cambiomoneda.modelos.ConsultaApi;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado =new Scanner(System.in);
        ConsultaApi consultarApi=new ConsultaApi();
        String[][] conversionesMenu={{"USD","ARS"},{"ARS","USD"},{"USD","MXN"},{"MXN","USD"},{"EUR","MXN"},{"MXN","EUR"},{"USD","COP"},{"COP","USD"},{"BRL","USD"},{"USD","BRL"},{"USD","INR"},{"INR","USD"},{"MXN","INR"},{"INR","MXN"}};
        System.out.println(conversionesMenu[0][1]);


        while (true) {

            var menuDivisasConvertir = 0;
            try {
                System.out.println("""
                        *********************************************************************************************
                        Sea Bienvenido al conversor de monedas elija alguna de las opciones de conversion a realizar:
                        *********************************************************************************************
                        1.- Dolar -> Peso Argentino          8.- Peso Colombiano -> Dolar 
                        2.- Peso Argentino -> Dolar          9.- Real Brasileño -> Dolar
                        3.- Dolar -> Peso Méxicano          10.- Dolar -> Real Brasileño
                        4.- Peso Méxicano -> Dolar          11.- Dolar -> Rupia India
                        5.- Euro -> Peso Méxicano           12.- Rupia India -> Dolar
                        6.- Peso Méxicano -> Euro           13.- Peso Mexicano -> Rupia India
                        7.- Dolar -> Peso Colombiano        14.- Rupia India -> Peso Mexicano
                        0.-Salir    15.- Ver historial de Consultas
                        *********************************************************************************************
                        """);
                menuDivisasConvertir = teclado.nextInt();
                if (menuDivisasConvertir == 0) {
                    break;
                }else if (menuDivisasConvertir==15){
                    consultarApi.verHistorial();
                }
                else {
                    System.out.println("Ingrese el valor que desea convertir:");
                    var montoDivisasConvertir = teclado.nextDouble();
                    var origen = conversionesMenu[menuDivisasConvertir - 1][0];
                    var destino = conversionesMenu[menuDivisasConvertir - 1][1];
                    var divisaConvertida = consultarApi.convertirDivisa(montoDivisasConvertir, origen, destino);
                    System.out.println("El valor " + montoDivisasConvertir + "[" + origen + "] corresponde al valor final de =>> " + divisaConvertida + "[" + destino + "]");
                }


            } catch (NumberFormatException |InputMismatchException e) {
                System.out.println("Error al recibir un valor no numerico: " + e.getMessage());
                break;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
        System.out.println("Finalizando Aplicacion");
    }
}
