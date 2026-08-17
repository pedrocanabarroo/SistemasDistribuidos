package exercicio2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Modelo responsável pela criação dos dados de vendas das filiais.
 *
 * <p>Cada chamada de {@link #criarListaVendas(int, int, int, long)} cria uma
 * nova lista independente, garantindo que as filiais não compartilhem a mesma
 * coleção de registros.</p>
 *
 * @author Pedro Henrique
 * @version 1.0
 */
public class RelatorioVendasModel {

    /**
     * Cria o modelo responsável pelos dados das filiais.
     */
    public RelatorioVendasModel() {
    }

    /**
     * Cria uma lista independente de vendas inteiras em reais.
     *
     * @param quantidade quantidade de registros que serão gerados
     * @param valorMinimo menor valor possível para uma venda
     * @param valorMaximo maior valor possível para uma venda
     * @param seed semente usada pelo gerador pseudoaleatório
     * @return nova lista contendo os registros de vendas
     */
    public List<Integer> criarListaVendas(int quantidade, int valorMinimo,
                                          int valorMaximo, long seed) {
        List<Integer> vendas = new ArrayList<>();
        Random random = new Random(seed);

        for (int i = 0; i < quantidade; i++) {
            int valor = random.nextInt(valorMaximo - valorMinimo + 1) + valorMinimo;
            vendas.add(valor);
        }

        return vendas;
    }
}
