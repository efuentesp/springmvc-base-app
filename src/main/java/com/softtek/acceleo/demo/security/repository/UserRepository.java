package com.softtek.acceleo.demo.security.repository;

import com.softtek.acceleo.demo.security.model.User;

public interface UserRepository  {
    User findByUsername(String username);
}


