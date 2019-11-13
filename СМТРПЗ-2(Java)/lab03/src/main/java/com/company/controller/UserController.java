package com.company.controller;

import com.company.entity.User;
import com.company.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("")
    public List<User> getUserById(@RequestParam(value = "id", required = false) Integer id) {

        List<User> resultList = new ArrayList<>();
        if (id == null) {
            Iterable<User> result = userRepository.findAll();
            result.forEach(resultList::add);
        }
        else {
            Optional<User> customer = userRepository.findById(id);
            if (customer.isPresent()) {
                resultList.add(customer.get());
            }
        }

        return resultList;
    }
}
