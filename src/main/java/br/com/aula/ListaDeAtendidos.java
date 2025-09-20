package br.com.aula;

import java.util.ArrayList;
import java.util.List;

public class ListaDeAtendidos {
    private List<Paciente> atendidos = new ArrayList<>();

    public void adicionar(Paciente paciente) {
        atendidos.add(paciente);
        System.out.println("➡️ " + paciente.getNome() + " foi movido para a lista de atendidos.");
    }

    public void exibir() {
        System.out.println("\n---  Lista de Pacientes Atendidos Hoje ---");
        if (atendidos.isEmpty()) {
            System.out.println("   (Nenhum paciente atendido ainda)");
        } else {
            for (Paciente p : atendidos) {
                System.out.println("   - " + p.getNome() + " (Idade: " + p.getIdade() + ")");
            }
        }
        System.out.println("-------------------------------------------");
    }

    public void pesquisar(String nomePaciente) {
        System.out.println("\n Pesquisando por '" + nomePaciente + "' na lista de atendidos...");
        for (Paciente p : atendidos) {
            if (p.getNome().equalsIgnoreCase(nomePaciente)) {
                System.out.println("   Resultado: Sim, " + nomePaciente + " já foi atendido.");
                return;
            }
        }
        System.out.println("   Resultado: Não, " + nomePaciente + " não foi encontrado na lista.");
    }

    public void gerarEstatisticas() {
        System.out.println("\n---  Estatísticas do Dia ---");
        int totalAtendidos = atendidos.size();

        if (totalAtendidos == 0) {
            System.out.println("   Nenhum paciente atendido para gerar estatísticas.");
            return;
        }

        double mediaIdade = atendidos.stream()
                .mapToInt(Paciente::getIdade)
                .average()
                .orElse(0.0);

        System.out.println("   Total de pacientes atendidos: " + totalAtendidos);
        System.out.printf("   Média de idade dos atendidos: %.1f anos\n", mediaIdade);
        System.out.println("-----------------------------");
    }
}