import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Main {

  public static void main(String[] args) throws InterruptedException {

    /* Inicia um valor final */
    int finalValue = 120;
    /* Inicia a quantidade de threads baseada na raiz do valor final */
    int qThreads = (int) Math.sqrt(finalValue);

    /*
     * Inicia o indice de analise na posição 2, visto que os valores 0 e 1 podem ser
     * desconsiderados
     */
    int startIndex = 2;

    /*
     * Inicia o vetor de primos de tamanho i+1 justamente para considerar a posição
     * final
     */
    boolean[] primeNumbers = new boolean[finalValue + 1];

    for (int i = 2; i <= finalValue; i++)
      primeNumbers[i] = true;

    /* Para contabilizar o tempo de execução */
    long startTime = System.currentTimeMillis();

    /* Inicia o vetor de threads */
    Crivo[] threads = new Crivo[qThreads];

    for (int i = 0; i < qThreads; i++) {

      if (primeNumbers[startIndex + i])
        threads[i] = new Crivo(i, startIndex + i, primeNumbers);
    }

    for (int i = 0; i < qThreads; i++)
      threads[i].start();

    for (int i = 0; i < qThreads; i++)
      threads[i].join();

    long endTime = System.currentTimeMillis();

    System.out.println("\nNúmeros primos até " + finalValue + ":");

    for (int i = 2; i < primeNumbers.length; i++) {
      if (primeNumbers[i])
        System.out.print(i + " ");
    }

    System.out.println(
        "\nTempo gasto para execução: " + new SimpleDateFormat("mm:ss.SSS").format(new Date(endTime - startTime)));

  }
}