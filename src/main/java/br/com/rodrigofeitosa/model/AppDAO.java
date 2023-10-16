package br.com.rodrigofeitosa.model;

import br.com.rodrigofeitosa.db.DB;
import jdk.jshell.spi.ExecutionControlProvider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.PropertyResourceBundle;
import java.util.concurrent.ExecutionException;

public class AppDAO {

    private String driver = "org.postgresql.Driver";

    private final String user="postgres";
    private final String password="rodrodrigues10";
    private final String dburl="jdbc:postgresql://localhost:5432/db_agenda";

    private Connection conectar() {
//        Connection conn = DB.getConnection();
//        System.out.println("DEUCERTO");
//        Db.

        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(dburl, user, password);
            return conn;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public void inserirUsuario(JavaBeans user) {
        String sqlCreate = "INSERT INTO contatos (nome, idade, profissao) VALUES(?, ?, ?)";

        try {
            Connection conn = conectar();
            PreparedStatement pst = conn.prepareStatement(sqlCreate);
            pst.setString(1, user.getNome());
            pst.setString(2, user.getIdade());
            pst.setString(3, user.getProfissao());

            // Executar query
            pst.executeUpdate();
            // Fechando conexão
            pst.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /*CRUD READ*/
    public ArrayList<JavaBeans> listarProfissoes() {
        // Criando um objeto para acessar a classe JavaBeans
        ArrayList<JavaBeans> profissoes = new ArrayList<>();
        String read = "SELECT * FROM contatos ORDER BY nome";
        try {
            Connection conn = conectar();
            PreparedStatement pst = conn.prepareStatement(read);
            ResultSet rst = pst.executeQuery();
            // Enquanto houver contatos
            while (rst.next()) {
                // Variáveis de apooio que recebem os dados do banco
                Integer idcon = rst.getInt(1);
                String nome = rst.getString(2);
                String idade = rst.getString(3);
                String profissao = rst.getString(4);
                // Populando o ArrayList
                profissoes.add(new JavaBeans(idcon, nome, idade, profissao));
            }
            conn.close();
            return profissoes;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /**/
    // Selecionar profissao
    public void selecionarProfissao(JavaBeans profissao) {
        String read2 = "SELECT * FROM contatos WHERE idcon = ?";
        try {
            Connection conn = conectar();
            PreparedStatement pst = conn.prepareStatement(read2);
            pst.setInt(1, profissao.getIdcon());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                // Setar as variavei JavaBeans
                profissao.setIdcon(rs.getInt(1));
                profissao.setNome(rs.getString(2));
                profissao.setIdade(rs.getString(3));
                profissao.setProfissao(rs.getString(4));
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void alterarProfissao(JavaBeans profissao) {
        String create = "UPDATE contatos SET nome = ?, idade = ?, profissao = ?::varchar WHERE idcon = ?::integer";
        try {
            Connection conn = conectar();
            PreparedStatement pst = conn.prepareStatement(create);
            pst.setInt(1, profissao.getIdcon());
            pst.setString(2, profissao.getNome());
            pst.setString(3, profissao.getIdade());
            pst.setString(4, profissao.getProfissao());
            pst.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void testeConxeo() {
        try {
            Connection conn = conectar();
            System.out.println(conn);
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /*CRUD DELETE*/
    public void deletarProfissao(JavaBeans profissao) {
        String deletar = "DELETE FROM contatos WHERE idcon = ?";
        try {
            Connection conn = conectar();
            PreparedStatement pst = conn.prepareStatement(deletar);
            pst.setInt(1, profissao.getIdcon());
            pst.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
