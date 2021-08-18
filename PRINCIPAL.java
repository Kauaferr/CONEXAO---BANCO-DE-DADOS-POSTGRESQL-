import java.sql.ResultSet;
import java.util.Scanner;

public class PRINCIPAL {

	public static void main(String[] args) {
conexaosql conexao = new conexaosql();

Scanner scan = new Scanner(System.in);
System.out.println("DIGITE O SEU NOME: ");

String sql = "INSERT INTO pessoas_profissao(id_pessoas, id_profissao) " + "VALUES ( 2,1)";
String sql1 = "INSERT INTO pessoas(id, nome, email) " + "VALUES ( default, 'BONNIE' , 'pedro.j@hotmail.com')";



int res = conexao.executaSQL(sql);
int res1 = conexao.executaSQL(sql1);


String consultar = "SELECT * FROM pessoas;";


ResultSet consultando = conexao.executaBusca(consultar);


if ( res >0 ) {
	System.out.println("CADASTRO REALIZADO COM SUCESSO!!");
}
else {
	System.out.println("ERRO NO CADASTRO!!");
}

try {
	for ( int cont = 0; cont<=5;) {
	while ( consultando.next()) {
		
		cont++;
		int id = consultando.getInt("id");
		String nomedoCliente = consultando.getString("nome");
		String email = consultando.getString("email");
		System.out.println("NOME: " + nomedoCliente + "|EMAIL: " + email);
		
	}
	}
}catch (Exception e) {
	
	e.printStackTrace();
}
	}

}
