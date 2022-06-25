# Proyecto 1: Sistemas Distribuidos - Sockets

Primer proyecto: Los fumadores (LF)

Considerar una plaza en la que hay tres fumadores y un vendedor de los implementos para hacer cigarros.
Cada fumador continuamente arma un cigarro y se lo fuma. Para armar un cigarro, el fumador necesita tres
ingredientes: tabaco, papel y fósforos. Un fumador tiene solamente papel, otro tiene solamente tabaco y el
otro tiene solamente fósforos.
En la plaza existen tres bancos, uno para cada ingrediente. El vendedor coloca aleatoriamente dos
ingredientes diferentes, en dos de los tres bancos de la plaza, un banco para cada ingrediente. Cada
fumador debe buscar los dos ingredientes que le faltan y tomar dos ingredientes del banco en el que esté el
ingrediente. Cuando logra los tres ingredientes, arma un cigarro y fuma durante un tiempo.
Si algún fumador ha intentado conseguir los ingredientes por 2 veces y no lo ha logrado, le pide al vendedor
que coloque los dos ingredientes faltantes en el banco.

La manera como interactúan es así:
1. Los fumadores siempre intentan buscar los dos ingredientes que le faltan de dos bancos.
2. El vendedor aleatoriamente pone dos ingredientes en dos bancos (un fumador podría nunca armar su
cigarro porque no hay los ingredientes suficientes).
3. Si un fumador lleva dos veces intentando conseguir ingredientes, sin lograrlo, pide al vendedor que los
coloque y el vendedor no necesariamente los coloca porque actúa aleatoriamente.
4. Cuando el fumador logra sus tres ingredientes, arma el cigarro, lo fuma y luego retorna a seguir armando
cigarros que es la acción 1: buscar los dos ingredientes que le faltan porque el ingrediente con el que
empezó es infinito y no hace falta reponerlo.
5. Se puede tomar y poner un ingrediente de un tipo por vez. Es decir sólo un proceso puede estar poniendo
o tomando ingredientes.
Se solicita una aplicación (no web) que permita realizar las 5 acciones descritas anteriormente, que esté
compuesta de tres repositorios de ingredientes (bancos), tres aplicaciones cliente (fumadores) y una
aplicación cliente (vendedor)

### Consideraciones generales
Se requiere llevar una traza de movimientos del vendedor y de los 3 fumadores.
Esta traza deben ser archivos texto o xml que tengan
* actor
* acción
* cantidad
* hora de la acción. La hora es la de los repositorios (bancos)

### Funcionamiento
1. Todo empieza con una cantidad de 2 ingredientes de cada tipo en cada banco
2. Los fumadores inician la construcción del cigarro a demanda: es decir que por interfaz usuario o por
comando comienzan a buscar los ingredientes
3. Si no pueden conseguir los dos ingredientes, se lo piden al vendedor que aleatoriamente pondrá 2
ingredientes
4. Los archivos de traza los manejan cada aplicación cliente (fumador y vendedor)
5. La política de elección del ingrediente por el vendedor es aleatoria
6. El tiempo que el vendedor está llenando los ingredientes y el cliente está tomándolos es
configurable, se puede empezar con 2 segundos.

### Arquitectura
* Un servidor que tiene los tres repositorios (bancos) que son tres procesos, de los cuales 2 están
físicamente en el servidor y uno está virtualizado
* Tres fumadores que están 2 en una máquina cliente, 1 en otra máquina cliente
* Un vendedor que está en la máquina cliente donde solo hay un fumador
* En total son tres máquinas: 1 aloja los tres repositorios, las otras dos alojan los clientes

### Plataforma
* Servidor (tres bancos) con Linux / Unix y la virtualización de Linux
* Vendedor y Fumadores (clientes) con Windows
* Comunicación vía sockets
* Lenguaje Java
* Exclusión mutua usando Monitores

### Entregables
* Sistema funcionando.
* Código fuente comentado.
* Algoritmo del manejo de la zona excluida de manera que se entienda la política implementada.
