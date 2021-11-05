/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto_4.repositorio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import Reto_4.interfaces.InterfaceOrtesis;
import Reto_4.modelo.Mensaje;
import Reto_4.modelo.Ortesis;

/**
 *
 * @author USUARIO
 */
@Repository
public class RepositorioOrtesis {
     @Autowired
    private InterfaceOrtesis crud;
    

    public List<Ortesis> getAll(){
        return (List<Ortesis>) crud.findAll();       
    }
    
    public Optional <Ortesis> getOrthesis(int id){
        return crud.findById(id);
    }
    
    public Ortesis save(Ortesis ortesis){
        return crud.save(ortesis);
    }
      public void delete(Ortesis ortesis){
        crud.delete(ortesis);
    }
    
    
}
