package com.group.libraryapp.service.user;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.repository.user.UserJdbcRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceV1 {

    private final UserJdbcRepository UserJdbcRepository;

    public UserServiceV1(UserJdbcRepository UserJdbcRepository) {
        this.UserJdbcRepository = UserJdbcRepository;
    }

    public void saveUser(UserCreateRequest request) {
        UserJdbcRepository.saveUser(request.getName(), request.getAge());
    }

    public List<UserResponse> getUser() {
        return UserJdbcRepository.getUser();
    }

    public void updateUser(UserUpdateRequest request) {
        if (UserJdbcRepository.isUserNotExist(request.getId())) {
            throw new IllegalArgumentException();
        }

        UserJdbcRepository.updateUserNmae(request.getName(), request.getId());
    }

    public void deleteUser(String name) {
        if (UserJdbcRepository.isUserNotExist(name)) {
            throw new IllegalArgumentException();
        }

        UserJdbcRepository.deleteUser(name);
    }
}
