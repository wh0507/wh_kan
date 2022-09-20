package service;

import model.RecordBean;
import model.RecordDAO;

public class CommonLogic {

	public void execute(String checked) {

		RecordBean rcBean = new RecordBean();
		RecordDAO dao = new RecordDAO();
		dao.findAll();

	}
}
