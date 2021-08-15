# :mortar_board: Proyecto final formación Sinensia :school_satchel:
## :bomb::boom: Se realiza el despliegue del proyecto "hello-final" :bomb::boom:

* Previamente se ha modificado el proyecto hello-final para añadir un mensaje guay a la salida. :stuck_out_tongue_winking_eye:
* Se ha creado un Dockerfile.
  * Se ha compilado el proyecto hello-final en una maquina con gradle y jdk 16.
  * Se ha guardado el .jar resultante en una maquina alpine con jre 16.
* Se ha creado un docker-compose.yml.
  * Se ha añadido el nombre de la imagen que quieres crear para arrancar el Dockerfile.
  * Se ha realizado un mapeo de puertos para poder ejecutar la aplicación.
* Se ha realizado la conexion de Jenkins con GitLab mediante el token para poder incorporar modificaciones en caso de commit y poder realizar la ejecución automáticamente.
* Se ha creado un proyecto nuevo de pepeline en Jenins para la integración continua.
* Se ha configurado Jenkis para poder localizar jdk 16 en el equipo.
* Se ha creado un Jenkinsfile para realizar tirar de Jenkis y crear una integracion continua del código.
  * Se ha declarado el jdk 16 para tirar de el en la compilación y ejecución de la aplicación.
  * Se han añadido pasos de testing al Jenkins.
  * El Pitest no se ha conseguido lanzar con jdk 16, se ha dejado comentado esa parte del codigo.
  * Se ha realizado la conexion con el registro de contenedores de GitLab mediante un token de despliegue.
  * Se ha realizado un envio de la imagen al registro de contenedores de GitLab.
  * Al usuario creado app en las practicas le pasamos con la herramienta ANSIBLE un docker-compose.yml con la imagen del registros de contenedores de GitLab que hemos subido.
  * Para finalizar realizamos una conexion via SSH a este usuario y de forma "remota" lanzamos el "docker-compose up -d"

:diamond_shape_with_a_dot_inside: Con estos pasos tenemos nuestra aplicación en ejecución. :tada:

:diamond_shape_with_a_dot_inside: Si me he dejado algo, lo siento... Se me ha quedado la maquina frita :fire:

## Por ultimo decir muchas gracias a Javier y a Sinensia por esta formación tan entretenida y perfectamente explicada! :clap::clap:
## Saludos!! :sunglasses::sunglasses:

