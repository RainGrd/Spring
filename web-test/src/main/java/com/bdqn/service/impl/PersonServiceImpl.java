package com.bdqn.service.impl;

import com.bdqn.dao.PersonDao;
import com.bdqn.dao.impl.PersonDaoImpl;
import com.bdqn.entity.Dept;
import com.bdqn.entity.Person;
import com.bdqn.service.PersonService;
import com.bdqn.utils.DBUtil;
import com.bdqn.utils.PageInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.service
 * @Author: RainGrd
 * @CreateTime: 2022-06-20  11:30
 * @Description: TODO
 * @Version: 1.0
 */
public class PersonServiceImpl implements PersonService {

    private PersonDao personDao = new PersonDaoImpl();
    /*用来拼接SQL语句的*/
    StringBuilder sb = null;
    /**
     * 用于存放参数的
     */
    List<Object> args = null;

    @Override
    public PageInfo<Person> findPersonList(int current, int pageSize, Person person) {
        sb = new StringBuilder();
        /*拼接字符串*/
        sb.append("SELECT * FROM t_person where del_status=0");
        sb.append(" LIMIT ?,?");
        PageInfo<Person> personPageInfo = DBUtil.pageList(sb.toString(), Person.class, current, pageSize);
        for (Person personList : personPageInfo.getData()) {
            personList.setDeptList(DBUtil.queryList(Dept.class, "select dept.* from t_person person join t_dept dept " +
                    "on " +
                    "person.dept = dept.dept_id and person.pid=" + personList.getPid()));
        }
        System.out.println(personPageInfo);
        return personPageInfo;
    }

    @Override
    public void delete(int id) {
        sb = new StringBuilder();
        sb.append("update t_person set del_status=1 where pid=?");
        personDao.delete(sb.toString(), id);
    }

    @Override
    public void update(Person person) {
        sb = new StringBuilder();
        args = new ArrayList<>();
        sb.append("update t_person set ");
        if (person.getName() != null && !"".equals(person.getName())) {
            args.add(person.getName());
            sb.append(" name=?,");
        }
        if (person.getGender() != null && !"".equals(person.getGender())) {
            args.add(person.getGender());
            sb.append(" gender=?,");
        }
        if (person.getSalary() != null) {
            args.add(person.getSalary());
            sb.append(" salary=?,");
        }
        if (person.getDept() != null) {
            args.add(person.getDept());
            sb.append(" dept=?,");
        }
        System.out.println(person.getRemark()!=null);
        System.out.println(person.getRemark()!=null);
        if (person.getRemark() != null && !"".equals(person.getRemark())) {
            args.add(person.getRemark());
            sb.append(" remark=? ");
        }
        sb.append(" WHERE pid=?");
        System.out.println(sb);
        args.add(person.getPid());
        personDao.update(sb.toString(), args.toArray());
    }

    @Override
    public void insert(Person person) {
        args=new ArrayList<>();
        if (person.getName() != null && !"".equals(person.getName())) {
            args.add(person.getName());
        }
        if (person.getGender() != null && !"".equals(person.getGender())) {
            args.add(person.getGender());

        }
        if (person.getSalary() != null) {
            args.add(person.getSalary());

        }
        if (person.getDept() != null) {
            args.add(person.getDept());

        }
        if (person.getRemark() != null && !"".equals(person.getRemark())) {
            args.add(person.getRemark());

        }
        personDao.increase(args.toArray());
    }
}
