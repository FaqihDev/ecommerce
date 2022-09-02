package com.example.CartProject.controlller;


import com.example.CartProject.Entity.User;
import com.example.CartProject.common.BaseResponse;
import com.example.CartProject.common.CommonCode;
import com.example.CartProject.common.CommonMessage;
import com.example.CartProject.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserServiceImpl userService;

    @GetMapping("/getAllUsers")
    public BaseResponse getAllUser(){
      List<User> listUser = userService.getAllUser();
        return new BaseResponse(CommonMessage.FOUND,CommonCode.SUCCESS,listUser);

    }

    @PostMapping("/add")
    public BaseResponse<User> addNewUser(@RequestBody User param){
        userService.saveNewUser(param);
        return new BaseResponse(CommonMessage.SAVED, CommonCode.SUCCESS);
    }

    @GetMapping("/getById/{id}")
    public BaseResponse<User> getUserById(@PathVariable("id") Long id){
       User user = userService.getUserById(id);
       return new BaseResponse(CommonMessage.FOUND,CommonCode.SUCCESS,user);
    }

    @PutMapping("updateUser/{id}")
    public BaseResponse<User> updateUser(@PathVariable ("id") Long id, @RequestBody User param){
        try{
            userService.updateUser(id,param);
            return new BaseResponse(CommonMessage.UPDATED,CommonCode.SUCCESS);
        } catch (Exception e){
            return new BaseResponse<>(CommonMessage.NOT_UPDATED,CommonCode.NOT_FOUND);
        }
    }

    @DeleteMapping("deleteUser/{id}")
    public BaseResponse<User> deleteUser(@PathVariable ("id") Long id) {
        try {
            userService.deleteUser(id);
            return new BaseResponse<>(CommonMessage.DELETED, CommonCode.SUCCESS);
        } catch (Exception e) {
            return new BaseResponse<>(CommonMessage.NOT_DELETED, CommonCode.NOT_FOUND);
        }
    }
}
