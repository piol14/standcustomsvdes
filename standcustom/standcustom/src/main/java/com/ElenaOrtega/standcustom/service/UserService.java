package com.ElenaOrtega.standcustom.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ElenaOrtega.standcustom.exception.ResourceNotFoundException;
import com.ElenaOrtega.standcustom.entity.PartidaEntity;
import com.ElenaOrtega.standcustom.entity.UserEntity;
import com.ElenaOrtega.standcustom.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;


@Service
public class UserService {

    private final String foxforumPASSWORD = "e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e";

    @Autowired
    UserRepository oUserRepository;

    @Autowired
    HttpServletRequest oHttpServletRequest;

 

    public UserEntity get(Long id) {
        return oUserRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

  

    public Page<UserEntity> getPage(Pageable pageable, String filter) {
      
        
        Page<UserEntity> page;

       
            page = oUserRepository.findAll(pageable);
     
        return page;
    }

  

    public Long create(UserEntity oUserEntity) {
      
        oUserEntity.setId(null);
        oUserEntity.setPassword(foxforumPASSWORD);
        return oUserRepository.save(oUserEntity).getId();
    }

    public UserEntity update(UserEntity updatedUserEntity) {
        UserEntity oUserEntityFromDatabase = this.get(updatedUserEntity.getId());
        return oUserRepository.save(updatedUserEntity);
    }

    public Long delete(Long id) {
      
        oUserRepository.deleteById(id);
        return id;
    }
   
    public UserEntity getOneRandom() {
      
        Pageable oPageable = PageRequest.of((int) (Math.random() * oUserRepository.count()), 1);
        return oUserRepository.findAll(oPageable).getContent().get(0);
    }

public Long populate(Integer amount) {
  
    for (int i = 0; i < amount; i++) {
        UserEntity usuario = new UserEntity();
        usuario.setNombre("Cliente" + i);
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
  
    oUserRepository.deleteAll();
    oUserRepository.resetAutoIncrement();
    oUserRepository.flush();
    return oUserRepository.count();
}

}


