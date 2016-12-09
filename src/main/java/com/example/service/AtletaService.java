package com.example.service;

import com.example.domain.Atleta;
import com.example.domain.Medalla;
import com.example.domain.TipoMedalla;
import com.example.repository.AtletaRepository;
import com.example.repository.MedallaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AtletaService {
    @Autowired
    private AtletaRepository atletaRepository;
    @Autowired
    private MedallaRepository medallaRepository;
    public void testAtletas(){
        Atleta a1 = new Atleta("Fulanito", "Tal", "Española", LocalDate.of(1990, 10, 29));
        atletaRepository.save(a1);
        Atleta a2 = new Atleta("Benganito", "Tal", "Española", LocalDate.of(1994, 1, 9));
        atletaRepository.save(a2);
        Atleta a3 = new Atleta("Menganito", "Prueba", "Inglesa", LocalDate.of(1992, 8, 5));
        atletaRepository.save(a3);
        Atleta a4 = new Atleta("Atletilla", "Aaaa", "Italiano", LocalDate.of(1996, 12, 16));
        atletaRepository.save(a4);
        Atleta a5 = new Atleta("Crack", "Mundial", "Madagascar", LocalDate.of(1988, 3, 14));
        atletaRepository.save(a5);

        Medalla m1 = new Medalla(TipoMedalla.valueOf("ORO"),"Atletismo", "1", a1);
        Medalla m2 = new Medalla(TipoMedalla.valueOf("ORO"),"Ciclismo", "1", a3);
        Medalla m3 = new Medalla(TipoMedalla.valueOf("PLATA"),"Atletismo", "1", a4);
        Medalla m4 = new Medalla(TipoMedalla.valueOf("BRONCE"),"Ciclismo", "1", a2);
        Medalla m5 = new Medalla(TipoMedalla.valueOf("BRONCE"),"Baloncesto", "1", a5);
        medallaRepository.save(m1);
        medallaRepository.save(m2);
        medallaRepository.save(m3);
        medallaRepository.save(m4);
        medallaRepository.save(m5);
    }
}
