package br.com.interestMe.service.impl;

import br.com.interestMe.service.IGenericService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


public class GenericService<T,K> implements IGenericService<T, K>{

    @PersistenceContext
    private EntityManager em;
    
    private final Class<T> persistentClass;
     
    public GenericService(Class persistentClass){
        
        this.persistentClass = persistentClass;
      
    }
   
    @Override
    public String salvar(T entity) {  
        try{
          
            em.merge(entity);
            return null;            
        }catch(Exception ex){
            return "Erro: "+ex.getMessage();
        }
    }

    @Override
    public String excluir(K id) {
       try{
           T m = obter(id);
           em.remove(m);
           return null;
       }catch(Exception ex){
           return "Erro: "+ ex.getMessage();
       }
    }

    @Override
    public T obter(K id) {
       return em.find(persistentClass, id);
    }

    @Override
    public List<T> todos() {

        TypedQuery<T> query 
           = em.createQuery("select c from "+ 
                    persistentClass.getSimpleName() +" as c", persistentClass);
        
        return query.getResultList();
    }
    
} 
