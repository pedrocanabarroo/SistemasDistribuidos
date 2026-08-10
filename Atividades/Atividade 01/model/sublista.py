class Sublistas:
    def __init__(self, dados):
        self.dados = dados
        self.soma = 0

    def run(self):
        total = 0
        for valor in self.dados:
            total += valor
        self.soma = total
