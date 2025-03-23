import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ejercicios_Avanzados {

  public static void main(String[] args) {
    ejr1();
    ejr2();
    ejr3();
    ejr4();
    ejr5();
    ejr6();
    ejr7();
    ejr8();
    ejr9();

  }

  private static void ejr9() {
    List<Integer> numeros = Arrays.asList(12, 10, 15, 30, 9, 8, 45);

    numeros.stream().filter(n -> n % 3 == 0 || n % 5 == 0).findFirst().ifPresent(System.out::println);

  }

  private static void ejr8() {
    List<List<Integer>> listas = Arrays.asList(
        Arrays.asList(1, 2, 3),
        Arrays.asList(4, 5, 6),
        Arrays.asList(7, 8, 9));

    List<Integer> unaSola = listas.stream().flatMap(list -> list.stream()).toList();
    System.out.println(unaSola);
  }

  private static void ejr7() {
    List<String> palabras = Arrays.asList("elefante", "oso", "iguana", "universal", "agua");

    String result = palabras.stream()
        .flatMap(pal -> pal.chars().mapToObj(c -> (char) c))

        .map(Character::toLowerCase)
        .filter(c -> "aeiou".indexOf(c) != -1)

        .distinct()
        .sorted()
        .map(String::valueOf)
        .collect(Collectors.joining());

    System.out.println("Vocales únicas ordenadas: " + result);

  }

  private static void ejr6() {
    Map<Integer, Integer> nums = IntStream.rangeClosed(1, 10)
        .boxed()
        .collect(Collectors.toMap(num -> num, num -> num * num));

    nums.forEach((numero, cuadrado) -> {
      System.out.println("Numero: " + numero + " | Cuadrado: " + cuadrado);
    });

  }

  private static void ejr5() {

    List<Integer> numeros = Arrays.asList(12, 5, 8, 19, 25, 30, 15, 50, 45, 40);
    var media = numeros.stream().mapToInt(Integer::intValue).average().orElse(0);
    System.out.println(media);
  }

  private static void ejr4() {
    class Producto {
      private String nombre;
      private double precio;

      public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
      }

      public double getPrecio() {
        return precio;
      }

      public String getNombre() {
        return nombre;
      }

      @Override
      public String toString() {
        return nombre + " - $" + precio;
      }
    }

    List<Producto> productos = Arrays.asList(
        new Producto("Laptop", 1500),
        new Producto("Celular", 800),
        new Producto("Tablet", 600),
        new Producto("Monitor", 300),
        new Producto("Teclado", 100),
        new Producto("Mouse", 50),
        new Producto("Silla Gamer", 200));
    var orden = productos.stream().sorted(Comparator.comparingDouble(Producto::getPrecio).reversed()).limit(5).toList();
    System.out.println(orden);
  }

  private static void ejr3() {
    class Empleado {
      private String nombre;
      private double salario;
      private int edad;

      public Empleado(String nombre, double salario, int edad) {
        this.nombre = nombre;
        this.salario = salario;
        this.edad = edad;
      }

      public double getSalario() {
        return salario;
      }

      public int getEdad() {
        return edad;
      }

      public String getNombre() {
        return nombre;
      }

      @Override
      public String toString() {
        return nombre + " - $" + salario + " - " + edad + " años";
      }
    }

    List<Empleado> empleados = Arrays.asList(
        new Empleado("Carlos", 5000, 30),
        new Empleado("Ana", 7000, 25),
        new Empleado("Miguel", 7000, 28),
        new Empleado("Sofía", 4500, 22),
        new Empleado("Daniel", 5000, 35));
    var orden = empleados.stream()
        .sorted(Comparator.comparingDouble(Empleado::getSalario).thenComparingInt(Empleado::getEdad).reversed())
        .toList();
    System.out.println(orden);
  }

  private static void ejr2() {
    /*
     * Encontrar la palabra más larga en un texto: Usa flatMap() y reduce().
     */
    String texto = "Java es un lenguaje de programación potente y versátil utilizado en diversas aplicaciones.";

    Optional<String> palabraMasLarga = Arrays.stream(texto.split("\\s+")) // Divide en palabras
        .map(palabra -> palabra.replaceAll("[^a-zA-Z]", "")) // Limpia signos de puntuación
        .reduce((palabra1, palabra2) -> palabra1.length() >= palabra2.length() ? palabra1 : palabra2);
    palabraMasLarga.ifPresent(System.out::println);
  }

  private static void ejr1() {
    /*
     * Agrupar y contar palabras por longitud: Usa Collectors.groupingBy() para
     * hacer un mapa con el tamaño de las palabras y la cantidad de veces que
     * aparecen.
     */
    List<String> palabras = Arrays.asList("java", "stream", "api", "codigo", "ejemplo", "map", "stream", "codigo",
        "api");

    Map<Integer, Long> agrup = palabras.stream().collect(Collectors.groupingBy(String::length, Collectors.counting()));
    System.out.println(agrup);
  }
}