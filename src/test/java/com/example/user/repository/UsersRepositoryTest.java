package com.example.user.repository;

import com.example.user.domain.Users;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UsersRepositoryTest {

    @Mock
    UsersRepository usersRepository;

    @Test
    void findById_정상() {
        // given
        Users user = Users.builder()
                .id(1L)
                .name("testuser")
                .build();

        when(usersRepository.findById(1L)).thenReturn(Optional.of(user));

        // when
        Optional<Users> foundUser = usersRepository.findById(1L);

        // then
        assertThat(foundUser).isPresent();
        assertThat(foundUser.get().getId()).isEqualTo(1L);
        assertThat(foundUser.get().getName()).isEqualTo("testuser");
    }
}