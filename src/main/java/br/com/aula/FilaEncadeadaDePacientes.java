package br.com.aula;

public class FilaEncadeadaDePacientes {

    private class NoPaciente {
        Paciente paciente;
        NoPaciente proximo;

        public NoPaciente(Paciente paciente) {
            this.paciente = paciente;
            this.proximo = null;
        }
    }

    private NoPaciente inicio;
    private NoPaciente fim;
    private int tamanho;

    public FilaEncadeadaDePacientes() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public boolean estaVazia() {
        return this.inicio == null;
    }

    public void adicionar(Paciente paciente) {
        NoPaciente novoNo = new NoPaciente(paciente);

        if (estaVazia()) {
            this.inicio = novoNo;
            this.fim = novoNo;
        } else {
            this.fim.proximo = novoNo;
            this.fim = novoNo;
        }
        this.tamanho++;
        System.out.println(" " + paciente.getNome() + " entrou na fila de espera (Encadeada).");
    }

    public Paciente atenderProximo() {
        if (estaVazia()) {
            System.out.println("ℹ A fila de espera está vazia.");
            return null;
        }

        Paciente pacienteAtendido = this.inicio.paciente;
        this.inicio = this.inicio.proximo;

        if (this.inicio == null) {
            this.fim = null;
        }

        this.tamanho--;
        return pacienteAtendido;
    }

    public Paciente verProximo() {
        if (estaVazia()) {
            System.out.println("ℹ Ninguém na fila de espera.");
            return null;
        }
        return this.inicio.paciente;
    }

    public void exibirFila() {
        System.out.println("\n---  Fila de Espera Atual (Encadeada) ---");
        if (estaVazia()) {
            System.out.println("   (Vazia)");
        } else {
            NoPaciente atual = this.inicio;
            int pos = 1;
            while (atual != null) {
                System.out.println("   " + (pos++) + "º -> " + atual.paciente.getNome());
                atual = atual.proximo;
            }
        }
        System.out.println("------------------------------------------");
    }
}