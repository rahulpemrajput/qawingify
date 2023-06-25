describe('Login Page', () => {
  beforeEach(() => {
    cy.visit('https://sakshingp.github.io/assignment/login.html');
  });

  it('should successfully login with valid credentials', () => {
    cy.get('input[name="username"]').type('your-username');
    cy.get('input[name="password"]').type('your-password');
    cy.contains('Login').click();

    // Add assertions to validate the successful login
    // Example:
    cy.url().should('include', '/home');
  });

  it('should display an error message for invalid login', () => {
    cy.get('input[name="username"]').type('invalid-username');
    cy.get('input[name="password"]').type('invalid-password');
    cy.contains('Login').click();

    // Add assertions to validate the error message
    // Example:
    cy.contains('Invalid username or password').should('be.visible');
  });

  // Add more test cases for other scenarios (e.g., empty fields, special characters, etc.)
});
