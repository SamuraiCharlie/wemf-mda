package tech.gearsofcode.wemf.reveng.database.sql;

import java.util.List;
import java.util.Optional;

import tech.gearsofcode.wemf.reveng.database.model.DataType;

/**
 * Represents a group of Data Types for some database technology.
 * 
 * @author SamuraiCharlie
 * */
public interface DatabaseTypes {

	/**
	 * Enumerates all the available data types.
	 * */
	public abstract List<DataType> getDatabaseTypes();
	public DataType fromJavaClass(Class<?> c);
	public default DataType getByTypeName(String typeName) {
		String searchName = typeName.toLowerCase();
		int index = searchName.indexOf("(");
		if (index>0) searchName = searchName.substring(0, index);
		final String compareName = searchName.trim();
		Optional<DataType> dt = getDatabaseTypes().stream().filter(dataType -> dataType.getName().equalsIgnoreCase(compareName)).findFirst();
		if (dt.isPresent()) return dt.get();
		throw new IllegalArgumentException("Unknow datatype: '" + typeName + "'");
	}
}
