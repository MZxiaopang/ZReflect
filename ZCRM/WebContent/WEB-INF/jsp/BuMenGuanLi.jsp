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
	          width: 1024px;
            height: 800px;
        }
        #div3{
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
            float: left;
            margin-left: 30px;
        }
       #button2{
       	float: right;
       	margin-top: 30px;
       }
    </style>
</head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<body>

<div id="div1">
 <button id="button2"  onclick="f()">添加部门</button>
<form action="DepartmentServlet?service=DepartmentGuanLiFind" method="post">
    <div id="div3">
        <h2>部门管理</h2>
        <div id="div3_1">
            搜索内容:<input class="input1" name="find" type="text">
        </div>
        <div id="div3_2">
            搜索字段:
            <select name="where">
                <option value="1">名称</option>
            </select>
            <input type="submit" value="搜索"> 
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
                    <td>操作</td>
                </tr>
                <c:if test="${!empty list}">
                <c:forEach begin="0" end="${list.size()-1 }" var="i">
                   	<tr>
                    	<td>${i+1 }</td>
                    	<td>${list[i].department_id }</td>
                    	<td>${list[i].department_name }</td>
                    	<td>${list[i].remark }</td>
                    	<td>${list[i].update_time }</td>
                    	<td>
                    	<a href="DepartmentUpdate?id=${list[i].department_id }&service=DepartmentUpdate">✎</a>
                    	<a href="DepartmentDelete?id=${list[i].department_id }&service=DepartmentDelete">X</a>
                    	</td>
                    </tr>
                </c:forEach>
				</c:if>
            </table>
        </div>
		<div style="float: left">
            
        </div>
        <c:if test="${count %5==0}">
		<c:set value="${count/5}" var="page"></c:set>
		</c:if>
		<c:if test="${count %5!=0}">
			<c:set value="${count/5+1}" var="page"></c:set>
		</c:if>
		
		<c:if test="${!empty nameshow }">
			<fmt:parseNumber var="page" value="${page}" integerOnly="true" />
			<h6>总共${count}条记录</h6>
		</c:if>
		<c:if test="${empty nameshow }">
			<fmt:parseNumber var="page" value="${page}" integerOnly="true" />
			<h6>总共${count}条记录,共${page}页</h6>
       		<div style="float: right;margin-top: 30px;">
        	<c:forEach var="i" begin="1" end="${page}">
				<a href="DepartmentServlet?page=${i}&service=DepartmentGuanLi">第${i}页</a>
			</c:forEach>	
       		</div>
       </c:if>
    </div>
    
     </form>
</div>

<script type="text/javascript">
function f(){
	location.href="${pageContext.request.contextPath }//DepartmentServlet?service=DepartmentAdd";

}

</script>
</body>
</html>