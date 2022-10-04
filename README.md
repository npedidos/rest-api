# NPedidos - REST API

[![DeepSource](https://deepsource.io/gh/npedidos/rest-api.svg/?label=active+issues&show_trend=true&token=Dfu5Zcgrcwn5tDz83zE1QmFe)](https://deepsource.io/gh/npedidos/rest-api/?ref=repository-badge)

## Descripción

NPedidos es una aplicación que permite la gestión simple de pedidos de menús de comidas, por fechas.

Este proyecto proporciona los recursos a consumir por el [proyecto web](https://github.com/npedidos/web).

## Demostración

No disponible, por el momento.

## Despliegue local

### Requisitos

* [Java 17](https://jdk.java.net/archive/)
* [Maven 3.8.6](https://maven.apache.org/download.cgi)
* [MySQL 8](https://dev.mysql.com/downloads/mysql/)
* [Wildfly 26](https://www.wildfly.org/downloads/) (Opcional)

### Empezar a trabajar

**Crear base de datos**

- Ejecutamos el script `npedidos.sql`

**Trabajando en IntelliJ IDEA**

Clonar proyecto:

- `File > New > Project from Version Control`

Comprobar que **maven home path** este indicando ruta del maven local:

- `File > Settings > Build, Execution, Deployment > Build Tools > Maven`

Compilar:

- `Run > Run...`
    - `[clean,install]`: Compila el proyecto.
    - `[clean,install] No Test`: Compila sin ejecutar los test.

Ejecutar aplicación:

- `Run > Run...`
    - `App`

  > Si el usuario y contraseña, de la base de datos, es distinto a `root`, modificar la información de conexión
  > del fichero `src/main/resources/application-runner.properties`

Rellenar la base de datos con registros de prueba:

- `Run > Run...`
    - `db:seed`: Rellenar la base de datos con registros.
    - `db:fresh --seed`: Borrar la base de datos y la rellena con registros.

  > La aplicación debe estar detenida.

Otras configuraciones de RUN:

- `All`: Ejecuta todos los test.
- `API`: Despliega el proyecto en Wildfly.
- `API [clean, install]`: Compila con maven y despliega el proyecto en wildfly.

  > Configurar la ruta del servidor de wildfly.

## Contribuir

Cualquier contribución que hagas será muy apreciada.

- Antes de empezar a codificar, lea las [directrices de contribución](CONTRIBUTING.md).

## Agradecimientos

Gracias a [JetBrains](https://www.jetbrains.com/?from=SoftN%20CMS) por proporcionar una licencia para IntelliJ para
desarrollar este proyecto.

| JetBrains  | IntelliJ                                                                                  |
| ------------- |-------------------------------------------------------------------------------------------|
| ![jetbrains](https://github.com/npedidos/rest-api/blob/master/img/jetbrains.svg "jetbrains") | ![phpstorm](https://github.com/npedidos/rest-api/blob/master/img/intellij.svg "intellij") |

## Licencia

[MIT license](LICENSE).
