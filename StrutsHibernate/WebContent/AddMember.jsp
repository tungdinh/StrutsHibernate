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
<title>Add Member</title>
</head>
<body>
<% MemberModel mb = new MemberModel();
   ArrayList<Department> listDep = mb.getDepartments();
   request.setAttribute("choices", listDep); %>

<h2 style="background-color: #dc7329;">新規作成</h2>
<html:errors/>

    <html:form method="POST" action="/save" >
        <table border="1" cellspacing="2" cellpadding="2">
               <tr>
                   <td>部門</td>
                   <td>
                   <html:select property="department_id" style="width: 150px">
                   <logic:iterate id="choiceInfo" name="choices" scope="request">
                   <html:option value="${choiceInfo.id}">${choiceInfo.deparment}</html:option>
                   </logic:iterate>
                   </html:select>
                   </td>
               </tr>
               <tr>
                   <td>ユーザーID</td>
                   <td>
                       <html:text property="id" />
                   </td>
               </tr>
               <tr>
                   <td>名前</td>
                   <td>
                       <html:text property="name" />
                   </td>
               </tr>
               <tr>
                   <td>名前(ふりがな)</td>
                   <td>
                       <html:text property="nameYomikata" />
                   </td>
               </tr>
               <tr>
                   <td>Email</td>
                   <td>
                       <html:text property="email" />
                   </td>
               </tr>
               <tr>
                   <td>連絡先</td>
                   <td>
                       <html:text property="telephone"  />
                   </td>
               </tr>
               <tr>
                   <td>住所</td>
                   <td>
                       <html:text property="address"  />
                   </td>
               </tr>
       </table><br>
    <html:submit value="作成" property="button" style="background-color: #52e238;"/>
    </html:form>

</body>
</html>