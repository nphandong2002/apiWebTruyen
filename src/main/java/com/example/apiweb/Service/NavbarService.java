package com.example.apiweb.Service;

import com.example.apiweb.Repo.NavbarRepo;
import com.example.apiweb.Repo.RoleNavRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NavbarService {
    @Autowired
    RoleNavRepo roleNavRepo;

    @Autowired
    NavbarRepo navbarRepo;
}
