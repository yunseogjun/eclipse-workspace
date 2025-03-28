import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class CallStoredProcedure {

	public static void main(String[] args) {
        String jdbcUrl = "jdbc:oracle:thin:@192.168.0.247:1521:FREE"; // Oracle 연결 정보
        String username = "sale"; // DB 사용자명
        String password = "p_sale_w"; // DB 비밀번호

        Connection conn = null;
        CallableStatement cstmt = null;

        try {
            // 1. Oracle DB 연결
            conn = DriverManager.getConnection(jdbcUrl, username, password);

            System.out.println("---------------------------------------");
            System.out.println("프로시져 호출 시작!");
            System.out.println("---------------------------------------");

            // 2. CallableStatement 객체 생성 (프로시저 호출)
            cstmt = conn.prepareCall("{CALL PROCEDURE1(?, ?, ?, ?, ?, ?, ?, ?)}");

            // 3. IN 파라미터 설정
            cstmt.setString(1, "S");      				  //처리구분
            cstmt.setString(2, "1000");      			  //사원번호
            cstmt.setString(3, "윤석준");      		      //이름
            cstmt.setString(4, "010-0000-0000");      	  //전화번호
            cstmt.setString(5, "aaaaaaaaa@gmail.com");    //email번호
            cstmt.registerOutParameter(6, Types.INTEGER); //처리건수
            cstmt.registerOutParameter(7, Types.VARCHAR); //결과코드
            cstmt.registerOutParameter(8, Types.VARCHAR); //결과명

            // 4. 프로시저 실행
            cstmt.execute();

            String ov_satus = cstmt.getString(1);
            String ov_empno = cstmt.getString(2);
            String ov_name  = cstmt.getString(3);
            String ov_hpno  = cstmt.getString(4);
            String ov_email = cstmt.getString(5);
            Integer ov_proccnt  = cstmt.getInt(6);
            String ov_code  = cstmt.getString(7);
            String ov_msg   = cstmt.getString(8);
            System.out.println("ov_satus = " + ov_satus);
            System.out.println("ov_empno = " + ov_empno);
            System.out.println("ov_name  = " + ov_name);
            System.out.println("ov_hpno  = " + ov_hpno);
            System.out.println("ov_email = " + ov_email);
            System.out.println("ov_proccnt  = " + ov_proccnt);
            System.out.println("ov_code  = " + ov_code);
            System.out.println("ov_msg   = " + ov_msg);
            System.out.println("프로시져 호출 완료!");
            System.out.println("---------------------------------------");


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (cstmt != null) cstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
	    }
	}

}
