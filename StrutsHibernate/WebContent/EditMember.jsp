<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entities.Department" %>
<%@ page import="model.MemberModel" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Member</title>
<script type="text/javascript">
  function deleteConfirm(){
	  if(confirm('Are you sure ?'))
		  location.href='/StrutsHibernate/delete.do?id=${l.id}'
  }
</script>
</head>
<body>
<% MemberModel mb = new MemberModel();
   ArrayList<Department> listDep = mb.getDepartments();
   request.setAttribute("choices", listDep);
%>
<html:errors/>

<h2 style="background-color: #dc7329;">
<logic:iterate id="l" collection="${listEdit}">
<bean:write name="l" property="name"/>
</logic:iterate></h2>

   <html:form action="update.do" method="POST">
    <logic:iterate id="l" name="listEdit" scope="request">
       <table border="1" cellspacing="2" cellpadding="2" >
               <tr>
                   <td style="background-color: #527de7;">部門</td>
                   <td>
                   <html:select property="department_id" value="${dptId}" style="width: 150px">
                   <logic:iterate id="choiceInfo" name="choices" scope="request">
                   <html:option value="${choiceInfo.id}" >${choiceInfo.deparment}</html:option>
                   </logic:iterate>
                   </html:select>
                   </td>
               </tr>
               <tr>
                   <td style="background-color: #527de7;">ユーザーID</td>
                   <td>
                       <html:text property="id" name="l" readonly="true" />
                   </td>
               </tr>
               <tr>
                   <td style="background-color: #527de7;">名前</td>
                   <td>
                       <html:text property="name" name="l"  />
                   </td>
               </tr>
               <tr>
                   <td style="background-color: #527de7;">名前(ふりがな)</td>
                   <td>
                       <html:text property="nameYomikata" name="l" />
                   </td>
               </tr>
               <tr>
                   <td style="background-color: #527de7;">Email</td>
                   <td>
                       <html:text property="email" name="l" />
                   </td>
               </tr>
               <tr>
                   <td style="background-color: #527de7;">連絡先</td>
                   <td>
                       <html:text property="telephone" name="l" />
                   </td>
               </tr>
               <tr>
                   <td style="background-color: #527de7;">住所</td>
                   <td>
                       <html:text property="address" name="l" />
                   </td>
               </tr>


       </table><br>
     </logic:iterate>
   <html:submit value="更新" property="button" style="background-color: #52e238;"/>
   <input type="button" value="削除"  style="background-color: #52e238;" onclick="location.href='/StrutsHibernate/delete.do?id=${l.id}'">
   </html:form>

</body>
</html>