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
        <h2>站内邮件</h2>
        <div id="div3_1">
            搜索内容:<input class="input1" type="text">
        </div>
        <div id="div3_2">
            搜索字段:
            <select>
                <option value="用户名">用户名</option>
            </select>
            <button id="button1" value="搜索">搜索</button>
        </div>
    </div>
    <div id="div4">
        <div>
            <table class="table table-bordered">
                <tr>
                    <td>序号</td>
                    
                    <td>邮件ID</td>
                    <td>邮件主题</td>
                    <td>内容</td>
                    <td>发件人</td>
                    <td>发件人删除</td>
                    <td>发布状态</td>
                    <td>保存草稿时间</td>
                    <td>发送时间</td>
                    <td>发送方更新时间</td>
                    <td>接收人</td>
                    <td>收件人删除</td>
                    <td>收件状态</td>
                    <td>收件方更新时间</td>
                    <td>操作</td>
                </tr>
                <tr>
                <c:if test="${!empty list }">
	                <c:forEach  begin="0" end="${list.size()-1 }" var="i" >
						<tr>
							<td>${i+1 }</td>
		                    <td>${list[i].message_id }</td>
		                    <td>${list[i].subject }</td>
		                    <td>${list[i].content }</td>
		                    <td>${list[i].sender }</td>
		                    <td>${list[i].send_delete }</td>
		                    <td>${list[i].send_status }</td>
		                    <td>${list[i].save_time }</td>
		                    <td>${list[i].send_time }</td>
		                    <td>${list[i].send_update_time }</td>
		                    <td>${list[i].receiver }</td>
		                    <td>${list[i].receive_delete }</td>
		                    <td>${list[i].receive_status }</td>
		                    <td>${list[i].receive_update_time }</td>
							<td><a href="MessageUpdate?id=${list[i].message_id}&service=MessageUpdate">✎</a>
							<a href="MessageDelete?id=${list[i].message_id}&service=MessageDelete">X</a></td>
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
				<a href="MessageServlet?page=${i}&service=MessageGuanLi">第${i}页</a>
			</c:forEach>	
       </div>

    </div>
</div>

</body>
</html>