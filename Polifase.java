import java.io.*;
import java.util.*;

/**
 * Clase correspondiente al algoritmo de Ordenamiento Polifase
 * Este archivo corresponde a ordenamiento polifase, a este se le puede pasar cualquier numero y lo ordenara
 * ya sea de forma ascendente o descendente.
 *
 * @author Luis Aldo Gomez Bolanios, Karen Mariel Bastida Vargas y Jorge Salgado Miranda
 * @version 1.0
 */
public class Polifase {

    public static void polifase(File archivo) throws IOException {
        Scanner sc = new Scanner(System.in);//Creamos un nuevo Objeto del tipo Scanner para poder obtener las entradas del usuario
        float opc;
        short opcion = ordenar();

        String Arch0 = archivo.getAbsolutePath();// Se declara la ruta absoluta del fichero 0 en donde se encuentra la lista a ordenar.
        String Arch1 = "/Users/luisaldogb/Downloads/Facultad de Ingenieria/Semestre IV/Estructura de Datos y Algoritmos II/Proyecto 1 EDA II TERMINADO /Proyecto 1 EDA II 3/src/f1.txt"; // Se declara la ruta absoluta del fichero auxiliar 1 donde se guardaran los bloques de numeros ordenados.
        String Arch2 = "/Users/luisaldogb/Downloads/Facultad de Ingenieria/Semestre IV/Estructura de Datos y Algoritmos II/Proyecto 1 EDA II TERMINADO /Proyecto 1 EDA II 3/src/f2.txt";// Se declara la ruta absoluta del fichero auxiliar 2 donde se guardaran los bloques de numeros ordenados.
        String Arch3 = "/Users/luisaldogb/Downloads/Facultad de Ingenieria/Semestre IV/Estructura de Datos y Algoritmos II/Proyecto 1 EDA II TERMINADO /Proyecto 1 EDA II 3/src/f3.txt";
        // Se crean 3 listas de arreglos, la primera para ser la lista original y las otras 2 auxiliares para contener los bloques
        ArrayList<ArrayList<Integer>> list = new ArrayList<>(); // Lista de arreglos principal.
        ArrayList<ArrayList<Integer>> auxiliar1 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> auxiliar2 = new ArrayList<>(); //Listas auxiliares
        ArrayList<ArrayList<Integer>> auxiliar3 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> totalNum = new ArrayList<>(); //Se declara una lista auiliar que tendra los bloques.

        LeerArchivo ls = new LeerArchivo(); //Creamos un nuevo Objeto de la clase LeerArchivo
        String temp1 = archivo.getAbsolutePath(); //Obtenemos el path absoluto del archivo y se lo asignamos a una variable de tipo string
        System.out.println("\nLista original del archivo:  "+ archivo.getName());
        System.out.println(ls.leerArchivoTxt(temp1)); //Imprimimos en pantalla el retorno del metodo del nuevo objeto del tipo leer archivo
        String aux = ls.leerArchivoTxt(temp1);//Asignamos el valor del contenido del archivo a la variable String para una mejor manipulacion
        String[] text = aux.split(",");//Seleccionamos el tipo de division que separa las claves.

        System.out.println("Cuantos valores quieres que se tomen a leer?");
        opc = sc.nextShort();//Se le pide al usuario de cuantos digitos se van a hacer los bloques iniciales

        int valor = (int) Math.ceil(text.length/opc);//Redondea la division del total de numero en la lista entre los valores en los bloques, y lo redondea hacia arriba.

        for (int j = 0; j < valor; j++) { //creamos la lista con base a la cantidad de bloques que determina el usuario.
            ArrayList<Integer> arr1 = new ArrayList<>();
            list.add(arr1);
        }

        //Separamos las entradas a la lista de indices con base en la cantidad de divisiones que quiere que haga el usuario.
        int aux1 = 0;//Variable para ir iterando los indices de la lista.

        for (ArrayList<Integer> integers : list) { // Ciclo para agregar los numeros en la lista principal
            for (int j = 0; j < opc; j++) { //Este ciclo for recorre los indices de los numeros en los indices de la lista principal.
                if (aux1 < text.length) {//Se hace esto para que el valor de aux1 no rebase el valor de la longitud de la lista y se salga del rango.
                    integers.add(Integer.valueOf(text[aux1]));
                    // Se obtiene con un metodo get el indice de la linea principal, y se agrega el valor a otra lista determinada.
                    aux1++; //Se itera para obtener todas los numeros del arreglo text
                }
                //Se agregan a la lista con la clase envolvente para convertirlos de String a entero.
            }
        }

        File f1 = new File("/Users/luisaldogb/Downloads/Facultad de Ingenieria/Semestre IV/Estructura de Datos y Algoritmos II/Proyecto 1 EDA II TERMINADO /Proyecto 1 EDA II 3/src", "f1.txt");
        //Creamos un nuevo archivo donde se van a ir poniendo las iteraciones del ordenamiento por Polifase

        File f2 = new File("/Users/luisaldogb/Downloads/Facultad de Ingenieria/Semestre IV/Estructura de Datos y Algoritmos II/Proyecto 1 EDA II TERMINADO /Proyecto 1 EDA II 3/src", "f2.txt");
        //Creamos un nuevo archivo donde se van a ir poniendo las iteraciones del ordenamiento por Polifase

        File f3 = new File("/Users/luisaldogb/Downloads/Facultad de Ingenieria/Semestre IV/Estructura de Datos y Algoritmos II/Proyecto 1 EDA II TERMINADO /Proyecto 1 EDA II 3/src", "f3.txt");
        //Creamos un nuevo archivo donde se van a ir poniendo las iteraciones del ordenamiento por Polifase

        if (f1.createNewFile() && f2.createNewFile() && f3.createNewFile()) { //Si no existen los archivos con esta
            System.out.println("Creando los archivos auxiliares...");
        } else {
            System.out.println("Los archivos ya existen.");
        }

        for(ArrayList<Integer> princi: list){ // Se manda al Heap la lista original para ordenarla partida en bloques dependiendo del numero digitado por el usuario
            HeapSort.heap(princi, princi.size()); // Se llama el metodo heap en la clase HeapSort, y se pasa como parametro un ArrayList con los numeros del archivo original.
        }

        System.out.println("Lista original: "+ list); // Se imprime la lista original para checar que esten separados por bloques
        ArrayList<Integer> unionDatos;
        int valor2 =(int) Math.ceil(((double)valor)/((double)2)); //Indica cuantos bloques se haran en la primera iteracion
        int elementos = (int) (opc*2); //Elementos aumenta la capacidad de los bloques cuando se "juntan".
        int aux200, aux300; //Vaiables auxiliares para calcular cuantos numeros restan en el ultimo bloque
        int aux100 = 0; //Calcula en que indice se encuentra el primer numero del bloque incompleto.
        int cuentaBloques = 0; //Variable que almacena el ultimo bloque de auxiliar1 o list, ya que aqui siempre se va almacenar el ultimo bloque solitario si es que hay

        for(int k = 0; k < valor2; k++){  //Se inicializa totalNum de forma que se llena dependiendo de los bloques que haya en la
            ArrayList<Integer> arr2 = new ArrayList<>();            //primera iteracion.
            totalNum.add(arr2);
        }

        asignarDatosList(auxiliar1, auxiliar2, list); // Se pasa a la listas auxiliares la lista original partiendo la mitad en cada una
        DistribucionArchivos(auxiliar1, Arch1, auxiliar2, Arch2); // Se imprimen los valores en los archivos
        //segundoCaso(valor, auxiliar1, auxiliar2,list,auxiliar3); // Una vez ordenados los archivos auxiliares se hace de nuevo la particion hacia f0 y f3.


        for(int i = 0; i <=  valor; i++){ //For que engloba todo con la finalidad de que haga un aproximado en iteraciones.

            if( i >= 1){                             //Este if solo entra si ya se hizo la primera iteracion ya que se tiene que
                for(int k = 0; k < valor2; k++){     //asignar cuantos ArrayList tendra totalNum ya que con cada iteracion cambia.
                    ArrayList<Integer> arr2 = new ArrayList<>();
                    totalNum.add(arr2);
                }

                //Como los datos estan guardados en auxiliar1 y auxiliar2 se borran los contenidps de list y auxiliar3
                list.clear();   // Ya que con esta iteracion se van a guardar ahi y para evitar tener tamanios de mas se borran
                auxiliar3.clear(); //estas dos listas.
            }

            //Este if calcula la resta de "bloques" entre auxiliar1 y auxiliar2 si la resta es diferente de cero quiere decir
            if(auxiliar1.size() - auxiliar2.size() != 0){ //que hay un bloque solitario que se encuentra en auxiliar1
                cuentaBloques = auxiliar1.size()-1;
            }

            // Este for sirve para asignar los bloques a lista y auxiliar3 provenientes de auxiliar1 y auxiliar2
            for(int m = 0; m < valor2; m++){ //Se hacen las iteraciones dependiendo del numero de bloques que haya.
                if(m == cuentaBloques && (auxiliar1.size()-auxiliar2.size()) >= 1){
                    //Si se cumple significa que estamos en la ultima iteracion que con el bloque solitario.
                    unionDatos = EscrituraArchivo.ultimaIteracion(auxiliar1.get(m));
                }else{
                    //Caso contrario existen parejas completas por lo que se llama al metodo para concatenar los dos bloques
                    unionDatos = EscrituraArchivo.deIntegeraString(auxiliar1.get(m), auxiliar2.get(m));
                }

                //Se llama a heapsort y se guardan los valores concatenados en un ArrayList <Integer>
                HeapSort.heap(unionDatos, unionDatos.size());
                //Text.length es cuantos numeros tenemos en nuestro archivo.
                aux200 = text.length % elementos; //Si sacamos el modulo nos dice cuantos numeros quedan solos
                aux300 = text.length - aux200;
                // Si hacemos la resta se calcula en que posicion empieza el primer numero que pertenece al bloque que queda solo

                if(aux300 != aux100){ //Si la primera posicion del elemento que resta es diferente de aux100 entrara
                    //Aux100 es un contador que nos ayuda a saber cuantos elementos se han pasado ha totalNum
                    for(int j = 0; j < elementos; j++){ //Significa que va a iterar desde 0 hasta la concatencacion de bloques
                        totalNum.get(m).add((unionDatos.get(j)));
                        aux100++;
                    }
                }else{ //Caso contrario entonces se agregara a total num los numeros que no completan el tamanio del bloque
                    for(int k = 0; k < aux200; k++){ //Se va a iterar desde 0 hasta cuantos elementos se quedaron solos
                        totalNum.get(m).add(unionDatos.get(k));
                    }
                    break;
                }
                unionDatos.clear(); //Una vez teniendo los datos en un ArrayList separado por bloques se borra nuestro
                                    //Array auxiliar
            }
            //Una vez que sale del ciclo se incializan en cero nuestras variables para la siguiente iteracion
            aux100 = 0;
            cuentaBloques = 0;
            asignarDatosList(list, auxiliar3, totalNum); //Se asigna en cada Array sus bloques correspondientes ya anidados.
            DistribucionArchivos(list, Arch0, auxiliar3, Arch3);

            //Como en list siempre se almacena el bloque ordenado si el tamanio original es igual al de la primera posicion
            if(list.get(0).size() == text.length) { //significa que ya se ordeno todos los numeros y que no son necesarias
                break;                              //mas iteraciones por lo tanto se rompe el ciclo.
            }

            //En caso de que el bloque en la posicion1 no este completo se seguira ejecutando el programa.

            //Se actualizan las variables para la siguiente iteracion.
            valor2 =(int) Math.ceil(((double)valor2)/((double)2));
            elementos = elementos*2;

            //Se llena nuestro ArrayList auxiliar.
            for(int k = 0; k < valor2; k++){    // Llena nuevamente totalNum ya que se queda vacio en cada iteracion.
                ArrayList<Integer> arr2 = new ArrayList<>();
                totalNum.add(arr2);
            }

            if(list.size() - auxiliar3.size() != 0){ // Calcula si queda un bloque vacio en lista y auxiliar3.
                cuentaBloques = list.size()-1;    //De ser el caso se asigna el valor en una variable auxiliar.
            }

            for(int m = 0; m < valor2; m++) { //Entrando al ciclo recorremos cada bloque hasta asiganrlo en su nueva posicion de auxiliar1 y auxiliar2.
                if(m == cuentaBloques && (list.size() - auxiliar3.size() >= 1)) {
                    unionDatos = EscrituraArchivo.ultimaIteracion(list.get(m)); //El bloque solitario siempre se encuentra en list por lo que se extrae de ahi.
                }else{
                    unionDatos = EscrituraArchivo.deIntegeraString(list.get(m), auxiliar3.get(m));
                }

                HeapSort.heap(unionDatos, unionDatos.size()); // Se usa HeapSort para ordenar el combo de bloques y se pasa su tamanio.
                aux200 = text.length % elementos; // Variable auxiliar que calcula cuantos numero quedan solos.
                aux300 = text.length - aux200;  // Se asigna a una variable auxiliar desde que posicion se encuentra el indice que corresponde al bloque solitario.
                if(aux300 != aux100){
                    for(int j = 0; j < elementos; j++){ // En caso de que se entre al if se da por generico que los bloques tienen parejas.
                        totalNum.get(m).add(unionDatos.get(j));
                        aux100++;
                        // Se incrementa  aux100 lo que significa que en un dado punto no entrara al if por lo que se dara inicio al bloque que no tiene pareja.
                    }
                }else{
                    for(int k = 0; k < aux200; k++){  //Con este ciclo se llena el bloque que queda solo.
                        totalNum.get(m).add(unionDatos.get(k));
                    }
                    break; // Para que no se siga iterando el ciclo se utiliza un break para romperlo.
                }
                unionDatos.clear(); // Se vacia el auxiliar datos para la siguiente iteracion.
            }

            aux100 = 0;            //Se inicializan en cero las variables para la siguiente iteracion en dado caso
            cuentaBloques = 0; //se vacian las listas auxiliares y se llama el metodo asignarDatosList para pasarlo a lista y auxiliar3
            auxiliar1.clear();
            auxiliar2.clear();
            asignarDatosList(auxiliar1, auxiliar2, totalNum);
            DistribucionArchivos(auxiliar1, Arch1, auxiliar2, Arch2); // Con distribucion de archivos se imprime en los archivos correspondientes.

            valor2 =(int) Math.ceil(((double)valor2)/((double)2)); // Se calculan entre dos los siguientes bloques a juntar y ordenar.
            elementos = elementos*2; // Se calcula cuantos elementos iran por bloque.
        }
        System.out.println("Su archivo se ha ordenado satisfactoriamente en:  " + archivo.getName());

        if(opcion == 2){
            int imprimir;
            Object [] arreglo = list.get(0).toArray();
            for(int i= arreglo.length - 1;  i >= 0; i--){
                imprimir  = (Integer) arreglo[i];
                System.out.print(imprimir+", ");
            }
            System.out.println();
        }
    }

