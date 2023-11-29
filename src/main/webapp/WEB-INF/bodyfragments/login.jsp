<section class="vh-100 bg-image bgimage">
  <div class="container py-5 h-100">
    <div class="row d-flex align-items-center justify-content-center h-100">
      <div class="col-md-8 col-lg-7 col-xl-6">
        <img src="https://img.freepik.com/free-photo/computer-security-with-login-password-padlock_107791-16191.jpg"
          class="img-fluid" alt="Phone image">
      </div>
      <div class="col-md-7 col-lg-5 col-xl-5 offset-xl-1">
      <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Login Form</h3>
      <%@include file="businessMessage.jsp" %>
        <form method="post" action="${pageContext.request.contextPath}/auth" modelAttribute="form">
          <!-- Email input -->
          <div class="form-outline mb-4">
            <input type="email" id="form1Example13" class="form-control form-control-lg" name="email" />
            <label class="form-label" for="form1Example13">Email address</label>
          </div>

          <!-- Password input -->
          <div class="form-outline mb-4">
            <input type="password" id="form1Example23" class="form-control form-control-lg" name="password" />
            <label class="form-label" for="form1Example23">Password</label>
          </div>
          
          <div class="d-flex justify-content-around align-items-center mb-4">
          <!-- Submit button -->
          <button type="submit" class="btn btn-primary btn-lg btn-block">Sign in</button>

        </form>
      </div>
    </div>
  </div>
</section>