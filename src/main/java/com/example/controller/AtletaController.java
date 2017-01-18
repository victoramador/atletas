package com.example.controller;

import com.example.domain.Atleta;
import com.example.repository.AtletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/atletas")
public class AtletaController {

    @Autowired
    private AtletaRepository atletaRepository;

    @GetMapping
    public List<Atleta> getAtletas(){
        return atletaRepository.findAll();
    }

    @GetMapping("/{nacionalidad}")
    public List<Atleta> getAtletasByNacionalidad(@PathVariable String nacionalidad){
        return atletaRepository.findAll().parallelStream().filter(atleta -> atleta.getNacionalidad().toLowerCase().equals(nacionalidad.toLowerCase())).collect(Collectors.toList());
    }

    @GetMapping("/nacimiento-antes/{nacimientoStr}")
    public List<Atleta> getAtletasNacimientoAntesDe(@PathVariable String nacimientoStr){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate nacimiento = LocalDate.parse(nacimientoStr, formatter);
        return atletaRepository.findAll().parallelStream().filter(atleta -> atleta.getNacimiento().isBefore(nacimiento)).collect(Collectors.toList());
    }

    @GetMapping("/groupby/nacionalidad")
    public Map<String, List<Atleta>> getAtletasGroupByNacionalidad(){
            return atletaRepository.findAll().parallelStream().collect(Collectors.groupingBy(Atleta::getNacionalidad));
    }
}
