package com.lee.web.controller;

import com.baomidou.mybatisplus.core.injector.methods.DeleteById;
import com.lee.web.entity.Employee;
import com.lee.web.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;



    //查询所有员工
    @RequestMapping("/emps")
    public String list(Model model){

        List<Employee> list = employeeService.list();
        model.addAttribute("emps",list);
        return "emp/list";

    }


    //进入添加页面
    @GetMapping("/emp")
    public String toAddEmp(Model model){
        //添加的操作

        return "emp/add";
    }

    //添加员工
    @PostMapping("/emp")
    public String addEmp(Employee employee){
    //添加的操作
    employeeService.save(employee);


        return "redirect:/emps";
    }

    //跳转到员工修改页面
    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable ("id")String id, Model model){

        //查出原来的数据
        Employee employeeById = employeeService.getById(id);
        model.addAttribute("emp",employeeById);


        return "emp/update";
    }

    //保存修改
    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee){
        //修改的操作
        employeeService.save(employee);


        return "redirect:/emps";
    }

    //删除员工
    @GetMapping("/delemp/{id}")
    public String deletEmp(@PathVariable ("id")String id, Model model){

      employeeService.removeById(id);
        return "redirect:/emps";
    }



}