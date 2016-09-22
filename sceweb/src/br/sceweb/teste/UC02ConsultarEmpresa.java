package br.sceweb.teste;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.Empresa;
import br.sceweb.modelo.EmpresaDAO;
import junit.framework.AssertionFailedError;

public class UC02ConsultarEmpresa {

	static Empresa empresaEsperada;
	static Empresa empresaObtida;
	static EmpresaDAO empresaDAO;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empresaEsperada = new Empresa();
		empresaEsperada = new Empresa();
		empresaEsperada.setNomeDaEmpresa("empresa x");
		empresaEsperada.setCnpj("89424232000180");
		empresaEsperada.setNomeFantasia("empresa x");
		empresaEsperada.setEndereco("rua taquari");
		empresaEsperada.setTelefone("2222");
		empresaObtida = new Empresa();
		empresaDAO = new EmpresaDAO();
		empresaDAO.adiciona(empresaEsperada);
	}
	
	@After
	public void excluirEmpresa() throws Exception{
		empresaDAO.exclui("89424232000180");
	}

	@Test
	public void CT01ConsultarEmpresa_com_sucesso() {
		empresaObtida = empresaDAO.consultaEmpresa("89424232000180");
		assertTrue(empresaEsperada.equals(empresaObtida));
		
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}
