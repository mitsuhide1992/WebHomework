var weekday;
var lesson=new Array();
lesson[0] = new Array();//瀛樼1鑺傝
lesson[1] = new Array();
lesson[2] = new Array();
lesson[3] = new Array();
lesson[4] = new Array();
lesson[5] = new Array();
lesson[6] = new Array();
lesson[7] = new Array();
lesson[8] = new Array();
lesson[9] = new Array();
lesson[10] = new Array();//瀛樼10鑺傝
var recvLesson;
var lastLeNo,lastXuNo;

var transWeek = ["星期一","星期二","星期三","星期四","星期五","星期六","星期日"];
$(document).ready(function(){
    if(weekday == undefined){
        weekday = "1";
    }
	$.ajax({
        type:"post",
        url:"getalltimetable.action",
        datatype:'json',
        success:function(alltimetable){
            recvLesson = eval("("+alltimetable.returnResult+")");
            getWeekdayLesson();//鑾峰彇鏈棩璇剧▼
//            var forminnerhtml = getTimeTableHtml();
            $("#form_timetable").html(getTimeTableHtml());
        },
        error:function(){
            alert("查询所有课表错误！");
        }
    });
});

function getTimeTableHtml(){
    var lehtml="";
    var xu;
    var length0,length1,length2,length3,length4,length5,length6,length7,length8,length9;
    length0=lesson[0].length;
    length1=lesson[1].length;
    length2=lesson[2].length;
    length3=lesson[3].length;
    length4=lesson[4].length;
    length5=lesson[5].length;
    length6=lesson[6].length;
    length7=lesson[7].length;
    length8=lesson[8].length;
    length9=lesson[9].length;
    var notfinished = true;
    while(notfinished){
        notfinished = false;
        lehtml=lehtml+"<tr>";
        if(length0!=0){
            xu = lesson[0].length-length0;
            lehtml=lehtml+"<td id=\"0_"+xu+"\" onclick=\"showInfo("+0+","+xu+")\" class=\"formContent\">"+lesson[0][xu].courseName+"</td>";
            length0--;
            notfinished = true;
        }
        else{
            lehtml=lehtml+"<td></td>"
        }
        if(length1!=0){
            xu = lesson[1].length-length1;
            lehtml=lehtml+"<td id=\"1_"+xu+"\" onclick=\"showInfo("+1+","+xu+")\" class=\"formContent\">"+lesson[1][xu].courseName+"</td>";
            length1--;
            notfinished = true;
        }
        else{
            lehtml=lehtml+"<td></td>"
        }
        if(length2!=0){
            xu = lesson[2].length-length2;
            lehtml=lehtml+"<td id=\"2_"+xu+"\" onclick=\"showInfo("+2+","+xu+")\" class=\"formContent\">"+lesson[2][xu].courseName+"</td>";
            length2--;
            notfinished = true;
        }else{
            lehtml=lehtml+"<td></td>"
        }
        if(length3!=0){
            xu = lesson[3].length-length3;
            lehtml=lehtml+"<td id=\"3_"+xu+"\" onclick=\"showInfo("+3+","+xu+")\" class=\"formContent\">"+lesson[3][xu].courseName+"</td>";
            length3--;
            notfinished = true;
        }else{
            lehtml=lehtml+"<td></td>"
        }
        if(length4!=0){
            xu = lesson[4].length-length4;
            lehtml=lehtml+"<td id=\"4_"+xu+"\" onclick=\"showInfo("+4+","+xu+")\" class=\"formContent\">"+lesson[4][xu].courseName+"</td>";
            length4--;
            notfinished = true;
        }else{
            lehtml=lehtml+"<td></td>"
        }
        if(length5!=0){
            xu = lesson[5].length-length5;
            lehtml=lehtml+"<td id=\"5_"+xu+"\" onclick=\"showInfo("+5+","+xu+")\" class=\"formContent\">"+lesson[5][xu].courseName+"</td>";
            length5--;
            notfinished = true;
        }else{
            lehtml=lehtml+"<td></td>"
        }
        if(length6!=0){
            xu = lesson[6].length-length6;
            lehtml=lehtml+"<td id=\"6_"+xu+"\" onclick=\"showInfo("+6+","+xu+")\" class=\"formContent\">"+lesson[6][xu].courseName+"</td>";
            length6--;
            notfinished = true;
        }else{
            lehtml=lehtml+"<td></td>"
        }
        if(length7!=0){
            xu = lesson[7].length-length7;
            lehtml=lehtml+"<td id=\"7_"+xu+"\" onclick=\"showInfo("+7+","+xu+")\" class=\"formContent\">"+lesson[7][xu].courseName+"</td>";
            length7--;
            notfinished = true;
        }else{
            lehtml=lehtml+"<td></td>"
        }
        if(length8!=0){
            xu = lesson[8].length-length8;
            lehtml=lehtml+"<td id=\"8_"+xu+"\" onclick=\"showInfo("+8+","+xu+")\" class=\"formContent\">"+lesson[8][xu].courseName+"</td>";
            length8--;
            notfinished = true;
        }else{
            lehtml=lehtml+"<td></td>"
        }
        if(length9!=0){
            xu = lesson[9].length-length9;
            lehtml=lehtml+"<td id=\"9_"+xu+"\" onclick=\"showInfo("+9+","+xu+")\" class=\"formContent\">"+lesson[9][xu].courseName+"</td>";
            length9--;
            notfinished = true;
        }else{
            lehtml=lehtml+"<td></td>"
        }
        lehtml=lehtml+"</tr>";
    }
    return lehtml;
}

