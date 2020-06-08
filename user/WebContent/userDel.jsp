<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="layout/header.jsp"></jsp:include>
<div class="content">
	<div class="container">
		<h3>USER 삭제</h3>
		<form action="process/delProcess.jsp" method="post">
			<div class="form-group row">
				<label for="no" class="col-sm-2 col-form-label">No</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="no" name="no">
				</div>
			</div>
			<div class="form-group row">
				<label for="userName" class="col-sm-2 col-form-label">userName</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="userName" name="userName">
				</div>
			</div>			
			<div class="form-group row">				
				<div class="col-sm-10">
					<button type="submit" class="btn btn-primary">탈퇴</button>
					<button type="button" class="btn btn-success" onclick="">취소</button>
				</div>
			</div>
		</form>
	</div>
</div>
<jsp:include page="layout/footer.jsp"></jsp:include>
