package com.softtek.Mayo13.controlador;

import com.softtek.Mayo13.modelo.Videojuego;
import com.softtek.Mayo13.servicio.IVideojuegoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/videojuegos")
@CrossOrigin(origins = "http://localhost:4200")
public class VideojuegoControlador {

    @Autowired
    private IVideojuegoServicio servicio;

    @GetMapping
    public ResponseEntity<List<Videojuego>> consultarTodos(){
        return new ResponseEntity<>(servicio.consultarTodos(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Videojuego> crear(@RequestBody Videojuego v) {
        Videojuego vBBDD = servicio.crear(v);
        return new ResponseEntity<>(vBBDD, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Videojuego> consultarUno(@PathVariable("id") int id){
        Videojuego cm = servicio.consultaUno(id);
        return new ResponseEntity<>(cm, HttpStatus.OK);

    }

    @PutMapping
    public ResponseEntity<Videojuego> modificar(@RequestBody Videojuego v) {
        Videojuego vBBDD = servicio.consultaUno(v.getId());
        return new ResponseEntity<>(servicio.modificar(v), HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        servicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
