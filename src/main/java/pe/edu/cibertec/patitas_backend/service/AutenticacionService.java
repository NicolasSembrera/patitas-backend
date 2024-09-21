package pe.edu.cibertec.patitas_backend.service;

import pe.edu.cibertec.patitas_backend.dto.LoginRequestDTO;

import java.io.IOException;

public interface AutenticacionService {
    String[] varlidarUsuario(LoginRequestDTO loginRequestDTO) throws IOException;
}
