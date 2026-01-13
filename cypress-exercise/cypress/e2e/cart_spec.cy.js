describe('Cart and Checkout Test', () => {
  // Hook beforeEach để đăng nhập trước mỗi bài test
  beforeEach(() => {
    cy.visit('https://www.saucedemo.com');
    cy.get('#user-name').type('standard_user');
    cy.get('#password').type('secret_sauce');
    cy.get('#login-button').click();
  });

  // Kịch bản 3: Thêm sản phẩm vào giỏ
  it('Should add a product to the cart', () => {
    // Click nút Add to cart đầu tiên
    cy.get('.inventory_item').first().find('.btn_inventory').click();
    // Kiểm tra badge giỏ hàng hiện số 1
    cy.get('.shopping_cart_badge').should('have.text', '1');
  });

  // Kịch bản 4: Sắp xếp sản phẩm (Giá thấp -> cao)
  it('Should sort products by price low to high', () => {
    cy.get('.product_sort_container').select('lohi'); // Chọn option Low to High
    // Kiểm tra giá sản phẩm đầu tiên là $7.99
    cy.get('.inventory_item_price').first().should('have.text', '$7.99');
  });

  // --- BÀI TẬP YÊU CẦU 1: Xóa sản phẩm khỏi giỏ hàng ---
  it('Should remove a product from the cart', () => {
    // 1. Thêm sản phẩm vào giỏ trước
    cy.get('.inventory_item').first().find('.btn_inventory').click();
    // Kiểm tra chắc chắn đã thêm (badge = 1)
    cy.get('.shopping_cart_badge').should('have.text', '1');

    // 2. Nhấn nút "Remove" (Nút Add to cart sẽ đổi tên class hoặc text sau khi click)
    // Cách 1: Tìm nút có text Remove
    cy.contains('Remove').click(); 
    // Hoặc Cách 2: Tìm lại nút btn_inventory ở vị trí đó (lúc này nó là nút Remove)
    // cy.get('.inventory_item').first().find('.btn_inventory').click();

    // 3. Xác minh số lượng về 0 (Badge sẽ biến mất trên DOM của SauceDemo khi giỏ rỗng)
    cy.get('.shopping_cart_badge').should('not.exist');
  });

  // --- BÀI TẬP YÊU CẦU 2: Quy trình thanh toán (Checkout) ---
  it('Should complete the checkout process', () => {
    // 1. Thêm sản phẩm vào giỏ
    cy.get('.inventory_item').first().find('.btn_inventory').click();

    // 2. Đi đến trang giỏ hàng (Click icon giỏ hàng)
    cy.get('.shopping_cart_link').click();
    
    // 3. Nhấn nút Checkout
    cy.get('#checkout').click();

    // 4. Điền thông tin (First Name, Last Name, Zip Code)
    cy.get('#first-name').type('John');
    cy.get('#last-name').type('Doe');
    cy.get('#postal-code').type('12345');

    // 5. Nhấn Continue
    cy.get('#continue').click();

    // 6. Xác minh chuyển đến trang xác nhận (URL chứa checkout-step-two)
    cy.url().should('include', '/checkout-step-two.html');
  });
});