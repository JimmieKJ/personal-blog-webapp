	<div class="user_profile">
        <h3>用户中心</h3>
        <#if user?? && user.nickName??>
            <div id="user_info_div">
                <#if user.imagePath??>
                <div id="avatar_div" class="float_left">
                    <img id="avatar_img" src="${user.imagePath}" height="30" width="30">
                </div>
                </#if>
                <div id="welcome_div" class="float_left">
                <u><i><a href="${contextPath}/common/user_center.ftl" style="font-size:15px;" title="用户中心">${user.nickName}</a></i></u><span class="welcome_font">，欢迎你！</span>
                </div>
                <div id="logout_div" class="float_right">
                    <a id="logout_button" href="#" class="button">注销</a>
                </div>
            </div>
            <#else>
            <table id="login_table" cellspacing="0" cellpadding="0">
                <tbody>
                <tr>
                    <td style="font-size: 12px;">用户名：</td>
                    <td><input class="text_input" type="text" name="username"/></td>
                </tr>
                <tr>
                    <td style="font-size: 12px;">密  码：</td>
                    <td><input class="text_input" type="password" name="password"/></td>
                </tr>
                <#include "../common/gVerify.ftl">
				<tr>
                    <td><a id="login_button" href="#" class="button">登录</a></td>
                    <td><a id="register_button" href="#" class="button">注册</a></td>
                </tr>
                </tbody>
            </table>
        </#if>
    </div>