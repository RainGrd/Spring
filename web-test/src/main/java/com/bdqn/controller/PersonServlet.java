package com.bdqn.controller;

import com.bdqn.entity.Person;
import com.bdqn.service.PersonService;
import com.bdqn.service.impl.PersonServiceImpl;
import com.bdqn.utils.Util;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.controller
 * @Author: RainGrd
 * @CreateTime: 2022-06-20  11:11
 * @Description: TODO
 * @Version: 1.0
 */
@WebServlet("/person/*")
public class PersonServlet extends BaseServlet {

    private final PersonService personService = new PersonServiceImpl();
    ObjectMapper mapper = new ObjectMapper();
    public void findPersonList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int current = Integer.parseInt(request.getParameter("current"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        response.getWriter().write(mapper.writeValueAsString(personService.findPersonList(current, pageSize,
                new Person())));
    }

    public void deletePerson(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Person person = Util.parsing(Person.class, request);
        personService.delete(person.getPid());
//        返回删除成功的标识
        response.getWriter().write("deleteSuccess");
    }
    public void updatePerson(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Person person = Util.parsing(Person.class, request);
        personService.update(person);
        /*返回修改成功的标识*/
        response.getWriter().write("updateSuccess");
    }
    public void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Person person = Util.parsing(Person.class, request);
        personService.insert(person);
        /*返回添加成功的标识*/
        response.getWriter().write("insertSuccess");
    }
}
