package org.veiculos;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

public class VeiculoDao {
	
	public void salvar(Veiculo p) {
		if (p.getIdveiculo()>0) {
			alterar(p);
		}else {
			inserir(p);
		}
	}
	
	public Retorno1 inserir(Veiculo p) {
		//lista.add(p);
		//abre a conexao com o bd
		Conexao3 con = new Conexao3();
		
		Retorno1Dao retornoDao = new Retorno1Dao();
		try {
			String sql = "INSERT INTO veiculo (marca, valor, cor, placa)"
					+ " VALUES (?,?,?,?)";
			PreparedStatement prep = con.getConnection().prepareStatement(sql);
			prep.setString(1,  p.getMarca());
			prep.setString(2,  p.getValor());
			prep.setString(3,  p.getCor());
			prep.setString(4,  p.getPlaca());
			prep.execute();
			
			String mensagem = "Inserido com sucesso!";
			Boolean resposta = true;
			
			Retorno1 retorno = retornoDao.RetornoJson(resposta, mensagem);
			
			//fecha a conexao com o banco de dados 
			con.desconecta();
			return retorno;
			
			
		} catch (Exception e) {
			e.printStackTrace();
			//fecha a conexao com o banco de dados 
			con.desconecta();
			String mensagem = "Falha ao inserir!";
			Boolean resposta = false;
			
			Retorno1 retorno = retornoDao.RetornoJson(resposta, mensagem);
			
			return retorno;
		}
	}
	public LinkedList<Veiculo> listar(String pesquisa) {
		//return lista;
		LinkedList<Veiculo> lista = new LinkedList<Veiculo>();
		Conexao3 con = new Conexao3();
		try {
			String sql = "SELECT * FROM veiculo "
					+ "WHERE marca like ? "
					+ "ORDER BY marca";
			PreparedStatement sta = con.getConnection().prepareStatement(sql);
			sta.setString(1,  "%" + pesquisa + "%");
			
			ResultSet res = sta.executeQuery();
			while (res.next()) {
				Veiculo p = new Veiculo();
				p.setIdveiculo(res.getInt("idveiculo"));
				p.setMarca(res.getString("marca"));
				p.setValor(res.getString("valor"));
				p.setCor(res.getString("cor"));
				p.setPlaca(res.getString("placa"));
				lista.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();
		return lista;
	}
	
	public Retorno1 alterar(Veiculo p) {
		Conexao3 con = new Conexao3();
		
		Retorno1Dao retornoDao = new Retorno1Dao();
		
		try {
			String sql = "UPDATE veiculo SET"
					+" marca = ?, valor = ?," 
					+ "cor = ? , placa = ? "
					+ "WHERE idveiculo = ?";
			PreparedStatement prep = con.getConnection().prepareStatement(sql);
			prep.setString(1, p.getMarca());
			prep.setString(2, p.getValor());
			prep.setString(3, p.getCor());
			prep.setString(4, p.getPlaca());
			prep.setInt(5, p.getIdveiculo());
			prep.execute();
			
			String mensagem = "Alterado com sucesso!";
			Boolean resposta = true;
			
			Retorno1 retorno = retornoDao.RetornoJson(resposta, mensagem);
			
			//fecha a conexao com o banco de dados 
			con.desconecta();
			return retorno;
			
		} catch (Exception e) {
			e.printStackTrace();
			String mensagem = "Falha ao alterar!";
			Boolean resposta = false;
			
			Retorno1 retorno = retornoDao.RetornoJson(resposta, mensagem);
			
			//fecha a conexao com o banco de dados 
			con.desconecta();
			
			return retorno;
		}
		
	}
	public Retorno1 excluir(Veiculo p) {
		Conexao3 con = new Conexao3();
		
		Retorno1Dao retornoDao = new Retorno1Dao();
		
		try {
			String sql = "DELETE FROM veiculo"
					+ " WHERE idveiculo = ?";
			PreparedStatement prep = con.getConnection().prepareStatement(sql);
			prep.setInt(1, p.getIdveiculo());
			prep.execute();
			
			String mensagem = "Excluido com sucesso!";
			Boolean resposta = true;
			
			Retorno1 retorno = retornoDao.RetornoJson(resposta, mensagem);
			
			//fecha a conexao com o banco de dados 
			con.desconecta();
			return retorno;
		} catch (Exception e) {
			e.printStackTrace();
			
			String mensagem = "Falha ao excluir!";
			Boolean resposta = false;
			
			Retorno1 retorno = retornoDao.RetornoJson(resposta, mensagem);
			
			//fecha a conexao com o banco de dados 
			con.desconecta();
			
			return retorno;
		}
		
	}
	
	public Veiculo consultar(int id) {
		Veiculo p = new Veiculo();
		Conexao3 con = new Conexao3();
		try {
			String sql = "SELECT * FROM veiculo WHERE idveiculo = "+ id;
			Statement sta = con.getConnection().createStatement();
			ResultSet res = sta.executeQuery(sql);
			if (res.next()) {
				p.setIdveiculo(res.getInt("idveiculo"));
				p.setMarca(res.getString("marca"));
				p.setValor(res.getString("valor"));
				p.setCor(res.getString("cor"));
				p.setPlaca(res.getString("placa"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();
		return p;
	}
}