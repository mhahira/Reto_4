/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto_4.servicios;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Reto_4.modelo.Ortesis;
import Reto_4.repositorio.RepositorioOrtesis;

/**
 *
 * @author USUARIO
 */
@Service
public class ServiciosOrtesis {
     @Autowired
    private RepositorioOrtesis metodosCrud;
    
    public List<Ortesis> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Ortesis> getOrthesis(int idOrthesis){
        return metodosCrud.getOrthesis(idOrthesis);
    }
    
    public Ortesis save(Ortesis orthesis){
        if(orthesis.getId()==null){
            return metodosCrud.save(orthesis);
        }else{
            Optional<Ortesis> evt=metodosCrud.getOrthesis(orthesis.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(orthesis);
            }else{
                return orthesis;
            }
        }
    }
    public Ortesis update(Ortesis ortesis){
        if(ortesis.getId()!=null){
            Optional<Ortesis> e=metodosCrud.getOrthesis(ortesis.getId());
            if(!e.isEmpty()){
                if(ortesis.getName()!=null){
                    e.get().setName(ortesis.getName());
                }
                if(ortesis.getBrand()!=null){
                    e.get().setBrand(ortesis.getBrand());
                }
                if(ortesis.getYear()!=null){
                    e.get().setYear(ortesis.getYear());
                }
                if(ortesis.getDescription()!=null){
                    e.get().setDescription(ortesis.getDescription());
                }
                if(ortesis.getCategory()!=null){
                    e.get().setCategory(ortesis.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return ortesis;
            }
        }else{
            return ortesis;
        }
    }


    public boolean deleteOrtesis(int ortesisId) {
        Boolean aBoolean = getOrthesis(ortesisId).map(ortesis -> {
            metodosCrud.delete(ortesis);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
