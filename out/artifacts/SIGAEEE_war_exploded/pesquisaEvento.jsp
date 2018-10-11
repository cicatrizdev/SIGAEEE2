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
<h1>Pesquisa de Evento</h1>
<table>
    <tr>
        <th>Código Evento</th>
        <th>Nome Evento</th>
        <th colspan=2>Ação</th>
    </tr>
    <c:forEach itemm="${eventos}" var="evento">
        <tr>
            <td><c:out value="${evento.idEvento}"/></td>
            <td><c:out value="${evento.nomeEvento}" /></td>
            <td><a href="ManterEventoController?acao=prepararOperacao&operacao=Editar&idEvento=<c:out value="${evento.idEvento}"/>">Editar</a></td>
            <td><a href="ManterEventoController?acao=prepararOperacao&operacao=Excluir&idEvento=<c:out value="${evento.idEvento}"/>">Excluir</a></td>
        </tr>
    </c:forEach >
</table>
<form action="ManterEventoController?acao=prepararOperacao&operacao=Incluir" method="post">
    <input type="submit" name="btnIncluir" value="Incluir"/>
</form>
</body>
</html>
