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
    public int contarTotalAtendidos() {
        return atendidos.size();
    }

    public double calcularMediaIdade() {
        if (atendidos.isEmpty()) {
            return 0.0;
        }
        return atendidos.stream()
                .mapToInt(Paciente::getIdade)
                .average()
                .orElse(0.0);
    }

    public Paciente encontrarPacienteMaisIdoso() {
        if (atendidos.isEmpty()) {
            return null;
        }

        Paciente maisIdoso = atendidos.get(0);
        for (int i = 1; i < atendidos.size(); i++) {
            if (atendidos.get(i).getIdade() > maisIdoso.getIdade()) {
                maisIdoso = atendidos.get(i);
            }
        }
        return maisIdoso;
    }


    public void exibirRelatorioDiario() {
        System.out.println("\n---  Relatório Diário de Atendimentos ---");

        int total = contarTotalAtendidos();
        double media = calcularMediaIdade();
        Paciente idoso = encontrarPacienteMaisIdoso();

        System.out.println("Total de pacientes atendidos: " + total);
        System.out.printf("Média de idade: %.1f anos\n", media);

        if (idoso != null) {
            System.out.println("Paciente mais idoso: " + idoso.getNome() + " (" + idoso.getIdade() + " anos)");
        } else {
            System.out.println("Paciente mais idoso: N/A (nenhum paciente atendido)");
        }

        System.out.println("-------------------------------------------");
    }


    public void exportarRelatorioTxt() {
        try (java.io.PrintWriter writer = new java.io.PrintWriter("relatorio_diario.txt")) {

            writer.println("--- Relatório Diário de Atendimentos ---");
            writer.println("Data: " + java.time.LocalDate.now());
            writer.println("-------------------------------------------");

            int total = contarTotalAtendidos();
            double media = calcularMediaIdade();
            Paciente idoso = encontrarPacienteMaisIdoso();

            writer.println("Total de pacientes atendidos: " + total);
            writer.printf("Média de idade: %.1f anos\n", media);

            if (idoso != null) {
                writer.println("Paciente mais idoso: " + idoso.getNome() + " (" + idoso.getIdade() + " anos)");
            } else {
                writer.println("Paciente mais idoso: N/A (nenhum paciente atendido)");
            }

            System.out.println("\n Relatório exportado com sucesso para 'relatorio_diario.txt'");

        } catch (java.io.IOException e) {
            System.err.println(" Erro ao exportar o relatório: " + e.getMessage());
        }
    }
}