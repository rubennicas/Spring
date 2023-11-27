package es.jsomoza.controller;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.jsomoza.controller.request.CreateUserDTO;
import es.jsomoza.models.ERole;
import es.jsomoza.models.RoleEntity;
import es.jsomoza.models.UserEntity;
import es.jsomoza.repositories.UserRepository;
import jakarta.validation.Valid;

@RestController
public class PrincipalController {

	
	@Autowired 
	private PasswordEncoder passwordEncoder;
	  
	@Autowired 
	private UserRepository userRepository;
	 

    @GetMapping("/hello")
    public String hello(){
        return "Hello World Not Secured";
    }

    @GetMapping("/helloSecured")
    public String helloSecured(){
        return "Hello World Secured";
    }

	
	  @PostMapping("/createUser") public ResponseEntity<?>
	  createUser(@Valid @RequestBody CreateUserDTO createUserDTO){
	  
	  Set<RoleEntity> roles = createUserDTO.getRoles().stream() .map(role ->
	  RoleEntity.builder() .name(ERole.valueOf(role)) .build())
	  .collect(Collectors.toSet());
	  
	  UserEntity userEntity = UserEntity.builder()
	  .username(createUserDTO.getUsername())
	  .password(passwordEncoder.encode(createUserDTO.getPassword()))
//	  .password(createUserDTO.getPassword())
	  .email(createUserDTO.getEmail()) .roles(roles) .build();
	  
	  userRepository.save(userEntity);
	  
	  return ResponseEntity.ok(userEntity); }
	  
	  @DeleteMapping("/deleteUser") public String deleteUser(@RequestParam String
	  id){ userRepository.deleteById(Long.parseLong(id)); return
	  "Se ha borrado el user con id".concat(id); }
	 
}