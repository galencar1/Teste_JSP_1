
package DAO;
import java.sql.Connection; // Realiza a Conexão com o banco de dados
import MODEL.Cliente; // Realiza o import dos métodos Getters e Setters da Model Cliente(Conseguimos inserir
//e pegar os atributos id, nome, email e telefone do cliente.
import java.sql.PreparedStatement; // Trabalha com inserção de parâmetros no banco de dados.
//Utilizamos o Prepared Statement quando vamos inserir VÁRIOS parametros no DB.
import java.sql.Statement; // Trabalha com a inserção de parâmetros no DB. 
//Utilizamos o Statement para inserir apenas UM Parâmetro
import java.sql.ResultSet; //Todos os dados obtidos da consulta do banco de dados
//são inseridos no Result Set(recebe do Statement ou do Prepared Statement      )
import java.util.ArrayList; // Os resultados lançados no Result Set são inseridos no array List
//para que possam ser exibidos em formato de tabela(lista).

public class DAOCliente {
    // Vamos declarar as variáveis que receberam utilizaram as bibliotecas importadas
    private Connection conn;
    private PreparedStatement pstm;
    private Statement st;
    private ResultSet rs;
    
    //Cria uma Array List dos Parâmetros capturados pela MODEL.Cliente com nome de lista.
    private ArrayList<Cliente> lista = new ArrayList<> (); 
    
    // Efetua a conexão da classe DAOCliente com o Banco de dados. Chamando o método pegar Conexão.
    public DAOCliente(){
        conn = new Conexao().pegarConexao();
    }
    
    //Criando método para inserir os dados no banco de dados
    public void cadastrarCliente(Cliente objcliente){
        // Criando a variável que vai receber o comando SQL
        String sql = "INSERT INTO clientes (nome_cliente,email_cliente,telefone_cliente) VALUES (?,?,?)";
        
        // Criando Try Catch. Vamos Executar o que está dentro do Try, e caso ocorra ERRO
        //cairá no Catch, mostrando pra nós qual o erro que ocorreu.
        
        try {
            // Vamos utilizar o prepared Statement(São vários Parâmetros)
            //efetuar a conexão com o banco de dados e capturando o comando
            //SQL que está na variável "sql"
            pstm = conn.prepareStatement(sql);
            
            // Agora que a variável "pstm" está com o Comando SQL, vamos utilizá-la
            // para colocar uma string na Model.Cliente utilizando os Getters
            // para inserir os dados nas colunas das tabelas;
            pstm.setString(1, objcliente.getNome_cliente());
            pstm.setString(2, objcliente.getEmail_cliente());
            pstm.setString(3, objcliente.getTelefone_cliente());
            
            //Vamos abrir o caminho e executar o comando para que seja inserido os dados no DB
            pstm.execute();
            
            //Vamos fechar o caminho aberto
            pstm.close();
            
        } catch (Exception erro) {
            throw new RuntimeException("ERRO DAOCliente CADASTRAR CLIENTE " + erro);
        }
    }
    
    /*Criar um método ArrayList para listar os clientes cadastrados no DB*/
    public ArrayList<Cliente> listarClientes(){
        /*Cria variável para guardar a Instrução SQL*/
        String sql = "SELECT * FROM clientes";
        /*Try Catch para verificação de erros*/
        try {
            /*utilizamos o statement(Apenas um parâmetro) para pegar os dados
            e o Result Set para guardar os resultados*/
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            /*Criamos um loop while para percorrer toda a tabela do DB
            enquanto houver uma próxima linha com dados ele buscará e armazenará
            */
            while(rs.next()){
                /*Acessamos a Model Cliente através de um obj*/
                Cliente objcliente = new Cliente();
                /*O Objeto Cliente acessa a model e seta os atributos com os valores
                que o rs pegou do banco de dados*/
                objcliente.setId_cliente(rs.getInt("id_cliente"));
                objcliente.setNome_cliente(rs.getString("nome_cliente"));
                objcliente.setEmail_cliente(rs.getString("email_cliente"));
                objcliente.setTelefone_cliente(rs.getString("telefone_cliente"));
                /*Adicionamos os resultados capturados na lista utilizando o método lista 
                através do objeto cliente (Model Cliente)*/
                lista.add(objcliente);
                
            }
        } catch (Exception erro) {
            throw new RuntimeException("ERRO DAOCliente Listar Clientes " + erro);
        }
        /*Como nosso método não é VOID precisamos de um retorno*/
        return lista;
    }
    
}
