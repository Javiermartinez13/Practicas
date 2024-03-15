# Aproximación de Pi con Método de Monte Carlo/Practica-3

Este proyecto contiene un programa Java que aproxima el valor de pi utilizando el método de Monte Carlo.

## Funcionamiento del Programa

El programa se compone de dos clases principales: `main` y `mates`.

### Clase `main`

La clase `main` contiene el método `main`, que es el punto de entrada del programa. En este método:

1. Se define el número de muestras (`numSamples`) a utilizar en la aproximación.
2. Se llama al método `approximatePi` de la clase `mates` para obtener la aproximación de pi.
3. Se imprime en consola la aproximación obtenida.

### Clase `mates`

La clase `mates` contiene la lógica para realizar la aproximación de pi utilizando el método de Monte Carlo.

#### Método `approximatePi`

Este método toma como parámetro el número de muestras a generar y devuelve la aproximación de pi. El proceso para obtener la aproximación se realiza de la siguiente manera:

1. Se instancia un generador de números aleatorios (`Random`).
2. Se define una función lambda (`isInsideCircle`) que determina si un punto está dentro del círculo unitario.
3. Se generan las muestras y se cuenta cuántas están dentro del círculo.
4. Se calcula la aproximación de pi utilizando la relación entre los puntos dentro del círculo y el total de muestras.

#### Método `generateSamples`

Este método genera muestras aleatorias y cuenta cuántas de ellas están dentro del círculo unitario. Toma como parámetros el número de muestras a generar, un generador de números aleatorios y una condición que determina si un punto está dentro del círculo.

#### Interfaz Funcional `MontecarloSimulation`

Esta interfaz funcional define un único método `test` que toma las coordenadas x e y de un punto y devuelve `true` si el punto está dentro del círculo y `false` en caso contrario.

## Ejecución del Programa

Para ejecutar el programa:

1. Clona este repositorio en tu máquina local.
2. Abre el proyecto en tu editor de código preferido.
3. Compila y ejecuta la clase `main`.
4. Observa la aproximación de pi obtenida en la consola.

## Requisitos

- Java Development Kit (JDK) instalado en tu sistema.

## Contribuciones

Las contribuciones son bienvenidas. Si encuentras algún error o tienes alguna sugerencia de mejora, no dudes en abrir un problema o enviar un pull request.

