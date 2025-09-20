package br.com.aula;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(" INICIANDO SIMULAÇÃO DA CLÍNICA UNIVERSITÁRIA ");

        FilaDePacientes filaDeEspera = new FilaDePacientes();
        ListaDeAtendidos listaDeAtendidos = new ListaDeAtendidos();

        System.out.println("\n--- Chegada de Pacientes ---");
        Thread.sleep(1000);
        filaDeEspera.adicionar(new Paciente("Carlos", 34));
        filaDeEspera.adicionar(new Paciente("Maria", 28));
        filaDeEspera.adicionar(new Paciente("João", 45));
        filaDeEspera.adicionar(new Paciente("Ana", 22));
        filaDeEspera.adicionar(new Paciente("Pedro", 65));

        filaDeEspera.exibirFila();
        Thread.sleep(2000);

        System.out.println("\n--- Médico iniciando os atendimentos ---");
        for (int i = 0; i < 3; i++) {
            System.out.println("\n--- Atendimento " + (i + 1) + " ---");
            Paciente pacienteASerAtendido = filaDeEspera.atenderProximo();
            if (pacienteASerAtendido != null) {
                System.out.println("🩺 Chamando " + pacienteASerAtendido.getNome() + " para a consulta...");
                Thread.sleep(1500);
                listaDeAtendidos.adicionar(pacienteASerAtendido);
            }
        }

        System.out.println("\n-------------------------------------------");
        System.out.println("\n O médico verifica quem é o próximo...");
        Paciente proximo = filaDeEspera.verProximo();
        if (proximo != null) {
            System.out.println("Próximo paciente na fila é: " + proximo.getNome());
        }

        filaDeEspera.exibirFila();
        listaDeAtendidos.exibir();
        Thread.sleep(2000);

        listaDeAtendidos.pesquisar("Maria");
        listaDeAtendidos.pesquisar("Lucas");

        System.out.println("\n\n---  DESAFIO EXTRA  ---");
        Thread.sleep(1000);

        System.out.println("\n--- Chegada de um caso de urgência ---");
        filaDeEspera.adicionarPrioritario(new Paciente("Sra. Helena", 80));
        filaDeEspera.exibirFila();

        System.out.println("\nMédico atende o caso urgente...");
        Paciente pacienteUrgente = filaDeEspera.atenderProximo();
        if (pacienteUrgente != null) {
            listaDeAtendidos.adicionar(pacienteUrgente);
        }
        listaDeAtendidos.exibir();

        listaDeAtendidos.gerarEstatisticas();

        System.out.println("\n FIM DA SIMULAÇÃO ");
    }
}