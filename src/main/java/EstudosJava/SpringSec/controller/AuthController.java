package EstudosJava.SpringSec.controller;


import EstudosJava.SpringSec.dto.request.LoginRequest;
import EstudosJava.SpringSec.dto.request.RegisterUserRequest;
import EstudosJava.SpringSec.dto.response.LoginResponse;
import EstudosJava.SpringSec.dto.response.RegisterUserResponse;
import EstudosJava.SpringSec.entity.User;
import EstudosJava.SpringSec.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        // Lógica de autenticação (omitted for brevity)
        return null;
    }

    public ResponseEntity<RegisterUserResponse> register(@Valid @RequestBody RegisterUserRequest request) {
        // Lógica de registro de usuário (omitted for brevity)
        User newUser = new User();
        newUser.setPassword(request.password());
        newUser.setEmail(request.email());
        newUser.setName(request.name());

        userRepository.save(newUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(
                new RegisterUserResponse(newUser.getName(), newUser.getEmail())
        );
    }
}
