# Sistemas Distribuídos

## Obrigações e Avaliações

### Repositório GitHub

- Manter um **repositório pessoal** da disciplina no GitHub.
- Armazenar:
  - Códigos dos desafios;
  - Códigos dos trabalhos;
  - Todas as aulas e materiais produzidos.

---

## Distribuição das Notas

| Critério | Peso |
|----------|------:|
| Notas de aula | **20%** |
| Participação efetiva | **20%** |
| Trabalho prático | **60%** |

### Requisitos do Trabalho Prático

- Todo o código deve ser **orientado a objetos**;
- O projeto deve estar organizado em **classes**;
- Utilizar o padrão de arquitetura **MVC**;
- Todo o código deve conter documentação utilizando:
  - **JavaDoc** (Java);
  - **Python Docstring** (Python);
- Não serão aceitas múltiplas soluções em um único arquivo.

---

# Arquiteturas de Sistemas

## 1. Cliente-Servidor

### Modelo de Comunicação

- Baseado no modelo **TCP/IP**.

### Comparação com o Modelo OSI

- **Modelo TCP/IP (4 camadas)**
  - Aplicação;
  - Transporte;
  - Internet;
  - Rede.

> O foco da disciplina será o modelo **TCP/IP**, enfatizando sua aplicação prática em relação ao modelo teórico **OSI (7 camadas)**.

---

## 2. Ponto-a-Ponto (P2P)

Também utiliza o modelo **TCP/IP** para comunicação entre os nós.

### Envio de Dados

**Enviar (Send / Write)**

É possível enviar:

- Bytes;
- Strings *(serializadas)*;
- Objetos *(serializados)*.

### Recebimento de Dados

**Receber (Receive / Read)**

Os dados enviados são recebidos através de operações de leitura.

---

# Threads

## Conceito

Uma **Thread** é um **mini processo** pertencente a um processo principal.

Cada thread possui características próprias:

- ID;
- Memória e CPU;
- Tempo de vida;
- Processo pai;
- Nome.

---

## Tipos de Threads

### Threads sem compartilhamento de memória

- Não compartilham memória entre si;
- Menor necessidade de sincronização.

---

### Threads com compartilhamento de memória

Compartilham recursos do processo e exigem mecanismos de sincronização.

### Possíveis Problemas

- Bloqueio (Lock).

### Mecanismos de Controle

- Monitor;
- Semáforo;
- Deadlock.
