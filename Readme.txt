Lado del Servidor  
• Servidor implementado Java utilizando sockets de flujo 
• El servidor deberá ser capaz de atender al menos a un cliente. 
• Para obtener las preguntas y respuestas, el servidor deberá leer un archivo de texto que contiene los estados y sus capitales. (Con unos 5 es suficiente) • Después de recibir la conexión entrante, el servidor deberá pedir el nombre y edad del jugador (Usando serialización). 
• Una vez conectado el cliente, el servidor le enviará un conjunto de 5 estados y el jugador debe contestar correctamente la mayor cantidad posible de capitales. 
• Posteriormente el servidor se debe encargar de evaluar las respuestas de cada jugador y enviar el respectivo mensaje de cuántas capitales ha contestado bien.  

Lado del Cliente  

• Cliente implementado Java usando sockets de flujo 
• Antes de comenzar a jugar, el usuario deberá proporcionar a la aplicación cliente la dirección IP del servidor a conectarse, así como el número de puerto al que se conectará. 
• Una vez conectado el cliente, se le deberá pedir al usuario que ingrese el nombre y edad del jugador y éstos deberán ser enviados al servidor mediante serialización. • El cliente deberá recibir un conjunto de 5 estados de México para contestar cuál es su respectiva capital. 
• Cuando el servidor haya evaluado las respuestas del jugador, se debe enviar al cliente el respectivo mensaje de cuántas capitales contestó acertadamente.

Datos de la conexion:
Direccion Ip: 127.0.0.1
Puerto: 9999

Instruciones del Juego:
Los nombres de las Capitales deben estar correctamente escritas para tener
el punto eso incluye la mayuscula al inicio del nombre de cada una

Informacion extra:
El servidor solo puede atender un cliente a la vez.
cada que termine con un cliente(jugador) el siguente podra entrar de forma automatica.
