/**
 * Created by Administrator on 13-12-25.
 */
$(document).ready(function(){
//    alert($.cookie("userNo"));
    $("#userNoForModify").val($.cookie("userNo"));
    $("#oldPassword").val($.cookie("userPassword"));
});