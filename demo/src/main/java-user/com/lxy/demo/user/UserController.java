package com.lxy.demo.user;


import com.lxy.demo.user.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/hello")
    public String Sayhello (){
       return "hello world";
    }



    @RequestMapping("/getUsers")
    public List<UserEntity> getUsers(){
        List<UserEntity> users = userDao.getAll();

        return users;
    }


    @RequestMapping("/getUser")
    public  UserEntity getUser(@RequestParam long id){
        UserEntity user = userDao.getOne(id);
        return user;
    }



    @RequestMapping(value="/add",method = RequestMethod.POST)
    public ResponseEntity<List<ErrorResponse>> Save(@RequestBody UserEntity user){
        userDao.insert(user);
        List<ErrorResponse> errors= new ArrayList<ErrorResponse>();
        ErrorResponse error = new ErrorResponse("error","创建用户失败");
        errors.add(error);
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }


    @RequestMapping(value="update",method=RequestMethod.POST)
    public HttpStatus Update(@RequestBody UserEntity user){
        userDao.update(user);
        return HttpStatus.OK;
    }


    @RequestMapping("/delete/{id}")
    public HttpStatus delete (@PathVariable("id") long id){
        userDao.delete(id);
        return HttpStatus.OK;
    }
}
