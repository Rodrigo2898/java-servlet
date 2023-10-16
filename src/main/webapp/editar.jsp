<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="br.com.rodrigofeitosa.model.JavaBeans"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Editar de Profissao</title>
</head>
<body>
    <h1>Editar Profissão</h1>
    <form name="frmProfissao" action="update">
        <input type="text" name="idcon" readonly value="<% out.print(request.getAttribute("idcon")); %>">
        <input type="text" name="nome" value="<%out.print(request.getAttribute("nome"));%>">
        <input type="text" name="idade" value="<%out.print(request.getAttribute("idade"));%>">
        <input type="text" name="profissao" value="<%out.print(request.getAttribute("profissao"));%>">
        <input type="submit" value="Salvar" onclick="validar()">
    </form>
<script src="scripts/validador.js"></script>
</body>
</html>