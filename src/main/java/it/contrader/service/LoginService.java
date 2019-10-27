package it.contrader.service;

import java.security.NoSuchAlgorithmException;

import it.contrader.converter.UserConverter;
import it.contrader.dao.LoginDAO;
import it.contrader.dto.UserDTO;

public class LoginService {

	private LoginDAO dao;
	
	private UserConverter converter;
	/**
	 * Costruttore della classe, crea un oggetto di tipo LoginDAO per poter chiamare il metodo del DAO
	 */
	public LoginService() {
		this.dao = new LoginDAO();
		this.converter = new UserConverter();
	}

	/**
	 * Chiama il metodo del DAO e ottiene una stringa (lo usertype)
	 * @return 
	 * @throws NoSuchAlgorithmException 
	 */
	public UserDTO login(String username, String password) throws NoSuchAlgorithmException {
		return converter.toDTO(dao.login(username, password));
	}
}
