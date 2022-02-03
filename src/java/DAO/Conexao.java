package DAO;
// Primeiro passo. Importar o Connection SQL e o DriverManager SQL.
import java.sql.Connection;
import java.sql.DriverManager;
public class Conexao {
    // Criar método pegar conexão com Connection
    public Connection pegarConexao(){
        //Try catch para efetuar a conexão com o DriverManager
        try {
            //Conexão com o DriverManager
            Class.forName("org.gjt.mm.mysql.Driver");
            return DriverManager.getConnection
            ("jdbc:mysql://localhost/teste_1?autoReconnect=true&useSSL=false","teste","FrangoeFritas77");
                    
        } catch (Exception erro) {
            throw new RuntimeException("Erro na Classe DAO Conexão" + erro);
        }
    }
    
}
