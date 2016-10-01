# fiuba.tda.tps

======================
Estadistico de Orden K
======================

Descripcion
-----------

El estadistico de orden k de un conjunto de n elementos es el el k-esimo elemento mas pequenio. Son casos particulares de estos el maximo (k = n-1), el mŒ·ŒıŒ·nimo (k = 0) y la mediana de un conjunto (k = n/2). Se propone analizar varios algoritmos que computan este valor.

1. Fuerza bruta: se implementa un verificador que dado un conjunto y un candidato devuelve un booleano indicando si el valor indicado es el k elemento mas pequenio. El algoritmo de fuerza bruta itera todos los elementos del conjunto y verifica de a uno si es la solucion. Una vez el verificador devuelve true, devuelve ese elemento.

2. Ordenar y seleccionar: ordena el conjunto mediante un algoritmo veloz de comparacion y luego seleccionar el k elemento del arreglo ordenado.

3. k-selecciones: el algoritmo de ordenamiento por seleccion busca el menor elemento de una secuencia y lo intercambia con el primero. Se propone realizar k selecciones para encontrar el k elemento mas pequeÒo.

4. k-heapsort: asi como heapsort es una mejora del algoritmo de seleccion usando un heap, este algoritmo mejora el de k-selecciones haciendo k extracciones a un arreglo con la propiedad de heap.

5. HeapSelect: se propone usar un heap para almacenar los k elementos mas chicos, intercambiandolos cuando sea necesario.

6. QuickSelect (Cormen cap. 10): se usa una estrategia de division y conquista similar a la de quicksort pero descartando las divisiones que sabemos que no incluyen al k buscado.

Requisitos Minimos
------------------

* Java SDK 1.7.0_51
* Apache Maven 3.2.1


Compilacion y Ejecucion
-----------------------

1. Desde una terminal dirigirse a {path_usuario}/EstadisticoDeOrdenK, donde path_usuario es el directorio del usuario en donde se encuentra desomprimido el proyecto.

2. Ejecutar el comando mvn package.

3. Ejecutar el comando java -jar target/EstadisticoDeOrdenK-1.0.0.jar ALGORITMO K VECTOR (ver Ayuda)

Ayuda 
-----

Uso:
        java -jar EstadisticoDeOrdenK.jar ALGORITMO K VECTOR

Parametros:
        ALGORITMO: Algoritmo de ejecucion del estadistico
                fb: Fuerza Bruta
                hs: Heap Select
                kh: K Heapsort
                ks: K Selecciones
                os: Ordenar y Seleccionar
                qs: Quick Select

        K: Candidato (para fb) / Orden del algoritmo (para el resto)

        VECTOR: Vector a aplicar el algoritmo

Ejemplo:
        java -jar EstadisticoDeOrdenK.jar fb 0 "3 5 89 55 164 42 0 77 911 22"
        java -jar EstadisticoDeOrdenK.jar hs 4 "3 5 89 55 164 42 0 77 911 22"


