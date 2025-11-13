package com.senai.ResourceScheduleSA;

import com.senai.ResourceScheduleSA.repositories.UsuarioRepository;
import com.senai.ResourceScheduleSA.services.UsuarioService;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Assertions;

public class TesteUsuario {
    UsuarioRepository repoMock = mock(UsuarioRepository.class);

    @Test
    void naoDeveAceitarSenhaComCaracterInvalido() {
        UsuarioService service = new UsuarioService(repoMock); // Esse bexiga aqui cria um mock do repository,
        // sendo assim não precisamos acessar o banco de dados para testar a regra de negocios da senha.
        Assertions.assertFalse(service.validarSenha("abc@123"));
    }

    @Test
    void deveAceitarSenhaValida() {
        UsuarioService service = new UsuarioService(repoMock);
        Assertions.assertTrue(service.validarSenha("abc123"));
    }
}
