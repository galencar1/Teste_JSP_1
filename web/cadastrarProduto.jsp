<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--Vamos capturar os dados do formulário e lançar na Model Produto,
e após isso executar o método cadastrarProduto() que está na classe DAOProduto
para lançar os dados no Banco de dados--%>

<%-- Primeiro passo é importar as classes--%>
<%@page import="MODEL.Produto"%>
<%@page import="DAO.DAOProduto"%>
<%
    /*Cadastrar os métodos para acessar as classes importadas*/
    Produto pro = new Produto();
    DAOProduto prod = new DAOProduto();
    
    /*Try Catch para acusar possíveis erros*/
    try {
            /*Vamos capturar os dados inseridos no formulário*/
            String nome = request.getParameter("nome");
            String qtd = request.getParameter("qtd");
            
            /*Vamos enviar os dados para a DAO Produto*/
            pro.setNome_produto(nome);
            pro.setQtd_produto(Integer.parseInt(qtd));
            /*Chama o método Cadastrar produto que está na DAOProduto
            e passa os valores capturados no formulário que estão na Model Produto*/
            prod.cadastrarProduto(pro);
            
            /*Exibe uma mensagem se o processo foi realizado com sucesso
            e retorna a página de cadastro de clientes*/
            out.print("Produto Inserido com Sucesso!");
            out.print("<meta http-equiv='refresh' content='3, url=form_novo_produto.jsp'>");
            
        } catch (Exception erro) {
            throw new RuntimeException("ERRO cadastrarProduto JSP " + erro);
        }
%>