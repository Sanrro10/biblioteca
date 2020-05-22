# Biblioteca

Esta aplicación es un pequeño gestor de biblioteca donde tanto usuarios como gestores pueden interactuar con los libros de una Base de Datos.

## Comenzando 🚀

_A continuación, se explican los pasos a seguir para la correcta utilización de la aplicación._


### Pre-requisitos 📋

Para el funcionamiento correcto de la aplicación, es necesario tener instalado:
  - apache-maven-3.6.3
  - Java jdk1.8.0_241

### Instalación 🔧

_Clonar repositorio_
  Primero habrá que clonar el repositorio de github desde este link:
```
    https://github.com/Sanrro10/biblioteca
```
  En caso de querer clonar desde la consola, utilizaremos estos comandos:
```
  git remote add origin https://github.com/Sanrro10/biblioteca.git
  git push -u origin master
  ```

## Setup ⚙️

Para arrancar el programa será necesario abrir un terminal en la ruta del proyecto donde esté el archivo "pom.xml" y ejecutaremos estos comandos:
```
    mvn clean
    mvn compile
    mvn datanucleus:schema-create
    mvn exec:java -PServer
    
    ¡Importante no cerrar este terminal mientars usamos la aplicación! Podemos minimizarla para que no nos moleste    
```
Abrimos de nuevo otra consola y la ruta del proyecto donde esté el archivo "pom.xml" y ejecutaremos este comando para abrir la parte del cliente:
```
    mvn exec:java -PClient
```


## Documentación 📦

La aplicación es capaz de registrar usuarios en una base de datos e iniciar sesión permitiendo el paso solo a aquellos previamente registrados. Al iniciar sesión tenemos la opción de ver todos los libros disponibles que tenemos en la biblioteca, pudiendo reservarlo y visualizar el titulo, el genero, el autor y el último día de la reserva. También es posible entrar como gestor y tendremos distintos privilegios. Al entrar tenemos la posibilidad de gestionar un libro, donde nos permite añadir un libro nuevo, donde podemos introducir el nombre, el genero, el autor y un plazo de dias para la reserva o modificar un libro, que en caso de no haber introducido bien algún dato del libro previamente añadido lo podemos modificar, ademas es podible eliminar libros. También es posible visualizar los libros que se han pasado el plazo de la reserva y en un futuro será posible sancionarlos. 

Para obtener la documentación del proyecto, ejecutar este comando:
```
    mvn site    
```

## Tests 💻

Para obtener los tests del proyecto, ejecutar este comando:
```
    mvn test    
```

## Construido con 🛠️

_Menciona las herramientas que utilizaste para crear tu proyecto_

* [Eclipse](https://www.eclipse.org/) - El framework web usado
* [Maven](https://maven.apache.org/) - Manejador de dependencias
* [Log4j](https://logging.apache.org/log4j/2.x/) - Logger
* [Travis](https://travis-ci.org/) - Tester e implementador


## Autores ✒️

* **Kevin Arnaiz**  [kevin.arnaiz@opendeusto.es]
* **Mikel Gonzalez**  [mikel.gonzalez2@opendeusto.es]
* **Sergio Lopez**  [sergi.lopez@opendeusto.es]
* **Iñigo Gonzalez de San Román** [i.glzsr@opendeusto.es]



