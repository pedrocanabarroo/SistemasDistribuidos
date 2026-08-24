- Teoria básica de sistemas distribuídos
    - o que é e para que serve -> compartilhar recurso (cpu, ram, memória secundária)
    - diferenças entre grid (computação concomitante) e cluster (computação paralela)
        - programação concomitante = threads
        - programação paralela = cuda, openMP, MPI
    - comunicação entre computadores ou equipamentos em sistemas distribuídos
        - model TCP/IP: endereço, porta, máscara de rede, socket, camada de transporte (UDP e TCP)
    - comunicação é leitura (consumidor) ou é escrita (produtor) - É BLOQUEANTE
        - THREADS: mini processos concomitantes -> desbloquear a comunicação
            - sem memória compartilhada - somente rotinas/tarefas
            - com memória compartilhada - rotinas/tarefas + seção crítica
            - delegar uma rotina para thread; passar parâmetros; identificação
        - SINCRONISMO -> acesso a seção crítica -> memória compartilhada
            - java: sincronized
            - c# e python: lock
            - via relógio: físico e lógico (lamport)
            - exclusão mútua - lock ou relógio ou eleição

- Poll de Threads

- Atividades:
    - pesquisar, compilar e disponibilizar nos githubs pessoais sobre Relógios Físicos e Lógicos. Exclusão Mútua e Eleição
    - pesquisar e compilar sobre a teoria de poll de threads
    - refazer ou compreender o Tele Jogo com uso de threads (sem e com compartilhamento de recurso)


Próxima aula: avaliação.
