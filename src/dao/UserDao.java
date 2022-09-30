package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.UserBean;

public class UserDao extends DBAccess{

	//ユーザー一覧表
	public ArrayList<UserBean> find_user() {
		ArrayList<UserBean> list_user = new ArrayList<>();
		try {
			conn = getConnection(); //コネクト処理

			//SQL文作成
			String sql = "SELECT * FROM user_info";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				String userId_db = rs.getString("user_id");
				String pass_db = rs.getString("password");
				String user_name = rs.getString("user_name");

				UserBean uBean = new UserBean(userId_db, user_name, pass_db);
				list_user.add(uBean);
			}
		} catch (SQLException e) {
			System.out.println("SELECTエラー：" + e.getMessage());
		}
		return list_user;
	}

	public int insert(String user_id, String user_name, String pass) throws SQLException {
		int num = 0;

		try {
			conn = getConnection();

			//SQLの準備
			String sql = "INSERT INTO user_info (user_id,user_name,password)VALUES(?,?,?)";
			//SQLを実行する準備
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, user_id);
			pStmt.setString(2, user_name);
			pStmt.setString(3, pass);

			//お決まりの実行
			num = pStmt.executeUpdate();

		}catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	public List<UserBean> selectID(String user_id) throws SQLException {

		List<UserBean> list_user = new ArrayList<UserBean>();

		try {
			conn = getConnection();

			String sql = "SELECT * FROM user_info WHERE user_id = ?";
			//SQLを実行する準備
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//SQL実行

			pStmt.setString(1, user_id);

			ResultSet rs = pStmt.executeQuery();


			//取得結果を１行ずつ処理
			while(rs.next()) {
				//取得したデータ
				String userId_db = rs.getString("user_id");
				String pass_db = rs.getString("password");
				String user_name = rs.getString("user_name");

				UserBean uBean = new UserBean(userId_db, user_name, pass_db);
				list_user.add(uBean);

			}


		}catch (SQLException e) {
			e.printStackTrace();
		}
		return list_user;
	}

	//更新
		public int update(String user_id, String user_name, String pass) {
			int num = 0;

			try {
				conn = getConnection();
				//SQLの準備
				String sql = "UPDATE user_info SET user_id=?, user_name=?, password=? WHERE user_id=?;";
				//SQLを実行する準備
				PreparedStatement pStmt = conn.prepareStatement(sql);

				pStmt.setString(1, user_id);
				pStmt.setString(2, user_name);
				pStmt.setString(3, pass);
				pStmt.setString(4, user_id);

				//お決まりの実行
				num = pStmt.executeUpdate();
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return num;
		}

		//削除
		public int Delete(String user_id) {
			int num = 0;

			try {
				conn = getConnection();

				//SQLの準備
				String sql = "DELETE FROM user_info WHERE user_id = ?;";
				//SQLを実行する準備
				PreparedStatement pStmt = conn.prepareStatement(sql);

				pStmt.setString(1, user_id);

				//お決まりの実行
				num = pStmt.executeUpdate();
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return num;
		}

		//user_id重複チェック
		public String user_id_check(String user_id) {
			String msg = "";

			try {
				conn = getConnection(); //コネクト処理
				//SQL文作成
				String sql = "SELECT * FROM user_info";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				ResultSet rs = pStmt.executeQuery();

				while (rs.next()) {

					String userId_db = rs.getString("user_id");

					if(user_id.equals(userId_db)) {
						msg = "ユーザーIDは既に記録されています。別のユーザーIDで入力してください。";
						break;

					}else {

					}
				}


			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			return msg;
		}

		public int delete_user_all(String user_id) {
			int num = 0;

			try {
				conn = getConnection();

				//SQLの準備
				String sql = "DELETE FROM height_weight_record WHERE user_id = ?;";
				//SQLを実行する準備
				PreparedStatement pStmt = conn.prepareStatement(sql);

				pStmt.setString(1, user_id);

				//お決まりの実行
				num = pStmt.executeUpdate();
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return num;
		}

}
