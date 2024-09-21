package pe.edu.cibertec.patitas_backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.patitas_backend.dto.LoginRequestDTO;
import pe.edu.cibertec.patitas_backend.service.AutenticacionService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

@Service
public class AutenticacionServiceImpl implements AutenticacionService {

    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public String[] varlidarUsuario(LoginRequestDTO loginRequestDTO) throws IOException{
        String[] datoUsuarios = null;
        Resource resource = resourceLoader.getResource("classpath:usuarios.txt");

        try(BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))) {

            String linea;
            while((linea = br.readLine()) != null){
                String[] dato = (linea.split(";"));
                if(loginRequestDTO.tipoDocumento().equals(dato[0]) &&
                        loginRequestDTO.numeroDocumento().equals(dato[1]) && loginRequestDTO.password().equals(dato[2])){

                    datoUsuarios = new String[2];
                    datoUsuarios[0] = dato[3];
                    datoUsuarios[1] = dato[4];
                    break;
                };
            }

        } catch (IOException e){
            datoUsuarios = null;
            throw new IOException(e);
        }

        return datoUsuarios;
    }
}
