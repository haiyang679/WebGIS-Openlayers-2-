//表格
var Table_shuiqing;
var Table_taifeng;
var Table_yqYlxx;
var Table_yqGszdyl;
var Table_yqLjtj;
//查询的数据信息
var sqsk_InfoArray;
var sqhl_InfoArray;
var Ssyq_InfoArray;
var tfPathInfo;
//地图对象
var map;
//图层组
var LayerArr;
//矢量、影像、地形图层
var vecLayer, imgLayer, terLayer;
//注记图层
var vecZjLayer, imgZjLayer, terZjLayer;
//popup元素
var PopopOverlay;
var popupElement;
var popupClose;
//查询雨量为100的数据
var minRain = 50;
var maxRain = 99.91;
var times = "2008-05-16";
var timee = "2008-05-16";
var timeS = " 08:00:00";
var timeE = " 17:00:00";
var s = times + timeS;
var e = timee + timeE;
var mydata;
var myChart;
var movetype;
//鼠标选中的前一要素
var preFeature = null;  

/**
* 初始化函数
* @author zjh 2018-08-23
*/
function init() {
    //地图中心点
    var center = [12308196.042592192, 2719935.2144997073];
    //获取图层（天地图）
    addBaseLayer();
    //创建地图对象
    map = new ol.Map({
        //添加图层
        layers: [vecLayer, vecZjLayer],
        //目标DIV
        target: 'map',
        view: new ol.View({
            //投影坐标系
            projection: ol.proj.get('EPSG:3857'), 
            center: center,
            maxZoom: 16,
            minZoom: 2,
            zoom: 6
        })
    });

    /**
    * 为map添加点击事件监听，渲染弹出popup
    */
    map.on('singleclick', function (evt) {
        var coordinate = evt.coordinate;
        //判断当前单击处是否有要素，捕获到要素时弹出popup
        var feature1 = map.forEachFeatureAtPixel(evt.pixel, function (feature, layer) { return feature; });
        if (feature1) {
            var type = feature1.get('type');
            var info = feature1.get('info');
            //console.log(feature1.get('info'));
            //console.log(feature1.get('info').length);
            if (type == "river") {
                //水情-河流 Popup
                showSssqPopup(info, "river");
            }
            if (type == "shuiku") {
                //水情-河流 Rver
                showSssqPopup(info, "shuiku");
            }
            if (type == "sq") {
                //为雨情要素点添加popup的信息内容
                showSsyqPopup(info);
            }
            if (type == "typhoon") {
                //台风popup
                showTfljPopup(info);
            }
            else {
                return;
            }
        }
    });

    /**
    * 为map添加move事件监听，变更图标大小实现选中要素的动态效果
    */
    map.on('pointermove', function (evt) {
        var pixel = map.getEventPixel(evt.originalEvent);
        var hit = map.hasFeatureAtPixel(pixel);
        map.getTargetElement().style.cursor = hit ? 'pointer' : '';

        var coordinate = evt.coordinate;
        //判断当前鼠标悬停位置处是否有要素，捕获到要素时设置图标样式
        var feature = map.forEachFeatureAtPixel(evt.pixel, function (feature, layer) { return feature; });
        
        if (feature) {

            movetype = feature.get('type');
            if ((movetype == undefined) || (movetype == "tfMarker") || (movetype == "tfCircle")) {
                return;
            }
            //鼠标移动到台风标注时，显示tooltip
            if (movetype == "typhoon") {
                var info = feature.get('info');
                showTfljPopup(info);
            }
            if ((preFeature != null) && (preFeature !== feature)) { //如果当前选中要素与前一选中要素不同，恢复前一要素样式，放大当前要素图标
                var curImgURL = feature.get('imgURL');
                var preImgURL = preFeature.get('imgURL');
                feature.setStyle(createLabelStyle(feature, curImgURL, 1.2));
                preFeature.setStyle(createLabelStyle(preFeature, preImgURL, 0.8));
                preFeature = feature;
            }
            if (preFeature == null) { //如果前一选中要素为空，即当前选中要素为首次选中要素，放大当前要素图标
                var curImgURL = feature.get('imgURL');
                feature.setStyle(createLabelStyle(feature, curImgURL, 1.2));
                preFeature = feature;
            }
        }
        else {
            if (preFeature != null) { //如果鼠标移出前一要素，恢复要素图标样式
                var imgURL = preFeature.get('imgURL');
                preFeature.setStyle(createLabelStyle(preFeature, imgURL, 0.8));
                preFeature = null;
                if (movetype == "typhoon") {
                    PopopOverlay.setPosition(undefined);
                }
            }
        }
    });

    //获取popup的容器
    container = document.getElementById('popup');
    //在地图容器中创建一个Overlay
    PopopOverlay = new ol.Overlay(({
        element: container,
        autoPan: true
    }));
    map.addOverlay(PopopOverlay);

    popupClose = $("#popup-closer");
    /**
    * 添加关闭按钮的单击事件（隐藏popup）
    * @return {boolean} Don't follow the href.
    */
    popupClose.bind("click", function () {
        PopopOverlay.setPosition(undefined);  //未定义popup位置
        popupClose.blur(); //失去焦点

    });

    // 初始化卫星云图对话框
    $("#dialog").dialog({
        modal: true,  // 创建模式对话框
        autoOpen: false, //默认隐藏对话框
        height: 590,
        width: 920,
        minWidth: 920,
        minHeight: 590,
        open: function (event, ui) {
            $("#wxytIframe").attr("src", "newYunTu.htm"); //打开对话框时加载卫星云图功能页面
        }
        ,
        close: function (event, ui) {
            $('#wxyt').attr('checked', false); //关闭对话框时不选中【卫星云图】功能项
        }
    });
    //给卫星云图添加关闭按钮的样式
    $(".ui-dialog-titlebar-close").addClass("ui-button");
    $(".ui-dialog-titlebar-close").addClass("ui-widget");
    $(".ui-dialog-titlebar-close").addClass("ui-state-default");
    $(".ui-dialog-titlebar-close").addClass("ui-corner-all");
    $(".ui-dialog-titlebar-close").addClass("ui-button-icon-only");
    $(".ui-dialog-titlebar-close").append('<span class="ui-button-icon-primary ui-icon ui-icon-closethick"></span>');

    /*
        加载广西壮族自治区边界线
     */
    //定义坐标数组
    var finaldots = new Array();
    //获取图形边界范围
    //boundary就是一系列经纬度坐标，格式为（经度 纬度,经度 纬度）  注意空格
    var result = boundary.split(",");   //result就是由[[经度 维度],[经度 维度]]的数组
    for (var i = 0; i < result.length; i++) {
        //按照空格分隔字符串
        var dot = result[i].split(" ");  //dot就是每个[经度,纬度]
        var mktdot = lonLat2Mercator(parseFloat(dot[0]), parseFloat(dot[1]));
        //将坐标存入结果数组
        finaldots.push([mktdot.x, mktdot.y]);   //格式为[[x,y],[x,y]]
    }
   
    //创建边界
    var Polygon = new ol.Feature({
        geometry: new ol.geom.Polygon([finaldots])
    });
    //设置区样式信息
    Polygon.setStyle(new ol.style.Style({
        //边线颜色
        stroke: new ol.style.Stroke({
            color: '#ffcc33',
            width: 2
        }),
        //形状
        image: new ol.style.Circle({
            radius: 700,
            fill: new ol.style.Fill({
                color: '#ffcc33'
            })
        })
    }));

    //实例化一个矢量图层Vector作为绘制层
    var source = new ol.source.Vector({
        features: [Polygon]
    });
    //创建一个图层
    var vector = new ol.layer.Vector({
        source: source
    });
    //将绘制层添加到地图容器中
    map.addLayer(vector);

    //初始化水库table
    var oTable_sk = new Table_shuiqing("tb_shuiku");
    oTable_sk.Init();
    //初始化河流table
    var oTable_hl = new Table_shuiqing("tb_heliu");
    oTable_hl.Init();
   
    //初始化雨情-雨量信息table
    var oTable_ylxx = new Table_yqYlxx();
    oTable_ylxx.Init();
    //初始化雨情-最大雨量table
    var oTable_gszdyl = new Table_yqGszdyl();
    oTable_gszdyl.Init();
    //初始化雨情-雨量统计table
    var oTable_ljtj = new Table_yqLjtj();
    oTable_ljtj.Init();

    //初始化台风基本信息table
    var oTable_tf = new Table_taifeng();
    oTable_tf.Init();
    //初始化台风详细路径table
    var oTable_tflj = new Table_taifenglujing();
    oTable_tflj.Init();
}

