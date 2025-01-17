package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.ItemInformationDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;

public interface ItemInformationModelInt {
	long add(ItemInformationDTO dto)throws ApplicationException,DuplicateRecordException;
	public void delete(ItemInformationDTO dto)throws ApplicationException;
	public void update(ItemInformationDTO dto)throws ApplicationException,DuplicateRecordException;
	public List list()throws ApplicationException;
	public List list(int pageNo,int pageSize)throws ApplicationException;
	public List search(ItemInformationDTO dto)throws ApplicationException;
	public List search(ItemInformationDTO dto,int pageNo,int pageSize)throws ApplicationException;
	public ItemInformationDTO findByPK(long pk)throws ApplicationException;
	public ItemInformationDTO findByName(String name)throws ApplicationException;

}
