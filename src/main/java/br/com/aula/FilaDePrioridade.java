package br.com.aula;

public class FilaDePrioridade {

    private class NoPaciente {
        Paciente paciente;
        NoPaciente proximo;

        public NoPaciente(Paciente paciente) {
            this.paciente = paciente;
            this.proximo = null;
        }
    }

    private NoPaciente inicio;
    private int tamanho;

    public FilaDePrioridade() {
        this.inicio = null;
        this.tamanho = 0;
    }

    public boolean estaVazia() {
        return this.inicio == null;
    }

    public void adicionar(Paciente paciente) {
        NoPaciente novoNo = new NoPaciente(paciente);

        if (estaVazia() || paciente.isUrgente()) {
            novoNo.proximo = this.inicio;
            this.inicio = novoNo;
        } else {
            NoPaciente atual = this.inicio;
            NoPaciente anterior = null;

            while (atual != null && atual.paciente.temPrioridade()) {
                anterior = atual;
                atual = atual.proximo;
            }


            if (anterior == null && paciente.temPrioridade()) {
                novoNo.proximo = this.inicio;
                this.inicio = novoNo;
            } else {

                novoNo.proximo = atual;
                if (anterior != null) {
                    anterior.proximo = novoNo;
                }
            }
        }
        this.tamanho++;
        System.out.println(" " + paciente.getNome() + " inserido na fila de prioridade.");
    }

    public Paciente atenderProximo() {
        if (estaVazia()) {
            System.out.println(" A fila está vazia.");
            return null;
        }
        Paciente pacienteAtendido = this.inicio.paciente;
        this.inicio = this.inicio.proximo;
        this.tamanho--;
        return pacienteAtendido;
    }

    public void exibirFila() {
        System.out.println("\n---  Fila de Espera Atual (Com Prioridade) ---");
        if (estaVazia()) {
            System.out.println("   (Vazia)");
        } else {
            NoPaciente atual = this.inicio;
            int pos = 1;
            while (atual != null) {
                System.out.printf("   %dº -> %s (Idade: %d, Urgente: %b)\n",
                        pos++, atual.paciente.getNome(), atual.paciente.getIdade(), atual.paciente.isUrgente());
                atual = atual.proximo;
            }
        }
        System.out.println("-------------------------------------------------");
    }
}