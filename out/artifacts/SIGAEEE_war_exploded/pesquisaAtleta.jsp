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
    <h1>Pesquisa de Atleta</h1>
    <table>
        <tr>
            <th>Código Atleta</th>
            <th>Nome Atleta</th>
            <th colspan=2>Ação</th>
        </tr>
        <c:forEach itemm="${atletas}" var="atleta">
            <tr>
                <td><c:out value="${atleta.idAtleta}"/></td>
                <td><c:out value="${atleta.nomeUsuario}" /></td>
                <td><a href="ManterAtletaController?acao=prepararOperacao&operacao=Editar&idAtleta=<c:out value="${atleta.idAtleta}"/>">Editar</a></td>
                <td><a href="ManterAtletaController?acao=prepararOperacao&operacao=Excluir&idAtleta=<c:out value="${atleta.idAtleta}"/>">Excluir</a></td>
            </tr>
        </c:forEach >
    </table>
<form action="ManterAtletaController?acao=prepararOperacao&operacao=Incluir" method="post">
    <input type="submit" name="btnIncluir" value="Incluir"/>
</form>
</body>
</html>
