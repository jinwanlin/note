
##wx.request

	wx.request({
      url: baseUrl+'/book/list',
      data: {
      
      },
      success: function(res){
        console.info(res.data.list);
        that.setData({
            list:res.data.list
        })
      },
      complete:function(){
      }
    })

##wx:for
<view wx:for="{{array}}" wx:for-index="idx" wx:for-item="itemName">
  {{idx}}: {{itemName.message}}
</view>




##点击打开详情页面

	点击事件，获取当前ID
	e.currentTarget.dataset.id;

	跳转
	wx.navigateTo({
	  url: '../goodsDetail/goodsDetail?goods='+JSON.stringify(goods)
	})


	在详情页面接收参数
	onLoad: function(option){

	    if(option.fromMiniProgram){
	      var data = JSON.parse(option.goods);  
	    }

	}



##数组合并
	var str3 = str1.concat(str2);
##json 转 字符串
	var str = JSON.stringify(json);
##字符串 转 json
	var json=JSON.parse(orderGoodsExtra);

#存储
##	写入
		
		wx.setStorage({
		  key:"uname",
		  data:that.data.name
		})

		wx.setStorageSync("uname", that.data.name );
##	读取
		wx.getStorage('xxxxx')
		wx.getStorageSync('xxxxx')
##	清理
		wx.clearStorage
		wx.clearStorageSync
		wx.removeStorage
		wx.removeStorageSync



