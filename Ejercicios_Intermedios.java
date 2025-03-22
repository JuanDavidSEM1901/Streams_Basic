import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ejercicios_Intermedios {

  public static void main(String[] args) {
    ejr1();
    ejr2();
    ejer3();
    ejr4();
    ejr5();
  }

  private static void ejr5() {
    /*
     * Obtener los 3 números más grandes: Usa sorted().limit(3) para encontrar los
     * tres números más altos.
     */
    List<Integer> numeros = Arrays.asList(25, 78, 12, 90, 34, 67, 89, 100, 45);
    List<Integer> masGrandes = numeros.stream().sorted(Comparator.reverseOrder()).limit(3).toList();
    System.out.println("3 numeros mas grandes de la lista: " + masGrandes);
  }

  private static void ejr4() {
    /*
     * Convertir un List<String> en un List<Integer> con la longitud de cada
     * palabra.
     */
    List<String> palabras = Arrays.asList("Java", "Stream", "API", "Ejemplo", "Código");

    List<Integer> conversion = palabras.stream().map(palabra -> palabra.length()).toList();

    System.out.println(conversion);
  }

  private static void ejer3() {
    /*
     * Obtener el promedio de una lista de números: Usa average() sobre un
     * IntStream.
     */
    List<Integer> numeros = Arrays.asList(10, 20, 30, 40, 50, 60);
    Double promedio = numeros.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    System.out.println("El promedio es: " + promedio);
  }

  private static void ejr2() {
    /*
     * Agrupar palabras por su primera letra: Usa Collectors.groupingBy() para
     * agrupar palabras según su primera letra.
     */
    List<String> palabras = Arrays.asList("manzana", "mango", "pera", "piña", "papaya", "fresa", "frambuesa", "melón",
        "durazno");

    Map<Character, List<String>> grupedByLetter = palabras.stream().collect(Collectors.groupingBy(l -> l.charAt(0)));
    grupedByLetter.forEach((letra, lista) -> {
      System.out.println("Letra: " + letra + " | Lista: " + lista);
    });
  }

  private static void ejr1() {
    /*
     * Obtener el número más grande: Usa max() para encontrar el mayor número en una
     * lista.
     */
    List<Integer> numeros = Arrays.asList(10, 45, 78, 23, 89, 56, 12, 99, 34);
    Integer max = numeros.stream().max(Integer::compare).get();
    System.out.println("Numero maximo de la lista: " + max);
  }
}