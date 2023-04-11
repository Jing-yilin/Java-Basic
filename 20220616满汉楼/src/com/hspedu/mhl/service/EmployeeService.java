package com.hspedu.mhl.service;

import com.hspedu.mhl.dao.EmployeeDAO;
import com.hspedu.mhl.domain.Employee;

/**
 * @ClassName employeeService
 * @Description 该类完成对employee表的各种操作，通过调用employeeDAO完成对employee表的操作
 * @Author zephyr
 * @Date 2022/6/16 22:29
 * @Version 1.0
 */
public class EmployeeService {
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    //根据empId和pwd返回一个Employee对象
    //如果查询不到就返回一个null
    public Employee getEmployeeByIdAndPwd(String empId, String pwd){
        Employee employee = employeeDAO.querySingle("select * from employee where empId = ? and pwd = md5(?)", Employee.class, empId, pwd);
        return employee;
    }
}
