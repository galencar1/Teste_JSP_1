
package MODEL;
//A model com os métodos Getters e Setters vão inserir dados no banco de dados
//e pegar os dados do banco de dados.
// Os nomes das variáveis devem ser iguais as colunas criadas nas tabelas do DB
public class Cliente {
    private int id_cliente;
    private String nome_cliente;
    private String email_cliente;
    private String telefone_cliente;

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getEmail_cliente() {
        return email_cliente;
    }

    public void setEmail_cliente(String email_cliente) {
        this.email_cliente = email_cliente;
    }

    public String getTelefone_cliente() {
        return telefone_cliente;
    }

    public void setTelefone_cliente(String telefone_cliente) {
        this.telefone_cliente = telefone_cliente;
    }
}
