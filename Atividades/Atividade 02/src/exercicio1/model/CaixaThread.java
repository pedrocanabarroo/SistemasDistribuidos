package exercicio1.model;

/**
 * Thread que representa um caixa físico do festival.
 *
 * <p>Cada caixa realiza uma quantidade definida de vendas e atualiza o mesmo
 * objeto {@link CaixaCentral}.</p>
 *
 * @author Pedro Henrique
 * @version 1.0
 */
public class CaixaThread extends Thread {

    private final CaixaCentral caixaCentral;
    private final int quantidadeFichas;
    private final double valorFicha;

    /**
     * Cria uma thread que representa um caixa do evento.
     *
     * @param nomeCaixa nome usado para identificar a thread
     * @param caixaCentral objeto compartilhado que armazena o saldo do evento
     * @param quantidadeFichas quantidade de fichas que o caixa deverá vender
     * @param valorFicha valor unitário de cada ficha
     */
    public CaixaThread(String nomeCaixa, CaixaCentral caixaCentral,
                       int quantidadeFichas, double valorFicha) {
        super(nomeCaixa);
        this.caixaCentral = caixaCentral;
        this.quantidadeFichas = quantidadeFichas;
        this.valorFicha = valorFicha;
    }

    /**
     * Executa as vendas do caixa.
     *
     * <p>A cada venda, a thread solicita ao modelo compartilhado a atualização
     * sincronizada do saldo.</p>
     */
    @Override
    public void run() {
        for (int i = 0; i < quantidadeFichas; i++) {
            caixaCentral.adicionarVenda(valorFicha);
        }
    }
}
