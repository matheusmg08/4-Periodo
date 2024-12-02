package org.veiculos;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

import com.google.gson.Gson;

/**
 * Servlet implementation class PessoaAPI
 */
@WebServlet("/VeiculoAPI/*")
public class VeiculoAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VeiculoAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VeiculoDao pdao = new VeiculoDao();
		Gson gson = new Gson();
		
		int id = 0;
		try {
			//pega o id passado por parametro 
			id = Integer.parseInt(request.getPathInfo().substring(1));
			
		} catch (Exception e) {
		}
		
		String pesquisa = request.getParameter("pesquisa");

		String resposta;
		if (id==0) {
			//listar todos
			resposta = gson.toJson(pdao.listar(pesquisa));
		} else {
			//consultar apenas 1
			resposta = gson.toJson(pdao.consultar(id));
		}
		response.setHeader("content-type", "application/json");
		response.getWriter().print(resposta);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//pega o body da request
		String body = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		
		//converte o body para um objeto Java
		Gson gson = new Gson();
		Veiculo p = gson.fromJson(body,  Veiculo.class);
		
		//salva
		VeiculoDao pdao = new VeiculoDao();
//		pdao.inserir(p);
		
		
		
		//envia a resposta
		String resposta = gson.toJson(pdao.inserir(p));
		response.setHeader("content-type", "application/json");
		response.getWriter().print(resposta);
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//pega o body da request
		String body = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		
		//converte o body para um objeto Java
		Gson gson = new Gson();
		Veiculo p = gson.fromJson(body,  Veiculo.class);
		
		//pega o id passado por parametro
		int id = 0;
		try {
			id = Integer.parseInt(request.getPathInfo().substring(1));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		p.setIdveiculo(id);
		
		//salva o novo veiculo
		VeiculoDao pdao = new VeiculoDao();
		pdao.alterar(p);
				
		
		//envia a resposta
		String resposta = gson.toJson(pdao.alterar(p));
		response.setHeader("content-type", "application/json");
		response.getWriter().print(resposta);		
		
		
	}
	
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//pega o id passado por parametro
		int id = 0;
		try {
			id = Integer.parseInt(request.getPathInfo().substring(1));
					
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//exclui
		VeiculoDao pdao = new VeiculoDao();
		Veiculo p = new Veiculo();
		Gson gson = new Gson();
		p.setIdveiculo(id);
		pdao.excluir(p);
		
		//envia resposta
		
		String resposta = gson.toJson(pdao.excluir(p));
		response.setHeader("content-type", "application/json");
		response.getWriter().print(resposta);	
	}

}