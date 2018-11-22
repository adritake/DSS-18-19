# DSS-18-19
Repositorio de la asignatura DSS del Máster en Ingeniería informática de la UGR.

## Introducción a las prácticas
Breve demo de creación de managed beans y cómo inyectar un managed bean en otro.

[Introducción](https://github.com/adritake/DSS-18-19/tree/master/holamundo)

## Práctica 1
Crear un simulador de un motor con un managed bean con un patrón interceptor.

Para que la práctica funcione, el managed Bean motorBean tiene que estar funcionando en un servidor de apache Tomcat.

[Práctica 1](https://github.com/adritake/DSS-18-19/tree/master/practica1DSS)

## Práctica 2
Utilizando JPA, se pide programar una aplicación para crear Listas de Correo que utilizará un canal (DBUsuario) para escribir los datos de los usuarios de una Lista de Correo en una base de datos relacional, de acuerdo con las siguientes condiciones:
- La aplicación ha de permitir conectar rápidamente el programa “Cliente” a la base de datos de usuarios a través de un Servlet (“ListaCorreosServlet”) del tipo HttpServlet de Java.
- Crear una aplicación de “Administración de Usuarios”, que permita: visualizar todos los usuarios incluídos en la BD, actualizar los usuarios existentes y eliminar los usuarios almacenados en la mencionada tabla usuario.
- Ejecutar la aplicación como un proyecto Java de Eclipse y utilizar dicha aplicación para añadir usuarios a la lista de correo.

[Práctica 2](https://github.com/adritake/DSS-18-19/tree/master/practica2DSS)

## Práctica 3

Implementación de un CRUD-service en Java.

LLamamos 'CRUD' (Create, Read, Update, Delete) a un Servicio WEB (WS) que tiene que ser RESTful y que nos permitirá guardar y operar una lista hecha con entidades extraidas del dominio específico que elijamos (Reseñas bibliográficas, catálogos de cocher, críticas de películas, etc.). El modelo de datos manejado por el WS puede incluir imágenes y sonidos, los cuales pueden ser incluidos desde una página Web a través de llamadas HTTP.

- Tenemos que crear el modelo de datos, así como la clase Singleton actuará como la única "proveedora de datos" del modelo.
- Usaremos una clase enum de Java para programar un "proveedore de contenidos" a las aplicaciones cliente (página web) a través de Internet.
- Crearemos los recursos necesarios para el servicio.
- Finalmente, el servicio REST que hemos programado tiene que poder ser usdao por HTML forms.

El formulario Web permitirá hacer POST en datos nuevos, los cuales son incluidos en la base de datos del servicio: tenemos que crear una página `.html` en la carpeta *WebContent* de nuestro proyecto Eclipse.

[Práctica 3](https://github.com/adritake/DSS-18-19/tree/master/practica3DSS)

## Práctica 4
### Ejercicio 1
Especificar utilizando BPEL el proceso de negocio (cuyo diagrama de actividad se muestra en la siguiente figura) y que se describe informalmente como sigue: “El cliente invoca al proceso de negocio, especificando el nombre del empleado, el destino de su viaje, la fecha de salida, y la fecha de regreso. El proceso de negocio BPEL comprueba primero el status del empleado para viajar (clase turista, business, avión privado); suponemos que existe un servicio Web contra el que se puede realizar esta consulta. Después, el proceso BPEL comprobará el precio del billete con 2 líneas aéreas: Iberia y Vueling. Supongamos otra vez que ambas compañías proporcionan un servicio Web contra el que se pueden realizar estas gestiones. El proceso BPEL seleccionará el precio más bajo y devolverá un plan de viaje al cliente”.

[Ejercicio 1](https://github.com/adritake/DSS-18-19/tree/master/practica4DSS_1)

[Imagenes](https://github.com/adritake/DSS-18-19/tree/master/practica4DSS_1/img)

### Ejercicio 2
Orquestar, de forma simplificada, el mercadeo entre un comprador y un vendedor de un producto solicitado,de acuerdo con el diagrama de interacción que se muestra en la siguiente figura. El compradorcomienza pidiendo un precio al vendedor y el vendedor responde con un precio para el producto o unaexcepción si no conoce el artículo que le demandan o no estuviera disponible en el almacén. El compradorcontinua pidiendo precio al vendedor y entra en un comportamiento repetitivo con actualizaciones(del precio del artículo) hasta que decide comprar el artículo cuando considera que se le ofrece el mejorprecio. Se pide en este ejercicio desarrollar la descripción completa de la orquestación que se ha descrito anteriormente entre el comprador y el vendedor.

[Ejercicio 2](https://github.com/adritake/DSS-18-19/tree/master/practica4DSS_2)

[Imágenes](https://github.com/adritake/DSS-18-19/tree/master/practica4DSS_2/img) del ejercicio.
