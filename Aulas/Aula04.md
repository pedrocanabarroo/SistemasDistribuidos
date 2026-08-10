# Aula 2

## Revisão sobre Arquiteturas

### Arquitetura Cliente-Servidor

- **Modelo centralizado:** um ou mais servidores fornecem serviços, dados ou recursos.
- **Clientes** solicitam serviços ou recursos aos servidores.
- Os servidores processam e respondem às requisições dos clientes.
- Comunicação baseada em requisição: o cliente faz o pedido e o servidor responde.
- Exemplo: navegador (cliente) acessando um servidor web.

#### Características

- **Centralização:** os servidores são o núcleo do sistema.
- **Dependência:** se o servidor falhar, o serviço pode ficar indisponível.
- **Gerenciamento:** administração centralizada e mais simples.

---

### Arquitetura Ponto a Ponto (P2P)

- **Modelo descentralizado:** todos os nós podem atuar como clientes e servidores.
- Cada nó pode solicitar e fornecer recursos diretamente a outros nós, sem um servidor central.
- Comunicação direta entre os pares.
- Exemplo: redes de compartilhamento de arquivos, como **BitTorrent**.

#### Características

- **Descentralização:** não existe ponto único de falha.
- **Escalabilidade:** o sistema cresce facilmente, pois cada nó contribui com recursos.
- **Resiliência:** a falha de um nó não interrompe o funcionamento do sistema.

---

## Exemplo de Threads em Java

### Classe da Thread

```java
import java.util.ArrayList;
import java.util.Random;

class TarefaPopular extends Thread {

    ArrayList<Integer> lista;
    int quantidade;

    public TarefaPopular(ArrayList<Integer> lista, int quantidade) {
        this.lista = lista;
        this.quantidade = quantidade;
    }

    @Override
    public void run() {
        Random gerador = new Random();

        for (int i = 0; i < quantidade; i++) {
            lista.add(gerador.nextInt(200));
        }
    }
}
```

### Classe Principal

```java
import java.util.ArrayList;
import java.util.Random;

public class ExemploThread {

    public static void main(String[] args) {

        ArrayList<Integer> listaA = new ArrayList<>();
        ArrayList<Integer> listaB = new ArrayList<>();
        Random gerador = new Random();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                listaB.add(gerador.nextInt(200));
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                listaB.add(gerador.nextInt(200));
            }
        });

        t1.start();
        t2.start();

        // Exemplo utilizando herança da classe Thread

        ArrayList<Integer> listaC = new ArrayList<>();
        ArrayList<Integer> listaD = new ArrayList<>();

        TarefaPopular t3 = new TarefaPopular(listaC, 500);
        TarefaPopular t4 = new TarefaPopular(listaD, 500);

        t3.start();
        t4.start();
    }
}
```

---

## Observações

- Uma thread pode ser criada implementando `Runnable` (expressões lambda) ou estendendo a classe `Thread`.
- O método `start()` inicia uma nova thread de execução, enquanto `run()` contém o código executado por ela.
- É necessário criar a `Thread` primeiro e chamar `start()` depois, pois `start()` retorna `void`.
- Quando várias threads acessam a mesma estrutura de dados (como um `ArrayList`), pode ocorrer **Race Condition**, sendo necessário utilizar sincronização ou coleções thread-safe.
