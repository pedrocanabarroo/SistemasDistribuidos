package exercicio2.model;

import java.util.List;

/**
 * Thread responsável por processar exclusivamente os dados de uma filial.
 *
 * <p>A thread recebe sua própria lista no construtor, calcula a soma localmente
 * e armazena apenas o resultado em um atributo do próprio objeto. Durante o
 * processamento, não acessa variáveis globais nem dados de outras filiais.</p>
 *
 * @author Pedro Henrique
 * @version 1.0
 */
public class ProcessadorFilial extends Thread {

    private final List<Integer> vendas;
    private long resultadoLocal;

    /**
     * Cria uma thread para processar uma única filial.
     *
     * @param nomeFilial nome utilizado para identificar a thread
     * @param vendas lista exclusiva com as vendas da filial
     */
    public ProcessadorFilial(String nomeFilial, List<Integer> vendas) {
        super(nomeFilial);
        this.vendas = vendas;
        this.resultadoLocal = 0;
    }

    /**
     * Soma todos os registros pertencentes à filial.
     */
    @Override
    public void run() {
        long soma = 0;

        for (int valor : vendas) {
            soma += valor;
        }

        resultadoLocal = soma;
    }

    /**
     * Retorna o resultado calculado pela thread.
     *
     * <p>Este método deve ser consultado pela thread principal após o uso de
     * {@link Thread#join()}.</p>
     *
     * @return soma das vendas da filial
     */
    public long getResultadoLocal() {
        return resultadoLocal;
    }
}
