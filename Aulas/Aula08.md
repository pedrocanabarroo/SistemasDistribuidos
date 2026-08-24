# Semana 4

# Aula 2 — Threads, Sincronização e Coordenação em Sistemas Distribuídos

## Resumo para a avaliação — Teoria Básica de Sistemas Distribuídos

---

# 1. Threads

Uma **Thread** é uma unidade de execução dentro de um processo.

Ela permite dividir um programa em várias tarefas menores.

## Exemplo

Um editor de texto pode possuir várias Threads:

**Thread 1**
- Digitar texto.

**Thread 2**
- Salvar automaticamente.

**Thread 3**
- Verificar ortografia.

Todas pertencem ao mesmo programa.

---

# 2. Threads sem Memória Compartilhada

Cada Thread trabalha com seus próprios dados.

## Exemplo

```text
Thread 1:
Lista A → soma

Thread 2:
Lista B → soma
```

Uma Thread não interfere diretamente nos dados da outra.

---

# 3. Threads com Memória Compartilhada

As Threads acessam os mesmos dados.

## Exemplo

Considere um sistema bancário:

```text
Saldo:
R$ 1000
```

Duas Threads realizam operações:

```text
Thread 1:
Saque de R$ 500

Thread 2:
Saque de R$ 700
```

Se as operações ocorrerem ao mesmo tempo sem controle, podem gerar inconsistências.

Por isso, é necessário utilizar mecanismos de **sincronização**.

---

# 4. Seção Crítica

A **seção crítica** é o trecho do código que acessa ou modifica dados compartilhados.

## Exemplo

Variável inicial:

```text
contador = 10
```

Duas Threads executam:

```text
Thread A:
contador + 1

Thread B:
contador + 1
```

Sem controle, o resultado pode ser:

```text
11
```

quando deveria ser:

```text
12
```

Esse tipo de situação pode ocorrer quando duas Threads acessam e alteram o mesmo dado ao mesmo tempo.

---

# 5. Sincronismo

O **sincronismo** é o controle utilizado para organizar o acesso das Threads aos recursos compartilhados.

Seu objetivo é evitar problemas causados pelo acesso simultâneo aos mesmos dados.

---

# 6. Lock

Um **Lock** funciona como uma chave que controla o acesso a um recurso.

Quando uma Thread entra na região protegida:

```text
🔒 Recurso ocupado
```

As outras Threads precisam esperar.

Quando a Thread termina:

```text
🔓 Recurso liberado
```

Outra Thread pode acessar o recurso.

## Exemplo

Ao salvar um arquivo:

- Apenas uma Thread pode escrever por vez.
- As demais aguardam até que o recurso seja liberado.

---

# 7. Relógios em Sistemas Distribuídos

Cada computador possui seu próprio relógio.

Isso pode gerar diferenças entre os horários registrados por máquinas diferentes.

## Exemplo

```text
Computador A:
10:00:01

Computador B:
10:00:03
```

Surge então uma questão importante:

> Qual evento aconteceu primeiro?

---

# 8. Relógio Físico

O **relógio físico** utiliza o tempo real.

## Exemplo

Servidores podem ser sincronizados com uma referência de tempo mundial.

### Problema

Mesmo com sincronização, pode existir uma diferença de alguns milissegundos entre as máquinas.

---

# 9. Relógio Lógico de Lamport

O **relógio lógico de Lamport** não tenta descobrir o horário real.

Seu objetivo é organizar a ordem dos eventos.

## Exemplo

Evento A:

```text
Enviar mensagem
```

Evento B:

```text
Receber mensagem
```

O relógio lógico permite estabelecer que:

```text
A aconteceu antes de B
```

Assim, é possível organizar eventos mesmo que os relógios físicos das máquinas sejam diferentes.

---

# 10. Exclusão Mútua

A **exclusão mútua** garante que apenas uma Thread ou processo utilize determinado recurso por vez.

## Exemplo

Considere uma impressora compartilhada.

**Sem exclusão mútua:**

```text
Usuário A imprime
Usuário B imprime junto
```

Resultado:

```text
Documento misturado
```

**Com exclusão mútua:**

```text
Usuário A imprime
Depois usuário B imprime
```

O recurso é utilizado de forma organizada.

---

# 11. Eleição

Em sistemas distribuídos, pode ser necessário escolher um **coordenador**.

Isso pode acontecer, por exemplo, quando o servidor responsável pela coordenação do sistema falha.

## Exemplo

```text
Servidor A
Servidor B
Servidor C

↓

Servidor principal falha

↓

Os servidores realizam uma eleição

↓

Servidor B é escolhido como líder
```

A eleição permite que o sistema escolha um novo coordenador.

---

# 12. Pool de Threads

Um **Pool de Threads** mantém várias Threads prontas para executar tarefas.

Em vez de criar uma nova Thread para cada operação:

```text
Criar Thread
Executar
Destruir

Criar outra Thread
Executar
Destruir
```

utiliza-se um conjunto de Threads já disponíveis:

```text
Thread Pool

Thread 1 → tarefa
Thread 2 → tarefa
Thread 3 → aguardando
```

---

# 13. Exemplo de Uso de Pool de Threads

Considere um servidor web com muitos usuários acessando simultaneamente.

## Sem Pool

```text
Usuário → cria Thread nova
Usuário → cria Thread nova
Usuário → cria Thread nova
```

Uma nova Thread é criada para cada acesso.

## Com Pool

```text
Servidor possui 100 Threads prontas.

Cada usuário utiliza uma Thread disponível.
```

Isso permite reutilizar Threads existentes e organizar melhor a execução das tarefas.

---

# Resumo da Aula 2

| Conceito | Ideia principal |
|---|---|
| Thread | Unidade de execução dentro de um processo |
| Memória não compartilhada | Cada Thread trabalha com seus próprios dados |
| Memória compartilhada | Várias Threads acessam os mesmos dados |
| Seção crítica | Trecho que acessa dados compartilhados |
| Sincronismo | Organiza o acesso aos recursos |
| Lock | Bloqueia temporariamente um recurso |
| Relógio físico | Utiliza o tempo real |
| Relógio lógico de Lamport | Organiza a ordem dos eventos |
| Exclusão mútua | Apenas uma Thread ou processo acessa o recurso por vez |
| Eleição | Escolha de um coordenador |
| Pool de Threads | Conjunto de Threads reutilizáveis |

---

# Ideia Geral da Semana 4

Sistemas distribuídos permitem que várias máquinas trabalhem juntas.

Para isso, é necessário controlar:

- Comunicação entre computadores.
- Execução concomitante através de Threads.
- Compartilhamento de memória.
- Sincronização.
- Exclusão mútua.
- Organização dos eventos através de relógios.
- Escolha de coordenadores.
- Gerenciamento eficiente de Threads através de Pools.

## Ideia central

> **Em sistemas distribuídos, não basta apenas fazer várias máquinas ou Threads executarem tarefas. Também é necessário organizar a comunicação, controlar o acesso aos dados e coordenar a ordem em que os eventos acontecem.**
