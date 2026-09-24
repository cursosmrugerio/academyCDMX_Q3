# Índice por pregunta — exámenes mixtos

Clasifica **pregunta por pregunta** los 8 exámenes que mezclan temas, para poder estudiar solo APX o solo Java sin partir ningún archivo. Los exámenes se copiaron enteros y sin modificar a `CLASIFICADOR/` (columna «Archivo»).

## Criterio de tema

| Tema | Incluye |
|---|---|
| **APX** | Arquitectura APX y su ecosistema BBVA: componentes (transacción, librería, DTO, job), APX CLI, Operation Console, utilidades (JDBC Utility, APIConnector…), normas APX (acceso a datos, logs, nomenclatura, UUAA, NMM), antipatrones de librería que enseña el curso (Blob, Contenedor Mágico), y **Spring Batch** como base de APX Batch. |
| **Java** | Lenguaje, JDK y API estándar (incluido JDBC de `java.sql`), POO, excepciones, JUnit y Mockito. |
| **Herramientas/general** | Git/Gitflow, Maven, Bash/Windows, Jenkins, Jira, SonarQube, Artifactory, Postman, JBoss, OSGi, HTTP/servicios web, bases de datos, SemVer y retrocompatibilidad genérica, patrones de diseño genéricos (Singleton, Command, Composite, State…). |

Con este criterio los porcentajes difieren de los del informe del verificador de la ronda 2 de la clasificación de archivos, que contaba Spring Batch, niveles de log y buenas prácticas de BD como «generales». La categoría de cada archivo no cambia.

## Resumen

| Examen | Archivo | Preguntas | APX | Java | Herramientas/general |
|---|---|---|---|---|---|
| Java.pdf | `java/Java.pdf` | 213 | 38 (18%) | 134 (63%) | 41 (19%) |
| 01 - Simulación APX V1.docx | `java/01 - Simulación APX V1.docx` | 45 | 9 (20%) | 23 (51%) | 13 (29%) |
| 02 - Simulación APX V2.docx | `java/02 - Simulación APX V2.docx` | 45 | 15 (33%) | 19 (42%) | 11 (24%) |
| 01 - Quiz APX.docx | `java/01 - Quiz APX.docx` | 22 | 6 (27%) | 8 (36%) | 8 (36%) |
| 02 - Quiz Desarrollo APX 1.docx | `java/02 - Quiz Desarrollo APX 1.docx` | 25 | 11 (44%) | 12 (48%) | 2 (8%) |
| 03 - Quiz Desarrollo APX 2.docx | `java/03 - Quiz Desarrollo APX 2.docx` | 24 | 4 (17%) | 14 (58%) | 6 (25%) |
| 07 - Diagnóstico APX 5.docx | `apx/examenes/07 - Diagnóstico APX 5.docx` | 85 | 61 (72%) | 22 (26%) | 2 (2%) |
| Examen Diagnóstico APX 4.pdf | `apx/examenes/Examen Diagnóstico APX 4.pdf` | 21 | 12 (57%) | 7 (33%) | 2 (10%) |
| **Total** | | **480** | **156** | **239** | **85** |

## Cómo se hizo y límites

- **Extracción:** `Java.pdf` desde su texto (separado por la numeración de las preguntas); simulaciones V1/V2 y quizzes de Educaplay desde los JSON de la extracción (`_datos-extraccion/`); `07` desde el .docx; APX 4 desde el OCR de sus imágenes, revisando las páginas dudosas a ojo.
- **Clasificación:** manual, leyendo cada enunciado con sus opciones. Las preguntas cuyo código está solo en imagen se clasificaron como Java por sus opciones; los verificadores miraron una muestra amplia de esas imágenes y todas eran Java.
- **Recorte:** el enunciado aparece **recortado a 110 caracteres** solo para identificar la pregunta; el texto completo y las opciones están en el archivo original. El registro completo, una fila por pregunta, está en `_verificacion/indice-preguntas.tsv`.
- **Sin referencias cruzadas por pregunta:** se probó una columna «también en» (la misma pregunta en otro examen) calculada por similitud de texto, pero la verificación encontró enlaces falsos y muchas omisiones, así que se retiró. Las relaciones entre exámenes que sí están verificadas se indican en la nota de cada examen.
- **Verificación:** dos rondas de verificador independiente (una a ciegas, que coincidió en el tema de todas las preguntas, y una adversarial). Informes en `_verificacion/`.

## Casos límite

Preguntas donde el criterio decide, pero por poco. Si prefieres otra frontera, estas son las que cambiarían:

| Decisión tomada | Preguntas |
|---|---|
| Definición genérica de «patrón de diseño» → Herramientas/general, aunque aparezca en la sección APX | 07 #11 · Quiz Desarrollo APX 1 #19 · APX 4 #8 |
| Paginación en aplicaciones web (sin mencionar APX) → Herramientas/general | V2 #4 · Java.pdf #69 |
| DTO «en el diseño de software», ACID, CRUD (sin mencionar APX) → Herramientas/general | Java.pdf #173, #194, #198 |
| DTO en un quiz de desarrollo APX («si un DTO cambia… serial versión») → APX | Quiz Desarrollo APX 2 #22 |
| Singleton dentro de la sección JAVA → Herramientas/general | 07 #78 |
| pom.xml sin concepto APX → Herramientas/general | APX 4 #1 · Quiz Desarrollo APX 1 #15 |
| Retrocompatibilidad genérica → Herramientas/general; de una transacción o de sus campos de entrada/salida → APX | Genérica: V2 #29, Java.pdf #122, #171 · Transacción: Quiz APX #22, 07 #50 (por la sección APX y los campos de entrada/salida; el enunciado no dice «transacción») |
| Norma APX sobre un concepto genérico → APX | Acceso a datos encapsulado: V2 #18, #41, Java.pdf #98, #147 · Variables bind, @SuppressWarnings, niveles de log, ROWNUM: 07 #8, #33, #36–41, #61 · Herramientas para desarrollar componentes APX: V2 #16, Java.pdf #91 |
| «BLOB» cuya respuesta es el antipatrón Blob del curso → APX | V2 #40 · Java.pdf #142 |

## Java.pdf

`java/Java.pdf` — Resuelto: la respuesta correcta va marcada (resaltado verde y/o ✅), casi siempre con justificación; 30 preguntas solo traen el resaltado verde. Numeración propia del PDF (1–212) más una pregunta sin número, listada como **126b**. La #75 no es de opción múltiple (trae el resultado, 13) y el enunciado de la #191 es una descripción en texto de una imagen.

