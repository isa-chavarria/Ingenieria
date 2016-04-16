/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import modelo.Enfermedad;
import modelo.Informacion;

/**
 *
 * @author david
 */
public interface InformacionService {

    Informacion findbyCodigo(Long codigo);

    void save(Informacion matricula);

    void DeletebyCodigo(Long codigo);

    List<Informacion> findAll();

    void UpdateInformacion(Informacion matricula);
}
