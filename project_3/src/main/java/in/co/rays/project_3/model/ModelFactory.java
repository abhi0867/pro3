
package in.co.rays.project_3.model;

import java.util.HashMap;
import java.util.ResourceBundle;

/**
 * ModelFactory decides which model implementation run
 * 
 * @author Anshul Prajapati
 *
 */
public final class ModelFactory {

	private static ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.project_3.bundle.system");
	private static final String DATABASE = rb.getString("DATABASE");
	private static ModelFactory mFactory = null;
	private static HashMap modelCache = new HashMap();

	private ModelFactory() {

	}

	public static ModelFactory getInstance() {
		if (mFactory == null) {
			mFactory = new ModelFactory();
		}
		return mFactory;
	}

	

	public MarksheetModelInt getMarksheetModel() {
		MarksheetModelInt marksheetModel = (MarksheetModelInt) modelCache.get("marksheetModel");
		if (marksheetModel == null) {
			
			
			if ("Hibernate".equals(DATABASE)) {
				marksheetModel = new MarksheetModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				marksheetModel = new MarksheetModelJDBCImpl();
			}
			modelCache.put("marksheetModel", marksheetModel);
		}
		return marksheetModel;
	}

	public CollegeModelInt getCollegeModel() {
		CollegeModelInt collegeModel = (CollegeModelInt) modelCache.get("collegeModel");
		if (collegeModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				collegeModel = new CollegeModelHibImp();

			}
			if ("JDBC".equals(DATABASE)) {
				collegeModel = new CollegeModelJDBCImpl();
			}
			modelCache.put("collegeModel", collegeModel);
		}
		return collegeModel;
	}

	public RoleModelInt getRoleModel() {
		RoleModelInt roleModel = (RoleModelInt) modelCache.get("roleModel");
		if (roleModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				roleModel = new RoleModelHibImp();

			}
			if ("JDBC".equals(DATABASE)) {
				roleModel = new RoleModelJDBCImpl();
			}
			modelCache.put("roleModel", roleModel);
		}
		return roleModel;
	}

	public UserModelInt getUserModel() {

		UserModelInt userModel = (UserModelInt) modelCache.get("userModel");
		if (userModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				userModel = new UserModelHibImp();
			}
			
			
			modelCache.put("userModel", userModel);
		}

		return userModel;
	}
	public ProductModelInt getProductModel() {
		ProductModelInt productModel = (ProductModelInt) modelCache.get("productModel");
		if (productModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				productModel = new ProductModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				productModel = new ProductModelHibImp();
			}
			modelCache.put("productModel", productModel);
		}
		return productModel;
	}
	public StudentModelInt getStudentModel() {
		StudentModelInt studentModel = (StudentModelInt) modelCache.get("studentModel");
		if (studentModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				studentModel = new StudentModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				studentModel = new StudentModelJDBCImpl();
			}
			modelCache.put("studentModel", studentModel);
		}

		return studentModel;
	}

	public CourseModelInt getCourseModel() {
		CourseModelInt courseModel = (CourseModelInt) modelCache.get("courseModel");
		if (courseModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				courseModel = new CourseModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				courseModel = new CourseModelJDBCImpl();
			}
			modelCache.put("courseModel", courseModel);
		}

		return courseModel;
	}

	public TimetableModelInt getTimetableModel() {

		TimetableModelInt timetableModel = (TimetableModelInt) modelCache.get("timetableModel");

		if (timetableModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				timetableModel = new TimetableModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				timetableModel = new TimetableModelJDBCImpl();
			}
			modelCache.put("timetableModel", timetableModel);
		}

		return timetableModel;
	}

	public SubjectModelInt getSubjectModel() {
		SubjectModelInt subjectModel = (SubjectModelInt) modelCache.get("subjectModel");
		if (subjectModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				subjectModel = new SubjectModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				subjectModel = new SubjectModelJDBCImpl();
			}
			modelCache.put("subjectModel", subjectModel);
		}

		return subjectModel;
	}
	public ProductDetailsModelInt getProductDetailsModel() {

		ProductDetailsModelInt ProductDetailsModel = (ProductDetailsModelInt) modelCache.get("ProductDetailsModel");
		if (ProductDetailsModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				ProductDetailsModel = new ProductDetailsModelHibImp();
			}
			/*
			 * if ("JDBC".equals(DATABASE)) { bankModel = new UserModelJDBCImpl(); }
			 */
			modelCache.put("ProductDetailsModel",ProductDetailsModel);
		}

		return ProductDetailsModel;
	}


	public FacultyModelInt getFacultyModel() {
		FacultyModelInt facultyModel = (FacultyModelInt) modelCache.get("facultyModel");
		if (facultyModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				facultyModel = new FacultyModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				facultyModel = new FacultyModelJDBCImpl();
			}
			
			
			modelCache.put("facultyModel", facultyModel);
		}
		

		return facultyModel;
	}
	
	
	
	public ItemInformationModelInt getiteminMdel() {
		ItemInformationModelInt ItemInformationModelInt = (ItemInformationModelInt) modelCache.get("ItemInformationModel");
		if (ItemInformationModelInt == null) {
			if ("Hibernate".equals(DATABASE)) {
				ItemInformationModelInt = new ItemInformationModelHibImp();
			}
			
			
			
			modelCache.put("ItemInformationModelInt", ItemInformationModelInt);
		}
		

		return ItemInformationModelInt;
	}
	
	
	public CartOverviewModelInt getCartOverMdel() {
		CartOverviewModelInt CartOverviewModelInt = (CartOverviewModelInt) modelCache.get("CartOverviewModel");
		if (CartOverviewModelInt == null) {
			if ("Hibernate".equals(DATABASE)) {
				CartOverviewModelInt = new CartOverviewModelHibImp();
			}
			
			
			
			modelCache.put("StaffMemberModelInt", CartOverviewModelInt);
		}
		

		return CartOverviewModelInt;
	}
	
	public PurchaseOrderModelInt getpurchaseOrderModel() {
		PurchaseOrderModelInt PurchaseOrderModelInt = (PurchaseOrderModelInt) modelCache.get("purchaseOrderModel");
		if (PurchaseOrderModelInt == null) {
			if ("Hibernate".equals(DATABASE)) {
				PurchaseOrderModelInt = new PurchaseOrderModelHibImp();
			}
			
			
			
			modelCache.put("purchaseOrderModel", PurchaseOrderModelInt);
		}
		

		return PurchaseOrderModelInt;
	}
	
	public StaffMemberModelInt getstaffStaffMemberModel() {
		StaffMemberModelInt StaffMemberModelInt = (StaffMemberModelInt) modelCache.get("staffStaffMemberModel");
		if (StaffMemberModelInt == null) {
			if ("Hibernate".equals(DATABASE)) {
				StaffMemberModelInt = new StaffMemberModelHibImp();
			}
			
			
			
			modelCache.put("StaffMemberModelInt", StaffMemberModelInt);
		}
		

		return StaffMemberModelInt;
	}
	
	
	public CompensationModelInt getCompensationModel() {
		CompensationModelInt CompensationModelInt = (CompensationModelInt) modelCache.get("comCompensationModel");
		if (CompensationModelInt == null) {
			if ("Hibernate".equals(DATABASE)) {
				CompensationModelInt = new CompensationModelHibImp();
			}
			
			
			
			modelCache.put("CompensationModelInt", CompensationModelInt);
		}
		

		return CompensationModelInt;
	}
	
	public CustomerModelInt getCustomerModel() {		

		CustomerModelInt customerModel = (CustomerModelInt) modelCache.get("customerModel");
		if (customerModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				customerModel = new CustomerModelHibImp();
			}
			
			
			modelCache.put("customerModel", customerModel);
		}

		return customerModel;
	}
	
	



	
}

