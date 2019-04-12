<!DOCTYPE html>
<html>
<head>
<#include "meta.ftl">
<#include "head.ftl">
<link href="${contextPath}/resources/css/common/article.css" rel="stylesheet"/>
<style type="text/css">
.left_box p {text-indent: 2em;line-height:30px;}
</style>
</head>
<body>
<#include "header.ftl">
<article>
	<div class="left_box float_left">
		<#include "about_me_main.ftl">
	</div>
	<div class="right_box float_right">
		<#include "../blog/right.ftl">
	</div>
</article>
<#include "footer.ftl">
<#include "bottom.ftl">
</body>
</html>