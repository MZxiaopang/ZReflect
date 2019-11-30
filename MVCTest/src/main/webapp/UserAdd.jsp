<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>

<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style type="text/css">
    	.error{
    		color: red;
    	}
        .table1{

            border: 1px gray solid;
            border-collapse: collapse;
        }
        .tr1{
            width: 810px;
            height: 40px;
        }
        .td1{
            border: 1px gray solid;
             width: 100px;
             height: 40px;
            text-align: center;
         }
        .td2{
            border: 1px gray solid;
            width: 300px;
            height: 40px;
        }
        .td3{
            text-align: center;
            border: 1px gray solid;
            width: 100px;
            height: 40px;
        }
        .td4{
            border: 1px gray solid;
            width: 300px;
            height: 40px;
        }
        .input1{
            width: 160px;
            height: 30px;
        }
        .input2{
            width: 250px;
            height: 30px;
        }
        select{
            width: 100px;
            height: 30px;
        }
        #div1{
            margin-top: 20px;
        }
    </style>
    <script src="jQuery/jquery.js"></script>
	<script src="jQuery/jquery.validate.min.js"></script>
	<script src="jQuery/messages_zh.js"></script>
    <script type="text/javascript">
    	$().ready(function() {
    		$("#form").validate({
    			rules:{
    				username:{
    					required:true,
    					minlength:6,
    					maxlength:12
    				},
    				password:{
    					required:true,
    					minlength:6,
    					maxlength:12
    				},
    				shouji:{
    					required:true,
    					digits:true,
    					minlength:11,
    					maxlength:11
    				},
    				dizhi:{
    					required:true,
    					maxlength:30
    				},
    				age:{
    					required:true,
    					digits:true
    				},
    				dianhua:{
    					required:true,
    					digits:true,
    					minlength:7,
    					maxlength:7
    				},
    				shenfenzhenghao:{
    					required:true,
    					digits:true,
    					minlength:18,
    					maxlength:18
    				},
    				youxiang:{
    					required:true,
    					email:true
    				},
    				qq:{
    					required:true,
    					digits:true,
    					minlength:3,
    					maxlength:10
    				},
    				aihao:{
    					required:true,
    					maxlength:30
    				},
    				gongzhikahao:{
    					required:true,
    					digits:true,
    					minlength:10,
    					maxlength:10,
    				},
    				minzu:{
    					required:true,
    					minlength:1,
    					maxlength:20
    				},
    				beizhu:{
    					required:true,
    					minlength:1,
    					maxlength:100
    				}
    			},
    			messages:{
    				username:{
    					required:"请输入用户名",
    					minlength:"用户名长度最小为6位",
    					maxlength:"用户名长度最大为12位"
    				},
	    			password:{
						required:"请输入密码",
						minlength:"密码长度最小为6位",
						maxlength:"密码长度最大为12位"
					},
					shouji:{
						required:"请输入手机号",
						digits:"手机号只能是数字",
						minlength:"手机号最小是11位",
						maxlength:"手机号最大是11位"
					},
					dizhi:{
						required:"请输入地址",
						maxlength:"地址最大长度30"
					},
					age:{
						required:"请输入年龄",
						digits:"年龄只能是数字"
					},
					dianhua:{
						required:"请输入电话号",
						digits:"电话只能是数字",
						minlength:"最少长度是7位",
						maxlength:"最大长度是7位"
					},
					shenfenzhenghao:{
						required:"请输入身份证号码",
						digits:"身份证号码只能是数字",
						minlength:"身份证号码最小是18位",
						maxlength:"身份证号码最长是18位"
					},
					youxiang:{
						required:"请输入邮箱",
						email:"请输入正确邮箱格式XXX@XXX.XXX"
					},
					qq:{
						required:"请输入qq号码",
						digits:"qq号码只能是数字",
						minlength:"qq号码最小是3位",
						maxlength:"qq号码最长是10位"
					},
					aihao:{
						required:"请输入爱好",
						maxlength:"最大长度不超过30个字"
					},
					gongzhikahao:{
						required:"请输入工资卡号",
						digits:"工资卡号只能是数字",
						minlength:"工资卡号最小是10位",
						maxlength:"工资卡号最长是10位"
					},
					minzu:{
						required:"请输入民族",
						minlength:"长度最低是1个字",
						maxlength:"长度最高是20个字"
					},
					beizhu:{
						required:"请输入备注",
						minlength:"最少是1个字",
						maxlength:"最多是100个字"
					}
    				
    			}
    		});
		})
    </script>
    
