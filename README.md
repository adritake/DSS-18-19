# DSS-18-19
Repositorio de la asignatura DSS del Máster en Ingeniería informática de la UGR.

## Introducción a las prácticas
Breve demo de creación de managed beans y cómo inyectar un managed bean en otro.

[Repositorio](https://github.com/adritake/DSS-18-19/tree/master/holamundo)

## Práctica 1
Crear un simulador de un motor con un managed bean con un patrón interceptor.

Para que la práctica funcione, el managed Bean motorBean tiene que estar funcionando en un servidor de apache Tomcat.

[Repositorio](https://github.com/adritake/DSS-18-19/tree/master/practica1DSS)

## Práctica 2
Utilizando JPA, se pide programar una aplicación para crear Listas de Correo que utilizará un canal (DBUsuario) para escribir los datos de los usuarios de una Lista de Correo en una base de datos relacional, de acuerdo con las siguientes condiciones:
- La aplicación ha de permitir conectar rápidamente el programa “Cliente” a la base de datos de usuarios a través de un Servlet (“ListaCorreosServlet”) del tipo HttpServlet de Java.
- Crear una aplicación de “Administración de Usuarios”, que permita: visualizar todos los usuarios incluídos en la BD, actualizar los usuarios existentes y eliminar los usuarios almacenados en la mencionada tabla usuario.
- Ejecutar la aplicación como un proyecto Java de Eclipse y utilizar dicha aplicación para añadir usuarios a la lista de correo.

[Repositorio](https://github.com/adritake/DSS-18-19/tree/master/practica2DSS)

## Práctica 3

Implementación de un CRUD-service en Java.

LLamamos 'CRUD' (Create, Read, Update, Delete) a un Servicio WEB (WS) que tiene que ser RESTful y que nos permitirá guardar y operar una lista hecha con entidades extraidas del dominio específico que elijamos (Reseñas bibliográficas, catálogos de cocher, críticas de películas, etc.). El modelo de datos manejado por el WS puede incluir imágenes y sonidos, los cuales pueden ser incluidos desde una página Web a través de llamadas HTTP.

- Tenemos que crear el modelo de datos, así como la clase Singleton actuará como la única "proveedora de datos" del modelo.
- Usaremos una clase enum de Java para programar un "proveedore de contenidos" a las aplicaciones cliente (página web) a través de Internet.
- Crearemos los recursos necesarios para el servicio.
- Finalmente, el servicio REST que hemos programado tiene que poder ser usdao por HTML forms.

El formulario Web permitirá hacer POST en datos nuevos, los cuales son incluidos en la base de datos del servicio: tenemos que crear una página `.html` en la carpeta *WebContent* de nuestro proyecto Eclipse.

[Repositorio](https://github.com/adritake/DSS-18-19/tree/master/practica3DSS)
