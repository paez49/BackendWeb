package com.example.demo.rest;

import com.example.demo.domain.Usuario;
import com.example.demo.dto.UsuarioDTO;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.security.jwt.JwtTokenUtil;
import com.example.demo.security.payload.JwtResponse;
import com.example.demo.security.payload.LoginRequest;
import com.example.demo.security.payload.MessageResponse;
import com.example.demo.security.payload.RegisterRequest;
import com.example.demo.service.UsuarioService;
import com.example.demo.util.ConverterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Controlador para llevar a cabo la autenticación utilizando JWT
 *
 * Se utiliza AuthenticationManager para autenticar las credenciales que son el
 * usuario y password que llegan por POST en el cuerpo de la petición
 *
 * Si las credenciales son válidas se genera un token JWT como respuesta
 */
// @CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authManager;
    @Autowired
    private final UsuarioRepository userRepository;

    @Autowired
    private final UsuarioService usuarioService;
    private final PasswordEncoder encoder;
    private final JwtTokenUtil jwtTokenUtil;

    public AuthController(AuthenticationManager authManager,
                          UsuarioRepository usuarioRepository,
                          PasswordEncoder encoder,
                          UsuarioService usuarioService,
                          JwtTokenUtil jwtTokenUtil){
        this.authManager = authManager;
        this.userRepository = usuarioRepository;
        this.encoder = encoder;
        this.jwtTokenUtil = jwtTokenUtil;
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenUtil.generateJwtToken(authentication);

        Usuario user = usuarioService.findByUsername(loginRequest.getUsername());

        ConverterDTO converterDTO = new ConverterDTO();
        UsuarioDTO usuarioDTO = converterDTO.toDto(user);
        Map<String, Object> response = new HashMap<>();
        response.put("user", usuarioDTO);
        response.put("token", jwt);

        return ResponseEntity.ok(response);
    }
    @PostMapping("/register")
    public ResponseEntity<MessageResponse> register(@RequestBody RegisterRequest signUpRequest) {

        // Check 1: username
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        // Check 2: email
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        Usuario user = new Usuario(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
