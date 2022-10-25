package ldifabio.recursosapi;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController()
@RequestMapping("/seguros")
public class SegurosController {

    @GetMapping("/{seguroId}")
    public Seguro getSeguro(@PathVariable Long seguroId) {

        log.info("Request for seguro " + seguroId + " received");
        Seguro seguro = new Seguro(seguroId);
        seguro.setNombre("seguro" + seguroId.toString());

        return seguro;
    }

    @DeleteMapping("/{seguroId}")
    public void deleteSeguro(@PathVariable long seguroId) {
        log.info("Delete user request for Seguro " + seguroId + " received");
        //Acá ser borraría
        //repositorio.deleteSeguro(seguroId)
    }
    class Seguro{
        Seguro(Long segId){
            this.seguroId = segId;
        }
        @Getter @Setter private Long seguroId;
        @Getter @Setter private String nombre;
    }
}

