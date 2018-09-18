<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">"
    <title>SIGAEE- Cadastro de Equipe</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand text-white">SIGAEE</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp">Home</a>
                </li>
                <li class="nav-item ">
                    <a class="nav-link" href="cadastroUsuario.jsp">Cadastro</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="login.jsp">Login</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<section class="py-5">
    <div class="container">
        <h1>Cadastro</h1>
        <form>
            <div class="form-group">
       <%--@declare id="nomeequipe"--%><label for="nomeEquipe">Nome da Equipe</label>
                <input type="text" class="form-control" id="nome" placeholder="Insira o nome da equipe">
            </div>
            <div class="form-group">
                <%--@declare id="equipelogo"--%><label for="equipeLogo">Team Logo</label><br>
                    <button type="button" class="btn">Selecionar arquivo...</button> Nenhum arquivo selecionado.
            </div>
            <div class="form-group">
                <%--@declare id="escolhaesporte"--%><label for="escolhaEsporte">Selecione o esporte ...</label>
                <div class="form-group>
                <label for="tipoUsuario">Esporte</label>
                    <select class="form-control" id="tipoEsporte">
                        <option>exemplo 1</option>
                        <option>exemplo 2</option>
                    </select>
                </div>
        </form>
            </div>

            <div>
                <button type="button" class="btn bg-dark text-white">Enviar</button>
            </div>

    </div>

</section>

<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>
