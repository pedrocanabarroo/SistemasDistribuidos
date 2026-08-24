# Semana 3 — Aula 2

**Tema:** Threads com memória compartilhada e sincronização

## Conteúdos

- memória compartilhada entre threads;
- sincronização com `synchronized` e `threading.Lock`;
- uso de `join()`;
- comparação entre threads com e sem memória compartilhada;
- condições de corrida, deadlocks e inconsistência de dados.

---

## Threads com Memória Compartilhada

### Java

Em Java, threads dentro da mesma **JVM** compartilham a memória do processo.

Por isso, quando várias threads acessam e modificam a mesma estrutura de dados, é necessário utilizar mecanismos de **sincronização** para evitar condições de corrida (*race conditions*).

#### Exemplo

```java
import java.util.ArrayList;
import java.util.List;

class ListaCompartilhada {

    private final List<Integer> numeros = new ArrayList<>();

    // Operação de escrita
    public synchronized void adicionarNumero(int umNumero) {
        numeros.add(umNumero);

        System.out.println(
            Thread.currentThread().getName() +
            " adicionou: " +
            umNumero
        );
    }

    // Operação de leitura
    public synchronized List<Integer> retornarNumeros() {
        return new ArrayList<>(numeros);
    }
}

class ThreadDeTrabalho extends Thread {

    private final ListaCompartilhada listaCompartilhada;
    private int quantidadeNumeros;

    public ThreadDeTrabalho(
        ListaCompartilhada lista,
        int quantidadeNumeros
    ) {
        this.listaCompartilhada = lista;
        this.quantidadeNumeros = quantidadeNumeros;
    }

    @Override
    public void run() {

        for (
            int i = 1;
            i <= this.quantidadeNumeros;
            i++
        ) {
            listaCompartilhada.adicionarNumero(i);

            try {
                Thread.sleep(50);
            } catch (InterruptedException ignored) {
            }
        }
    }
}

public class Principal {

    public static void main(String[] args)
        throws InterruptedException {

        ListaCompartilhada listaCompartilhada =
            new ListaCompartilhada();

        // Duas threads populam números inteiros
        // na mesma estrutura compartilhada.
        Thread t1 = new ThreadDeTrabalho(
            listaCompartilhada,
            5
        );

        Thread t2 = new ThreadDeTrabalho(
            listaCompartilhada,
            5
        );

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(
            "Lista final: " +
            listaCompartilhada.retornarNumeros()
        );
    }
}
```

#### Conceitos importantes

##### `private final`

```java
private final List<Integer> numeros = new ArrayList<>();
```

O `final` garante que a referência da variável `numeros` não será alterada depois da inicialização.

Isso **não significa que a lista é imutável**. A lista ainda pode receber novos elementos.

##### `synchronized`

```java
public synchronized void adicionarNumero(int umNumero)
```

O `synchronized` garante que apenas uma thread por vez execute o método sincronizado sobre aquela instância.

Isso ajuda a evitar problemas de concorrência.

##### `join()`

```java
t1.join();
t2.join();
```

Faz com que a thread principal espere as threads `t1` e `t2` terminarem antes de continuar.

---

### Python

No Python, threads também compartilham memória.

Por isso, quando várias threads acessam uma estrutura compartilhada, podemos utilizar `Lock` para proteger as operações.

```python
import threading
import time


class ListaCompartilhada:

    def __init__(self):
        self.numeros = []
        self.lock = threading.Lock()

    def adicionar_numeros(self, um_numero):
        with self.lock:
            self.numeros.append(um_numero)

            print(
                f"{threading.current_thread().name} "
                f"adicionou: {um_numero}"
            )

    def retornar_numeros(self):
        with self.lock:
            return list(self.numeros)


def operacao_trabalho(lista, quantidade_numeros):

    for i in range(1, quantidade_numeros):
        lista.adicionar_numeros(i)
        time.sleep(0.05)


if __name__ == "__main__":

    lista_compartilhada = ListaCompartilhada()

    t1 = threading.Thread(
        target=operacao_trabalho,
        args=(lista_compartilhada, 5)
    )

    t2 = threading.Thread(
        target=operacao_trabalho,
        args=(lista_compartilhada, 5)
    )

    t1.start()
    t2.start()

    t1.join()
    t2.join()

    print(
        "Lista final:",
        lista_compartilhada.retornar_numeros()
    )
```

#### Conceitos importantes

##### `threading.Lock()`

Cria um mecanismo de bloqueio que permite controlar o acesso à estrutura compartilhada.

```python
self.lock = threading.Lock()
```

##### `with self.lock`

O bloco protegido pelo `Lock` será executado com exclusão mútua:

```python
with self.lock:
    self.numeros.append(um_numero)
```

Isso evita que duas threads executem simultaneamente uma operação crítica sobre a mesma estrutura.

##### `join()`

Assim como no Java, `join()` faz a thread principal esperar a conclusão das outras threads:

```python
t1.join()
t2.join()
```

---

## Threads sem Memória Compartilhada × Threads com Memória Compartilhada

### Threads sem memória compartilhada

Cada thread trabalha com **parâmetros ou dados próprios**, por exemplo:

* Números;
* Strings;
* Objetos independentes;
* Estruturas que não são acessadas simultaneamente por outras threads.

#### Características

* Mais fáceis de implementar;
* Menor necessidade de sincronização;
* Menos propensas a condições de corrida;
* Menor risco de *deadlocks* relacionados ao compartilhamento de recursos.

---

### Threads com memória compartilhada

Duas ou mais threads acessam a **mesma estrutura de dados**, como:

* Lista;
* Dicionário;
* Objeto;
* Variável;
* Estrutura de dados compartilhada.

#### Características

* Podem ser mais eficientes em determinadas situações;
* Exigem cuidado com concorrência;
* Necessitam de mecanismos de sincronização quando há acesso concorrente a dados mutáveis.

#### Exemplos de mecanismos de sincronização

| Linguagem | Mecanismo        |
| --------- | ---------------- |
| Java      | `synchronized`   |
| C#        | `lock`           |
| Python    | `threading.Lock` |

#### Problemas que podem ocorrer

* **Race condition (condição de corrida):** duas ou mais threads acessam/modificam um recurso de forma concorrente e o resultado depende da ordem de execução.
* **Deadlock:** duas ou mais threads ficam bloqueadas esperando recursos que estão sendo mantidos umas pelas outras.
* **Inconsistência de dados:** uma thread pode observar dados em um estado inesperado caso o acesso não seja corretamente sincronizado.

---

## Resumo geral das duas aulas

> Esta seção reúne os principais conceitos trabalhados nas duas aulas.


### Servidores multithread

| Linguagem | Principal recurso            |
| --------- | ---------------------------- |
| Java      | `ExecutorService` / `Thread` |
| Python    | `threading.Thread`           |
| C#        | `Thread`                     |

### Identificação de threads

| Linguagem | Nome                               | ID                                     |
| --------- | ---------------------------------- | -------------------------------------- |
| Java      | `Thread.currentThread().getName()` | `Thread.currentThread().getId()`       |
| C#        | `Thread.CurrentThread.Name`        | `Thread.CurrentThread.ManagedThreadId` |
| Python    | `threading.current_thread().name`  | `threading.get_ident()`                |

### Memória compartilhada

| Linguagem | Sincronização    |
| --------- | ---------------- |
| Java      | `synchronized`   |
| C#        | `lock`           |
| Python    | `threading.Lock` |

### Ideia central

> **Threads podem executar tarefas concorrentemente, mas quando compartilham dados mutáveis é necessário controlar o acesso a esses dados para evitar condições de corrida e outros problemas de concorrência.**
