<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="uploadResult.jsp" enctype="multipart/form-data" method="post" >
		<div>
			<label for="title">제목</label>
			<input type="text" name="title" id="title" />
		</div>
		<div>
			<label for="content">내용</label>
			<textarea name="content" id="content" cols="30" rows="10"></textarea>
		</div>
				<div>
			<label for="file">첨부파일</label>
			<input type="file" name="file" id="file" />
		</div>
		<div>
			<button>전송</button>
		</div>
	</form>
</body>
</html>