# KiemThuPhanMem

Bài tập môn Kiểm thử phần mềm

## Bài tập chương 1
Kết quả của bài tập trang Can't Unsee:
<img src="https://github.com/user-attachments/assets/cb461802-3f15-4c06-9c38-a6d444d13d1f" width="800" alt="Màn hình Can't Dissoee - Điểm 7388">

## Bài tập chương 2

### Mô tả bài toán

Lớp `StudentAnalyzer` bao gồm 2 phương thức:

- `countExcellentStudents(List<Double> scores)`  
  Đếm số học sinh đạt loại **Giỏi** (điểm ≥ 8.0).  
  Bỏ qua các điểm không hợp lệ (< 0 hoặc > 10).

- `calculateValidAverage(List<Double> scores)`  
  Tính trung bình các điểm **hợp lệ** (trong khoảng 0–10).  
  Nếu không có điểm hợp lệ nào thì trả về **0**.

### Cấu trúc thư mục
```text
unit-test/
├── src/
│   └── StudentAnalyzer.java          # Code logic chính
├── test/
│   └── StudentAnalyzerTest.java      # 10 test case (JUnit 5)
├── lib/
│   └── junit-platform-console-standalone-6.0.2.jar
└── bin/                              # Các file .class sau khi biên dịch
```
### Hướng dẫn biên dịch (chạy trong ô nhập lệnh của môi trường lập trình)
```bash
mkdir -p unit-test/bin

javac -cp "unit-test/lib/junit-platform-console-standalone-6.0.2.jar" \
      -d unit-test/bin \
      unit-test/src/*.java unit-test/test/*.java
```
### Hướng dẫn chạy kiểm thử (chạy trong ô nhập lệnh của môi trường lập trình)
```bash
java -jar unit-test/lib/junit-platform-console-standalone-6.0.2.jar \
     execute \
     --class-path unit-test/bin \
     --scan-classpath
```
### Kết quả sau khi thực hiện kiểm thử:
<img width="1375" height="948" alt="image" src="https://github.com/user-attachments/assets/942c9162-c137-4ab8-be84-85f66998640b" />
