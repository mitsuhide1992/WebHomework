/**
 * Created by Administrator on 13-12-25.
 */

function storUserNoAndPassword(){
    $.cookie("userNo",$("#loginUserNo").val());
    $.cookie("userPassword",$("#loginPassword").val());
    return true;
}

function checkModifyPass(){
    if($("#oldPassword").val()!=$.cookie("userPassword")){
        alert("原始密码错误");
        return false;
    }
    return true;
}