</head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<body>
<form action="alter" method="post" id="form" onsubmit="return on()">
<div id="div1">

		<h1>${a }</h1>

    <div id="div2">
        <table class="table1">
            <tr class="tr1">
                <td class="td1">
                    <h4>用户名</h4>
                </td>
                <td class="td2">
               		<input type="hidden" name="id" id="user_id" value="${user.user_id }" >
               		<input type="hidden" name="create_time" id="create_time" value="${user.create_time }" >
               		<input type="hidden" name="creater" id="creater" value="${user.creater }" >
                    <input class="input1" id="username" type="text"  name="username" value="${user.username }" onblur="oon()"><i id="i1"></i>
                </td>
                <td class="td3">
                    <h4>密码</h4>
                </td>
                <td class="td4">
                    <input class="input1" maxlength="12"  type="password" name="password" value="${user.password }">
                </td>
            </tr>
            <tr class="tr1">
                <td class="td1">
                    <h4>是否为管理员</h4>
                </td>
                <td class="td2">
               		<input type="radio" checked="checked" name="messager" value="true">是
                    <input type="radio"  name="messager" value="false">不是
                </td>
                
            </tr>
            <tr class="tr1">
                <td class="td1">
                    <h4>部门</h4>
                </td>
                <td class="td2">
                    <select name="bumen" >
	                    <c:if test="${!empty DepartmentList }">
	                       <c:forEach var="i" begin="0" end="${DepartmentList.size()-1}">
	                      	  <option  value="${DepartmentList[i].department_id }">${DepartmentList[i].department_name}</option>
	                        </c:forEach>
	                    </c:if>
                    </select>
                </td>
	       
                <td class="td3">
                    <h4>角色</h4>
                </td>
                <td class="td4">
                    <select name="juese">
                    	<c:if test="${!empty RoleList }">
	                    	<c:forEach var="i" begin="0" end="${ RoleList.size()-1}">
	                      	  <option value="${RoleList[i].role_id }">${RoleList[i].role_name}</option>
	                        </c:forEach>
                        </c:if>
                    </select>
                </td>
           
            </tr>
            <tr class="tr1">
                <td class="td1">
                    <h4>性别</h4>
                </td>
                <td class="td2">
                    <input type="radio" checked="checked" name="sex" value="true">男
                    <input type="radio"  name="sex" value="false">女
                </td>
                          
                <td class="td3">
                    <h4>手机号</h4>
                </td>
                <td class="td4">
                    <input class="input1"  type="text" name="shouji" maxlength="11" id="mobile" value="${user.mobile }" onblur="oon1()"><i id="i2"></i>
                </td>
            </tr>
            <tr class="tr1">
                <td class="td1">
                    <h4>地址</h4>
                </td>
                <td class="td2">
                    <input class="input2" type="text" name="dizhi" value="${user.address }">
                </td>
                <td class="td3">
                    <h4>年龄</h4>
                </td>
                <td class="td4">
                    <input class="input1"  type="text" name="age" value="${user.age }">
                </td>
            </tr>
            <tr class="tr1">
                <td class="td1">
                    <h4>固定电话</h4>
                </td>
                <td class="td2">
                    <input class="input1"  type="text" name="dianhua" value="${user.tel }">
                </td>
                <td class="td3">
                    <h4>身份证号</h4>
                </td>
                <td class="td4">
                    <input class="input2" maxlength="18"  type="text" name="shenfenzhenghao" id="id_num" value="${user.id_num }" onblur="oon2()"><i id="i3"></i>
                </td>
            </tr>
            <tr class="tr1">
                <td class="td1">
                    <h4>电子邮箱</h4>
                </td>
                <td class="td2">
                    <input class="input2" type="text" name="youxiang" value="${user.email }">
                </td>
                <td class="td3">
                    <h4>QQ号</h4>
                </td>
                <td class="td4">
                    <input class="input1"  type="text" name="qq" value="${user.qq }">
                </td>
            </tr>
            <tr class="tr1">
                <td class="td1">
                    <h4>爱好</h4>
                </td>
                <td class="td2">
                    <input class="input1"  type="text" name="aihao" value="${user.hobby }">
                </td>
                <td class="td3">
                    <h4>学历</h4>
                </td>
                <td class="td4">
                    <select name="xueli">
                        <option value="1">小学</option>
                        <option value="2">初中</option>
                        <option value="3">高中</option>
                        <option value="4">专科</option>
                        <option value="5">本科</option>
                        <option value="6">硕士</option>
                        <option value="7">博士</option>
                    </select>
                </td>
                
        
            </tr>
            <tr class="tr1">
                <td class="td1">
                    <h4>工资卡号</h4>
                </td>
                <td class="td2">
                    <input class="input1"  type="text" name="gongzhikahao" id="card_num" value="${user.card_num }" onblur="oon3()"><i id="i4"></i>
                </td>
                <td class="td3">
                    <h4>民族</h4>
                </td>
                <td class="td4">
                    <input class="input1"  type="text" name="minzu" value="${user.nation }">
                </td>
            </tr>
            <tr class="tr1">
                <td class="td1">
                    <h4>婚姻状况</h4>
                </td>
                <td class="td2">
                    <select name="hunyin">
                        <option value="-1">离异</option>
                        <option value="0">未婚</option>
                        <option value="1">已婚</option>
                    </select>
                </td>
        
                <td class="td3">

                </td>
                <td class="td4">

                </td>
            </tr>
            <tr class="tr1">
                <td class="td1">
                    <h4>备注</h4>
                </td>
                <td class="td2" colspan="3">
                    <textarea style="width:700px ;height:100px;" name="beizhu">${user.remark }</textarea>
                </td>
            </tr>
        </table>
    </div>
    <div id="div3">
        <div id="div4" style="margin-left: 300px;margin-top:20px; ">
        	<input type="hidden" value="Useralter" name="service">
            <input type="submit" value="保存" style="width: 80px;height: 40px;font-size: 20px;">
            &nbsp;&nbsp;&nbsp;
            <input type="button" value="返回" onclick="f1()" style="width: 80px;height: 40px;font-size: 20px;">
        </div>
    </div>
