package model;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExample {
	public static void main(String[] args) {
        // Định dạng ngày tháng theo chuẩn
        String dateStr = "2024-06-12";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
            // Chuyển đổi từ String sang java.util.Date
            Date utilDate = dateFormat.parse(dateStr);
            
            // Chuyển đổi từ java.util.Date sang java.sql.Date
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            
            // In ra để kiểm tra
            System.out.println("java.sql.Date: " + sqlDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
