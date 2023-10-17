package br.com.rodrigofeitosa.controller;

import br.com.rodrigofeitosa.dao.PessoaDAO;
import br.com.rodrigofeitosa.entity.Pessoa;

import java.util.List;

public class PessoaController2 {
    private final PessoaDAO PESSOA_DAO = new PessoaDAO();

    public int salvarPessoaController(Pessoa pessoa) {
        Pessoa pessoaExistente = this.getPessoaController(pessoa.getId());
        if (pessoaExistente == null) {
            return this.PESSOA_DAO.salvarPessoaDAO(pessoa);
        } else {
            if (atualizarPessoaController(pessoa)) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public List<Pessoa> getTodasPessoasController() {
        return  this.PESSOA_DAO.getTodasPessoas();
    }

    public boolean excluirPessoaController(Pessoa pessoa) {
        return this.PESSOA_DAO.deletarPessoaDao(pessoa);
    }

    public boolean atualizarPessoaController(Pessoa pessoa) {
        return this.PESSOA_DAO.atualizarPessoaDAO(pessoa);
    }

    public Pessoa getPessoaController(int idPessoa) {
        return this.PESSOA_DAO.getPessoaDao(idPessoa);
    }
}
