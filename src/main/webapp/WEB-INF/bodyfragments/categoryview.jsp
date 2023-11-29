<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<section class="vh-100 gradient-custom bg-image bgimage">
  <div class="container py-5 h-100">
    <div class="row justify-content-center align-items-center h-100">
      <div class="col-12 col-lg-9 col-xl-7">
        <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
          <div class="card-body p-4 p-md-5">
           <%@include file="businessMessage.jsp" %>
            <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Add Blog Categories</h3>
            
             
            <sf:form method="post" action="${pageContext.request.contextPath}/addCat" modelAttribute="form">
            <sf:input type="hidden" id="id" class="form-control form-control-lg" path="id" name="id" value="${form.id}"/>
              <div class="row">
                <div class="col-md-6 mb-4">
                  <div class="form-outline">   
                  <s:bind path="catName">
                  <font color="red" style="font-size: 15px"><sf:errors path="${status.expression}" /></font>
                  <sf:input type="text" id="catName" class="form-control form-control-lg" path="catName" name="catName"/>
                  </s:bind>      
                  <label class="form-label" for="catName">Category Name</label>
                  
                  </div>
				 
                </div>
  
              </div>
                <c:choose>
  				<c:when test="${form.id>0}">
   				  <div class="mt-4 pt-2">
                <input class="btn btn-primary btn-lg" type="submit" value="Update" />
              </div>   
 			</c:when>

  			<c:otherwise>
             <div class="mt-4 pt-2">
                <input class="btn btn-primary btn-lg" type="submit" value="Add" />
              </div>
  			</c:otherwise>
			</c:choose> 

           </sf:form>
          
          </div>
        </div>
      </div>
    </div>
  </div>
</section>