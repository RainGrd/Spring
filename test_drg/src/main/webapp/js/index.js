$(function () {
    /*默认*/
    let current = 1;
    let pageSize = 5;
    selectAll();
    $('.down').on('click', function () {

    })

    /**
     * 查询数据
     */
    function selectAll() {
        $.ajax({
            type: 'get',
            url: 'http://localhost:8080/test_drg/book/selectAll?current=' + current + '&pageSize=' + pageSize,
            success: function (result) {
                tableData(JSON.parse(result));
                page(JSON.parse(result))
            }, error: function (error) {
                console.log('出错了')
            }
        })
    }
    /**
     * 下一页点击事件
     */
    $('.down').on('click',function (){
        current++;
        selectAll();
    })
    $('.up').on('click',function (){
        current--;
        selectAll();
    })
    $('.home').on('click',function (){
        current=1;
        selectAll();
    })
    $('.last').on('click',function (){
        current=$('.page').text();
        selectAll();
    })
    /**
     * 分页条赋值
     */
    function page(result){
        current=result.current;
        pageSize=result.pageSize;
        $('.index').text(result.current)
        $('.page').text(result.countPages);
        $('.count').text(result.totalCount);
    }
    /**
     * 拼接表格
     */
    function tableData(data) {
        let result = data.data;
        let $table = $('table');
        /*清空数据*/
        $table.html('')
        $table.append('<tr>\n' +
            '        <th>编号</th>\n' +
            '        <th>书名</th>\n' +
            '        <th>作者</th>\n' +
            '        <th>价格</th>\n' +
            '    </tr>');
        /*遍历数据*/
        for (let i = 0; i < result.length; i++) {
            $table.append(' <tr align="center">\n' +
                '            <td>' + (i + 1) + '</td>\n' +
                '            <td>' + result[i].title + '</td>\n' +
                '            <td>' + result[i].author + '</td>\n' +
                '            <td>' + result[i].price + '</td>\n' +
                '        </tr>')
        }

    }
});