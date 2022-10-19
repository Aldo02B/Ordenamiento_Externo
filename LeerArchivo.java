import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Clase correspondiente a Leer el Archivo Proporcionado por el usuario.
 *
 * @author Luis Aldo Gomez Bolanios, Karen Mariel Bastida Vargas y Jorge Salgado Miranda
 * @version 1.0
 *
 */

public class LeerArchivo {//Clase encargada de poder leer el archivo del usuario.

    public String leerArchivoTxt(String direccion){//este metodo va a recibir la direccion del archivo TXT
        String text = "";
        try{//Manejamos excepciones, por ello se hace el intento de obtener el archivo, en dado caso de que no funcione, retornamos una excepcion.
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            // (FileReader)
            // Creamos un FIleReader y le pasamos la direccion, (Crea un nuevo FileReader dado el nombre que le pasemos para leer).
            // Usando los caracteres predeterminados dependiendo la plataforma.
            // Se le pasa el nombre del archivo para leerlo

            // (BufferedReader)
            // Crea una secuencia de entrada del tamanio exacto con base en la entrada del buffer.
            // De parametros requiere un Reader

            StringBuilder temp = new StringBuilder();
            String bfRead;
            while((bfRead = bf.readLine()) != null){
                //Lee una linea de texto, (Se considera que una linea termina cuando se aprecia un '\n' o un '\r')
                // Termina cuando encuentra un EOF (End of FIle) o fin del archivo.

                    temp.append(bfRead); // Se va agregando lo leido en el archivo a la variable temp
            }
            text = temp.toString();
            //Vamos asignando los valores obtenidos en el archivo a la variable text.

        }catch (Exception e){//Mostramos una excepcion de que no se ha encontrado el archivo.
            System.out.println("No se encontro el archivo");
        }
        return text;//Regresamos el valor del texto (el valor que se fue acumulando al leer el archivo hasta llegar a EOF)
    }
}
