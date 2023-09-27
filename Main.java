import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) throws ParseException {
		
		FabricaProduto fp = new FabricaProduto();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		// ---------------- Inserts na tabela produtos:
		
		/*
		Produto produto1 = new Produto();
		produto1.setNome("Arroz");
		produto1.setPreco(24.90);
		produto1.setCategoria("Cereal");
		produto1.setDataCadastro(new Date());
		produto1.setDataVenda(formato.parse("30/09/2023"));
		produto1.setDataFabricacao(formato.parse("01/01/2023"));
		produto1.setDataValidade(null);
		produto1.setIngredientes("Grãos");
		
		fp.criaProduto(produto1);
		
		Produto produto2 = new Produto();
		produto2.setNome("Iogurte");
		produto2.setPreco(2.95);
		produto2.setCategoria("Leite e Derivados");
		produto2.setDataCadastro(new Date());
		produto2.setDataVenda(null);
		produto2.setDataFabricacao(formato.parse("20/09/2023"));
		produto2.setDataValidade(formato.parse("30/09/2023"));
		produto2.setIngredientes("Leite e fermento lácteo");
		
		fp.criaProduto(produto2);
		*/
		
		// ---------------- Ver elementos da tabela produtos:
		
		/*
		for (Produto p: fp.informaProdutoEstoque()) {
			System.out.println("ID: " + p.getId() + " - Nome: " + p.getNome() + " - Preco: " + p.getPreco() +
					" - Categoria: " + p.getCategoria() + " - Data do cadastro: " + p.getDataCadastro() +
					" - Data da venda: " + p.getDataVenda() + " - Data de fabricacao: " + 
					p.getDataFabricacao() + " - Data de validade: " + p.getDataValidade());
		}
		*/
		
		// ---------------- Atualizar elementos da tabela produtos:
		
		/*
		Produto produto = new Produto();
		
		produto.setNome("Iogurte");
		produto.setPreco(2.95);
		produto.setCategoria("Leite e Derivados");
		produto.setDataCadastro(new Date());
		produto.setDataVenda(formato.parse("25/09/2023"));
		produto.setDataFabricacao(formato.parse("20/09/2023"));
		produto.setDataValidade(formato.parse("30/09/2023"));
		produto.setIngredientes("Leite e fermento lácteo");
		
		// O id presente na tabela:
		produto.setId(2); 
		
		fp.atualizaProduto(produto);
		*/
		
		// ---------------- Deletar elementos da tabela produtos:
		
		//fp.deletaProduto(2);
	}
}