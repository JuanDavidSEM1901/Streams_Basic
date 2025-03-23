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
    ejr6();
    ejr7();
    ejr8();
    ejr9();
    ejr10();
  }

  private static void ejr10() {
    /*
     * Verificar si todos los números de una lista son positivos: Usa allMatch().
     */
    List<Integer> numeros = Arrays.asList(5, 12, 8, 20, 33, 7, 15);
    var verificacion = numeros.stream().allMatch(n -> n > 0);
    System.out.println(verificacion);
  }

  private static void ejr9() {
    /*
     * Obtener la segunda palabra más corta: Usa sorted() y skip(1).findFirst().
     */
    List<String> palabras = Arrays.asList("manzana", "kiwi", "pera", "uva", "banana", "cereza", "higo");
    palabras.stream().sorted(Comparator.comparingInt(String::length)).skip(1).findFirst()
        .ifPresent(System.out::println);

  }

  private static void ejr8() {
    /*
     * Filtrar personas mayores de 18 años y obtener solo sus nombres: Trabaja con
     * una lista de objetos Persona.
     */
    class Persona {
      private String nombre;
      private int edad;

      // Constructor
      public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
      }

      // Getters
      public String getNombre() {
        return nombre;
      }

      public int getEdad() {
        return edad;
      }

      @Override
      public String toString() {
        return nombre + " (" + edad + " años)";
      }
    }

    List<Persona> personas = Arrays.asList(
        new Persona("Carlos", 17),
        new Persona("Andrea", 20),
        new Persona("Miguel", 15),
        new Persona("Sofía", 22),
        new Persona("Daniel", 18),
        new Persona("Lucía", 25));

    List<String> filter = personas.stream().filter(p -> p.getEdad() > 18).map(Persona::getNombre)
        .collect(Collectors.toList());
    System.out.println(filter);

  }

  private static void ejr7() {
    /*
     * Contar ocurrencias de cada palabra en una lista: Usa Collectors.toMap() para
     * hacer un conteo.
     */
    List<String> palabras = Arrays.asList("java", "stream", "api", "java", "codigo", "stream", "java", "ejemplo",
        "codigo", "stream");
    Map<String, Long> ocurrencias = palabras.stream()
        .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
    System.out.println(ocurrencias);
  }

  private static void ejr6() {
    /*
     * Juntar nombres con formato específico: Une una lista de nombres en una sola
     * string con joining(", ").
     * 
     */
    List<String> nombres = Arrays.asList("Carlos", "Andrea", "Miguel", "Sofía", "Daniel");
    String names = nombres.stream().collect(Collectors.joining(","));
    System.out.println(names);
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