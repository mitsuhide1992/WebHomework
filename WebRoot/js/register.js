/**
 * Created by Administrator on 13-12-10.
 */
function checkNewUser(){
    var checkTest  = /^[0-9]*$/;
    if(!checkTest.test($("#userNo").val())){
        alert("工号或学号必须是数字，重新填写！");
        return false;
    }
    if(!checkTest.test($("#identifyNo").val())){
        alert("身份证号必须是数字，重新填写！");
        return false;
    }
    checkTest =  /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if(!checkTest.test($("#userEmail").val())){
        alert("邮箱格式错误，重新填写！");
        return false;
    }
    checkTest=/^1[3|4|5|8][0-9]\d{4,8}$/;
    if(!checkTest.test($("#phoneNo").val())){
        alert("手机号格式错误，重新填写！");
        return false;
    }
    if($("#userType").val()!="学生" && $("#userType").val()!="老师"){
        alert("用户类别只能是学生或老师，重新填写！");
        return false;
    }
    checkTest  = /^[0-9]*$/;
    if($("#userType").val() == "学生" && !checkTest.test($("#classNo").val())){
        alert("学生班级号必须是数字，重新填写！");
        return false;
    }
    if($("#password").val() != $("#confirmpassword").val()){
        alert("两次密码输入不一致，重新填写！");
        return false;
    }
    if($("#userType").val() == "学生"){
        $("#realUserType").val("student");
    }
    else if($("#userType").val() == "老师"){
        $("#realUserType").val("teacher");
    }
    return true;
}