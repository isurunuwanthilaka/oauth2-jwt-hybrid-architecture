package lk.isumalab.authservice.controller;

import lk.isumalab.authservice.config.AccessToken;
import lk.isumalab.authservice.model.OAuth2Token;
import lk.isumalab.authservice.model.User;
import lk.isumalab.authservice.service.JwtTokenService;
import lk.isumalab.authservice.service.OfficerDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1")
public class AuthController {

    private JwtTokenService jwtTokenService;
    private OfficerDetailService officerDetailService;

    @Autowired
    public AuthController(JwtTokenService jwtTokenService, OfficerDetailService officerDetailService) {
        this.jwtTokenService = jwtTokenService;
        this.officerDetailService = officerDetailService;
    }

    @GetMapping("/login")
    public ResponseEntity login() {
        String token = AccessToken.getAccessToken();
        return ResponseEntity.ok(OAuth2Token.builder().oauth2Token(token).build());
    }

    @GetMapping("/jwt")
    public ResponseEntity jwt() {
        String principal = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = officerDetailService.loadUserByUsername(principal);
        if (user == null) {
            //save user
        }

        String generateToken = jwtTokenService.generateToken(user);

        return ResponseEntity.ok(generateToken);
    }

    @PostMapping("/jwt/validate/{jwt}")
    public ResponseEntity validateJwt(@PathVariable(value = "jwt") String jwt) {
        return ResponseEntity.ok(jwt);
    }
}
