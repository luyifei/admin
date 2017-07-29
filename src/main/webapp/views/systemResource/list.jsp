<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib tagdir="/WEB-INF/tags/simpletable" prefix="simpletable"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
    <head>
    <base href="<%=basePath%>">
    <!-- jsp文件头和头部 -->
    <%@ include file="/views/system/admin/base.jsp"%> 
    </head> 
<body>
        
<div class="main-container ace-save-state" id="main-container">
<table style="width:100%;" border="0">
    <tbody>
	    <tr>
	        <td style="width:15%;" valign="top" bgcolor="#F9F9F9">
	            <div style="width:15%;">
	                <ul id="leftTree" class="ztree"><li id="leftTree_1" class="level0" tabindex="0" hidefocus="true" treenode=""><span id="leftTree_1_switch" title="" class="button level0 switch roots_close" treenode_switch=""></span><a id="leftTree_1_a" class="level0" treenode_a="" onclick="" target="_blank" style="" title="父节点1 - 展开"><span id="leftTree_1_ico" title="" treenode_ico="" class="button ico_close" style="width:0px;height:0px;"></span><span id="leftTree_1_span">父节点1 - 展开</span></a><ul id="leftTree_1_ul" class="level0 line" style="display: none;"><li id="leftTree_2" class="level1" tabindex="0" hidefocus="true" treenode=""><span id="leftTree_2_switch" title="" class="button level1 switch center_close" treenode_switch=""></span><a id="leftTree_2_a" class="level1" treenode_a="" onclick="" target="_blank" style="" title="父节点11 - 折叠"><span id="leftTree_2_ico" title="" treenode_ico="" class="button ico_close" style="width:0px;height:0px;"></span><span id="leftTree_2_span">父节点11 - 折叠</span></a></li><li id="leftTree_10" class="level1" tabindex="0" hidefocus="true" treenode=""><span id="leftTree_10_switch" title="" class="button level1 switch center_close" treenode_switch=""></span><a id="leftTree_10_a" class="level1" treenode_a="" onclick="" href="http://www.so.com/" target="treeFrame" style="" title="父节点12 - 折叠"><span id="leftTree_10_ico" title="" treenode_ico="" class="button ico_close" style="width:0px;height:0px;"></span><span id="leftTree_10_span">父节点12 - 折叠</span></a></li><li id="leftTree_15" class="level1" tabindex="0" hidefocus="true" treenode=""><span id="leftTree_15_switch" title="" class="button level1 switch bottom_close" treenode_switch=""></span><a id="leftTree_15_a" class="level1" treenode_a="" onclick="" target="_blank" style="" title="父节点13 - 没有子节点"><span id="leftTree_15_ico" title="" treenode_ico="" class="button ico_close" style="width:0px;height:0px;"></span><span id="leftTree_15_span">父节点13 - 没有子节点</span></a></li></ul></li><li id="leftTree_16" class="level0" tabindex="0" hidefocus="true" treenode=""><span id="leftTree_16_switch" title="" class="button level0 switch center_close" treenode_switch=""></span><a id="leftTree_16_a" class="level0" treenode_a="" onclick="" target="_blank" style="" title="父节点2 - 折叠"><span id="leftTree_16_ico" title="" treenode_ico="" class="button ico_close" style="width:0px;height:0px;"></span><span id="leftTree_16_span">父节点2 - 折叠</span></a><ul id="leftTree_16_ul" class="level0 line" style="display: none;"><li id="leftTree_17" class="level1" tabindex="0" hidefocus="true" treenode=""><span id="leftTree_17_switch" title="" class="button level1 switch center_close" treenode_switch=""></span><a id="leftTree_17_a" class="level1" treenode_a="" onclick="" target="_blank" style="" title="父节点21 - 展开"><span id="leftTree_17_ico" title="" treenode_ico="" class="button ico_close" style="width:0px;height:0px;"></span><span id="leftTree_17_span">父节点21 - 展开</span></a><ul id="leftTree_17_ul" class="level1 line" style="display: none;"><li id="leftTree_18" class="level2" tabindex="0" hidefocus="true" treenode=""><span id="leftTree_18_switch" title="" class="button level2 switch center_docu" treenode_switch=""></span><a id="leftTree_18_a" class="level2" treenode_a="" onclick="" target="_blank" style="" title="叶子节点211"><span id="leftTree_18_ico" title="" treenode_ico="" class="button ico_docu" style=""></span><span id="leftTree_18_span">叶子节点211</span></a></li><li id="leftTree_19" class="level2" tabindex="0" hidefocus="true" treenode=""><span id="leftTree_19_switch" title="" class="button level2 switch center_docu" treenode_switch=""></span><a id="leftTree_19_a" class="level2" treenode_a="" onclick="" target="_blank" style="" title="叶子节点212"><span id="leftTree_19_ico" title="" treenode_ico="" class="button ico_docu" style=""></span><span id="leftTree_19_span">叶子节点212</span></a></li><li id="leftTree_20" class="level2" tabindex="0" hidefocus="true" treenode=""><span id="leftTree_20_switch" title="" class="button level2 switch center_docu" treenode_switch=""></span><a id="leftTree_20_a" class="level2" treenode_a="" onclick="" target="_blank" style="" title="叶子节点213"><span id="leftTree_20_ico" title="" treenode_ico="" class="button ico_docu" style=""></span><span id="leftTree_20_span">叶子节点213</span></a></li><li id="leftTree_21" class="level2" tabindex="0" hidefocus="true" treenode=""><span id="leftTree_21_switch" title="" class="button level2 switch bottom_docu" treenode_switch=""></span><a id="leftTree_21_a" class="level2" treenode_a="" onclick="" target="_blank" style="" title="叶子节点214"><span id="leftTree_21_ico" title="" treenode_ico="" class="button ico_docu" style=""></span><span id="leftTree_21_span">叶子节点214</span></a></li></ul></li><li id="leftTree_22" class="level1" tabindex="0" hidefocus="true" treenode=""><span id="leftTree_22_switch" title="" class="button level1 switch center_close" treenode_switch=""></span><a id="leftTree_22_a" class="level1" treenode_a="" onclick="" target="_blank" style="" title="父节点22 - 折叠"><span id="leftTree_22_ico" title="" treenode_ico="" class="button ico_close" style="width:0px;height:0px;"></span><span id="leftTree_22_span">父节点22 - 折叠</span></a></li><li id="leftTree_27" class="level1" tabindex="0" hidefocus="true" treenode=""><span id="leftTree_27_switch" title="" class="button level1 switch bottom_close" treenode_switch=""></span><a id="leftTree_27_a" class="level1" treenode_a="" onclick="" target="_blank" style="" title="父节点23 - 折叠"><span id="leftTree_27_ico" title="" treenode_ico="" class="button ico_close" style="width:0px;height:0px;"></span><span id="leftTree_27_span">父节点23 - 折叠</span></a></li></ul></li><li id="leftTree_44" class="level0" tabindex="0" hidefocus="true" treenode=""><span id="leftTree_44_switch" title="" class="button level0 switch bottom_docu" treenode_switch=""></span><a id="leftTree_44_a" class="level0" treenode_a="" onclick="" target="_blank" style="" title="父节点3 - 没有子节点"><span id="leftTree_44_ico" title="" treenode_ico="" class="button ico_docu" style=""></span><span id="leftTree_44_span">父节点3 - 没有子节点</span></a></li></ul>
	            </div>
	        </td>
	        <td style="width:85%;" valign="top">
	            <iframe name="treeFrame" id="treeFrame" frameborder="0" src="http://localhost:8080/admin//happuser/listUsers.do" style="margin: 0px auto; width: 100%; height: 471px;"></iframe>
	        </td>
	    </tr>
    </tbody>
