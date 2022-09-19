package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class RecordDAO extends DBAccess {

	PreparedStatement pStmt = null;
	ResultSet rs = null;

	private static RecordDAO rcDao = new RecordDAO(); //daoインスタンス
	ArrayList<RecordBean> list = new ArrayList<>();

	//記録一覧
	public ArrayList<RecordBean> findAll() {
		try {
			conn = rcDao.getConnection(); //コネクト処理
			//SQL文作成
			String sql = "SELECT * FROM height_weight_record ";
			pStmt = conn.prepareStatement(sql);

			rs = pStmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String userId = rs.getString("user_id");
				Date date = rs.getDate("input_date"); //①java.util.Dateで取得
				double height = rs.getDouble("height");
				double weight = rs.getDouble("weight");
				double temperature = rs.getDouble("temperature");
				String note = rs.getString("note");

				LocalDate localDate = new java.sql.Date(date.getTime()).toLocalDate(); //②java.util.Date -> java.sql.Date -> LocalDate
				RecordBean rcBean = new RecordBean(id, userId, localDate, height, weight, temperature, note);
				list.add(rcBean);
			}
		} catch (SQLException e) {
			System.out.println("SELECTエラー：" + e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pStmt != null)
					pStmt.close();
				if (rcDao != null)
					rcDao.closeDBAccess();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	//記録の登録
	public int insert(RecordBean rcBean) {
		int result = 0;
		try {
			conn = rcDao.getConnection();

			//SQL文作成
			String sql = "INSERT INTO height_weight_record(user_id, input_date, height, weight, temperature, note) values(?,?,?,?,?,?)";
			pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, rcBean.getUserId());
			pStmt.setDate(2, java.sql.Date.valueOf(rcBean.getInputDate()));
			pStmt.setDouble(3, rcBean.getHeight());
			pStmt.setDouble(4, rcBean.getWeight());
			pStmt.setDouble(5, rcBean.getTemperature());
			pStmt.setString(6, rcBean.getNote());

			result = pStmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("INSERTエラー：" + e.getMessage());
		} finally {
			try {
				if (pStmt != null)
					pStmt.close();
				if (rcDao != null)
					rcDao.closeDBAccess();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	//記録の条件検査呼び出し
	public ArrayList<RecordBean> findById(int id) {
		try {
			conn = rcDao.getConnection();

			//SQL文作成
			String sql = "SELECT * FROM height_weight_record WHERE id=?";
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, id);

			rs = pStmt.executeQuery();

			while (rs.next()) {
				id = rs.getInt("id");
				String userId = rs.getString("user_id");
				Date date = rs.getDate("input_date");
				double height = rs.getDouble("height");
				double weight = rs.getDouble("weight");
				double temperature = rs.getDouble("temperature");
				String note = rs.getString("note");

				LocalDate localDate = new java.sql.Date(date.getTime()).toLocalDate();
				RecordBean rcBean = new RecordBean(id, userId, localDate, height, weight, temperature, note);
				list.add(rcBean);
			}
		} catch (SQLException e) {
			System.out.println("SELECT(findById)エラー：" + e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pStmt != null)
					pStmt.close();
				if (rcDao != null)
					rcDao.closeDBAccess();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	//記録の修正・更新
	public int update(int id, double height, double weight, double temperature, String note) {
		int result = 0;
		try {
			conn = rcDao.getConnection();

			//SQL文作成
			String sql = "UPDATE height_weight_record SET height=?, weight=?, temperature=?, note=? WHERE id=? ";
			pStmt = conn.prepareStatement(sql);

			pStmt.setDouble(1, height);
			pStmt.setDouble(2, weight);
			pStmt.setDouble(3, temperature);
			pStmt.setString(4, note);
			pStmt.setInt(5, id);

			result = pStmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("UPDATEエラー：" + e.getMessage());
		} finally {
			try {
				if (pStmt != null)
					pStmt.close();
				if (rcDao != null)
					rcDao.closeDBAccess();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	//記録の削除
	public int delete(int id) {
		int result = 0;
		try {
			conn = rcDao.getConnection();

			String sql = "DELETE FROM height_weight_record WHERE id=?";
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, id);

			result = pStmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("DELETEエラー：" + e.getMessage());
		} finally {
			try {
				if (pStmt != null)
					pStmt.close();
				if (rcDao != null)
					rcDao.closeDBAccess();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}