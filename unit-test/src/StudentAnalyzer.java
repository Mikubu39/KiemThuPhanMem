import java.util.List;

public class StudentAnalyzer {
    /**
     * Phân tích điểm số và trả về số lượng học sinh đạt loại Giỏi.
     * @param scores danh sách điểm số từ 0 đến 10
     * @return số học sinh đạt loại Giỏi (>= 8.0)
     * - Bỏ qua điểm âm hoặc lớn hơn 10 (coi là dữ liệu sai)
     * - Nếu danh sách rỗng hoặc null, trả về 0
     */
    public int countExcellentStudents(List<Double> scores) {
        // [SỬA LỖI 1]: Kiểm tra null trước khi gọi .isEmpty()
        if (scores == null || scores.isEmpty()) {
            return 0;
        }
        int count = 0;
        for (Double score : scores) {
            // [SỬA LỖI 2]: Kiểm tra từng điểm có bị null không
            if (score != null && !Double.isNaN(score)) {
                if (score >= 8.0 && score <= 10.0) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Tính điểm trung bình hợp lệ (từ 0 đến 10)
     * @param scores danh sách điểm
     * @return điểm trung bình của các điểm hợp lệ
     */
    public double calculateValidAverage(List<Double> scores) {
        // [SỬA LỖI 1]: Kiểm tra null trước
        if (scores == null || scores.isEmpty()) {
            return 0.0;
        }
        double sum = 0.0;
        int validCount = 0;
        for (Double score : scores) {
            // [SỬA LỖI 2]: Kiểm tra từng điểm có bị null không
            if (score != null && !Double.isNaN(score)) {
                if (score >= 0.0 && score <= 10.0) {
                    sum += score;
                    validCount++;
                }
            }
        }
        return validCount > 0 ? sum / validCount : 0.0;
    }
}