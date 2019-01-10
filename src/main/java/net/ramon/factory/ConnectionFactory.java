package net.ramon.factory;

import net.ramon.connection.publicinterface.ConnectionInterface;
import net.ramon.connection.specificimplementation.DBCPConnectionSpecificImplementation;
import net.ramon.connection.specificimplementation.BoneCPConnectionSpecificImplementation;
import net.ramon.connection.specificimplementation.C3P0ConnectionSpecificImplementation;
import net.ramon.connection.specificimplementation.HikariConnectionSpecificImplementation;
import net.ramon.connection.specificimplementation.ViburConnectionSpecificImplementation;
import net.ramon.constant.ConnectionConstants;

public class ConnectionFactory {
	public static ConnectionInterface getConnection(ConnectionConstants.EnumConstans enumConnection) {
		ConnectionInterface oConnectionInterface = null;
		switch (enumConnection) {
		case Hikari:
			oConnectionInterface = new HikariConnectionSpecificImplementation();
			break;
		case DBCP:
			oConnectionInterface = new DBCPConnectionSpecificImplementation();
			break;
		case BoneCP:
			oConnectionInterface = new BoneCPConnectionSpecificImplementation();
			break;
		case C3P0:
			oConnectionInterface = new C3P0ConnectionSpecificImplementation();
			break;
        case Vibur:
            oConnectionInterface = new ViburConnectionSpecificImplementation();
            break;
		default:
			oConnectionInterface = new HikariConnectionSpecificImplementation();
			break;
		}
		return oConnectionInterface;

	}
}
