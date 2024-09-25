package pe.edu.cibertec.patitas_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pe.edu.cibertec.patitas_backend.dto.LoginRequestDTO;
import pe.edu.cibertec.patitas_backend.dto.LoginResponseDTO;
import pe.edu.cibertec.patitas_backend.service.AutenticacionService;

import java.io.IOException;

@RestController
@RequestMapping("/autenticacion")
public class AutenticacionController {

    @Autowired
    AutenticacionService autenticacionService;

    @PostMapping("/login")
    public LoginResponseDTO Login(@RequestBody LoginRequestDTO loginRequestDTO){

        try {
            String[] datosUsuario = autenticacionService.varlidarUsuario(loginRequestDTO);
            if (datosUsuario == null){
                return new LoginResponseDTO("01","Error : Usuarion no Encontrado","", "");
            }

            return new LoginResponseDTO("00","",datosUsuario[0], datosUsuario[1]);

        } catch (IOException e) {
            return new LoginResponseDTO("99", "Error : Ocurrio un problema","", "");
        }

    }

}
