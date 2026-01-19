import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StudentAnalyzerTest {
   
    private final StudentAnalyzer analyzer = new StudentAnalyzer();
    
    // =================================================================
    // NHÓM 1: HÀM countExcellentStudents
    // Tiêu chí: Giỏi [8.0 - 10.0]. Hợp lệ [0.0 - 10.0]
    // =================================================================
    
    // 1. Invalid Input: Null
    @Test
    public void testCountExcellent_NullInput() {
        assertEquals(0, analyzer.countExcellentStudents(null));
    }
    
    // 2. Valid Input: Rỗng
    @Test
    public void testCountExcellent_EmptyList() {
        assertEquals(0, analyzer.countExcellentStudents(Collections.emptyList()));
    }
    
    // 3. Boundary Analysis: Ngay tại biên dưới Giỏi (8.0 -> Có đếm)
    @Test
    public void testCountExcellent_Boundary_Eight() {
        List<Double> scores = Arrays.asList(8.0);
        assertEquals(1, analyzer.countExcellentStudents(scores));
    }
    
    // 4. Boundary Analysis: Sát biên dưới Giỏi (7.99 -> Không đếm)
    @Test
    public void testCountExcellent_Boundary_JustBelowEight() {
        List<Double> scores = Arrays.asList(7.99);
        assertEquals(0, analyzer.countExcellentStudents(scores));
    }
    
    // 5. Boundary Analysis: Biên trên hợp lệ (10.0 -> Có đếm)
    @Test
    public void testCountExcellent_Boundary_MaxScore() {
        List<Double> scores = Arrays.asList(10.0);
        assertEquals(1, analyzer.countExcellentStudents(scores));
    }
    
    // 6. Boundary Analysis: Biên dưới hợp lệ (0.0 -> Không đếm)
    @Test
    public void testCountExcellent_Boundary_MinScore() {
        List<Double> scores = Arrays.asList(0.0);
        assertEquals(0, analyzer.countExcellentStudents(scores));
    }
    
    // 7. Invalid Boundary: Vừa chớm vượt quá 10 (10.1 -> Bỏ qua)
    @Test
    public void testCountExcellent_Invalid_TooHigh() {
        List<Double> scores = Arrays.asList(10.1);
        assertEquals(0, analyzer.countExcellentStudents(scores));
    }
    
    // 8. Invalid Boundary: Vừa chớm âm (-0.1 -> Bỏ qua)
    @Test
    public void testCountExcellent_Invalid_Negative() {
        List<Double> scores = Arrays.asList(-0.1);
        assertEquals(0, analyzer.countExcellentStudents(scores));
    }
    
    // 9. NEW: Multiple excellent scores (chỉ chứa điểm giỏi)
    @Test
    public void testCountExcellent_MultipleExcellent() {
        List<Double> scores = Arrays.asList(8.0, 8.5, 9.2, 10.0);
        assertEquals(4, analyzer.countExcellentStudents(scores));
    }
    
    // 10. NEW: Mixed - có excellent, non-excellent, invalid
    @Test
    public void testCountExcellent_MixedMultiple() {
        // 7.5 (không), 8.5 (có), 9.2 (có), 10.0 (có), 6.0 (không), 11.0 (invalid), -1.0 (invalid)
        List<Double> scores = Arrays.asList(7.5, 8.5, 9.2, 10.0, 6.0, 11.0, -1.0);
        assertEquals(3, analyzer.countExcellentStudents(scores));
    }
    
    // 11. NEW: Contains NaN (NaN phải bị bỏ qua, không đếm)
    @Test
    public void testCountExcellent_ContainsNaN() {
        List<Double> scores = Arrays.asList(8.5, Double.NaN, 9.0);
        assertEquals(2, analyzer.countExcellentStudents(scores));
    }
    
    // 12. NEW: All invalid including NaN
    @Test
    public void testCountExcellent_AllInvalidOrNaN() {
        List<Double> scores = Arrays.asList(-1.0, 11.0, Double.NaN);
        assertEquals(0, analyzer.countExcellentStudents(scores));
    }
    
    // =================================================================
    // NHÓM 2: HÀM calculateValidAverage
    // =================================================================
    
    // 1. Invalid Input: Null
    @Test
    public void testAverage_NullInput() {
        assertEquals(0.0, analyzer.calculateValidAverage(null), 0.01);
    }
    
    // 2. Valid Input: Rỗng
    @Test
    public void testAverage_EmptyList() {
        assertEquals(0.0, analyzer.calculateValidAverage(Collections.emptyList()), 0.01);
    }
    
    // 3. Logic: Lọc bỏ toàn bộ số sai -> Chia cho 0
    @Test
    public void testAverage_AllInvalidScores() {
        List<Double> scores = Arrays.asList(-5.0, 12.0);
        assertEquals(0.0, analyzer.calculateValidAverage(scores), 0.01);
    }
    
    // 4. Logic: Tính toán chuẩn (Kết hợp lọc và tính)
    @Test
    public void testAverage_MixedValidAndInvalid() {
        // 10.0 (Lấy), -2.0 (Bỏ), 5.0 (Lấy) -> (10+5)/2 = 7.5
        List<Double> scores = Arrays.asList(10.0, -2.0, 5.0);
        assertEquals(7.5, analyzer.calculateValidAverage(scores), 0.01);
    }
    
    // 5. Special Case: NaN
    @Test
    public void testAverage_ContainsNaN() {
        List<Double> scores = Arrays.asList(10.0, Double.NaN, 6.0);
        assertEquals(8.0, analyzer.calculateValidAverage(scores), 0.01);
    }
    
    // 6. NEW: Multiple valid scores only (để kiểm tra tính trung bình chính xác với nhiều phần tử)
    @Test
    public void testAverage_MultipleValidOnly() {
        List<Double> scores = Arrays.asList(7.0, 8.0, 9.0, 6.5);
        assertEquals(7.625, analyzer.calculateValidAverage(scores), 0.01);
    }
}
