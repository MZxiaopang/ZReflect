<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style type="text/css">

        #div1{
            margin-top: 100px;
            width: 1024px;
            height: 800px;
        }
        #div3{
            margin-top: 100px;
            width: 1024px;
            height: 100px;
        }
        #div4{
            width: 1024px;
            height: 300px;
        }
        .input1{
            width: 200px;
            height: 30px;
        }
        select{
            width: 80px;
            height: 30px;
        }
        #div3_1{
            float: left;
        }
        #div3_2{
            float: right;
            margin-top: 60px;
        }
        #button1{
            width: 50px;
            height: 30px;
            margin-left: 30px;
        }
        #button2{
            width: 100px;
            height: 30px;
            margin-left: 300px;
        }
    </style>
</head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<body>

<div id="div1">
    <div id="div3">

        <div id="div3_1">
            <h2>部门信息</h2>
        </div>
        
    </div>
    <div id="div4">
        <div>
            <table class="table table-bordered">
                <tr>
                    <td>序号</td>
                    <td>部门ID</td>
                    <td>部门名称</td>
                    <td>部门描述</td>
                    <td>更新时间</td>
                    
                </tr>
                <c:if test="${!empty list }">
                   	<tr>
                    	<td>${i+1 }</td>
                    	<td>${list.department_id }</td>
                    	<td>${list.department_name }</td>
                    	<td>${list.remark }</td>
                    	<td>${list.update_time }</td>
                    </tr>
                </c:if>
            </table>
        </div>

    </div>
</div>


</body>
</html>