package br.com.aula;

public class MainPrioridade {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(" INICIANDO SIMULACAO COM FILA DE PRIORIDADE ");

        FilaDePrioridade filaDeEspera = new FilaDePrioridade();

        System.out.println("\n--- Chegada de Pacientes (10 no total) ---");
        Thread.sleep(1000);

        filaDeEspera.adicionar(new Paciente("João", 30, false));
        filaDeEspera.adicionar(new Paciente("Maria", 65, false));
        filaDeEspera.adicionar(new Paciente("Carlos", 25, true));
        filaDeEspera.adicionar(new Paciente("Ana", 70, false));
        filaDeEspera.adicionar(new Paciente("Pedro", 45, false));
        filaDeEspera.adicionar(new Paciente("Sofia", 22, false));
        filaDeEspera.adicionar(new Paciente("Lucas", 80, true));
        filaDeEspera.adicionar(new Paciente("Laura", 35, false));
        filaDeEspera.adicionar(new Paciente("Miguel", 68, false));
        filaDeEspera.adicionar(new Paciente("Beatriz", 19, true));

        filaDeEspera.exibirFila();
        Thread.sleep(2000);

        System.out.println("\n--- Médico iniciando os atendimentos ---");
        for (int i = 0; i < 5; i++) {
            System.out.println("\n--- Atendimento " + (i + 1) + " ---");
            Paciente pacienteAtendido = filaDeEspera.atenderProximo();
            if (pacienteAtendido != null) {
                System.out.println("🩺 Chamando " + pacienteAtendido.getNome() + " (Idade: " + pacienteAtendido.getIdade() + ", Urgente: " + pacienteAtendido.isUrgente() + ")");
                Thread.sleep(1500);
            }
        }

        filaDeEspera.exibirFila();
        System.out.println("\n FIM DA SIMULACAO ");
    }
}