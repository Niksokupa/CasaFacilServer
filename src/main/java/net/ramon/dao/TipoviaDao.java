package net.ramon.dao;

import java.sql.Connection;
import net.ramon.dao.genericDaoImplementation.GenericDaoImplementation;
import net.ramon.dao.publicDaoInterface.DaoInterface;

/**
 *
 * @author Ramón
 */

public class TipoviaDao extends GenericDaoImplementation implements DaoInterface {

	public TipoviaDao(Connection oConnection, String ob) {
		super(oConnection, ob);
	}
}
