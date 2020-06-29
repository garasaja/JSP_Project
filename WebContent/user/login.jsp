<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<br/><br/>
<style>
#modal {
  position:relative;
  width:100%;
  height:100%;
  z-index:1;
}

#modal h2 {
  margin:0;   
}

#modal button {
  display:inline-block;
  width:100px;
  margin-left:calc(100% - 100px - 10px);
}

#modal .modal_content {
  width:300px;
  margin:100px auto;
  padding:20px 10px;
  background:#fff;
  border:2px solid #666;
}

#modal .modal_layer {
  position:fixed;
  top:0;
  left:0;
  width:100%;
  height:100%;
  background:rgba(0, 0, 0, 0.5);
  z-index:-1;
}   
</style>

<%@ include file="../include/nav.jsp" %>
<br/><br/>



<div class="modal-dialog">
  <div class="modal-content">
      <div class="modal-header">
       <h1 class="text-center">Login</h1>
          
         
      </div>
      <div class="modal-body">
          <form class="form col-md-12 center-block" action="/blog/user?cmd=loginProc" method="POST">
            <div class="form-group">
              <input type="text" class="form-control input-lg" id="username" placeholder="ID" name="username" required>
            </div>
            <div class="form-group">
              <input type="password" class="form-control input-lg" id="password" placeholder="Password" name="password" required>
            </div>
            <div class="form-group">
              <button class="btn btn-primary btn-lg btn-block">Sign In</button>
              <span class="pull-right"><a href="/blog/user?cmd=join">Register</a></span>
            </div>
          </form>
      </div>
      <div class="modal-footer">
          <div class="col-md-1accordion2">
        
    	  </div>	
      </div>
  </div>
  </div>


	
	
	  <!--login modal-->

  









<%@ include file="../include/footer.jsp" %>