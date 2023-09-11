# Dalton el Aventurero

Videojuego de clases con Java. 

## Pre-requisitos

Antes de comenzar, se debe tener instalado lo siguiente:

- Java JDK 17.0.7 o superior.
- Gradle 8.3 o superior (si no está incluido en tu IDE).
- Visual Studio Code (u otro IDE de tu preferencia).
- JavaFX SDK para tu plataforma 17.0.8 o superior.
- (Opcional) Scene Builder para JavaFX.

## Configuración del Entorno

### Instalación de Java y Gradle

1. Descarga e instala Java JDK desde [Oracle JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) o una versión similar.
2. Instala Gradle siguiendo las instrucciones en [Gradle Installation](https://gradle.org/install/).

### Configuración de JavaFX y Scene Builder en VSCode

1. Descarga JavaFX SDK desde [OpenJFX](https://gluonhq.com/products/javafx/).
2. Descomprime el archivo en una ubicación deseada.
3. (Opcional) Descarga e instala Scene Builder desde [Gluon Scene Builder](https://gluonhq.com/products/scene-builder/).

### Plugins de VSCode

Instala los siguientes plugins en VSCode:

- Extension Pack for Java
- JavaFX Extension

## Configuración del Proyecto

Clona el repositorio y abre el proyecto en VSCode.

### Configuración de JavaFX

1. Configura la variable de entorno `PATH_TO_FX` para apuntar al directorio `lib` del JavaFX SDK descargado.
2. Agrega el JavaFX SDK como una biblioteca en tu IDE. En VSCode, puedes hacer esto editando tu archivo de configuración `launch.json` para incluir el siguiente argumento en `vmArgs`:

    ```json
    {
        "type": "java",
        "name": "Debug Launch-DaltonGame",
        "request": "launch",
        "mainClass": "org.openjfx.MainApp",
        "vmArgs": "--module-path ${env:PATH_TO_FX} --add-modules javafx.controls,javafx.fxml",
        "projectName": "DaltonGame.app"
    }
    ```

## Ejecución del Proyecto

Para ejecutar el proyecto, puedes usar Gradle desde la línea de comandos:

```shell
./gradlew run
