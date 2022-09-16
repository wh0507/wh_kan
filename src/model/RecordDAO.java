package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
				Date inputDate = rs.getDate("input_date");
				double height = rs.getDouble("height");
				double weight = rs.getDouble("weight");
				double temperature = rs.getDouble("temperature");

				RecordBean rcBean = new RecordBean(inputDate, height, weight, temperature);
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
			String sql = "INSERT INTO height_weight_record(input_date, height, weight, temperature, text) values(?,?,?,?,?,?,?)";
			pStmt = conn.prepareStatement(sql);

			Date date = new Date();

			pStmt.setDate(1, (java.sql.Date) rcBean.getInputDate());
			pStmt.setDouble(2, rcBean.getHeight());
			pStmt.setDouble(3, rcBean.getWeight());
			pStmt.setDouble(4, rcBean.getTemperature());

			//ps.setDate(2, new java.sql.Date(heightweight.getInput_date().getTime()));


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