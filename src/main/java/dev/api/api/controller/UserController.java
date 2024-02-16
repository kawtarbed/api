package dev.api.api.controller;


import lombok.AllArgsConstructor;
import dev.api.api.Dto.UserRequestDto;
import dev.api.api.entity.UserEntity;
import dev.api.api.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    public final UserService userServices;
    //Get
    @GetMapping ("/get/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id){
        try {
            return ResponseEntity.ok(userServices.getUser(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    //Post
    @PostMapping("/add")
    public ResponseEntity<?> addUser(@PathVariable UserEntity user){
        try {
            return ResponseEntity.ok(userServices.addUser(user));
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    //Delete
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        try {
            userServices.deleteById(id);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    //Update
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UserEntity user){
        try {

            return ResponseEntity.ok(userServices.updateUser(user));
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

}