package controller;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import dao.ClienteDao;
import model.Cliente;

public class ClienteController {
	public static void main(String[] args) throws Exception {
		String[] clientes = null;
		String linha  = null;
		Cliente c = new Cliente();
		ClienteDao cliDao = new ClienteDao();

		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\pessoa.csv")));
		int i = 0;
		while ((linha = reader.readLine()) != null) {

			clientes = linha.split("[|]");

			c.setId(Integer.valueOf(clientes[0]));
			c.setNome(clientes[1]);
			c.setCpfcnpj(clientes[2]);
			cliDao.inserir(c);
			i++;
			System.out.println("Foram cadastradas " + i + " colunas");
		}
		reader.close();
	}
}
