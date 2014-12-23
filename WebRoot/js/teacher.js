/**
 * Created by Administrator on 13-12-11.
 */
var teacherNo,teacherName,teacherIdentifyNo,teacher,teacherEmail,teacherPhoneNo;
var teacherLesson;
var transWeek = ["星期一","星期二","星期三","星期四","星期五","星期六","星期日"];
var slesson = new Array();
slesson[0] = new Array();
slesson[1] = new Array();
slesson[2] = new Array();
slesson[3] = new Array();
slesson[4] = new Array();
slesson[5] = new Array();
slesson[6] = new Array();
//slesson[7] = new Array();
//slesson[8] = new Array();
//slesson[9] = new Array();
var lastLeNo,lastXuNo;
var jieci = ["8:00-8:50","9:00-9:50","10:10-11:00","11:10-12:00","13:30-14:20","14:30-15:20","15:30-16:20","16:30-17:20","18:30-19:20","19:30-20:20"];

$(document).ready(function(){
    $(".content").css("width","auto");
    $(".content").css("margin-left","50px");

    teacherNo=$("#show_teacherNo")[0].textContent
    teacherName=$("#show_teacherName")[0].textContent;
    teacherIdentifyNo=$("#show_identifyNo")[0].textContent;
    teacherFacultyName=$("#show_facultyName")[0].textContent;
    teacherEmail=$("#show_teacherEmail")[0].textContent;
    teacherPhoneNo=$("#show_teacherPhoneNo")[0].textContent;

    $.ajax({
        type:"post",
        url:"getateachertable.action",
        datatype:'json',
        data:"teacherNo="+teacherNo+"",
        success:function(teacherTimetable){
            teacherLesson = eval("("+teacherTimetable.teacherCourse+")");
            getteacherWeekdayLesson();
            $("#teacher_form_timetable").html(getteacherTimeTableHtml());
        },
        error:function(){
            alert("wrong");
        }
    });
});

function modify_teacher_info(){
    teacherNo=$("#show_teacherNo")[0].textContent;
    teacherName=$("#show_teacherName")[0].textContent;
    teacherIdentifyNo=$("#show_identifyNo")[0].textContent;
    teacherFacultyName=$("#show_facultyName")[0].textContent;
    teacherEmail=$("#show_teacherEmail")[0].textContent;
    teacherPhoneNo=$("#show_teacherPhoneNo")[0].textContent;
    $("#show_teacher_info").css("display","none");
    $("#modify_teacher_form").css("display","block");

    $("#teacherNo").val(teacherNo);
    $("#teacherName").val(teacherName);
    $("#identifyNo").val(teacherIdentifyNo);
    $("#facultyName").val(teacherFacultyName);
    $("#teacherEmail").val(teacherEmail);
    $("#teacherPhoneNo").val(teacherPhoneNo);
}

function noModifySIF(){
    $("#modify_teacher_form").css("display","none");
    $("#teacher_timetable").css("display","none");
    $("#show_teacher_info").css("display","block");
}

function checkUpdateteacher(){
    var checkTest=/^1[3|4|5|8][0-9]\d{4,8}$/;
    if(!checkTest.test($("#teacherPhoneNo").val())){
        alert("手机号格式错误，重新填写！");
        return false;
    }
    checkTest=/^\d\d\d\d\d\d\d\d\d\d\d\d\d\d\d\d\d\d$/;
    if(!checkTest.test($("#identifyNo").val())){
        alert("身份证号必须是18位数字，重新填写！");
        return false;
    }
    checkTest =  /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if(!checkTest.test($("#teacherEmail").val())){
        alert("邮箱格式错误，重新填写！");
        return false;
    }
//    checkTest = /^\d*$/;
//    if(!checkTest.test($("#classNo").val())){
//        alert("班号必须是数字，重新填写！");
//        return false;
//    }
    return true;
}

