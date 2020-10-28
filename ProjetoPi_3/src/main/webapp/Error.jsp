<%-- 
    Document   : Error
    Created on : Oct 27, 2020, 10:37:14 PM
    Author     : canejo
--%>

<c:if test="${not empty error}">
    
    <div class="modal fade" id="errorModal" tabindex="-1" aria-labelledby="errorModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">

          <div class="modal-body">
            ${error}
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-danger" data-dismiss="modal">Ok</button>
          </div>
        </div>
      </div>
    </div>
    <script>
        $('#errorModal').modal();
    </script>
</c:if>