/**
 * 页面选项卡组件
 * @author JZY
 * @param aLiList {collection} 选项卡的节点列表
 * @param aDivList {collection} 选项卡内容的节点列表
 * @param evType {string} 事件类型, 可选
 * @param curIndex {number} 当前卡的索引, 可选
 * @param callback {function} 回调函数, 可选
 * @returns null
 * @last modify by: JZY
 */
var tab = (function(){
    var params = {};
    function cutTabStyle(index){
        for( var j = 0 ; j<params.aLiList.length ; j++){
                params.aLiList[j].className = '';
               
       }
    //    console.log(params.aLiList[index])
       params.aLiList[index].className ='selected'
    }


    function cutTabContent(index){
        for(var k = 0 ; k<params.aDivList.length; k++){
            params.aDivList[k].style.display = 'none';
        }
        // console.log(this.index)
        params.aDivList[index].style.display = 'block';
    }

    function bindEvent(){
        for(var i = 0 ; i< params.aLiList.length ; i++){
            params.aLiList[i].index = i;
            params.aLiList[i][params.evType] = function(){
                var  v = this.index;
                // console.log(v)
                cutTabStyle(v);
                cutTabContent(v);
                // 执行回调
                params.callback && params.callback(v);
            }
        }
    }


    
    function setparams(options){

        params.aDivList = options.aDivList;
        params.aLiList = options.aLiList; 
        if (!params.aLiList || !params.aDivList){
            console.error('组件传参有误');
            return;
        }
        // 可选参数 ||
        params.curIndex = options.curIndex || 0;
        // 判断是否越界
        params.curIndex = params.curIndex < 0 ? 0:params.curIndex;
        params.curIndex = params.curIndex > (params.aLiList.length-1) ? (params.aLiList.length-1) : params.curIndex;
        params.evType = options.evType||'onclick';
        params.callback = options.callback||null;
    }

    function install(options){
        setparams(options);
        // console.log(params)
        cutTabStyle(params.curIndex);
        cutTabContent(params.curIndex);
        bindEvent();
        
     }

    return install;
})()