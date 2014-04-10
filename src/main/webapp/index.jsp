<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>send mail page</title>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript">
    function sendMail() {
    	var email = document.getElementById("email").value;
    	var title = document.getElementById("title").value;
    	var content = document.getElementById("content").value;
    	var data = {
    		  email:email,
    		  title:title,
    		  content:content
    	};
    	$.ajax({
    		type : "POST",
    		url  : "sendMail",
    		data : data,
    		/* dataType : "application/json", */ 
    		success : function(data) {
    			if(data == "success") {
    				alert('邮件发送成功!')
    			} else {
    				alert('邮件发送失败！')
    			}
    		}
    	});
    }
</script>
</head>
<body>
  <center>
  		联系方式:<input type="text" name="email" id="email"></input><br>
  		标题:&nbsp;&nbsp;<input name="title" id="title"></input><br>
  		详细描述:<textarea rows="3" cols="20" id="content"></textarea><br>
  		<input type="button" value="提交" id="subBtn" onclick="sendMail();"></input>
  </center>

</body>
</html>