function showteacherInfo(){
    $("#teacher_info").removeClass().addClass("selected");
    $("#teacher_timetable_select").removeClass();
    $("#teacher_timetable").css("display","none");
    $("#modify_teacher_form").css("display","none");
    $("#show_teacher_info").css("display","block");
}

function showteacherSelected(){
    $("#teacher_timetable_select").removeClass().addClass("selected");
    $("#teacher_info").removeClass();
    $("#show_teacher_info").css("display","none");
    $("#modify_teacher_form").css("display","none");
    $("#teacher_timetable").css("display","block");
//    $("#teacher_select_timetable").css("display","block");
}

function getteacherWeekdayLesson(){
//    lesson[0].length=lesson[1].length=lesson[2].length=lesson[3].length=lesson[4].length=lesson[5].length=lesson[6].length=lesson[7].length=lesson[8].length=lesson[9].length=0;
    var i,j;
    for(i = 0;i <= 6;i++){
        for(j = 0;j <= 9;j++){
            slesson[i][j] = null;
        }
    }
    for(i = 0;i < teacherLesson.length;i++){
        var st = parseInt(teacherLesson[i].startTime);
        var et = parseInt(teacherLesson[i].endTime);
        var wk = parseInt(teacherLesson[i].weekday);
        for(j = st - 1;j < et - 1;j++){
            slesson[wk-1][j]=teacherLesson[i];
        }
    }//lesson瀛樻斁鏈棩璇剧▼
}

function getteacherTimeTableHtml(){
    var lehtml="";
    for(var i = 0;i <= 9;i++){
        lehtml = lehtml+"<tr><td>"+jieci[i]+"</td>";
        for(var j = 0;j <= 6;j++){
            if(slesson[j][i] != null){
                lehtml=lehtml+"<td onclick=\"show_teacher_course("+j+","+i+")\" class=\"formContent\">"+slesson[j][i].courseName+"</td>";
            }
            else if(slesson[j][i] == null){
                lehtml=lehtml+"<td></td>";
            }
        }
        lehtml = lehtml+"</tr>";
    }
    return lehtml;
}

function show_teacher_course(leNo,xuNo){
    var event=getEvent();
    event.stopPropagation();
    var offset = $(event.target).offset();
    $('#showteacherLessonInfo').css({ top: offset.top + $(event.target).height() + "px", left: offset.left });

    $("#courseN").val(slesson[leNo][xuNo].courseName);
    $("#semesterN").val(slesson[leNo][xuNo].semesterNo);
    $("#teacherN").val(slesson[leNo][xuNo].teacherNo);
    $("#classN").val(slesson[leNo][xuNo].classNo);
    $("#classR").val(slesson[leNo][xuNo].classRoom);
    $("#startW").val(slesson[leNo][xuNo].startWeek);
    $("#endW").val(slesson[leNo][xuNo].endWeek);
    $("#startT").val(slesson[leNo][xuNo].startTime);
    $("#endT").val(slesson[leNo][xuNo].endTime);
    $("#weekD").val(transWeek[slesson[leNo][xuNo].weekday-1]);
    $("#timeTableI").val(slesson[leNo][xuNo].id);
    if(lastLeNo == undefined && lastXuNo == undefined || lastLeNo == leNo && lastXuNo == xuNo)
        $('#showteacherLessonInfo').toggle('slow');
    else
    {
        $('#showteacherLessonInfo').hide();
        $('#showteacherLessonInfo').show('slow');
    }
    lastLeNo=leNo;
    lastXuNo=xuNo;
}

function notShowteacherInfo(){
    $('#showteacherLessonInfo').hide("slow");
}

function getEvent() //鍚屾椂鍏煎ie鍜宖f鐨勫啓娉�
{
    if(document.all)  return window.event;
    func=getEvent.caller;
    while(func!=null){
        var arg0=func.arguments[0];
        if(arg0)
        {
            if((arg0.constructor==Event || arg0.constructor ==MouseEvent) || (typeof(arg0)=="object" && arg0.preventDefault && arg0.stopPropagation))
            {
                return arg0;
            }
        }
        func=func.caller;
    }
    return null;
}