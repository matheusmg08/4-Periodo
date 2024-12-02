package org.libertas;

import com.google.gson.Gson;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/PessoaServlet")
public class PessoaServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Definindo o encoding para garantir suporte a caracteres especiais
        request.setCharacterEncoding("UTF-8");

        // Criando o objeto Pessoa com dados vindos do request
        Pessoa p = new Pessoa();
        p.setNome(request.getParameter("nome"));
        p.setTelefone(request.getParameter("telefone"));
        p.setEmail(request.getParameter("email"));
        p.setCidade(request.getParameter("cidade"));
        p.setEndereco(request.getParameter("endereco"));
        p.setCep(request.getParameter("cep"));

        // Usando o DAO para inserir a pessoa no banco de dados
        PessoaDao dao = new PessoaDao();
        Retorno retorno = dao.inserir(p); // Recebe o resultado da inserção

        // Converte o objeto de retorno para JSON usando Gson
        Gson gson = new Gson();
        String jsonResponse = gson.toJson(retorno);

        // Configurando a resposta como JSON
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Enviando o JSON como resposta
        PrintWriter out = response.getWriter();
        out.print(jsonResponse);
        out.flush();
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Definindo o encoding para garantir suporte a caracteres especiais
        request.setCharacterEncoding("UTF-8");

        // Criando o objeto Pessoa com dados vindos do request
        Pessoa p = new Pessoa();
        p.setIdpessoa(Integer.parseInt(request.getParameter("idpessoa")));
        p.setNome(request.getParameter("nome"));
        p.setTelefone(request.getParameter("telefone"));
        p.setEmail(request.getParameter("email"));
        p.setCidade(request.getParameter("cidade"));
        p.setEndereco(request.getParameter("endereco"));
        p.setCep(request.getParameter("cep"));

        // Usando o DAO para alterar a pessoa no banco de dados
        PessoaDao dao = new PessoaDao();
        Retorno retorno = dao.alterar(p); // Recebe o resultado da alteração

        // Converte o objeto de retorno para JSON usando Gson
        Gson gson = new Gson();
        String jsonResponse = gson.toJson(retorno);

        // Configurando a resposta como JSON
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Enviando o JSON como resposta
        PrintWriter out = response.getWriter();
        out.print(jsonResponse);
        out.flush();
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Definindo o encoding para garantir suporte a caracteres especiais
        request.setCharacterEncoding("UTF-8");

        // Pegando o ID da pessoa a ser excluída
        int idPessoa = Integer.parseInt(request.getParameter("idpessoa"));

        // Criando o objeto Pessoa com o ID
        Pessoa p = new Pessoa();
        p.setIdpessoa(idPessoa);

        // Usando o DAO para excluir a pessoa no banco de dados
        PessoaDao dao = new PessoaDao();
        Retorno retorno = dao.excluir(p); // Recebe o resultado da exclusão

        // Converte o objeto de retorno para JSON usando Gson
        Gson gson = new Gson();
        String jsonResponse = gson.toJson(retorno);

        // Configurando a resposta como JSON
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Enviando o JSON como resposta
        PrintWriter out = response.getWriter();
        out.print(jsonResponse);
        out.flush();
    }
}
