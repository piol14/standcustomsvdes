package com.ElenaOrtega.standcustom.helper;

import com.ElenaOrtega.standcustom.entity.StandEntity;
import com.ElenaOrtega.standcustom.repository.StandRepository;
import com.ElenaOrtega.standcustom.service.SessionService;
import com.ElenaOrtega.standcustom.service.UserService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public class StandPopulator {
SessionService oSessionService;
    StandRepository standRepository;
    UserService userService;
    

    public Long populateFromJson(String jsonFilePath) {
        
       

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode standsNode = objectMapper.readTree(new File("C:/Users/Usuario/Documents/standcustomservidor-1-3/standcustom/standcustom/src/main/java/com/ElenaOrtega/json/stands.json"));


            for (JsonNode standNode : standsNode) {
                StandEntity stand = new StandEntity();

                // Leer datos del JSON y asignarlos al objeto StandEntity
                stand.setNombre(standNode.path("nombre").asText());
                stand.setDescripcion(standNode.path("descripcion").asText());
                stand.setImagen(standNode.path("imagen").asText());
                stand.setVelocidad(standNode.path("velocidad").asText());
                stand.setAlcance(standNode.path("alcance").asText());
                stand.setPoder(standNode.path("poder").asText());
                stand.setDesarollo(standNode.path("desarollo").asText());
                stand.setAcierto(standNode.path("acierto").asText());
                stand.setAguante(standNode.path("aguante").asText());

                
                
                //stand.setUsuario(userService.getOneRandom());

                // Guardar el stand en la base de datos
                standRepository.save(stand);
            }

           return (long) standsNode.size();


        } catch (IOException e) {
            e.printStackTrace();
            return 0L;
        }
    }
}
