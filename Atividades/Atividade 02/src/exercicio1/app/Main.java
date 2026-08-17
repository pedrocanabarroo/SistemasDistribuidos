package exercicio1.app;

import exercicio1.controller.EventoController;
import exercicio1.model.CaixaCentral;
import exercicio1.view.EventoView;

/**
 * Classe principal do exercício 1.
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
        CaixaCentral model = new CaixaCentral();
        EventoView view = new EventoView();
        EventoController controller = new EventoController(model, view);

        controller.executar();
    }
}
