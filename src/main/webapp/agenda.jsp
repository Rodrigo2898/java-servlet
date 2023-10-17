<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="br.com.rodrigofeitosa.entity.Pessoa"%>
<%@ page import="java.util.List"%>
<%
    out.println("TESTE");
    List<Pessoa> pessoaList = (List<Pessoa>) request.getAttribute("profissoes");
    out.println("CHEGOU AQUI");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Agenda</title>
</head>
<body>
    <h1>Agenda de profissões</h1>

        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Idade</th>
                    <th>Profissão</th>
                    <th>Opções</th>
                </tr>
            </thead>
            <tbody>
                <% for (int i = 0; i < pessoaList.size(); i++) { %>
                    <tr>
                        <td><%=pessoaList.get(i).getId()%></td>
                        <td><%=pessoaList.get(i).getNome()%></td>
                        <td><%=pessoaList.get(i).getIdade()%></td>
                        <td><%=pessoaList.get(i).getProfissao()%></td>
                        <td><a href="select?idcon=<%=pessoaList.get(i).getId()%>">Editar</a>
                            <a href="javascript: confirmar(<%=pessoaList.get(i).getId()%>)">Excluir</a>
                        </td>
                    </tr>
                <% } %>
            </tbody>
        </table>

    <a href="novo.jsp">Novo Cadastro</a>
<script src="scripts/confirmar.js"></script>
</body>
</html>