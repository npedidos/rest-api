# NPedidos - REST API

[![DeepSource](https://deepsource.io/gh/npedidos/rest-api.svg/?label=active+issues&show_trend=true&token=Dfu5Zcgrcwn5tDz83zE1QmFe)](https://deepsource.io/gh/npedidos/rest-api/?ref=repository-badge)
[![hacktoberfest issues](https://img.shields.io/github/hacktoberfest/2022/npedidos/rest-api?color=%237259a3&style=flat-square)](https://github.com/npedidos/rest-api/issues?q=is%3Aissue+label%3Ahacktoberfest+is%3Aopen)
[![Build Status](https://img.shields.io/github/workflow/status/npedidos/rest-api/Build%20-%20master?label=Build%20-%20master&style=flat-square)](https://github.com/npedidos/rest-api/actions/workflows/build.yml)
[![Repo size](https://img.shields.io/github/repo-size/npedidos/rest-api?style=flat-square)](https://github.com/npedidos/rest-api)

[![Twitch nmarulo](https://img.shields.io/twitch/status/nmarulo?color=%23A970FF&label=twitch%20nmarulo&style=flat-square)](https://www.twitch.tv/nmarulo)

## Descripción / Description

NPedidos es una aplicación que permite la gestión simple de pedidos de menús de comidas, por fechas.

Este proyecto proporciona los recursos a consumir por el [proyecto web](https://github.com/npedidos/web).

<br /> 

NPedidos is an application that simplifies the management of food orders.

This project provides the neccessary resources: [proyecto web](https://github.com/npedidos/web).

## Demostración / Demonstration

No disponible, por el momento.

Not yet available.

## Despliegue local / Local deployment

### Requisitos / prerequisites

* [Java 17](https://jdk.java.net/archive/)
* [Maven 3.8.6](https://maven.apache.org/download.cgi)
* [MySQL 8](https://dev.mysql.com/downloads/mysql/)
* [Wildfly 26](https://www.wildfly.org/downloads/) (Opcional)

### Empezar a trabajar / How to get started

**Crear base de datos** / **Create the Database**

- Ejecutamos el script [npedidos.sql](npedidos.sql) / Run the script [npedidos.sql](npedidos.sql)

**Usando postman** / **Use Postman**

- Puedes hacer un fork a las API en el siguiente enlace: / You can fork the APIs at the following link:

  [![Run in Postman](https://run.pstmn.io/button.svg)](https://god.gw.postman.com/run-collection/3462094-1245bdc5-f0fc-4a80-b067-33db0095e664?action=collection%2Ffork&collection-url=entityId%3D3462094-1245bdc5-f0fc-4a80-b067-33db0095e664%26entityType%3Dcollection%26workspaceId%3Dfaa3b08b-5495-45eb-a53f-5d832821e4f2#?env%5Bnpedidos%20-%20local%5D=W3sia2V5IjoidXJsIiwidmFsdWUiOiJodHRwOi8vbG9jYWxob3N0OjgwODAvYXBpIiwiZW5hYmxlZCI6dHJ1ZSwidHlwZSI6ImRlZmF1bHQifSx7ImtleSI6InRva2VuIiwidmFsdWUiOiIiLCJlbmFibGVkIjp0cnVlLCJ0eXBlIjoiZGVmYXVsdCJ9XQ==)
  
**Trabajando en IntelliJ IDEA** / Working in IntelliJ IDEA

- [Clonar proyecto / Clone project](#clonar-proyecto)
- [Configurar maven home path / Configure maven home path](#maven-home-path)
- [Rellenar base de datos / Fill database](#db-seed)
- [Compilar / Compile](#compile)
- [Ejecutar / Execute](#run)
- [Iniciar sesión / Login](#login)
- [Otras configuraciones de RUN / other run configurations](#run-configs)
- [Habilitar EditorConfig / Enable EditorConfig](#editor-config)
- [Estables opciones de guardado / Enable save options](#on-save)
- [spring-boot-devtools](#spring-boot-devtools)

<a name="clonar-proyecto"></a>
Clonar proyecto / Clone project:

> File > New > Project from Version Control

<a name="maven-home-path"></a>
Establecer la ruta local de maven / Set the maven home path:

> File > Settings > Build, Execution, Deployment > Build Tools > Maven
> - maven home path

<a name="compile"></a>
Compilar / Compile:

- `Run > Run...`
    - `[clean,install]`: Compila el proyecto / Compile the project.
    - `[clean,install] No Test`: Compila sin ejecutar los test / Compile without running tests.

<a name="run"></a>
Ejecutar aplicación / Start the app:

- `Run > Run...`
    - `App`

  > Si el usuario y contraseña, de la base de datos, es distinto a `root`, modificar la información de conexión
  > del fichero `src/main/resources/application-runner.properties`
  
   > If the username and password from the database is different from `root`, modify the connection information
   > from the `src/main/resources/application-runner.properties` file

<a name="db-seed"></a>
Rellenar la base de datos con registros de prueba: / Populate the database with test records:

- `Run > Run...`
    - `db:seed`: Rellenar la base de datos con registros. / Populate the database with test records
    - `db:fresh --seed`: Borrar la base de datos y la rellena con registros. / Clear the database and fill it with records.

  > La aplicación debe estar detenida. / The application must be stopped.

<a name="login"></a>
Iniciar sesión / Login

- Al ejecutar `db:seed` la contraseña de los usuarios creados es igual al nombre de usuario.
- When running `db:seed` the password of the created users is equal to the username.

<a name="run-configs"></a>
Otras configuraciones de RUN: / Other run configurations:

- `All`: Ejecuta todos los test. / run all the tests
- `API`: Despliega el proyecto en Wildfly. / Deploy the project to Wildfly.
- `API [clean, install]`: Compila con maven y despliega el proyecto en wildfly. / Compile with maven and deploy the project to wildfly.

  > Configurar la ruta del servidor de wildfly. / Configure wildfly server path.

<a name="editor-config"></a>
Habilitar EditorConfig / Enable EditorConfig

- Es necesario tener habilitado el soporte de EditorConfig: / You need to have EditorConfig support enabled:

  > Settings > Editor > Code Style
  > - Enable Editor Config Support

<a name="on-save"></a>
Establecer acciones de guardado / Enable save options

- Recomiendo tener activado las acciones de guardado: / I recommend having save actions enabled:
    - Reformat code
    - Optimize imports

> Settings > Tools > Actions on save

> Tener habilitado EditorConfig. / Have editorConfig enabeld.

<a name="spring-boot-devtools"></a>
spring-boot-devtools

- Activar la compilación automática del proyecto: / Activate the automatic compilation of the project:

> Settings > Build, Execution, Development > Compiler
> - Build project automatically

**Ver swagger** / **Watch swagger**

Puedes acceder a la información de la API con swagger en las siguientes URL: / You can access the API information with swagger at the following URLs:

- http://localhost:8080/api/api-docs
- http://localhost:8080/swagger-ui/index.html

Al acceder se te pedirá ingresar un usuario y contraseña. / When accessing you will be asked to enter a username and password. 

> Previamente, rellenar la base de datos con datos de pruebas, ya que este proceso creara usuarios con los que puedes
> acceder. Por el momento cualquiera es válido para acceder.

> Before that, fill the database with test data, since this process will create users with whom you can
> access. At the moment anyone is valid to access.

## Contribuir / Contribute 

Cualquier contribución que hagas será muy apreciada. / Any contribution you make will be greatly appreciated.

- Antes de empezar a codificar, lea las [directrices de contribución](CONTRIBUTING.md). / Before you start contributing, read the [contribution guidelines](CONTRIBUTING.md).

## Agradecimientos / Thank you

Gracias a [JetBrains](https://www.jetbrains.com/?from=SoftN%20CMS) por proporcionar una licencia para IntelliJ para
desarrollar este proyecto. / Thanks to [JetBrains](https://www.jetbrains.com/?from=SoftN%20CMS) for providing a license for IntelliJ for
developing this project.

| JetBrains  | IntelliJ                                                                                  |
| ------------- |-------------------------------------------------------------------------------------------|
| ![jetbrains](https://github.com/npedidos/rest-api/blob/master/img/jetbrains.svg "jetbrains") | ![phpstorm](https://github.com/npedidos/rest-api/blob/master/img/intellij.svg "intellij") |

## Licencia / License

[MIT license](LICENSE).