/**
* 判断是否为低版本ie浏览器
* @author zjh 2018-08-23
*/
function isIE() {
    if (!!window.ActiveXObject || "ActiveXObject" in window)
        return true;
    else
        return false;
}

/**
* WGS-84 转 web墨卡托，主要用于将坐标单位为度的值转为单位为米的值
* @param {double} lon 经度
* @param {double} lat 纬度
* @author zjh 2018-08-23
*/
function lonLat2Mercator(lon, lat) {
    var x = lon * 20037508.34 / 180;
    var y = Math.log(Math.tan((90 + lat) * Math.PI / 360)) / Math.PI * 20037508.34;
    y = Math.max(-20037508.34, Math.min(y, 20037508.34));
    return { 'x': x, 'y': y };
}

/**
* web墨卡托 转 WGS-84，主要用于将坐标单位为米的值转为单位为度的值
* @param {double} mercatorX X坐标
* @param {double} mercatorY Y坐标
* @author zjh 2018-08-23
*/
function mercator2LonLat(mercatorX, mercatorY) {
    var lon = mercatorX * 180 / 20037508.34;
    var lat = 180 / Math.PI * (2 * Math.atan(Math.exp((mercatorY / 20037508.34) * Math.PI)) - Math.PI / 2);
    return { 'x': lon, 'y': lat };
}

