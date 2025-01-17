package in.co.rays.project_3.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import in.co.rays.project_3.dto.BaseDTO;
import in.co.rays.project_3.dto.CartOverviewDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.model.CartOverviewModelInt;
import in.co.rays.project_3.model.ModelFactory;

import in.co.rays.project_3.util.DataUtility;
import in.co.rays.project_3.util.DataValidator;
import in.co.rays.project_3.util.PropertyReader;
import in.co.rays.project_3.util.ServletUtility;
@WebServlet(name = "CartOverviewCtl", urlPatterns = { "/ctl/CartOverviewCtl" })
public class CartOverviewCtl extends BaseCtl {
	
	@Override
	protected void preload(HttpServletRequest request) {
	   Map<Integer,String> map = new HashMap<Integer, String>();
	   map.put(1, "Tv");
	   map.put(2, "Led");
	   map.put(3, "Game");
	   map.put(4, "Mobile");
		
		
		request.setAttribute("pr",map );
	}
	
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(CollegeCtl.class);

	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;
		if (DataValidator.isNull(request.getParameter("Customername"))) {
			request.setAttribute("Customername", PropertyReader.getValue("error.require", "Customername"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("product"))) {
			request.setAttribute("product", PropertyReader.getValue("error.require", "product"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("Transactiondate"))) {
			request.setAttribute("Transactiondate", PropertyReader.getValue("error.require", "Transactiondate"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("quantity"))) {
			request.setAttribute("quantity", PropertyReader.getValue("error.require", "quantity"));
			pass = false;
		}
		return pass;
	}

	protected BaseDTO populateDTO(HttpServletRequest request) {
		CartOverviewDTO dto = new CartOverviewDTO();
		dto.setCustomername(DataUtility.getString(request.getParameter("Customername")));
		dto.setProduct(request.getParameter("product"));
		dto.setTransactiondate(DataUtility.getDate(request.getParameter("Transactiondate")));
		dto.setQuantity(DataUtility.getString(request.getParameter("quantity")));

		populateBean(dto, request);
		return dto;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String op = request.getParameter("operation");
		long id = DataUtility.getLong(request.getParameter("id"));
		CartOverviewModelInt model = ModelFactory.getInstance().getCartOverMdel();
		if (id > 0 || op != null) {
			CartOverviewDTO dto;
			try {
				dto = model.findByPK(id);
				ServletUtility.setDto(dto, request);

			} catch (ApplicationException e) {
				log.error(e);
				ServletUtility.handleException(e, request, response);
				return;
			}

		}
		ServletUtility.forward(getView(), request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String op = request.getParameter("operation");
		long id = DataUtility.getLong(request.getParameter("id"));

		CartOverviewModelInt model = ModelFactory.getInstance().getCartOverMdel();

		if (OP_SAVE.equalsIgnoreCase(op) || OP_UPDATE.equalsIgnoreCase(op)) {

			CartOverviewDTO
			dto = (CartOverviewDTO) populateDTO(request);

			try {
				if (id > 0) {
					dto.setId(id);
					model.update(dto);
					ServletUtility.setDto(dto, request);

					ServletUtility.setSuccessMessage("Record Successfully Updated", request);

				} else {
					System.out.println("college add" + dto + "id...." + id);
					// long pk
					model.add(dto);
					ServletUtility.setSuccessMessage("Record Successfully Saved", request);
				}
				ServletUtility.setDto(dto, request);
			} catch (ApplicationException e) {
				e.printStackTrace();
				log.error(e);
				ServletUtility.handleException(e, request, response);
				return;
			} catch (DuplicateRecordException e) {
				ServletUtility.setDto(dto, request);
				ServletUtility.setErrorMessage("ProductName Already Exists", request);
			}
		} else if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.CARTOVERVIEW_CTL, request, response);
			return;
		} else if (OP_CANCEL.equalsIgnoreCase(op)) {

			ServletUtility.redirect(ORSView.CARTOVERVIEW_LIST_CTL, request, response);
			return;

		}
		ServletUtility.forward(getView(), request, response);
	}

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.CARTOVERVIEW_VIEW;
	
	
	
	}


}
