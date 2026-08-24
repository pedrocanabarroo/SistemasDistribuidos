# Resumo para a Avaliação — Sistemas Distribuídos

## 1. O que são Sistemas Distribuídos?

Um **sistema distribuído** é formado por dois ou mais computadores ou equipamentos independentes que trabalham em conjunto através de uma rede.

Cada máquina possui seus próprios recursos, como processador, memória RAM e armazenamento, mas pode disponibilizar esses recursos para outras máquinas do sistema.

A ideia principal é fazer com que vários computadores cooperem para realizar determinadas tarefas.

### Principal objetivo

O objetivo principal dos sistemas distribuídos é o **compartilhamento de recursos**:

| Recurso | O que pode ser compartilhado |
|---|---|
| CPU | Poder de processamento |
| RAM | Recursos de memória |
| Memória secundária | Arquivos, bancos de dados e armazenamento |

### Exemplo

Imagine três computadores:

```text
Computador A
CPU: 4 núcleos

Computador B
CPU: 8 núcleos

Computador C
CPU: 4 núcleos
```

Em vez de apenas um computador realizar uma tarefa pesada, o processamento pode ser distribuído entre várias máquinas.

```text
Tarefa

        ↓

---------------------
|        |          |
PC A     PC B       PC C
Parte 1  Parte 2    Parte 3
```

Depois, os resultados podem ser reunidos.

---

## 2. Grid Computing

Um **Grid** utiliza recursos computacionais de várias máquinas conectadas através de uma rede.

Essas máquinas podem estar fisicamente distantes e não necessariamente possuem o mesmo hardware ou sistema operacional.

No conteúdo da disciplina, o Grid está associado principalmente à **computação concomitante**.

### Exemplo

Um projeto científico precisa realizar milhares de cálculos.

```text
Computador A → tarefa 1

Computador B → tarefa 2

Computador C → tarefa 3

Computador D → tarefa 4
```

Cada computador realiza uma tarefa ou parte de uma tarefa.

Uma característica importante é que os computadores podem estar em locais diferentes.

---

## 3. Cluster Computing

Um **Cluster** é formado por vários computadores conectados, normalmente próximos fisicamente e com comunicação rápida.

Eles trabalham em conjunto como se fossem um único grande sistema computacional.

No conteúdo da disciplina, o Cluster está relacionado principalmente à **computação paralela**.

### Exemplo

```text
            Servidor
               |
      -------------------
      |        |        |
     PC1      PC2      PC3
```

Uma grande tarefa pode ser dividida entre os processadores.

```text
Problema

   ↓

Parte 1 → CPU 1
Parte 2 → CPU 2
Parte 3 → CPU 3
Parte 4 → CPU 4

   ↓

Resultado final
```

Clusters são muito utilizados em processamento científico, inteligência artificial, simulações e aplicações que exigem grande capacidade de processamento.

---

## 4. Grid x Cluster

| Característica | Grid | Cluster |
|---|---|---|
| Máquinas | Podem estar distantes | Normalmente próximas |
| Hardware | Pode ser diferente | Frequentemente semelhante |
| Comunicação | Pela rede | Rede normalmente rápida |
| Organização | Mais distribuída | Mais integrada |
| Associação na disciplina | Computação concomitante | Computação paralela |
| Objetivo | Compartilhar recursos/tarefas | Aumentar capacidade de processamento |

Para a avaliação, uma associação importante é:

```text
GRID
↓
Computação concomitante
↓
Threads
```

e:

```text
CLUSTER
↓
Computação paralela
↓
CUDA / OpenMP / MPI
```

---

## 5. Programação Concomitante

Na **programação concomitante**, várias tarefas avançam durante o mesmo período.

Elas não precisam necessariamente estar executando exatamente no mesmo instante.

Um dos principais mecanismos utilizados para isso são as **Threads**.

### Exemplo

Imagine um programa executando:

```text
Thread 1 → recebe dados da rede

Thread 2 → processa informações

Thread 3 → atualiza a interface
```

Mesmo que exista apenas uma CPU, o sistema operacional pode alternar rapidamente entre as Threads.

Visualmente:

```text
Tempo →

Thread 1: ███     ███
Thread 2:    ███     ███
Thread 3:       ███
```

Temos várias tarefas progredindo no mesmo intervalo de tempo.

---

## 6. Programação Paralela

Na programação paralela, duas ou mais operações são realmente executadas **ao mesmo tempo**, utilizando diferentes unidades de processamento.

### Exemplo

```text
CPU 1 → calcula parte A

CPU 2 → calcula parte B

CPU 3 → calcula parte C

CPU 4 → calcula parte D
```

