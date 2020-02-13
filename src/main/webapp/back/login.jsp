<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8" import="java.util.*" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录 - 当当网</title>
<link href="${path }/back/css/login.css" rel="stylesheet" type="text/css" />
<link href="${path }/back/css/pop_cheat.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${path }/back/js/jquery-3.3.1.js"></script>
<script type="text/javascript">
	//点击切换验证码
	function changeImage(){
		$("#imgVcode").prop("src","${path }/admin/creatImage?a="+ new Date().getTime());
	}
</script>

</head>
<body>
	<div class="head">
		<a href="http://www.dangdang.com"> <img src="${path }/back/images/signin_logo.png" /></a>
		<div class="improve">
			<img src="${path }/back/images/bz.jpg" width="178" height="61" />
		</div>
	</div>

	<div class="login_bg" style="width:960px; margin:0 auto;">
		<img src="http://a.dangdang.com/api/data/cpx/img/38930001/1" style="display: none;">
		<div id="J_cheatProofTop" class="new_tip">
			<div id="component_2747856"></div>
			<div>为保障账户安全，请勿设置与邮箱及其他网站相同的账户登录密码或支付密码，<a href="javascript:;">谨防诈骗</a>！</div>
		</div>
		<div class="set_area clearfix">
			<div class="wrap clearfix">
				<div id="J_loginDiv">
					<form action="${path }/admin/login" method="post">
						<span style="color:red;font-size: 21px;margin-left: 45px;">${message}</span>
						<div id="J_loginCoreWrap" class="infro">
							<div class="username" id="username_div">
								<span></span> <input class="user" id="txtUsername" name="admin.username" type="text" />
							</div>
							<br /><br />

							<div class="password" id="password_div">
								<span></span> <input class="pass" id="txtPassword" name="admin.password" type="password" />
							</div>
							<br /> <br />
							<div id="J_captchVcodeWrap" style="" class="Captcha">
								<div class="code" style="width:100px;">
									<input type="text" name="clientCode" />
								</div>
								<div class="Captcha-operate">
									<div class="Captcha-imageConatiner">
										<a class="code_pic" id="vcodeImgWrap" name="change_code_img" href="javascript:void(0);">
											<img id="imgVcode" src="${path }/admin/creatImage" class="Ucc_captcha Captcha-image" onClick="changeImage()">
										</a>
										<a id="vcodeImgBtn" name="change_code_link" class="code_picww" href="javascript:changeImage()">换张图</a> 
										<span id="spn_vcode_ok" class="icon_yes pin_i" style="display: none;"></span> 
										<span id="J_tipVcode" class="cue warn"></span>
									</div>
								</div>
							</div>
							<br /> <br />

							<p class="btn">
								<input id="submitLoginBtn" type="submit" value="登&nbsp;录" />
							</p>
						</div>
					</form>
				</div>
			</div>
		</div>
</body>
</html>