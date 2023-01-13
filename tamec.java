import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class SampleAccess {
	public static void main(String[] args) {
		Connection conn = null;
		String qry = null;
		PreparedStatement ps = null;
		ResultSet rset = null;
		//接続文字列
		String url = "jdbc:postgresql://XXX.XXX.XXX.XXX:5432/postgres";
		String user = "postgres";
		String password = "postgres";

		try {

			//PostgreSQLへ接続
			conn = DriverManager.getConnection(url, user, password);

			//自動コミットOFF
			conn.setAutoCommit(false);

			//SELECT文の実行
			qry = "SELECT * FROM 社員テーブル WHERE 社員番号 = ?";
			ps = conn.prepareStatement(qry);
			ps.setInt(1, Integer.parseInt(args[0])); // 1番目の?に最初の引数(args[0])を設定
			System.out.println(ps.toString());
			rset = ps.executeQuery(); // SQL文を実行して結果をResultSetで受け取る

			//SELECT結果の受け取り
			while (rset.next()) {
				//SELECT結果の受け取り
				String col = rset.getString(1) + ' '
						+ rset.getString(2) + ' '
						+ rset.getString(3) + ' '
						+ rset.getString(4) + ' '
						+ rset.getString(5);
				System.out.println(col);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (rset != null)
					rset.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
}