Isso é possível quando existem vários núcleos, processadores ou máquinas trabalhando simultaneamente.

### Tecnologias importantes

| Tecnologia | Principal utilização |
|---|---|
| CUDA | Processamento paralelo utilizando GPUs NVIDIA |
| OpenMP | Paralelismo principalmente em memória compartilhada |
| MPI | Comunicação entre processos, muito utilizado em clusters |

### Exemplo com GPU

Uma GPU possui muitos núcleos capazes de executar várias operações simultaneamente.

```text
Dados

 ↓

--------------------------
GPU
--------------------------
Core 1 → cálculo
Core 2 → cálculo
Core 3 → cálculo
Core 4 → cálculo
...
--------------------------

 ↓

Resultado
```

CUDA permite utilizar essa capacidade das GPUs.

---

## 7. Concomitante x Paralelo

Essa diferença é muito importante.

| Concomitante | Paralelo |
|---|---|
| Várias tarefas avançam | Várias tarefas executam simultaneamente |
| Pode utilizar uma única CPU | Normalmente utiliza vários núcleos/processadores |
| Muito relacionado a Threads | Relacionado a processamento paralelo |
| Foco em organização das tarefas | Foco em desempenho |
| Ex.: Threads | Ex.: CUDA, OpenMP, MPI |

Uma forma simples de lembrar:

> **Concomitância = várias tarefas sendo administradas.**

> **Paralelismo = várias tarefas realmente executando ao mesmo tempo.**

---

## 8. Comunicação em Sistemas Distribuídos

Como os computadores de um sistema distribuído são independentes, eles precisam se comunicar através de uma **rede**.

Para isso, utilizamos protocolos.

O principal modelo abordado é o:

```text
TCP/IP
```

Na comunicação devemos conhecer principalmente:

```text
Endereço IP
      +
Porta
      +
Máscara de rede
      +
Socket
      +
TCP ou UDP
```

---

## 9. Endereço IP

O **endereço IP** identifica um equipamento dentro de uma rede.

### Exemplo

```text
192.168.1.10
```

Podemos imaginar o IP como o endereço de uma residência.

```text
IP → identifica o computador
```

Se vários computadores estiverem conectados:

```text
PC 1 → 192.168.1.10
PC 2 → 192.168.1.11
PC 3 → 192.168.1.12
```

Cada equipamento possui sua identificação.

---

## 10. Porta

O IP identifica o computador.

Mas um computador pode executar vários programas ao mesmo tempo.

A **porta** serve para identificar qual programa ou serviço deverá receber os dados.

### Exemplo

```text
Computador

IP: 192.168.1.10
```

Pode ter:

```text
Porta 80   → servidor HTTP
Porta 443  → servidor HTTPS
Porta 3306 → MySQL
```

Portanto:

```text
IP
↓
Encontra o computador

Porta
↓
Encontra a aplicação
```

---

## 11. Máscara de Rede

A **máscara de rede** ajuda a determinar qual parte de um endereço IP representa a rede e qual parte representa o dispositivo.

### Exemplo

```text
IP:
192.168.1.10

Máscara:
255.255.255.0
```

Nesse exemplo, dispositivos como:

```text
192.168.1.1
192.168.1.20
192.168.1.50
```

estão, considerando essa configuração, na mesma rede `192.168.1.x`.

---

## 12. Socket

Um **socket** é um ponto de comunicação utilizado por aplicações.

Para a disciplina, pense principalmente em:

```text
Socket = IP + Porta
```

### Exemplo

```text
192.168.1.10:5000
```

Onde:

```text
192.168.1.10 → computador

5000 → aplicação
```

Em uma arquitetura cliente-servidor:

```text
CLIENTE

Socket
   |
   | comunicação
   ↓

SERVIDOR
IP: 192.168.1.10
Porta: 5000
```

O servidor normalmente cria um socket e fica aguardando conexões de clientes.

---

## 13. Camada de Transporte

Na comunicação TCP/IP, dois protocolos importantes da camada de transporte são:

```text
TCP
UDP
```

Eles possuem características diferentes.

---

## 14. TCP

O **TCP — Transmission Control Protocol** é um protocolo orientado à conexão e confiável.

Ele busca garantir que os dados:

- cheguem ao destino;
- cheguem corretamente;
- sejam entregues na ordem adequada.

### Exemplo

Imagine enviar:

```text
Pacote 1
Pacote 2
Pacote 3
```

Se o pacote 2 for perdido:

```text
Pacote 1 → chegou

Pacote 2 → perdido

Pacote 3 → chegou
```

