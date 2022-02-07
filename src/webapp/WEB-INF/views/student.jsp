<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>페이지 타이틀</title>
</head>
<body>
	Hello, World!!<br/>
	<br/>
	<input type="button" value="현재 시각" onclick="javascript:getCurrentTime();"/>
	 / 
	<input type="button" value="학생 추가" onclick="javascript:createStudent();"/>
	 / 
	<input type="button" value="학생 수정" onclick="javascript:updateStudent();"/>
	 / 
	<input type="button" value="학생 삭제" onclick="javascript:deleteStudent();"/>
	<br/>
	<br/>
	<c:forEach items="${studentList }" var="item">
		번호 : ${item.num } / 이름 : ${item.name }<br/>
	</c:forEach>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
	<script type="text/javascript">
		function getCurrentTime() {
			$.ajax({
				url: '${pageContext.request.contextPath}/student/time',
				method: 'get',
				success: function(data) {
					alert('현재 시각 - ' + data);
				}
			});
		}
		
		function createStudent() {
			if(confirm('학생 정보를 추가하시겠습니까?')) {
				$.ajax({
					url: '${pageContext.request.contextPath}/student',
					method: 'put',
					success: function() {
						location.reload();
					}
				});
			}
		}
		
		function updateStudent() {
			var num = prompt('수정할 학생 번호를 입력해주세요.');
			
			if(num != undefined && num != '') {
				$.ajax({
					url: '${pageContext.request.contextPath}/student',
					method: 'post',
					data: {num: num},
					dataType: 'json',
					success: function(data) {
						if(data != undefined) {
							alert(data.msg);
							
							if(data.result) {
								location.reload();
							}
						}
					}
				});
			}
		}
		
		function deleteStudent() {
			var num = prompt('삭제할 학생 번호를 입력해주세요.');
			
			if(num != undefined && num != '') {
				$.ajax({
					url: '${pageContext.request.contextPath}/student',
					method: 'delete',
					data: {num: num},
					dataType: 'json',
					success: function(data) {
						if(data != undefined) {
							alert(data.msg);
							
							if(data.result) {
								location.reload();
							}
						}
					}
				});
			}
		}
	</script>
</body>
</html>