</div>
</form>
<script>
function f1() {
	location.href="${pageContext.request.contextPath }//ManagerPageServlet?service=UserGuanLi";
}
var i=false;

function oon() {
	$.ajax({
		url:"ManagerPageServlet?service=selectUser",
		data:{
			username1:$("#username").val()
		},
		success:function(data){
			if (data=="true") {
				$("#i1").text("");
				i=true;
			}else {
				$("#i1").text("用户名已存在！");
				if ($("#username").val()=="${user.username}") {
					$("#i1").text("");
				}
				i=false;
			}
		}		
	})	
	
}
function oon1() {
	$.ajax({
		url:"ManagerPageServlet?service=selectUserMobile",
		data:{
			mobile1:$("#mobile").val()
		},
		success:function(data){
			if (data=="true") {
				$("#i2").text("");
				i=true;
			}else {
				$("#i2").text("手机号已存在请确认后操作！");
				i=false;
			}
		}		
	})	
}
function oon2() {
	$.ajax({
		url:"ManagerPageServlet?service=selectUserId_num",
		data:{
			id_num1:$("#id_num").val()
		},
		success:function(data){
			if (data=="true") {
				$("#i3").text("");
				i=true;
			}else {
				$("#i3").text("身份证号已存在请确认后操作！");
				i=false;
			}
		}		
	})	
}
function oon3() {
	$.ajax({
		url:"ManagerPageServlet?service=selectUserCard_num",
		data:{
			card_num1:$("#card_num").val()
		},
		success:function(data){
			if (data=="true") {
				$("#i4").text("");
				i=true;
			}else {
				$("#i4").text("银行卡号已存在请确认后操作！");
				i=false;
			}
		}		
	})	
}
function on() {
		if ($("#username").val()=="${user.username}") {
			return true;
		}else  {
			return i;
		}
		
	
}
</script>
</body>
</html>