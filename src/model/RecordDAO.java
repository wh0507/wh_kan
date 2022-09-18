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

	private static RecordDAO rcDao = new RecordDAO();
	ArrayList<RecordBean> list = new ArrayList<>();

	//条件検査呼び出し
	public ArrayList<RecordBean> selectOne(String userId) {
		try {
			//コネクト処理
			conn = rcDao.getConnection();
			//SQL文作成
			String sql = "SELECT * FROM height_weight_record WHERE user_id=?";
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, userId);
			rs = pStmt.executeQuery();

			while (rs.next()) {
				Date date = rs.getDate("input_date"); //①java.util.Dateで取得
				double height = rs.getDouble("height");
				double weight = rs.getDouble("weight");
				double temperature = rs.getDouble("temperature");

				LocalDate localDate = new java.sql.Date(date.getTime()).toLocalDate(); //②java.util.Date -> java.sql.Date -> LocalDate
				RecordBean rcBean = new RecordBean(localDate, height, weight, temperature);
				list.add(rcBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//切断処理
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

	//登録
	public int insert(RecordBean rcBean) {
		int result = 0;
		try {
			//コネクト処理
			conn = rcDao.getConnection();

			//SQL文作成
			String sql = "INSERT INTO height_weight_record(user_id, input_date, height, weight, temperature, note) values(?,?,?,?,?,?)";
			//			String sql = "INSERT INTO height_weight_record values (?, input_date(?,'yyyy-mm-dd'), ?, ?, ?, ?)";
			pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, rcBean.getUserId());
			pStmt.setDate(2, java.sql.Date.valueOf(rcBean.getInputDate()));
			pStmt.setDouble(3, rcBean.getHeight());
			pStmt.setDouble(4, rcBean.getWeight());
			pStmt.setDouble(5, rcBean.getTemperature());
			pStmt.setString(6, rcBean.getNote());

			result = pStmt.executeUpdate(); //戻り値はint型で登録行数が返される。
		} catch (SQLException e) {
			System.out.println("INSERTエラー：" + e.getMessage());
		} finally {
			//切断処理
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

	//13.更新
	public int update(String id, String name, int kakaku) {
		int result = 0;
		try {
			//コネクト処理
			conn = rcDao.getConnection();

			//SQL文作成
			String sql = "UPDATE height_weight_record SET name=?, kakaku=? WHERE id=?";
			pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, name);
			pStmt.setInt(2, kakaku);
			pStmt.setString(3, id);

			result = pStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//切断処理
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

	//削除
	public int delete(String id) {
		int result = 0;
		try {
			//コネクト処理
			conn = rcDao.getConnection();

			//SQL文作成
			String sql = "DELETE FROM height_weight_record WHERE id=?";
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);

			result = pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//切断処理
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