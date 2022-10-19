import java.io.File;
import java.util.*;

/**
 * Clase correspondiente al algoritmo de Ordenamiento RadixSort.
 *
 * Ordena enteros procesando sus digitos de forma individual. Como los enteros pueden representar
 * cadenas de caracteres y, especialmente,
 * numeros en punto flotante especialmente formateados,
 * radix sort no esta limitado solo a los enteros. (En esta implementacion se trabaja solo con enteros).
 *
 * @author Luis Aldo Gomez Bolanios, Karen Mariel Bastida Vargas y Jorge Salgado Miranda
 * @version 1.0
 */

public class Radix {
    static int cont;
    /**
     * Clase que implementa el Algoritmo de Ordenamiento por Radix
     *
     * @param archivo //Este parametro se pasa la direccion del archivo con la lista de numeros desordenados
     */

    public static void radix(File archivo){
        int i, j; // Variables para los ciclos for.
        short opc;
        List< Queue <Integer>> listaDeQueue = new LinkedList<>();
        // Creamos una Cola de Enteros Para aplicar el metodo Radix. y Creamos una lista de esas colas.
        // ListaDeQueue es una lista de colas que almanenan enteros.
        List<Integer> lista = new ArrayList<>(); // Creamos una lista como un arreglo.

        opc = ordenar(); // Guardamos la opcion obtenida por el usuario (Ordenamiento Ascendente o Descendente).


        for(int k = 0; k < 10; k++){
            Queue<Integer> colaPos = new LinkedList<>(); //Creamos 10 colas de enteros del Objeto listas ligadas para poder ejecutar el algoritmo radix.
            listaDeQueue.add(colaPos);// Agregamos las colas de enteros a la lista de Colas de Enteros (ListaDeQueue).
        }

        LeerArchivo ls = new LeerArchivo(); // Creamos un nuevo Objeto de la clase leer archivo.
        String temp1 = archivo.getAbsolutePath(); // Obtenemos el path absoluto del archivo del usuario.
        System.out.println(ls.leerArchivoTxt(temp1)); // Imprimimos el archivo obtenido del path absoluto del usuario con ayuda del metodo leerTXT.
        String aux = ls.leerArchivoTxt(temp1); // Le asignamos el valor del archivo a una variable auxiliar.
        String [] text = aux.split(","); // Este metodo nos ayuda a dividir la cadena de la variable aux en este caso con base a una clave determinada.
        // Como nuestro texto esta separado por comas se asigno esto de clave de separacion del texto.

        for (String s : text) { // Recorremos lo asignado en la variable texto, clave por clave.
            lista.add(Integer.parseInt(s)); // parseInt convierte el string de cadena como un numero entero con signo.
        }

        int temp, unidades, decenas, centenas;
        // Variables para hacer el acomodo en las listas con base en las unidades, decenas y centenas.

        for(i = 0; i < 3; i++){ // Maximo tres iteraciones por que seran los digitos que estan en el archivo .txt
            for(j = 0; j <= lista.size() - 1; j++){ // Recorre cada elemento de la lista para asignarlo en su respectivo Queue.
                if(i == 0){ //En el primer valor de i lo recorremos por unidades
                    temp = lista.get(j);
                    unidades = temp % 10; //Usamos el modulo para saber sus unidades.

                    if(unidades == 0){
                        listaDeQueue.get(0).add(lista.get(j));
                    }else if(unidades == 1){
                        listaDeQueue.get(1).add(lista.get(j));
                    }else if(unidades == 2){
                        listaDeQueue.get(2).add(lista.get(j));
                    }else if(unidades == 3){
                        listaDeQueue.get(3).add(lista.get(j)); // Estas intrucciones se compara si la unidad es un digito dentro de 0-9
                    }else if(unidades == 4){             // por lo que el respectivo numero se ingresa en en la lista de colas. Y
                        listaDeQueue.get(4).add(lista.get(j)); // se realiza hasta que termine el primer ciclo for.
                    }else if(unidades == 5){
                        listaDeQueue.get(5).add(lista.get(j));
                    }else if(unidades == 6){
                        listaDeQueue.get(6).add(lista.get(j));
                    }else if(unidades == 7){
                        listaDeQueue.get(7).add(lista.get(j));
                    }else if(unidades == 8){
                        listaDeQueue.get(8).add(lista.get(j));
                    }else{
                        listaDeQueue.get(9).add(lista.get(j));
                    }
                }else if( i == 1){ //Decenas
                    temp = lista.get(j);
                    temp /= 10;
                    decenas = temp % 10;

                    if(decenas == 0){
                        listaDeQueue.get(0).add(lista.get(j));
                    }else if(decenas == 1){
                        listaDeQueue.get(1).add(lista.get(j));
                    }else if(decenas == 2){
                        listaDeQueue.get(2).add(lista.get(j));
                    }else if(decenas == 3){
                        listaDeQueue.get(3).add(lista.get(j));
                    }else if(decenas == 4){
                        listaDeQueue.get(4).add(lista.get(j));
                    }else if(decenas == 5){
                        listaDeQueue.get(5).add(lista.get(j));
                    }else if(decenas == 6){
                        listaDeQueue.get(6).add(lista.get(j));
                    }else if(decenas == 7){
                        listaDeQueue.get(7).add(lista.get(j));
                    }else if(decenas == 8){
                        listaDeQueue.get(8).add(lista.get(j));
                    }else{
                        listaDeQueue.get(9).add(lista.get(j));
                    }
                }else if(i == 2){ //Centenas
                    temp = lista.get(j);
                    temp /= 10;
                    temp /= 10;
                    centenas = temp % 10;

                    if(centenas == 0){
                        listaDeQueue.get(0).add(lista.get(j));
                    }else if(centenas == 1){
                        listaDeQueue.get(1).add(lista.get(j));
                    }else if(centenas == 2){
                        listaDeQueue.get(2).add(lista.get(j));
                    }else if(centenas == 3){
                        listaDeQueue.get(3).add(lista.get(j));
                    }else if(centenas == 4){
                        listaDeQueue.get(4).add(lista.get(j));
                    }else if(centenas == 5){
                        listaDeQueue.get(5).add(lista.get(j));
                    }else if(centenas == 6){
                        listaDeQueue.get(6).add(lista.get(j));
                    }else if(centenas == 7){
                        listaDeQueue.get(7).add(lista.get(j));
                    }else if(centenas == 8){
                        listaDeQueue.get(8).add(lista.get(j));
                    }else{
                        listaDeQueue.get(9).add(lista.get(j));
                    }
                }
                Imprimir(listaDeQueue);
            }
            lisOrdenar(lista, listaDeQueue);
        }

        // En caso de que el usuario haya decidido ordenarlo de forma descendente, una vez obtenido la lista ordenada.
        if(opc == 2){ // se vuelve arreglo para "invertir" los valores.
            Object[] array = new Object[lista.size()];
            for(int a = 0; a < lista.size(); a++){
                array = lista.toArray(); // Se convierte en arreglo.
            }
            lista.clear();
            for(int b = array.length - 1; b >= 0 ; b--){
                lista.add((Integer) array[b]);  // Se pasan los valores desde la ultima posicion.
            }
        }
        System.out.println("Imprimiendo la lista ordenada: " + lista);
    }

