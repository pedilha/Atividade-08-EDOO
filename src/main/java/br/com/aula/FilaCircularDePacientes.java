package br.com.aula;



public class FilaCircularDePacientes {

    private Paciente[] fila;
    private int inicio;
    private int fim;
    private int tamanho;
    private int capacidade;

    public FilaCircularDePacientes(int capacidade) {
        this.capacidade = capacidade;
        this.fila = new Paciente[capacidade];
        this.inicio = 0;
        this.fim = -1;
        this.tamanho = 0;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public boolean estaCheia() {
        return tamanho == capacidade;
    }

    public void adicionar(Paciente paciente) {
        if (estaCheia()) {
            System.out.println(" A fila de espera está cheia. Não é possível adicionar " + paciente.getNome());
            return;
        }

        this.fim = (this.fim + 1) % this.capacidade;
        this.fila[this.fim] = paciente;
        this.tamanho++;
        System.out.println(" " + paciente.getNome() + " entrou na fila de espera (Circular).");
    }


    public Paciente atenderProximo() {
        if (estaVazia()) {
            System.out.println(" A fila de espera está vazia.");
            return null;
        }
        Paciente pacienteAtendido = this.fila[this.inicio];
        this.inicio = (this.inicio + 1) % this.capacidade;
        this.tamanho--;
        return pacienteAtendido;
    }


    public Paciente verProximo() {
        if (estaVazia()) {
            System.out.println(" Ninguém na fila de espera.");
            return null;
        }
        return this.fila[this.inicio];
    }


    public void exibirFila() {
        System.out.println("\n--- Fila de Espera Atual (Circular) ---");
        if (estaVazia()) {
            System.out.println("   (Vazia)");
        } else {
            for (int i = 0; i < this.tamanho; i++) {
                int indice = (this.inicio + i) % this.capacidade;
                System.out.println("   " + (i + 1) + "º -> " + this.fila[indice].getNome());
            }
        }
        System.out.println("----------------------------------------");
    }
}