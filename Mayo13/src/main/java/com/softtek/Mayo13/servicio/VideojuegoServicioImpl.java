package com.softtek.Mayo13.servicio;

import com.softtek.Mayo13.modelo.Videojuego;
import com.softtek.Mayo13.repo.IGenericoRepositorio;
import com.softtek.Mayo13.repo.IVideojuegoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideojuegoServicioImpl extends CRUDImpl<Videojuego,Integer> implements IVideojuegoServicio{
    @Autowired
    private IVideojuegoRepositorio repo;

    @Override
    protected IGenericoRepositorio<Videojuego, Integer> getRepo() {
        return repo;
    }
}
