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
        .error{
        	color: red;
        }
    </style>
    <script type="text/javascript">
		$().ready(function() {
			$("#form1").validate({
				rules:{
					department_name:{
						required:true,
						minlength:3,
						maxlength:12
					},
					remark:{
						required:true,
						minlength:1,
						maxlength:100
					}
				},
				messages:{
					department_name:{
						required:"请输入部门名称",
						minlength:"最少输入3个字",
						maxlength:"最大输入12个字"
					},
					remark:{
						required:"请输入部门描述",
						minlength:"最少输入1个字",
						maxlength:"最大输入12个字"
					}

				}
				
			});
		})
	
	</script>
</head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<body>
<form action="DepartmentAlter" method="post" onsubmit="return on()" id="form1">
<div id="div1">
    <div id="div3">

        <div id="div3_1">
            <h2>添加部门管理</h2>
        </div>
    </div>
    <div id="div4">
        <div>
            <table class="table table-bordered" >
                <tr >
                    <td ><h4>管理名称</h4><input type="hidden" name="id" value="${department.department_id }">
                    <input type="hidden" name="create_time" value="${department.create_time }">
                    <input type="hidden" name="creater" value="${department.creater }">
                    </td>
                    <td ><input class="input1" type="text"  id="department" name="department_name" value="${department.department_name }" onblur="oon()"><i></i></td>
                </tr>
                <tr >
                    <td ><h4>管理描述</h4></td>
                    <td>
                    <textarea style="width:600px ;height:400px;" name="remark" >${department.remark }</textarea>
                    </td>
                </tr>
            </table>
        </div>
     

    </div>
    <div id="div5">
        <div id="div6" style="margin-left: 400px;margin-top:20px; ">
        	<input type="hidden" name="service" value="DepartmentAlter">
            <input type="submit" value="保存" style="width: 80px;height: 40px;font-size: 20px;">
            &nbsp;&nbsp;&nbsp;
            <input type="button" value="返回" onclick="f1()" style="width: 80px;height: 40px;font-size: 20px;">
        </div>
    </div>
</div>
</form>
<script>
   
    function f1() {
    	location.href="${pageContext.request.contextPath }//DepartmentServlet?service=DepartmentGuanLi";
    }
    var i=false;
    function oon() {
		$.ajax({
			url:"DepartmentServlet?service=selectDepartment",
			data:{
				department:$("#department").val()
			},
			success:function(data){
				if (data=="true") {
					$("i").text("");
					i=true;
				}else {
					$("i").text("部门已存在！");
					if ($("#department").val()=="${department.department_name}") {
    					$("i").text("");
    				}
    				i=false;
					
    				
				}
			}
		})
	}
    function on() {
    	if ($("#department").val()=="${department.department_name}") {
			return true;
		}else{
			return i;
		}
	}
</script>
</body>
</html>