    public static void DistribucionArchivos(ArrayList<ArrayList<Integer>> lista1,String direccionArchivo1, ArrayList<ArrayList<Integer>> lista2,String direccionArchivo2){
        EscrituraArchivo.escribirDatos(lista1,direccionArchivo1); //Este metodo sirve para escribir en los archivos la iteracion correspondiente.
        EscrituraArchivo.escribirDatos(lista2,direccionArchivo2);
    }

    public static void asignarDatosList( ArrayList<ArrayList<Integer>> auxiliar1, ArrayList<ArrayList<Integer>> auxiliar2, ArrayList<ArrayList<Integer>> list){
        int w = 0;//Variable para contabilizar el indice del arraylist
        for (int i = 0; i < list.size(); i++) {
            if ((i % 2) == 0) { // Con el modulo del la variable del ciclo for es como se calcula en que lista se ingresara el primer bloque,
                auxiliar1.add(list.get(w)); //asi como los sub-secuentes
            } else {
                auxiliar2.add(list.get(w));
            }
            w++; //Esta variable nos ayuda a localizarnos en que posicion se estan guardando cada bloque de la lista original.
        }
        list.clear(); // Se vacia la lista original para no tener problemas con el almacenamiento de los numeros.
    }
    public static short ordenar(){
        Scanner sc = new Scanner(System.in);//Creamos un nuevo objeto de tipo Scanner
        short opc;
        System.out.println("Como desea ordenar su archivo? \n1.Ascendente\n2.Descendente");
        opc = sc.nextShort();
        return opc;//Con base en lo ingresado por el usuario seleccionamos si se hace de manera ascendente o Descendente
    }
}