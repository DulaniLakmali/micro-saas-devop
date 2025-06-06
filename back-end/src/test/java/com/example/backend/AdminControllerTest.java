package com.example.backend;

import com.example.backend.controller.AdminController;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.example.backend.model.Admin;
import com.example.backend.repository.AdminRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class AdminControllerTest {

    @Autowired
    private AdminController adminController;

    @Test
    public void shouldLoginSuccessfully(){
        // Mock the AdminRepository dependency
        AdminRepository adminRepository = mock(AdminRepository.class);

        // Create a LoginRequest object
        Admin loginRequest = new Admin();
        loginRequest.setUsername("admin");
        loginRequest.setPassword("123");

        // Set up the mock AdminRepository to return a valid admin user
        Admin admin = new Admin();
        admin.setAdminId(1);
        when(adminRepository.findByUsername("admin")).thenReturn(admin);

        // Call the Login() method
        ResponseEntity<?> response = adminController.Login(loginRequest);

        // Assert that the response is as expected
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(1);
    }

    @Test
    public void shouldReturnUnauthorizedWhenUsernameIsInvalid() {
        // Mock the AdminRepository dependency
        AdminRepository adminRepository = mock(AdminRepository.class);

        // Create a LoginRequest object
        Admin loginRequest = new Admin();
        loginRequest.setUsername("invalid_username");
        loginRequest.setPassword("123");

        // Set up the mock AdminRepository to return null for an invalid username
        when(adminRepository.findByUsername("invalid_username")).thenReturn(null);

        // Call the Login() method
        ResponseEntity<?> response = adminController.Login(loginRequest);

        // Assert that the response is as expected
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
        assertThat(response.getBody()).isEqualTo("Invalid username or password");
    }

    @Test
    public void shouldReturnUnauthorizedWhenPasswordIsInvalid() {
        // Mock the AdminRepository dependency
        AdminRepository adminRepository = mock(AdminRepository.class);

        // Create a LoginRequest object
        Admin loginRequest = new Admin();
        loginRequest.setUsername("admin");
        loginRequest.setPassword("invalid_password");

        // Set up the mock AdminRepository to return a valid admin user
        Admin admin = new Admin();
        admin.setAdminId(1);
        when(adminRepository.findByUsername("admin")).thenReturn(admin);

        // Call the Login() method
        ResponseEntity<?> response = adminController.Login(loginRequest);

        // Assert that the response is as expected
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
        assertThat(response.getBody()).isEqualTo("Invalid username or password");
    }
}
