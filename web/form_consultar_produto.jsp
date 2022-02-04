<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="DAO.DAOProduto" %>
<%@page import="MODEL.Produto" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/estilos_tabela.css">
    <title>Consulta de Clientes</title>
</head>
<body>
    <body style="background-color: #999999;">
        <div class="limiter">
            <div class="container-login100">
                <div class="login100-more">
                    <div id="slider">
                        
                        <img class="selected" src="imagens/pet_1.jpg" alt="pet_1" width="500px" height="500px">
                        <img src="imagens/pet_2.jpeg" alt="pet_2" width="500px" height="500px">
                        <img src="imagens/pet_3.png" alt="pet_3" width="500px" height="500px">
                        <img src="imagens/pet_4.jpg" alt="pet_4" width="500px" height="500px">
                        <img src="imagens/pet_5.png" alt="pet_5" width="500px" height="500px">
                
                        <script src="js/script.js"></script>

                        <div class="login100-links">
                    
                            <div class="container-login100-form-btn">
                                <div class="wrap-login100-form-btn">
                                    <div class="login100-form-bgbtn">
                                       <a href="index.jsp"><button class="login100-form-btn">Inicio</button></a>
                                    </div>
                                </div>
                            </div>
                        
                            <div class="container-login100-form-btn">
                                <div class="wrap-login100-form-btn">
                                    <div class="login100-form-bgbtn">
                                       <a href="form_novo_produto.jsp"><button class="login100-form-btn">Cadastrar Produto</button></a>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="tabela">
                        <table border="1">
                            <tr>
                                <th>ID</th>
                                <th>NOME</th>
                                <th>QUANTIDADE</th>
                            </tr>
                            <%--Vamos chamar a DAO Produto para acessar os métodos --%>
                            <%
                                DAOProduto prod = new DAOProduto();
                                /*Vamos chamar o método listar clientes através do ArrayList*/
                                ArrayList<Produto> lista = prod.listarProdutos();
                                /*Vamos criar um loop for para percorrer toda a lista e trazer
                                os dados obtidos*/
                                for(int i=0;i<lista.size();i++){
                                out.print("<tr>");
                                   /*Com o método lista pegamos a variável 'i', 
                                    e pegamos os métodos Getter da Model Cliente*/
                                    out.print("<td>"+lista.get(i).getId_produto()+"</td>");
                                    out.print("<td>"+lista.get(i).getNome_produto()+"</td>");
                                    out.print("<td>"+lista.get(i).getQtd_produto()+"</td>");
                                out.print("</tr>");
                            }
                            %>
                            
                        </table>
                    </div>

                </div>
            </div>

        </div>
    </body>

</body>
</html>
