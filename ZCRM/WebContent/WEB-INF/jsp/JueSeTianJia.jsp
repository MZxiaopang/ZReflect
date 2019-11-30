<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
 
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="jQuery/jquery.js"></script>
	<script src="jQuery/jquery.validate.min.js"></script>
	<script src="jQuery/messages_zh.js"></script>
	<script type="text/javascript">
		$().ready(function() {
			$("#form1").validate({
				rules:{
					jueSeMingCheng:{
						required:true,
						minlength:3,
						maxlength:12
					},
					jueSeMiaoShu:{
						required:true,
						minlength:1,
						maxlength:100
					}
				},
				messages:{
					jueSeMingCheng:{
						required:"请输入角色名称",
						minlength:"最少输入3个字",
						maxlength:"最大输入12个字"
					},
					jueSeMiaoShu:{
						required:"请输入角色描述",
						minlength:"最少输入1个字",
						maxlength:"最大输入12个字"
					}

				}
				
			});
		})
	
	</script>
    <style type="text/css">
       .error{
       		color: red;
       }
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
            margin-top: 200px;
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
<form action="RoleAlter" method="post" id="form1" onsubmit="return on()">
<div id="div1">
    <div id="div3">

        <div id="div3_1">
            <h2>添加角色</h2>
        </div>
    </div>
    <div id="div4">
        <div>
            <table class="table table-bordered" >
                <tr >
                    <td >
                    	<h4>角色名称</h4><input type="hidden" name="id" value="${role.role_id }">
                    	<input type="hidden" name="creater" value="${role.creater }">
                    	<input type="hidden" name="create_time" value="${role.create_time }">
                    </td>
                    <td ><input class="input1" type="text" id="role" name="jueSeMingCheng" value="${role.role_name }" onblur="oon()"><i></i></td>
                </tr>
                <tr >
                    <td ><h4>角色描述</h4></td>
                    <td>
                        <textarea name="jueSeMiaoShu" style="width:600px ;height:400px;" cols="">${role.remark }</textarea>
                    </td>
                </tr>
            </table>
        </div>
     

    </div>
    <div id="div5">
        <div id="div6" style="margin-left: 400px;margin-top:20px; ">
        	<input type="hidden" name="service" value="RoleAlter">
            <input type="submit" value="保存" style="width: 80px;height: 40px;font-size: 20px;">
            &nbsp;&nbsp;&nbsp;
            <input type="button" value="返回" onclick="f1()" style="width: 80px;height: 40px;font-size: 20px;">
        </div>
    </div>
</div>
</form>
<script type="text/javascript">
   
    function f1() {
    	location.href="${pageContext.request.contextPath }//RoleManagePageServlet?service=RoleGuanLi";
    }
	var i=false;
    function oon() {
    	$.ajax({
    		url:"RoleManagePageServlet?service=selectRole_Name",
    		data:{
    			name1:$("#role").val()
    		},
    		success:function(data){
    			if (data=="true") {
    				$("i").text("");
    				i=true;
    			}else {
    				$("i").text("角色已存在！");
    				if ($("#role").val()=="${role.role_name}") {
    					$("i").text("");
    					i=true;
    				}else {
    					i=false;
					}
    				
    			}
    		}		
    	})	
    }
   function on() {
	   if ($("#role").val()=="${role.role_name}") {
			return true;
		}else {
			   return i;
		}	
	
   }
</script>
</body>
</html>