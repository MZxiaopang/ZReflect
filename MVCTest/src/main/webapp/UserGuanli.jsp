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
 <button id="button2"  onclick="f()">添加用户</button>
<form action="ManagerPageServlet?service=UserGuanLiFind" method="post" >
    <div id="div3">
        <h2>用户列表</h2>
        <div id="div3_1">
            搜索内容:<input class="input1" name="find" type="text">
        </div>
        <div id="div3_2">
            搜索字段:
            <select name="where">
                <option value="1">姓名</option>
            </select>
            <input type="submit" value="搜索"> 
        </div>
    </div>
    
    <div id="div4">
        <div>
            <table class="table table-bordered">
                <tr>
                    <td>序号</td>
                    <td>员工ID</td>
                    <td>部门</td>
                    <td>角色</td>
                    <td>姓名</td>
                    <td>性别</td>
                    <td>手机</td>
                    <td>年龄</td>
                    <td>地址</td>
                    <td>是否管理员</td>
                    <td>是否为系统内置</td>
                    <td>密码</td>
                    <td>座机</td>
                    <td>身份证</td>
                    <td>E_mail</td>
                    <td>爱好</td>
                    <td>学历</td>
                    <td>工资卡号</td>
                    <td>民族</td>
                    <td>婚姻状况</td>
                    <td>用户状态</td>
                    <td>操作备注</td>
                    <td>添加时间</td>
                    <td>添加人</td>
                    <td>修改时间</td>
                    <td>修改人</td>
                    <td>操作</td>
                </tr>
                <tr>
                <c:if test="${!empty list}">
	                <c:forEach  begin="0" end="${list.size()-1 }" var="i" >
						<tr>
							<td>${i+1}</td>
							<td>${list[i].user_id}</td>
							<c:if test="${list[i].department_id==8 }" >
								<c:set var="department" value="部门1"></c:set>
							</c:if>
							<c:if test="${list[i].department_id==9 }" >
								<c:set var="department" value="部门2"></c:set>
							</c:if>
							<c:if test="${list[i].department_id==10 }" >
								<c:set var="department" value="部门3"></c:set>
							</c:if>
							<c:if test="${list[i].department_id==11 }" >
								<c:set var="department" value="部门4"></c:set>
							</c:if>
							<c:if test="${list[i].department_id==12 }" >
								<c:set var="department" value="部门5"></c:set>
							</c:if>
							<c:if test="${list[i].department_id==13 }" >
								<c:set var="department" value="部门6"></c:set>
							</c:if>
							<td>${department}</td>
							<c:if test="${list[i].role_id==1 }" >
								<c:set var="role" value="教学主任"></c:set>
							</c:if>
							<td>${role}</td>
							<td>${list[i].username}</td>
							<c:if test="${list[i].is_male==true }" >
								<c:set var="sex" value="男"></c:set>
							</c:if>
							<c:if test="${list[i].is_male==false }" >
								<c:set var="sex" value="女"></c:set>
							</c:if>
							<td>${sex}</td>
							<td>${list[i].mobile}</td>
							<td>${list[i].age}</td>
							<td>${list[i].address}</td>
							<td>${list[i].is_admin}</td>
							<td>${list[i].is_system}</td>
							<td>${list[i].password}</td>
							<td>${list[i].tel}</td>
							<td>${list[i].id_num}</td>
							<td>${list[i].email}</td>
							<td>${list[i].hobby}</td>
							<c:if test="${list[i].education==0 }" >
								<c:set var="EDU" value="默认"></c:set>
							</c:if>
							<c:if test="${list[i].education==1 }" >
								<c:set var="EDU" value="小学"></c:set>
							</c:if>
							<c:if test="${list[i].education==2 }" >
								<c:set var="EDU" value="初中"></c:set>
							</c:if>
							<c:if test="${list[i].education==3 }" >
								<c:set var="EDU" value="高中"></c:set>
							</c:if>
							<c:if test="${list[i].education==4 }" >
								<c:set var="EDU" value="专科"></c:set>
							</c:if>
							<c:if test="${list[i].education==5 }" >
								<c:set var="EDU" value="本科"></c:set>
							</c:if>
							<c:if test="${list[i].education==6 }" >
								<c:set var="EDU" value="硕士"></c:set>
							</c:if>
							<c:if test="${list[i].education==7 }" >
								<c:set var="EDU" value="博士"></c:set>
							</c:if>
							<td>${EDU}</td>
							<td>${list[i].card_num}</td>
							<td>${list[i].nation}</td>
							<c:if test="${list[i].marry==1 }" >
								<c:set var="Marry" value="已婚"></c:set>
							</c:if>
							<c:if test="${list[i].marry==-1 }" >
								<c:set var="Marry" value="离异"></c:set>
							</c:if>
							<c:if test="${list[i].marry==0 }" >
								<c:set var="Marry" value="未婚"></c:set>
							</c:if>
							<td>${Marry}</td>
							<c:if test="${list[i].status==1 }" >
								<c:set var="Status" value="已创建"></c:set>
							</c:if>
							<c:if test="${list[i].status==2 }" >
								<c:set var="Status" value="正常"></c:set>
							</c:if>
							<c:if test="${list[i].status==-1 }" >
								<c:set var="Status" value="已禁用"></c:set>
							</c:if>
							<c:if test="${list[i].status==-2 }" >
								<c:set var="Status" value="已删除"></c:set>
							</c:if>
							<td>${Status}</td>
							<td>${list[i].remark}</td>
							<td>${list[i].create_time}</td>
							<td>${list[i].creater}</td>
							<td>${list[i].update_time}</td>
							<td>${list[i].updater}</td>
							<td><a href="update?id=${list[i].user_id}&service=Userupdate">✎</a>
							<a href="delete?id=${list[i].user_id}&service=Userdelete">X</a></td>
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
				<a href="ManagerPageServlet?page=${i}&service=UserGuanLi">第${i}页</a>
			</c:forEach>	
       		</div>
       </c:if>
		
    </div>

    </form>
</div>

    <script>
    function f() {
    	location.href="${pageContext.request.contextPath }/add?service=Useradd";
    }
	</script>

</body>
</html>