import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Ejercicios {

  public static void main(String[] args) {
    /*
     * EJERCICIOS BASICOS
     */
    ejer1();
    ejer2();
    ejer3();
    ejer4();
    ejer5();
    ejer6();
    ejer7();
    ejer8();
    ejer9();
    ejer10();
  }

  private static void ejer10() {
    /*
     * Verificar si hay algún número negativo: Usa anyMatch() para comprobar si hay
     * un número negativo.
     */
    // CON NEGATIVOS
    List<Integer> numeros = Arrays.asList(5, -3, 12, 8, -7, 20, 0, 15);
    boolean hayNegativos = numeros.stream().anyMatch(n -> n < 0);
    System.out.println(hayNegativos);
    // SIN NEGATIVOS
    List<Integer> numeros2 = Arrays.asList(5, 3, 12, 8, 7, 20, 0, 15);
    boolean noNegativos = numeros2.stream().anyMatch(n -> n < 0);
    System.out.println(noNegativos);

  }

  private static void ejer9() {
    /*
     * Multiplicar cada número por 2: Usa map() para duplicar el valor de cada
     * número en una lista.
     */
    List<Integer> numeros = Arrays.asList(4, 8, 15, 16, 8, 23, 42, 15, 4, 23, 42, 50);
    List<Integer> mult = numeros.stream().map(n -> n * 2).toList();
    System.out.println("LISTA CON LOS NUMEROS MULTIPLICADOS * 2: " + mult);
  }

  private static void ejer8() {
    List<Integer> numeros = Arrays.asList(10, 20, 30, 40, 50);
    var first = numeros.stream().findFirst();
    System.out.println("PRIMER ELEMENTO DE LA LISTA: " + first);
  }

  private static void ejer7() {
    /*
     * Concatenar strings: Une una lista de palabras en una sola string separada por
     * comas.
     */
    List<String> palabras = Arrays.asList("Java", "Stream", "API", "Ejemplo", "Código");
    var union = palabras.stream().collect(Collectors.joining(","));
    System.out.println(union);
  }

  private static void ejer6() {
    /*
     * Eliminar duplicados: Usa distinct() para eliminar valores repetidos en una
     * lista.
     */
    List<Integer> numeros = Arrays.asList(4, 8, 15, 16, 8, 23, 42, 15, 4, 23, 42, 50);
    List<Integer> sinDuplicado = numeros.stream().distinct().toList();
    System.out.println("Lista sin duplicados: " + sinDuplicado);

  }

  private static void ejer5() {
    /*
     * Ordenar una lista de enteros: Ordena una lista de enteros de forma ascendente
     * con sorted().
     */
    List<Integer> numeros = Arrays.asList(3, 12, 7, 25, 18, 5, 30, 10, 22);
    List<Integer> orden = numeros.stream().sorted().toList();
    System.out.println("Lista Ordenada Ascendentemente" + orden);
  }

  private static void ejer4() {
    /*
     * Contar elementos mayores que 10: Filtra y cuenta cuántos números son mayores
     * a 10 en una lista.
     */
    List<Integer> numeros = Arrays.asList(3, 12, 7, 25, 18, 5, 30, 10, 22);
    var mayoresQue = numeros.stream().filter(n -> n > 10).count();
    System.out.println("Conteo de numeros mayores que 10: " + mayoresQue);
  }

  private static void ejer3() {
    /*
     * Sumar todos los elementos: Usa reduce() para sumar todos los números de una
     * lista.
     */
    List<Integer> numeros = Arrays.asList(5, 10, 15, 20, 25, 30);
    var suma = numeros.stream().reduce(0, Integer::sum);
    System.out.println(suma);

  }

  private static void ejer2() {
    /*
     * Convertir a mayúsculas: Dada una lista de strings, convierte cada elemento a
     * mayúsculas usando map().
     */
    List<String> palabras = Arrays.asList("java", "stream", "api", "ejemplo", "codigo");
    List<String> toUpper = palabras.stream().map(String::toUpperCase).collect(Collectors.toList());
    System.out.println(toUpper);

  }

  private static void ejer1() {
    /*
     * Filtrar números pares: Dado un List<Integer>, usa Stream para obtener solo
     * los números pares.
     */
    List<Integer> numeros = Arrays.asList(3, 8, 12, 5, 7, 10, 4, 15, 18, 20);
    List<Integer> pares = numeros.stream().filter(n -> n % 2 == 0).toList();
    System.out.println(pares);
  }
}