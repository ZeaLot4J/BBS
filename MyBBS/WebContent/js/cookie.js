/**
 * @Author ZeaLot
 */
//cookie是多个以分号隔离的键值对字符串

//通过键找值,没有则返回空字符串
function getCookie(cookieName) {
	if (document.cookie.length > 0) {
		var start=document.cookie.indexOf(cookieName + "=");
		if (start!=-1) { 		//如果没有找到 键 ,返回空字符串
			start=start + cookieName.length+1;
	    	var end=document.cookie.indexOf(";",start);
	    	if (end==-1){ 	//如果此键值对是最后一个，则没有";"
	    		end=document.cookie.length;
	    	}
	    		//解码后取出
	    	return unescape(document.cookie.substring(start,end));
		} 
	}
	return "";
}

//设置cookie	     cookie名   对应值    过期时间 单位天
function setCookie(cookieName,value,expireDays) {
	if(getCookie(cookieName) != "")	//如果已存在则覆盖掉
		delCookie(cookieName, "/MyBBS/");
	var expireDate=new Date();
	expireDate.setDate(expireDate.getDate()+expireDays);
									//转码存入cookie
	document.cookie=cookieName+ "=" +escape(value)+((expireDays==null) ? "" : ";expires="+expireDate.toGMTString());
}

//一定要指定cookie所在的项目路径如：/xxx/
function delCookie(cookieName, path){
	var exp = new Date();
	exp.setTime(exp.getTime()-1);
	var cookieValue = getCookie(cookieName);
	if(cookieValue!=null)
		document.cookie = cookieName + "=" + cookieValue + ";expires=" + exp.toGMTString() + ";path=" + path;
}
function checkCookie(cookieName)	//检查用户名
{
	username=getCookie(cookieName);
	if (username!=null && username!="") {
		return true;
	}
	return false;
}