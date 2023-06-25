describe('Home Page', () => {
  beforeEach(() => {
    // Perform a successful login first
    cy.visit('https://sakshingp.github.io/assignment/login.html');
    cy.get('input[name="username"]').type('your-username');
    cy.get('input[name="password"]').type('your-password');
    cy.contains('Login').click();
  });

  it('should sort the transaction table by clicking the AMOUNT header', () => {
    // Navigate to the Home Page and click the AMOUNT header
    cy.url().should('include', '/home');
    cy.contains('AMOUNT').click();

    // Add assertions to validate that the values are sorted
    // Example:
    const transactionAmounts = [];
    cy.get('td[data-th="Amount"]').each((row) => {
      transactionAmounts.push(parseFloat(row.text()));
    });
    expect(transactionAmounts).to.be.sorted('asc');
  });

  // Add more test cases for other actions on the Home Page
});
