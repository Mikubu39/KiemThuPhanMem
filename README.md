# KiemThuPhanMem
Bài tập chương 1:
<img width="2560" height="1600" alt="image" src="https://github.com/user-attachments/assets/cb461802-3f15-4c06-9c38-a6d444d13d1f" />
Bài tập chương 2:
# Mô tả bài toán
Lớp StudentAnalyzer có 2 phương thức:
- countExcellentStudents(List<Double> scores): Đếm số học sinh đạt loại Giỏi (điểm >= 8.0), bỏ qua điểm không hợp lệ (<0 hoặc >10).
- calculateValidAverage(List<Double> scores): Tính trung bình các điểm hợp lệ (0-10), trả về 0 nếu không có điểm hợp lệ.
# Cấu trúc thư mục unit-test/
├── src/
│   └── StudentAnalyzer.java          ← Code logic
├── test/
│   └── StudentAnalyzerTest.java      ← 10 test cases (JUnit 5)
├── lib/
│   └── junit-platform-console-standalone-6.0.2.jar
└── bin/                              ← File .class sau khi compile
Cách biên dịch và chạy test
# Biên dịch
mkdir -p unit-test/bin
javac -cp "unit-test/lib/junit-platform-console-standalone-6.0.2.jar" \
      -d unit-test/bin \
      unit-test/src/*.java unit-test/test/*.java
# Chạy test (tất cả pass)
java -jar unit-test/lib/junit-platform-console-standalone-6.0.2.jar \
     execute \
     --class-path unit-test/bin \
     --scan-classpath
     <img width="1375" height="948" alt="image" src="https://github.com/user-attachments/assets/942c9162-c137-4ab8-be84-85f66998640b" />
