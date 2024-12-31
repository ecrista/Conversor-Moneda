# Conversor de monedas
Reto de Alura Latam para convertir divisas usando una API que brinda siempre informacion actualizada

## Descripción
Este proyecto es una solución para el reto de Alura Latam que consiste en crear un conversor de monedas usando java. El objetivo es consumir una API para poder realizar la conversion de divisas que solicite el usuario.

## Contenido del repositorio
Este repositorio contiene el código fuente del proyecto, organizado en los siguientes paquetes y archivos:

* **modelos**: Contiene la clase necesia para poder realizar la consulta a la API y las demas operaciones para realizar el cambio de divisa y guardar los registros de todas las consultas realizadas en un archivo de texto.
* **principal**: Contiene la funcion principal donde se encuentra el menu de la interfaz de usuario y el llamado de las funciones para realizar la consulta.
* **records**: Contiene el record para almacenar la informacion necesaria del json que nos regresa la API al consultarla.
* **README.md**: Este archivo de lectura.
* **index.html**: La estructura html.

## Requisitos previos
Para ejecutar este proyecto, se requiere:

* Instalar java
* Mandar a llamar la libreria Gson 2.11.0.


## Uso
Para utilizar el encriptador y desencriptador, sigue los siguientes pasos:

1. Abre el proyecto en un IDE que pueda ejecutar java.
2. ingresar al paquete `principal` ejecute el archivo Principal.class
3. Selecciona una opcion del menu que se muestra en consola.
4. Ingresa la cantidad de dinero que quieres convertir.
5. Si se desea salir del programa ingrese el numero 0.
6. Se puede puede consultar el historial de conversiones realizadas ingresando el numero 15.
7. Por cada consulta que se realiza se guarda un registro en un archivo que se genera llamado `api_divisas_log.txt`

## Autor
Este proyecto fue creado por Cesar Moises Arteaga German.

## Agradecimientos
Agradezco a Alura Latam por proporcionar este reto y la oportunidad de desarrollar mis habilidades en programación.
## API Reference

#### Consultar conversion_rates

```http
  GET https://v6.exchangerate-api.com/v6/YOUR-API-KEY/latest/{base_code}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `YOUR-API-KEY` | `string` | **requerido**. Tu API KEY |
|`base_code`|`string`| Iniciales de la moneda que deseas consultar ej. (USD)|



