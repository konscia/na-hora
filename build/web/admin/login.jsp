<!DOCTYPE html>
<html lang="en">
  
  <jsp:include page="includes/head.jsp" />

  <body>

    <div class="container">

        <div class="row">

             <div class="span6 offset3">
                <form action="acao/login.jsp" method="POST">
                <legend>Bem Vindo ao Na Hora.</legend>

                <%
                //Se alguma mensagem de erro for encontrada na sessão
                if(session.getAttribute("error") != null){
                    //Pega a mensagem da sessão e converte-a para String
                    String mensagemErro = (String)session.getAttribute("error");
                    //Imprime em um bloco de erro
                    out.print( "<p class=\"alert alert-error\">" + mensagemErro + "</p>" );
                    //E Limpa a mensagem de erro. Afinal, se ela já foi exibida, pode deixar de existir.
                    session.setAttribute("error", null);
                }
                %>

                <fieldset>

                  <div class="control-group">
                    <label class="control-label" for="usuario">
                        Nome de Usuário:
                    </label>
                    <div class="controls">
                      <input type="text" class="input-large" id="usuario" name="usuario">
                    </div>
                  </div>

                  <div class="control-group">
                    <label class="control-label" for="senha">
                        Senha:
                    </label>
                    <div class="controls">
                      <input type="password" class="input-large" id="senha" name="senha">
                    </div>
                  </div>

                  <button type="submit" class="btn btn-primary">Acessar</button>

                </fieldset>
            </form>
             </div>
        </div>

    </div>
    
    <jsp:include page="includes/javascript.jsp" />
  </body>
</html>
