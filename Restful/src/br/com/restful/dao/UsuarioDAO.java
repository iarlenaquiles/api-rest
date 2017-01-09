package br.com.restful.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.restful.factory.ConnectionFactory;
import br.com.restful.model.Usuario;

public class UsuarioDAO extends ConnectionFactory {

	public static UsuarioDAO instance;

	public static UsuarioDAO getInstance() {
		if (instance == null)
			instance = new UsuarioDAO();
		return instance;
	}

	public Usuario listar(int id) {
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Usuario usuario = null;

		conexao = criarConexao();

		try {
			pstmt = conexao.prepareStatement("select * from usuario where id = '" + id + "'");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				usuario = new Usuario();

				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setIdade(rs.getInt("idade"));
				usuario.setRg(rs.getString("rg"));
				usuario.setTelefone(rs.getString("telefone"));
				usuario.setSexo(rs.getString("sexo"));
				usuario.setNumero(rs.getInt("numero"));
				usuario.setBairro(rs.getString("bairro"));
				usuario.setComplemento(rs.getString("complemento"));
				usuario.setRua(rs.getString("rua"));
				usuario.setTipo_sangue(rs.getString("tipo_sangue"));

			}

		} catch (Exception e) {
			System.out.println("Erro ao listar todos os usuarios: " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		return usuario;
	}

	public ArrayList<Usuario> listarTodos() {
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Usuario> usuarios = null;

		conexao = criarConexao();
		usuarios = new ArrayList<Usuario>();
		try {
			pstmt = conexao.prepareStatement("select * from usuario order by nome");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Usuario usuario = new Usuario();

				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setIdade(rs.getInt("idade"));
				usuario.setRg(rs.getString("rg"));
				usuario.setTelefone(rs.getString("telefone"));
				usuario.setSexo(rs.getString("sexo"));
				usuario.setNumero(rs.getInt("numero"));
				usuario.setBairro(rs.getString("bairro"));
				usuario.setComplemento(rs.getString("complemento"));
				usuario.setRua(rs.getString("rua"));
				usuario.setTipo_sangue(rs.getString("tipo_sangue"));

				usuarios.add(usuario);
			}

		} catch (Exception e) {
			System.out.println("Erro ao listar todos os usuarios: " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		return usuarios;
	}

	public Usuario salvar(Usuario u) {

		String sql = "INSERT INTO usuario VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		Connection conexao = null;
		PreparedStatement pstmt = null;

		conexao = criarConexao();

		try {
			pstmt = conexao.prepareStatement(sql);
			pstmt.setInt(1, u.getId());
			pstmt.setString(2, u.getNome());
			pstmt.setInt(3, u.getIdade());
			pstmt.setString(4, u.getRg());
			pstmt.setString(5, u.getTelefone());
			pstmt.setString(6, u.getSexo());
			pstmt.setString(7, u.getRua());
			pstmt.setInt(8, u.getNumero());
			pstmt.setString(9, u.getComplemento());
			pstmt.setString(10, u.getBairro());
			pstmt.setString(11, u.getTipo_sangue());

			pstmt.execute();
			return u;

		} catch (SQLException e) {
			System.out.println("Erro na inserção: " + e );

		}

		return null;

	}

}
