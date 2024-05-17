package com.ElenaOrtega.standcustom.service;



import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ElenaOrtega.standcustom.exception.ResourceNotFoundException;
import com.ElenaOrtega.standcustom.entity.PartidaEntity;
import com.ElenaOrtega.standcustom.entity.UserEntity;
import com.ElenaOrtega.standcustom.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import com.ElenaOrtega.standcustom.entity.UserEntity;
import com.ElenaOrtega.standcustom.service.EmailService; // Add missing import


@Service
public class UserService {

    private final String standCustomPASSWORD= "e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e";
  @Autowired
     private SessionService oSessionService;
    @Autowired
    UserRepository oUserRepository;

    @Autowired
    HttpServletRequest oHttpServletRequest;
@Autowired
    private EmailService oEmailService;
 

    public UserEntity get(Long id) {
        oSessionService.onlyAdminsOrUsers();
        return oUserRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
    public void sendEmail(UserEntity user) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getEmail());
        mailMessage.setSubject("Complete Registration!");
        mailMessage.setText("To confirm your account, please click here : "
                + "http://localhost:4200/user/confirm-account?token=" + user.getToken());
        oEmailService.sendEmail(mailMessage);
    }
    public UserEntity getByEmail(String email) {
        return oUserRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found by email"));
    }

     public UserEntity getByTokenPassword(String tokenPassword) {
        return oUserRepository.findByTokenPassword(tokenPassword)
                .orElseThrow(() -> new ResourceNotFoundException("User not found by token"));
    }
    /*
     * Confirm email
     */
    

 public Page<UserEntity> getPage(Pageable pageable, String filter) {
    Page<UserEntity> page;

    // Verificar si el filtro está vacío o nulo
    if (filter == null || filter.isEmpty() || filter.trim().isEmpty()) {
        // Si el filtro está vacío o nulo

        // Verificar si el usuario es un administrador
        if (oSessionService.isAdmin()) {
            // Si el usuario es un administrador, devolver todos los usuarios
            page = oUserRepository.findAll(pageable);
        } else {
            // Si el usuario no es un administrador, devolver una página vacía
            page = Page.empty();
        }
    } else {
        // Si hay un filtro

        // Buscar usuarios que coincidan con el filtro en el nombre, apellido y otros campos
        page = oUserRepository.findByUserByNameOrSurnameOrLastnameContainingIgnoreCase(
                filter, filter, filter, filter, pageable);
    }

    // Devolver la página de usuarios
    return page;
}

  

   public Long create(UserEntity oUserEntity) {
        oSessionService.onlyAdmins();
        oUserEntity.setId(null);
        oUserEntity.setPassword(standCustomPASSWORD);
        oUserEntity.setToken(UUID.randomUUID().toString()); // genero el token    
        oUserRepository.save(oUserEntity);
        this.sendEmail(oUserEntity); // envio el email
        return oUserEntity.getId();        
    }

    public Long createForUsers(UserEntity oUserEntity) {
        oUserEntity.setId(null);
        oUserEntity.setPassword(standCustomPASSWORD);
        oUserEntity.setToken(UUID.randomUUID().toString()); // genero el token
        oUserEntity.setRole(true); // role = true -> user
        oUserRepository.save(oUserEntity);
        this.sendEmail(oUserEntity); // envio el email
        return oUserEntity.getId();
    }

    /**
     * Send email to user with token
     * 
     * @param user
     */
 
    

    /*
     * Confirm email
     */
    public ResponseEntity<?> confirmCorreo(String tokenVerificacion, String password) {
        UserEntity oUser = oUserRepository.findByToken(tokenVerificacion)
                .orElseThrow(() -> new RuntimeException("Token not found when validatimg token"));
        oUser.setVerified(true);
        oUser.setToken(null);
        oUser.setPassword(password);
        oUserRepository.save(oUser);
        return ResponseEntity.ok("Email verified successfully!");
    }
    public UserEntity update(UserEntity updatedUserEntity) {


         UserEntity oUserEntityFromDatabase = this.get(updatedUserEntity.getId());
        oSessionService.onlyAdminsOrUsersWithIisOwnData(oUserEntityFromDatabase.getId());
        if (oSessionService.isUser()) {
            
            updatedUserEntity.setRole(oUserEntityFromDatabase.getRole());
            updatedUserEntity.setPassword(standCustomPASSWORD );
            return oUserRepository.save(oUserEntityFromDatabase);
        } else {
            
            updatedUserEntity.setPassword(standCustomPASSWORD );
            return oUserRepository.save(oUserEntityFromDatabase);
        }
       
    }
    public Long delete(Long id) {
        oSessionService.onlyAdmins();
        oUserRepository.deleteById(id);
        return id;
    }
   
    public UserEntity getOneRandom() {
      oSessionService.onlyAdmins();
        Pageable oPageable = PageRequest.of((int) (Math.random() * oUserRepository.count()), 1);
        return oUserRepository.findAll(oPageable).getContent().get(0);
    }
    public ResponseEntity<?> confirmCorreo(String tokenVerificacion) {
        UserEntity oUser = oUserRepository.findByToken(tokenVerificacion)
                .orElseThrow(() -> new RuntimeException("Token not found when validatimg token"));
        oUser.setVerified(true);
        oUser.setToken(null);
        oUserRepository.save(oUser);
        return ResponseEntity.ok("Email verified successfully!");        
    }
public Long populate(Integer amount) {
  oSessionService.onlyAdmins();
    for (int i = 0; i < amount; i++) {
        UserEntity usuario = new UserEntity();
        usuario.setNombre("usuario" + i);
     usuario.setEmail("email"+i+"@gmail.com");
        usuario.setTelefono("1234567" + i);
        usuario.setRole(false);
        usuario.setUsername("mitio"+i);
        usuario.setPassword( "e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e" );
        oUserRepository.save(usuario);
    }
    return amount.longValue();
}
public Long empty() {
  oSessionService.onlyAdmins();
    oUserRepository.deleteAll();
    oUserRepository.resetAutoIncrement();
    oUserRepository.flush();
    return oUserRepository.count();
}
   public UserEntity getByUsername(String username) {
        return oUserRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found by username"));
    }
}