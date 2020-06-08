<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="layout/header.jsp"></jsp:include>
<div class="content">
	<div class="container">
		<h3>USER 입력</h3>
		<form action="process/addProcess2.jsp" method="post">			
			<div class="form-group row">
				<label for="userName" class="col-sm-2 col-form-label">userName</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="userName" name="userName">
				</div>
			</div>
			<div class="form-group row">
				<label for="birthYear" class="col-sm-2 col-form-label">birthYear</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="birthYear" name="birthYear">
				</div>
			</div>
			<div class="form-group row">
				<label for="addr" class="col-sm-2 col-form-label">addr</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="addr" name="addr">
				</div>
			</div>
			<div class="form-group row">
				<label for="mobile" class="col-sm-2 col-form-label">mobile</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="mobile" name="mobile">
				</div>
			</div>
			<div class="form-group row">				
				<div class="col-sm-10">
					<button type="submit" class="btn btn-primary">입력</button>
					<button type="reset" class="btn btn-danger">취소</button>
				</div>
			</div>
		</form>
	</div>
</div>
<jsp:include page="layout/footer.jsp"></jsp:include>
