package control;

public class Test {

	public static void main(String[] args) throws Exception {
		//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		//		LocalDate date = (LocalDate) formatter.parse("2021-10-10");
		//		RecordBean rcBean = new RecordBean(2, "admin", date, 190, 80, 25, "test1");
		//
		//		RecordDAO dao = new RecordDAO();
		//		dao.insert(rcBean);

		//SQL
		StringBuilder sbSql = new StringBuilder();
		sbSql.append("SELECT * ");
		sbSql.append("FROM height_weight_record");
		sbSql.append(" WHERE user_id = ?");
//
//		if(serchCondition == null) {
//			//ソート
//			sbSql.append(" ORDER BY input_date DESC");
//		} else {
//
//			if(CommonLogic.isNull(serchCondition.getUboyDate())) {
//
//			}
//		}
//
//		String num = "10";
//
//		if(num.indexOf(".") == -1) {
//			num += ".0";
//			}
//
//			if(!Pattern.matches("^[0-9]{1,3}\\.{1}[0-9]{1}$",num)) {
//			msg = date + "は半角数値で入力してください";
//			} else {
//			msg = from_to(date,num,num2);
//			}
//
	}

}
