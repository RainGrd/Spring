$(document).ready(function () {
    // 选择框
    $(".select2").select2();

    // WYSIHTML5编辑器
    $(".textarea").wysihtml5({
        locale: 'zh-CN'
    });
});

// 设置激活菜单
function setSidebarActive(tagUri) {
    var liObj = $("#" + tagUri);
    if (liObj.length > 0) {
        liObj.parent().parent().addClass("active");
        liObj.addClass("active");
    }
}

$(document).ready(function () {

    // 激活导航位置
    setSidebarActive("admin-datalist");

    // 列表按钮
    $("#dataList td input[type='checkbox']")
        .iCheck(
            {
                checkboxClass: 'icheckbox_square-blue',
                increaseArea: '20%'
            });
    // 全选操作
    $("#selall")
        .click(
            function () {
                var clicks = $(this).is(
                    ':checked');
                if (!clicks) {
                    $(
                        "#dataList td input[type='checkbox']")
                        .iCheck(
                            "uncheck");
                } else {
                    $(
                        "#dataList td input[type='checkbox']")
                        .iCheck("check");                }
                $(this).data("clicks",
                    !clicks);
            });
});
/*当前页码*/
var currPage = 1;
/*查询的最大条数*/
var pageSize = 10;
/*默认查询*/
getListData();

function getListData() {
    $.ajax({
        type: 'post',
        url: "http://localhost:8080/spring_system/user/findAllUsers", // ajax请求路径
        data: {
            page: currPage, //当前页数
            rows: pageSize  //查询的最大条数
        },
        dataType: 'json',
        success: function (data) {
            console.log(data);
            tableData(data.list);
            currPage = data.pageNum;
            pageSize = data.pageSize;
            /*刷新分页条*/
            layuiPage(data);
            // data=JSON.parse(data);

            /*            data = JSON.parse(data);
                        pageCount = data.result.pageCount;
                        shuju(data.result.dataList);
                        paged(data);*/
        }, error: function (res) {
            console.log('出错了');
        }
    });
}


/**
 * 拼接表格数据
 * @param data
 */
function tableData(data) {
    let $dataList = $('#dataList');
    /*将table的内容清空*/
    $dataList.html('');
    /*重新拼接*/
    $dataList.append('<thead>' +
        '<tr>' +
        '    <th class="" style="padding-right: 0px"><input id="selall" type="checkbox" class="icheckbox_square-blue">' +
        '    </th>' +
        '    <th class="sorting_asc">ID</th>' +
        '    <th class="sorting_desc">用户名</th>' +
        '    <th class="sorting_asc sorting_asc_disabled">邮箱</th>' +
        '    <th class="sorting_desc sorting_desc_disabled">联系电话</th>' +
        '    <th class="sorting">具有角色</th>' +
        '    <th class="sorting">操作</th>' +
        '</tr>' +
        '</thead>')

    for (let i = 0; i < data.length; i++) {
        $dataList.append("<tr>" +
            "<td><input name='ids' type='checkbox'></td>" +
            "<td>" + (i + 1) + "</td>" +
            "<td>" + data[i].username + "</td>" +
            "<td>" + data[i].email + "</td>" +
            "<td>" + data[i].phoneNum + "</td>" +
            "<td class='text-center roleName"+i+"'>" +

            "</td>" +
            "<td class='text-center'>" +
            "    <a href='javascript:void(0);' onclick='delUser()'" +
            "       class='btn bg-olive btn-xs'>删除</a>" +
            "</td>" +
            "</tr>")
        /*角色*/
        let array = data[i].roles;
        for (let j = 0; j < array.length; j++) {
            $('.roleName'+i).append(array[j].roleName+',');
        }
    }
/*    for (let j = 0; j < array.length; j++) {
        // console.log(data[i].roles[j].roleName)
        // array.push();
        $('.roleName').append(array[j].roleName);
    }*/
}

/**
 * 分页条
 * @param data 数据
 */
function layuiPage(data) {
    /*layui*/
    layui.use(['laypage', 'layer', 'jquery'], function () {
        var laypage = layui.laypage,
            layer = layui.layer,
            $ = layui.jquery;
        /*渲染分页*/
        laypage.render({
            elem: 'page'
            , count: data.total
            , layout: ['count', 'prev', 'page', 'next', 'limit', 'skip'],
            curr: currPage,
            limit: pageSize,
            jump: function (obj, first) {
                console.log(obj)
                /*发送ajax请求*/
                if (!first) {
                    /*当前页码*/
                    currPage = obj.curr;
                    pageSize = obj.limit;
                    getListData();
                }
            }
        });
    })
}

/*layui.use('table', function () {
    var table = layui.table;
    table.render({
        elem: '#userTable'
        , url: 'http://localhost:8080/spring_system/user/findUserAll'
        , toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
        , defaultToolbar: ['filter', 'exports', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
            title: '提示'
            , layEvent: 'LAYTABLE_TIPS'
            , icon: 'layui-icon-tips'
        }]
        , title: '用户数据表'
        , cols: [[
            {type: 'checkbox', fixed: 'left'}
            , {field: 'id', title: 'ID', width: 80, fixed: 'left', type: 'numbers', unresize: true, sort: true}
            , {field: 'username', title: '用户名', width: 120, edit: 'text'}
            , {
                field: 'email', title: '邮箱', width: 150, edit: 'text', templet: function (res) {
                    return '<em>' + res.email + '</em>'
                }
            }
            , {field: 'phoneNum', title: '手机号码', width: 80, edit: 'text', sort: true}
            , {field: 'birthDay', title: '日期', width: 100}
            /!*, {field: 'sign', title: '签名'}
            , {field: 'experience', title: '积分', width: 80, sort: true}
            , {field: 'ip', title: 'IP', width: 120}
            , {field: 'logins', title: '登入次数', width: 100, sort: true}
            , {field: 'joinTime', title: '加入时间', width: 120}*!/
            , {fixed: 'right', title: '操作', toolbar: '#barDemo', width: 150}
        ]]
        , page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
            layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
            // , curr: 5 //设定初始在第 5 页
            // , groups: 1 //只显示 1 个连续页码

        },done:function(res) {
            console.log(res)
        }
    });

    //头工具栏事件
    table.on('toolbar(test)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id);
        switch (obj.event) {
            case 'getCheckData':
                var data = checkStatus.data;
                layer.alert(JSON.stringify(data));
                break;
            case 'getCheckLength':
                var data = checkStatus.data;
                layer.msg('选中了：' + data.length + ' 个');
                break;
            case 'isAll':
                layer.msg(checkStatus.isAll ? '全选' : '未全选');
                break;

            //自定义头工具栏右侧图标 - 提示
            case 'LAYTABLE_TIPS':
                layer.alert('这是工具栏右侧自定义的一个图标按钮');
                break;
        }
        ;
    });

    //行工具事件
    table.on('tool(test)', function (obj) {
        var data = obj.data;
        //console.log(obj)
        if (obj.event === 'del') {
            layer.confirm('真的删除行么', function (index) {
                obj.del();
                layer.close(index);
            });
        } else if (obj.event === 'edit') {
            layer.prompt({
                formType: 2
                , value: data.email
            }, function (value, index) {
                obj.update({
                    email: value
                });
                layer.close(index);
            });
        }
    });
});*/

