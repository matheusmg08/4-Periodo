package org.trabalho;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

public class PessoaDao2 {
	//private static LinkedList<Pessoa> lista = new LinkedList<Pessoa>();
	
	public void salvar(Pessoa2 p) {
		if (p.getIdvendedor()>0) {
			alterar(p);			
		} else {
			inserir(p);		
		}
	}
	
	public void inserir(Pessoa2 p) {
		//lista.add(p);	
		Conexao2 con = new Conexao2();
		try {
			String sql = "INSERT INTO vendedor (nome, telefone, email, cidade) " + "VALUES(?,?,?,?)";
			PreparedStatement prep = con.getConnection().prepareStatement(sql);
			prep.setString(1, p.getNome());
			prep.setString(2,  p.getTelefone());
			prep.setString(3,  p.getEmail());
			prep.setString(4, p.getCidade());
			prep.execute();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		con.desconecta();
	}
	
	public void alterar(Pessoa2 p) {
		Conexao2 con = new Conexao2();
		try {
			String sql = "UPDATE vendedor SET"
					+ " nome = ?, telefone = ?, "
					+ " email = ?, cidade = ?"
					+ "endereco = ?, cep = ?"
					+ " WHERE idpessoa = ?";
			PreparedStatement prep = con.getConnection().prepareStatement(sql);
			prep.setString(1,  p.getNome());
			prep.setString(2,  p.getTelefone());
			prep.setString(3,  p.getEmail());
			prep.setString(4,  p.getCidade());
			prep.setInt(5,  p.getIdvendedor());
			
			prep.execute();
			
			} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();
	}
	
	public void excluir(Pessoa2 p) {
		Conexao2 con = new Conexao2();
		try {
			String sql = "DELETE FROM vendedor"
					+ " WHERE idvendedor = ?";
			PreparedStatement prep = con.getConnection().prepareStatement(sql);
			prep.setInt(1,  p.getIdvendedor());
			prep.execute();
			
			} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();
	}
	
	public LinkedList<Pessoa2> listar(){
		//return lista;
		LinkedList<Pessoa2> lista = new LinkedList<Pessoa2>();
		Conexao2 con = new Conexao2();
		try {
			String sql = "SELECT * FROM vendedor ORDER BY nome";
			Statement sta = con.getConnection().createStatement();
			ResultSet res = sta.executeQuery(sql);
			while (res.next()) {
				Pessoa2 p = new Pessoa2();
				p.setIdvendedor(res.getInt("idvendedor"));;
				p.setNome(res.getString("nome"));
				p.setTelefone(res.getString("telefone"));
				p.setEmail(res.getString("email"));
				p.setCidade(res.getString("cidade"));
				lista.add(p);			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();
		return lista;
	}
	
	public Pessoa2 consultar(int id){
		Pessoa2 p = new Pessoa2();
		Conexao2 con = new Conexao2();
		try {
			String sql = "SELECT * FROM vendedor WHERE idvendedor = " + id;
			Statement sta = con.getConnection().createStatement();
			ResultSet res = sta.executeQuery(sql);
			if (res.next()) {
				p.setIdvendedor(res.getInt("idvendedor"));
				p.setNome(res.getString("nome"));
				p.setTelefone(res.getString("telefone"));
				p.setEmail(res.getString("email"));
				p.setCidade(res.getString("cidade"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();
		return p;
	}
	
}