O TCP pode identificar o problema e providenciar o reenvio.

É adequado quando perder dados seria problemático.

Exemplos comuns:

```text
Arquivos
Sites
E-mails
Sistemas bancários
```

---

## 15. UDP

O **UDP — User Datagram Protocol** possui uma comunicação mais simples.

Ele não possui os mesmos mecanismos de garantia de entrega do TCP.

Isso reduz o overhead e pode proporcionar menor latência.

### Exemplo

```text
Pacote 1 → chegou
Pacote 2 → perdido
Pacote 3 → chegou
```

O UDP não necessariamente solicita novamente o pacote perdido.

É interessante quando velocidade e baixa latência são mais importantes do que garantir cada pacote.

Exemplos:

```text
Jogos online
Streaming em tempo real
Chamadas de voz/vídeo
```

---

## 16. TCP x UDP

| TCP | UDP |
|---|---|
| Orientado à conexão | Não orientado à conexão |
| Confiável | Não garante entrega |
| Controla ordem | Não garante ordem |
| Possui mais controle | Possui menos overhead |
| Pode retransmitir | Não possui retransmissão automática do protocolo |
| Maior overhead | Menor overhead |
| Arquivos, web etc. | Jogos, streaming etc. |

Uma maneira simples de lembrar:

```text
TCP
→ segurança/confiabilidade

UDP
→ velocidade/baixa latência
```

---

## 17. Comunicação: Produtor e Consumidor

Dentro da comunicação podemos pensar em dois papéis.

### Produtor

É quem **produz, escreve ou envia** informações.

```text
PRODUTOR
   ↓
Escreve dados
   ↓
Comunicação
```

### Consumidor

É quem **lê, recebe ou consome** informações.

```text
Comunicação
   ↓
Lê dados
   ↓
CONSUMIDOR
```

Assim:

```text
PRODUTOR
   |
   | envia
   ↓
[ dados ]
   |
   | recebe
   ↓
CONSUMIDOR
```

---

## 18. Comunicação Bloqueante

Um conceito importante para a avaliação é que determinadas operações de comunicação são **bloqueantes**.

Isso significa que uma operação pode ficar esperando até que determinado evento aconteça.

Imagine:

```text
Consumidor

read()
```

Se ainda não existem dados:

```text
read()

↓

esperando...

↓

esperando...

↓

dados chegaram

↓

continua
```

Enquanto espera, aquela execução não continua para a próxima instrução.

### Exemplo

```text
Servidor:

Cliente ainda não enviou mensagem.

↓
read()

↓
Servidor espera

↓
Cliente envia mensagem

↓
read() recebe

↓
Servidor continua
```

Esse comportamento pode criar problemas porque um programa poderia ficar completamente parado esperando uma comunicação.

É aí que as **Threads** se tornam importantes.

---

## 19. Threads

Uma **Thread** pode ser entendida como uma unidade de execução dentro de um processo.

No conteúdo da disciplina, pode ser pensada como um **“mini processo” concomitante**.

Um programa pode ter várias Threads executando diferentes rotinas.

```text
PROCESSO

├── Thread 1
├── Thread 2
├── Thread 3
└── Thread 4
```

Todas pertencem ao mesmo processo.

---

## 20. Threads e Comunicação Bloqueante

Imagine um servidor sem Threads:

```text
Servidor
   ↓
espera cliente
   ↓
recebe cliente
   ↓
espera mensagem
   ↓
processa
```

Se a operação de leitura ficar bloqueada, o servidor pode não conseguir executar outras tarefas naquele fluxo.

Com Threads:

```text
Servidor principal

      ↓

Cliente A → Thread 1

Cliente B → Thread 2

Cliente C → Thread 3
```

Se:

```text
Thread 1
```

ficar esperando dados de um cliente, as outras Threads ainda podem continuar trabalhando.

> **Importante:** a Thread não transforma necessariamente a operação bloqueante em uma operação não bloqueante. Ela permite que uma Thread fique bloqueada enquanto outras continuam executando.

---

## 21. Delegar uma Rotina para uma Thread

Podemos pegar uma rotina ou tarefa e pedir para uma Thread executá-la.

Conceitualmente:

```text
Programa principal
      |
      | delega
      ↓
    Thread
      |
      ↓
executa rotina
```

Por exemplo:

```text
Rotina:
atenderCliente()
```

Pode ser executada por:

```text
Thread 1 → atenderCliente(cliente1)

Thread 2 → atenderCliente(cliente2)
```

Dessa forma, vários clientes podem ser tratados concomitantemente.

---

## 22. Parâmetros nas Threads

