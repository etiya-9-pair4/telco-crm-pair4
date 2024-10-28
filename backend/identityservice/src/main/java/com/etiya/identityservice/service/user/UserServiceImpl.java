package com.etiya.identityservice.service.user;

import com.etiya.identityservice.dto.User.request.CreateUserRequestDto;
import com.etiya.identityservice.dto.User.request.DeleteUserRequestDto;
import com.etiya.identityservice.dto.User.request.UpdateUserRequestDto;
import com.etiya.identityservice.dto.User.response.CreateUserResponseDto;
import com.etiya.identityservice.dto.User.response.DeleteUserResponseDto;
import com.etiya.identityservice.entity.User;
import com.etiya.identityservice.mapper.UserMapper;
import com.etiya.identityservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public abstract class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional
    public CreateUserResponseDto create(CreateUserRequestDto createUserRequestDto) {

        User user = userMapper.userFromCreateRequest(createUserRequestDto);
        userRepository.save(user);
        return userMapper.createUserResponseFromUser(user);
    }

    @Transactional
    public UpdateUserRequestDto update(UpdateUserRequestDto updateUserRequestDto) {
        User existingUser = userRepository.findById(updateUserRequestDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        User user = userMapper.userFromUpdateRequest(updateUserRequestDto);
        user.setId(existingUser.getId());
        User updatedUser = userRepository.save(user);
        return userMapper.updateUserResponseFromUser(updatedUser);
    }

    @Transactional

    public DeleteUserResponseDto delete(DeleteUserRequestDto deleteUserRequestDto) {
        User user = userRepository.findById(deleteUserRequestDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        userRepository.delete(user);

        return userMapper.deleteUserResponseFromUser(user);
    }

    public User getUserById(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);

        // User varsa döndür, yoksa hata fırlat veya başka bir işleyiş belirle
        return userOptional.orElseThrow(() -> new RuntimeException(STR."User not found with id: \{id}"));
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmailIgnoreCase(username).orElseThrow(() -> new UsernameNotFoundException(""));
    }
}