    /**
     * Metodo que extrae el valor de la Cola y lo agrega a la lista original,
     * para obtener los datos y ver si estan ordenados
     *
     * @param lis Lista de Enteros
     * @param lis1 Lista de Colas de Enteros
     */

    public static void lisOrdenar(List<Integer> lis, List<Queue<Integer>> lis1){
        lis.clear(); // Se limpia la lista que tiene los elementos desordenados.
        for(Queue<Integer> princi:lis1){ //For each que recorre las colas
            Object[] arreglo = princi.toArray(); // Se convierte la cola en una arreglo objeto.
            for (Object o : arreglo) { //Con un for each se agrega los elementos del arreglo a la lista.
                lis.add((Integer) o); //Se castea el arreglo de objetos a Integer.
            }
            princi.clear(); // Se limpia la Queue.
        }
    }

    /**
     * Metodo que sirve para imprimir la Lista
     *
     * @param lis Lista de Colas de Enteros
     */

    public static void Imprimir(List<Queue<Integer>> lis){//Metodo que sirve para imprimir la lista
        System.out.println("Iteracion " + cont + ":" + lis);
        cont++;
    }

    /**
     * Metodo que consiste en saber que tipo de Ordenamiento desea implementar el usuario.
     * @return Tipo de Ordenamiento Ascendente o Descendente.
     */
    public static short ordenar(){
            Scanner sc = new Scanner(System.in);//Creamos un nuevo objeto de tipo Scanner
            short opc;
            System.out.println("Como desea ordenar su archivo? \n1.Ascendente\n2.Descendente");
            opc = sc.nextShort();
            return opc;//Con base en lo ingresado por el usuario seleccionamos si se hace de manera ascendente o Descendente
    }
}
