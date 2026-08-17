package exercicio1.view;

/**
 * Responsável pela apresentação das informações do exercício 1.
 *
 * @author Pedro Henrique
 * @version 1.0
 */
public class EventoView {

    /**
     * Cria a view do exercício 1.
     */
    public EventoView() {
    }

    /**
     * Exibe uma mensagem informando o início da simulação.
     *
     * @param quantidadeCaixas quantidade de caixas executados simultaneamente
     * @param fichasPorCaixa quantidade de fichas vendidas por cada caixa
     * @param valorFicha valor de cada ficha
     */
    public void exibirInicio(int quantidadeCaixas, int fichasPorCaixa, double valorFicha) {
        System.out.println("=== SISTEMA DE CAIXA CENTRALIZADO ===");
        System.out.println("Caixas: " + quantidadeCaixas);
        System.out.println("Fichas por caixa: " + fichasPorCaixa);
        System.out.printf("Valor da ficha: R$ %.2f%n%n", valorFicha);
    }

    /**
     * Exibe o saldo central obtido ao final da execução.
     *
     * @param saldo saldo central final
     * @param saldoEsperado saldo que deveria ser obtido
     */
    public void exibirResultado(double saldo, double saldoEsperado) {
        System.out.printf("Saldo final: R$ %.2f%n", saldo);
        System.out.printf("Saldo esperado: R$ %.2f%n", saldoEsperado);

        if (saldo == saldoEsperado) {
            System.out.println("Resultado correto: o saldo permaneceu consistente.");
        } else {
            System.out.println("Resultado incorreto: ocorreu inconsistência no saldo.");
        }
    }

    /**
     * Exibe uma mensagem quando a thread principal é interrompida.
     */
    public void exibirErroInterrupcao() {
        System.out.println("A execução foi interrompida antes do término das threads.");
    }
}
