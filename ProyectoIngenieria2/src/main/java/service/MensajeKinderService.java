/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import modelo.MensajeKinder;


/**
 *
 * @author david
 */
public interface MensajeKinderService {

    MensajeKinder findbyCodigo(Long codigo);

    void save(MensajeKinder contacto);

    void DeletebyCodigo(Long codigo);

    List<MensajeKinder> findAll();

    void UpdateMensajeKinder(MensajeKinder contacto);
}
