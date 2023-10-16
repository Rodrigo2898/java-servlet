<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Lista de Profissões</title>
</head>
<body>
    <h1>Nova Profissão</h1>
    <form name="frmProfissao" action="insert">
        <input type="text" name="nome" placeholder="nome">
        <input type="text" name="idade" placeholder="idade">
        <input type="text" name="profissao" placeholder="profissao">
        <input type="submit" value="Adicionar" onclick="validar()">
    </form>
<script src="scripts/validador.js"></script>
</body>
</html>