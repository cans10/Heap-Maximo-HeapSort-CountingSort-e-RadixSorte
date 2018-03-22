package Tarefa3;

/**
 *
 * @author Carlinhos
 */
public class HeapMaximo {

    public void heapMaximo(int[] vetor, int tam) {
        int aux;
        int pai = (tam / 2) - 1;

        while (pai >= 0) {
            int filhoEsq = pai * 2 + 1;
            int filhoDir = pai * 2 + 2;

//            this.imprimir("Índices: Pai = " + pai + " - FilhoEsq = " + filhoEsq + " - FilhoDir = " + filhoDir);

            // Verificando se existe filho da esquerda e se ele é maior do que o pai
            // se sim, faz a troca
            if (filhoEsq < tam) {

                if (vetor[filhoEsq] > vetor[pai]) {
//                    this.imprimir("1 - Trocou vetor[pai] [" + vetor[pai] + "] com vetor[filhoEsq] [" + vetor[filhoEsq] + "]");

                    aux = vetor[pai];
                    vetor[pai] = vetor[filhoEsq];
                    vetor[filhoEsq] = aux;
                }

                // Verificando se existe filho da direita e se ele é maior do que o pai
                // se sim, faz a troca
                if (filhoDir < tam) {
                    if (vetor[filhoDir] > vetor[pai]) {
//                        this.imprimir("2 - Trocou vetor[pai] [" + vetor[pai] + "] com vetor[filhoDir] [" + vetor[filhoDir] + "]");

                        aux = vetor[pai];
                        vetor[pai] = vetor[filhoDir];
                        vetor[filhoDir] = aux;
                    }

                    // para colocar o maior sempre na esquerda (Não é necessário para ordenação)
                    // Verificando se o filho da direita é maior que o filho da esquera
                    // se sim, faz a troca
//                    if (vetor[filhoDir] > vetor[filhoEsq]) {
//                        this.imprimir("3 - Trocou vetor[filhoEsq] [" + vetor[filhoEsq] + "] com vetor[filhoDir] [" + vetor[filhoDir] + "]");
//
//                        aux = vetor[filhoDir];
//                        vetor[filhoDir] = vetor[filhoEsq];
//                        vetor[filhoEsq] = aux;
//                    }
                }
            }

            pai--;
        }
    }

    public void imprimir(String a) {
//        System.out.println(a);
    }
}