function getWeekdayLesson(){
    lesson[0].length=lesson[1].length=lesson[2].length=lesson[3].length=lesson[4].length=lesson[5].length=lesson[6].length=lesson[7].length=lesson[8].length=lesson[9].length=0;
    for(var i = 0;i < recvLesson.length;i++){
        if(recvLesson[i].weekday == weekday){
            var st = parseInt(recvLesson[i].startTime);
            var et = parseInt(recvLesson[i].endTime);
            for(var j = st - 1;j < et - 1;j++){
                lesson[j][lesson[j].length]=recvLesson[i];
            }
        }
    }//lesson瀛樻斁鏈棩璇剧▼
}

function changeWeekday(wekd){
    weekday = wekd;
//    $("#week"+wekd).removeClass().addClass("selected");
//    $("#week2").removeClass().addClass("selected");
    for(var i = 1;i<=7;i++){
        if(i!=wekd)
            $("#week"+i).removeClass();
        else if(i == wekd){
            $("#week"+i).removeClass().addClass("selected");
        }
    }
    getWeekdayLesson();//鑾峰彇鏈棩璇剧▼
    $("#form_timetable").empty();
    $("#form_timetable").html(getTimeTableHtml());
//    $("#form_timetable").;
}

function showInfo(leNo,xuNo){
        var event=getEvent();
        event.stopPropagation();

        var offset = $(event.target).offset();
        $('#showLessonInfo').css({ top: offset.top + $(event.target).height() + "px", left: offset.left });

        $("#courseN").val(lesson[leNo][xuNo].courseName);
        $("#semesterN").val(lesson[leNo][xuNo].semesterNo);
        $("#teacherN").val(lesson[leNo][xuNo].teacherNo);
        $("#classN").val(lesson[leNo][xuNo].classNo);
        $("#classR").val(lesson[leNo][xuNo].classRoom);
        $("#startW").val(lesson[leNo][xuNo].startWeek);
        $("#endW").val(lesson[leNo][xuNo].endWeek);
        $("#startT").val(lesson[leNo][xuNo].startTime);
        $("#endT").val(lesson[leNo][xuNo].endTime);
        $("#weekD").val(transWeek[lesson[leNo][xuNo].weekday-1]);
        $("#timeTableI").val(lesson[leNo][xuNo].id);

        $('#newLessonInfo').hide();
        $('#selectLessonInfo').hide();

        if(lastLeNo == undefined && lastXuNo == undefined || lastLeNo == leNo && lastXuNo == xuNo)
            $('#showLessonInfo').toggle('slow');
        else
        {
            $('#showLessonInfo').hide();
            $('#showLessonInfo').show('slow');
        }
        lastLeNo=leNo;
        lastXuNo=xuNo;

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

function notShowInfo(){
    $('#showLessonInfo').hide("slow");
}
function notShowNewInfo(){
    $('#newLessonInfo').hide("slow");
}
function notShowSelectInfo(){
    $('#selectLessonInfo').hide("slow");
}
function checkModifyLessInfo(){
    var checkTest  = /^[0-9]*$/;
    if(!checkTest.test($("#semesterN").val())){
        alert("学期号必须是数字，重新填写！");
        return false;
    }
    if(!checkTest.test($("#teacherN").val())){
        alert("教师号必须是数字，重新填写！");
        return false;
    }
    if(!checkTest.test($("#startW").val())){
        alert("开始周必须是数字，重新填写！");
        return false;
    }
    if(!checkTest.test($("#endW").val())){
        alert("结束周必须是数字，重新填写！");
        return false;
    }
    if(!checkTest.test($("#startT").val())){
        alert("起始节必须是数字，重新填写！");
        return false;
    }
    if(!checkTest.test($("#endT").val())){
        alert("结束节必须是数字，重新填写！");
        return false;
    }
    if(parseInt($("#startW").val())>parseInt($("#endW").val())){
        alert("起始周大于结束周，错误！");
        return false;
    }
    if(parseInt($("#startT").val())>parseInt($("#endT").val())){
        alert("起始节大于结束节，错误！");
        return false;
    }
    checkTest = /^\d*-\d*$/;
    if(!checkTest.test($("#classR").val())){
        alert("上课教室格式：教学楼号-教室号！");
        return false;
    }
    checkTest = /^(&\d*)*&$/;
    if(!checkTest.test($("#classN").val())){
        alert("上课班级格式：以&开头和结束，中间有若干个班级号，用&分隔！");
        return false;
    }

    if($("#weekD").val() == "星期一"){
//        $("#weekD").val(1);
        $("#realWeekD").val(1);
        return true;
    }
    else if($("#weekD").val()=="星期二"){
//        $("#weekD").val(2);
        $("#realWeekD").val(2);
        return true;
    }
    else if($("#weekD").val()=="星期三"){
//        $("#weekD").val(3);
        $("#realWeekD").val(3);
        return true;
    }
    else if($("#weekD").val()=="星期四"){
//        $("#weekD").val(4);
        $("#realWeekD").val(4);
        return true;
    }
    else if($("#weekD").val()=="星期五"){
//        $("#weekD").val(5);
        $("#realWeekD").val(5);
        return true;
    }
    else if($("#weekD").val()=="星期六"){
//        $("#weekD").val(6);
        $("#realWeekD").val(6);
        return true;
    }
    else if($("#weekD").val()=="星期日"){
//        $("#weekD").val(7);
        $("#realWeekD").val(7);
        return true;
    }
    else
    {
        alert("上课日必须是星期一、星期二、星期三、星期四、星期五、星期六、星期日！");
        return false;
    }
    return true;
}

function new_time_table(){
    var event=getEvent();
    event.stopPropagation();
    $('#selectLessonInfo').hide();
    $('#showLessonInfo').hide();
    var offset = $(event.target).offset();
    $('#newLessonInfo').css({ top: offset.top + $(event.target).height() + "px", left: offset.left });
    $('#newLessonInfo').toggle('slow');
}

function checkNewLessInfo(){
    var checkTest  = /^[0-9]*$/;
    if(!checkTest.test($("#newSemesterN").val())){
        alert("学期号必须是数字，重新填写！");
        return false;
    }
    if(!checkTest.test($("#newTeacherN").val())){
        alert("教师号必须是数字，重新填写！");
        return false;
    }
    if(!checkTest.test($("#newStartW").val())){
        alert("开始周必须是数字，重新填写！");
        return false;
    }
    if(!checkTest.test($("#newEndW").val())){
        alert("结束周必须是数字，重新填写！");
        return false;
    }
    if(!checkTest.test($("#newStartT").val())){
        alert("起始节必须是数字，重新填写！");
        return false;
    }
    if(!checkTest.test($("#newEndT").val())){
        alert("结束节必须是数字，重新填写！");
        return false;
    }
    if(parseInt($("#newStartW").val())>parseInt($("#newEndW").val())){
        alert("起始周大于结束周，错误！");
        return false;
    }
    if(parseInt($("#newStartT").val())>parseInt($("#newEndT").val())){
        alert("起始节大于结束节，错误！");
        return false;
    }
    checkTest = /^\d*-\d*$/;
    if(!checkTest.test($("#newClassR").val())){
        alert("上课教室格式：教学楼号-教室号！");
        return false;
    }
    checkTest = /^(&\d*)*&$/;
    if(!checkTest.test($("#newClassN").val())){
        alert("上课班级格式：以&开头和结束，中间有若干个班级号，用&分隔！");
        return false;
    }

    if($("#newWeekD").val() == "星期一"){
//        $("#weekD").val(1);
        $("#newRealWeekD").val(1);
        return true;
    }
    else if($("#newWeekD").val()=="星期二"){
//        $("#weekD").val(2);
        $("#newRealWeekD").val(2);
        return true;
    }
    else if($("#newWeekD").val()=="星期三"){
//        $("#weekD").val(3);
        $("#newRealWeekD").val(3);
        return true;
    }
    else if($("#newWeekD").val()=="星期四"){
//        $("#weekD").val(4);
        $("#newRealWeekD").val(4);
        return true;
    }
    else if($("#newWeekD").val()=="星期五"){
//        $("#weekD").val(5);
        $("#newRealWeekD").val(5);
        return true;
    }
    else if($("#newWeekD").val()=="星期六"){
//        $("#weekD").val(6);
        $("#newRealWeekD").val(6);
        return true;
    }
    else if($("#newWeekD").val()=="星期日"){
//        $("#weekD").val(7);
        $("#newRealWeekD").val(7);
        return true;
    }
    else
    {
        alert("上课日必须是星期一、星期二、星期三、星期四、星期五、星期六、星期日！");
        return false;
    }
    return true;
}

function select_time_table(){
    var event=getEvent();
    event.stopPropagation();

    $('#newLessonInfo').hide();
    $('#showLessonInfo').hide();

    var offset = $(event.target).offset();
    $('#selectLessonInfo').css({ top: offset.top + $(event.target).height() + "px", left: offset.left });
    $('#selectLessonInfo').toggle('slow');
}
function checkSelectLessInfo(){
    var checkTest  = /^[0-9]*$/;
    if($("#selectSemesterN").val() != "" && !checkTest.test($("#selectSemesterN").val())){
        alert("学期号必须是数字，重新填写！");
        return false;
    }
    if($("#selectTeacherN").val()!="" && !checkTest.test($("#selectTeacherN").val())){
        alert("教师号必须是数字，重新填写！");
        return false;
    }
    checkTest = /^\d*-\d*$/;
    if($("#selectClassR").val()!="" && !checkTest.test($("#selectClassR").val())){
        alert("上课教室格式：教学楼号-教室号！");
        return false;
    }
    checkTest = /^(&\d*)*&$/;
    if($("#selectClassN").val()!="" && !checkTest.test($("#selectClassN").val())){
        alert("上课班级格式：以&开头和结束，中间有若干个班级号，用&分隔！");
        return false;
    }
    if($("#selectClassN").val()=="" && $("#selectClassR").val()=="" && $("#selectTeacherN").val()=="" && $("#selectSemesterN").val()=="" && $("#selectCourseN").val()==""){
        alert("查询条件不能全是空，重新填写！");
        return false;
    }

    return true;
}

function select_course_submit(){
    $.ajax({
        type:"post",
        url:"selecttimetable.action",
        datatype:'json',
        data:"selectCourseN="+$("#selectCourseN").val()+
            "&selectSemesterN="+$("#selectSemesterN").val()+
            "&selectTeacherN="+$("#selectTeacherN").val()+
            "&selectClassN="+$("#selectClassN").val()+
            "&selectClassR="+$("#selectClassR").val()+"",
        success:function(selecttimetable){
            recvLesson = eval("("+selecttimetable.selectResult+")");
            getWeekdayLesson();//鑾峰彇鏈棩璇剧▼
//            var forminnerhtml = getTimeTableHtml();
            $("#form_timetable").empty();
            $("#form_timetable").html(getTimeTableHtml());
        },
        error:function(){
            alert("查询部分课表错误！");
        }
    });
}

function delCourse(){
    $.ajax({
        type:"post",
        url:"deletetimetable.action",
        datatype:'json',
        data:"timeTableI="+$("#timeTableI").val()+"",
        success:function(){
            alert("课程删除成功！");
            location.reload();
        },
        error:function(){
            alert("课程删除错误！");
        }
    });
}
//$(document).click(function (event) { $('#showLessonInfo').slideUp('slow') });