/*
* 根据基地址创建天地图图层
* @param {string} baseurl 天地图图层基地址
* @author zjh 2019-01-16
*/
function CreteTDTLayer(baseurl) {
    //初始化天地图矢量图层
    var layer = new ol.layer.Tile({
        //设置图层透明度
        opacity: 1,
        //数据源
        source: new ol.source.XYZ({
            url: baseurl
        })
    })
    //返回layer
    return layer;
}

/*
* 加载天地图图层
* @author zjh 2019-01-16
*/
function addBaseLayer() {
    //矢量图层
    vecLayer = CreteTDTLayer("http://t0.tianditu.com/DataServer?T=vec_w&x={x}&y={y}&l={z}&tk=b74ca9a5dbd96fab6338ab9d239180fb");
    //影像图层
    imgLayer = CreteTDTLayer("http://t0.tianditu.com/DataServer?T=img_w&x={x}&y={y}&l={z}&tk=b74ca9a5dbd96fab6338ab9d239180fb");
    //地形图层
    terLayer = CreteTDTLayer("http://t0.tianditu.com/DataServer?T=ter_w&x={x}&y={y}&l={z}&tk=b74ca9a5dbd96fab6338ab9d239180fb");
    //矢量注记图层
    vecZjLayer = CreteTDTLayer("http://t0.tianditu.com/DataServer?T=cva_w&x={x}&y={y}&l={z}&tk=b74ca9a5dbd96fab6338ab9d239180fb");
    //影像注记图层
    imgZjLayer = CreteTDTLayer("http://t0.tianditu.com/DataServer?T=cia_w&x={x}&y={y}&l={z}&tk=b74ca9a5dbd96fab6338ab9d239180fb");
    //地形注记图层
    terZjLayer = CreteTDTLayer("http://t0.tianditu.com/DataServer?T=cta_w&x={x}&y={y}&l={z}&tk=b74ca9a5dbd96fab6338ab9d239180fb");
    //图层组
    LayerArr = [vecLayer, imgLayer, terLayer, vecZjLayer, imgZjLayer, terZjLayer];
}


