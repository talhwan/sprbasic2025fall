package com.thc.sprbasic2025fall.dto;

import com.thc.sprbasic2025fall.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

public class UserDto {

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor
    public static class LoginReqDto{
        String username;
        String password;
    }

    /**/

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor
    public static class CreateReqDto{
        String username;
        String password;
        String name;
        String phone;
        String gender;

        //CreateReqDto를 사용해서, User Entity 인스턴스 하나 만들어주세요!
        public User toEntity(){
            return User.of(getUsername(), getPassword(), getName(), getPhone(), getGender());
        }
    }

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @SuperBuilder
    public static class UpdateReqDto extends DefaultDto.UpdateReqDto{
        String password;
        String name;
        String phone;
        String gender;
    }
    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @SuperBuilder
    public static class DetailResDto extends DefaultDto.DetailResDto {
        String username;
        String name;
        String phone;
        String gender;
    }
    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @SuperBuilder
    public static class ListReqDto extends DefaultDto.ListReqDto {
        String name;
        String phone;
    }
}
