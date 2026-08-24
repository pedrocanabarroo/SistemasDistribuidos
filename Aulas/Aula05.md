# Semana 3 — Aula 1

**Data:** 10/08  
**Tema:** Servidores multithread, identificação de threads e passagem de parâmetros

## Conteúdos

- Servidores multithread em Java, Python e C#;
- identificação de nome e ID das threads;
- passagem de parâmetros para threads;
- uso de `ExecutorService`, `Thread` e `threading.Thread`.

---

## Exemplos de Servidores em Threads

### 1. Java — Servidor simples multithread usando `ExecutorService`

Um servidor multithread pode utilizar um **pool de threads** para atender múltiplos clientes simultaneamente.

```java
import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class ServidorMultithread {
    private static final int PORTA = 12345;
    private static ExecutorService pool = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORTA);
        System.out.println("Servidor rodando na porta " + PORTA);

        while (true) {
            Socket clienteSocket = serverSocket.accept();
            pool.execute(new TratadorCliente(clienteSocket));
        }
    }
}

class TratadorCliente implements Runnable {
    private Socket socket;

    public TratadorCliente(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try (
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
            );
            PrintWriter out = new PrintWriter(
                socket.getOutputStream(), true
            )
        ) {
            String linha;

            while ((linha = in.readLine()) != null) {
                System.out.println("Recebido: " + linha);
                out.println("Eco: " + linha);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

#### Conceitos importantes

* `ExecutorService` gerencia um conjunto de threads.
* `Executors.newFixedThreadPool(5)` cria um pool com **5 threads**.
* Cada cliente recebido pelo servidor é encaminhado para uma tarefa.
* `pool.execute(...)` executa o tratamento do cliente em uma thread disponível.
* O servidor consegue atender vários clientes de forma concorrente.

---

### 2. Python — Servidor multithread com `threading`

Exemplo de servidor multithread para operações **I/O-bound**:

```python
import socket
import threading


def trata_cliente(conn, addr):
    print(f"Conexão de {addr}")

    with conn:
        while True:
            data = conn.recv(1024)

            if not data:
                break

            print(f"Recebido de {addr}: {data.decode()}")
            conn.sendall(b"Eco: " + data)


def servidor():
    HOST = "127.0.0.1"
    PORT = 12345

    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.bind((HOST, PORT))
        s.listen()

        print(f"Servidor rodando na porta {PORT}")

        while True:
            conn, addr = s.accept()

            thread = threading.Thread(
                target=trata_cliente,
                args=(conn, addr)
            )

            thread.start()


if __name__ == "__main__":
    servidor()
```

#### Conceitos importantes

* `threading.Thread` cria uma nova thread.
* Cada cliente conectado é tratado por uma thread separada.
* O servidor continua aceitando novas conexões enquanto outras threads estão trabalhando.
* Esse modelo é especialmente útil para tarefas **I/O-bound**, como comunicação de rede.

---

### 3. C# — Servidor TCP com Threads

```csharp
using System;
using System.Net;
using System.Net.Sockets;
using System.Text;
using System.Threading;

class Servidor
{
    public static void Main()
    {
        TcpListener listener =
            new TcpListener(IPAddress.Loopback, 12345);

        listener.Start();

        Console.WriteLine("Servidor rodando na porta 12345");

        while (true)
        {
            TcpClient client = listener.AcceptTcpClient();

            Thread thread = new Thread(
                () => TrataCliente(client)
            );

            thread.Start();
        }
    }

    static void TrataCliente(TcpClient client)
    {
        NetworkStream stream = client.GetStream();
        byte[] buffer = new byte[1024];
        int bytesRead;

        try
        {
            while (
                (bytesRead = stream.Read(
                    buffer, 0, buffer.Length
                )) != 0
            )
            {
                string data = Encoding.UTF8.GetString(
                    buffer, 0, bytesRead
                );

                Console.WriteLine($"Recebido: {data}");

                byte[] response = Encoding.UTF8.GetBytes(
                    "Eco: " + data
                );

                stream.Write(
                    response, 0, response.Length
                );
            }
        }
        catch (Exception e)
        {
            Console.WriteLine($"Erro: {e.Message}");
        }
        finally
        {
            client.Close();
        }
    }
}
```

---

## Threads e suas identificações

Quando as threads são disparadas, mesmo sem utilizar memória compartilhada, ainda é possível **identificar e monitorar qual thread está executando**.

Algumas informações importantes:

* **ID da thread:** número único associado à thread dentro do processo.
* **Nome da thread:** pode ser definido manualmente ou pelo sistema.

Essas informações são úteis para:

* Debug;
* Logging;
* Monitoramento;
* Sincronização;
* Identificação de problemas de concorrência.

---

### Java

Em Java, cada thread possui métodos para obter seu **ID** e **nome**.

```java
class MinhaTarefa implements Runnable {

