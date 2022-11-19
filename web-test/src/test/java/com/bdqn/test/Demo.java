package com.bdqn.test;

import com.bdqn.entity.Admin;
import com.bdqn.entity.Dept;
import com.bdqn.entity.Person;
import com.bdqn.utils.DBUtil;
import com.bdqn.utils.PageInfo;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.test
 * @Author: RainGrd
 * @CreateTime: 2022-06-20  11:20
 * @Description: TODO
 * @Version: 1.0
 */
public class Demo {
    @Test
    public void test1() {
        System.out.println(DBUtil.queryList(Person.class, "select * from t_person limit 0,5"));
        StringBuilder sb = new StringBuilder();
        /*拼接字符串*/
        sb.append("SELECT * FROM t_person where del_status=0");
        sb.append(" LIMIT ?,?");
        System.out.println(DBUtil.pageList(sb.toString(), Person.class, 1, 5));
        PageInfo<Person> personPageInfo = DBUtil.pageList(sb.toString(), Person.class, 1, 5);
        List<Person> personList = personPageInfo.getData();
        for (Person person : personList) {
            person.setDeptList(DBUtil.queryList(Dept.class, "select dept.* from t_person person join t_dept dept on " +
                    "person.dept = dept.dept_id and person.pid=" + person.getPid()));
        }
        System.out.println(personList);

    }

    @Test
    public void test2() {
        StringBuilder sb = new StringBuilder();
        /*拼接字符串*/
        sb.append("update t_person set del_status=1 where pid=?");
        System.out.println(DBUtil.update(sb.toString(), 12));
    }

    @Test
    public void test3() {
        DBUtil.update("update t_person set name=? where pid=?", "张三", 1);
    }

    @Test
    public void test4() {
        Person person = new Person();
        person.setName("zhangsan");
        person.setSalary(5000.00);
        person.setDept(2);
        person.setGender("女");
        person.setRemark("123456321w23454321");
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(person.getName());
        objects.add(person.getGender());
        objects.add(person.getSalary());
        objects.add(person.getDept());
        objects.add(person.getRemark());
        DBUtil.update("insert t_person values(null,?,?,?,?,?,0)",objects.toArray());
    }
    @Test
    public void test5() {
        Admin admin = DBUtil.queryOne(Admin.class, "select * from t_admin where username=? and password=?", "admin",
                123456);
        System.out.println(admin);
    }

    @Test
    public void test6() {
        Admin admin=new Admin();
        admin.setName("段荣贵");
        admin.setUsername("username");
        admin.setPassword("123456");
        admin.setPhone("15873461176");
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(admin.getName());
        objects.add(admin.getUsername());
        objects.add(admin.getPassword());
        objects.add(admin.getPhone());
        DBUtil.update("insert t_admin values(null,?,?,?,?)",objects.toArray());
    }

    @Test
    public void test7() {
        DBUtil.update("update t_admin set password=? where phone=?","789456","15873461176");
    }
}
