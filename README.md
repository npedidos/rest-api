# NPedidos - REST API

[![DeepSource](https://deepsource.io/gh/npedidos/rest-api.svg/?label=active+issues&show_trend=true&token=Dfu5Zcgrcwn5tDz83zE1QmFe)](https://deepsource.io/gh/npedidos/rest-api/?ref=repository-badge)
[![hacktoberfest issues](https://img.shields.io/github/hacktoberfest/2022/npedidos/rest-api?color=%237259a3&style=flat-square)](https://github.com/npedidos/rest-api/issues?q=is%3Aissue+label%3Ahacktoberfest+is%3Aopen)
[![Build Status](https://img.shields.io/github/workflow/status/npedidos/rest-api/Build%20-%20master?label=Build%20-%20master&style=flat-square)](https://github.com/npedidos/rest-api/actions/workflows/build.yml)
[![Repo size](https://img.shields.io/github/repo-size/npedidos/rest-api?style=flat-square)](https://github.com/npedidos/rest-api)

[![Twitch nmarulo](https://img.shields.io/twitch/status/nmarulo?color=%23A970FF&label=twitch%20nmarulo&style=flat-square)](https://www.twitch.tv/nmarulo)

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

- Ejecutamos el script [npedidos.sql](npedidos.sql)

**Usando postman**

- Puedes hacer un fork a las API en el siguiente enlace:

  [![Run in Postman](https://run.pstmn.io/button.svg)](https://god.gw.postman.com/run-collection/3462094-1245bdc5-f0fc-4a80-b067-33db0095e664?action=collection%2Ffork&collection-url=entityId%3D3462094-1245bdc5-f0fc-4a80-b067-33db0095e664%26entityType%3Dcollection%26workspaceId%3Dfaa3b08b-5495-45eb-a53f-5d832821e4f2#?env%5Bnpedidos%20-%20local%5D=W3sia2V5IjoidXJsIiwidmFsdWUiOiJodHRwOi8vbG9jYWxob3N0OjgwODAvYXBpIiwiZW5hYmxlZCI6dHJ1ZSwidHlwZSI6ImRlZmF1bHQifSx7ImtleSI6InRva2VuIiwidmFsdWUiOiIiLCJlbmFibGVkIjp0cnVlLCJ0eXBlIjoiZGVmYXVsdCJ9XQ==)

**Trabajando en IntelliJ IDEA**

- [Clonar proyecto](#clonar-proyecto)
- [Configurar maven home path](#maven-home-path)
- [Rellenar base de datos](#db-seed)
- [Compilar](#compile)
- [Ejecutar](#run)
- [Iniciar sesión](#login)
- [Otras configuraciones de RUN](#run-configs)
- [Habilitar EditorConfig](#editor-config)
- [Estables opciones de guardado](#on-save)
- [spring-boot-devtools](#spring-boot-devtools)

<a name="clonar-proyecto"></a>
Clonar proyecto:

> File > New > Project from Version Control

<a name="maven-home-path"></a>
Establecer la ruta local de maven:

> File > Settings > Build, Execution, Deployment > Build Tools > Maven
> - maven home path

<a name="compile"></a>
Compilar:

- `Run > Run...`
    - `[clean,install]`: Compila el proyecto.
    - `[clean,install] No Test`: Compila sin ejecutar los test.

<a name="run"></a>
Ejecutar aplicación:

- `Run > Run...`
    - `App`

  > Si el usuario y contraseña, de la base de datos, es distinto a `root`, modificar la información de conexión
  > del fichero `src/main/resources/application-runner.properties`

<a name="db-seed"></a>
Rellenar la base de datos con registros de prueba:

- `Run > Run...`
    - `db:seed`: Rellenar la base de datos con registros.
    - `db:fresh --seed`: Borrar la base de datos y la rellena con registros.

  > La aplicación debe estar detenida.

<a name="login"></a>
Iniciar sesión

- Al ejecutar `db:seed` la contraseña de los usuarios creados es igual al nombre de usuario.

<a name="run-configs"></a>
Otras configuraciones de RUN:

- `All`: Ejecuta todos los test.
- `API`: Despliega el proyecto en Wildfly.
- `API [clean, install]`: Compila con maven y despliega el proyecto en wildfly.

  > Configurar la ruta del servidor de wildfly.

<a name="editor-config"></a>
Habilitar EditorConfig

- Es necesario tener habilitado el soporte de EditorConfig:

  > Settings > Editor > Code Style
  > - Enable Editor Config Support

<a name="on-save"></a>
Establecer acciones de guardado

- Recomiendo tener activado las acciones de guardado:
    - Reformat code
    - Optimize imports

> Settings > Tools > Actions on save

> Tener habilitado EditorConfig.

<a name="spring-boot-devtools"></a>
spring-boot-devtools

- Activar la compilación automática del proyecto:

> Settings > Build, Execution, Development > Compiler
> - Build project automatically

**Ver swagger**

Puedes acceder a la información de la API con swagger en las siguientes URL:

- http://localhost:8080/api/api-docs
- http://localhost:8080/swagger-ui/index.html

Al acceder se te pedirá ingresar un usuario y contraseña.

> Previamente, rellenar la base de datos con datos de pruebas, ya que este proceso creara usuarios con los que puedes
> acceder. Por el momento cualquiera es válido para acceder.

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
