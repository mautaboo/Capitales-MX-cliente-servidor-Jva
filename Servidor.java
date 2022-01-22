import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;

public class Servidor {
    public static void main(String args[]) {
        iniciarServidor();
    }

    public static void iniciarServidor() {

        /* DECLARAMOS LOS OBJETOS */
        ObjectOutputStream objetoSalida = null;
        ObjectInputStream objetoEntrada = null;
        BufferedReader ba = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         /* DECLARAMOS LAS VARIABLES */
        String nombreFichero = "capitales.txt";
        int i=0;
        String text[] = new String[11];
        String resuno;
        String resdos;
        String restres;
        String rescuatro;
        String rescinco;
        int resultado=0;

//-----------------------------Lectura de los Estados y las Capitales desde el archivo-----------------------
        try {
            //Crear un objeto BufferedReader al que se le pasa 
            //un objeto FileReader con el nombre del fichero
            ba = new BufferedReader(new FileReader(nombreFichero));
            String texto = "inicio";
            //Repetir mientras no se llegue al final del fichero
            while(texto != null)
            {  
                //Leer la primera línea, guardando en un String
                texto = ba.readLine();
                //Guardamos la linea leida dentro del arreglo text
                text[i]= texto;
                i++;
            }
         }catch (FileNotFoundException e) {
            System.out.println("Error: Archivo no encontrado");
            System.out.println(e.getMessage());
        }catch(Exception e) {
            System.out.println("Error de lectura del Archivo");
            System.out.println(e.getMessage());
        }
        finally {
            try {
                if(br != null)
                    br.close();
            }
            catch (Exception e) {
                System.out.println("Error al cerrar el Archivo");
                System.out.println(e.getMessage());
            }

//----------------------------Fin de la lectura de los Estados y las Capitales desde el archivo------------------------

Estados estados1 = new Estados(text[0], text[1], text[2], text[3], text[4]);
System.out.println("| ------------------------------------- |");
System.out.println("|                 Estados               |");
System.out.println("| ------------------------------------- |");
System.out.println("| "+text[0]);
System.out.println("| "+text[1]);
System.out.println("| "+text[2]);
System.out.println("| "+text[3]);
System.out.println("| "+text[4]);
System.out.println("| ------------------------------------- |");

System.out.println("| ------------------------------------- |");
System.out.println("|                Capitales              |");
System.out.println("| ------------------------------------- |");
System.out.println("| "+text[5]);
System.out.println("| "+text[6]);
System.out.println("| "+text[7]);
System.out.println("| "+text[8]);
System.out.println("| "+text[9]);
System.out.println("| ------------------------------------- |");


//----------------------------------- Implemetacion del Socketservidor ------------------------------------------
        try {

            /* PUERTO POR EL QUE ESCUCHA */
            ServerSocket socketServidor = new ServerSocket(9999);
            System.out.println("\n Esperando jugadores... \n");

            while (true) {

                /* ESCUCHA UNA CONEXION A ESTE SOCKET Y LA ACEPTA */
                Socket socketCliente = socketServidor.accept();

                /* RECIBIMOS INFORMACION DEL CLIENTE */
                System.out.println("|--------------------------------------------------------------|");
                System.out.println(" Nuevo jugador conectado " );

                /* INICIALIZAMOS LOS OBJETOS DE ENTRADA Y SALIDA */
                objetoSalida = new ObjectOutputStream(socketCliente.getOutputStream());
                objetoEntrada = new ObjectInputStream(socketCliente.getInputStream());

                /* RECIBIMOS EL OBJETO DEL CLIENTE */
                Jugador jugador1 = (Jugador) objetoEntrada.readObject();
                System.out.println(" Informacion del nuevo jugador ");
                System.out.println(" Nombre: " + jugador1.getNombre());
                System.out.println(" Edad: " + jugador1.getEdad());

                /* ENVIAMOS EL OBJETO CON LOS ESTADOS*/
                System.out.println(" Enviando estados al cliente...");
                objetoSalida.writeObject(estados1);
                objetoSalida.flush();

                
                /* RECIBIMOS LAS RESPUESTAS DEL CLIENTE */
                Respuestas respuestas2 = (Respuestas) objetoEntrada.readObject();
                 /* Asignamos una por una a una variable auxiliar local */
                resuno = respuestas2.getRespuno();
                resdos = respuestas2.getRespdos();
                restres = respuestas2.getResptres();
                rescuatro = respuestas2.getRespcuatro();
                rescinco = respuestas2.getRespcinco();

                if(text[5].equals(resuno)){
                  resultado++;
                }
                if(text[6].equals(resdos)){
                    resultado++;
                }
                if(text[7].equals(restres)){
                    resultado++;
                }
                if(text[8].equals(rescuatro)){
                    resultado++;
                }

                if(text[9].equals(rescinco)){
                    resultado++;
                }

               /* ENVIAMOS EL OBJETO CON LOS ESTADOS*/
               System.out.println(" !!Resultados enviados al usuario!! ");
               System.out.println("|--------------------------------------------------------------| \n");
               objetoSalida.writeObject(resultado);
               objetoSalida.flush();
               resultado=0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//-------------------------------------- Implemetacion del Socketservidor -------------------------------------
    }
 }


}