</table>
</div>
        
        <!-- 返回顶部  -->
        <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse display">
            <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
        </a>
        
        <!-- 引入 -->
        <script type="text/javascript" src="scripts/bootstrap/dist/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="scripts/ace/dist/js/ace-elements.min.js"></script>
        <script type="text/javascript" src="scripts/ace/dist/js/ace.min.js"></script>
        
        <script type="text/javascript" src="scripts/chosen/chosen.jquery.min.js"></script><!-- 下拉框 -->
        <script type="text/javascript" src="scripts/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script><!-- 日期框 -->
        <script type="text/javascript" src="scripts/bootbox.js/bootbox.min.js"></script><!-- 确认窗口 -->
        <script type="text/javascript" src="scripts/layer/layer.js"></script>
        
        <!-- 引入 -->
        
        
        <script type="text/javascript" src="<c:url value="/widgets/simpletable/simpletable.js"/>"></script>
        <script type="text/javascript">
        $(document).ready(function() {
            // 分页需要依赖的初始化动作
            window.simpleTable = new SimpleTable('searchForm',${page.thisPageNumber},${page.pageSize},'${pageRequest.sortColumns}');
            
          //复选框
            $('table th input:checkbox').on('click' , function(){
                var that = this;
                $(this).closest('table').find('tr > td:first-child input:checkbox')
                .each(function(){
                    this.checked = that.checked;
                    $(this).closest('tr').toggleClass('selected');
                });
                    
            });
            $(top.hangge());
        });
        //检索
        function submit(){
        	$("#searchForm").submit();
        }
        function create(){
        	layer.open({
        		  type: 2,
        		  title: '新增',
        		  area: ['800px', '650px'],
        		  fixed: false,
        		  maxmin: true,
        		  content: 'systemUser/create.do'
        		});
        }
        function edit(id){
            layer.open({
                  type: 2,
                  title: '编辑',
                  area: ['800px', '650px'],
                  fixed: false,
                  maxmin: true,
                  content: 'systemUser/edit.do?id='+id
                });
        }
        function show(id){
            layer.open({
                  type: 2,
                  title: '详情',
                  area: ['800px', '650px'],
                  fixed: false,
                  maxmin: true,
                  content: 'systemUser/show.do?id='+id
                });
        }
        function remove(){
            layer.open({
                  type: 2,
                  title: '新增',
                  area: ['800px', '650px'],
                  fixed: false,
                  maxmin: true,
                  content: 'systemUser/create.do'
                });
        }
        <%-- function switchStatus(id,'status',id2){
            if(id != hcid1){
                hcid1 = id;
                qxhc1 = '';
            }
            var value = 1;
            var wqx = $("#"+id).attr("checked");
            if(qxhc1 == ''){
                if(wqx == 'checked'){
                    qxhc1 = 'checked';
                }else{
                    qxhc1 = 'unchecked';
                }
            }
            if(qxhc1 == 'checked'){
                value = 0;
                qxhc1 = 'unchecked';
            }else{
                value = 1;
                qxhc1 = 'checked';
            }
                var url = "<%=basePath%>role/kfqx.do?kefu_id="+kefu_id+"&msg="+msg+"&value="+value+"&guid="+new Date().getTime();
                $.get(url,function(data){
                    if(data=="success"){
                        //document.location.reload();
                    }
                });
        } --%>
        </script>
    </body>
</html>

