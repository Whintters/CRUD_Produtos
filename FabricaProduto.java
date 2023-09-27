import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

// CRUD

public class FabricaProduto {

	public void criaProduto(Produto produto) { // CREATE
		
		// Comando em sql para inserir um dado na tabela produto:
		String sql = "INSERT INTO produtos(nome, preco, categoria, dataCadastro, dataVenda, " +
		"dataFabricacao, dataValidade, ingredientes) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		// Objeto da classe de conexão:
		Connection conn = null;
		
		// Objeto da classe de preparação da query:
		PreparedStatement pstm = null;
		
		try {
			
			// Estabelece a conexão com o banco de dados:
			conn = ConexaoBanco.conexaoBanco();
			
			// Utiliza o objeto pstm para executar a query:
			pstm = conn.prepareStatement(sql);
			
			// Define os valores das variáveis presentes na tabela produto:
			pstm.setString(1, produto.getNome());
			pstm.setDouble(2, produto.getPreco());
			pstm.setString(3, produto.getCategoria());
			pstm.setDate(4, new Date(produto.getDataCadastro().getTime()));
			if(produto.getDataVenda()==null) {
				pstm.setNull(5, Types.DATE);
			}
			else {
				pstm.setDate(5, new Date(produto.getDataVenda().getTime()));
			}
			pstm.setDate(6, new Date(produto.getDataFabricacao().getTime()));
			if(produto.getDataValidade()==null) {
				pstm.setNull(7, Types.DATE);
			}
			else {
				pstm.setDate(7, new Date(produto.getDataValidade().getTime()));
			}
			pstm.setString(8, produto.getIngredientes());
			
			// Executa a query:
			pstm.execute();
			
			System.out.println("Produto salvo com sucesso!");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			// Fecha as conexões:
			try {
				
				if(pstm!=null) {
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<Produto> informaProdutoEstoque() { // READ
		
		String sql = "SELECT * FROM produtos";
		
		List<Produto> produtos = new ArrayList<Produto>();
		
		Connection con = null;
		PreparedStatement pstm = null;
		
		// Classe que vai recuperar os dados do banco:
		ResultSet rset = null;
		
		try {
			
			con = ConexaoBanco.conexaoBanco();
			pstm = con.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Produto produto = new Produto();
				
				// Recuperar o id do produto:
				produto.setId(rset.getInt("id"));
				
				// Recuperar o nome do produto:
				produto.setNome(rset.getString("nome"));
				
				// recuperar o preço do produto:
				produto.setPreco(rset.getDouble("preco"));
				
				// Recuperar a categoria dp produto:
				produto.setCategoria(rset.getString("categoria"));
				
				// Recuperar a data de cadastro do produto:
				produto.setDataCadastro(rset.getDate("datacadastro"));
				
				// Recuperar a data de venda do produto:
				produto.setDataVenda(rset.getDate("dataVenda"));
				
				// Recuperar a data de Fabricação do produto:
				produto.setDataFabricacao(rset.getDate("dataFabricacao"));
				
				// Recuperar a data de Validade do produto:
				produto.setDataValidade(rset.getDate("dataValidade"));
				
				// Recuperar os ingredientes do produto:
				produto.setIngredientes(rset.getString("ingredientes"));
				
				produtos.add(produto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				if(rset!=null) {
					rset.close();
				}
				
				if(pstm!=null) {
					pstm.close();
				}
				
				if(con!=null) {
					con.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return produtos;
	}
	
	// Esse método se comporta parecido com o de criação:
	public void atualizaProduto(Produto produto) { // UPTADE
		
		String sql = "UPDATE produtos SET nome = ?, preco = ?, categoria = ?, dataCadastro = ?," + 
		"dataVenda = ?, dataFabricacao = ?, dataValidade = ?, ingredientes = ?" + "WHERE id = ?";
		
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			
			con = ConexaoBanco.conexaoBanco();
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, produto.getNome());
			pstm.setDouble(2, produto.getPreco());
			pstm.setString(3, produto.getCategoria());
			pstm.setDate(4, new Date(produto.getDataCadastro().getTime()));
			pstm.setDate(5, new Date(produto.getDataVenda().getTime()));
			pstm.setDate(6, new Date(produto.getDataFabricacao().getTime()));
			pstm.setDate(7, new Date(produto.getDataValidade().getTime()));
			pstm.setString(8, produto.getIngredientes());
			
			// O id do produto que será atualizado:
			pstm.setInt(9, produto.getId());
			
			pstm.execute();
			
			System.out.println("Produto atualizado com sucesso!");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				
				if(pstm!=null) {
					pstm.close();
				}
				
				if(con!=null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	// Método de deletar o produto através do id, pois o id é único:
	public void deletaProduto (int id) { // DELETE
		
		String sql = "DELETE FROM produtos WHERE id = ?";
		
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			
			con = ConexaoBanco.conexaoBanco();
			pstm = con.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			pstm.execute();
			
			System.out.println("Produto deletado com sucesso!");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				
				if(pstm!=null) {
					pstm.close();
				}
				
				if(con!=null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
