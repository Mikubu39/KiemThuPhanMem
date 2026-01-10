import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StudentAnalyzerTest {
    private final StudentAnalyzer analyzer = new StudentAnalyzer();

    @Test
    public void testCountExcellentStudents_NormalCaseWithInvalid() {
        List<Double> scores = Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0);
        assertEquals(2, analyzer.countExcellentStudents(scores));
    }

    @Test
    public void testCountExcellentStudents_AllValid() {
        List<Double> scores = Arrays.asList(8.0, 9.5, 7.9, 10.0);
        assertEquals(3, analyzer.countExcellentStudents(scores));
    }

    @Test
    public void testCountExcellentStudents_EmptyList() {
        assertEquals(0, analyzer.countExcellentStudents(Collections.emptyList()));
    }

    @Test
    public void testCountExcellentStudents_OnlyBoundaryValues() {
        List<Double> scores = Arrays.asList(0.0, 10.0, 0.0, 10.0);
        assertEquals(2, analyzer.countExcellentStudents(scores));
    }

    @Test
    public void testCountExcellentStudents_AllInvalid() {
        List<Double> scores = Arrays.asList(-5.0, 11.0, 15.0);
        assertEquals(0, analyzer.countExcellentStudents(scores));
    }

    @Test
    public void testCalculateValidAverage_NormalCaseWithInvalid() {
        List<Double> scores = Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0);
        assertEquals(8.166666666666666, analyzer.calculateValidAverage(scores), 0.01);
    }

    @Test
    public void testCalculateValidAverage_AllValid() {
        List<Double> scores = Arrays.asList(5.0, 6.0, 7.0);
        assertEquals(6.0, analyzer.calculateValidAverage(scores), 0.01);
    }

    @Test
    public void testCalculateValidAverage_EmptyList() {
        assertEquals(0.0, analyzer.calculateValidAverage(Collections.emptyList()), 0.01);
    }

    @Test
    public void testCalculateValidAverage_OnlyBoundaryValues() {
        List<Double> scores = Arrays.asList(0.0, 10.0);
        assertEquals(5.0, analyzer.calculateValidAverage(scores), 0.01);
    }

    @Test
    public void testCalculateValidAverage_AllInvalid() {
        List<Double> scores = Arrays.asList(-1.0, 11.0);
        assertEquals(0.0, analyzer.calculateValidAverage(scores), 0.01);
    }
}