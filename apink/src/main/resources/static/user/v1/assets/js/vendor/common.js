	logout = function () {

	$.ajax({
		async: true 
		,cache: false
		,type: "post"
		,url: "/logoutUser"
		,success: function(response) {
			if(response.rt == "success") {
				location.href = "/indexUser";
			} else {
				alert("로그아웃 실패.");
			}
		}
		,error : function(jqXHR, textStatus, errorThrown){
			alert("ajaxUpdate " + jqXHR.textStatus + " : " + jqXHR.errorThrown);
		}
	});
}