| # | Tema | Ubicación | Enunciado (recorte) |
|---|---|---|---|
| 1 | Java | pág 1 | ¿Cuáles son los tipos de excepciones en Java? a. Throwable b. Object c. Checked d. Unchecked e. Todas las opci… |
| 2 | Herramientas/general | pág 2 | ¿Cuáles de los siguientes comandos de Git se utilizan para gestionar ramas en un repositorio? Selecciona todas… |
| 3 | Herramientas/general | pág 3 | En el contexto del versionado semántico (Semantic Versioning), si un desarrollador cambia la versión de una bi… |
| 4 | Herramientas/general | pág 4 | ¿Cuál de los siguientes componentes es parte de una solicitud HTTP? a. Headers, scripts, funciones. b. URL, co… |
| 5 | Herramientas/general | pág 5 | ¿Cuál de las siguientes opciones describe correctamente un servicio web (web service)? a. Una aplicación o com… |
| 6 | Java | pág 6 | ¿Cuál de las siguientes afirmaciones sobre el ciclo for mejorado introducido en Java 5 es verdadera? a. El cic… |
| 7 | Herramientas/general | pág 7 | ¿Cuál de las siguientes características es fundamental en una base de datos relacional? a. Almacenamiento de d… |
| 8 | APX | pág 8 | ¿Cuál es el archivo utilizado para agregar la dependencia del JDBC Utility a una aplicación? A. conﬁg.xml B. c… |
| 9 | Java | pág 9 | public class Test { int[] array = {1, 2, 3, 4, 5}; public static void main(String[] args) { new Test().go(1);… |
| 10 | Java | pág 11 | class Parent { public void display() { System.out.println("Parent"); } } class Child extends Parent { public v… |
| 11 | Herramientas/general | pág 13 | ¿Cuál de las siguientes sentencias acerca del patrón de diseño Singleton es verdadera? a. El patrón Singleton… |
| 12 | Java | pág 14 | What will be the result of the following code execution involving streams? import java.util.Arrays; import jav… |
| 13 | APX | pág 16 | ¿Qué comando permite enviar una solicitud de transacción a un servidor APX? a. apx show in --project path=./TE… |
| 14 | Java | pág 17 | public class Test { public static void main(String... arguments) { final char a = 'A', d = 'D'; char grade = '… |
| 15 | Java | pág 20 | What will be the output of the following code snippet? class StaticNonStaticBlockTest { static { System.out.pr… |
| 16 | APX | pág 21 | ¿Cual es la consola para la configuración de la aplicación en APX Online? a. Chrome Console b. APX Operation C… |
| 17 | Java | pág 22 | public class StringInternExample { public static void main(String[] args) { String str1 = new String("example"… |
| 18 | APX | pág 25 | Este patrón suele representarse como una única librería que contiene la mayoría de la funcionalidad y que otra… |
| 19 | Java | pág 26 | public class Test { public static void op1(String s) { s += new String("Java"); } public static void stringTes… |
| 20 | Java | pág 28 | Dado el siguiente código: import java.util.List; import java.util.function.Predicate; class Person { String na… |
| 21 | Java | pág 30 | ¿Cuál será el resultado de ejecutar el siguiente código? class Parent { public void display() { System.out.pri… |
| 22 | Java | pág 32 | public class OverloadedMethods { public OverloadedMethods() { this(10); System.out.println("No-argument constr… |
| 23 | Java | pág 36 | Which of the following is not a part of the Java Collections Framework? a. ArrayList b. Map c. Dictionary d. L… |
| 24 | Herramientas/general | pág 37 | Cual de los siguientes comandos de Maven se utiliza para compilar un proyecto JAR, pero sin depositarlo en el… |
| 25 | Java | pág 38 | What is the result type when a short is subtracted from a double in Java? a. short b. You cannot subtract a sh… |
| 26 | Java | pág 39 | public class Test { static boolean b; public static void main(String[] args) { int x = 0; if (b) { x = 1; } el… |
| 27 | Herramientas/general | pág 41 | ¿Cuál de las siguientes herramientas se utiliza principalmente para probar y desarrollar APIs, permitiendo env… |
| 28 | Java | pág 42 | ¿Qué puede suceder al intentar ejecutar el siguiente código para establecer una conexión a una base de datos?"… |
| 29 | Java | pág 43 | public class OverloadedExample { private String name; public OverloadedExample() { this("Default"); System.out… |
| 30 | Java | pág 45 | In Java, which syntax is used to declare a method parameter that accepts a variable number of arguments? a. []… |
| 31 | APX | pág 46 | En JDBC APX cual es la cantidad máxima de resultados que permite obtener la consulta antes de que se deba de p… |
| 32 | Java | pág 46 | Which statement about the following code is correct? class Base { public Base() { System.out.println("Base con… |
| 33 | Herramientas/general | pág 49 | ¿Qué patrón de diseño es el más adecuado para garantizar que una clase tenga solo una instancia y proporciona… |
| 34 | APX | pág 50 | ¿Cuál de los siguientes componentes de APX representa una entidad comercial en forma de un Bean? a. Transaccio… |
| 35 | Java | pág 51 | Which of the following are reserved words in Java for exception handling? a. try, catch, ﬁnally, throw, throws… |
| 36 | Herramientas/general | pág 53 | ¿Cuál es el propósito principal del archivo pom.xml en un proyecto Maven? a. Para almacenar la conﬁguración de… |
| 37 | Java | pág 54 | Which tool is used to package Java classes into a JAR (Java Archive) file? a. jconsole b. java c. jps d. javac… |
| 38 | Java | pág 55 | ¿Cuál de los siguientes fragmentos de código generará una ClassCastException en tiempo de ejecución? // Opción… |
| 39 | Java | pág 59 | Which of the following operators are valid for boolean variables in Java? a. && b. \| c. + d. \|\| e. == The corr… |
| 40 | Java | pág 60 | public class LoopQuestion { public static void main(String[] args) { int count = 0; for (int i = 0; i < 10; i+… |
| 41 | Java | pág 61 | What is the output of the following program? public class Test { public static void main(String[] args) { int… |
| 42 | APX | pág 63 | ¿Qué es el APX CLI? a. Herramienta Web que permite crear el andamio de un proyecto APX. b. Herramienta para ad… |
| 43 | Herramientas/general | pág 64 | Which of the following statements about the Singleton pattern is true? a. The Singleton pattern allows a class… |
| 44 | APX | pág 66 | ¿Cuáles dos de las siguientes opciones son funciones de la siguiente instrucción? apx deploy local --runtime=o… |
| 45 | Herramientas/general | pág 66 | ¿Cuál de las siguientes bases de datos NoSQL es conocida por su modelo de documentos, donde los datos se almac… |
| 46 | APX | pág 67 | ¿Cómo solucionamos un Blob? Realizar un refactoring del diseño entre las librerías involucradas. La clave es m… |
| 47 | Herramientas/general | pág 69 | ¿Cuál es la principal función del servidor de aplicaciones Jboss? a. Proporcionar una plataforma para desplega… |
| 48 | Herramientas/general | pág 70 | ¿Cuál de los siguientes comandos de Git se utiliza para crear una nueva rama y cambiarse a ella? a. git branch… |
| 49 | Java | pág 71 | ¿Cuáles de las siguientes excepciones deben ser chequeadas? a. IOException b. IndexOutOfBoundsException c. Int… |
| 50 | Herramientas/general | pág 72 | In a Maven proyect which file is used to configure proyect dependecies, build configuration and proyect metada… |
| 51 | Java | pág 74 | ¿Cuál será el resultado de intentar compilar y ejecutar el siguiente fragmento de código? import java.util.*;… |
| 52 | Java | pág 77 | Dado el siguiente código public class Test { _____ doMath(long l, short s) { return s / (l * 10); } } ¿Cuál es… |
| 53 | Java | pág 78 | ¿Cuál de las siguientes anotaciones en JUnit se utiliza para indicar que un método debe ejecutarse antes de ca… |
| 54 | Java | pág 80 | import java.util.ArrayList; public class Test { public static void main(String[] args) { String v = new String… |
| 55 | Java | pág 81 | In Java, which of the following is used to call a constructor from another constructor in the same class? a. s… |
| 56 | Java | pág 83 | public class Test { public static void main(String[] args) { String str = "a1b2c3d4e5f6"; String[] parts = str… |
| 57 | Java | pág 84 | public class Test { static int co = 0; public static void main(String[] args) { int x = 1; for (test('1'); tes… |
| 58 | Java | pág 87 | Which of the following statements about ArrayList is true? a. ArrayList allows duplicate elements. b. ArrayLis… |
| 59 | Java | pág 88 | import java.time.LocalDateTime; import java.time.Period; import java.time.format.DateTimeFormatter; import jav… |
| 60 | Java | pág 91 | ¿Cuál es el tipo de resultado cuando se resta un short de un double en Java? a. int b. No se puede restar un s… |
| 61 | Java | pág 92 | ¿Cuál de los siguientes métodos de Mockito se utiliza para verificar que un método de un mock ha sido llamado… |
| 62 | Java | pág 93 | ¿Cuál de las siguientes afirmaciones es correcta sobre la aserción assertEquals en JUnit? a. Se utiliza para v… |
| 63 | Java | pág 94 | import java.util.Arrays; public class Test { public static void main(String[] args) { String[] strings = { "2"… |
| 64 | Java | pág 96 | class Exc1 extends Exception {} class Exc2 extends Exception {} public class Test { static void a() throws Exc… |
| 65 | Java | pág 98 | En Java, ¿cuál de las siguientes instrucciones es usada para llamar a un constructor desde otro constructor en… |
| 66 | APX | pág 99 | ¿Cuáles son las utilerías que pueden ser usadas en APX Batch? a. JDBC Utility b. AP Connector c. Merge/Sort d.… |
| 67 | Java | pág 99 | What will be the output of the following code snippet? import java.io.Closeable; import java.io.IOException; c… |
| 68 | Herramientas/general | pág 103 | En el contexto del patrón de diseño de Comando (Command Pattern), ¿cuál es el propósito de la clase invocadora… |
| 69 | Herramientas/general | pág 104 | ¿Cuál es el propósito principal del patrón de paginación en el desarrollo de aplicaciones web? Mejorar la segu… |
| 70 | Java | pág 105 | public class NestedLoopTest { public static void main(String[] args) { for (int i = 1; i <= 3; i++) { for (int… |
| 71 | Java | pág 109 | ¿Cuál es la salida del siguiente código? import java.time.LocalDate; import java.time.Month; public class Test… |
| 72 | Java | pág 110 | Which of the following lines of code correctly uses a method from the String class to replace all occurrences… |
| 73 | Java | pág 111 | Consider the following Java Code: class Animal { public void makeSound() { System.out.println("Sound"); } publ… |
| 74 | APX | pág 115 | APX proporciona a las aplicaciones las utilidades para ejecutar una consulta solo a base de datos relacional.… |
| 75 | Java | pág 116 | Resultado de la operacion 9 \| 4 13 --> System.out.println( 9\| 4); Vamos a analizarlo paso a paso: La operación… |
| 76 | Java | pág 116 | Which of the following are valid ways to initialize a boolean variable in Java? a. boolean ﬂag = Boolean.FALSE… |
| 77 | Herramientas/general | pág 117 | Which is the primary purpose of the pom.xml file in a Maven project? a. To specify the Java version used in th… |
| 78 | Java | pág 118 | public class Test { public static void main(String[] args) { try { mf(); System.out.print("A"); } catch (Excep… |
| 79 | Java | pág 120 | En Java, ¿qué sintaxis es usada para declarar un parámetro en un método que acepte un número variable de argum… |
| 80 | APX | pág 121 | ¿Qué es un Job en el contexto de Spring Batch? a. Una clase que gestiona la persistencia de datos en la base d… |
| 81 | Java | pág 122 | Give public class Test { public static void main(String[] args) { float f = 3.14f; new Test().doIt(f); } void… |
| 82 | APX | pág 125 | ¿Cuál de los siguientes componentes de APX encapsula la lógica empresarial y el acceso a los datos, además pub… |
| 83 | Java | pág 125 | Which of the following statements accurately describe the relationships that can exist between classes in Java… |
| 84 | Java | pág 127 | import java.io.Closeable; import java.io.IOException; class Resource implements AutoCloseable { @Override publ… |
| 85 | Herramientas/general | pág 130 | ¿Cuál es el comando en Windows para listar el contenido de un directorio/carpeta? a. ls b. list c. mv d. dir e… |
| 86 | Java | pág 130 | What are the modifiers that a nested class can have? a. public b. ﬁnal c. protected d. abstract e. static f. p… |
| 87 | Java | pág 131 | import java.util.*; public class ComparableTest { public static void main(String[] args) { List<Item> items =… |
| 88 | Java | pág 135 | What will be the output of the following code snippet? class A { public A() { System.out.println("A's construc… |
| 89 | Java | pág 138 | What will be the output of the following code snippet? public class StringConcatenationTest { public static vo… |
| 90 | Java | pág 141 | import java.sql.Connection; import java.sql.DriverManager; import java.sql.ResultSet; import java.sql.SQLExcep… |
| 91 | APX | pág 143 | ¿Cuáles de las siguientes son herramientas necesarias para desarrollar componentes APX? a. Git b. Docker c. Ar… |
| 92 | Java | pág 144 | public class Test { public void op2(String s) { s.toUpperCase(); } public void op3() { String msg = new String… |
| 93 | Java | pág 146 | ¿Cuál de las siguientes afirmaciones confirma correctamente los paquetes que usa el siguiente código? import j… |
| 94 | Java | pág 149 | public class Test implements Runnable { private int i; @Override public void run() { if (i % 10 == 0) { i++; }… |
| 95 | Java | pág 153 | public class OverloadedStaticMethods { public static void display() { System.out.println("Display with no argu… |
| 96 | Herramientas/general | pág 156 | ¿Cuál de las siguientes opciones se utiliza principalmente para la integración continua en el desarrollo del s… |
| 97 | Java | pág 158 | import java.util.ArrayList; import java.util.List; public class Test { public static void main(String[] args)… |
| 98 | APX | pág 160 | Todo el acceso a los datos debe estar encapsulado en una transacción para facilitar la reutilización y control… |
| 99 | Java | pág 161 | Given: interface IFun { int calculate( int i1, int i2); } public class Test { public static void main(String[]… |
| 100 | Herramientas/general | pág 163 | ¿Cuál de las siguientes ramas en Gitflow se utiliza para aplicar correcciones rápidas directamente en producci… |
| 101 | Java | pág 164 | import java.util.Arrays; import java.util.List; import java.util.stream.Collectors; public class StreamTest {… |
| 102 | Java | pág 165 | class ABC { public String met() { return "snippet 1"; } } public class ABCD extends ABC { // Insert code here… |
| 103 | Java | pág 167 | class CA { CA() { System.out.print("middle"); } CA(String s) { System.out.print(s); } } class CB extends CA {… |
| 104 | APX | pág 170 | Una transacción APX es la unidad aplicativa que se ejecutará en APX Batch. Seleccione una: Verdadero Falso |
| 105 | Java | pág 170 | ¿Cuál es la función principal del JDK (Java Development Kit)? a. Permitir la edición de archivos JHTML y JCSS.… |
| 106 | APX | pág 171 | ¿Cuál es el propósito del método setSeverity() en el manejo de una transacción APX? a. Validar los datos propo… |
| 107 | Java | pág 172 | import java.util.function.*; public class Test { public static void main(String[] args) { Predicate<String> p… |
| 108 | Java | pág 174 | public class Test { public static void main(String[] args) { String a = "tic"; String b = "tac"; a.substring(0… |
| 109 | Java | pág 176 | Which of the following packages in Java do not need to be explicitly imported in a Java program? a. java.net b… |
| 110 | Java | pág 177 | Which of the following statements correctly describes an immutable object in Java? a. An immutable object must… |
| 111 | Java | pág 178 | What will be the output of the following code snippet? public class EnumTest { enum Day { MONDAY, TUESDAY, WED… |
| 112 | Java | pág 179 | enum Days { MONDAY, TUESDAY, WEDNESDAY, THURSDAY } public class Test { public static void main(String[] args)… |
| 113 | Java | pág 182 | Cuando se asigna un byte a un carácter en Java, ¿cuál es el tipo de resultado? a. char b. int c. byte d. short… |
| 114 | Java | pág 182 | Dado: class Test { static void m(int a) { a += 10; } public static void main(String[] args) { int a = 20; m(a)… |
| 115 | Java | pág 184 | abstract class Animal { void speak() { System.out.println("Animals make noise"); } public static void main(Str… |
| 116 | Java | pág 187 | public class Test { public static void main(String[] args) { String str = "Hello"; modify(str); System.out.pri… |
| 117 | Java | pág 189 | ¿Cuál es la salida del siguiente código? public class Test { public void run() { try { System.out.print("Runni… |
| 118 | Java | pág 192 | Which two options are true about the default constructor? a. The default always invokes the no-arg superclass… |
| 119 | APX | pág 192 | ¿Cuál es la nomenclatura correcta para un componente de tipo librería? a. TESTCO01 b. TESTRO01-MX-01 c. TESTRO… |
| 120 | Java | pág 193 | boolean x = true; boolean y = false; boolean result = x && y \|\| !x; System.out.println(result); a. Runtime err… |
| 121 | Herramientas/general | pág 194 | Which file is used to configure user-specific settings in Maven? a. build.xml b. settings.xml c. user.xml d. p… |
| 122 | Herramientas/general | pág 195 | ¿Qué significa que un cambio en el software sea retrocompatible? a. El cambio puede romper la funcionalidad ex… |
| 123 | Java | pág 195 | Given the following classes, which line of code correctly creates an instance of the Dog class? class Animal {… |
| 124 | Java | pág 196 | ¿Qué declaraciones inicializan correctamente una variable booleana en Java? a. boolean d = (4 - 14); b. boolea… |
| 125 | APX | pág 197 | En APX CLI, ¿cual opcion permite crear un proyecto Maven con una unidad de despliegue de tipo librería? a. apx… |
| 126 | APX | pág 198 | ¿Qué es ENTORNO LOCAL APX? a. Ninguna opción es correcta. b. Es un entorno productivo para desplegar los compo… |
| 126b | APX | pág 199 (sin número propio: va tras la respuesta de la #126) | ¿Cuál de las siguientes afirmaciones describe mejor un Step en el contexto de Spring Batch? a. Una clase que g… |
| 127 | Java | pág 199 | ¿Qué métodos de anulación (Override) son válidos para las siguientes clases? class Parent { void display() { S… |
| 128 | Java | pág 201 | Which of the following class declarations is not correct? a. abstract class Person () b. ﬁnal class Person ()… |
| 129 | Java | pág 202 | Given the following code snippet, what will be the output of the program? String s1 = "text"; String s2 = new… |
| 130 | Java | pág 203 | Which method in java.lang.Object should be overridden if the hashcode() method is overridden? a. clone() b. co… |
| 131 | Java | pág 204 | ¿Cuál será el resultado de compilar y ejecutar el siguiente fragmento de código en Java? public class StaticBl… |
| 132 | Herramientas/general | pág 208 | ¿Cuál es el comando en Bash para cambiar el directorio actual a uno especificado? a. goto b. cd c. move d. sh… |
| 133 | Java | pág 209 | Which three of the following options are considered bad practices in software development in Java? a. Ignoring… |
| 134 | Java | pág 210 | ¿Qué clase puede proveer las siguientes capacidades?: no permitir valores duplicados, mantener el orden en el… |
| 135 | Java | pág 210 | ¿Cuántas veces se ejecutará la instrucción println más interna en el siguiente código? public class NestedForL… |
| 136 | Java | pág 212 | Given: interface I { void method(); } public class C implements I { // method declarations } Which method can… |
| 137 | APX | pág 212 | ¿Cuál de las siguientes opciones es verdadera acerca de Spring Batch? a. Marco de trabajo basado en jobs y ste… |
| 138 | Java | pág 213 | Dado el siguiente código: import java.util.function.Predicate; class Foo { int i; Foo(int i) { this.i = i; } }… |
| 139 | Java | pág 215 | public class Test { public static void main(String... arguments) { final char a = 'A', d = 'D'; char grade = '… |
| 140 | Java | pág 218 | public class Test { String value = "A"; { value += "B"; } { value += "C"; } public Test() { value += "x"; } pu… |
| 141 | Java | pág 221 | Which statement is true about the following code? abstract class Shape { public abstract void draw(); public v… |
| 142 | APX | pág 223 | ¿Cuál es un antipatrón de Binary Large Object (BLOB)? Una librería compuesta de sola clase con gran cantidad d… |
| 143 | Java | pág 224 | Which of the following code snippets will result in a compilation error when implementing the Vehicle interfac… |
| 144 | Java | pág 227 | ¿Cuál de los siguientes fragmentos de código implementa correctamente Comparator para ordenar una lista de obj… |
| 145 | Java | pág 230 | public class Test { ___ doMath (long l, short s) { return s / (l * 10); } } What is the narrowest valid return… |
| 146 | Java | pág 231 | In Java, which class is the superclass of all errors and exceptions? a. Object b. RuntimeException c. Exceptio… |
| 147 | APX | pág 231 | Todo el acceso a los datos debe estar encapsulado en una biblioteca para facilitar la reutilización y el contr… |
| 148 | Java | pág 232 | ¿Cuál es la característica que comparten Array y Arraylist? Pueden almacenar valores nulos. Ambos procesos ocu… |
| 149 | Java | pág 233 | abstract class Animal { void speak() { System.out.println("Animals make noise"); } public static void main(Str… |
| 150 | Java | pág 234 | ¿Cuál será el resultado del siguiente fragmento de código? public class OverloadedConstructorsTest { private S… |
| 151 | Herramientas/general | pág 239 | ¿Cuál de las siguientes opciones es una herramienta de comprensión y gestión de proyectos basada en el concept… |
| 152 | Java | pág 240 | import java.util.Arrays; import java.util.Comparator; class SortLongs implements Comparator<Long> { @Override… |
| 153 | Java | pág 242 | public class NestedForLoopTest { public static void main(String[] args) { int[][] matrix = { {1, 2, 3}, {4, 5,… |
| 154 | Herramientas/general | pág 245 | En el contexto de Maven. ¿Cuál es la función principal del archivo settings.xml? a. Ninguna opción es correcta… |
| 155 | Java | pág 246 | abstract class Animal { private void speak() { System.out.println("Animals make noise"); } public static void… |
| 156 | Java | pág 249 | ¿Cuál de las siguientes afirmaciones sobre la palabra clave throw es verdadera? a. Se utiliza para detectar ex… |
| 157 | Java | pág 250 | ¿Cuál de las siguientes anotaciones es verdadera acerca de la siguiente jerarquía de clases? class Vehicle { S… |
| 158 | Java | pág 252 | Which of the following statements correctly identifies checked and unchecked exceptions in Java? a. SQLExcepti… |
| 159 | APX | pág 254 | ¿Cuáles de las siguientes opciones son verdaderas acerca de APX? a. Ayuda a aumentar el uso de Mainframe. b. N… |
| 160 | APX | pág 254 | ¿Cuáles son los tipos de componentes en APX batch? a. Librerías b. Jobs c. Todas las opciones son correctas d.… |
| 161 | Java | pág 255 | What is the output of the following program? public class Test { public static void main(String[] args) { int… |
| 162 | Java | pág 257 | public class Test implements Runnable { boolean flag = true; @Override public synchronized void run() { if (fl… |
| 163 | Java | pág 259 | ¿Cuáles son palabras reservadas para manejo de excepciones en Java? a. throw & throws b. Error, Exception, Run… |
| 164 | Java | pág 260 | ¿Cuál de las siguientes implementaciones de código utiliza correctamente una clase genérica en Java? a) public… |
| 165 | APX | pág 263 | ¿Cuál de las siguientes opciones son capacidades ofrecidas en APX? a. Todas las opciones son correctas. b. Pro… |
| 166 | Java | pág 263 | hat will happen when you try to compile the following code? class Parent { protected void show() { System.out.… |
| 167 | APX | pág 265 | ¿Cuáles de las siguientes opciones son archivos configurados por APX CLI al agregar JDBC Utility? a. library-a… |
| 168 | APX | pág 265 | Con la "APX Operation Console", sólo se pueden ver grafos de dependencias para las librerías. Seleccione una:… |
| 169 | APX | pág 266 | ¿Cual opción es verdadera acerca de "APX Operation Console"? a. Herramienta web que proporciona a los desarrol… |
| 170 | APX | pág 267 | ¿Cuáles son los tipos de componentes en APX? a. Librerías b. Jobs c. Todas las opciones son correctas d. DTOs… |
| 171 | Herramientas/general | pág 267 | ¿Qué significa que un cambio en el software sea retrocompatible? a. El cambio garantiza que el software siga f… |
| 172 | Herramientas/general | pág 268 | ¿Qué comando en Bash se utiliza para copiar archivos de un lugar a otro? a. copy b. mv c. cp d. zip e. duplica… |
| 173 | Herramientas/general | pág 269 | ¿Cuál es el propósito principal de un objeto de transferencia de datos (DTO) en el diseño de software? a. Enca… |
| 174 | APX | pág 269 | ¿Cuál es la función principal de JobRepository en Spring Batch? a. Conﬁgurar y gestionar los recursos necesari… |
| 175 | Java | pág 270 | class Ot { enum Colors { RED, GREEN, BLUE, YELLOW, BLACK }; } public class Test { public static void main(Stri… |
| 176 | APX | pág 272 | ¿Cuál es el archivo generado por el comando 'apx config'? a. settings.yaml b. conﬁg.xml c. pom.xml d. settings… |
| 177 | APX | pág 272 | ¿Cuál es la nomenclatura correcta para un componente de tipo transacción? a. TESTT001-01-MX b. TESTT001-MX-01… |
| 178 | Java | pág 273 | Which of the following are valid ways to initialize an array in Java? a. int[] arr = (1, 2, 3); b. int[] arr =… |
| 179 | APX | pág 274 | ¿Cuál es la nomenclatura y la ruta de creación de un archivo que sigue el formato [UUAA]T[CODE]-[VERSION]-[COU… |
| 180 | Java | pág 274 | What are the types of exceptions in Java? a. Checked b. Unchecked c. Object d. All the options are correct. e.… |
| 181 | Java | pág 275 | Dado el siguiente código: interface Omega {} class Gamma {} class Epsilon extends Gamma implements Omega {} pu… |
| 182 | APX | pág 276 | ¿Cuáles son los protocolos físicos que admite en APX? a.SQL b.JMS c.Kermit d.REST e.HTTP |
| 183 | Java | pág 276 | Which of the following are unchecked exceptions? a. ArrayIndexOutOfBoundsException b. IOException c. RuntimeEx… |
| 184 | Herramientas/general | pág 277 | ¿Cual de las siguientes opciones de vida de Maven se encarga de compilar el código fuente del proyecto? a. com… |
| 185 | Java | pág 278 | ¿Cuál de las siguientes herramientas incluidas en el JDK se utiliza para monitorear y gestionar aplicaciones?… |
| 186 | Herramientas/general | pág 279 | ¿Cuál de las siguientes herramientas proporciona análisis de calidad del código, detectando errores, vulnerabi… |
| 187 | Java | pág 279 | Dado el siguiente código: interface I { void method(); } public class C implements I { // declaraciones de mét… |
| 188 | Java | pág 280 | ¿Cuál de los siguientes métodos de Mockito se utilizan conjuntamente para definir el comportamiento de un mock… |
| 189 | Java | pág 281 | abstract class Animal { public void speak() { System.out.println("Animals make noise"); } public static void m… |
| 190 | Java | pág 283 | Which of the following lines of code correctly appends a string to a StringBuilder object in Java? a. StringBu… |
| 191 | Java | pág 283 | The image shows a multiple-choice question about the java -jar command, which is used to execute Java programs… |
| 192 | Java | pág 284 | Which two statements are true? a. An interface cannot be extended by another interface. b. An interface can be… |
| 193 | Java | pág 285 | ¿Cuál es el propósito principal de la anotación @Test en JUnit? a. Ninguna opción es correcta. b. Marcar un mé… |
| 194 | Herramientas/general | pág 286 | Una transacción es un conjunto de operaciones que se ejecutan como un solo elemento. Una transacción debe tene… |
| 195 | Herramientas/general | pág 286 | ¿Cuál es la rama principal de Gitflow en la que se integran las nuevas funcionalidades antes de lanzarlas a pr… |
| 196 | Herramientas/general | pág 287 | ¿Cuál de los siguientes comandos de Maven se utiliza para compilar un proyecto y crear un archivo JAR pero sin… |
| 197 | Herramientas/general | pág 287 | Which design pattern allows you to compose objects into tree structures to represent part-whole hierarchies, l… |
| 198 | Herramientas/general | pág 288 | ¿Cuál es el significado del acrónimo CRUD en el contexto del desarrollo de aplicaciones? a. Create, Read, Upda… |
| 199 | Java | pág 289 | import java.util.stream.Stream; import java.util.Objects; class Person { public String name; Person(String nam… |
| 200 | Herramientas/general | pág 292 | ¿Cuál es la principal función de JFrog Artifactory en un entorno de desarrollo de software? a. Proporcionar un… |
| 201 | Java | pág 292 | Which of the following lines of code correctly defines the main method in a Java program? a. static void main(… |
| 202 | Java | pág 293 | hat will be the result of attempting to compile and run the following code snippet? public class RecursiveCons… |
| 203 | Java | pág 294 | abstract class Vehicle { public abstract void start(); public void stop() { System.out.println("Vehicle stoppe… |
| 204 | APX | pág 296 | ¿Cuáles son los tipos de componentes en APX Online? a. Librerías b. Jobs c. Todas las opciones son correctas d… |
| 205 | Herramientas/general | pág 296 | ¿Cuál es el patrón de diseño que permite a un objeto cambiar su estado interno? State Pattern Correcto. |
| 206 | Java | pág 297 | Which two statements are true? a. A class that is abstract cannot be instantiated or turned into an object (in… |
| 207 | Herramientas/general | pág 298 | ¿Cuál de las siguientes herramientas es la más adecuada para el seguimiento de problemas y la gestión de proye… |
| 208 | APX | pág 299 | ¿Cuál es el objetivo de la clase abstracta de la transacción APX? a. Recuperar información de solicitud HTTP.… |
| 209 | Herramientas/general | pág 299 | ¿Cuál es el propósito del plugin maven-surefire-plugin y en qué etapa del ciclo de vida de Maven se ejecuta pr… |
| 210 | Herramientas/general | pág 300 | ¿Cuál es el propósito principal de OSGi (Open Service Gateway Initiative) en el desarrollo de software moderno… |
| 211 | Java | pág 300 | ¿Cuál será el resultado del siguiente fragmento de código? class Animal { public void makeSound() { System.out… |
| 212 | Java | pág 302 | What are the modifiers that can precede a toplevel class declaration? a. protected b. abstract c. strictfp d.… |

## 01 - Simulación APX V1.docx

`java/01 - Simulación APX V1.docx` — Sin respuestas. # = «Pregunta N» del .docx (sin contar el campo «Ingresa tu nombre»). 40 de sus 45 preguntas están también en `Java.pdf`, que trae las respuestas. Las #34 y #36 son la misma pregunta.

| # | Tema | Ubicación | Enunciado (recorte) |
|---|---|---|---|
| 1 | APX | Pregunta 1 | ¿Qué es el APX CLI? |
| 2 | Java | Pregunta 2 | public class Test { public static void op1(String s) { s += new String("Java"); } public static void stringTes… |
| 3 | Herramientas/general | Pregunta 3 | ¿Cuál de los siguientes componentes es parte de una solicitud HTTP? |
| 4 | APX | Pregunta 4 | ¿Cuál de los siguientes componentes de APX representa una entidad comercial en forma de un Bean? |
| 5 | Java | Pregunta 5 | ¿Cuáles de las siguientes excepciones deben ser chequeadas? |
| 6 | Java | Pregunta 6 | ¿Qué herramienta se utiliza para empaquetar clases de Java en un archivo JAR (Java Archive)? |
| 7 | APX | Pregunta 7 | ¿Cual es la consola para la configuración de la aplicación en APX Online? |
| 8 | Herramientas/general | Pregunta 8 | ¿Qué patrón de diseño es el más adecuado para garantizar que una clase tenga solo una instancia y proporciona… |
| 9 | Java | Pregunta 9 | ¿Cuál es el tipo de retorno válido punto flotante más restringido para el método de cálculo? |
| 10 | Herramientas/general | Pregunta 10 | ¿Cuáles de los siguientes comandos de Git se utilizan para gestionar ramas en un repositorio? Selecciona todas… |
| 11 | Java | Pregunta 11 | public class Test { public static void main(String[] args) { String str = "a1b2c3d4e5f6"; String[] parts = str… |
| 12 | Java | Pregunta 12 | ¿Cual de las siguientes no es parte del framework de Java Collentions? |
| 13 | Java | Pregunta 13 | ¿Cuáles son los tipos de excepciones en Java? |
| 14 | APX | Pregunta 14 | ¿Cómo solucionamos un Blob? |
| 15 | Java | Pregunta 15 | ¿Cuál de las siguientes afirmaciones es correcta sobre la aserción assertEquals en JUnit? |
| 16 | APX | Pregunta 16 | En JDBC APX cual es la cantidad máxima de resultados que permite obtener la consulta antes de que se deba de p… |
| 17 | Herramientas/general | Pregunta 17 | ¿Cuál de las siguientes bases de datos NoSQL es conocida por su modelo de documentos, donde los datos se almac… |
| 18 | Herramientas/general | Pregunta 18 | ¿En un proyecto Maven, qué archivo se utiliza para configurar las dependencias del proyecto, la configuración… |
| 19 | Herramientas/general | Pregunta 19 | ¿Cuál de los siguientes comandos de Git se utiliza para crear una nueva rama y cambiarse a ella? |
| 20 | Java | Pregunta 20 | ¿Cuál de las siguientes anotaciones en JUnit se utiliza para indicar que un método debe ejecutarse antes de ca… |
| 21 | APX | Pregunta 21 | Este patrón suele representarse como una única librería que contiene la mayoría de la funcionalidad y que otra… |
| 22 | Java | Pregunta 22 | public class Test { static int co = 0; public static void main(String[] args) { int x = 1; for (test('1'); tes… |
| 23 | APX | Pregunta 23 | ¿Cuáles dos de las siguientes opciones son funciones de la siguiente instrucción? apx deploy local --runtime=o… |
| 24 | Herramientas/general | Pregunta 24 | ¿Cuál de las siguientes sentencias acerca del patrón de diseño Singleton es verdadera? |
| 25 | Herramientas/general | Pregunta 25 | En el contexto del versionado semántico (Semantic Versioning), si un desarrollador cambia la versión de una bi… |
| 26 | Java | Pregunta 26 | En Java, ¿cuál de las siguientes se utiliza para llamar a un constructor desde otro constructor dentro de la m… |
| 27 | Java | Pregunta 27 | import java.util.Arrays; public class Test { public static void main(String[] args) { String[] strings = { "2"… |
| 28 | Java | Pregunta 28 | public class LoopQuestion { public static void main(String[] args) { int count = 0; for (int i = 0; i < 10; i+… |
| 29 | Java | Pregunta 29 | public class Test { int[] array = {1, 2, 3, 4, 5}; public static void main(String[] args) { new Test().go(1);… |
| 30 | Java | Pregunta 30 | ¿Cuál de los siguientes métodos de Mockito se utiliza para verificar que un método de un mock ha sido llamado… |
| 31 | Java | Pregunta 31 | ¿Cuáles de las siguientes son palabras reservadas en Java para el manejo de excepciones? |
| 32 | Herramientas/general | Pregunta 32 | ¿Cuál de las siguientes herramientas se utiliza principalmente para probar y desarrollar APIs, permitiendo env… |
| 33 | Java | Pregunta 33 | ¿Cuál de las siguientes afirmaciones sobre el ciclo for mejorado introducido en Java 5 es verdadera? |
| 34 | Java | Pregunta 34 | ¿Cuál es el tipo de resultado cuando se resta un valor short de un valor double en Java? |
| 35 | Herramientas/general | Pregunta 35 | ¿Cuál es la principal función del servidor de aplicaciones Jboss? |
| 36 | Java | Pregunta 36 | ¿Cuál es el tipo de resultado cuando se resta un short de un double en Java? |
| 37 | Herramientas/general | Pregunta 37 | ¿Cuál de las siguientes características es fundamental en una base de datos relacional? |
| 38 | Java | Pregunta 38 | Dado el siguiente código: import java.util.List; import java.util.function.Predicate; class Person { String na… |
| 39 | Java | Pregunta 39 | public class StringInternExample { public static void main(String[] args) { String str1 = new String("example"… |
| 40 | Herramientas/general | Pregunta 40 | Cual de los siguientes comandos de Maven se utiliza para compilar un proyecto JAR, pero sin depositarlo en el… |
| 41 | APX | Pregunta 41 | ¿Qué comando permite enviar una solicitud de transacción a un servidor APX? |
| 42 | Herramientas/general | Pregunta 42 | ¿Cuál de las siguientes opciones describe correctamente un servicio web (web service)? |
| 43 | Java | Pregunta 43 | ¿Cuál de las siguientes afirmaciones sobre ArrayList es verdadera? |
| 44 | Java | Pregunta 44 | ¿Cuáles de los siguientes operadores son válidos para variables booleanas en Java? |
| 45 | APX | Pregunta 45 | ¿Cuál es el archivo utilizado para agregar la dependencia del JDBC Utility a una aplicación? |

## 02 - Simulación APX V2.docx

`java/02 - Simulación APX V2.docx` — Sin respuestas. 39 de sus 45 preguntas están también en `Java.pdf`, que trae las respuestas.

| # | Tema | Ubicación | Enunciado (recorte) |
|---|---|---|---|
| 1 | Java | Pregunta 1 | En Java, ¿cuál de las siguientes instrucciones es usada para llamar a un constructor desde otro constructor en… |
| 2 | APX | Pregunta 2 | ¿Cuáles son las utilerías que pueden ser usadas en APX Batch? |
| 3 | Herramientas/general | Pregunta 3 | En el contexto del patrón de diseño de Comando (Command Pattern), ¿cuál es el propósito de la clase invocadora… |
| 4 | Herramientas/general | Pregunta 4 | ¿Cuál es el propósito principal del patrón de paginación en el desarrollo de aplicaciones web? |
| 5 | Java | Pregunta 5 | ¿Cuál es la salida del siguiente código? import java.time.LocalDate; import java.time.Month; public class Test… |
| 6 | Java | Pregunta 6 | ¿Cuál de las siguientes líneas de código utiliza correctamente un método de la clase String para reemplazar to… |
| 7 | APX | Pregunta 7 | APX proporciona a las aplicaciones las utilidades para ejecutar una consulta solo a base de datos relacional.… |
| 8 | Java | Pregunta 8 | ¿Cuáles de las siguientes son formas válidas de inicializar una variable booleana en Java? |
| 9 | Herramientas/general | Pregunta 9 | ¿Cuál es el propósito principal del archivo pom.xml en un proyecto Maven? |
| 10 | APX | Pregunta 10 | ¿Qué es un Job en el contexto de Spring Batch? |
| 11 | Java | Pregunta 11 | En Java, ¿qué sintaxis es usada para declarar un parámetro en un método que acepte un número variable de argum… |
| 12 | APX | Pregunta 12 | ¿Cuál de los siguientes componentes de APX encapsula la lógica empresarial y el acceso a los datos, además pub… |
| 13 | Java | Pregunta 13 | ¿Cuál de las siguientes afirmaciones describe con precisión las relaciones que pueden existir entre clases en… |
| 14 | Herramientas/general | Pregunta 14 | ¿Cuál es el comando en Windows para listar el contenido de un directorio/carpeta? |
| 15 | Java | Pregunta 15 | ¿Cuáles son los modificadores que puede tener una clase anidada en Java? |
| 16 | APX | Pregunta 16 | ¿Cuales son las herramientas necesarias para desarrollar componentes en APX? |
| 17 | Herramientas/general | Pregunta 17 | ¿Cuál de las siguientes opciones se utiliza principalmente para la integración continua en el desarrollo del s… |
| 18 | APX | Pregunta 18 | Todo el acceso a los datos debe estar encapsulado en una transacción para facilitar la reutilización y control… |
| 19 | Herramientas/general | Pregunta 19 | ¿Cuál de las siguientes ramas en Gitflow se utiliza para aplicar correcciones rápidas directamente en producci… |
| 20 | APX | Pregunta 20 | Una transacción APX es la unidad aplicativa que se ejecutará en APX Batch. Seleccione una: |
| 21 | Java | Pregunta 21 | ¿Cuál es la función principal del JDK (Java Development Kit)? |
| 22 | APX | Pregunta 22 | ¿Cuál es el propósito del método setSeverity() en el manejo de una transacción APX? |
| 23 | Java | Pregunta 23 | ¿Cuál de los siguientes paquetes en Java no necesitan ser importados explícitamente en un programa Java? |
| 24 | Java | Pregunta 24 | ¿Cuál de las siguientes afirmaciones describe correctamente un objeto inmutable en Java? |
| 25 | Java | Pregunta 25 | ¿Cuando se asigna un byte a un carácter en Java, ¿cuál es el tipo de resultado? |
| 26 | Java | Pregunta 26 | ¿Cuáles dos opciones son verdaderas sobre el constructor por defecto? |
| 27 | APX | Pregunta 27 | ¿Cuál es la nomenclatura correcta para un componente de tipo librería? |
| 28 | Herramientas/general | Pregunta 28 | ¿Qué archivo se utiliza para configurar la configuración específica del usuario en Maven? |
| 29 | Herramientas/general | Pregunta 29 | ¿Qué significa que un cambio en el software sea retrocompatible? |
| 30 | Java | Pregunta 30 | ¿Qué declaraciones inicializan correctamente una variable booleana en Java? |
| 31 | APX | Pregunta 31 | En APX CLI, ¿cual opcion permite crear un proyecto Maven con una unidad de despliegue de tipo librería? |
| 32 | APX | Pregunta 32 | ¿Cuál de las siguientes afirmaciones describe mejor un Step en el contexto de Spring Batch? |
| 33 | APX | Pregunta 33 | ¿Qué es ENTORNO LOCAL APX? |
| 34 | Java | Pregunta 34 | ¿Cuál de las siguientes declaraciones de clase no es correcta? |
| 35 | Java | Pregunta 35 | ¿Qué método en java.lang.Object debe ser sobrescrito si se sobrescribe el método hashCode()? |
| 36 | Herramientas/general | Pregunta 36 | ¿Cuál es el comando en Bash para cambiar el directorio actual a uno especificado? |
| 37 | Java | Pregunta 37 | ¿Cuáles tres de las siguientes opciones se consideran malas prácticas en el desarrollo de software en Java? |
| 38 | Java | Pregunta 38 | ¿Qué clase puede proveer las siguientes capacidades?: no permitir valores duplicados, mantener el orden en el… |
| 39 | APX | Pregunta 39 | ¿Cuál de las siguientes opciones es verdadera acerca de Spring Batch? |
| 40 | APX | Pregunta 40 | ¿Cuál de las siguientes opciones representa un antipatrón relacionado con el uso de Binary Large Object (BLOB)… |
| 41 | APX | Pregunta 41 | Todo el acceso a los datos debe estar encapsulado en una biblioteca para facilitar la reutilización y el contr… |
| 42 | Java | Pregunta 42 | ¿Cuál es la característica que comparten Array y Arraylist? |
| 43 | Herramientas/general | Pregunta 43 | ¿Cuál de las siguientes opciones es una herramienta de comprensión y gestión de proyectos basada en el concept… |
| 44 | Herramientas/general | Pregunta 44 | En el contexto de Maven. ¿Cuál es la función principal del archivo settings.xml? |
| 45 | Java | Pregunta 45 | ¿Cuál de las siguientes afirmaciones sobre la palabra clave throw es verdadera? |

## 01 - Quiz APX.docx

`java/01 - Quiz APX.docx` — Educaplay. Pese al título, su URL original se llama `desafio_java_fundamentos`.

| # | Tema | Ubicación | Enunciado (recorte) |
|---|---|---|---|
| 1 | Herramientas/general | Pregunta 1 | ¿Para qué sirve el patrón de diseño Command? |
| 2 | Java | Pregunta 2 | ¿Para qué sirve la palabra clave throw en Java? |
| 3 | Java | Pregunta 3 | ¿Qué paquete está importado por defecto en Java? |
| 4 | Java | Pregunta 4 · código en imagen | ¿Qué imprime este bucle? |
| 5 | Java | Pregunta 5 · código en imagen | ¿Qué imprime este código? |
| 6 | Java | Pregunta 6 · código en imagen | ¿Qué imprime este código de matriz? |
| 7 | Java | Pregunta 7 · código en imagen | ¿Qué imprime este código? |
| 8 | Java | Pregunta 8 · código en imagen | ¿Qué imprime este programa de herencia? |
| 9 | Java | Pregunta 9 · código en imagen | Dado el siguiente código ¿cuál es el resultado? |
| 10 | Herramientas/general | Pregunta 10 | ¿Cuál es el comando Maven que compila el proyecto pero no instala? |
| 11 | Herramientas/general | Pregunta 11 | ¿Cuál es el comando Bash para copiar archivos? |
| 12 | Herramientas/general | Pregunta 12 | ¿Cuál es la rama principal en GitFlow para subir cambios a producción? |
| 13 | Herramientas/general | Pregunta 13 | ¿Qué patrón asegura una única instancia de una clase? |
| 14 | APX | Pregunta 14 | 14. ¿Cuál de las siguientes describe a Spring Batch? |
| 15 | Herramientas/general | Pregunta 15 | ¿Cuál es la utilidad de las bases de datos relacionales? |
| 16 | Herramientas/general | Pregunta 16 | ¿Qué herramienta analiza vulnerabilidades en código? |
| 17 | Herramientas/general | Pregunta 17 | ¿Qué herramienta sirve para seguimiento ágil de proyectos? |
| 18 | APX | Pregunta 18 | ¿Un componente UUAAT000-00-MX.xml en que carpeta se genera? |
| 19 | APX | Pregunta 19 | Una transacción APX es la unidad aplicativa que se ejecutará en APX Batch. |
| 20 | APX | Pregunta 20 | Fue creada para dar a desarrolladores y administradores una herramienta para gestionar operaciones en la plata… |
| 21 | APX | Pregunta 21 | ¿Cuál es la afirmación correcta sobre APX Operation Console? |
| 22 | APX | Pregunta 22 | ¿Cuándo un cambio en una transacción no es retrocompatible? |

## 02 - Quiz Desarrollo APX 1.docx

`java/02 - Quiz Desarrollo APX 1.docx` — Educaplay. Recopilación: unas 12 preguntas coinciden con Diagnóstico APX 3/5 y otras son traducciones de los exámenes de Java.

| # | Tema | Ubicación | Enunciado (recorte) |
|---|---|---|---|
| 1 | Java | Pregunta 1 · código en imagen | ¿Cuál es el resultado del siguiente código? |
| 2 | Java | Pregunta 2 | El API estándar para acceder a bases de datos en Java es: |
| 3 | Java | Pregunta 3 | En Java, la diferencia entre throws y throw es: |
| 4 | Java | Pregunta 4 · código en imagen | ¿Cuál es la mejor manera de comprobar que los valores de h1 y h2 son iguales? |
| 5 | Java | Pregunta 5 · código en imagen | ¿Cuál es el resultado del siguiente código? |
| 6 | Java | Pregunta 6 · código en imagen | ¿Cuál es el resultado del siguiente código? |
| 7 | Java | Pregunta 7 · código en imagen | ¿Cuántos de los fragmentos de código, si compilan? |
| 8 | Java | Pregunta 8 · código en imagen | ¿Qué afirmación es correcta? |
| 9 | APX | Pregunta 9 | . ¿Cuál es la ubicación de archivos temporales utilizados en Batch? |
| 10 | APX | Pregunta 10 | Los archivos objeto del procesamiento Batch de APX son de naturaleza estrictamente ____________ y este archivo… |
| 11 | APX | Pregunta 11 | ¿Cuáles son los campos que definen a una transacción en APX? |
| 12 | Java | Pregunta 12 | ¿Cuáles son tres malas prácticas? |
| 13 | Java | Pregunta 13 · código en imagen | ¿Cuál es el resultado del siguiente código? |
| 14 | Java | Pregunta 14 · código en imagen | ¿Cuál es el resultado? |
| 15 | Herramientas/general | Pregunta 15 | El archivo pom.xml es el archivo de configuración para: |
| 16 | APX | Pregunta 16 | ¿Cuál definición de APX es incorrecta? |
| 17 | APX | Pregunta 17 | Son dos de los protocolos físicos que APX admite en una solicitud. |
| 18 | APX | Pregunta 18 | ¿Cuáles son los protocolos físicos disponibles en APX? Selecciona 2 |
| 19 | Herramientas/general | Pregunta 19 | Un ________ proporciona una solución a un problema de diseño. Debe cumplir con diferentes características, com… |
| 20 | APX | Pregunta 20 | ¿Cuáles son ejemplos de Patrones de diseño para APX? |
| 21 | APX | Pregunta 21 | ¿Qué patrones de la siguiente lista son obligatorios del Data Transfer Object (DTO) en APX? |
| 22 | APX | Pregunta 22 | Selecciona dos aplicaciones que justifican el uso del patrón Data Transfer Object (DTO) es obligatorio cuando |
| 23 | APX | Pregunta 23 | Encapsula la lógica empresarial y el acceso a los datos. Publica su interfaz para que pueda ser utilizada por… |
| 24 | Java | Pregunta 24 | Indica a JUnit que la propiedad que usa esta anotación es una simulación y, por lo tanto, se inicializa como t… |
| 25 | APX | Pregunta 25 | En un Batch cuál es el step donde el desarrollador introducirá la lógica empresarial necesaria |

## 03 - Quiz Desarrollo APX 2.docx

`java/03 - Quiz Desarrollo APX 2.docx` — Educaplay.

| # | Tema | Ubicación | Enunciado (recorte) |
|---|---|---|---|
| 1 | Herramientas/general | Pregunta 1 | En Git, ¿cuál es el comando para crear una rama? |
| 2 | Herramientas/general | Pregunta 2 | En Git, ¿cuál es el comando para crear un commit? |
| 3 | Herramientas/general | Pregunta 3 | En Git, ¿cuál es el comando para cambiar de rama? |
| 4 | Herramientas/general | Pregunta 4 | ¿Cuál es el comando para compilar un proyecto Maven? |
| 5 | Herramientas/general | Pregunta 5 | ¿Qué comando se utiliza para instalar el paquete en el repositorio local de Maven? |
| 6 | Herramientas/general | Pregunta 6 | ¿Cuál es el comando para ejecutar las pruebas en un proyecto Maven? |
| 7 | Java | Pregunta 7 · código en imagen | Dado el siguiente código. ¿Cuál es el resultado? |
| 8 | Java | Pregunta 8 · código en imagen | Dado el siguiente código. ¿Cuál es el resultado? |
| 9 | Java | Pregunta 9 · código en imagen | ¿Cuál será la salida del siguiente fragmento de código? |
| 10 | Java | Pregunta 10 · código en imagen | ¿Qué ocurrirá si ejecutas el siguiente código? |
| 11 | Java | Pregunta 11 · código en imagen | ¿Cuál será la salida del siguiente código? |
| 12 | Java | Pregunta 12 · código en imagen | ¿Qué ocurre cuando ejecutas este fragmento de código? |
| 13 | Java | Pregunta 13 · código en imagen | Dado el siguiente código. ¿Cuál es el resultado? |
| 14 | Java | Pregunta 14 · código en imagen | Dado el siguiente código, ¿Cuál es el resultado? |
| 15 | Java | Pregunta 15 · código en imagen | Dado el siguiente código. ¿Cuál es el resultado? |
| 16 | Java | Pregunta 16 · código en imagen | Dado el siguiente código. ¿Cuál es el resultado? |
| 17 | Java | Pregunta 17 · código en imagen | Dado el siguiente código. Con que se necesita remplazar línea 1, línea 2 y línea 3 para que la salida sea Shap… |
| 18 | Java | Pregunta 18 · código en imagen | Dado el siguiente código. ¿Cual será el resultado? |
| 19 | Java | Pregunta 19 · código en imagen | Dado el siguiente código. ¿Cuál es el resultado? |
| 20 | Java | Pregunta 20 · código en imagen | Dado el siguiente código. ¿Cuál es el resultado? |
| 21 | APX | Pregunta 21 | ¿Cuál es el comando para agregar un DTO en una Deployment Unit? |
| 22 | APX | Pregunta 22 | Si un DTO cambia es necesario cambiar el serial versión |
| 23 | APX | Pregunta 23 | ¿Cuál es el comando para agregar una libreria en una Deployment Unit? |
| 24 | APX | Pregunta 24 | ¿Como se agrega jdbc en una librería apx? |

## 07 - Diagnóstico APX 5.docx

`apx/examenes/07 - Diagnóstico APX 5.docx` — El propio formulario trae dos secciones: «Sección 2 — APX» (#1–62) y «Sección 3 — JAVA» (#63–85). Sin respuestas; la mayoría de las preguntas de `Examen Diagnóstico APX 4.pdf` están también aquí. Las #67 y #74 tienen las mismas opciones.

| # | Tema | Ubicación | Enunciado (recorte) |
|---|---|---|---|
| 1 | APX | Pregunta 1 · sección APX | ¿Que causa no corresponde al antipatron Contenedor Magico? |
| 2 | APX | Pregunta 2 · sección APX | ¿Quién es el responsable de iniciar un Job? |
| 3 | APX | Pregunta 3 · sección APX | Selecciona las tres respuestas que describen las mejores practicas establecidas para acceder a Datos |
| 4 | APX | Pregunta 4 · sección APX | Las partes de un campo variable definidos por la cadena NMM son: |
| 5 | APX | Pregunta 5 · sección APX | El objeto ______ no debe manejarse directamente. No debe crear instancias , abrir o cerrar explicitamente cone… |
| 6 | APX | Pregunta 6 · sección APX | ¿Cuál es el prefijo que debe utilizarse en la nomenclatura de los métodos que exponen las librerías para ser c… |
| 7 | APX | Pregunta 7 · sección APX | Para garantizar el comportamiento transaccional de APX, la arquitectura se basa en el estándar ____, por lo qu… |
| 8 | APX | Pregunta 8 · sección APX | En las consultas a BBDD debe usar variables _______ para no afectar el rendimiento de la base de datos |
| 9 | APX | Pregunta 9 · sección APX | En un Batch, ¿Cual es el step donde el desarrollador introducirá la logica empresarial necesaria? |
| 10 | APX | Pregunta 10 · sección APX | El identificador unico para la ejecución de transacciones/Job se genera automaticamente como ultimo paso cuand… |
| 11 | Herramientas/general | Pregunta 11 · sección APX | Un ______ proporciona una solución a un problema de diseño. Debe cumplir con diferentes características, como… |
| 12 | APX | Pregunta 12 · sección APX | Para enviar un aviso desde una biblioteca o desde la transacción, cualquiera que sea el tipo, el método utiliz… |
| 13 | APX | Pregunta 13 · sección APX | Cualquier documento utilizado (.dll, .txt, etc.) se almacenará en el sistema de archivos compartidos del nodo… |
| 14 | APX | Pregunta 14 · sección APX | Los componentes de seguridad lógica que dan servicio a la arquitectura no están acoplados a la Arquitectura AP… |
| 15 | APX | Pregunta 15 · sección APX | La información utilizada en la lógica de negocio de la transacción debe incluirse en ______. |
| 16 | APX | Pregunta 16 · sección APX | ¿Cuál definición de APX es incorrecta? |
| 17 | APX | Pregunta 17 · sección APX | Las utilidades APX implementadas tanto para la arquitectura Online como para la arquitectura Batch son: |
| 18 | APX | Pregunta 18 · sección APX | De la lista siguiente marca 2 funcionalidades de servicios persistencia incluidas en APX |
| 19 | APX | Pregunta 19 · sección APX | De la lista siguiente marca 2 funcionalidades de servicios conectores incluidos en APX |
| 20 | APX | Pregunta 20 · sección APX | Patrones de diseño en APX |
| 21 | APX | Pregunta 21 · sección APX | En primer lugar, APX recibe la solicitud en uno de los protocolos físicos que admite (HTTP, JMS, REST,). Luego… |
| 22 | APX | Pregunta 22 · sección APX | ¿Cuáles son los campos que definen a una transacción en APX? |
| 23 | APX | Pregunta 23 · sección APX | ¿Cuáles son los protocolos físicos disponibles en APX Online? Selecciona 2 |
| 24 | APX | Pregunta 24 · sección APX | Este tipo de paginación es el que establece Arquitectura y Calidad como el más eficiente, tanto en consumo de… |
| 25 | APX | Pregunta 25 · sección APX | Este patrón suele representarse como una única librería que contiene la mayoría de la funcionalidad y que otra… |
| 26 | APX | Pregunta 26 · sección APX | ¿Cómo solucionamos un Blob? |
| 27 | APX | Pregunta 27 · sección APX | Selecciona dos aplicaciones que justifican el uso del patrón Data Transfer Object (DTO) es obligatorio cuando: |
| 28 | APX | Pregunta 28 · sección APX | Este patrón suele representarse en una librería que contiene un solo método “execute” con parámetros que actúa… |
| 29 | APX | Pregunta 29 · sección APX | ¿Qué causas no corresponden al patrón Contenedor Mágico? |
| 30 | APX | Pregunta 30 · sección APX | La aplicación de este anti patrón de diseño en los desarrollos, causará la búsqueda y análisis de una mejor so… |
| 31 | APX | Pregunta 31 · sección APX | ¿Qué nivel de profundidad es permitido al realizar invocaciones de librería a librería? |
| 32 | APX | Pregunta 32 · sección APX | ¿Cuál es el número máximo de librerías a invocar desde una transacción o librería? |
| 33 | APX | Pregunta 33 · sección APX | No puede incluir _______ o etiquetas similares. Estas anotaciones no reciben errores ni advertencias en el com… |
| 34 | APX | Pregunta 34 · sección APX | Está prohibido poner las siguientes anotaciones de primavera en las clases de implementación de las biblioteca… |
| 35 | APX | Pregunta 35 · sección APX | Niveles de Logs más comunes dentro de APX |
| 36 | APX | Pregunta 36 · sección APX | Para información de muy bajo nivel, solo útil para depurar la aplicación tanto en el desarrollo como en el aná… |
| 37 | APX | Pregunta 37 · sección APX | Este nivel de Log tiene las siguientes características: -Paradas e inicios de servicios y sistemas. -Parámetro… |
| 38 | APX | Pregunta 38 · sección APX | DEBUG, sirve para información de muy bajo nivel solo útil para el debug de la aplicación, tanto en el desarrol… |
| 39 | APX | Pregunta 39 · sección APX | WARN, son situaciones que impiden la ejecución correcta de una operación o transacción, pero sin afectar a otr… |
| 40 | APX | Pregunta 40 · sección APX | ERROR, información de situaciones, que aún sin ser de error, si son anómalas o no previstas, aunque el aplicat… |
| 41 | APX | Pregunta 41 · sección APX | INFO, información de nivel superior que permita hacer un seguimiento de la ejecución normal |
| 42 | APX | Pregunta 42 · sección APX | Las partes de un campo variable definidos por la cadena _$NMM$ son: |
| 43 | APX | Pregunta 43 · sección APX | _________ fue creada para brindar una herramienta a los desarrolladores y administradores del entorno para ges… |
| 44 | APX | Pregunta 44 · sección APX | La comunicación de APX a otros servicios NO APX se realiza UNICAMENTE a través de la utilidad APX _______ |
| 45 | APX | Pregunta 45 · sección APX | No está permitido generar _________ para escribir de Logs. Tampoco se permite la escritura por ______, debe se… |
| 46 | APX | Pregunta 46 · sección APX | ¿Cuáles son los protocolos lógicos disponibles en APX? Selecciona 2 |
| 47 | APX | Pregunta 47 · sección APX | ¿Cuáles son las acciones posteriores a la ejecución de la lógica de negocio en la capa de Arquitectura de cont… |
| 48 | APX | Pregunta 48 · sección APX | Selecciona las únicas excepciones que pueden ser capturadas y administradas por las aplicaciones, típicas de A… |
| 49 | APX | Pregunta 49 · sección APX | ¿Cuáles son los dos tipos de step que existen en Batch APX? |
| 50 | APX | Pregunta 50 · sección APX | Agrega un campo de entrada obligatorio. Agregue un campo de salida. Modifique el tipo de un campo de entrada o… |
| 51 | APX | Pregunta 51 · sección APX | Es obligatorio que los DTOs se implementen dentro de un…. |
| 52 | APX | Pregunta 52 · sección APX | Las dependencias circulares son permitidas… |
| 53 | APX | Pregunta 53 · sección APX | El multiproceso no debe usarse en APX Batch ¿Que se puede hacer como opción? |
| 54 | APX | Pregunta 54 · sección APX | Excepción de Spring permitida |
| 55 | APX | Pregunta 55 · sección APX | Diferencias entre Las invocaciones de APX Batch e invocaciones de APX Online |
| 56 | APX | Pregunta 56 · sección APX | APX, ¿Qué es Escritura ROP? |
| 57 | APX | Pregunta 57 · sección APX | En caso de que una transacción deba invocar a otra, solo se puede realizar de forma... |
| 58 | APX | Pregunta 58 · sección APX | Capacidades de APX |
| 59 | APX | Pregunta 59 · sección APX | ¿Qué característica NO pertenece al BATCH? |
| 60 | APX | Pregunta 60 · sección APX | Existe un API de código de barras |
| 61 | APX | Pregunta 61 · sección APX | NO se deben utilizar sentencias que incluyan atributos o acciones específicas de un administrador de base de d… |
| 62 | APX | Pregunta 62 · sección APX | ¿Qué es un Chunk? |
| 63 | Java | Pregunta 63 · sección JAVA | Which three are bad practices? |
| 64 | Java | Pregunta 64 · sección JAVA | Indica a JUnit que la propiedad que usa esta anotación es una simulación y, por lo tanto, se inicializa como t… |
| 65 | Java | Pregunta 65 · sección JAVA | [código en imagen] opciones: a) 3false3 \| b) 3false1 \| c) 2false1 \| d) 3true1 \| e) 2true3 |
| 66 | Java | Pregunta 66 · sección JAVA | Which two statments are true? |
| 67 | Java | Pregunta 67 · sección JAVA | [código en imagen] opciones: a) Gamma gamma \| b) Beta beta \| c) Alpha beta \| d) Compilation fails |
| 68 | Java | Pregunta 68 · sección JAVA | Which five methods, inserted independiently at line 5, will compile? (Choose five) [IMG] |
| 69 | Java | Pregunta 69 · sección JAVA | [código en imagen] opciones: a) Change line 2 to: public int a; \| b) Change line 13 to: public Sub(){ super(5)… |
| 70 | Java | Pregunta 70 · sección JAVA | Whats is true about the class Wow? [IMG] |
| 71 | Java | Pregunta 71 · sección JAVA | What is the result? [IMG] |
| 72 | Java | Pregunta 72 · sección JAVA | What is printed out when the program is excuted? [IMG] |
| 73 | Java | Pregunta 73 · sección JAVA | What is the result? [IMG] |
| 74 | Java | Pregunta 74 · sección JAVA | What is the result? [IMG] |
| 75 | Java | Pregunta 75 · sección JAVA | What is the result? [IMG] |
| 76 | Java | Pregunta 76 · sección JAVA | What is the result? [IMG] |
| 77 | Java | Pregunta 77 · sección JAVA | Which statement is true? [IMG] |
| 78 | Herramientas/general | Pregunta 78 · sección JAVA | The SINGLETON pattern allows: |
| 79 | Java | Pregunta 79 · sección JAVA | What is the result? [IMG] |
| 80 | Java | Pregunta 80 · sección JAVA | What is the result? [IMG] |
| 81 | Java | Pregunta 81 · sección JAVA | Which three implementations are valid? [IMG] |
| 82 | Java | Pregunta 82 · sección JAVA | What is the result? [IMG] |
| 83 | Java | Pregunta 83 · sección JAVA | What value of x, y, z will produce the following result? 1234,1234,1234 -----, 1234, ------ [IMG] |
| 84 | Java | Pregunta 84 · sección JAVA | Which three lines will compile and output "Right on!"? [IMG] |
| 85 | Java | Pregunta 85 · sección JAVA | What is the result? [IMG] |

## Examen Diagnóstico APX 4.pdf

`apx/examenes/Examen Diagnóstico APX 4.pdf` — Escaneo sin numeración: # = orden de aparición (dos preguntas por página, izq/der; las págs 9 y 12 tienen una sola). La pág 8 der no es una pregunta sino la explicación de la #15, y no se cuenta. Algunas páginas marcan la respuesta. La mayoría de sus preguntas están también en `07 - Diagnóstico APX 5.docx`.

| # | Tema | Ubicación | Enunciado (recorte) |
|---|---|---|---|
| 1 | Herramientas/general | pág 1 izq | ¿Qué acción realiza el archivo de dependencia pom.xml? Revisa que versiones de dependencias se tienen con otro… |
| 2 | APX | pág 1 der | ¿Qué causas no corresponde al antipatron Contenedor Mágico? • Reparto de responsabilidades incorrecto. • Falta… |
| 3 | APX | pág 2 izq | Selecciona las tres respuestas que describen las mejores prácticas establecidas para acceder a Datos: En el ca… |
| 4 | APX | pág 2 der | Las partes de un campo variable definidos por la cadena NMM son: N es el orden de la variable literal (1 o 4),… |
| 5 | APX | pág 3 izq | El objeto _ _ no debe manejarse directamente. No debe crear instancias, abrir o cerrar explicitamente conexion… |
| 6 | APX | pág 3 der | En un Batch cual es el step donde el desarrollador introducirá la lógica empresarial necesaria: O itemWriter.… |
| 7 | APX | pág 4 izq | El identificador único para la ejecución de transacciones/Job se genera automáticamente como ultimo paso cuand… |
| 8 | Herramientas/general | pág 4 der | Unl proporciona una solución a un problema de diseño. Debe cumplir con diferentes características, omo la efec… |
| 9 | Java | pág 5 izq | Given: import java.utiliẠi public class App ( public static void main(String[] args) ( List p = new ArrayList(… |
| 10 | APX | pág 5 der | Para enviar un aviso desde una biblioteca o desde la transacción, cualquiera que sea el tipo, el método utiliz… |
| 11 | APX | pág 6 izq | Cualquier documento utilizado (.dll, .txt, etc.) se almacenará en el sistema de archivos compartido del nodo B… |
| 12 | Java | pág 6 der | Givens 1. public class Blip ( protected int blipvert(int x) ( retur 0; ) class Vert extends Blip ( // insert c… |
| 13 | APX | pág 7 izq | Los componentes de seguridad lógica que dan servicio a la arquitectura no están acoplados a la Arquitectura AP… |
| 14 | APX | pág 7 der | La información utilizada en la lógica de negocio de la transacción debe incluirse en. O Los archivos locales.… |
| 15 | APX | pág 8 | ¿Cuáles son las acciones posteriores a la ejecución de la lógica de negocio en la capa de Arquitectura de cont… |
| 16 | Java | pág 9 | 1. class Super protected superunt a thstaacp class Sub extends Super ( 12 public Sub(int a) (super(a):) H KNES… |
| 17 | APX | pág 10 izq | Selecciona las únicas excepciones que pueden ser capturadas y administradas por las aplicaciones, típicas de А… |
| 18 | Java | pág 10 der | Given public static void main(String[] args) { int [l] array2D = {{0, 1,2), {3,4, 5, 6l . System.out.print(arr… |
| 19 | Java | pág 11 izq | Which two statements are true? An interface CANNOT be extended by another interface. An abstract class can be… |
| 20 | Java | pág 11 der | Given: class Alpha ( String getType() { return "alpha"; } ) class Beta extends Alpha { String getType() { retu… |
| 21 | Java | pág 12 | Which three are bad practices? Checking for an IOException and ensuring that the program can recover if one oc… |
