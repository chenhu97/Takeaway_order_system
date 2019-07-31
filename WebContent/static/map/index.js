$(function () {
    // 百度地图API功能
    var map = new BMap.Map("allmap"); // 创建Map实例
    var point = new BMap.Point(116.331398,39.897445);
    map.centerAndZoom(point,12);
    //添加地图类型控件
    var mapType =new BMap.MapTypeControl({
        mapTypes:[
            BMAP_NORMAL_MAP,
            BMAP_HYBRID_MAP
        ]});
    // map.setCurrentCity("北京");          // 设置地图显示的城市 此项是必须设置的
    map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
    map.enableContinuousZoom(false);          //开启连续缩放效果 默认关闭
    map.centerAndZoom(new BMap.Point(116.4035,39.915), 14);
    var bs = map.getBounds();   //获取可视区域
    var bssw = bs.getSouthWest();   //可视区域左下角
    var bsne = bs.getNorthEast();   //可视区域右上角
    alert("当前地图可视范围是：" + bssw.lng + "," + bssw.lat + "到" + bsne.lng + "," + bsne.lat);
    map.centerAndZoom(new BMap.Point(116.404, 39.915), 11);


    var menu = new BMap.ContextMenu();
    var txtMenuItem = [
        {
            text:'标注',
            callback:function(e){    //给地图添加点击事件
                // map.clearOverlays();
                var geoc = new BMap.Geocoder();

                var marker2 = new BMap.Marker(e);  // 创建标注
                map.addOverlay(marker2);              // 将标注添加到地图中
                marker2.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
                marker2.enableDragging();                   //允许拖动
                //alert(e.point.lng + "," + e.point.lat);
                geoc.getLocation(e, function(rs){
                    var addComp = rs.address;
                    var con;
                    con=confirm("当前位置是:"+addComp+"   是否选择成为您的收货地址"); //在页面上弹出对话框
                    if(con==true){
                    	
                        location.href="MemberMain?oper=list&address="+addComp+"";
                    }

                });
                var label = new BMap.Label("右击我就可以删除喔",{offset:new BMap.Size(20,-10)});
                label.setStyle({
                    backgroundColor:"transparent",
                    border:"0px",
                    color : "#fc7034",
                    fontSize : "12px",
                    height : "20px",
                    lineHeight : "20px",
                    fontFamily:"微软雅黑"
                });
                marker2.setLabel(label);
                marker2.addEventListener("rightclick", function () {  //右击标注删除标注
                    map.removeOverlay(marker2);
                });
            }
        },
        {
            text:'放大',
            callback:function(){map.zoomIn()}
        },
        {
            text:'缩小',
            callback:function(){map.zoomOut()}
        },
        {
            text:'测距',
            callback:function(){
                var myDis = new BMapLib.DistanceTool(map);
                myDis.open();
            }
        },

    ];
    for(var i=0; i < txtMenuItem.length; i++){
        menu.addItem(new BMap.MenuItem(txtMenuItem[i].text,txtMenuItem[i].callback,100));
    }
    map.addContextMenu(menu);


    // 关键字搜索
    $("#search2").click(function () {
        var str= $('.search')[0].value;
        var local = new BMap.LocalSearch(map, {
            renderOptions:{map: map}
        });
        local.search(str);
    });

    //绘制模式
    var overlays = [];
    var overlaycomplete = function(e){
        overlays.push(e.overlay);
    };
    var styleOptions = {
        strokeColor:"red",    //边线颜色。
        fillColor:"red",      //填充颜色。当参数为空时，圆形将没有填充效果。
        strokeWeight: 3,       //边线的宽度，以像素为单位。
        strokeOpacity: 0.8,	   //边线透明度，取值范围0 - 1。
        fillOpacity: 0.6,      //填充的透明度，取值范围0 - 1。
        strokeStyle: 'solid' //边线的样式，solid或dashed。
    };
    var drawingManager = new BMapLib.DrawingManager(map, {
        isOpen: false, //是否开启绘制模式
        enableDrawingTool: true, //是否显示工具栏
        drawingToolOptions: {
            anchor: BMAP_ANCHOR_TOP_RIGHT, //位置
            offset: new BMap.Size(20, 50), //偏离值

            drawingModes : [BMAP_DRAWING_POLYLINE,BMAP_DRAWING_RECTANGLE,BMAP_DRAWING_CIRCLE,BMAP_DRAWING_POLYGON], //设置只显示画矩形、圆的模式

            drawingTypes : [
                BMAP_DRAWING_MARKER,//点的样式
                BMAP_DRAWING_CIRCLE,//圆的样式
                BMAP_DRAWING_POLYLINE,//线的样式
                BMAP_DRAWING_POLYGON,//多边形的样式
                BMAP_DRAWING_RECTANGLE //矩形的样式
            ]
        },
        circleOptions: styleOptions, //圆的样式
        polylineOptions: styleOptions, //线的样式
        polygonOptions: styleOptions, //多边形的样式
        rectangleOptions: styleOptions //矩形的样式
    });
    drawingManager.addEventListener('overlaycomplete', overlaycomplete);
    $("#clear").click(function () {
        for(var i = 0; i < overlays.length; i++){
            map.removeOverlay(overlays[i]);
        }
        overlays.length = 0;
    });




    // 地图文本注释
    /*
    var opts = {
        position : point,    // 指定文本标注所在的地理位置
        offset   : new BMap.Size(0, 10)    //设置文本偏移量
    };
    var label = new BMap.Label("jiangjiang~", opts);  // 创建文本标注对象
    label.setStyle({
        color : "red",
        fontSize : "12px",
        height : "20px",
        lineHeight : "20px",
        fontFamily:"微软雅黑"
    });
    map.addOverlay(label);
    */
    var size = new BMap.Size(100, 10);
    var size1 = new BMap.Size(120, 50);
    var size2 = new BMap.Size(10, 50);
    var size3 = new BMap.Size(10, 150);
    var cityListControl =new BMap.CityListControl({     //切换城市控件
        anchor: BMAP_ANCHOR_TOP_LEFT,
        offset: size,
        // 切换城市之间事件
        // onChangeBefore: function(){
        //    alert('before');
        // },
        // 切换城市之后事件
        // onChangeAfter:function(){
        //   alert('after');
        // }
    });
    var ctrl = new BMapLib.TrafficControl({            //路况信息控件
        showPanel: false,        //是否显示路况提示面板
    });
    ctrl.setAnchor(BMAP_ANCHOR_TOP_LEFT);
    // ctrl.setOffset(offset,new BMap.Size(20,-10));
    //ctrl.defaultOffset = new BMap.Size(rem * 0.16, rem * 0.2);
    var overView = new BMap.OverviewMapControl();
    var overViewOpen = new BMap.OverviewMapControl({isOpen:true, anchor: BMAP_ANCHOR_BOTTOM_RIGHT});
    var top_left_control = new BMap.ScaleControl({anchor: BMAP_ANCHOR_BOTTOM_LEFT, offset: size1});// 左上角，添加比例尺
    var top_left_navigation = new BMap.NavigationControl({anchor: BMAP_ANCHOR_TOP_LEFT, offset: size3});  //左上角，添加默认缩放平移控件
    /*缩放控件type有四种类型:
    BMAP_NAVIGATION_CONTROL_SMALL：仅包含平移和缩放按钮；BMAP_NAVIGATION_CONTROL_PAN:仅包含平移按钮；BMAP_NAVIGATION_CONTROL_ZOOM：仅包含缩放按钮*/

    // 添加定位控件
    var geolocationControl = new BMap.GeolocationControl({offset: size2});
    geolocationControl.addEventListener("locationSuccess", function(e){    //切换事件
        // 定位成功事件
        var address = '';
        address += e.addressComponent.province;
        address += e.addressComponent.city;
        address += e.addressComponent.district;
        address += e.addressComponent.street;
        address += e.addressComponent.streetNumber;
        alert("当前定位地址为：" + address);
    });
    geolocationControl.addEventListener("locationError",function(e){
        // 定位失败事件
        alert(e.message);
    });
    //添加控件和比例尺
    $("#open").click(function () {
        map.addControl(mapType);
        map.addControl(top_left_control);
        map.addControl(top_left_navigation);
        map.addControl(overView);          //添加默认缩略地图控件
        map.addControl(overViewOpen);      //右下角，打开
        map.addControl(geolocationControl); //定位控件
        map.addControl(cityListControl); //添加城市切换控件
        map.addControl(ctrl);           //添加路况信息控件
    });
    //清除控件
    $("#close").click(function () {
        map.removeControl(mapType);
        map.removeControl(top_left_control);
        map.removeControl(top_left_navigation);
        map.removeControl(overView);
        map.removeControl(overViewOpen);
        map.removeControl(geolocationControl);
        map.removeControl(cityListControl);
        map.removeControl(ctrl);
    });
});


