/*页码默认为1*/
var current = 1;
/*查询最大的条数为5*/
var pageSize = 10;
let $person = {
    pid: '',
    name: '',
    gender: '',
    salary: '',
    dept: '',
    remark: ''
}
getListData();

/**
 * 查询后端返回的数据
 */
function getListData() {
    /*发送Ajax请求*/
    $.ajax({
        type: 'post',
        url: 'http://localhost:8080/web-test/person/findPersonList?current=' + current + "&pageSize=" + pageSize,
        data: {}, // dataType:'json',
        success: function (result) {
            /*将JSON数据重新转换为JS对象*/
            result = JSON.parse(result);
            tableData(result.data);
            getPage(result);
        },
        error: function (error) {
            console.log("出错了");
        }
    })
}

/**
 * 表格数据拼接
 */
function tableData(data) {
    let $tableDataList = $('#tableDataList');
    /*清空*/
    $tableDataList.html('');
    $tableDataList.append('<tr>' +
        '<td>Id</td>' +
        '<td>员工姓名</td>' +
        '<td>性别</td>' +
        '<td>薪水</td>' +
        '<td>部门</td>' +
        '<td>其他</td>' +
        '<td>操作</td>' +
        '</tr>')
    for (let i = 0; i < data.length; i++) {
        let deptList = data[i].deptList;
        $tableDataList.append('<tr>' +
            '<td>' + (i + 1) + '</td>' +
            '<td class="name">' + data[i].name + '</td>' +
            '<td class="gender">' + data[i].gender + '</td>' +
            '<td class="salary">' + data[i].salary + '</td>' +
            '<td class="deptName">' + getDeptName(deptList) + '</td>' +
            '<td class="remark">' + data[i].remark + '</td>' +
            '<td class="input_operation">' +
            '<button data-method="setTop" class="layui-btn layui-btn-normal layui-btn-sm update" onclick="updatePerson(' + data[i].pid + ')">修改</button>' +
            '<button type="button" class="layui-btn layui-btn-sm layui-btn-danger delete" onClick="delPerson(' + data[i].pid + ')">删除</button></td>' +
            '</tr>'
        );

    }
}

function getDeptName(deptList) {
    /*将部门名称提取出来*/
    for (let j = 0; j < deptList.length; j++) {
        return deptList[j].deptName;
    }
}

/**
 * 分页条
 * @param data
 */
function getPage(data) {
    layui.use(['laypage', 'layer', 'jquery', 'form'], function () {
        var laypage = layui.laypage, layer = layui.layer, $ = layui.jquery, form = layui.form;
        laypage.render({
            elem: 'page',
            count: data.totalCount,
            curr: data.current,
            limit: data.pageSize,
            layout: ['count', 'prev', 'page', 'next', 'limit', 'skip'],
            jump: function (obj, first) {
                console.log(obj);
                if (!first) {
                    current = obj.curr;
                    pageSize = obj.limit;
                    getListData();
                }
            }
        });
        //触发事件
        var active = {
            setTop: function () {
                var that = this;
                //多窗口模式，层叠置顶
                var updateOpen=layer.open({
                    id: 'updateOpen',
                    type: 1 //此处以iframe举例
                    ,
                    title: '修改窗口'
                    ,
                    area: ['1200px', '700px']
                    ,
                    shade: 0
                    ,
                    maxmin: true
                    ,
                    content: $('#update')
                    ,
                    yes: function () {
                        $(that).click();
                    }
                    ,
                    btn2: function () {
                        layer.closeAll();
                    }

                    ,
                    zIndex: layer.zIndex //重点1
                    ,
                    success: function (layero, index) {
                        layer.setTop(layero); //重点2. 保持选中窗口置顶

                        //记录索引，以便按 esc 键关闭。事件见代码最末尾处。
                        layer.escIndex = layer.escIndex || [];
                        layer.escIndex.unshift(index);
                        //选中当前层时，将当前层索引放置在首位
                        layero.on('mousedown', function () {
                            var _index = layer.escIndex.indexOf(index);
                            if (_index !== -1) {
                                layer.escIndex.splice(_index, 1); //删除原有索引
                            }
                            layer.escIndex.unshift(index); //将索引插入到数组首位
                        });
                    }
                    ,
                    end: function () {
                        //更新索引
                        if (typeof layer.escIndex === 'object') {
                            layer.escIndex.splice(0, 1);
                        }
                    }
                });
            }
        };
        /*修改单击事件*/
        $('.update').on('click', function () {
            var othis = $(this), method = othis.data('method');
            active[method] ? active[method].call(this, othis) : '';
            //表单赋值
            form.val('example', {
                "name": othis.parent().siblings(".name").text()// "name": "value"
                , "gender": othis.parent().siblings(".gender").text()
                , "salary": othis.parent().siblings(".salary").text()
                , "dept": true
                //复选框选中状态
                , "remark": othis.parent().siblings(".remark").text()
            });
        });
        //多窗口模式 - esc 键
        $(document).on('keyup', function (e) {
            if (e.keyCode === 27) {
                layer.close(layer.escIndex ? layer.escIndex[0] : 0);
            }
        });
        /*复选框单选*/
        form.on('checkbox(oneCheck)', function (data) {
            $("input[name='deptName']").prop("checked", false);
            $(this).prop("checked", true);
            form.render('checkbox');
        });
        /*修改表单提交事件*/
        form.on('submit(updateForm)', function (data) {
            let field = data.field;
            field.pid = $person.pid;
            console.log(field)
            /*发送Ajax请求*/
            $.ajax({
                type: 'put',
                url: 'http://localhost:8080/web-test/person/updatePerson',
                data: JSON.stringify(field),
                success: function (data) {
                    console.log(data);
                    if(data==='updateSuccess'){
                        /*关闭窗口*/
                        layer.close(layer.escIndex ? layer.escIndex[0] : 0);
                        /*重新查找数据*/
                        getListData();
                    }
                }, error: function (error) {
                    console.log(error);
                }
            })
            return false;
        });
    });
}

function flushDate(data) {
    /*    $person.pid=data.pid;
        $person.name=data.name;
        $person.=data.pid;
        $person.pid=data.pid;
        $person.pid=data.pid;*/
}

function delPerson(id) {
    $.ajax({
        type: 'delete',
        url: 'http://localhost:8080/web-test/person/deletePerson',
        data: JSON.stringify({
            pid: id
        }),
        success: function (data) {
            console.log(data)
            if (data === 'deleteSuccess') {
                /*重新查询数据*/
                getListData();
            }
        }, error: function (data) {
            console.log("出错了");
        }
    })
}

function updatePerson(id) {
    $person.pid = id;
}