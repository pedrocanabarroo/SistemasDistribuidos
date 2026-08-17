package exercicio1.model;

/**
 * Representa o caixa centralizado do evento.
 *
 * <p>O saldo é compartilhado por todas as threads que representam os caixas
 * físicos. O método de atualização é sincronizado para impedir condições de
 * corrida durante as vendas simultâneas.</p>
 *
 * @author Pedro Henrique
 * @version 1.0
 */
public class CaixaCentral {

    /** Saldo compartilhado entre todos os caixas do evento. */
    private double saldo_central;

    /**
     * Cria um caixa central com saldo inicial igual a zero.
     */
    public CaixaCentral() {
        this.saldo_central = 0.0;
    }

    /**
     * Adiciona ao saldo central o valor obtido em uma venda.
     *
     * <p>O modificador {@code synchronized} garante que apenas uma thread por
     * vez execute a alteração do saldo, evitando perda de atualizações.</p>
     *
     * @param valor valor da venda que será somado ao saldo central
     */
    public synchronized void adicionarVenda(double valor) {
        saldo_central += valor;
    }

    /**
     * Retorna o saldo atual do evento.
     *
     * @return saldo central atual
     */
    public synchronized double getSaldoCentral() {
        return saldo_central;
    }
}
