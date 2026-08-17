# Trabalho Avaliativo - Threads em Java com MVC

Este repositório contém dois exercícios sobre programação concorrente utilizando Java e organização MVC.

## Exercício 1 - Compartilhamento de Memória

Simula cinco caixas de um festival vendendo fichas simultaneamente e atualizando um saldo central compartilhado.

Conceitos utilizados:

- `Thread`
- memória compartilhada
- condição de corrida
- exclusão mútua
- `synchronized`
- `join()`
- MVC

Resultado esperado: **R$ 50.000,00**.

## Exercício 2 - Sem Compartilhamento de Memória

Simula quatro filiais, cada uma com 10.000 registros de vendas. Cada thread processa somente sua própria lista e devolve um resultado local. A thread principal aguarda todas e soma os resultados.

Conceitos utilizados:

- `Thread`
- isolamento de dados
- Fork-Join
- `join()`
- resultado armazenado no objeto da thread
- MVC

## Estrutura

```text
src/
├── exercicio1/
│   ├── app/
│   ├── controller/
│   ├── model/
│   └── view/
└── exercicio2/
    ├── app/
    ├── controller/
    ├── model/
    └── view/
```

## Compilar

No Linux/macOS, na raiz do projeto:

```bash
javac -encoding UTF-8 -d out $(find src -name "*.java")
```

No Windows/PowerShell:

```powershell
$arquivos = Get-ChildItem -Recurse -Path src -Filter *.java
javac -encoding UTF-8 -d out $arquivos.FullName
```

No VS Code com a extensão Java, também é possível executar diretamente cada classe `Main.java`.

## Executar

Exercício 1:

```bash
java -cp out exercicio1.app.Main
```

Exercício 2:

```bash
java -cp out exercicio2.app.Main
```

## Gerar Javadoc

Na raiz do projeto:

```bash
javadoc -encoding UTF-8 -docencoding UTF-8 -charset UTF-8 -d docs -sourcepath src -subpackages exercicio1:exercicio2
```

O mesmo comando pode ser usado no PowerShell.

Depois, abra `docs/index.html` no navegador.
