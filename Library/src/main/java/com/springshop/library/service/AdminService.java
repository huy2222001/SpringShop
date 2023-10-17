package com.springshop.library.service;

import com.springshop.library.dto.AdminDto;
import com.springshop.library.model.Admin;

public interface AdminService {
    Admin findByUsername(String username);
    Admin save(AdminDto adminDto);
}
