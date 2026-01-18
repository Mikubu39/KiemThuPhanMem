# Báo cáo kiểm thử hiệu năng với JMeter

## Trang web được chọn
- URL: https://httpbin.org
- Lý do: Trang web chuyên dụng để test HTTP requests, an toàn, hỗ trợ GET/POST/delay, không vi phạm rate limiting.

## Cấu hình chung
- JMeter version: 5.6.x (hoặc phiên bản bạn dùng)
- Base URL: https://httpbin.org
- Listeners: Summary Report, Aggregate Report, View Results Tree

## Kịch bản 1 - Basic Load
- Số users: 10
- Loop: 5 lần
- Hành vi: GET /get
- Kết quả:
<img width="1930" height="397" alt="Screenshot 2026-01-18 205903" src="https://github.com/user-attachments/assets/db573f45-3e3a-4afc-8527-1f6f50e2458c" />

## Kịch bản 2 - Heavy Load
- Số users: 50
- Ramp-up: 30 giây
- Loop: 10
- Hành vi: GET /get và GET /delay/2 (2 trang)
- Kết quả:
<img width="1937" height="534" alt="Screenshot 2026-01-18 210306" src="https://github.com/user-attachments/assets/e8b34f5a-477d-4c3a-a9af-6359555b830b" />

## Kịch bản 3 - Custom Personalized
- Số users: 20
- Duration: 60 giây
- Hành vi: POST /post với data cá nhân hóa (user_id, timestamp khác nhau cho từng thread)
- Kết quả:
<img width="1931" height="151" alt="Screenshot 2026-01-18 210050" src="https://github.com/user-attachments/assets/6612a0af-3a26-4046-9af5-1a0a497d73f1" />

## Phân tích tổng quan
- Trang httpbin.org xử lý rất tốt với tải nhỏ- trung bình.
- Response time tăng khi có delay (kịch bản 2).
- Không có lỗi nào xảy ra.
- Throughput ổn định, chứng tỏ server test rất mạnh.

## File đính kèm
- performance_test.jmx
