# Semana 4

# Aula 1 — Fundamentos de Sistemas Distribuídos e Comunicação

## Resumo para a avaliação — Teoria Básica de Sistemas Distribuídos

---

# 1. Sistemas Distribuídos

Um **sistema distribuído** é um conjunto de computadores ou dispositivos independentes que trabalham juntos para executar tarefas e compartilhar recursos.

Cada computador possui seu próprio processamento e memória, mas eles conseguem se comunicar através de uma rede para realizar uma atividade em conjunto.

## Objetivo

O principal objetivo é compartilhar recursos:

- **CPU** → utilizar o poder de processamento de outras máquinas.
- **Memória RAM** → distribuir o uso de memória entre diferentes computadores.
- **Memória secundária** → compartilhar dados armazenados.

## Exemplo

Um serviço de streaming como a Netflix possui milhares de servidores.

Quando um usuário assiste a um filme:

- Um servidor pode armazenar o vídeo.
- Outro pode autenticar o usuário.
- Outro pode processar recomendações.

Para o usuário, tudo parece ser um único sistema, mas existem várias máquinas trabalhando juntas.

---

# 2. Computação Concomitante x Computação Paralela

## 2.1 Computação Concomitante

A computação concomitante ocorre quando várias tarefas avançam durante o mesmo período de tempo, mas não necessariamente executam exatamente no mesmo instante.

Normalmente utiliza **Threads**.

### Exemplo

Um navegador de internet pode executar várias tarefas ao mesmo tempo:

- Uma Thread carrega o vídeo.
- Outra Thread atualiza a interface.
- Outra Thread recebe comandos do teclado.

As tarefas acontecem de forma organizada e concorrente.

---

## 2.2 Computação Paralela

A computação paralela acontece quando várias tarefas são executadas simultaneamente por diferentes unidades de processamento.

### Exemplo

Um programa precisa somar uma lista com 1 milhão de números.

**Forma sequencial:**

```text
CPU:
1 + 2 + 3 + 4 + 5 ... até 1 milhão
```

**Forma paralela:**

```text
CPU 1 → soma parte 1
CPU 2 → soma parte 2
CPU 3 → soma parte 3
CPU 4 → soma parte 4
```

Depois, os resultados são unidos.

---

# 3. Grid x Cluster

## 3.1 Grid Computing

Um Grid utiliza computadores distribuídos, normalmente localizados em diferentes lugares.

Os recursos são compartilhados através da rede.

### Exemplo

Em um projeto de pesquisa científica, milhares de computadores voluntários podem ceder parte do processamento quando estão ociosos.

Cada computador executa uma pequena parte do cálculo.

---

## 3.2 Cluster Computing

Um Cluster é formado por vários computadores próximos, trabalhando como se fossem uma única máquina.

Normalmente possui alta velocidade de comunicação.

### Exemplo

```text
Servidor principal
       |
-----------------
|       |       |
PC1    PC2     PC3
```

Cada computador executa uma parte do processamento.

Clusters podem ser utilizados em:

- Pesquisas científicas.
- Inteligência artificial.
- Simulações.

---

# 4. Comunicação em Sistemas Distribuídos

Para computadores diferentes trocarem informações, eles precisam utilizar protocolos de comunicação.

O principal modelo utilizado é o **TCP/IP**.

---

# 5. Endereço IP

O endereço IP identifica um dispositivo na rede.

### Exemplo

```text
192.168.1.10
```

Um computador envia uma mensagem para esse endereço para encontrar o destino correto.

Uma comparação simples:

- **Rua** → Rede.
- **Número da casa** → Dispositivo.

---

# 6. Porta

A porta identifica qual aplicação receberá a comunicação.

Um computador pode executar vários serviços ao mesmo tempo.

### Exemplo

```text
IP: 192.168.1.10

Porta 80   → Servidor Web
Porta 25   → E-mail
Porta 3306 → Banco MySQL
```

> **Resumo:** o IP encontra o computador e a porta encontra o programa.

---

# 7. Máscara de Rede

A máscara de rede define quais endereços pertencem à mesma rede.

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

fazem parte da mesma rede.

---

# 8. Socket

Um **socket** é um ponto de comunicação entre aplicações.

Ele combina:

- Endereço IP.
- Porta.

### Exemplo

Um navegador acessa:

```text
Servidor:
IP: 142.250.79.14
Porta: 443
```

O socket identifica exatamente para onde os dados devem ser enviados.

---

# 9. TCP x UDP

## 9.1 TCP

O TCP é orientado à conexão e busca garantir confiabilidade na comunicação.

### Características

- Confirma recebimento.
- Reenvia dados perdidos.
- Mantém a ordem das mensagens.

### Exemplo

Em um download de arquivo, se um pacote chegar errado ou for perdido, o TCP solicita novamente.

---

## 9.2 UDP

O UDP é mais rápido, mas não garante a entrega dos dados.

### Características

- Não verifica se o dado chegou.
- Não corrige erros.
- Possui menor atraso.

### Exemplo

Em jogos online, pode ser melhor perder um pacote contendo a posição de um jogador do que atrasar toda a partida.

---

# 10. Comunicação Bloqueante

Uma comunicação bloqueante faz uma tarefa esperar até receber uma resposta.

### Exemplo

```text
Consumidor:
"Preciso receber dados"

↓

Aguarda...

↓

Produtor:
"Enviei os dados"

↓

Consumidor continua
```

Enquanto a informação não chega, o consumidor fica parado.

---

# Resumo da Aula 1

| Conceito | Ideia principal |
|---|---|
| Sistema distribuído | Várias máquinas trabalham em conjunto |
| Computação concomitante | Várias tarefas avançam no mesmo período |
| Computação paralela | Várias tarefas executam simultaneamente |
| Grid | Máquinas distribuídas geograficamente |
| Cluster | Máquinas próximas trabalhando em conjunto |
| IP | Identifica o dispositivo na rede |
| Porta | Identifica a aplicação |
| Socket | Combinação de IP e porta |
| TCP | Comunicação confiável |
| UDP | Comunicação rápida e com menor controle |
| Comunicação bloqueante | A tarefa espera a resposta antes de continuar |

## Ideia central

> **Sistemas distribuídos dependem da comunicação entre diferentes máquinas. Para que essa comunicação funcione, é necessário identificar os dispositivos, as aplicações e os protocolos utilizados na troca de dados.**
