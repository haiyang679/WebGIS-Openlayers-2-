# DrawAndModifyFeatures

本次例子使用两个api

ol/interaction/Draw和ol/interaction/Modify

## (1)ol/interaction/Modify

使用`ol/interaction/Modify`对象可以修改已经添加到图层上的几何图形，使用起来很简单，首先创建一个`Modify`对象，然后再使用`Map`的`addInteraction`方法添加该对象，然后将鼠标移动到已经绘制好的线条或点上面，再移动鼠标，可以对图形进行修改。按住`Alt`键时，再点击鼠标，可以删除选中的点。

eg:

```javascript
var modify = new ol.interaction.Modify({
            source:sourse
        })
map.addInteraction(modify)
```

其他属性：

**condition**：设置一个函数，在修改时监听点击事件，返回一个布尔值表示是否处理该点击事件。比如返回`false`时，选中点后，点击选中的点再移动鼠标时将不处理移动事件。

**deleteCondition**：设置一个函数，返回一个布尔值是否执行删除的操作。

**insertVertexCondition**：设置一个函数，返回一个布尔值表示是否添加新的点。比如我们在编辑多边形时，点击多边形上的线条时，默认是可以在点击的位置添加一个点。如果返回值为`false`，不会添加新的坐标点。

**pixelTolerance**：设置捕捉点的像素差，如果设置的很大，离坐标点很远也能捕捉到点，默认值 为`10px`。

方法:

**removePoint**：删除当前正编辑的点。

事件：

**modifystart**：编辑开始时触发。

**modifyend**：编辑结束时触发。

## (2)ol/interaction/Draw

用来绘制图形的api，其中默认的type类型有

![Draw中的type](E:\openlayes\MygithubOpenlayers\WebGIS-Openlayers-2-\8.OpenlayersExamples\2.DrawAndModifyFeatures\images\Draw中的type.png)

最终代码：

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Draw and Modify Features</title>
    <style>
        .map {
            width: 100%;
            height:100%;
        }
    </style>
    <link href="css/ol.css" type="text/css">
    <script src="js/ol.js" type="text/javascript"></script>
</head>
<body>
<div id="map" class="map"></div>
<form>
    <label>Geometry type &nbsp;</label>
    <select id="type"><!--单选框-->
        <option value="Point">Point</option>
        <option value="LineString">LineString</option>
        <option value="Polygon">Polygon</option>
        <option value="Circle">Circle</option>
    </select>
</form>
<script type="text/javascript">
    /*底图*/
    var raster = new ol.layer.Tile({
        source:new ol.source.OSM()
    });

    /*绘制图形的新的矢量图层*/
    var source = new ol.source.Vector();

    var vector = new ol.layer.Vector({
        source: source,
        style: new ol.style.Style({
            fill: new ol.style.Fill({   //填充样式
                color: 'rgba(255, 255, 255, 0.2)',   //填充颜色  均为255，为白色
            }),
            stroke: new ol.style.Stroke({  //边界样式
                color: '#DC143C',
                width: 22,   //边界宽度
            }),
            image: new ol.style.Circle({    //点样式
                radius: 20,  //点的半径
                fill: new ol.style.Fill({   //点里的填充
                    color: '#DC143C',
                }),
            }),
        }),
    });

    var map = new ol.Map({
        layers: [raster, vector],
        target: 'map',
        view: new ol.View({
            center: [-11000000, 4600000],
            zoom: 4,
        }),
    });

    var modify = new ol.interaction.Modify({
        source:source
    });
    map.addInteraction(modify);

    var draw, snap; // global so we can remove them later
    var typeSelect = document.getElementById('type');

    function addInteractions() {
        draw = new ol.interaction.Draw({
            source: source,
            type: typeSelect.value,
        });
        map.addInteraction(draw);
        snap = new ol.interaction.Snap({
            source: source
        });
        map.addInteraction(snap);
    }
    /**
     * Handle change event.
     */
    typeSelect.onchange = function () {
        map.removeInteraction(draw);
        map.removeInteraction(snap);
        addInteractions();
    };
    addInteractions();
</script>
</body>
</html>
```



