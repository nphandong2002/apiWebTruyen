package com.example.apiweb.Service;

import com.example.apiweb.Entity.RoleEntity;
import com.example.apiweb.Entity.UserEntity;
import com.example.apiweb.Repo.ReadingRepo;
import com.example.apiweb.Repo.RoleNavRepo;
import com.example.apiweb.Repo.RoleRepo;
import com.example.apiweb.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    ReadingRepo readingRepo;

    @Autowired
    RoleNavRepo roleNavRepo;

    //User

    public List<UserEntity> getAllUser(Pageable pageable){
        return  userRepo.findAll(pageable).getContent();
    }
    public UserEntity getUserByUsername(String email){
        return userRepo.findUserEntityByUsername(email);
    }
    public UserEntity createUser(UserEntity user){
        UserEntity userEntity = userRepo.findUserEntityByUsername(user.getUsername());
        if(userEntity != null) return new UserEntity();
        return  userRepo.save(user);
    }
    public void deleteById(int id){
        userRepo.deleteById(id);
    }
    public UserEntity getUserbyId(int id){
        return userRepo.findUserEntityById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepo.findUserEntityByUsername(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException("username not found");
        }
        SimpleGrantedAuthority grand = new SimpleGrantedAuthority(userEntity.roleEntity.getName());
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();


        authorities.add(grand);
        User user = new User(userEntity.getUsername(), userEntity.getPassword(), authorities);
        return user;
    }

    //role
    public List<RoleEntity> getAll(){
        return roleRepo.findAll();
    }

    public RoleEntity createRole(RoleEntity role){
        RoleEntity role1 = getRoleByName(role.getName());
        if(role1 != null) return new RoleEntity();
        return roleRepo.save(role);
    }
    public RoleEntity getRoleByName(String name){
        return roleRepo.findRoleEntityByName(name);
    }
    public void delete(int id){
        roleRepo.deleteById(id);
    }

}
