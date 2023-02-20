# ApiTest
## Descripción:
ApiTest es una aplicación en JAVA, desarrollada en Spring Boot, la cual tiene por objetivo consumir servicios de diferentes API fuente, y mostrar la información de forma resumida y agrupada, como si se hubieran consumido los servicios de forma independiente. Posee dos servicios, uno Rest y otro SOAP, y busca información de personas, actores, canciones, etc., enviando únicamente como parámetro un nombre.

## Requisitos:
La aplicación para funcionar necesita de JAVA 11 y Maven, si además se desea modificar el código se hizo uso de Spring Tools 4 el cual se puede descargar del siguiente enlace:

https://spring.io/tools

La aplicación se ejectua sobre el puerto 8080, el cual es el puerto por default, de una aplicación web, si se desea cambiar el puerto es necesario agregar la linea:

server.port= {número puerto}

En el archivo application.properties, antes de compilar.

### Configuración en Linux (ejecución):
Si se desea correr la aplicación en un ambiente Linux (basado en Debian) que no tenga instalado ni configurado un ambiente de desarrollo se debe primero instalar JAVA 11:
```sh
$ sudo apt update
```
```sh
$ sudo apt install openjdk-11-jdk
```
```sh
$ sudo apt install openjdk-11-jre
```
Después se debe instalar Maven:
```sh
$ sudo apt install maven
```
### Compilación:
Se puede compilar usando el comando:
```sh
$ mvn package
```
### Ejecución:
Después de haber compilando la aplicación, se puede ejecutar a través del JAR generado (previamente se debe ubicar el JAR en la carpeta target, haciendo un cd a la carpeta target)
```sh
$ java -jar test-0.0.1-SNAPSHOT.jar
```
La aplicación puede ser detenida en consola presionando <kbd>ctrl</kbd>+<kbd>c</kbd> en consola.

### Servicio REST:
Se puede ejecutar el servicio REST de tipo GET, a través de la siguiente url, desde localhost:

http://localhost:8080/rest/find/{nombre}

### Servicios SOAP:
El archivo WSDL del servicio SOAP, con la definición para ser consumido se encuentra en la siguite ruta:

http://localhost:8080/ws/person.wsdl

### Ayuda:
Se puede consultar el manual técnico a través de la siguiente ruta:

https://docs.google.com/document/d/1NOX4XBioyq1lDMCj8vrgR7tTm_8PGEVnzUCN9h8abwY/edit?usp=sharing



