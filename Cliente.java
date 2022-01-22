import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;

public class Cliente {
    public static void main(String args[]) throws IOException{
        iniciarCliente();
    }

    public static void iniciarCliente() throws IOException {

        /* DECLARAMOS LOS OBJETOS */
        ObjectOutputStream objetoSalida = null;
        ObjectInputStream objetoEntrada = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nombre;
        String edad;
        String host;
        String ports;
        int porti=0;
        int edadc = 0;
        String resuno;
        String resdos;
        String restres;
        String rescuatro;
        String rescinco;

        /* REALIZAMOS LAS CONFIGURACIONES DE CONEXIÓN */
        System.out.println("Introduca la direccion ip del servidor del juego:");
        host = br.readLine();
        System.out.println("Introduzca el puerto:");
        ports = br.readLine();
        
        porti=Integer.parseInt(ports);
       
        try {

            /* CREAMOS UN SOCKET Y LO CONECTAMOS AL PUERTO ESPECIFICADO */
            Socket socketCliente = new Socket(host, porti);
            System.out.println("Conexion establecida con exito Bienvenid@ al juego \n");

            /* INICIALIZAMOS LOS OBJETOS DE ENTRADA Y SALIDA */
            objetoSalida = new ObjectOutputStream(socketCliente.getOutputStream());
            objetoEntrada = new ObjectInputStream(socketCliente.getInputStream());

            /* CREAMOS UN NUEVO Jugador CON LAS PARAMETROS RESPECTIVOS */
            System.out.println("Introduce tu nombre:");
            nombre = br.readLine();
            System.out.println("Introduce tu edad:");
            edad = br.readLine();
            edadc =Integer.parseInt(edad);
          
            Jugador jugador1 = new Jugador(nombre,edadc);

            /* ESCRIBIMOS UN OBJETO EN EL FLUJO */
            objetoSalida.writeObject(jugador1);
            objetoSalida.flush();
            
            /* CREAMOS UN NUEVO ONBJETO de estados PARA RECIBIR EL OBJETO DE TIPO estados */
            System.out.println("\nJuego para aprender las estados de los estados de México");
            System.out.println("Instrucciones:");
            System.out.println("*Recibiras un listado de estados de la republica Mexicana posteriormete deberas escribir la capital de cada uno respectivamente");
            System.out.println("*La primera letra de cada capital debe estar en mayuscula o se tomara como incorrecta");
            System.out.println("!BUENA SUERTE!  \n");
            Estados estados2 = (Estados) objetoEntrada.readObject();
            System.out.println("Estos son los estados:");
            System.out.println("1)" + estados2.getEstuno()+ "\n");
            System.out.println("2)" + estados2.getEstdos()+ "\n");
            System.out.println("3)" + estados2.getEsttres()+ "\n");
            System.out.println("4)" + estados2.getEstcuatro()+ "\n");
            System.out.println("5)" + estados2.getEstcinco()+ "\n");
            System.out.println("Introduce la capital del estado 1):");
            resuno = br.readLine();
            System.out.println("Introduce la capital del estado 2):");
            resdos = br.readLine();
            System.out.println("Introduce la capital del estado 3):");
            restres = br.readLine();
            System.out.println("Introduce la capital del estado 4):");
            rescuatro = br.readLine();
            System.out.println("Introduce la capital del estado 5):");
            rescinco = br.readLine();

            Respuestas respuestas1 = new Respuestas(resuno, resdos, restres, rescuatro, rescinco);

             /* ESCRIBIMOS UN OBJETO EN EL FLUJO */
             objetoSalida.writeObject(respuestas1);
             objetoSalida.flush();
             
            int resultado = (Integer) objetoEntrada.readObject();
            if(resultado == 5){
                System.out.println("\n!!Felicidades "+nombre+" obtuviste un puntaje perfecto!!");
                System.out.println("El puntaje obtenido es de: " + resultado+"/5 correctas");
            }else{
                System.out.println("\nGracias por jugar "+nombre);
                System.out.println("El puntaje obtenido es de: " + resultado+"/5 correctas");
            }

            

        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
