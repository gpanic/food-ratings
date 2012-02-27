package kis.dao;

import java.util.List;

public interface DAO<DataType, IdType> {
	
	public boolean create(DataType data);
	
	public DataType read(IdType id);
	
	public boolean update(IdType id, DataType data);
	
	public boolean delete(IdType id);
	
	public List<DataType> list();

}
