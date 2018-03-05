function submitForm(formName, u) {
	var f = '#' + formName;
	debugger;
	$(f).form({
		url : u,
		onSubmit : function() {
			debugger;
			return $(this).form('validate');
		},
		success : function(data) {
			debugger;
			$.messager.alert('Info', data, 'info');
		}
	});
}
function checkValidator(formName) {
	var f = '#' + formName;
	debugger;
	var isValid = $(f).form('enableValidation').form('validate');
	return isValid;
}

function validate(id) {
	var validate = $("#" + id).form('validate');
	if (!validate) {
		$.messager.alert("确认", '请正确填写表单！', "", function() {
			$("#" + id).find(".validatebox-invalid:first").focus();
		});
		return false;
	}
	return true;
}

function checkByParamForAJAX(paraName, checkWidgetName, url1, destWidgetName) {
	var pName = '+paraName+';
	var paraValue = $("#" + checkWidgetName).val();

	$.ajax({
		url : "" + url1 + "?time="
				+ new Date().getTime() + "&" + paraName + "=" + paraValue,
		type : "get",
		// data:{"username":paraValue},
		contentType : "application/json;charset=utf-8",
		dataType : "json",
		success : function(data) {
			var jsons = data.message;
			$("#" + destWidgetName).html(jsons);
		}
	});
}