package net.ramon.dao;

import java.sql.Connection;
import net.ramon.dao.genericDaoImplementation.GenericDaoImplementation;
import net.ramon.dao.publicDaoInterface.DaoInterface;

/**
 *
 * @author Ramón
 */

public class CiudadDao extends GenericDaoImplementation implements DaoInterface {

	public CiudadDao(Connection oConnection, String ob) {
		super(oConnection, ob);
	}
}
