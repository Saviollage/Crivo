
public class Crivo extends Thread {

    private int id, step;
    private boolean[] primeNumbers;

    public  Crivo(int id, int step, boolean[] primeNumbers) {
        this.id = id;
        this.step = step;
        this.primeNumbers = primeNumbers;
    }

    public void run() {
        /* Função chamada pelo método start(), iniciando a thread */
        System.out.println("Thread " + id + " iniciada");

        for (int i = step; i < primeNumbers.length; i += step) {
            if (i != step)
                primeNumbers[i] = false;
        }
    }
}