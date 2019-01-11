package net.ramon.dao;

import java.sql.Connection;
import net.ramon.dao.genericDaoImplementation.GenericDaoImplementation;
import net.ramon.dao.publicDaoInterface.DaoInterface;

/**
 *
 * @author Ramón
 */

public class TipoinmuebleDao extends GenericDaoImplementation implements DaoInterface {

	public TipoinmuebleDao(Connection oConnection, String ob) {
		super(oConnection, ob);
	}
}