Também é possível passar informações específicas para uma Thread.

### Exemplo

```text
Thread 1
cliente = "Cliente A"

Thread 2
cliente = "Cliente B"
```

Mesmo executando a mesma rotina:

```text
atenderCliente(cliente)
```

cada Thread recebe parâmetros diferentes.

Portanto:

```text
Rotina igual
+
Parâmetros diferentes
=
Trabalhos diferentes
```

---

## 23. Identificação das Threads

Cada Thread pode possuir uma identificação.

Podemos identificar, por exemplo:

```text
Thread 1
Thread 2
Thread 3
```

ou nomes:

```text
Cliente-1
Cliente-2
Cliente-3
```

Isso é útil principalmente para:

- saber qual Thread está executando;
- realizar debug;
- gerar logs;
- analisar problemas de concorrência.

Em Java, por exemplo:

```java
Thread.currentThread().getName()
```

permite obter o nome da Thread atual.

---

## 24. Threads sem Memória Compartilhada

Uma Thread pode executar uma tarefa utilizando apenas seus próprios dados.

### Exemplo

```text
Thread 1
↓
Lista A
↓
Calcula soma
```

e:

```text
Thread 2
↓
Lista B
↓
Calcula soma
```

Nesse caso:

```text
Thread 1 não altera dados da Thread 2

Thread 2 não altera dados da Thread 1
```

Isso reduz os problemas relacionados à concorrência.

Podemos resumir como:

```text
THREAD SEM MEMÓRIA COMPARTILHADA

rotina/tarefa
+
dados próprios
```

---

## 25. Threads com Memória Compartilhada

Agora imagine:

```text
Variável compartilhada:

saldo = 1000
```

Duas Threads utilizam essa mesma variável:

```text
Thread A ──┐
           ↓
        saldo
           ↑
Thread B ──┘
```

As duas podem acessar e modificar o mesmo recurso.

Isso cria um problema potencial.

### Exemplo

```text
Thread A → saldo = saldo + 100

Thread B → saldo = saldo + 200
```

Se as operações acontecerem de maneira inadequada, o valor final pode ser incorreto.

---

## 26. Seção Crítica

Quando várias Threads compartilham memória, existe um trecho particularmente importante chamado **seção crítica**.

A seção crítica é o trecho do programa onde um recurso compartilhado é acessado ou modificado.

### Exemplo

```text
saldo = saldo + valor
```

Se `saldo` for compartilhado entre Threads, essa operação pertence à seção crítica.

Outro exemplo:

```text
contador = contador + 1
```

Se duas Threads executarem isso simultaneamente, pode ocorrer uma condição de corrida.

---

## 27. Condição de Corrida

Imagine:

```text
contador = 10
```

Thread A lê:

```text
contador = 10
```

Thread B também lê:

```text
contador = 10
```

A calcula:

```text
10 + 1 = 11
```

B calcula:

```text
10 + 1 = 11
```

As duas escrevem:

```text
contador = 11
```

Resultado:

```text
11
```

Mas esperávamos:

```text
12
```

Isso é um exemplo clássico de **race condition**, ou condição de corrida.

O resultado depende da ordem ou intercalação de execução das Threads.

---

## 28. Sincronismo

Para impedir esse problema, precisamos controlar o acesso à seção crítica.

Esse controle é chamado de **sincronização**.

A ideia é:

```text
Thread A
   ↓
entra na seção crítica

Thread B
   ↓
espera
```

Depois:

```text
Thread A termina
   ↓
libera recurso
   ↓
Thread B entra
```

---

## 29. Exclusão Mútua

Esse comportamento é chamado de **exclusão mútua**.

A regra básica é:

> Apenas uma Thread por vez pode executar determinada seção crítica protegida.

Visualmente:

```text
          SEÇÃO CRÍTICA

Thread A ───────► ENTRA
Thread B ───────► ESPERA
Thread C ───────► ESPERA
```

Depois:

```text
Thread A sai

Thread B ───────► ENTRA
```

---

## 30. Sincronização em Java

Em Java, um dos principais mecanismos estudados é:

```java
synchronized
```

### Exemplo

```java
public synchronized void depositar(double valor) {
    saldo = saldo + valor;
}
```

Se duas Threads chamarem o método, apenas uma por vez executará a região protegida para aquela instância.

Conceitualmente:

```text
Thread 1
↓
synchronized
↓
ACESSA

Thread 2
↓
synchronized
↓
ESPERA
```

> A palavra-chave correta em Java é `synchronized`.

---

## 31. Lock em Python

No Python, podemos utilizar:

```python
threading.Lock()
```

### Exemplo conceitual