    @Override
    public void run() {
        Thread t = Thread.currentThread();

        System.out.println(
            "Executando na Thread: " +
            t.getName() +
            " | ID: " +
            t.getId()
        );
    }
}

public class TesteThreads {
    public static void main(String[] args) {

        Thread t1 = new Thread(
            new MinhaTarefa(),
            "Tarefa-1"
        );

        Thread t2 = new Thread(
            new MinhaTarefa(),
            "Tarefa-2"
        );

        t1.start();
        t2.start();
    }
}
```

#### Saída esperada

```text
Executando na Thread: Tarefa-1 | ID: 13
Executando na Thread: Tarefa-2 | ID: 14
```

> **Importante:** os valores dos IDs são apenas exemplos. Eles podem variar a cada execução.

Para saber qual thread está executando o código, utilize:

```java
Thread.currentThread()
```

---

### Python

No Python, o módulo `threading` fornece `threading.current_thread()`.

```python
import threading
import time


def minha_tarefa(param):
    t = threading.current_thread()

    print(
        f"Thread {t.name} | "
        f"ID interno: {threading.get_ident()} | "
        f"Param: {param}"
    )

    time.sleep(1)


t1 = threading.Thread(
    target=minha_tarefa,
    args=("A",),
    name="Tarefa-1"
)

t2 = threading.Thread(
    target=minha_tarefa,
    args=("B",),
    name="Tarefa-2"
)

t1.start()
t2.start()
```

#### Saída esperada

```text
Thread Tarefa-1 | ID interno: 140463276087040 | Param: A
Thread Tarefa-2 | ID interno: 140463267694336 | Param: B
```

> **Importante:** os valores dos IDs são apenas exemplos e podem variar a cada execução.

No Python:

```python
threading.get_ident()
```

retorna um identificador numérico da thread dentro do processo.

---

### Resumo — Identificação da Thread

| Linguagem | Método para obter nome             | Método para obter ID                   |
| --------- | ---------------------------------- | -------------------------------------- |
| Java      | `Thread.currentThread().getName()` | `Thread.currentThread().getId()`       |
| C#        | `Thread.CurrentThread.Name`        | `Thread.CurrentThread.ManagedThreadId` |
| Python    | `threading.current_thread().name`  | `threading.get_ident()`                |

---

## Threads e Parâmetros

Além de identificar a thread, podemos passar **parâmetros específicos para cada thread**.

### Java

```java
class MinhaTarefa implements Runnable {

    private String parametro;

    public MinhaTarefa(String parametro) {
        this.parametro = parametro;
    }

    @Override
    public void run() {
        Thread t = Thread.currentThread();

        System.out.println(
            "Executando na Thread: " +
            t.getName() +
            " | ID: " +
            t.getId() +
            " | Param: " +
            parametro
        );
    }
}

public class TesteThreads {
    public static void main(String[] args) {

        Thread t1 = new Thread(
            new MinhaTarefa("A"),
            "Tarefa-1"
        );

        Thread t2 = new Thread(
            new MinhaTarefa("B"),
            "Tarefa-2"
        );

        t1.start();
        t2.start();
    }
}
```

#### Saída

```text
Executando na Thread: Tarefa-1 | ID: 13 | Param: A
Executando na Thread: Tarefa-2 | ID: 14 | Param: B
```

Cada objeto `MinhaTarefa` possui seu próprio parâmetro.

---

### Python

```python
import threading
import time


def minha_tarefa(param):
    t = threading.current_thread()

    print(
        f"Thread {t.name} | "
        f"ID interno: {threading.get_ident()} | "
        f"Param: {param}"
    )

    time.sleep(1)


# ATENÇÃO:
# args é uma tupla.
# Quando passamos apenas um parâmetro,
# é necessário colocar a vírgula.
t1 = threading.Thread(
    target=minha_tarefa,
    args=("A",),
    name="Tarefa-1"
)

t2 = threading.Thread(
    target=minha_tarefa,
    args=("B",),
    name="Tarefa-2"
)

t1.start()
t2.start()
```

#### Saída

```text
Thread Tarefa-1 | ID interno: 140463276087040 | Param: A
Thread Tarefa-2 | ID interno: 140463267694336 | Param: B
```

#### Atenção ao `args`

Quando uma thread recebe apenas **um parâmetro**, é necessário colocar uma vírgula para que o Python interprete o valor como uma tupla:

```python
args=("A",)
```

Sem a vírgula:

```python
args=("A")
```

isso é apenas uma string entre parênteses, e não uma tupla.

---
