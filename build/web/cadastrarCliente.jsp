<%/*Nesta página vamos efetuar a comunicação da página web com o banco de dados.
    Vamos preencher um formulário na página web. Aqui nessa página vamos capturar 
    os dados digitados no formulário e enviar para Model.Cliente
    Após isso vamos executar o método Cadastrar cliente, que foi criado no DAOCliente.*/ %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%-- Primeiro passo é importar a Model.Cliente e a DAOCliente para podermos
acessar os métodos dentro dessas classes.--%>
<%@page import="MODEL.Cliente"%>
<%@page import="DAO.DAOCliente"%>

<% 
/*Vamos criar os objetos para acessar os métodos das classes especificadas.*/
Cliente cli = new Cliente();
DAOCliente clid = new DAOCliente();

/*Vamos criar um Try Catch para acusar caso ocorra um erro.*/
try {
        /*No try vamos capturar os dados inseridos no formulário da web
    e inseri-los na Model Cliente*/
        
        /*Pegando os dados do formulário*/
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        
        /*Inserindo os dados capturados acima na Model Cliente*/
        cli.setNome_cliente(nome);
        cli.setEmail_cliente(email);
        cli.setTelefone_cliente(telefone);
        
        /*Chama o método Cadastrar Cliente que está na DAO Cliente
        e passa os valores que estão na model Cliente*/
        clid.cadastrarCliente(cli);
        
        /*Exibe uma mensagem se o processo foi realizado com sucesso
        e retorna a página de cadastro de clientes*/
        out.print("Cliente Inserido com Sucesso!");
        out.print("<meta http-equiv='refresh' content='3, url=form_novo_cliente.jsp'>");
    
    
    } catch (Exception erro) {
        throw new RuntimeException("Erro Cadastrar Cliente JSP " + erro);
    }
%>