```python
lock = threading.Lock()
```

Quando uma Thread entra:

```text
Lock adquirido
🔒
```

Outra Thread precisa esperar.

Quando termina:

```text
Lock liberado
🔓
```

A próxima pode entrar.

---

## 32. Lock em C#

Em C#, o conceito equivalente pode ser utilizado através de:

```csharp
lock
```

A ideia é a mesma:

```text
Thread A
↓
lock
↓
seção crítica
```

Enquanto isso:

```text
Thread B
↓
espera
```

---

## 33. Comparação dos Mecanismos

| Linguagem | Mecanismo estudado |
|---|---|
| Java | `synchronized` |
| C# | `lock` |
| Python | `threading.Lock()` |

O objetivo dos três é controlar o acesso concorrente a recursos compartilhados.

---

## 34. Sem Memória Compartilhada x Com Memória Compartilhada

| Sem memória compartilhada | Com memória compartilhada |
|---|---|
| Dados independentes | Mesmo dado utilizado por várias Threads |
| Menor risco de race condition | Pode ocorrer race condition |
| Normalmente não precisa proteger dados comuns | Precisa sincronizar se houver acesso concorrente mutável |
| Rotinas/tarefas | Rotinas/tarefas + seção crítica |
| Mais simples | Mais complexo |

Uma associação importante para a prova:

```text
SEM MEMÓRIA COMPARTILHADA
=
rotinas/tarefas
```

Enquanto:

```text
COM MEMÓRIA COMPARTILHADA
=
rotinas/tarefas
+
seção crítica
+
sincronização
```

---

# Fluxo Geral do Conteúdo

Este é um dos esquemas mais importantes para memorizar:

```text
SISTEMAS DISTRIBUÍDOS
        ↓
Compartilhamento de recursos
        ↓
CPU / RAM / armazenamento
        ↓
Comunicação entre computadores
        ↓
TCP/IP
        ↓
IP + Porta + Máscara + Socket
        ↓
TCP ou UDP
        ↓
Comunicação pode ser bloqueante
        ↓
Threads permitem executar tarefas concomitantes
        ↓
Threads podem trabalhar:
        ↓
┌─────────────────────┬────────────────────────┐
│ Sem memória         │ Com memória            │
│ compartilhada       │ compartilhada          │
├─────────────────────┼────────────────────────┤
│ Rotinas/tarefas     │ Rotinas/tarefas        │
│ independentes       │ + seção crítica        │
└─────────────────────┴────────────────────────┘
                              ↓
                         Sincronismo
                              ↓
              Java → synchronized
              C#   → lock
              Python → Lock
```

---

# O que Priorizar para a Prova

É importante conseguir explicar com suas próprias palavras:

- O que é um sistema distribuído.
- Para que serve um sistema distribuído.
- Quais recursos podem ser compartilhados.
- Diferença entre Grid e Cluster.
- Diferença entre programação concomitante e programação paralela.
- Relação entre Threads e programação concomitante.
- Papel de CUDA, OpenMP e MPI.
- O que são IP, porta, máscara de rede e socket.
- Diferenças entre TCP e UDP.
- O que são produtor e consumidor.
- Por que uma leitura pode ser bloqueante.
- Como Threads ajudam em comunicações bloqueantes.
- Como delegar rotinas para Threads.
- Como passar parâmetros para Threads.
- Como identificar Threads.
- Diferença entre Threads com e sem memória compartilhada.
- O que é seção crítica.
- O que é condição de corrida.
- O que é sincronização.
- O que é exclusão mútua.
- Como funciona `synchronized` em Java.
- Como funciona `lock` em C#.
- Como funciona `threading.Lock()` em Python.

---

# Resumo de 1 Minuto

> Um **sistema distribuído** possui vários computadores independentes que se comunicam para compartilhar recursos, como CPU, RAM e armazenamento. O **Grid** está associado no conteúdo da disciplina à computação concomitante, enquanto o **Cluster** está associado à computação paralela. A comunicação ocorre através do modelo TCP/IP, utilizando IP, porta, máscara, sockets e protocolos de transporte como TCP e UDP. Operações de comunicação podem ser bloqueantes, fazendo uma execução esperar pelos dados. As **Threads** permitem que outras tarefas continuem enquanto uma Thread está esperando. Threads podem trabalhar sem memória compartilhada ou acessar dados em comum. Quando existe memória compartilhada, surge uma **seção crítica**, que precisa ser protegida para evitar condições de corrida. Esse controle é feito por sincronização e exclusão mútua, utilizando mecanismos como `synchronized` em Java e `lock` em C# ou Python.
