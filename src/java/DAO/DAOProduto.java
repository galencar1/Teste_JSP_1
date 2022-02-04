package DAO;
import java.sql.Connection; /* Efetua a importação da biblioteca Connection. Efetua Conexão com DB*/
import MODEL.Produto;/*efetua importação dos Getters e Setters da Model Produto, Conseguimos
pegar e inserir os dados id_produto, nome_produto e qtd_produto no DB*/
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.sql.PreparedStatement;/*Importa Prepared Statement para inserir vários parâmetros no DB*/
import java.sql.Statement;/*Importa Statement, para inserir apenas UM parâmetro no DB.*/
import java.sql.ResultSet;/*Result set é responsável guardar os dados capturados no Statement
ou Prepared Statement*/
import java.util.ArrayList;//Recebe os dados que estão no Result Set e os organiza em uma lista.

public class DAOProduto {
    //Declarar as variáveis para utilizar nossos imports
    private Connection conn;
    private PreparedStatement pstm;
    private Statement st;
    private ResultSet rs;
    
    // Vamos criar uma ArrayList para os parametros que serão capturados da Model Produto
    private ArrayList<Produto> lista = new ArrayList<>();
    
    //Criar a conexão com o banco de dados
    public DAOProduto(){
        conn = new Conexao().pegarConexao();
    }
    
    //Criando método para inserir dados no banco de dados
    public void cadastrarProduto(Produto objproduto){
        // Criar uma variável String para receber o comando SQL
        String sql = "INSERT INTO produtos (nome_produto,qtd_produto) VALUES (?,?)";
        
        /*Criando Try catch - Vamos executar o comando dentro do Try e caso ocorra
        erro vai direto para Catch, nos informando qual erro ocorreu*/
        try {
            /*Vamos utilizar o prepared Statement(Vários parametros
            Efetuar a conexão com o banco de dados e capturar o comando SQL*/
            pstm = conn.prepareStatement(sql);
            /*Agora que a variável pstm se conectou com o DB e está atribuida a ela a variável'sql'
            vamos colocar uma string recebendo os dados da Model Produto acessando através
            do objproduto e recebendo os dados através dos Getters*/
            pstm.setString(1, objproduto.getNome_produto());
            pstm.setInt(2, objproduto.getQtd_produto());
            /*Vamos abrir o caminho e executar o comando*/
            pstm.execute();
            /*Vamos fechar o caminho que o comando foi executado*/
            pstm.close();
            
        } catch (Exception erro) {
            throw new RuntimeException("ERRO DAOProduto CADASTRAR PRODUTO " + erro);
        }
    }
    
    /*Vamos iniciar o método para listar produtos. Esse método será um Array List*/
    public ArrayList<Produto>listarProdutos(){
        /*Vamos criar uma variável String para receber o comando SQL*/
        String sql = "SELECT * FROM produtos";
        
        /*Criando Try catch - Vamos executar o comando dentro do Try e caso ocorra
        erro vai direto para Catch, nos informando qual erro ocorreu*/
        try {
            /*vamos efetuar a conexão atribuindo a variável statement(apenas UM parâmetro)*/
            st = conn.createStatement();
            /*Vamos utilizar o Result Set para guardar os resultados capturados pelo Statement*/
            rs = st.executeQuery(sql);
            /*Vamos criar um loop while para percorrer toda a tabela do DB,
            enquanto houver dados eles serão armazenados na lista*/
            while (rs.next()){
                /*Acessamos a Model Produto utilizando um objeto*/
                Produto objproduto = new Produto();
                 /*O Objeto Cliente acessa a model e seta os atributos com os valores
                que o rs pegou do banco de dados*/
                 objproduto.setId_produto(rs.getInt("id_produto"));
                 objproduto.setNome_produto(rs.getString("nome_produto"));
                 objproduto.setQtd_produto(rs.getInt("qtd_produto"));
                  /*Adicionamos os resultados capturados na lista utilizando o método lista 
                através do objeto cliente (Model Cliente)*/
                  lista.add(objproduto);
            }
        } catch (Exception erro) {
            throw new RuntimeException("ERRO DAOProduto listarProdutos() " + erro);
        }
        /*Como nosso método não é VOID precisamos de um retorno*/
        return lista;
    }
    
    
}
