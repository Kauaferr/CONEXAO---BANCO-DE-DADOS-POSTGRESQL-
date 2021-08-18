import java.sql.ResultSet;
import java.util.Scanner;

public class PRINCIPAL {

	public static void main(String[] args) {
conexaosql conexao = new conexaosql();

Scanner scan = new Scanner(System.in);
System.out.println("DIGITE O SEU NOME: ");

String sql = "INSERT INTO pessoas(id, nome, email) " + "VALUES ( default, 'BONNIE' , 'pedro.j@hotmail.com')";

String consultar = "SELECT * FROM pessoas;";

int res = conexao.executaSQL(sql);

ResultSet consultando = conexao.executaBusca(consultar);


if ( res >0 ) {
	System.out.println("CADASTRO REALIZADO COM SUCESSO!!");
}
else {
	System.out.println("ERRO NO CADASTRO!!");
}

try {
	while ( consultando.next()) {
		System.out.println("OQUE DESEJA FAZER??");
		int resposta = scan.nextInt(); 
		if ( resposta == 1) {
		int id = consultando.getInt("id");
		String nomedoCliente = consultando.getString("nome");
		String email = consultando.getString("email");
		System.out.println("NOME: " + nomedoCliente + "|EMAIL: " + email);
		
	}
	else {
		System.out.println("OQUE DESEJA FAZER?");
	}
	}
	
}catch (Exception e) {
	
	e.printStackTrace();
}
	}

}
