package fit.imc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fit.imc.infra.security.utils.JwtUtils;
import fit.imc.view.AuthRequest;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:8000")
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AuthenticationManager authMgr;

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest request) {
        try {
            authMgr.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
            return jwtUtils.generateToken(request.getUsername());
        } catch (Exception ex) {
            System.out.println("error on login!");
            throw ex;
        }
    }
}
