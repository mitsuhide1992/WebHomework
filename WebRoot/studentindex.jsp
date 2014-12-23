<%@ page contentType="text/html" pageEncoding="utf-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML>
<html>

<head>
    <title>学生操作页面</title>
    <meta name="description" content="website description" />
    <meta name="keywords" content="website keywords, website keywords" />
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" type="text/css" href="css/stylemain.css" />
    <link rel="stylesheet" type="text/css" href="css/student.css" />

    <script type="text/javascript" src="js/modernizr-1.5.min.js"></script>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/jquery.easing-sooper.js"></script>
    <script type="text/javascript" src="js/jquery.sooperfish.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $('ul.sf-menu').sooperfish();
        });
    </script>
    <script src="js/student.js"></script>
</head>

<body>
<div id="main">
    <header>
        <div id="logo">
            <div id="logo_text">
                <h1>学生操作台--<span class="logo_colour">课表查询</span></h1>
                <a class="logout" href="login.html">注销</a>
                <a class="modifyPassowrd" href="modifyPassword.html">修改密码</a>
            </div>
        </div>
        <nav>
            <div id="menu_container">
                <ul class="sf-menu" id="nav">
                    <li><span id="student_info" class="selected" onclick="showStudentInfo()">个人信息</span></li>
                    <li><span id="student_timetable_select" onclick="showStudentSelected()">课表信息</span></li>
                </ul>
            </div>
        </nav>
    </header>
    <div id="site_content">
        <%--<div id="sidebar_container">--%>
            <%--<div class="sidebar" id="student_select_timetable">--%>
                <%--<h3>课表查询</h3>--%>
            <%--</div>--%>
        <%--</div>--%>
        <div class="content">
            <div id="student_timetable" class="hiden_student_timetable">
                <table>
                    <thead>
                    <tr>
                        <th></th>
                        <th scope="col" abbr="1">&nbsp&nbsp&nbsp周一&nbsp&nbsp&nbsp</th>
                        <th scope="col" abbr="2">&nbsp&nbsp&nbsp周二&nbsp&nbsp&nbsp</th>
                        <th scope="col" abbr="3">&nbsp&nbsp&nbsp周三&nbsp&nbsp&nbsp</th>
                        <th scope="col" abbr="4">&nbsp&nbsp&nbsp周四&nbsp&nbsp&nbsp</th>
                        <th scope="col" abbr="5">&nbsp&nbsp&nbsp周五&nbsp&nbsp&nbsp</th>
                        <th scope="col" abbr="6">&nbsp&nbsp&nbsp周六&nbsp&nbsp&nbsp</th>
                        <th scope="col" abbr="7">&nbsp&nbsp&nbsp周日&nbsp&nbsp&nbsp</th>
                    </tr>
                    </thead>
                    <tbody id="student_form_timetable">

                    </tbody>
                </table>
            </div>

            <div id="modify_student_form" class="hiden_student_modify" >
                <form  action="updatestudentinfo.action" autocomplete="on" method="post" onsubmit="return checkUpdateStudent()">
                    <h1>学生信息修改（只能修改班号、邮箱、手机）</h1>

                    <label for="studentNo" >学号——————</label>
                    <input id="studentNo" name="studentNo" required="required" type="text" readonly/><br>

                    <label for="studentName" >姓名——————</label>
                    <input id="studentName" name="studentName" required="required" type="text" readonly/><br>

                    <label for="identifyNo" >身份证号（18位）</label>
                    <input id="identifyNo" name="identifyNo" required="required" type="text" readonly/><br>

                    <label for="classNo" >班号——————</label>
                    <input id="classNo" name="classNo" required="required" type="text"/><br>

                    <label for="studentEmail">邮箱——————</label>
                    <input id="studentEmail" name="studentEmail" required="required" type="text"/><br>

                    <label for="studentPhoneNo">手机——————</label>
                    <input id="studentPhoneNo" name="studentPhoneNo" required="required" type="text"/><br>


                    <input type="submit" value="确认修改" class="form_button" />


                    <input type="button" value="返回" class="form_button" onclick="noModifySIF()"/>

                </form>
            </div>

            <div id="show_student_info">
                <h1>学生个人信息</h1>
                <%--<label for="show_studentNo" >学号</label>--%>
                <p>学号:<span id="show_studentNo"><s:property value="loginStudent.getStudentNo()"/></span></p>
                <%--<label for="show_studentName" >姓名</label>--%>
                <p>姓名:<span id="show_studentName"><s:property value="loginStudent.getStudentName()"/></span></p>
                <%--<label for="show_identifyNo" >身份证号</label>--%>
                <p>身份证号:<span id="show_identifyNo"><s:property value="loginStudent.getIdNo()"/></span></p>
                <%--<label for="show_classNo" >班号</label>--%>
                <p>班号:<span id="show_classNo"><s:property value="loginStudent.getClassNo()"/></span></p>
                <%--<label for="show_studentEmail" >邮箱</label>--%>
                <p>邮箱:<span id="show_studentEmail"><s:property value="loginStudent.getEmail()"/></span></p>
                <%--<label for="show_studentPhoneNo" >手机</label>--%>
                <p>手机:<span id="show_studentPhoneNo"><s:property value="loginStudent.getPhoneNo()"/></span></p>
                <span class="change_student_info" onclick="modify_student_info()">修改</span>
            </div>

            <div id="showStudentLessonInfo" class="hidenInfo" style="width:460px;">
                <form>
                    <h1>课程属性显示</h1>
                    <!--<p>-->
                    <label for="courseN" data-icon="u" > 课程名 </label>
                    <input id="courseN" name="courseN" required="required" type="text" readonly/>
                    <!--</p>-->
                    <!--<p>-->
                    <label for="semesterN" data-icon="p"> 学期号 </label>
                    <input id="semesterN" name="semesterN" required="required" type="text" readonly/>
                    <!--</p>-->
                    <!--<p>-->
                    <label for="teacherN" data-icon="p"> 教师号 </label>
                    <input id="teacherN" name="teacherN" required="required" type="text" readonly/>
                    <!--</p>-->
                    <!--<p>-->
                    <label for="classN" data-icon="p"> 班级号 </label>
                    <input id="classN" name="classN" required="required" type="text" readonly/>
                    <!--</p>-->
                    <!--<p>-->
                    <label for="classR" data-icon="p"> 教室号 </label>
                    <input id="classR" name="classR" required="required" type="text" readonly/>
                    <!--</p>-->
                    <!--<p>-->
                    <label for="startW" data-icon="p"> 开始周 </label>
                    <input id="startW" name="startW" required="required" type="text" readonly/>
                    <!--</p>-->
                    <!--<p>-->
                    <label for="endW" data-icon="p"> 结束周 </label>
                    <input id="endW" name="endW" required="required" type="text" readonly/>
                    <!--</p>-->
                    <!--<p>-->
                    <label for="startT" data-icon="p"> 起始节 </label>
                    <input id="startT" name="startT" required="required" type="text" readonly/>
                    <!--</p>-->
                    <!--<p>-->
                    <label for="endT" data-icon="p"> 结束节 </label>
                    <input id="endT" name="endT" required="required" type="text" readonly/>
                    <!--</p>-->
                    <!--<p>-->
                    <label for="weekD" data-icon="p"> 上课日 </label>
                    <input id="weekD" name="weekD" required="required" type="text" readonly/>

                    <input type="button" value="返回" class="form_button" onclick="notShowStudentInfo()"/>
                </form>
            </div>
        </div>
    </div>
    <footer>

    </footer>
</div>
<p>&nbsp;</p>

</body>
</html>
