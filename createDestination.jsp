<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/magenda.css">
<title>宛先情報入力</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="contents">
		<h1>宛先情報入力画面</h1>
		<s:if test="!#session.familyNameErrorMessageList.isEmpty()">
			<div class="error">
				<div class="error-message">
					<s:iterator value="#session.familyNameErrorMessageList">
						<s:property />
						<br>
					</s:iterator>
				</div>
			</div>
		</s:if>
		<s:if test="!#session.firstNameErrorMessageList.isEmpty()">
			<div class="error">
				<div class="error-message">
					<s:iterator value="#session.firstNameErrorMessageList">
						<s:property />
						<br>
					</s:iterator>
				</div>
			</div>
		</s:if>
		<s:if test="!#session.familyNameKanaErrorMessageList.isEmpty()">
			<div class="error">
				<div class="error-message">
					<s:iterator value="#session.familyNameKanaErrorMessageList">
						<s:property />
						<br>
					</s:iterator>
				</div>
			</div>
		</s:if>
		<s:if test="!#session.firstNameKanaErrorMessageList.isEmpty()">
			<div class="error">
				<div class="error-message">
					<s:iterator value="#session.firstNameKanaErrorMessageList">
						<s:property />
						<br>
					</s:iterator>
				</div>
			</div>
		</s:if>
		<s:if test="!#session.userAddressErrorMessageList.isEmpty()">
			<div class="error">
				<div class="error-message">
					<s:iterator value="#session.userAddressErrorMessageList">
						<s:property />
						<br>
					</s:iterator>
				</div>
			</div>
		</s:if>
		<s:if test="!#session.telNumberErrorMessageList.isEmpty()">
			<div class="error">
				<div class="error-message">
					<s:iterator value="#session.telNumberErrorMessageList">
						<s:property />
						<br>
					</s:iterator>
				</div>
			</div>
		</s:if>
		<s:if test="!#session.emailErrorMessageList.isEmpty()">
			<div class="error">
				<div class="error-message">
					<s:iterator value="#session.emailErrorMessageList">
						<s:property />
						<br>
					</s:iterator>
				</div>
			</div>
		</s:if>
		<s:form action="CreateDestinationConfirmAction">
			<table class="vertical-list-table">

				<tr>
					<th scope="row"><s:label value="姓" /></th>
					<td><s:textfield name="familyName" value="%{#session.familyName}" class="txt" placeholder="姓" /></td>
				</tr>

				<tr>
					<th scope="row"><s:label value="名" /></th>
					<td><s:textfield name="firstName" value="%{#session.firstName}" class="txt" placeholder="名" /></td>
				</tr>

				<tr>
					<th scope="row"><s:label value="姓ふりがな" /></th>
					<td><s:textfield name="familyNameKana" value="%{#session.familyNameKana}" class="txt" placeholder="姓ふりがな"/></td>
				</tr>

				<tr>
					<th scope="row"><s:label value="名ふりがな" /></th>
					<td><s:textfield name="firstNameKana" value="%{#session.firstNameKana}" class="txt" placeholder="名ふりがな"/></td>
				</tr>
				<tr>
					<th scope="row"><s:label value="住所" /></th>
					<td><s:textfield name="userAddress" value="%{#session.userAddress}" class="txt" placeholder="住所"/></td>
				</tr>

				<tr>
					<th scope="row"><s:label value="電話番号" /></th>
					<td><s:textfield name="telNumber" value="%{#session.telNumber}" class="txt" placeholder="電話番号"/></td>
				</tr>

				<tr>
					<th scope="row"><s:label value="メールアドレス" /></th>
					<td><s:textfield name="email" value="%{#session.email}" class="txt" placeholder="メールアドレス"/></td>
				</tr>
			</table>
			<div class="submit_btn_box">
					<s:submit value="確認" class="submit_btn" />
			</div>
		</s:form>
	</div>
</body>
</html>