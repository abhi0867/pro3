package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.CarDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;

public interface CarModelInt {
	
	 
		public long add(CarDTO dto)throws ApplicationException,DuplicateRecordException;
		public void delete(CarDTO dto)throws ApplicationException;
		public void update(CarDTO dto)throws ApplicationException,DuplicateRecordException;
		public List list()throws ApplicationException;
		public List list(int pageNo,int pageSize)throws ApplicationException;
		public List search(CarDTO dto)throws ApplicationException;
		public List search(CarDTO dto,int pageNo,int pageSize)throws ApplicationException;
		public CarDTO findByPK(long pk)throws ApplicationException;
		public CarDTO fingByName(String name)throws ApplicationException;
		

}
