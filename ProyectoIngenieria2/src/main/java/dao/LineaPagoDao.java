/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.LineaPago;

public interface LineaPagoDao {
    LineaPago findbyId(String id);
    void save(LineaPago lineaPago);
    void DeletebyId(String id);
    List<LineaPago> findAll();
}
