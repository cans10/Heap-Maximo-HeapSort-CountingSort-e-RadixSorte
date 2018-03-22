package Tarefa3;

/**
 *
 * @author Carlinhos
 */
public class HeapSort {

    private HeapMaximo heapMaximo;

    public HeapSort() {
        heapMaximo = new HeapMaximo();
    }

    public int[] heapSort(int[] vetor, int tam) {
        long tempoInicial, tempoFinal;
        tempoInicial = System.currentTimeMillis();

        int aux;
        while (tam > 1) {

            // chama o heapMaximo, passando com parâmetro índice até onde ele deve
            // formar a árvore.
            // OBS: a cada iteração, ordena o maior valor e decrementa o tamanho
            heapMaximo.heapMaximo(vetor, tam);

            // troca o primeiro termo, que é o maior, com o último.
            // nessa troca, ele já fica ordenado            
            aux = vetor[0];
            vetor[0] = vetor[tam - 1];
            vetor[tam - 1] = aux;

            // depois decrementa o tamanho e chama o heapMaximo novamente
            tam--;

            // encerra o loop, quando o tamanho for maior que 1;
        }

        tempoFinal = System.currentTimeMillis();
        System.out.println("HeapSort:\nTempo de Ordenação = "
                + (tempoFinal - tempoInicial) + " milisegundo(s)");

        return vetor;
    }
}
