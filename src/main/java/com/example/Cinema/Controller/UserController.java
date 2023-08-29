package com.example.Cinema.Controller;

import com.example.Cinema.DTO.LoginDTO;
import com.example.Cinema.DTO.TokenDTO;
import com.example.Cinema.Model.User;
import com.example.Cinema.Service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    public ResponseEntity<User> register(@RequestBody User user){
        return new ResponseEntity<>(userService.register(user), HttpStatus.OK);
    }

    @PostMapping(value = "/login",consumes = "application/json")
    public ResponseEntity<TokenDTO> login(@RequestBody LoginDTO loginDTO){

        String username = loginDTO.getUsername();
        String password = loginDTO.getPassword();

        User user = userService.findByUsername(username);

        if (user != null && password.equals(user.getPassword())){
            String jwtToken = generateToken(user.getUsername(), user.getEmail(), user.isAdmin());
            TokenDTO tokenDTO = new TokenDTO(jwtToken);
            return ResponseEntity.ok(tokenDTO);
        }else {

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

    }

    private String generateToken(String username, String email, Boolean isAdmin) {
        String secretKey = "your-secret-key";
        long expirationTime = 1000 * 60 * 60 * 24; // 24 hours
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        return Jwts.builder()
                .setSubject(username)
                .claim("email", email)
                .claim("isAdmin", isAdmin)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }
}
