package br.com.aula;

import java.util.LinkedList;
import java.util.Queue;

public class FilaDePacientes {
    private Queue<Paciente> fila = new LinkedList<>();

    public void adicionar(Paciente paciente) {
        fila.add(paciente); // ou fila.offer(paciente)
        System.out.println(" " + paciente.getNome() + " entrou na fila de espera.");
    }


    public Paciente atenderProximo() {
        Paciente pacienteAtendido = fila.poll();
        if (pacienteAtendido == null) {
            System.out.println(" A fila de espera está vazia.");
        }
        return pacienteAtendido;
    }

    public Paciente verProximo() {
        Paciente proximo = fila.peek();
        if (proximo == null) {
            System.out.println(" Ninguém na fila de espera.");
        }
        return proximo;
    }

    public void exibirFila() {
        System.out.println("\n--- Fila de Espera Atual ---");
        if (fila.isEmpty()) {
            System.out.println("   (Vazia)");
        } else {
            int pos = 1;
            for (Paciente p : fila) {
                System.out.println("   " + (pos++) + "º -> " + p.getNome());
            }
        }
        System.out.println("------------------------------");
    }

    public void adicionarPrioritario(Paciente paciente) {
        if (fila instanceof LinkedList) {
            ((LinkedList<Paciente>) fila).addFirst(paciente);
            System.out.println("O paciente: " + paciente.getNome() + " foi para o início da fila.");
        }
    }
}