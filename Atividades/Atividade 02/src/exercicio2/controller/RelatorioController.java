package exercicio2.controller;

import exercicio2.model.ProcessadorFilial;
import exercicio2.model.RelatorioVendasModel;
import exercicio2.view.RelatorioView;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller responsável por aplicar o padrão Fork-Join do exercício 2.
 *
 * <p>Primeiro o trabalho é dividido entre quatro threads independentes
 * (fork). Em seguida, a thread principal aguarda todas com {@code join()} e
 * combina os resultados locais (join).</p>
 *
 * @author Pedro Henrique
 * @version 1.0
 */
public class RelatorioController {

    private static final int QUANTIDADE_FILIAIS = 4;
    private static final int REGISTROS_POR_FILIAL = 10000;
    private static final int VENDA_MINIMA = 50;
    private static final int VENDA_MAXIMA = 500;

    private final RelatorioVendasModel model;
    private final RelatorioView view;

    /**
     * Cria o controller do relatório de vendas.
     *
     * @param model modelo usado para gerar as listas independentes
     * @param view view responsável por apresentar os resultados
     */
    public RelatorioController(RelatorioVendasModel model, RelatorioView view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Executa a criação das listas, o processamento paralelo e a junção dos
     * resultados finais.
     */
    public void executar() {
        view.exibirInicio(QUANTIDADE_FILIAIS, REGISTROS_POR_FILIAL);

        List<List<Integer>> listasFiliais = new ArrayList<>();

        for (int i = 0; i < QUANTIDADE_FILIAIS; i++) {
            listasFiliais.add(
                    model.criarListaVendas(
                            REGISTROS_POR_FILIAL,
                            VENDA_MINIMA,
                            VENDA_MAXIMA,
                            1000L + i
                    )
            );
        }

        ProcessadorFilial[] threads = new ProcessadorFilial[QUANTIDADE_FILIAIS];

        for (int i = 0; i < QUANTIDADE_FILIAIS; i++) {
            threads[i] = new ProcessadorFilial(
                    "Filial-" + (i + 1),
                    listasFiliais.get(i)
            );
            threads[i].start();
        }

        try {
            for (ProcessadorFilial thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            view.exibirErroInterrupcao();
            return;
        }

        long faturamentoTotal = 0;

        for (ProcessadorFilial thread : threads) {
            long resultado = thread.getResultadoLocal();
            view.exibirResultadoFilial(thread.getName(), resultado);
            faturamentoTotal += resultado;
        }

        view.exibirTotal(faturamentoTotal);
    }
}
