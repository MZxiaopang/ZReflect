<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script type="text/javascript" src="jQuery/jquery.js"></script>
    <script type="text/javascript" src="jQuery/jquery.validate.min.js"></script>
    <script type="text/javascript" src="jQuery/messages_zh.js"></script>
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
        #div5{
            margin-top: 250px;
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
        .error{
       		color: red;
        	
        }
    </style>
    <script type="text/javascript">
    	$().ready(function () {
			$("#form1").validate({
				rules:{
					expire_time:{
						required:true,
						dateISO:true
					},
					subject:{
						required:true,
						minlength:1,
						maxlength:20
					},
					text:{
						required:true,
						minlength:1,
						maxlength:100
					}
				},
				messages:{
					
					expire_time:{
						required:"请输入时间",
						dateISO:"请输入正确格式 例如:2019-11-11"
					},
					subject:{
						required:"请输入主题名字",
						minlength:"主题名字最少是1个字",
						maxlength:"主题名字最多是20个字"
					},
					text:{
						required:"请输入内容",
						minlength:"内容最少是1个字",
						maxlength:"内容最少是100个字"
					}
					
				}
				
			})
		})
    
    </script>
    
</head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<body>
<form action="NoticeAlter" method="post" id="form1">
<div id="div1">
    <div id="div3">

        <div id="div3_1">
            <h2>发布公告</h2>
        </div>
    </div>
    <div id="div4">
        <div>
            <table class="table table-bordered" >
                <tr >
                    
                    
                    <td >截止时间<input type="hidden" name="id" value="${notice.notice_id }">
                    	<input type="hidden" name="creater" value="${notice.creater }">
                    	<input type="hidden" name="create_time" value="${notice.create_time }">
                    	<input type="hidden" name="pub_time" value="${notice.pub_time }">
                    </td>
                    <td colspan="3"><input class="input1" type="date" name="expire_time" value="${notice.expire_time }"></td>
                </tr>
                <tr >
                    <td >主题</td>
	                <td>  
	                    <input type="text" name="subject" value="${notice.subject }">
                    </td>
                    <td >通知范围</td>
                    <td>
						<select name="tongzhifanwei">
							<c:forEach var="i" begin="0" end="${list.size()-1 }">
	                        	<option value="${list[i].department_id }">${list[i].department_name }</option>
	                        </c:forEach>
	                    </select>
                    </td>
                </tr>
                <tr >
                    <td style="padding-top: 200px">内容</td>
                    <td colspan="3">
                    	<textarea style="width:600px ;height:400px;" name="text" >${notice.text }</textarea>
                        
                    </td>
                </tr>
            </table>
        </div>
     

    </div>
    <div id="div5">
        <div id="div6" style="margin-left: 400px;margin-top:20px; ">
        	<input type="hidden" name="service" value="NoticeAlter">
            <input type="submit" value="保存" style="width: 80px;height: 40px;font-size: 20px;">
            &nbsp;&nbsp;&nbsp;
            <input type="button" value="返回" onclick="f1()" style="width: 80px;height: 40px;font-size: 20px;">
        </div>
    </div>
</div>
</form>
<script>
   
    function f1() {
    	location.href="${pageContext.request.contextPath }//NoticeServlet?service=NoticeGuanLi";
    }
</script>
</body>
</html>