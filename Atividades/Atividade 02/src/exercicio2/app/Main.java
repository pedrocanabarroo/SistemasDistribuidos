package exercicio2.app;

import exercicio2.controller.RelatorioController;
import exercicio2.model.RelatorioVendasModel;
import exercicio2.view.RelatorioView;

/**
 * Classe principal do exercício 2.
 *
 * @author Pedro Henrique
 * @version 1.0
 */
public class Main {

    /**
     * Impede a instanciação da classe principal.
     */
    private Main() {
    }

    /**
     * Ponto de entrada do programa.
     *
     * @param args argumentos de linha de comando, não utilizados
     */
    public static void main(String[] args) {
        RelatorioVendasModel model = new RelatorioVendasModel();
        RelatorioView view = new RelatorioView();
        RelatorioController controller = new RelatorioController(model, view);

        controller.executar();
    }
}
