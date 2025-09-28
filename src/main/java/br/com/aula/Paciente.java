// Arquivo: Paciente.java (atualizado)
package br.com.aula;

public class Paciente {
    private String nome;
    private int idade;
    private boolean urgente;

    public Paciente(String nome, int idade, boolean urgente) {
        this.nome = nome;
        this.idade = idade;
        this.urgente = urgente;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public boolean isUrgente() {
        return urgente;
    }

    public boolean temPrioridade() {
        return this.idade > 60 || this.urgente;
    }

    @Override
    public String toString() {
        return "Paciente{nome='" + nome + "', idade=" + idade + ", urgente=" + urgente + "}";
    }
}