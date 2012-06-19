<!DOCTYPE html>
<html lang="en">
  
  <jsp:include page="includes/head.jsp" />

  <body>

    <div class="container">

        <jsp:include page="includes/bloco_topo.jsp" />

        <div class="row">

            <jsp:include page="includes/bloco_menu.jsp" />

             <div class="span9">
                 <h2>Cadastro de Novidade</h2>

                 <form class="form-horizontal well" action="acao/upload.jsp" method="POST" enctype="multipart/form-data">
                    <fieldset>

                      <div class="control-group">
                        <label class="control-label" for="file">
                            Arquivo
                        </label>
                          
                        <div class="controls">
                          <input type="file" id="file" name="file" size="50" />
                        </div>
                      </div>
                        
                      <div class="form-actions">
                        <button type="submit" class="btn btn-primary">Cadastrar</button>
                      </div>

                    </fieldset>
                  </form>
             </div>
        </div>

    </div>
    
    <jsp:include page="includes/javascript.jsp" />
  </body>
</html>
