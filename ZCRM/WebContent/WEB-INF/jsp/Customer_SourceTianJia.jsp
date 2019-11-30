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
<form action="Customer_SourceAlter" method="post">
<div id="div1">
    <h2>客户来源表</h2>
    <div id="div2">
        <table class="table1">
            <tr class="tr1">
                <td class="td1">
                    <h4>客户来源</h4>
                </td>
                <td class="td2">
               		<input type="hidden" name="customer_source_id" value="${Customer_Source.customer_source_id }">
                    <input class="input1" type="text" name="customer_source_name" value="${Customer_Source.customer_source_name }">
                </td>
                <td class="td3">
                    <h4>来源说明</h4>
                </td>
                <td class="td4">
                    <input class="input1"  type="text" name="customer_source_desc" value="${Customer_Source.customer_source_desc }">
                </td>
            </tr>
            <tr class="tr1">
                <td class="td1">
                    <h4>状态</h4>
                </td>
                <td class="td2">
                  <input class="input1"  type="text" name="status" value="${Customer_Source.status }">
                </td>
	       
                <td class="td3">
                    <h4>备注</h4>
                </td>
                <td class="td4">
                   <input class="input1"  type="text" name="remark" value="${Customer_Source.remark }">
                </td>
           
            </tr>
            
            <tr class="tr1">
               	<td class="td1">
                    <h4>添加时间</h4>
                </td>
                <td class="td2">
                    <input class="input1"  type="date" name="create_time" value="${Customer_Source.create_time }">
                </td>
                <td class="td3">
                    <h4>添加人</h4>
                </td>
                <td class="td4">
                    <input class="input1"  type="text" name="creater" value="${Customer_Source.creater }">
                </td>
            </tr>
            <tr class="tr1">
               	<td class="td1">
                    <h4>修改时间</h4>
                </td>
                <td class="td2">
                    <input class="input1"  type="date" name="update_time" value="${Customer_Source.update_time }">
                </td>
                <td class="td3">
                    <h4>修改人</h4>
                </td>
                <td class="td4">
                    <input class="input1"  type="text" name="updater" value="${Customer_Source.updater }">
                </td>
            </tr>
        </table>
    </div>
    <div id="div3">
        <div id="div4" style="margin-left: 300px;margin-top:20px; ">
        	<input type="hidden" value="Customer_SourceAlter" name="service">
            <input type="submit" value="保存" style="width: 80px;height: 40px;font-size: 20px;">
            &nbsp;&nbsp;&nbsp;
            <input type="button" value="返回" onclick="f()" style="width: 80px;height: 40px;font-size: 20px;">
        </div>
    </div>
</div>
</form>
<script>
function f() {
	location.href="${pageContext.request.contextPath }//Customer_SourceServlet?service=Customer_SourceGuanLi";
}

</script>
</body>
</html>