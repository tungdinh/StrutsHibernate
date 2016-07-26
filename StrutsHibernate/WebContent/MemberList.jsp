<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Member List</title>
<link href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js" type="text/javascript" ></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js" type="text/javascript"></script>

<script type="text/javascript">
    $( function(){
	    $('#button1').click(function(){
	        var val = $('#myselect').val();
	        //var val2 = $("#key").val();
	        $.ajax({
	            url: "MemberListbyDepartment.do",
	            type: "POST",
	            data: {
	            	'dpt_id' : val
	            	//'key' : val2
	            	},
	            success: function(res){
	             $("#result").html(res);
	            },
	            error: function(xhr, textStatus, errorThrown){
	            }
	        });
	    });
    });
</script>
</head>
<body>

<h2 style="background-color: #dc7329;">ユーザー名簿</h2>
<strong>グループ</strong>
<select id="myselect" style="width: 150px">
<logic:iterate id="choiceInfo" name="choices" scope="request">
    <option value="${choiceInfo.id}">${choiceInfo.deparment}</option>
</logic:iterate>
</select>
<button id="button1" style="background-color: #52e238;">検索</button>
<input type="button" value="追加" onclick="location.href='/StrutsHibernate/add.do'" style="background-color: #52e238;">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<!-- <strong>キーワード</strong><input id="key" type="text" />-->

<br><br>
<div id="result">
<table border="1">
  <tr bgcolor="#eeeeee" style="background-color: #527de7;">
    <th>名前</th><th>よみ</th><th>E-mail</th><th>連絡先</th>
  </tr>
  <logic:iterate id="memInfo" name="member.info" scope="request">
    <tr>
      <td width="150"><html:link action="member?id=${memInfo.id}" > ${memInfo.name} </html:link></td>
      <td width="200">${memInfo.nameYomikata}</td>
      <td width="250">${memInfo.email}</td>
      <td width="250">${memInfo.telephone}</td>
  </logic:iterate>
</table>
</div>
</body>
</html>