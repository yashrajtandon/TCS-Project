package br.com.animais.adocao.dao.teste;

import br.com.animais.adocao.model.Endereco;
import br.com.animais.adocao.model.Ong;
import br.com.animais.adocao.model.Usuario;
import junit.framework.TestCase;

class CadastroOngTeste extends TestCase {

	private Ong ong;
	
	public CadastroOngTeste() {
		super();
		testCadastroOng();
	}

	public void testCadastroOng() {
		ong = new Ong();
		Usuario usu = new Usuario();
		usu.setLogin("@gmail");
		usu.setSenha("senha");

		Endereco end = new Endereco();
		end.setLogradouro("log");
		end.setNumero("123");
		end.setBairro("Barra");
		end.setCep("89212-128");
		end.setCidade("Floria");
		end.setEstado("SC");

		ong.setUsuario(usu);
		ong.setEndereco(end);

		ong.setNome("Acao animal");
		ong.setTelefone("(99) 99999-9999");
		ong.setEmail("@gmail");
		ong.setDescricao("Animais de rua");
		ong.setCnpj("99.999.999/9999-99");

		System.out.println("Ong:" + ong.getNome());
	}
}
