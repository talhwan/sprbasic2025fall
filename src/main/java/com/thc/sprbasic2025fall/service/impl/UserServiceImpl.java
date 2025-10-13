package com.thc.sprbasic2025fall.service.impl;

import com.thc.sprbasic2025fall.domain.User;
import com.thc.sprbasic2025fall.dto.DefaultDto;
import com.thc.sprbasic2025fall.dto.UserDto;
import com.thc.sprbasic2025fall.repository.UserRepository;
import com.thc.sprbasic2025fall.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    final UserRepository userRepository;

    @Override
    public DefaultDto.CreateResDto login(UserDto.LoginReqDto param) {
        /*
        //1. 아이디가 존재하는지 확인?
        User user = userRepository.findByUsername(param.getUsername());
        if(user == null){
            //아이디 없어!!
            return DefaultDto.CreateResDto.builder().id((long) -200).build();
        } else {
            //2. 아이디가 존재하면 비밀번호 일치하는지도 확인?
            if(user.getPassword().equals(param.getPassword())){
                // 로그인 완료!
                return DefaultDto.CreateResDto.builder().id(user.getId()).build();
            } else {
                //비번 불일치!!
                return DefaultDto.CreateResDto.builder().id((long) -200).build();
            }
        }

        User user = userRepository.findByUsername(param.getUsername());
        //2. 아이디가 존재하면 비밀번호 일치하는지도 확인?
        if(user != null && user.getPassword().equals(param.getPassword())){
            // 로그인 완료!
            return DefaultDto.CreateResDto.builder().id(user.getId()).build();
        }
        return DefaultDto.CreateResDto.builder().id((long) -200).build();
        */
        User user = userRepository.findByUsernameAndPassword(param.getUsername(), param.getPassword());
        if(user == null){
            throw new RuntimeException("no matched data");
        }
        // 로그인 완료!
        return DefaultDto.CreateResDto.builder().id(user.getId()).build();

    }

    /**/

    @Override
    public DefaultDto.CreateResDto create(UserDto.CreateReqDto param) {
        return userRepository.save(param.toEntity()).toCreateResDto();
    }

    @Override
    public void update(UserDto.UpdateReqDto param) {
        User user = userRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException("no data"));
        user.update(param);
        userRepository.save(user);
    }

    @Override
    public void delete(UserDto.UpdateReqDto param) {
        update(UserDto.UpdateReqDto.builder().id(param.getId()).deleted(true).build());
    }

    public UserDto.DetailResDto get(DefaultDto.DetailReqDto param) {
        User user = userRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException("no data"));
        return UserDto.DetailResDto.builder()
                .id(user.getId())
                .deleted(user.getDeleted())
                .username(user.getUsername())
                .name(user.getName())
                .phone(user.getPhone())
                .gender(user.getGender())
                .build();
    }

    @Override
    public UserDto.DetailResDto detail(DefaultDto.DetailReqDto param) {
        return get(param);
    }

    @Override
    public List<UserDto.DetailResDto> list(UserDto.ListReqDto param) {
        List<UserDto.DetailResDto> list = new ArrayList<>();
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if(param.getDeleted() != null){
                if(user.getDeleted() == param.getDeleted()){
                    list.add(get(DefaultDto.DetailReqDto.builder().id(user.getId()).build()));
                }
            }
        }
        return list;
    }
}
