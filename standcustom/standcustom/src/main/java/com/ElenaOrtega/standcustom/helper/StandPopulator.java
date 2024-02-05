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

// ... (otras importaciones)
@Service
public class StandPopulator {
SessionService oSessionService;
    StandRepository standRepository;
    UserService userService;
    // ... (otras declaraciones de la clase)

    public Long populateFromJson(String jsonFilePath) {
        
       

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode standsNode = objectMapper.readTree(new File("/json/stands.json"));

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

                // Establecer la relación entre el stand y el ataque stand (si es necesario)
                
                stand.setUsuario(userService.getOneRandom());

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
