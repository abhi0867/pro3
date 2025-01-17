package in.co.rays.project_3.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import in.co.rays.project_3.dto.ItemInformationDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.util.HibDataSource;

public class ItemInformationModelHibImp implements ItemInformationModelInt {
	
	@Override
	public long add(ItemInformationDTO dto) throws ApplicationException, DuplicateRecordException {
		Session session = null;
		Transaction tx = null;
//		ItemInformationDTO duplicateCollegeName = fingByName(dto.getProductName());
//		if (duplicateCollegeName != null) {
//			throw new DuplicateRecordException("college name already exist");
//		}
		try {
			session = HibDataSource.getSession();
			tx = session.beginTransaction();
			session.save(dto);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();

			}
			throw new ApplicationException("Exception in college Add " + e.getMessage());
		} finally {
			session.close();
		}
		return dto.getId();
	}

	@Override
	public void delete(ItemInformationDTO dto) throws ApplicationException {
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
			throw new ApplicationException("Exception in college Delete" + e.getMessage());
		} finally {
			session.close();
		}

	}

	@Override
	public void update(ItemInformationDTO dto) throws ApplicationException, DuplicateRecordException {
		Session session = null;
		Transaction tx = null;

		try {
			session = HibDataSource.getSession();
			tx = session.beginTransaction();
			System.out.println("before update");

			session.saveOrUpdate(dto);
			System.out.println("after update");
			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
			throw new ApplicationException("Exception in college update" + e.getMessage());
		} finally {
			session.close();
		}

	}

	@Override
	public List list() throws ApplicationException {
		return list(0, 0);
	}

	@Override
	public List list(int pageNo, int pageSize) throws ApplicationException {
		Session session = null;
		List list = null;
		try {
			session = HibDataSource.getSession();
			Criteria criteria = session.createCriteria(ItemInformationDTO.class);
			if (pageSize > 0) {
				pageNo = ((pageNo - 1) * pageSize) + 1;
				criteria.setFirstResult(pageNo);
				criteria.setMaxResults(pageSize);
			}
			list = criteria.list();

		} catch (HibernateException e) {

			throw new ApplicationException("Exception : Exception in  College list");
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public List search(ItemInformationDTO dto) throws ApplicationException {
		return search(dto, 0, 0);

	}

	@Override
	public List search(ItemInformationDTO dto, int pageNo, int pageSize) throws ApplicationException {
		Session session = null;
		List list = null;
		try {
			session = HibDataSource.getSession();
			Criteria criteria = session.createCriteria(ItemInformationDTO.class);
			if (dto.getId() != null && dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));

			}
			if (dto.getTitle() != null && dto.getTitle().length() > 0) {
				criteria.add(Restrictions.like("title", dto.getTitle() + "%"));
			}
			if (dto.getOverview() != null && dto.getOverview().length() > 0) {
				criteria.add(Restrictions.like("overview", dto.getOverview()+ "%"));
			}
			if (dto.getCost() != null && dto.getCost() > 0) {
				criteria.add(Restrictions.like("cost", dto.getCost()+ "%"));
			}
			if (dto.getPurchasedate() != null && dto.getPurchasedate().getTime() > 0) {
				criteria.add(Restrictions.like("purchasedate", dto.getPurchasedate() + "%"));
			}
			if (dto.getCategory() != null && dto.getCategory().length() > 0) {
				criteria.add(Restrictions.like("category", dto.getCategory()+ "%"));
			}
			
			
			if (pageSize > 0) {
				criteria.setFirstResult((pageNo - 1) * pageSize);
				criteria.setMaxResults(pageSize);

			}
			list = criteria.list();
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new ApplicationException("Exception in college search");
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public ItemInformationDTO findByPK(long pk) throws ApplicationException {
		System.out.println("======" + pk + "----------------------------------");
		Session session = null;
		ItemInformationDTO dto = null;
		try {
			session = HibDataSource.getSession();

			dto = (ItemInformationDTO) session.get(ItemInformationDTO.class, pk);
			System.out.println(dto);
		} catch (HibernateException e) {

			throw new ApplicationException("Exception : Exception in getting course by pk");
		} finally {
			session.close();
		}
		System.out.println("++++" + dto);
		return dto;
	}

	@Override
	public ItemInformationDTO findByName(String name) throws ApplicationException {
		Session session = null;
		ItemInformationDTO dto = null;
		try {
			session = HibDataSource.getSession();
			Criteria criteria = session.createCriteria(ItemInformationDTO.class);
			criteria.add(Restrictions.eq("name", name));
			List list = criteria.list();
			if (list.size() == 1) {
				dto = (ItemInformationDTO) list.get(0);
			}
		} catch (HibernateException e) {

			throw new ApplicationException("Exception in getting User by Login " + e.getMessage());

		} finally {
			session.close();
		}
		return dto;
	}

	


	

}
