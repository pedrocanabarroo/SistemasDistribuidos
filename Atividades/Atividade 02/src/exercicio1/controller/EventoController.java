package exercicio1.controller;

import exercicio1.model.CaixaCentral;
import exercicio1.model.CaixaThread;
import exercicio1.view.EventoView;

/**
 * Controlador do sistema de caixa centralizado.
 *
 * <p>O controller cria as cinco threads, inicia a execução simultânea e usa
 * {@link Thread#join()} para aguardar o encerramento de todas antes de mostrar
 * o saldo final.</p>
 *
 * @author Pedro Henrique
 * @version 1.0
 */
public class EventoController {

    private final CaixaCentral model;
    private final EventoView view;

    private static final int QUANTIDADE_CAIXAS = 5;
    private static final int FICHAS_POR_CAIXA = 1000;
    private static final double VALOR_FICHA = 10.0;

    /**
     * Cria o controller com as referências do model e da view.
     *
     * @param model modelo que mantém o saldo compartilhado
     * @param view view responsável pelas mensagens no console
     */
    public EventoController(CaixaCentral model, EventoView view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Executa toda a simulação do exercício 1.
     */
    public void executar() {
        view.exibirInicio(QUANTIDADE_CAIXAS, FICHAS_POR_CAIXA, VALOR_FICHA);

        CaixaThread[] caixas = new CaixaThread[QUANTIDADE_CAIXAS];

        for (int i = 0; i < QUANTIDADE_CAIXAS; i++) {
            caixas[i] = new CaixaThread(
                    "Caixa-" + (i + 1),
                    model,
                    FICHAS_POR_CAIXA,
                    VALOR_FICHA
            );
            caixas[i].start();
        }

        try {
            for (CaixaThread caixa : caixas) {
                caixa.join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            view.exibirErroInterrupcao();
            return;
        }

        double saldoEsperado = QUANTIDADE_CAIXAS * FICHAS_POR_CAIXA * VALOR_FICHA;
        view.exibirResultado(model.getSaldoCentral(), saldoEsperado);
    }
}
