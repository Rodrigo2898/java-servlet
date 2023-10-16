<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="br.com.rodrigofeitosa.model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
    out.println("TESTE");
    ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("profissoes");
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
                <% for (int i = 0; i < lista.size(); i++) { %>
                    <tr>
                        <td><%=lista.get(i).getIdcon()%></td>
                        <td><%=lista.get(i).getNome()%></td>
                        <td><%=lista.get(i).getIdade()%></td>
                        <td><%=lista.get(i).getProfissao()%></td>
                        <td><a href="select?idcon=<%=lista.get(i).getIdcon()%>">Editar</a>
                            <a href="javascript: confirmar(<%=lista.get(i).getIdcon()%>)">Excluir</a>
                        </td>
                    </tr>
                <% } %>
            </tbody>
        </table>

    <a href="novo.jsp">Novo Cadastro</a>
<script src="scripts/confirmar.js"></script>
</body>
</html>