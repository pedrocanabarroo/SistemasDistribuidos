package exercicio2.view;

/**
 * View responsável por apresentar os dados do relatório de vendas.
 *
 * @author Pedro Henrique
 * @version 1.0
 */
public class RelatorioView {

    /**
     * Cria a view do exercício 2.
     */
    public RelatorioView() {
    }

    /**
     * Exibe o início do processamento das filiais.
     *
     * @param quantidadeFiliais quantidade de filiais processadas
     * @param registrosPorFilial quantidade de vendas existentes em cada filial
     */
    public void exibirInicio(int quantidadeFiliais, int registrosPorFilial) {
        System.out.println("=== RELATÓRIO DE VENDAS POR FILIAL ===");
        System.out.println("Filiais: " + quantidadeFiliais);
        System.out.println("Registros por filial: " + registrosPorFilial);
        System.out.println();
    }

    /**
     * Exibe o resultado local de uma filial.
     *
     * @param nomeFilial identificação da filial
     * @param resultado total de vendas calculado para a filial
     */
    public void exibirResultadoFilial(String nomeFilial, long resultado) {
        System.out.printf("%s -> R$ %,d%n", nomeFilial, resultado);
    }

    /**
     * Exibe o faturamento total obtido pela junção dos resultados locais.
     *
     * @param total soma final das quatro filiais
     */
    public void exibirTotal(long total) {
        System.out.printf("%nFaturamento total das filiais: R$ %,d%n", total);
    }

    /**
     * Exibe uma mensagem quando a thread principal é interrompida.
     */
    public void exibirErroInterrupcao() {
        System.out.println("A execução foi interrompida antes do término das threads.");
    }
}
