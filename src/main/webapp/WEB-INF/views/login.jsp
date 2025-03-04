<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<jsp:include page="header.jsp" />
<section class="contact_section layout_padding">
    <div class="contact_bg_box">
      <div class="img-box">
        <img src="images/contact-bg.jpg" alt="">
      </div>
    </div>
    <div class="container">
      <div class="heading_container heading_center">
        <h2>
          Login Page
        </h2>
      </div>
      <div class="">
        <div class="row">
          <div class="col-md-7 mx-auto">
            <form action="login" method="POST">
              <div class="contact_form-container">
                <div>
                  
                  <div>
                    <input type="text" name="unm" placeholder="User Name" />
                  </div>
                  <div>
                    <input type="password" name="pw" />
                  </div>
                  <div class="btn-box ">
                    <input type="submit" value="Submit" />
                  </div>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </section>
</body>
<jsp:include page="footer.jsp" />
</html>