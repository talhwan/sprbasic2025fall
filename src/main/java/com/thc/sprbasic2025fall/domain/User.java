package com.thc.sprbasic2025fall.domain;

import com.thc.sprbasic2025fall.dto.DefaultDto;
import com.thc.sprbasic2025fall.dto.UserDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User extends AuditingFileds{
    @Column(nullable = false, unique = true) String username;
    String password;
    String name;
    String phone;
    String gender;

    protected User(){}
    private User(String username, String password, String name, String phone, String gender) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.gender = gender;
    }
    public static User of(String username, String password, String name, String phone, String gender){
        return new User(username, password, name, phone, gender);
    }
    public void update(UserDto.UpdateReqDto param){
        if(param.getDeleted() != null){ setDeleted(param.getDeleted()); }
        if(param.getPassword() != null){ setPassword(param.getPassword()); }
        if(param.getName() != null){ setName(param.getName()); }
        if(param.getPhone() != null){ setPhone(param.getPhone()); }
        if(param.getGender() != null){ setGender(param.getGender()); }
    }

    public DefaultDto.CreateResDto toCreateResDto() {
        return DefaultDto.CreateResDto.builder().id(getId()).build();
    }
}
