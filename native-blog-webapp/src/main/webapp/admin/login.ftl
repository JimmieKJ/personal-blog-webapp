<!DOCTYPE html>
<html>
<head>
<#include "../common/meta.ftl">
<#include "../common/head.ftl">
</head>
<body>
<#include "../common/header.ftl">
<article>
<form action="${contextPath}/admin/login.do" method="POST" onsubmit="return admin_check()">
<div style="width:100%;height:500px;line-height:20px;" align="center">
	<table id="showTable" cellpadding="0" border="0" align="center">
		<tr>
			<td>密码：</td>
			<td><input type="password" name="password"/></td>
		<tr>
		<#include "../common/gVerify.ftl">
		<tr>
			<td>&nbsp;</td>
			<td>
			<input type="submit" value="登录" style="line-height:30px;height:30px;width:80px;"/>
			</td>
		</tr>
	</table>
</div>
</form>
</article>
<#include "../common/footer.ftl">
<#include "../common/bottom.ftl">
</body>
</html>