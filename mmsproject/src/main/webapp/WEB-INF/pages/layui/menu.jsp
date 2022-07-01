<%--
  Created by IntelliJ IDEA.
  User: 2447115985
  Date: 2022/2/5
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <base href="${pageContext.request.contextPath}/"/>
    <title>menu</title>
    <link rel="stylesheet" href="js/layui/layui-v2.6.3/css/layui.css" media="all">
    <link rel="stylesheet" href="css/layui/public.css" media="all">
    <style>
        .layui-btn:not(.layui-btn-lg ):not(.layui-btn-sm):not(.layui-btn-xs) {
            height: 34px;
            line-height: 34px;
            padding: 0 8px;
        }
    </style>
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">
        <fieldset class="table-search-fieldset">
            <legend>搜索信息</legend>
            <div style="margin: 10px 10px 10px 10px">
                <form class="layui-form layui-form-pane" action="">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">用户姓名</label>
                            <div class="layui-input-inline">
                                <input type="text" name="username" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">用户性别</label>
                            <div class="layui-input-inline">
                                <input type="text" name="sex" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">用户城市</label>
                            <div class="layui-input-inline">
                                <input type="text" name="city" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">用户职业</label>
                            <div class="layui-input-inline">
                                <input type="text" name="classify" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <button type="submit" class="layui-btn layui-btn-primary"  lay-submit lay-filter="data-search-btn"><i class="layui-icon"></i> 搜 索</button>
                        </div>
                    </div>
                </form>
            </div>
        </fieldset>
        <div>
            <table id="munu-table" class="layui-table" lay-filter="munu-table"></table>
        </div>
    </div>
</div>
<!-- 操作列 -->
<script type="text/html" id="auth-state">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="edit">修改</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script src="js/layui/layui-v2.6.3/layui.js" charset="utf-8"></script>
<script src="js/layui.js/lay-config.js?v=1.0.4" charset="utf-8"></script>
<script>
    layui.use(['table'], function () {
        var $ = layui.jquery;
        var table = layui.table;
        // var treetable = layui.treetable;

        // 渲染表格
        // layer.load(2);
        table.render({
            elem: '#munu-table'
            ,url: 'Menu/toMenu1'
            ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,height:350
            ,page:true
            ,cols: [[
                {field:'id', width:80, title: 'ID', sort: true}
                ,{field:'title', width:120, title: '管理列表'}
                ,{field:'href', width:80, title: 'href', sort: true}
                ,{field:'icon', width:80, title: 'icon'}
                ,{field:'target', title: 'target', width: '80'} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
            ]],
            done: function () {
                         layer.closeAll('loading');
                     }
        });
        // treetable.render({
        //     treeColIndex: 1,
        //     treeSpid: -1,
        //     treeIdName: 'authorityId',
        //     treePidName: 'parentId',
        //     elem: '#munu-table',
        //     url: 'Menu/toMenu1',
        //     page: false,
        //     cols: [[
        //         {type: 'numbers'},
        //         {field: 'authorityName', minWidth: 200, title: '权限名称'},
        //         {field: 'authority', title: '权限标识'},
        //         {field: 'menuUrl', title: '菜单url'},
        //         {field: 'orderNumber', width: 80, align: 'center', title: '排序号'},
        //         {
        //             field: 'isMenu', width: 80, align: 'center', templet: function (d) {
        //                 if (d.isMenu == 1) {
        //                     return '<span class="layui-badge layui-bg-gray">按钮</span>';
        //                 }
        //                 if (d.parentId == -1) {
        //                     return '<span class="layui-badge layui-bg-blue">目录</span>';
        //                 } else {
        //                     return '<span class="layui-badge-rim">菜单</span>';
        //                 }
        //             }, title: '类型'
        //         },
        //         {templet: '#auth-state', width: 120, align: 'center', title: '操作'}
        //     ]],
        //     done: function () {
        //         layer.closeAll('loading');
        //     }
        // });
        form.on('submit(data-search-btn)', function (data) {
            var result = JSON.stringify(data.field);
            layer.alert(result, {
                title: '最终的搜索信息'
            });

            //执行搜索重载
            table.reload('currentTableId', {
                page: {
                    curr: 1
                }
                , where: {
                    searchParams: result
                }
            }, 'data');

            return false;
        });

        $('#btn-expand').click(function () {
            table.expandAll('#munu-table');
        });

        $('#btn-fold').click(function () {
            table.foldAll('#munu-table');
        });

        //监听工具条
        table.on('tool(munu-table)', function (obj) {
            var data = obj.data;
            var layEvent = obj.event;

            if (layEvent === 'del') {
                layer.msg('删除' + data.id);
            } else if (layEvent === 'edit') {
                layer.msg('修改' + data.id);
            }
        });
    });
</script>
</body>
</html>
