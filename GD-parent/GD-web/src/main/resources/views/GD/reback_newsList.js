layui.use(['form','layer','laydate','table','laytpl','laypage'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        laypage = layui.laypage,
        table = layui.table;
    

    //查看发布的文章
    var tableIns = table.render({
        elem: '#newsList',
        url : '/Publish/getreback',
        /*request: {
            pageName: 1//页码的参数名称，默认：page
            ,limitName: 5 //每页数据量的参数名，默认：limit
          },*/
        cellMinWidth : 95,
        limit : 5,
       // page : true,
        parseData:function(res){
        	return{
        		"code":0,
        		"msg":"",
        		"count":res.length,
        		"data": res
        	}
        },
       // count: res.length,
        height : "full-125",
        limits : [10,15,20,25],
        
        //id : "newsList",
        cols : [[
                 //数据列
                 {type: "checkbox", fixed:"left", width:50},
                 {field: 'pb_id', title: '发布编号', width:100, align:"center"},
                 {field: 'uid', title: '发布人', align:'center'},
                 {field: 'pb_date', title: '发布时间', width:250},
                 {field: 'topic', title: '主题', align:'center'},
                 {field: 'content', title: '内容',  align:'center'},
                 //{field: 'content', title: '内容',  align:'center',templet:"#newsStatus"},
                 {field: 'p_url', title: '图片地址', align:'center'},
                 {field: 'pb_type', title: '帖子类型', align:'center'},
                 {field: 'category', title: '标签', align:'center'},
                 {title: '操作', width:170, templet:'#newsListBar',fixed:"right",align:"center"}
           
        ]]
       
    });

    //完整功能
    //分页
  /*  $.post('/Publish/getpublished',function(data){
        laypage.render({
            elem: 'newsList' //分页容器的id
            ,count: data.length//总页数
            ,limit: 5
            ,skin: '#1E9FFF' //自定义选中色值
            //,skip: true //开启跳页
            ,jump: function(obj, first){
              if(!first){
                layer.msg('第'+ obj.curr +'页', {offset: 'b'});
              }
            }
          });
       
    });*/

    
    //是否置顶
    form.on('switch(newsTop)', function(data){
        var index = layer.msg('修改中，请稍候',{icon: 16,time:false,shade:0.8});
        setTimeout(function(){
            layer.close(index);
            if(data.elem.checked){
                layer.msg("置顶成功！");
            }else{
                layer.msg("取消置顶成功！");
            }
        },500);
    })

    //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
    $(".search_btn").on("click",function(){
        if($(".searchVal").val() != ''){
            table.reload("newsListTable",{
                page: {
                    curr: 1 //重新从第 1 页开始
                },
                where: {
                    key: $(".searchVal").val()  //搜索的关键字
                }
            })
        }else{
            layer.msg("请输入搜索的内容");
        }
    });

    //添加文章
    function addNews(edit){
        var index = layui.layer.open({
            title : "添加文章",
            type : 2,
            content : "newsAdd.html",
            success : function(layero, index){
                var body = layui.layer.getChildFrame('body', index);
                if(edit){
                    body.find(".newsName").val(edit.newsName);
                    body.find(".abstract").val(edit.abstract);
                    body.find(".thumbImg").attr("src",edit.newsImg);
                    body.find("#news_content").val(edit.content);
                    body.find(".newsStatus select").val(edit.newsStatus);
                    body.find(".openness input[name='openness'][title='"+edit.newsLook+"']").prop("checked","checked");
                    body.find(".newsTop input[name='newsTop']").prop("checked",edit.newsTop);
                    form.render();
                }
                setTimeout(function(){
                    layui.layer.tips('点击此处返回文章列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                },500)
            }
        })
        layui.layer.full(index);
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize",function(){
            layui.layer.full(index);
        })
    }
    $(".addNews_btn").click(function(){
        addNews();
    })

    //批量删除
    $(".delAll_btn").click(function(){
        var checkStatus = table.checkStatus('newsListTable'),
            data = checkStatus.data,
            newsId = [];
        if(data.length > 0) {
            for (var i in data) {
                newsId.push(data[i].newsId);
            }
            layer.confirm('确定删除选中的文章？', {icon: 3, title: '提示信息'}, function (index) {
                // $.get("删除文章接口",{
                //     newsId : newsId  //将需要删除的newsId作为参数传入
                // },function(data){
                tableIns.reload();
                layer.close(index);
                // })
            })
        }else{
            layer.msg("请选择需要删除的文章");
        }
    })

    //列表操作
    table.on('tool(newsList)', function(obj){
    	var p_url =  obj.data.p_url;
    	 var pb_id = obj.data.pb_id;
        var layEvent = obj.event,
            data = obj.data;
      
        if(layEvent === 'edit'){ //编辑
           // addNews(data);
        	layer.alert("ok");
        } else if(layEvent === 'del'){ //删除
        	layer.confirm('真的删除行么', function (index) {

                $.ajax({
                    url: "/Publish/deletereback",
                    type: "POST",
                    data: {pb_id: pb_id},
                    dataType: "json",
                    success: function (rebackinfo) {
                    	//alert(rebackinfo.status);
                        if (rebackinfo.status=="success") {
                            //删除这一行
                            obj.del();
                            //关闭弹框
                            layer.close(index);
                            layer.msg("删除成功", {icon: 6});
                            tableIns.reload();
                        }else {
                        	
                            layer.msg("删除失败", {icon: 5});
                            tableIns.reload();
                        }
                    }
                });
                return false;
            });
        } else if(layEvent === 'look'){ //预览
            //layer.alert("此功能需要前台展示，实际开发中传入对应的必要参数进行文章内容页面访问")
        	//console.log(obj.data.category);
        	var category = obj.data.category;
        	if(p_url==null){
        		layer.open({
          	      title: '详情',
          	      type: 1,//content打开的是content里边的内容
          	      shadeClose: true,
          	      shade: false,
          	      area : [ '600px', '500px' ],
          	      maxmin: true, //开启最大化最小化按钮
          	      content: '该信息不存在图片'
          	    });
        	}else{
//        		alert(p_url);
        		 
        		layer.open({
          	      title: '详情',
          	      type: 2,//content打开的是HTML链接
          	      shadeClose: true,
          	      shade: false,
          	      area : [ '600px', '500px' ],
          	      maxmin: true, //开启最大化最小化按钮
          	      content: '/views/GD/img.html?p_url='+p_url
          	    });
        	}
        }
    });
   
   

});