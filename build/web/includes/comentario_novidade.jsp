<form class="form-horizontal" action="acao/cad_comentario_novidade.jsp" method="POST">
    <fieldset>

      <input type="hidden" name="id_novidade" value="<%=request.getParameter("id")%>" />

      <div class="control-group">
        <label class="control-label" for="nome">
            Nome
        </label>
        <div class="controls">
          <input type="text" class="input-large" id="nome" name="nome">
        </div>
      </div>

      <div class="control-group">
        <label class="control-label" for="texto">
            Texto
        </label>
        <div class="controls">
          <textarea class="input-large" id="texto" name="texto" rows="8"></textarea>
        </div>
      </div>

      <div class="form-actions">
        <button type="submit" class="btn btn-primary">Enviar comentário</button>
      </div>

    </fieldset>
</form>