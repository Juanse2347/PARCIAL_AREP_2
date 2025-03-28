## Parcial 2do Tercio -Ejercicios de Diseño ##

Enunciado
La factorización de números enteros es un problema complejo para el cual no se conocen algoritmos clásicos eficientes. La criptografía clásica está soportada en la dificultad para encontrar los factores primos de números grandes.

Diseñe, construya y despliegue un aplicación web para investigar los factores de números enteros y los números primos. El programa debe estar desplegado en tres máquinas virtuales de EC2 de AWS como se describe abajo. Las tecnologías usadas en la solución deben ser maven, git, github, Spring, html5, y js. No use liberías adicionales.


## Problema ##
Diseñe un prototipo de sistema de microservicios que tenga un servicio (En la figura se representa con el nombre Math Services) para computar las funciones numéricas.  El servicio de las funciones numéricas debe estar desplegado en al menos dos instancias virtuales de EC2. Adicionalmente, debe implementar un service proxy que reciba las solicitudes de llamado desde los clientes  y se las delega a las dos instancias del servicio numérico usando un algoritmo de round-robin. El proxy deberá estar desplegado en otra máquina EC2. Asegúrese que se pueden configurar las direcciones y puertos de las instancias del servicio en el proxy usando variables de entorno del sistema operativo.  Finalmente, construya un cliente Web mínimo con un formulario que reciba el valor y de manera asíncrona invoke el servicio en el PROXY. Puede hacer un formulario para cada una de las funciones. El cliente debe ser escrito en HTML y JS

![image](https://github.com/user-attachments/assets/54699b0d-7162-48b7-a6a0-d9a15792a8d8)


Sobre las funciones numéricas:
Sus servicios matemáticos deben incluir dos funciones. 
- Una para calcular los factores de un número: factors(n) retorna un json con una lista de números enteros positivos. (Recibe solo enteros positivos)
- Una para calcular los números primos hasta un número dado: primes(n), retorna en un json los números primos menores o iguales a n.


PARA AMBAS IMPLEMENTACIONES USE UN ALGORITMO  DE FUERZA BRUTA, ES DECIR EXPLORE CADA UNO DE LOS VALORES. Usted debe implemntar las dos funciones, no debe usar funciones de una librería o del API (si ya existen).

Por ejemplo, para un  número dado n los factores se pueden calcular así:
- 1 es un factor de todos los números
- de ahí en adelante simplemente mirando el módulo puede verificar si es o no factor.
- Puede mirar todos los numeros hasta n/2
- n pertenece también a los factores.


Para los primos, puede usar su función de factores así:

- 1 es un número primo
- de ahí en adelante recuerde que un número es primo si solo es divisible por 1 y por si mismo.
- Es decir un número es primo si el tamaño del conjunto de factores es 2.

## 🚀 Instalación y Ejecución
### 1️⃣ Clonar el repositorio
```bash
git clone https://github.com/Juanse2347/PARCIAL_AREP_2
cd PARCIAL_AREP_2
```

### 2️⃣ Compilar el proyecto con Maven
```bash
mvn clean install
```

![Image](https://github.com/user-attachments/assets/9a3392f2-fd28-4615-bfa2-ea5b9fdf9c00)


### 3️⃣ Ejecutar el servidor 

```bash
mvn clean compile exec:java -Dexec.mainClass="edu.eci.arep.MathService"
```

![image](https://github.com/user-attachments/assets/09ec92c3-aca2-4fb1-8380-e1f1e949a505)



### 4️⃣ Probar con un navegador o `curl`
```bash
http://localhost:8000/primes?value=100
```

![image](https://github.com/user-attachments/assets/3a6d771d-6705-4e48-9639-7a7cf8d8ba46)



Al colocarlo en el navegador vamos a obtener lo siguiente:

![image](https://github.com/user-attachments/assets/81b92aa7-4486-4c14-8e4a-889eeb69fe60)


## 🚀 Despliegue AWS

Creamos la instancia en AWS EC2.

![image](https://github.com/user-attachments/assets/5a3748dc-4195-429e-a7ce-c7a4c4526133)


Desplegamos nuestro codigo en AWS

1. Subimos el proyecto a AWS

```bash
scp -i key.pem target/app.jar ec2-user@IP_EC2:/home/ec2-user/
```

![image](https://github.com/user-attachments/assets/ab4df350-7bec-4fb3-87e0-a576f76c1025)


2. Conectamos a nuestra instancia EC2

```bash
ssh -i key.pem ec2-user@IP_EC2
```

3. Ejecutamos la aplicacion 

```bash
java -jar /home/ec2-user/app.jar
```

4. Y para finalizar accedemos a la aplicacion

```bash
http://EC2_PUBLIC_IP:8000/primes?value=100
```

Que se veria de la siguiente manera

Me falto subir la instancia en AWS.

![image](https://github.com/user-attachments/assets/f5fb9839-94e8-40f2-9261-289c019562fa)


## Clase que nos dice si son primos o no ##

![image](https://github.com/user-attachments/assets/aa015c0b-dbab-45a1-9a75-b8fb6bd1e384)


## Formato de respuesta en JSON ##

![image](https://github.com/user-attachments/assets/f3dd318f-6b6d-4edd-b4ff-d32ea4a19599)

