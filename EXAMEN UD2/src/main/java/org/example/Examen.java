package org.example;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Examen {
    public static void ejercicio1(){

        Scanner entrada = new Scanner(System.in);
        Random random = new Random(); //Creación de la clase Random.

        String opc; //Creo las variables string que contendrán la opción del usuario, la inicial de la opción del bot y el nombre completo de la opción del bot -
        //(Piedra (p), Papel (a), Tijera (t).
        String bot_s = "";
        String bot_todo = "";

        int ronda = 1; //Variables que almacenan el número de la ronda actual y las puntuaciones del bot y del usuario.
        int punt_bot = 0;
        int punt_user = 0;
        int opc_n = 0; //Variable que almacena el equivalente en número de la opción escogida por el usuario.

        while (ronda <= 3) { //Bucle que se repite hasta que la varia ronda sea mayor que 3.

            int bot = random.nextInt(0, 3); //El bot elije al azar un número entre el 0 y el 3.

            if (bot == 0) { //Condicional que le da un valor string al número aleatorio del bot (0 = Piedra (p), 1 = Papel (a), 2 = Tijera (t)).
                bot_s = Integer.toString(bot);
                bot_s = "p";
                bot_todo = "Piedra";
            } else if (bot == 1) {
                bot_s = Integer.toString(bot);
                bot_s = "a";
                bot_todo = "Papel";
            } else if (bot == 2) {
                bot_s = Integer.toString(bot);
                bot_s = "t";
                bot_todo = "Tijera";
            }

//            System.out.println(bot_s); Esta línea comentada me avisa de la elección del bot.

            System.out.println("Ronda " + ronda); //Imprimo por pantalla el número de ronda actual y le pido al usuario que ingrese una opción (p, a o t).
            System.out.println("¿Piedra, papel o tijera? (p/a/t):");
            opc = entrada.nextLine();

             if (opc.equals("p")) { //Condicional que genera según la opción del usuario un número (0, 1 o 2) para poder verificar si la opción del usuario está permitida.
                 opc_n = 0;
             }else if (opc.equals("a")) {
                 opc_n = 1;
             }else if (opc.equals("t")) {
                 opc_n = 2;
             }

            if (opc_n != 0 || opc_n != 1 || opc_n != 2) { //Si la opción ingresada por el usuario es distinto a "p, a o t" no se avanza de ronda ya que se da por inválida.
                System.out.println("Dígito no válido. Se repite la ronda");

            }

            if (opc.equals("p") && bot_s.equals("p") || opc.equals("a") && bot_s.equals("a") || opc.equals("t") && bot_s.equals("t")) {
                //Si se empata la ronda, se imprime la opción del bot por pantalla y se declara la ronda como empate. No se avanza de ronda.
                System.out.println("El ordenador ha elegido " + bot_todo);
                System.out.println("EMPATE. Se repite la ronda");


            } else if (opc.equals("p") && bot_s.equals("a") || opc.equals("a") && bot_s.equals("t") || opc.equals("t") && bot_s.equals("p")) {
                //Si se pierde la ronda, se imprime la opción del bot por pantalla y se declara la ronda como derrota. Se avanza de ronda y se suma 1 a la puntuación del bot.
                System.out.println("El ordenador ha elegido " + bot_todo);
                System.out.println("DERROTA");
                ronda++;
                punt_bot++;

            } else if (opc.equals("a") && bot_s.equals("p") || opc.equals("t") && bot_s.equals("a") || opc.equals("p") && bot_s.equals("t")) {
                //Si se gana la ronda, se imprime la opción del bot por pantalla y se declara la ronda como derrota. Se avanza de ronda y se suma 1 a tu puntuación.
                System.out.println("El ordenador ha elegido " + bot_todo);
                System.out.println("VICTORIA");
                ronda++;
                punt_user++;

            }

            System.out.println("Marcador actual (bot-usuario): " + punt_bot + "-" + punt_user); //Imprime por pantalla el número de la ronda y la puntuación de las partes.
        }

        if (punt_bot > punt_user) { //Si la puntuación del bot es superior a la del user, gana el bot.
            System.out.println("La victora es para: ¡BOT!");
        } else { //Si la puntuación del user es superior a la del bot, gana el user.
            System.out.println("La victora es para: ¡Usuario!");
        }
    }

    public static void ejercicio2() {
        Scanner entrada = new Scanner(System.in);
        LocalDateTime hoy = LocalDateTime.now(); //Creamos la variable "hoy" que contiene los datos de la fecha actual.

        int año = 0; //Creamos una variable para almacenar el año introducido por el usuario.
        boolean valid = false; //Variable booleana necesaria para salir del try-catch.

        while (!valid) { //Bucle que contiene la lectura de la variable "año" y un try-catch que verifica el formato de introducción del año.
            try {
                System.out.println("Introduce tu año de nacimiento (año mínimo: 1900 / año máximo: " + hoy.getYear() + ")");
                año = entrada.nextInt();

                while (año < 1900 || año > hoy.getYear()) { //Bucle que comprueba que el año esté dentro del rango definido.
                    System.out.println("Número introducido fuera del rango. Vuelve a introducirlo (año mínimo: 1900 / año máximo: "  + hoy.getYear() + ")");
                    año = entrada.nextInt();
                }
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("ERROR. Formato no válido");
                entrada.next();
            }
        }
        int j = 0; //Variable creada para almacenar la edad de cada año en el siguiente bucle for.
        for (int i = año; i<=hoy.getYear(); i++) { //Bucle for que revisa el año introducido y va sumando 1 al año hasta llegar al año actual.
            System.out.println(i + "-edad: " + j);
            j++;
        }

    }
}


