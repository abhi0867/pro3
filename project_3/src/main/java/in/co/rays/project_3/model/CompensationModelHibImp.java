package in.co.rays.project_3.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import in.co.rays.project_3.dto.CompensationDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.util.HibDataSource;

public class CompensationModelHibImp implements CompensationModelInt{
	
	@Override
	public long add(CompensationDTO dto) throws ApplicationException, DuplicateRecordException {

		CompensationDTO existDto = null;

		Session session = HibDataSource.getSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			session.save(dto);

			dto.getId();
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();

			}
			throw new ApplicationException("Exception in Order Add " + e.getMessage());
		} finally {
			session.close();
		}

		return dto.getId();
	}

	@Override
	public void delete(CompensationDTO dto) throws ApplicationException {

		Session session = null;
		Transaction tx = null;
		try {
			session = HibDataSource.getSession();
			tx = session.beginTransaction();
			session.delete(dto);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new ApplicationException("Exception in Order Delete" + e.getMessage());
		} finally {
			session.close();
		}

	}

	@Override
	public void update(CompensationDTO dto) throws ApplicationException, DuplicateRecordException {

		Session session = null;

		Transaction tx = null;

		try {
			session = HibDataSource.getSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(dto);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new ApplicationException("Exception in Order update" + e.getMessage());
		} finally {
			session.close();
		}
	}

	@Override
	public CompensationDTO findByPK(long pk) throws ApplicationException {

		Session session = null;
		CompensationDTO dto = null;
		try {
			session = HibDataSource.getSession();
			dto = (CompensationDTO) session.get(CompensationDTO.class, pk);

		} catch (HibernateException e) {
			throw new ApplicationException("Exception : Exception in getting Product by pk");
		} finally {
			session.close();
		}

		return dto;
	}

	

	@Override
	public List list() throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List list(int pageNo, int pageSize) throws ApplicationException {

		Session session = null;
		List list = null;
		try {
			session = HibDataSource.getSession();
			Criteria criteria = session.createCriteria(CompensationDTO.class);
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult(pageNo);
				criteria.setMaxResults(pageSize);

			}
			list = criteria.list();

		} catch (HibernateException e) {
			throw new ApplicationException("Exception : Exception in  Order list");
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public List search(CompensationDTO dto, int pageNo, int pageSize) throws ApplicationException {

		Session session = null;
		ArrayList<CompensationDTO> list = null;
		try {
			session = HibDataSource.getSession();
			Criteria criteria = session.createCriteria(CompensationDTO.class);
			if (dto != null) {
				if (dto.getId() != null && dto.getId() > 0) {
					criteria.add(Restrictions.eq("id", dto.getId()));
				}
				
				
		
				 
				if (dto.getStaffMember() != null && dto.getStaffMember().length() > 0) {
					criteria.add(Restrictions.like("staffMember", dto.getStaffMember() + "%"));
				}
				
				if (dto.getPaymentAmount() != null && dto.getPaymentAmount().length() > 0) {
					criteria.add(Restrictions.like("paymentAmount", dto.getPaymentAmount() + "%"));
				}

				
				if (dto.getDateApplied() != null && dto.getDateApplied().getDate() > 0) {
					criteria.add(Restrictions.eq("DateApplied", dto.getDateApplied()));
				}
				if (dto.getState()!= null && dto.getState().length() > 0) {
					criteria.add(Restrictions.like("State", dto.getState() + "%"));
				}

				
			
				
			}

			System.out.println("searchcalll");
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult(pageNo);
				criteria.setMaxResults(pageSize);
			}
			list = (ArrayList<CompensationDTO>) criteria.list();
		} catch (HibernateException e) {
			throw new ApplicationException("Exception in Order search");
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public List search(CompensationDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompensationDTO fingByName(String name) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}


}
