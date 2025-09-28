package br.com.aula;


public class MainEncadeada {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("INICIANDO SIMULACAO COM FILA ENCADEADA");

        FilaEncadeadaDePacientes filaDeEspera = new FilaEncadeadaDePacientes();
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

        System.out.println("\n--- Medico iniciando os atendimentos ---");
        for (int i = 0; i < 3; i++) {
            System.out.println("\n--- Atendimento " + (i + 1) + " ---");
            Paciente pacienteASerAtendido = filaDeEspera.atenderProximo();
            if (pacienteASerAtendido != null) {
                System.out.println("Chamando " + pacienteASerAtendido.getNome() + " para a consulta...");
                Thread.sleep(1500);
                listaDeAtendidos.adicionar(pacienteASerAtendido);
            }
        }

        System.out.println("\n-------------------------------------------");
        System.out.println("\nO medico verifica quem e o proximo...");
        Paciente proximo = filaDeEspera.verProximo();
        if (proximo != null) {
            System.out.println("Proximo paciente na fila e: " + proximo.getNome());
        }

        filaDeEspera.exibirFila();
        listaDeAtendidos.exibir();

        System.out.println("\nFIM DA SIMULACAO");
    }
}