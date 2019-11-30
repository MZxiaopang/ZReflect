<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
   <link rel="stylesheet" type="text/css" href="Css/MessagePage.css" charset="utf-8"/> 
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="Max_div">
    <div id="div1">
        <div id="div4">
            <h2>智游客户管理系统</h2>
        </div>
        <div id="div5">
            <ul class="ul1">
                <li class="li1" >
                    <a href="#">工作台</a>
                </li>
                <li class="li1">
                    <a href="#">报表</a>
                </li>
                <li class="li1">
                    <a href="#">客户信息</a>
                </li>
                <li class="li1">
                    <a href="#">员工信息</a>
                </li>
                <li class="li1">
                    <a href="#">公告信息</a>
                </li>
                <li class="li1">
                    <a href="#">发邮件</a>
                </li>
            </ul>
        </div>
        <div id="div6">
        	<c:if test="${!empty adminUser }">
        	<a href="#">用户名:${adminUser.username }</a>
        	<a href="${pageContext.request.contextPath }/login">退出</a>
        	</c:if>
        	<c:if test="${empty adminUser }">
            <a href="${pageContext.request.contextPath }/login">登录</a>
            </c:if>
        </div>
    </div>
    <div id="div2">
        <ul id="ul2">
            <li class="li2" >
                <a href="#">客户管理</a>
                <ul>
                    <li >
                        <a href="${pageContext.request.contextPath }/CustomerServlet?service=CustomerGuanLi" target="myFrameName">客户信息</a>
                    </li>
                    <li >
                        <a href="${pageContext.request.contextPath }/Customer_CareServlet?service=Customer_CareGuanLi" target="myFrameName">客户关怀</a>
                    </li>
                    <li >
                        <a href="${pageContext.request.contextPath }/Customer_CategoryServlet?service=Customer_CategoryGuanLi" target="myFrameName">客户分类</a>
                    </li>
                    <li >
                        <a href="${pageContext.request.contextPath }/Customer_LinkServlet?service=Customer_LinkGuanLi" target="myFrameName">客户联系人表</a>
                    </li>
                    <li >
                        <a href="${pageContext.request.contextPath }/Customer_Link_RecordServlet?service=Customer_Link_RecordGuanLi" target="myFrameName">客户联系登记表</a>
                    </li>
                    <li >
                        <a href="${pageContext.request.contextPath }/Customer_SourceServlet?service=Customer_SourceGuanLi" target="myFrameName">客户来源</a>
                    </li>
                    <li >
                        <a href="${pageContext.request.contextPath }/Customer_StateServlet?service=Customer_StateGuanLi" target="myFrameName">客户状态</a>
                    </li>
                </ul>
            </li>
            <li class="li2">
                <a href="#">内部信息</a>
                <ul>
                    <li >
                        <a href="${pageContext.request.contextPath }/NoticeServlet?service=GongGaoTongZhi" target="myFrameName">通知公告</a>
                    </li>
                    <li >
                        <a href="${pageContext.request.contextPath }/ManagerPageServlet?service=YuanGongXinXi" target="myFrameName">员工信息</a>
                    </li>
                    <li >
                        <a href="${pageContext.request.contextPath }/DepartmentServlet?service=DepartmentXinXi" target="myFrameName">部门信息</a>
                    </li>

                </ul>
            </li>
            <li class="li2">
                <a href="#">站内邮件</a>
                <ul>
                    <li >
                        <a href="${pageContext.request.contextPath }/MessageServlet?service=MessageWrite" target="myFrameName">写邮件</a>
                    </li>
                    <li >
                        <a href="${pageContext.request.contextPath }/MessageServlet?service=MessageCollection" target="myFrameName">收邮件</a>
                    </li>
                    <li >
                        <a href="${pageContext.request.contextPath }/MessageServlet?service=MessageSendBox" target="myFrameName">发邮件</a>
                    </li>
                    <li >
                        <a href="${pageContext.request.contextPath }/MessageServlet?service=MessageHoldBox" target="myFrameName">草稿箱</a>
                    </li>
                    <li >
                        <a href="${pageContext.request.contextPath }/MessageServlet?service=MessageBinBox" target="myFrameName">垃圾箱</a>
                    </li>
                </ul>
            </li>
            <c:if test="${Admin.equals('NotAdmin') }">
	            <li class="li2">
	                <a href="#">管理员</a>
	                <ul>
	                    <li >
	                        <a href="${pageContext.request.contextPath }/NoticeServlet?service=NoticeGuanLi" target="myFrameName">公告管理员</a>
	                    </li>
	                    <li >
	                        <a href="${pageContext.request.contextPath }/DepartmentServlet?service=DepartmentGuanLi" target="myFrameName">部门管理员</a>
	                    </li>
	                    <li >
	                        <a href="${pageContext.request.contextPath }/RoleManagePageServlet?service=RoleGuanLi" target="myFrameName">角色管理员</a>
	                    </li>
	                    <li >
	                        <a href="${pageContext.request.contextPath }/ManagerPageServlet?service=UserGuanLi" target="myFrameName">用户管理员</a>
	                    </li>
	                </ul>
	            </li>
            </c:if>
        </ul>
    </div>
    <div id="div3">
        <iframe id="if1" style="width: 100%;height: 900px;"name="myFrameName"  >
        	
        </iframe>
    </div>
</div>

</body>
</html>