<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script type="text/javascript" src="jQuery/jquery.js"></script>
    <style type="text/css">
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
</head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<body>
<form action="CustomerAlter" method="post" onsubmit="return on()">
<div id="div1">
    <h2>新增顾客</h2>
    <div id="div2">
        <table class="table1">
            <tr class="tr1">
                <td class="td1">
                    <h4>客户状态ID</h4>
                </td>
                <td class="td2">
               		<input type="hidden" name="customer_id" value="${customer.customer_id }">
                    <input class="input1" type="text" name="customer_state_id" value="${customer.customer_state_id }">
                </td>
                <td class="td3">
                    <h4>客户来源ID</h4>
                </td>
                <td class="td4">
                    <input class="input1"  type="text" name="customer_source_id" value="${customer.customer_source_id }">
                </td>
            </tr>
            <tr class="tr1">
                <td class="td1">
                    <h4>责任员工ID</h4>
                </td>
                <td class="td2">
                  <input class="input1"  type="text" name="user_id" value="${customer.user_id }" >
                </td>
	       
                <td class="td3">
                    <h4>客户类型ID</h4>
                </td>
                <td class="td4">
                   <input class="input1"  type="text" name="customer_category_id" value="${customer.customer_category_id }">
                </td>
           
            </tr>
            <tr class="tr1">
           		<td class="td3">
                    <h4>客户姓名</h4>
                </td>
                <td class="td4">
                    <input class="input1"  type="text" name="customer_name" value="${customer.customer_name }">
                </td>
            
                <td class="td1">
                    <h4>客户性别</h4>
                </td>
                <td class="td2">
                    <input type="radio" checked="checked" name="sex" value="true">男
                    <input type="radio"  name="sex" value="false">女
                </td>
            </tr>
            <tr class="tr1">
                <td class="td1">
                    <h4>客户手机</h4>
                </td>
                <td class="td2">
                    <input class="input2" type="text" id="sj1" name="customer_mobile" value="${customer.customer_mobile }" onblur="oon()"><i></i>
                </td>
                <td class="td3">
                    <h4>客户QQ</h4>
                </td>
                <td class="td4">
                    <input class="input1"  type="text" name="customer_qq" value="${customer.customer_qq }">
                </td>
            </tr>
            <tr class="tr1">
                <td class="td1">
                    <h4>客户地址</h4>
                </td>
                <td class="td2">
                    <input class="input1"  type="text" name="customer_address" value="${customer.customer_address }">
                </td>
                <td class="td3">
                    <h4>客户邮箱</h4>
                </td>
                <td class="td4">
                    <input class="input2"  type="text" name="customer_email" value="${customer.customer_email }">
                </td>
            </tr>
            <tr class="tr1">
                <td class="td1">
                    <h4>客户备注</h4>
                </td>
                <td class="td2">
                    <input class="input2" type="text" name="customer_remark" value="${customer.customer_remark }">
                </td>
                <td class="td3">
                    <h4>客户职位</h4>
                </td>
                <td class="td4">
                    <input class="input1"  type="text" name="customer_position" value="${customer.customer_position }">
                </td>
            </tr>
            <tr class="tr1">
                <td class="td1">
                    <h4>客户微博</h4>
                </td>
                <td class="td2">
                    <input class="input1"  type="text" name="customer_blog" value="${customer.customer_blog }">
                </td>
                <td class="td3">
                    <h4>客户座机</h4>
                </td>
                <td class="td4">
                    <input class="input1"  type="text" name="customer_tel" value="${customer.customer_tel }">
                </td>
            </tr>
            <tr class="tr1">
                <td class="td1">
                    <h4>出生日期</h4>
                </td>
                <td class="td2">
                    <input class="input1"  type="date" name="customer_birth" value="${customer.customer_birth }">
                </td>
                <td class="td3">
                    <h4>客户公司</h4>
                </td>
                <td class="td4">
                    <input class="input1"  type="text" name="customer_company" value="${customer.customer_company }">
                </td>
            </tr>
            <tr class="tr1">
                <td class="td1">
                    <h4>客户公司状态</h4>
                </td>
                <td class="td2">
                    <select name="status">
                        <option value="-2">已删除</option>
                        <option value="2">正常</option>
                    </select>
                </td>
         		<td class="td1">
                    <h4>备注</h4>
                </td>
                <td class="td2">
                    <input class="input1"  type="text" name="remark" value="${customer.remark }">
                </td>
            </tr>
            <tr class="tr1">
               	<td class="td1">
                    <h4>添加时间</h4>
                </td>
                <td class="td2">
                    <input class="input1"  type="date" name="create_time" value="${customer.create_time }">
                </td>
                <td class="td3">
                    <h4>添加人</h4>
                </td>
                <td class="td4">
                    <input class="input1"  type="text" name="creater" value="${customer.creater }">
                </td>
            </tr>
            <tr class="tr1">
               	<td class="td1">
                    <h4>修改时间</h4>
                </td>
                <td class="td2">
                    <input class="input1"  type="date" name="update_time" value="${customer.update_time }">
                </td>
                <td class="td3">
                    <h4>修改人</h4>
                </td>
                <td class="td4">
                    <input class="input1"  type="text" name="updater" value="${customer.updater }">
                </td>
            </tr>
        </table>
    </div>
    <div id="div3">
        <div id="div4" style="margin-left: 300px;margin-top:20px; ">
        	<input type="hidden" value="CustomerAlter" name="service">
            <input type="submit" value="保存" style="width: 80px;height: 40px;font-size: 20px;">
            &nbsp;&nbsp;&nbsp;
            <input type="button" value="返回" onclick="f()" style="width: 80px;height: 40px;font-size: 20px;">
        </div>
    </div>
</div>
</form>
<script>
function f() {
	location.href="${pageContext.request.contextPath }//CustomerServlet?service=CustomerGuanLi";
}

var i=false;
function oon() {
	$.ajax({
		url:"CustomerServlet?service=selectPhone",
		data:{
			Phone1:$("#sj1").val()
		},
		success:function(data){
			if (data=="true") {
				$("i").text("");
				i=true;
			}else  {
				$("i").text("手机号已存在，不能重复");
				i=false;
			}
			
		}
		
		
	});
}
function on() {
	return i;
}

</script>
</body>
</html>