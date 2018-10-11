<%--
  Created by IntelliJ IDEA.
  User: cicatriz
  Date: 10/9/18
  Time: 9:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Pesquisa de Equipe</h1>
<table>
    <tr>
        <th>Código Equipe</th>
        <th>Nome Equipe</th>
        <th colspan=2>Ação</th>
    </tr>
    <c:forEach itemm="${equipes}" var="equipe">
        <tr>
            <td><c:out value="${equipe.idEquipe}"/></td>
            <td><c:out value="${equipe.nomeEquipe}" /></td>
            <td><a href="ManterEquipeController?acao=prepararOperacao&operacao=Editar&idEquipe=<c:out value="${equipe.idEquipe}"/>">Editar</a></td>
            <td><a href="ManterEquipeController?acao=prepararOperacao&operacao=Excluir&idEquipe=<c:out value="${equipe.idEquipe}"/>">Excluir</a></td>
        </tr>
    </c:forEach >
</table>
<form action="ManterEquipeController?acao=prepararOperacao&operacao=Incluir" method="post">
    <input type="submit" name="btnIncluir" value="Incluir"/>
</form>
</body>
</html>
