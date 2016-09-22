package br.sceweb.teste;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.Empresa;
import br.sceweb.modelo.EmpresaDAO;

public class UC01CadastrarEmpresa1 {

	static EmpresaDAO empresaDAO;
	static Empresa empresa;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empresaDAO = new EmpresaDAO();
		empresa = new Empresa();
		empresa.setNomeDaEmpresa("empresa x");
		empresa.setCnpj("89424232000180");
		empresa.setNomeFantasia("empresa x");
		empresa.setEndereco("rua taquari");
		empresa.setTelefone("2222");
	}
	/**
	 * estabelece as pre-condicoes antes da execucao de cada teste
	 * @throws Exception
	 */
	@Before
	public void excluiEmpresa() throws Exception{
		empresaDAO.exclui("89424232000180");
	}

	@Test
	public void CT01UC01FBCadastra_com_sucesso() {
		assertEquals(1,empresaDAO.adiciona(empresa));
		assertFalse(empresa.isValido("894242320001"));
		assertFalse(empresa.isValido("00000000000000"));
		assertFalse(empresa.isValido("11111111111111"));
		assertFalse(empresa.isValido("22222222222222"));
		assertFalse(empresa.isValido("33333333333333"));
		assertFalse(empresa.isValido("44444444444444"));
		assertFalse(empresa.isValido("55555555555555"));
		assertFalse(empresa.isValido("66666666666666"));
		assertFalse(empresa.isValido("77777777777777"));
		assertFalse(empresa.isValido("88888888888888"));
		assertFalse(empresa.isValido("99999999999999"));

	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		empresaDAO.exclui("89424232000180");
	}


}
