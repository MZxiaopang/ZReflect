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
            float: left;
            margin-left: 30px;
        }
        #button1{
            width: 50px;
            height: 30px;
            margin-left: 30px;
        }
        #button2{
            width: 200px;
            height: 30px;
            margin-left: 300px;
        }
    </style>
</head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<body>
<div id="div1">
    <div id="div3">
        <h2>联系人登记信息</h2>
        <div id="div3_1">
            搜索内容:<input class="input1" type="text">
        </div>
        <div id="div3_2">
            搜索字段:
            <select>
                <option value="用户名">用户名</option>
            </select>
            <button id="button1" value="搜索">搜索</button>
            <button id="button2" value="搜索" onclick="f()">添加联系人登记信息</button>
        </div>
    </div>
    <div id="div4">
        <div>
            <table class="table table-bordered">
                <tr>
                    <td>序号</td>
                    <td>记录ID</td>
                    <td>客户ID</td>
                    <td>联系类型</td>
                    <td>联系主题</td>
                    <td>下次联系时间</td>
                    <td>状态</td>
                    <td>备注</td>
                    <td>下次关怀时间</td>
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
							<td>${list[i].record_id}</td>
							<td>${list[i].customer_id}</td>
							<td>${list[i].link_type}</td>
							<td>${list[i].link_subject}</td>
							<td>${list[i].link_nexttime}</td>
							<td>${list[i].status}</td>
							<td>${list[i].remark}</td>
							<td>${list[i].next_time}</td>
							<td>${list[i].create_time}</td>
							<td>${list[i].creater}</td>
							<td>${list[i].update_time}</td>
							<td>${list[i].updater}</td>
							<td><a href="Customer_Link_RecordUpdate?id=${list[i].record_id}&service=Customer_Link_RecordUpdate">✎</a>
							<a href="Customer_Link_RecordDelete?id=${list[i].record_id}&service=Customer_Link_RecordDelete">X</a></td>
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
		<fmt:parseNumber var="page" value="${page}" integerOnly="true" />
		<h6>总共${count}条记录,共${page}页</h6>
       <div style="float: right;margin-top: 30px;">
        	<c:forEach var="i" begin="1" end="${page}">
				<a href="Customer_Link_RecordServlet?page=${i}&service=Customer_Link_RecordGuanLi">第${i}页</a>
			</c:forEach>	
       </div>

    </div>
</div>
<script>
    function f() {
    	location.href="${pageContext.request.contextPath }/Customer_Link_RecordAdd?service=Customer_Link_RecordAdd";
    }
  
</script>
</body>
</html>