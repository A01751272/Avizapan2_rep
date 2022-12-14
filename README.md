# Guía de descarga Avizapán
## Especificaciones
**Grupo 401 - Equipo 4**  
Este proyecto fue desarrollado utilizando el IDE [Android Studio Chipmunk | 2021.2.1 Patch 2](https://androidstudio.googleblog.com/2022/08/android-studio-chipmunk-202121-patch-2.html) y el lenguaje de programación [Kotlin 1.6.10](https://kotlinlang.org/docs/whatsnew16.html). En este archivo se encuentran los pasos a seguir para realizar la descarga de la aplicación Avizapán en dichas versiones.  

Esta aplicación está desarrollada para dispositivos con sistema operativo Android, mayor o igual al 5.0. Para determinar la versión de Android de su dispositivo, haga click [aquí](https://support.google.com/android/answer/7680439?hl=es-419).  

Para descargar esta aplicación en una computadora de escritorio o *laptop*, es necesario contar con Android Studio. Haga click [aquí](https://developer.android.com/studio).

Cualquier duda referente al funcionamiento de la aplicación, favor de consultar el [manual de usuario](https://docs.google.com/presentation/d/1C-_D4tdvXKTrwFN7aKiA2XmHQJuNd4JwOWqlv-QIPps/edit?usp=sharing).

## Descarga para Windows
1. Ingresa al [repositorio en github](https://github.com/A01751272/Avizapan2_rep) en tu computadora.
2. Dirige tu cursor hacia la parte superior de la pantalla, y pulsa el botón verde llamado **Código**
3. Al desplegarse la ventana emergente, haz click en **Descargar ZIP**. Recuerda que esto descargará la última versión disponible en el repositorio de la aplicación hasta el momento de la descarga.
4. Especifica en tu computadora el directorio en el que deseas guardar el proyecto. Recomendamos que la descarga se haga en el directorio que utiliza Android Studio por defecto, ya que esto agiliza el proceso de abrirlo de forma local.
5. En tu computadora, abre el explorador de archivos, y dirígete al directorio en donde descargaste el proyecto. Da click derecho sobre el .zip y da click en **Extraer todo...**. Pulsa **Extraer** en la ventana emergente y espera a que se realice la operación. Cuando esté listo, se mostrará una carpeta en tu directorio con el nombre *Avizapan2_rep-master*
6. Abre Android Studio, y cierra cualquier proyecto que aparezca, si es necesario.
7. Da click en **Abrir**, y dirígete al directorio en donde descargaste el proyecto. Selecciona el proyecto que acabas de descargar, este deberá tener un ícono de Android verde a la izquierda del nombre. Después, da click en **Aceptar**.
8. Espera a que los archivos del proyecto carguen correctamente. En la parte inferior derecha podrás consultar el estado de descarga de los archivos.
9. En la parte superior izquierda de la pantalla encontrarás una pestaña llamada **Proyecto**, en donde se encuentran los archivos del mismo. Da click sobre la flecha a la izquierda de **Gradle Scripts**. Verás que se despliegan varios archivos de configuración.
10. Haz doble click sobre el archivo **local.properties**, y espera a que abra.
11. Reemplaza la línea 8 con la siguiente línea de código: `sdk.dir=[unidad]\:\\Users\\[usuario]\\AppData\\Local\\Android\\Sdk`  
12. Reemplaza [usuario] por el de tu computadora. Reemplaza [unidad] por *C* o *D*, dependiendo en donde hayas instalado Android Studio.
13. Conecta tu dispositivo móvil con sistema operativo Android > 5.0 a la computadora, utilizando el cable de carga. **Nota:** Para descargar la aplicación en tu dispositivo, es necesario [activar el modo desarrollador](https://developer.android.com/studio/debug/dev-options?hl=es-419#:~:text=Si%20quieres%20habilitar%20las%20Opciones,del%20dispositivo%20%3E%20N%C3%BAmero%20de%20compilaci%C3%B3n).
14. Espera hasta que tu dispositivo aparezca en la parte superior de la pantalla, a la izquierda del botón verde **Run app**.
15. Una vez que la computadora haya detectado el dispositivo, corre la aplicación con el botón mencionado anteriormente. La aplicación deberá descargarse y abrirse en el dispositivo conectado.

