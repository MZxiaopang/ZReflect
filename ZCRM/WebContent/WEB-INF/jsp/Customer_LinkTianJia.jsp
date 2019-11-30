<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
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
<form action="Customer_LinkAlter" method="post">
<div id="div1">
    <h2>新增联系人</h2>
    <div id="div2">
        <table class="table1">
            <tr class="tr1">
                <td class="td1">
                    <h4>客户ID</h4>
                </td>
                <td class="td2">
               		<input type="hidden" name="link_id" value="${customer.link_id }">
                    <input class="input1" type="text" name="customer_id" value="${customer.customer_id }">
                </td>
                <td class="td3">
                    <h4>联系人姓名</h4>
                </td>
                <td class="td4">
                    <input class="input1"  type="text" name="link_name" value="${customer.link_name }">
                </td>
            </tr>
            <tr class="tr1">
                <td class="td1">
                    <h4>性别</h4>
                </td>
                <td class="td2">
                    <input type="radio" checked="checked" name="link_is_male" value="true">男
                    <input type="radio"  name="link_is_male" value="false">女
                </td>
	       
                <td class="td3">
                    <h4>职位</h4>
                </td>
                <td class="td4">
                   <input class="input1"  type="text" name="link_position" value="${customer.link_position }">
                </td>
           
            </tr>
            <tr class="tr1">
           		<td class="td3">
                    <h4>联系电话</h4>
                </td>
                <td class="td4">
                    <input class="input1"  type="text" name="link_mobile" value="${customer.link_mobile }">
                </td>
            
                <td class="td1">
                    <h4>年龄</h4>
                </td>
                <td class="td2">
                    <input class="input1"  type="text" name="link_age" value="${customer.link_age }">
                </td>
            </tr>
            <tr class="tr1">
                <td class="td1">
                    <h4>与客户关系</h4>
                </td>
                <td class="td2">
                	<select name="link_relation">
                		<option value="1">亲属</option>
                		<option value="2">朋友</option>
                		<option value="3">同事</option>
                		<option value="4">上司</option>
                	</select>
                </td>
                <td class="td3">
                    <h4>状态</h4>
                </td>
                <td class="td4">
                    <input class="input1"  type="text" name="status" value="${customer.status }">
                </td>
            </tr>
            <tr class="tr1">
                <td class="td1">
                    <h4>备注</h4>
                </td>
                <td class="td2">
                    <input class="input1"  type="text" name="remark" value="${customer.remark }">
                </td>
                <td class="td3">
                    <h4>下次关怀时间</h4>
                </td>
                <td class="td4">
                    <input class="input2"  type="date" name="next_time" value="${customer.next_time }">
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
        	<input type="hidden" value="Customer_LinkAlter" name="service">
            <input type="submit" value="保存" style="width: 80px;height: 40px;font-size: 20px;">
            &nbsp;&nbsp;&nbsp;
            <input type="button" value="返回" onclick="f()" style="width: 80px;height: 40px;font-size: 20px;">
        </div>
    </div>
</div>
</form>
<script>
function f() {
	location.href="${pageContext.request.contextPath }//Customer_LinkServlet?service=Customer_LinkGuanLi";
}

</script>
</body>
</html>