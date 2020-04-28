package com.passada.cursomc.resources;

import com.passada.cursomc.domain.Pedido;
import com.passada.cursomc.dto.EmailDTO;
import com.passada.cursomc.security.JWTUtil;
import com.passada.cursomc.security.UserSS;
import com.passada.cursomc.services.AuthService;
import com.passada.cursomc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/auth")
public class AuthResource {

    @Autowired
    JWTUtil jwtUtil;
    @Autowired
    AuthService service;

    @RequestMapping(value = "/refresh_token",method= RequestMethod.POST)
    public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
        UserSS user = UserService.authenticated();
        String token = jwtUtil.generateToken(user.getUsername());
        response.addHeader("Authorization", "Bearer " + token);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/forgot",method= RequestMethod.POST)
    public ResponseEntity<Void> forgot(@Valid @RequestBody EmailDTO obj) {
        service.SendNewPassword(obj.getEmail());
        return ResponseEntity.noContent().build();
    }
}
