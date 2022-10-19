import java.io.*;
import java.util.ArrayList;

/**
 * Clase correspondiente a escribir en los archivos
 * Dicha clase corresponde a poder ingresar dentro de los archivos correspondientes los numeros ordenados
 * para ello se crea un objeto de tipo FileWriter.
 * Mas abajo se encuentran los metodos para concatenar los bloques de los numeros, primero en String y
 * despues a clase Integer
 *
 * @author Luis Aldo Gomez Bolanios, Karen Mariel Bastida Vargas y Jorge Salgado Miranda
 * @version 1.0
 */

public class EscrituraArchivo {
    //Este metodo nos ayuda a escribir dentro de los archivos txt
    public static void escribirDatos(ArrayList<ArrayList<Integer>> listArrayList, String ubicacionArchivo) {
        try {
            //Se entra dentro de un try, se crea un objeto de la clase PrintWriter que es para escribir dentro de archivos txt.
            PrintWriter pw = new PrintWriter(new FileOutputStream(ubicacionArchivo, true));
            pw.append("\n\nIteracion: {"); //append es un atributo que nos ayuda agregar textos.
            for (ArrayList<Integer> integers : listArrayList) { //Con ayuda de un for-each se recorrio la lista de listas de forma que
                pw.append("").append(String.valueOf(integers)); // en la variable pw se agrega cada numero de la lista.
            }
            pw.append("}");
            pw.append("\n");
            pw.close(); //Se cierra el archivo para que no se pierdan los datos ingresados.

        } catch (Exception e) {
            e.printStackTrace(); //En caso de que  no se encuentre el archivo correspondiente mandara una excepcion.
        }
    }


    /** Este metodo sirve para concatenar en forma de String bloques que tienen pareja
     *  estos se llaman desde el metodo polifase.
     *
     * @param list1 Contiene el primer de bloque de numeros a concatenar.
     * @param list2 Contiene el segundo de bloque de numeros a concatenar.
     */
    public static ArrayList<Integer> deIntegeraString(ArrayList<Integer> list1, ArrayList<Integer> list2){
        String concat; // Variable String para concatenar los numeros.

        // Se crea un array de enteros para guardar la concatenacion de la primera lista con la segunda.
        ArrayList<Integer> arrayConcat = new ArrayList<>();
        concat = list1.toString() + list2.toString(); // Se convierten las listas a string usando .toString.

        String aux3 = quitarCaracteres(concat); // Se recibe un String que tendra los numeros "limpios".
        String[] text = aux3.split(",");  // Se usa split para poder quitar las comas.

        for (String s : text) {  //Con ayuda de un ciclo for-each se recorre el arreglo y se asignar a una variable String
            arrayConcat.add(Integer.valueOf(s)); // Se convierte a tipo Integer usando una clase envolvente y se asigna a
        }                                       // nuestro arrayList declarado anteriormente.
        return arrayConcat; //Se regresa el arreglo con los numeros concatenados.
    }


    /** Este metodo sirve para unicamente recibir una lista y convertirla a
     * un String y en seguida asignarse a un ArrayList, ese metodo se usa cuando
     * se tiene la ultima iteracion en dode el bloque NO tiene pareja.
     *
     *
     * @param list1 Contiene el primer de bloque de numeros a concatenar.
     */
    public static ArrayList <Integer> ultimaIteracion(ArrayList<Integer> list1){
        String concat;  // Variable String para concatenar los numeros.

        // Se crea un array de enteros para guardar la concatenacion de la primera lista con la segunda.
        ArrayList<Integer> arrayConcat = new ArrayList<>();
        concat = list1.toString(); // Se convierten las lista a string usando .toString.

        String aux3 = quitarCaracteres(concat); // Se recibe un String que tendra los numeros "limpios".
        String[] text = aux3.split(",");  // Se usa split para poder quitar las comas.

        for (String s : text) { //Con ayuda de un ciclo for-each se recorre el arreglo y se asignar a una variable String
            arrayConcat.add(Integer.valueOf(s));// Se convierte a tipo Integer usando una clase envolvente y se asigna a
        }                                      // nuestro arrayList declarado anteriormente.
        return arrayConcat; //Se regresa el arreglo con los numeros concatenados.
    }


    /** Este metodo sirve para poder quitar toda la "basura" que provienen de los arreglos
     * por ejemplo, los corchetes, comas juntas, entre otros.
     *
     * @param concat Variable que tiene la concatenacion de los dos bloques o de uno solo.
     */
    public static String quitarCaracteres(String concat){
        String aux, aux1, aux2, aux3; // Variables auxiliares.

        aux = concat.replaceAll("\\[", "");
        aux1 = aux.replaceAll("]", ","); // Con replace quita la entrada de corchetes y lo cambia por entre comillas.
        aux2 = aux1.replaceAll(" ", ""); // Esto se realiza tanto para corchetes, espacios o comas dobles.
        aux3 = aux2.replaceAll(",,", ",");
        return aux3; // Se retorna la variable String ya sin "basura"
    }
}