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
        }
        #div3{
            width: 1024px;
            height: 100px;
        }
        #div4{
            width: 1024px;
            height: 300px;
        }
        #div5{
        margin-top: 0px;
        width: 1024px;
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
        <h2>垃圾箱</h2>
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
							<td>
								<a href="MessageDelete?id=${list[i].message_id}&service=MessageSe_BinDelete">X</a>
							</td>
						</tr>
					</c:forEach>
					</c:if>
                </tr>
                <tr>
                  <c:if test="${!empty list1 }">
	                <c:forEach  begin="0" end="${list1.size()-1 }" var="i" >
						<tr>
							<td>${list.size()+i+1 }</td>
		                    <td>${list1[i].message_id }</td>
		                    <td>${list1[i].subject }</td>
		                    <td>${list1[i].content }</td>
		                    <td>${list1[i].sender }</td>
		                    <td>${list1[i].send_delete }</td>
		                    <td>${list1[i].send_status }</td>
		                    <td>${list1[i].save_time }</td>
		                    <td>${list1[i].send_time }</td>
		                    <td>${list1[i].send_update_time }</td>
		                    <td>${list1[i].receiver }</td>
		                    <td>${list1[i].receive_delete }</td>
		                    <td>${list1[i].receive_status }</td>
		                    <td>${list1[i].receive_update_time }</td>
							<td>
								<a href="MessageDelete?id=${list1[i].message_id}&service=MessageRe_BinDelete">X</a>
							</td>
						</tr>
					</c:forEach>
					</c:if>
                </tr>
            </table>
        </div>
		<h6>总共${count}条记录</h6>
    </div>
</div>
</body>
</html>