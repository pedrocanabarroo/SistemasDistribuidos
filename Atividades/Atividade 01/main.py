from view.exibir import Visualizar
from model.sublista import Sublistas
import random
import threading


def main():
    TAMANHO = 10_000
    NUM_THREADS = 4
    TAMANHO_PARTE = TAMANHO // NUM_THREADS

    v = Visualizar()
    dados = [random.randint(1, 100) for _ in range(TAMANHO)]

    partes = [
        Sublistas(dados[i * TAMANHO_PARTE:(i + 1) * TAMANHO_PARTE])
        for i in range(NUM_THREADS)
    ]
    threads = [threading.Thread(target=parte.run) for parte in partes]

    for t in threads:
        t.start()
    for t in threads:
        t.join()

    soma_total = 0
    for i, parte in enumerate(partes):
        v.mostrar_parcial(i, parte.soma)
        soma_total += parte.soma

    v.mostrar_total(soma_total)


if __name__ == "__main__":
    main()
