package ldifabio.recursosapi;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController()
@RequestMapping("/usuarios")
public class UsersController {

    @GetMapping("/{usuarioId}")
    public Usuario getUsuario(@PathVariable Long usuarioId) {

        log.info("Request for user " + usuarioId + " received");
        Usuario usuario = new Usuario(usuarioId);
        usuario.setUserName("usuario" + usuarioId.toString());

        return usuario;
    }

    @DeleteMapping("/{usuarioId}")
    public void deleteUsuario(@PathVariable long usuarioId) {
        log.info("Delete user request for user " + usuarioId + " received");
        //Acá ser borraría
        //repositorio.deleteUser(usuarioId)
    }
}

