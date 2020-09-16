Feature: Search results display pages with products
  Scenario:As a customer I want my search or navigation results to display in pages with products listed so that I can see all the results
Given the customer is on a product list page
When customer views the products
Then the system should display the products by the default pagination