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

        Atleta a1 = new Atleta("aaa", "sdf", "Española", LocalDate.of(1991, 11, 29));
        atletaRepository.save(a1);
        Atleta a2 = new Atleta("bbb", "fj", "Fracesa", LocalDate.of(1924, 11, 29));
        atletaRepository.save(a2);
        Atleta a3 = new Atleta("ccc", "rty", "Inglesa", LocalDate.of(1942, 2, 25));
        atletaRepository.save(a3);
        Atleta a4 = new Atleta("ddd", "yuk", "Estadounidense", LocalDate.of(1965, 12, 26));
        atletaRepository.save(a4);
        Atleta a5 = new Atleta("eee", "jkg", "Japones", LocalDate.of(1953, 5, 22));
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
