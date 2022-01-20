
import java.util.Scanner;


public class Main {

    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        String nombre = "";
        int fuerza = 0, danoAtaque = 0, opcion;
        
        //ingresamos los datos del gladiador 1
        System.out.println("**Primer gladiador**");
        System.out.print("Ingrese el nombre del gladiador: ");
        nombre = s.nextLine();
        do{
            System.out.println("Ingrese la fuerza de " + nombre + "(1-5):");
            fuerza = Integer.parseInt(s.nextLine());
        }while(fuerza < 1 || fuerza > 5);
        //se crea el objeto de la clase Gladiador
        Gladiador g1 = new Gladiador();
        g1.setNombre(nombre);
        g1.setFuerza(fuerza);
        
        
        //ingresamos los datos del gladiador 2
        System.out.println("**Segundo gladiador**");
        System.out.print("Ingrese el nombre del gladiador: ");
        nombre = s.nextLine();
        do{
            System.out.println("Ingrese la fuerza de " + nombre + "(1-5):");
            fuerza = Integer.parseInt(s.nextLine());
            //guardamos el nro de fuerza, mientras fuerza sea menor a 1 y mayor a 5,
            //se seguirá pidiendo el dato.
            //MIENTAS FUERZA ESTÉ FUERA DE RANGO, SEGUIMOS PIDIENDO LOS DATOS HASTA QUE SEAN LOS CORRECTOS
        }while(fuerza < 1 || fuerza > 5);
        //se crea el objeto de la clase Gladiador
        Gladiador g2 = new Gladiador();
        g2.setNombre(nombre);
        g2.setFuerza(fuerza);
        
        
        //menu de combates
        System.out.println("**Menú de combates**");
        do{
            System.out.println("***Ingrese el numero del gladiador que atacará (1." + g1.getNombre() + " / 2." + g2.getNombre() + ")");
            opcion = Integer.parseInt(s.nextLine());
            switch(opcion){
                case 1:
                    //aqui enviamos el ataque
                    danoAtaque = g1.atacar();
                    System.out.println(g1.getNombre() + " atacó a " + g2.getNombre() + " y el daño fue de " + danoAtaque + "!!!");
                    //aqui el oponente recibe el ataque enviado
                    g2.recibirDano(danoAtaque);
                    //si el gladiador tiene como estado "Derrotado" el juego termina.
                    if(g2.getEstado().equals("Derrotado")){
                        System.out.println(g2.getNombre() + " ha sido derrotado!");
                    }
                    break;
                case 2:
                    danoAtaque = g2.atacar();
                    System.out.println(g2.getNombre() + " atacó a " + g1.getNombre() + " y el daño fue de " + danoAtaque + "!!!");
                    g1.recibirDano(danoAtaque);
                    if(g1.getEstado().equals("Derrotado")){
                        System.out.println(g1.getNombre() + " ha sido derrotado!");
                    }
                    break;    
            }
            System.out.println("La energia de " + g1.getNombre() + " es " + g1.getEnergia());
            System.out.println("La energia de " + g2.getNombre() + " es " + g2.getEnergia());
        }while(g1.getEstado().equals("En guardia")&& g2.getEstado().equals("En guardia"));
        System.out.println("---Fin del combate---");
        //si un gladiador es derrotado se termina el combate, entonces para realizar esta condicion
        //usando do while, vamos a igualar el estado del gladiador, si el estado es "en guardia", el juego
        //sigue. Esto aplica para ambos gladiadores.
    }
    
}
