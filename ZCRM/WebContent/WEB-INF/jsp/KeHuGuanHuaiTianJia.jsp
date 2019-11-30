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
<form action="Customer_CareAlter" method="post">
<div id="div1">
    <h2>顾客关怀</h2>
    <div id="div2">
        <table class="table1">
            <tr class="tr1">
                <td class="td1">
                    <h4>客户ID</h4>
                </td>
                <td class="td2">
               		<input type="hidden" name="customer_care_id" value="${customer_Care_id.customer_care_id }">
                    <input class="input1" type="text" name="customer_id" value="${customer_Care_id.customer_id }">
                </td>
                <td class="td3">
                    <h4>关怀主题</h4>
                </td>
                <td class="td4">
                    <input class="input1"  type="text" name="care_subject" value="${customer_Care_id.care_subject }">
                </td>
            </tr>
            <tr class="tr1">
                <td class="td1">
                    <h4>关怀方式</h4>
                </td>
                <td class="td2">
                  <input class="input1"  type="text" name="care_type" value="${customer_Care_id.care_type }">
                </td>
	       
                <td class="td3">
                    <h4>关怀状态</h4>
                </td>
                <td class="td4">
                   <input class="input1"  type="text" name="status" value="${customer_Care_id.status }">
                </td>
           
            </tr>
            <tr class="tr1">
           		<td class="td3">
                    <h4>关怀备注</h4>
                </td>
                <td class="td4">
                    <input class="input1"  type="text" name="remark" value="${customer_Care_id.remark }">
                </td>
            
                <td class="td1">
                    <h4>下次关怀时间</h4>
                </td>
                <td class="td2">
                   <input class="input1"  type="date" name="next_time" value="${customer_Care_id.next_time }">
                </td>
            </tr>
            
            <tr class="tr1">
               	<td class="td1">
                    <h4>添加时间</h4>
                </td>
                <td class="td2">
                    <input class="input1"  type="date" name="create_time" value="${customer_Care_id.create_time }">
                </td>
                <td class="td3">
                    <h4>添加人</h4>
                </td>
                <td class="td4">
                    <input class="input1"  type="text" name="creater" value="${customer_Care_id.creater }">
                </td>
            </tr>
            <tr class="tr1">
               	<td class="td1">
                    <h4>修改时间</h4>
                </td>
                <td class="td2">
                    <input class="input1"  type="date" name="update_time" value="${customer_Care_id.update_time }">
                </td>
                <td class="td3">
                    <h4>修改人</h4>
                </td>
                <td class="td4">
                    <input class="input1"  type="text" name="updater" value="${customer_Care_id.updater }">
                </td>
            </tr>
        </table>
    </div>
    <div id="div3">
        <div id="div4" style="margin-left: 300px;margin-top:20px; ">
        	<input type="hidden" value="Customer_CareAlter" name="service">
            <input type="submit" value="保存" style="width: 80px;height: 40px;font-size: 20px;">
            &nbsp;&nbsp;&nbsp;
            <input type="button" value="返回" onclick="f()" style="width: 80px;height: 40px;font-size: 20px;">
        </div>
    </div>
</div>
</form>
<script>
function f() {
	location.href="${pageContext.request.contextPath }//Customer_CareServlet?service=Customer_CareGuanLi";
}

</script>
</body>
</html>