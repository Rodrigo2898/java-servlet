package br.com.rodrigofeitosa.controller;

import br.com.rodrigofeitosa.dao.PessoaDAO;
import br.com.rodrigofeitosa.entity.Pessoa;
import br.com.rodrigofeitosa.model.AppDAO;
import br.com.rodrigofeitosa.model.JavaBeans;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/controller", "/main", "/insert", "/select", "/update", "/delete"})
public class AppController extends HttpServlet {
    private  static final long serialVersionUID = 1L;

    AppDAO dao = new AppDAO();
    JavaBeans user = new JavaBeans();

    PessoaDAO pessoaDAO = new PessoaDAO();

    Pessoa pessoa = new Pessoa();

    public AppController() {
    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
//    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        System.out.println(action);
        if (action.equals("/main")) {
            profissoes(req, resp);
        } else if (action.equals("/insert")) {
            inserirProfissao(req, resp);
        } else if (action.equals("/select")) {
            listarProfissao(req, resp);
        } else if (action.equals("/update")) {
            editarProfissao(req, resp);
        } else if (action.equals("/delete")) {
            removerProfissao(req, resp);
        } else {
            resp.sendRedirect("index.html");
        }
    }

    // Listar Profissoes
    protected void profissoes(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.sendRedirect("agenda.jsp");

        // Criando um objeto que ira receber os dados JavaBeans
        // ArrayList<JavaBeans> lista = dao.listarProfissoes();

        // Utilizando Hibernate
        List<Pessoa> pessoaList = pessoaDAO.getTodasPessoas();

        // Encaminhar lista para agenda.jsp
        req.setAttribute("profissoes", pessoaList);
        RequestDispatcher rd = req.getRequestDispatcher("agenda.jsp");
        rd.forward(req, resp);
    }


    // Nova profissao
//    protected void novaProfissao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        user.setNome(req.getParameter("nome"));
//        user.setIdade(req.getParameter("idade"));
//        user.setProfissao(req.getParameter("profissao"));
//        // Invocar o método inserirUsuario
//        dao.inserirUsuario(user);
//        // Redirecionar para o documento agenda.jsp
//        resp.sendRedirect("main");
//
//        System.out.println(req.getParameter("nome"));
//        System.out.println(req.getParameter("idade"));
//        System.out.println(req.getParameter("profissao"));
//    }

    // Utilizando Hibernate
    protected void inserirProfissao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        pessoa.setNome(req.getParameter("nome"));
        pessoa.setIdade(req.getParameter("idade"));
        pessoa.setProfissao(req.getParameter("profissao"));

        pessoaDAO.salvarPessoaDAO(pessoa);

        resp.sendRedirect("main");

        System.out.println(req.getParameter("nome"));
        System.out.println(req.getParameter("idade"));
        System.out.println(req.getParameter("profissao"));
    }

    // Editar Contado
//    protected void listarProfissao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // Recebmento do id do contato que será editado
//        String idcon = req.getParameter("idcon");
//        // Setar variável JavaBeans
//        user.setIdcon(Integer.valueOf(idcon));
//        // Executar o método selecionar profissao (dao)
//        dao.selecionarProfissao(user);
//        // Setar os atributos do formulário com o conteúdo JavaBeans
//        req.setAttribute("idcon", user.getIdcon());
//        req.setAttribute("nome", user.getNome());
//        req.setAttribute("idade", user.getIdade());
//        req.setAttribute("profissao", user.getProfissao());
//        // Encaminhar para o documento editar.jsp
//        RequestDispatcher rd = req.getRequestDispatcher("editar.jsp");
//        rd.forward(req, resp);
//        //System.out.print(req.getAttribute(String.valueOf("idcon")));
//    }

    // Utilizando Hibernate
    protected void listarProfissao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idcon = req.getParameter("idcon");
        pessoa.setIdcon(Integer.valueOf(idcon));

        pessoaDAO.getPessoaDao(Integer.valueOf(idcon));

        req.setAttribute("idcon", pessoa.getId());
        req.setAttribute("nome", pessoa.getNome());
        req.setAttribute("idade", pessoa.getIdade());
        req.setAttribute("profissao", pessoa.getProfissao());

        RequestDispatcher rd = req.getRequestDispatcher("editar.jsp");
        rd.forward(req, resp);
    }


//    protected void editarProfissao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // Setar as variávei JavaBeans
//        user.setIdcon(Integer.valueOf(req.getParameter("idcon")));
//        user.setNome(req.getParameter("nome"));
//        user.setIdade(req.getParameter("idade"));
//        user.setProfissao(req.getParameter("profissao"));
//        // Executar método alterarProfissao
//        dao.alterarProfissao(user);
//        // Redirecionar para o documento agenda.jsp, atualizando as informações
//        resp.sendRedirect("main");
//    }

    // Utilizando Hibernate
    protected void editarProfissao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        pessoa.setIdcon(Integer.valueOf(req.getParameter("idcon")));
        pessoa.setNome(req.getParameter("nome"));
        pessoa.setIdade(req.getParameter("idade"));
        pessoa.setProfissao(req.getParameter("profissao"));
        pessoaDAO.atualizarPessoaDAO(pessoa);
        resp.sendRedirect("main");
    }

//    protected void removerProfissao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // Recebimento do id a ser excluirdo (validador.js)
//        String idcon = req.getParameter("idcon");
//        // Setar variavel idcon no javaBeans
//        user.setIdcon(Integer.valueOf(idcon));
//        // executar o método deletarProfisao DAO passando o objeto profissao
//        dao.deletarProfissao(user);
//
//        resp.sendRedirect("main");
//    }

    // Utilizando Hibernate
    protected void removerProfissao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idcon = req.getParameter("idcon");
        pessoa.setIdcon(Integer.valueOf(idcon));
        pessoaDAO.deletarPessoaDao(pessoa);
        resp.sendRedirect("main");
    }

}
