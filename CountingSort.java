package Tarefa3;

import Tarefa2.*;

/**
 *
 * @author Carlinhos
 */
public class CountingSort {

    int[] vetorA, vetorB;

    public int[] coutingSort(int[] vetor) {

        long tempoInicial, tempoFinal;
        tempoInicial = System.currentTimeMillis();

        // Verifica se o vetor é nulo ou está vazio
        if (vetor == null || vetor.length == 0) {
            return null;
        }
        this.vetorA = vetor;

        vetorB = new int[vetorA.length];
        this.ordenar();

        tempoFinal = System.currentTimeMillis();
        System.out.println("CountrySort:\nTempo de Ordenação = "
                + (tempoFinal - tempoInicial) + " milisegundo(s)");
        return vetorB;
    }

    private int[] ordenar() {
        int tamC = this.maiorValor();
        int[] vetorC = new int[tamC];
        int tamA = vetorA.length;
        int pos;

        // inicializando com 0 todo o vetorC
        for (int i = 0; i < tamC; i++) {
            vetorC[i] = 0;
        }

        // atribuindo a frequência dos elementos do vetor
        for (int i = 0; i < tamA; i++) {
            vetorC[vetorA[i]]++;
        }

        // fazendo o acumulo da frequência
        for (int i = 1; i < tamC; i++) {
            vetorC[i] += vetorC[i - 1];
        }

        // fazendo a atribuição ao vetorB dos valores do vetorA
        // conforme a sua frequencia acumulada;
        for (int i = tamA - 1; i >= 0; i--) {
            pos = vetorC[vetorA[i]] - 1;
            vetorB[pos] = vetorA[i];
            vetorC[vetorA[i]]--;
        }
        return vetorB;
    }

    private int maiorValor() {
        int maiorValor = 0;
        for (int i = 0; i < vetorA.length; i++) {
            if (vetorA[i] > maiorValor) {
                maiorValor = vetorA[i];
            }
        }
        return maiorValor + 1;
    }
}
