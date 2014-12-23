<%@ page contentType="text/html" pageEncoding="utf-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML>
<html>

<head>
  <title>管理员操作页面</title>
  <meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <link rel="stylesheet" type="text/css" href="css/stylemain.css" />

  <script type="text/javascript" src="js/modernizr-1.5.min.js"></script>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/jquery.easing-sooper.js"></script>
    <script type="text/javascript" src="js/jquery.sooperfish.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $('ul.sf-menu').sooperfish();
        });
    </script>
  <script src="js/admin.js"></script>
  <%--<script src="js/modifyPassword.js"></script>--%>
</head>

<body>
    <%--<div class=".userHidenInfo">--%>
        <%--<p id="userHidenNo"></p>--%>
        <%--<p id="userHidenPassword"></p>--%>
    <%--</div>--%>
  <div id="main">
    <header>
      <div id="logo">
        <div id="logo_text">
          <!-- class="logo_colour", allows you to change the colour of the text -->
          <h1>管理员控制台--<span class="logo_colour">课表管理</span></h1>
            <a class="logout" href="login.html">注销</a>
            <a class="modifyPassowrd" href="modifyPassword.html">修改密码</a>
        </div>
      </div>
      <nav>
        <div id="menu_container">
          <ul class="sf-menu" id="nav">
            <li><span id="week1" class="selected" onclick="changeWeekday(1)">周一</span></li>
            <li><span id="week2" onclick="changeWeekday(2)">周二</span></li>
            <li><span id="week3" onclick="changeWeekday(3)">周三</span></li>
            <li><span id="week4" onclick="changeWeekday(4)">周四</span></li>
            <li><span id="week5" onclick="changeWeekday(5)">周五</span>

            </li>
            <li><span id="week6" onclick="changeWeekday(6)">周六</span></li>
            <li><span id="week7" onclick="changeWeekday(7)">周日</span></li>

          </ul>
        </div>
      </nav>
    </header>
    <div id="site_content">

      <div class="content" id="timetable">
          <table>
              <thead>
                  <tr>

                      <th scope="col" abbr="1">8:00-8:50</th>
                      <th scope="col" abbr="2">9:00-9:50</th>
                      <th scope="col" abbr="3">10:10-11:00</th>
                      <th scope="col" abbr="4">11:10-12:00</th>
                      <th scope="col" abbr="5">13:30-14:20</th>
                      <th scope="col" abbr="6">14:30-15:20</th>
                      <th scope="col" abbr="7">15:30-16:20</th>
                      <th scope="col" abbr="8">16:30-17:20</th>
                      <th scope="col" abbr="9">18:30-19:20</th>
                      <th scope="col" abbr="10">19:30-20:20</th>
                  </tr>
              </thead>
              <tbody id="form_timetable">

              </tbody>
          </table>
          <button class="new_timetable" onclick="new_time_table()">新增课表</button>
          <button class="new_timetable" style="margin-left:30px;" onclick="select_time_table()">查询课表</button>
      </div>
    </div>
    <footer>

    </footer>
  </div>
  <p>&nbsp;</p>


  <div id="newLessonInfo" class="hidenInfo">
      <form  action="newtimetable.action" autocomplete="on" method="post" onsubmit="return checkNewLessInfo()">
          <h1>添加新课程</h1>

          <label for="newCourseN" data-icon="u" > 课程名 </label>
          <input id="newCourseN" name="newCourseN" required="required" type="text"/>

          <label for="newSemesterN" data-icon="p"> 学期号 </label>
          <input id="newSemesterN" name="newSemesterN" required="required" type="text"/><br>

          <label for="newTeacherN" data-icon="p"> 教师号 </label>
          <input id="newTeacherN" name="newTeacherN" required="required" type="text"/>

          <label for="newClassN" data-icon="p"> 班级号 </label>
          <input id="newClassN" name="newClassN" required="required" type="text"/><br>

          <label for="newClassR" data-icon="p"> 教室号 </label>
          <input id="newClassR" name="newClassR" required="required" type="text"/>

          <label for="newStartW" data-icon="p"> 开始周 </label>
          <input id="newStartW" name="newStartW" required="required" type="text"/><br>

          <label for="newEndW" data-icon="p"> 结束周 </label>
          <input id="newEndW" name="newEndW" required="required" type="text"/>

          <label for="newStartT" data-icon="p"> 起始节 </label>
          <input id="newStartT" name="newStartT" required="required" type="text"/><br>

          <label for="newEndT" data-icon="p"> 结束节 </label>
          <input id="newEndT" name="newEndT" required="required" type="text"/>

          <label for="newWeekD" data-icon="p"> 上课日 </label>
          <input id="newWeekD" name="newWeekD" required="required" type="text"/><br>

          <input name="newRealWeekD" id="newRealWeekD" style="display: none"/>


          <input type="submit" value="添加课程" class="form_button" />

          <input type="button" value="返回" class="form_button" onclick="notShowNewInfo()"/>
      </form>
  </div>
  <div id="selectLessonInfo" class="hidenInfo">
      <form  action="selecttimetable.action" autocomplete="on" method="post" onsubmit="return checkSelectLessInfo()">
          <h1>查询课程信息</h1>

          <label for="selectCourseN" data-icon="u" > 课程名 </label>
          <input id="selectCourseN" name="selectCourseN"  type="text"/>

          <label for="selectSemesterN" data-icon="p"> 学期号 </label>
          <input id="selectSemesterN" name="selectSemesterN"  type="text"/>

          <label for="selectTeacherN" data-icon="p"> 教师号 </label>
          <input id="selectTeacherN" name="selectTeacherN"  type="text"/>

          <label for="selectClassN" data-icon="p"> 班级号 </label>
          <input id="selectClassN" name="selectClassN" type="text"/>

          <label for="selectClassR" data-icon="p"> 教室号 </label>
          <input id="selectClassR" name="selectClassR"  type="text"/>

          <input type="button" value="查询课程" class="form_button" onclick="select_course_submit()"/>

          <input type="button" value="返回" class="form_button" onclick="notShowSelectInfo()"/>
      </form>
  </div>
  <div id="showLessonInfo" class="hidenInfo">
      <form  action="updatetimetable.action" autocomplete="on" method="post" onsubmit="return checkModifyLessInfo()">
          <h1>课程属性修改</h1>

              <label for="courseN" data-icon="u" > 课程名 </label>
              <input id="courseN" name="courseN" required="required" type="text"/>

              <label for="semesterN" data-icon="p"> 学期号 </label>
              <input id="semesterN" name="semesterN" required="required" type="text"/><br>

              <label for="teacherN" data-icon="p"> 教师号 </label>
              <input id="teacherN" name="teacherN" required="required" type="text"/>

              <label for="classN" data-icon="p"> 班级号 </label>
              <input id="classN" name="classN" required="required" type="text"/><br>

              <label for="classR" data-icon="p"> 教室号 </label>
              <input id="classR" name="classR" required="required" type="text"/>

              <label for="startW" data-icon="p"> 开始周 </label>
              <input id="startW" name="startW" required="required" type="text"/><br>

              <label for="endW" data-icon="p"> 结束周 </label>
              <input id="endW" name="endW" required="required" type="text"/>

              <label for="startT" data-icon="p"> 起始节 </label>
              <input id="startT" name="startT" required="required" type="text"/><br>

              <label for="endT" data-icon="p"> 结束节 </label>
              <input id="endT" name="endT" required="required" type="text"/>

              <label for="weekD" data-icon="p"> 上课日 </label>
              <input id="weekD" name="weekD" required="required" type="text"/><br>

          <input name="realWeekD" id="realWeekD" style="display: none"/>
          <input name="timeTableI" id="timeTableI" style="display: none"/>


              <input type="submit" value="确认修改" class="form_button" />


              <input type="button" value="删除该课程" class="form_button" onclick="delCourse()"/>
              <input type="button" value="返回" class="form_button" onclick="notShowInfo()"/>

      </form>
  </div>

</body>
</html>
