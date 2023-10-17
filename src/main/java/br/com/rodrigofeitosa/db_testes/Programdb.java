package br.com.rodrigofeitosa.db_testes;

import br.com.rodrigofeitosa.controller.PessoaController2;
import br.com.rodrigofeitosa.entity.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class Programdb {
    public static void main(String[] args) {
        System.out.println("Salvando cliente");
        PessoaController2 pessoaController = new PessoaController2();
        //Pessoa p1 = new Pessoa( "Tony", "42", "bilionario");

        //int idPessoa = pessoaController.salvarPessoaController(p1);

        List<Pessoa> pessoas = new ArrayList<>();
        pessoas = pessoaController.getTodasPessoasController();

        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.getId());
            System.out.println(pessoa.getNome());
        }

        Pessoa p1 = new Pessoa();
        p1.setNome("Vanessa");
        boolean resultado = pessoaController.atualizarPessoaController(p1);
        System.out.println("Pessoa " + p1);
       // System.out.println("Pessoa " + idPessoa);
    }
}
