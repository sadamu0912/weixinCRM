function setCookie(name, value) {
var Days = 30;
var exp = new Date();
exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
document. cookie = name +  + escape(value) + ";expires=" + exp.toGMTString();
}


/**
 * 讲表单序列化城对象  如果是checkbox的话，选中多个，一个name，就对应一个数组
 * @param arr
 * @param o
 * @returns
 */
function serializeFrom (arr , o){
	$(arr).each(function (index, el) {
	if(o[el.name]==undefined ||o[el.name]== ""){
		o[el.name] = el.value;
	}else{
		if(o[el.name].constructor.name=="String"){
			var array = new Array();
			array.push(o[el.name]);
			array.push(el.value);
			o[el.name]= array;
		}else{
			console.log(o[el.name].constructor.name);
			var array = new Array();
			for(var i=0;i<o[el.name].length;i++){
			array.push(o[el.name][i]);
			}
			array.push(el.value);
			o[el.name]= array;
		}
	}
	})
}

function loadFun(url){
	var oHead = document.getElementsByTagName('HEAD').item(0); 
	var oScript= document.createElement("script"); 
	oScript.type = "text/javascript"; 
	oScript.src=url; 
	oHead.appendChild( oScript); 
}
/**
 * ajax方法 封装
 */
var httpHelper = {
		'save':function (data,requestUrl,successcb,errorcb)  { 
		this.server(requestUrl.save, "POST", data, successcb, errorcb);
		},
		'delete':function (data,requestUrl,successcb,errorcb) {
		this.server(requestUrl.save, "DELETE", data, successcb, errorcb);
		},
		'update': function (data, requestUrl, successcb, errorcb) {
		this.server(requestUrl.save, "PUT", data, successcb, errorcb);
		},
		'get': function (data, requestUrl, successcb, errorcb) {
		this.server(requestUrl.get, "GET", data, successcb, errorcb);
		},
		'getAll' : function (data, requestUrl, successcb, errorcb) {
		this.server(requestUrl.getAll, "GET", data, successcb, errorcb);
		},
		'server': function (requestUrl, type, arg, successcb, errorcb) {
			var data;
			if (!type) type = "GET";
			if (type.toUpperCase() == 'GET') {
			data = arg;
			} else {
			data = JSON.stringify(arg);
			}
			$.ajax({
			url: requestUrl,
			type: type,
			contentType: "application/json;charset=utf-8",
			data: data,
			})
			.done(function (result) {
			successcb && successcb(result);
			})
			.fail(function (xhn) {
			errorcb && errorcb(xhr);
			});
		}
	}
		
		
		
		
		
		
		