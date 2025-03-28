import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class CallProcedureMvn {


	public static void main(String[] args) {
        String jdbcUrl = "jdbc:oracle:thin:@192.168.0.247:1521:FREE"; // Oracle 연결 정보
        String username = "sale"; // DB 사용자명
        String password = "p_sale_w"; // DB 비밀번호

        Connection conn = null;
        CallableStatement cstmt = null;

        try {

        	StringBuffer iv_status = new StringBuffer();
        	StringBuffer iv_empno  = new StringBuffer();

        	if (args.length == 2) {
        		iv_status.append(args[0]);
        		iv_empno.append(args[1]);
        	}
        	else {
        		iv_status.append("S");
        		iv_empno.append("1000");
        	}

            // 1. Oracle DB 연결
            conn = DriverManager.getConnection(jdbcUrl, username, password);
//            System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8)); // UTF-8로 출력
            System.out.println("---------------------------------------");
            System.out.println("프로시져 호출 시작!");
            System.out.println("---------------------------------------");
        	System.out.println("입력인자 iv_status = " + iv_status);
        	System.out.println("입력인자 iv_empno  = "  + iv_empno);
            System.out.println("---------------------------------------");

            // 2. CallableStatement 객체 생성 (프로시저 호출)
            cstmt = conn.prepareCall("{CALL PROCEDURE1(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");

            // 3. IN 파라미터 설정
            cstmt.setString(1, iv_status.toString());     //처리구분
            cstmt.setString(2, iv_empno.toString());      //사원번호
            cstmt.setString(3, "윤석준");      		      //이름
            cstmt.setString(4, "010-0000-0000");      	  //전화번호
            cstmt.setString(5, "aaaaaaaaa@gmail.com");    //email번호
            cstmt.registerOutParameter(6, Types.VARCHAR); //결과코드
            cstmt.registerOutParameter(7, Types.VARCHAR); //결과코드
            cstmt.registerOutParameter(8, Types.VARCHAR); //결과코드
            cstmt.registerOutParameter(9, Types.INTEGER); //처리건수
            cstmt.registerOutParameter(10, Types.VARCHAR); //결과코드
            cstmt.registerOutParameter(11, Types.VARCHAR); //결과명

            // 4. 프로시저 실행
            cstmt.execute();

            String ov_name  = cstmt.getString(6);
            String ov_hpno  = cstmt.getString(7);
            String ov_email = cstmt.getString(8);

            Integer ov_proccnt  = cstmt.getInt(9);
            String ov_code  = cstmt.getString(10);
            String ov_msg   = cstmt.getString(11);

            System.out.println("ov_name  = " + ov_name);
            System.out.println("ov_hpno = " + ov_hpno);
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
