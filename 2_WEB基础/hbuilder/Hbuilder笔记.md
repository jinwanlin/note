获取登录用户

```
let relationUser = JSON.parse(localStorage.getItem("aUser")); //当前用户登录信息
relationUser.mobilePhone
relationUser.userType
relationUser.uuid
appUserId=relationUser.id
```

## Ajax

```
mui.ajax(url, {
		data: dataGE100,
		dataType: 'json',
		type: 'post',
		timeout: 15000,
		crossDomain: true,
		beforeSend: function() {},
		complete: function() {
			plus.nativeUI.closeWaiting();
		},
		success: function(result) {
			if (result.code == 200 && result.obj != "") {
				var obj = result.obj;
				var jsonObj = JSON.parse(obj); //转换为json对象
			} else {
				getRecordsdataLT100(); // 小于100
			}

		}
	});
```

## 事件绑定

事件绑定, 页面先有dom节点还是后有都能生效

```
mui(".mui-table-view").on('tap','.mui-table-view-cell',function(){
  //获取id
  var id = this.getAttribute("id");
  //传值给详情页面，通知加载新数据
  mui.fire(detail,'getDetail',{id:id});
  //打开新闻详情
  mui.openWindow({
    id:'detail',
    url:'detail.html'
  });
}) 



```

​	传统事件绑定, 需要页面先有dom才能生效

```
document.getElementById("allRead").addEventListener("tap",function () {

});
```



