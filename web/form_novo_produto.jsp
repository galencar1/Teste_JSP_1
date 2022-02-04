<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/estilos.css">
    <title>Formulário de Cadastro de Produto</title>
</head>
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
                
                    <div class="wrap-login100 p-l-50 p-r-50 p-t-72 p-b-50">
                        <form class="login100-form validate-form" 
                              method="post" action="cadastrarProduto.jsp"> 
                            <span class="login100-form-title p-b-59">Cadastrar

                            </span>
                            <div class="wrap-input100 validate-input" data-validate="Preencha o campo nome">
                                <span class="label-input100">Nome do Produto</span>
                                <input class="input100" type="text" name="nome" placeholder="Nome...">
                                <span class="focus-input100"></span>
                            </div>
                            <div class="wrap-input100 validate-input" data-validate="Digite uma quantidade">
                                <span class="label-input100">Quantidade</span>
                                <input class="input100" type="text" name="qtd" placeholder="Quantidade...">
                                <span class="focus-input100"></span>
                            </div>

                            <div class="container-login100-form-btn">
                                <div class="wrap-login100-form-btn">
                                    <div class="login100-form-bgbtn">
                                        <button class="login100-form-btn">Cadastrar</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                    
            </div>
        </div>
    </div>
</body>
</html>