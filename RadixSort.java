package Tarefa3;

/**
 *
 * @author Carlinhos
 */
public class RadixSort {

    // Sort the numbers beginning with least-significant digit
    public int[] sort(int[] vetor) {
        long tempoInicial, tempoFinal;
        tempoInicial = System.currentTimeMillis();

        int quantCasasDecimais = this.casasDecimanis(vetor);

        for (int i = 1; i < quantCasasDecimais; i *= 10) {
            //Usando o countingSort para fazer a ordenação
            // Não é o implementado, pois tem uma pequena variação;
            vetor = countingSort(vetor, i);
        }

        tempoFinal = System.currentTimeMillis();
        System.out.println("RadixSort:\nTempo de Ordenação = "
                + (tempoFinal - tempoInicial) + " milisegundo(s)");
        return vetor;
    }

    private int[] countingSort(int[] vetorA, int lugar) {
//        imprimir("\nPOSIÇÃO DO CONTADOR\t0, 1, 2, 3, 4, 5, 6, 7, 8, 9, \n");
        int[] vetorB = new int[vetorA.length];

        int[] vetorC = new int[10];

        // atribuindo a frequência dos elementos do vetor
        for (int i = 0; i < vetorA.length; i++) {
            int digito = digito(vetorA[i], lugar); // informa qual é a casa decimal a ser usada
            vetorC[digito] += 1;
        }

//        this.imprimir("Frequencia Relativa", vetorC);
        // fazendo o acumulo da frequência
        for (int i = 1; i < vetorC.length; i++) {
            vetorC[i] += vetorC[i - 1];
        }
//        this.imprimir("Frquencia Acumlada", vetorC);

        // fazendo a atribuição ao vetorB dos valores do vetorA
        // conforme a sua frequencia acumulada e a posição do dígito em análise;
        for (int i = vetorA.length - 1; i >= 0; i--) {

            int digit = digito(vetorA[i], lugar); // informa qual é a casa decimal a ser usada
            int posicao = vetorC[digit] - 1; // informa qual é o índice
            vetorB[posicao] = vetorA[i]; // copia para o retorno o elemento do vetor[i]
            vetorC[digit]--; // decrementa a frequência acumulada daque posição
        }

//        this.imprimir("Retorno VetorB   ", vetorB);
//
//        imprimir("=======================================");
        return vetorB;

    }

    private int digito(int valor, int divisor) {
        int retorno = ((valor / divisor) % 10);
        return retorno;
    }

    public void imprimir(String nome, int[] vetor) {

        imprimir(nome + "\t");
        for (int i = 0; i < vetor.length; i++) {
            imprimir(vetor[i] + ", ");
            if ((i + 1) % 20 == 0) {
                imprimir("\n");
            }
        }
        imprimir("\n");
    }

    private void imprimir(String texto) {
//        System.out.print(texto);
    }

    private int casasDecimanis(int[] vetor) {
        int quant = 1, aux = 0;
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] > aux) {
                aux = vetor[i];
            }
        }

        while (true) {
            if (aux / quant < 1) {
                return quant;
            }
            quant *= 10;
        }
    }
}
