package tech.gearsofcode.wemf.reveng.database.sql;

import tech.gearsofcode.wemf.reveng.database.sql.java.DynamicDataTypes;
import tech.gearsofcode.wemf.reveng.database.sql.mysql.MySQLDatabaseTypes;
import tech.gearsofcode.wemf.reveng.database.sql.oracle.OracleDatabaseTypes;

/**
 * Factory of database types.
 * 
 * @TODO: refactor to allow more than one technology. Currently, only ORACLE and MYSQL are
 *        supported.
 *        
 * @author SamuraiCharlie
 * */
public class DatabaseTypesFactory {

	public enum SupportedDatabases {
		ORACLE, REVERSE_ENGINEERED, MYSQL
	};

	private static SupportedDatabases selectedDatabase = SupportedDatabases.MYSQL;



	public static DatabaseTypes getDatabaseTypes() {
		switch (selectedDatabase) {
			case REVERSE_ENGINEERED:
				return DynamicDataTypes.instance();
			case MYSQL:
				return new MySQLDatabaseTypes();
			case ORACLE:
			default:
				return new OracleDatabaseTypes();
		}
	}



	public static void selectedDatabase(SupportedDatabases selectedDatabase) {
		DatabaseTypesFactory.selectedDatabase = selectedDatabase;
	}
}
