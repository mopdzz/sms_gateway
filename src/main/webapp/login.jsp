<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ include file="/common/taglibs.jsp" %>
<html>
<head>
<title>增值业务管理平台 - 登陆</title>
<meta http-equiv=Content-Type content=text/html;charset=utf-8>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #1D3647;
}
-->
</style>
<link href="${stx}/css/skin.css" rel="stylesheet" type="text/css">
</head>
<body>
<table width="100%" height="166" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="42" valign="top"><table width="100%" height="42" border="0" cellpadding="0" cellspacing="0" class="login_top_bg">
      <tr>
        <td width="1%" height="21">&nbsp;</td>
        <td height="42">&nbsp;</td>
        <td width="17%">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td valign="top"><table width="100%" height="532" border="0" cellpadding="0" cellspacing="0" class="login_bg">
      <tr>
        <td width="49%" align="right"><table width="91%" height="532" border="0" cellpadding="0" cellspacing="0" class="login_bg2">
            <tr>
              <td height="138" valign="top"><table width="89%" height="427" border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td height="149">&nbsp;</td>
                </tr>
                <tr>
                  <td height="80" align="right" valign="top"><img src="${stx}/images/logo.png" width="279" height="68"></td>
                </tr>
                <tr>
                  <td height="198" align="right" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="35%">&nbsp;</td>
                      <td height="25" colspan="2" class="left_txt"><p>1 - 短信彩信IVR业务推广首选平台...</p></td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td height="25" colspan="2" class="left_txt"><p>2 - 一站通式的整合方式，方便使用...</p></td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td height="25" colspan="2" class="left_txt"><p>3 - 强大的后台管理系统，赚钱易如反掌...</p></td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td width="30%" height="40"><img src="${stx}/images/icon-demo.gif" width="16" height="16"><a href="" class="left_txt3"> 使用说明</a> </td>
                      <td width="35%"><img src="${stx}/images/icon-login-seaver.gif" width="16" height="16"><a href="" class="left_txt3"> 在线客服</a></td>
                    </tr>
                  </table></td>
                </tr>
              </table></td>
            </tr>

        </table></td>
        <td width="1%" >&nbsp;</td>
        <td width="50%" valign="bottom"><table width="100%" height="59" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
              <td width="4%">&nbsp;</td>
              <td width="96%" height="48"><span class="login_txt_bt">增值业务后台管理</span></td>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td height="21"><table cellSpacing="0" cellPadding="0" width="100%" border="0" id="table211" height="328">
                  <tr>
                    <td height="164" colspan="2" align="middle">
						<form name="myform" action="doLogin.action" method="post" onsubmit="return checkLoginForm();">
							<table cellSpacing="0" cellPadding="0" width="100%" border="0" height="143" id="table212">
							  <tr>
								<td width="13%" height="38" class="top_hui_text">
                                    <span class="login_txt">用 户：&nbsp;&nbsp; </span>
                                </td>
								<td height="38" colspan="2" class="top_hui_text">
                                    <input name="user.name" id="name" class="editbox4" value="" size="20">
                                </td>
							  </tr>
							  <tr>
								<td width="13%" height="35" class="top_hui_text">
                                    <span class="login_txt"> 密 码： &nbsp;&nbsp; </span>
                                </td>
								<td height="35" colspan="2" class="top_hui_text">
                                    <input name="user.passwd" id="passwd" class="editbox4" type="password" size="20">
								    <img src="${stx}/images/luck.gif" width="19" height="18">
                                </td>
							  </tr>
							  <tr>
								<td height="35" >&nbsp;</td>
								<td width="20%" height="35" ><input name="Submit" type="submit" class="button" id="Submit" value="登 陆"> </td>
								<td width="67%" class="top_hui_text"><input name="cs" type="reset" class="button" id="cs" value="取 消"></td>
							  </tr>
							</table>
							<br>
						</form>
					</td>
                  </tr>
                  <tr>
                    <td width="433" height="164" align="right" valign="bottom"><img src="${stx}/images/login-wel.gif" width="242" height="138"></td>
                    <td width="57" align="right" valign="bottom">&nbsp;</td>
                  </tr>
              </table></td>
            </tr>
          </table>
          </td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="20"><table width="100%" border="0" cellspacing="0" cellpadding="0" class="login-buttom-bg">
      <tr>
        <td align="center"><span class="login-buttom-txt">Copyright &copy; 2013-2015</span></td>
      </tr>
    </table></td>
  </tr>
</table>
<script src="${stx}/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript">
    function checkLoginForm(){
        if($("#name").val() == ""){
            alert("用户名不能为空");
            $("#name").focus();
            return false;
        }
        if($("#passwd").val() == ""){
            alert("密码不能为空");
            $("#passwd").focus();
            return false;
        }
    }
</script>
</body>
</html>