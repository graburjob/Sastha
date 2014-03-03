
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.graburjob.sastha.model.registration.Document" %>
 <%@ page import="java.util.List" %>  
 <%@ page import="java.util.ArrayList" %>  
 
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<title>Patient_Login</title>
<!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" media="screen">
    <link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css" media="screen">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
  
  <%
  List<Document> listOfDocument = (ArrayList<Document>) request.getAttribute("uploadedDocumentsByUser");
  %>
<div class="container">

  <!-- row 1 -->
  <header class="row page-header">


    <div class="col-lg-4">
        <a href="index.html"><img src="images/Logo.png"></a>
      <div class="header">
        <h2>Sastha</h2>
      </div>
    </div>


    <div class="col-lg-8">
      <ul class="nav nav-pills pull-right">
        <li><a href="#"><h3>Home</h3></a></li>
        <li><a href="#"><h3>Products</h3></a></li>
        <li><a href="#"><h3>Upload Document</h3></a></li>
        <li><a href="#"><h3>Contact Us</h3></a></li>
        <li><a href="#"><h3>welcome Jagan,</h3> SignOut</a></li>
      </ul>
    </div>


  </header>
</div>




<div class="container">
    <div class="row">
      <div class="col-lg-2">
      </div>
       <div class="col-lg-6">
      <div class="header">
        <h2>Uploaded Scanned Copies</h2><br /><br />
      </div>
        <form method="post" action="UploadServlet" enctype="multipart/form-data">

			<div class="control-group">
              <div class="controls">
             <table class="table table-bordered">
             <thead>
             	<tr>
             	<td>Document ID</td>
             	<td>Document Name</td>
             	<td>Document Type</td>
             	<td>Document</td>
             	</tr>
             </thead>
             <%for(Document document:listOfDocument){ %>
             
              <tr>
              <td><%=document.getDocumentId()%></td>
              <td><%=document.getDocumentName()%></td>
              <td><%=document.getDocumentType() %></td>
              <td align="center"><a href="DisplayPhotoServlet?Document_ID=<%=document.getDocumentId() %>" ><img src="images/document_icon.png"></img> </a><p/></td>
               <%} %>
                </table>
              </div>
            </div> 
            
       <div class="header">
        <h2>Upload Scanned Copies</h2><br /><br />
      </div>
            
			<div class="form-group">
              <label for="inputradio">Document Type</label>
                <div>
                  <input type="radio" id="radio1" name="optionsRadios" value="Sales" checked="checked">Sales
                &nbsp; &nbsp;
              <input type="radio" id="radio2" name="optionsRadios" value="Purchase">Purchase
            </div>
          </div>
           <div class="form-group" style="position: relative">
            <label for="labelEmail">Scanned Copy</label>
            <input type="file" class="form-control" id="scannedCopy" name="scannedCopy" placeholder="Choose Scanned Image">
          </div>

          <input type="submit" class="btn btn-primary btn-lg pull-right" value ="Upload" />
          <input type="reset" class="btn btn-primary btn-lg pull-right" value="Clear" />
           
        </form>
       </div>
      <div class="col-lg-4">
      </div>
    </div>
</div>

<!--<div class="container">
  <footer class="row">
        <p class="muted credit">Example courtesy <a href="http://martinbean.co.uk">Martin Bean</a> and <a href="http://ryanfait.com/sticky-footer/">Ryan Fait</a>.</p>
  </footer>
</div>-->

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://code.jquery.com/jquery.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>