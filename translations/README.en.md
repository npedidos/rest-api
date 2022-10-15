# NPedidos - REST API

[![DeepSource](https://deepsource.io/gh/npedidos/rest-api.svg/?label=active+issues&show_trend=true&token=Dfu5Zcgrcwn5tDz83zE1QmFe)](https://deepsource.io/gh/npedidos/rest-api/?ref=repository-badge)
[![hacktoberfest issues](https://img.shields.io/github/hacktoberfest/2022/npedidos/rest-api?color=%237259a3&style=flat-square)](https://github.com/npedidos/rest-api/issues?q=is%3Aissue+label%3Ahacktoberfest+is%3Aopen)
[![Build Status](https://img.shields.io/github/workflow/status/npedidos/rest-api/Build%20-%20master?label=Build%20-%20master&style=flat-square)](https://github.com/npedidos/rest-api/actions/workflows/build.yml)
[![Repo size](https://img.shields.io/github/repo-size/npedidos/rest-api?style=flat-square)](https://github.com/npedidos/rest-api)

[![Twitch nmarulo](https://img.shields.io/twitch/status/nmarulo?color=%23A970FF&label=twitch%20nmarulo&style=flat-square)](https://www.twitch.tv/nmarulo)
---
📚 Translations: [<img title="Spanish" alt="Spanish" src="https://cdn.staticaly.com/gh/hjnilsson/country-flags/master/svg/es.svg" width="28">](../README.md)

## Description

NPedidos is an application that simplifies the management of food orders.

This project provides the necessary resources: [proyecto web](https://github.com/npedidos/web).

## Demonstration

Not yet available.

## Local deployment

- [prerequisites](#prerequisites)
- [How to get started](#empezar-a-trabajar)
    - [Create the Database](#create-database)
    - [Use Postman](#using-postman)
    - [Working in IntelliJ IDEA](#working-ingellij)
    - [Access Swagger](#access-swagger)

### prerequisites

* [Java 17](https://jdk.java.net/archive/)
* [Maven 3.8.6](https://maven.apache.org/download.cgi)
* [MySQL 8](https://dev.mysql.com/downloads/mysql/)
* [Wildfly 26](https://www.wildfly.org/downloads/) (Optional)

<a name="empezar-a-trabajar"></a>
### How to get started

<a name="create-database"></a>
**Create the Database**

- Run the script [npedidos.sql](../npedidos.sql)

<a name="using-postman"></a>
**Use Postman**

- You can fork the APIs at the following link:

  [![Run in Postman](https://run.pstmn.io/button.svg)](https://god.gw.postman.com/run-collection/3462094-1245bdc5-f0fc-4a80-b067-33db0095e664?action=collection%2Ffork&collection-url=entityId%3D3462094-1245bdc5-f0fc-4a80-b067-33db0095e664%26entityType%3Dcollection%26workspaceId%3Dfaa3b08b-5495-45eb-a53f-5d832821e4f2#?env%5Bnpedidos%20-%20local%5D=W3sia2V5IjoidXJsIiwidmFsdWUiOiJodHRwOi8vbG9jYWxob3N0OjgwODAvYXBpIiwiZW5hYmxlZCI6dHJ1ZSwidHlwZSI6ImRlZmF1bHQifSx7ImtleSI6InRva2VuIiwidmFsdWUiOiIiLCJlbmFibGVkIjp0cnVlLCJ0eXBlIjoiZGVmYXVsdCJ9XQ==)

<a name="working-ingellij"></a>
**Working in IntelliJ IDEA**

- [Clone project](#clonar-proyecto)
- [Configure maven home path](#maven-home-path)
- [Fill database](#db-seed)
- [Compile](#compile)
- [Execute](#run)
- [Login](#login)
- [other run configurations](#run-configs)
- [Enable EditorConfig](#editor-config)
- [Enable save options](#on-save)
- [spring-boot-devtools](#spring-boot-devtools)

<a name="clonar-proyecto"></a>
Clone project:

> File > New > Project from Version Control

<a name="maven-home-path"></a>
Set the maven home path:

> File > Settings > Build, Execution, Deployment > Build Tools > Maven
> - maven home path

<a name="compile"></a>
Compile:

- `Run > Run...`
    - `[clean,install]`: Compile the project.
    - `[clean,install] No Test`: Compile without running tests.

<a name="run"></a>
Start the app:

- `Run > Run...`
    - `App`

  > If the username and password from the database is different from `root`, modify the connection information
  > from the `src/main/resources/application-runner.properties` file

<a name="db-seed"></a>
Populate the database with test records:

- `Run > Run...`
    - `db:seed`: Populate the database with test records
    - `db:fresh --seed`: Clear the database and fill it with records.

  > The application must be stopped.

<a name="login"></a>
Login

- When running `db:seed` the password of the created users is equal to the username.

<a name="run-configs"></a>
Other run configurations:

- `All`: run all the tests
- `API`: Deploy the project to Wildfly.
- `API [clean, install]`: Compile with maven and deploy the project to wildfly.

  > Configure wildfly server path.

<a name="editor-config"></a>
Enable EditorConfig

- You need to have EditorConfig support enabled:

  > Settings > Editor > Code Style
  > - Enable Editor Config Support

<a name="on-save"></a>
Enable save options

- I recommend having save actions enabled:
    - Reformat code
    - Optimize imports

> Settings > Tools > Actions on save

> Have editorConfig enabled.

<a name="spring-boot-devtools"></a>
spring-boot-devtools

- Activate the automatic compilation of the project:

> Settings > Build, Execution, Development > Compiler
> - Build project automatically

<a name="access-swagger"></a>
**Access swagger**

You can access the API information with swagger at the following URLs:

- http://localhost:8080/api/api-docs
- http://localhost:8080/swagger-ui/index.html

When accessing you will be asked to enter a username and password.

> Before that, fill the database with test data, since this process will create users with whom you can
> access. At the moment anyone is valid to access.

## Contribute

Any contribution you make will be greatly appreciated.

- Before you start contributing, read the [contribution guidelines](../CONTRIBUTING.md).

## Thank you

Thanks to [JetBrains](https://www.jetbrains.com/?from=SoftN%20CMS) for providing a license for IntelliJ for
developing this project.

| JetBrains  | IntelliJ                                                                                  |
| ------------- |-------------------------------------------------------------------------------------------|
| ![jetbrains](https://github.com/npedidos/rest-api/blob/master/img/jetbrains.svg "jetbrains") | ![phpstorm](https://github.com/npedidos/rest-api/blob/master/img/intellij.svg "intellij") |

## License

[MIT license](../LICENSE).
