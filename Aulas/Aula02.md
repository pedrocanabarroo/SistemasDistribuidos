# Sistemas Distribuídos e Sistemas Paralelos

## Sistemas Distribuídos (SD)

### Conceito

Sistemas distribuídos são compostos por computadores **heterogêneos**, conectados em rede, que cooperam para compartilhar recursos, como processamento e memória.

---

## Características

### Heterogeneidade

- Diferentes arquiteturas de hardware;
- Diferentes sistemas operacionais;
- Diferentes linguagens de programação.

### Fraco Acoplamento

- Computadores distribuídos geograficamente;
- Comunicação via protocolos TCP/IP:
  - Endereço IP;
  - Porta lógica;
  - Máscara de rede;
  - Protocolos de transporte.

### Estrutura

- **GRID Computacional**

### Arquiteturas

- Cliente-Servidor;
- Ponto-a-Ponto (P2P);
- Híbrida.

---

## Objetivos

Compartilhar recursos, como:

- Processador;
- Memória.

---

## Desafios

Ao compartilhar recursos, é necessário garantir o sincronismo.

### Relógios

- Relógio físico;
- Relógio lógico.

### Controle de acesso aos recursos

- Exclusão mútua.

---

## Dependência do Sistema Operacional

Os sistemas distribuídos dependem fortemente do Sistema Operacional, que atua como:

- Gestor de processamento;
- Gestor de comunicação;
- Gestor das camadas de serviço.

---

## Comunicação

A comunicação ocorre principalmente por **Sockets**.

Um socket é composto por:

- Endereço IP;
- Porta;
- Máscara de rede;
- Objetos de escrita e leitura.

> **Importante:** A comunicação via socket é **bloqueante**.

### Solução

Utilizar **Threads**, permitindo que a comunicação bloqueante não interrompa toda a aplicação.

---

## Outras Características

- Tolerância a falhas;
- Escalabilidade;
- Segurança;
- Facilidade de manutenção e atualização.

---

# Threads

## Conceito

Uma **Thread** é um subprocesso (ou miniprocesso) pertencente a um processo.

Cada thread possui informações próprias, como:

- Identificador (ID);
- Nome;
- Endereço;
- Tamanho;
- Tempo;
- Instruções.

Pode ser criada durante:

- Tempo de programação;
- Tempo de execução.

---

## Finalidade

Garantir processamento concomitante.

Nos sistemas distribuídos, as threads são fundamentais para liberar a aplicação da comunicação bloqueante via sockets.

---

## Estados de uma Thread

- Ready (Pronta);
- Running (Em execução);
- Waiting (Esperando);
- Sleeping (Dormindo);
- Stopped (Parada);
- Terminated (Finalizada);
- Cancelled (Cancelada).

---

## Sincronismo entre Threads

Existem mecanismos que garantem o sincronismo da execução, como:

- Monitor;
- Semáforo.

---

## Tipos de Threads

### 1. Thread com compartilhamento de memória

**Características**

- Compartilha recursos e memória;
- O processamento pode sofrer bloqueios;
- O programador é responsável por garantir o sincronismo.

### Em Java

Utiliza a interface:

```java
Runnable
```

---

### 2. Thread sem compartilhamento de memória

**Características**

- Não compartilha recursos diretamente;
- Menor necessidade de sincronização.

### Em Java

Utiliza a classe:

```java
Thread
```

---

# Sistemas Paralelos

## Conceito

Sistemas paralelos são compostos por computadores **homogêneos**, fortemente acoplados, trabalhando conjuntamente para aumentar o desempenho do processamento.

---

## Características

### Homogeneidade

- Hardware idêntico;
- Sistema Operacional idêntico;
- Linguagem de programação idêntica.

### Forte Acoplamento

- Localizados no mesmo ambiente físico;
- Comunicação via TCP/IP:
  - Endereço IP;
  - Porta lógica;
  - Máscara de rede;
  - Protocolos de transporte.

### Estrutura

- **CLUSTER Computacional**

### Arquitetura

- Ponto-a-Ponto (P2P).

---

## Objetivo

Compartilhar recursos como:

- Processador;
- Memória.

Com foco principal em:

- Alto desempenho;
- Processamento paralelo.

---

## Outras Características

- Tolerância a falhas;
- Escalabilidade;
- Segurança;
- Facilidade de manutenção e atualização.

---

# Comparação: Sistemas Distribuídos × Sistemas Paralelos

| Característica | Sistemas Distribuídos | Sistemas Paralelos |
|----------------|-----------------------|--------------------|
| Hardware | Heterogêneo | Homogêneo |
| Sistema Operacional | Pode ser diferente | Igual |
| Linguagem | Pode ser diferente | Geralmente igual |
| Acoplamento | Fraco | Forte |
| Localização | Distribuídos geograficamente | Mesmo local físico |
| Estrutura | GRID Computacional | CLUSTER Computacional |
| Arquiteturas | Cliente-Servidor, P2P e Híbrida | P2P |
| Comunicação | TCP/IP via Socket | TCP/IP |
| Principal desafio | Sincronismo e comunicação | Paralelismo eficiente |
| Objetivo | Compartilhar recursos e serviços | Aumentar desempenho computacional |

---

# Resumo

## Sistemas Distribuídos

- Computadores heterogêneos;
- Fracamente acoplados;
- GRID Computacional;
- Arquiteturas Cliente-Servidor, P2P e Híbrida;
- Comunicação via Socket (bloqueante);
- Uso de Threads para concorrência;
- Compartilhamento de recursos;
- Necessidade de sincronismo:
  - Relógios físicos e lógicos;
  - Exclusão mútua.

---

## Threads

- Miniprocessos pertencentes a um processo;
- Executam tarefas concomitantemente;
- Possuem diversos estados de execução;
- Sincronização por:
  - Monitor;
  - Semáforo.

### Java

| Compartilhamento | Implementação |
|------------------|---------------|
| Com compartilhamento de memória | `Runnable` |
| Sem compartilhamento de memória | `Thread` |

---

## Sistemas Paralelos

- Computadores homogêneos;
- Fortemente acoplados;
- CLUSTER Computacional;
- Arquitetura P2P;
- Compartilhamento de processador e memória;
- Foco em alto desempenho e processamento paralelo.
