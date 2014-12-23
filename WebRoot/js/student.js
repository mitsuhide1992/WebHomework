/**
 * Created by Administrator on 13-12-11.
 */
var studentNo,studentName,studentIdentifyNo,studentClassNo,studentEmail,studentPhoneNo;
var studentLesson;
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

    studentNo=$("#show_studentNo")[0].textContent
    studentName=$("#show_studentName")[0].textContent;
    studentIdentifyNo=$("#show_identifyNo")[0].textContent;
    studentClassNo=$("#show_classNo")[0].textContent;
    studentEmail=$("#show_studentEmail")[0].textContent;
    studentPhoneNo=$("#show_studentPhoneNo")[0].textContent;

    $.ajax({
        type:"post",
        url:"getastudenttable.action",
        datatype:'json',
        data:"classNo="+studentClassNo+"",
        success:function(studentTimetable){
            studentLesson = eval("("+studentTimetable.studentCourse+")");
            getStudentWeekdayLesson();
            $("#student_form_timetable").html(getStudentTimeTableHtml());
        },
        error:function(){
            alert("wrong");
        }
    });
});

function modify_student_info(){
    studentNo=$("#show_studentNo")[0].textContent
    studentName=$("#show_studentName")[0].textContent;
    studentIdentifyNo=$("#show_identifyNo")[0].textContent;
    studentClassNo=$("#show_classNo")[0].textContent;
    studentEmail=$("#show_studentEmail")[0].textContent;
    studentPhoneNo=$("#show_studentPhoneNo")[0].textContent;
    $("#show_student_info").css("display","none");
    $("#modify_student_form").css("display","block");

    $("#studentNo").val(studentNo);
    $("#studentName").val(studentName);
    $("#identifyNo").val(studentIdentifyNo);
    $("#classNo").val(studentClassNo);
    $("#studentEmail").val(studentEmail);
    $("#studentPhoneNo").val(studentPhoneNo);
}

function noModifySIF(){
    $("#modify_student_form").css("display","none");
    $("#student_timetable").css("display","none");
    $("#show_student_info").css("display","block");
}

function checkUpdateStudent(){
    var checkTest=/^1[3|4|5|8][0-9]\d{4,8}$/;
    if(!checkTest.test($("#studentPhoneNo").val())){
        alert("手机号格式错误，重新填写！");
        return false;
    }
    checkTest=/^\d\d\d\d\d\d\d\d\d\d\d\d\d\d\d\d\d\d$/;
    if(!checkTest.test($("#identifyNo").val())){
        alert("身份证号必须是18位数字，重新填写！");
        return false;
    }
    checkTest =  /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if(!checkTest.test($("#studentEmail").val())){
        alert("邮箱格式错误，重新填写！");
        return false;
    }
    checkTest = /^\d*$/;
    if(!checkTest.test($("#classNo").val())){
        alert("班号必须是数字，重新填写！");
        return false;
    }
    return true;
}

function showStudentInfo(){
    $("#student_info").removeClass().addClass("selected");
    $("#student_timetable_select").removeClass();
    $("#student_timetable").css("display","none");
    $("#modify_student_form").css("display","none");
    $("#show_student_info").css("display","block");
}

function showStudentSelected(){
    $("#student_timetable_select").removeClass().addClass("selected");
    $("#student_info").removeClass();
    $("#show_student_info").css("display","none");
    $("#modify_student_form").css("display","none");
    $("#student_timetable").css("display","block");
//    $("#student_select_timetable").css("display","block");
}

function getStudentWeekdayLesson(){
//    lesson[0].length=lesson[1].length=lesson[2].length=lesson[3].length=lesson[4].length=lesson[5].length=lesson[6].length=lesson[7].length=lesson[8].length=lesson[9].length=0;
    var i,j;
    for(i = 0;i <= 6;i++){
        for(j = 0;j <= 9;j++){
            slesson[i][j] = null;
        }
    }
    for(i = 0;i < studentLesson.length;i++){
        var st = parseInt(studentLesson[i].startTime);
        var et = parseInt(studentLesson[i].endTime);
        var wk = parseInt(studentLesson[i].weekday);
        for(j = st - 1;j < et - 1;j++){
            slesson[wk-1][j]=studentLesson[i];
        }
    }//lesson瀛樻斁鏈棩璇剧▼
}

function getStudentTimeTableHtml(){
    var lehtml="";
    for(var i = 0;i <= 9;i++){
        lehtml = lehtml+"<tr><td>"+jieci[i]+"</td>";
        for(var j = 0;j <= 6;j++){
            if(slesson[j][i] != null){
                lehtml=lehtml+"<td onclick=\"show_student_course("+j+","+i+")\" class=\"formContent\">"+slesson[j][i].courseName+"</td>";
            }
            else if(slesson[j][i] == null){
                lehtml=lehtml+"<td></td>";
            }
        }
        lehtml = lehtml+"</tr>";
    }
    return lehtml;
}

function show_student_course(leNo,xuNo){
    var event=getEvent();
    event.stopPropagation();
    var offset = $(event.target).offset();
    $('#showStudentLessonInfo').css({ top: offset.top + $(event.target).height() + "px", left: offset.left });

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
        $('#showStudentLessonInfo').toggle('slow');
    else
    {
        $('#showStudentLessonInfo').hide();
        $('#showStudentLessonInfo').show('slow');
    }
    lastLeNo=leNo;
    lastXuNo=xuNo;
}

function notShowStudentInfo(){
    $('#showStudentLessonInfo').hide("slow");
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