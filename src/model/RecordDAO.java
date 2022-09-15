package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RecordDAO extends DBAccess {

	PreparedStatement pStmt = null;
	ResultSet rs = null;

	private static RecordDAO shDAO = new RecordDAO();

	ArrayList<ShohinBean> list = new ArrayList<>();

	//10.全件検査
	public ArrayList<ShohinBean> selectAll() {
		try {
			//コネクト処理
			conn = shDAO.getConnection();
			//SQL文作成
			String sql = "SELECT * FROM shohin";
			pStmt = conn.prepareStatement(sql);
			//SELECTを実行し、結果表(ResultSet)を取得
			rs = pStmt.executeQuery();
			//結果表に格納されたレコードの内容を表示
			while (rs.next()) {
				String id = rs.getString("ID");
				String name = rs.getString("NAME");
				int kakaku = rs.getInt("KAKAKU");
				ShohinBean shBean = new ShohinBean(id, name, kakaku);
				list.add(shBean);
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
				if (shDAO != null)
					shDAO.closeDBAccess();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	//11.条件検査呼び出し
	public ArrayList<ShohinBean> jouken(String id) {
		ShohinBean shBean = null;
		try {
			//コネクト処理
			conn = shDAO.getConnection();
			//SQL文作成
			String sql = "SELECT * FROM shohin WHERE id=?";
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id); //index1にid設定
			rs = pStmt.executeQuery();

			rs.next();
			String name = rs.getString("NAME");
			int kakaku = rs.getInt("KAKAKU");

			shBean = new ShohinBean(id, name, kakaku);
			list.add(shBean);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//切断処理
			try {
				if (rs != null)
					rs.close();
				if (pStmt != null)
					pStmt.close();
				if (shDAO != null)
					shDAO.closeDBAccess();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	//12.新規登録
	public int insert(String id, String name, int kakaku) {
		int result = 0;
		try {
			//コネクト処理
			conn = shDAO.getConnection();

			//SQL文作成
			String sql = "INSERT INTO shohin(id,name,kakaku) values(?,?,?)";
			pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, id); //setString(埋め込み場所の順序,実際のデータor変数)
			pStmt.setString(2, name);
			pStmt.setInt(3, kakaku);

			result = pStmt.executeUpdate(); //戻り値はint型で登録行数が返される。
		} catch (SQLException e) {
			System.out.println("INSERTエラー：" + e.getMessage());
		} finally {
			//切断処理
			try {
				if (pStmt != null)
					pStmt.close();
				if (shDAO != null)
					shDAO.closeDBAccess();
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
			conn = shDAO.getConnection();

			//SQL文作成
			String sql = "UPDATE shohin SET name=?, kakaku=? WHERE id=?";
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
				if (shDAO != null)
					shDAO.closeDBAccess();
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
			conn = shDAO.getConnection();

			//SQL文作成
			String sql = "DELETE FROM shohin WHERE id=?";
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
				if (shDAO != null)
					shDAO.closeDBAccess();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;

	}
}