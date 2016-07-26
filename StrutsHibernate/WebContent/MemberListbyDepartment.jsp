<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

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