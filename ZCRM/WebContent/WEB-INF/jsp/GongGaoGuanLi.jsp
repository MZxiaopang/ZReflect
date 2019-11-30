<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
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
<button id="button2" value="添加" onclick="f()">添加公告</button>
<form action="NoticeServlet?service=NoticeGuanLiFind" method="post">
    <div id="div3">
        <h2>公告管理</h2>
        <div id="div3_1">
            搜索内容:<input class="input1" name="find" type="text">
        </div>
        <div id="div3_2">
            搜索字段:
            <select name="where">
                <option value="1">主题名</option>
            </select>
            <input type="submit" value="搜索"> 
        </div>
    </div>
    <div id="div4">
        <div>
            <table class="table table-bordered">
                <tr>
                    <td>序号</td>
                    <td>公告信息ID</td>
                    <td>接收部门ID</td>
                    <td>公告主题</td>
                    <td>公告内容</td>
                    <td>发布时间</td>
                    <td>过期时间</td>
                    <td>公告状态</td>
                    <td>备注</td>
                    <td>添加时间</td>
                    <td>添加人</td>
                    <td>修改时间</td>
                    <td>修改人</td>
                    <td>操作</td>
                </tr>
                <tr>
                <c:if test="${!empty list }">
	                <c:forEach  begin="0" end="${list.size()-1 }" var="i" >
						<tr>
							<td>${i+1}</td>
							<td>${list[i].notice_id}</td>
							<td>${list[i].receive_id}</td>
							<td>${list[i].subject}</td>
							<td>${list[i].text}</td>
							<td>${list[i].pub_time}</td>
							<td>${list[i].expire_time}</td>
							<td>${list[i].status}</td>
							<td>${list[i].remark}</td>
							<td>${list[i].create_time}</td>
							<td>${list[i].creater}</td>
							<td>${list[i].update_time}</td>
							<td>${list[i].updater}</td>
							<td><a href="NoticeUpdate?id=${list[i].notice_id}&service=NoticeUpdate">✎</a>
							<a href="NoticeDelete?id=${list[i].notice_id}&service=NoticeDelete">X</a></td>
						</tr>
					</c:forEach>
					</c:if>
                </tr>
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
				<a href="NoticeServlet?page=${i}&service=NoticeGuanLi">第${i}页</a>
			</c:forEach>	
       		</div>
       </c:if>
    </div>
    </form>
</div>
<script>
    function f() {
    	location.href="${pageContext.request.contextPath }/NoticeAdd?service=NoticeAdd";
    }
  
</script>
</body>
</html>