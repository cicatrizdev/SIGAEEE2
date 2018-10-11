package controller;

import java.io.IOException;

protected void processRequest(HttpServletRequest request, HttpServletREsponse response) throws ServletException, IOException{
    try {
        request.setAttribute("atletas", Atleta.lerAtleta)
        }
        }

public class PesquisaAtletaController extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
