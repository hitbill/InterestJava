package br.com.interestMe.service;

import java.util.List;


public interface IGenericService<T,K> {
    
    public List<T> todos();
    public T obter(K id);
    public String excluir(K id);
    public String salvar(T entity);
}
