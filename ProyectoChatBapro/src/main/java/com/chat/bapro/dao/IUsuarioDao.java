package com.chat.bapro.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chat.bapro.dto.UsuarioDto;
import com.chat.bapro.entity.Usuario;

@Repository(value="IUsuarioDao")
public class IUsuarioDao implements UsuarioDao {
	
	@PersistenceContext
	private EntityManager entity;

	@Transactional
	public void creacionDeUsuario(Usuario usuario)
	{

		this.entity.persist(usuario);		
		
		
	}
	
	
	public void modificacionDeUsuario(Usuario usuario)
	{
		
//falta		
	}
	
	
	public UsuarioDto buscarUnUsuario(long id)
	{
		UsuarioDto retorno = null;
		if(id >= 0)
		{
			
			retorno=entity.find(UsuarioDto.class, id);
		}
		return retorno;
	}
	
	
	@SuppressWarnings("unchecked")//esto es para sacar una advertencia
	@Transactional(readOnly=true)//esto porque es solo de lectura , si fuera de insercion , esta notacion no va
	@Override
	public List<Usuario> retornarTodosLosUsuarios() {
		
		return entity.createQuery("from Cliente").getResultList();
	}


	
	
	

}
