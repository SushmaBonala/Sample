# Sample
Spring boot project with crud operations for items and orders

There are 7 API's in this project 
1. "url" : "http://localhost:8082/app/getAllItems"
    "description" : it returns all items with the available stock(quantity) to buy
    
2. "url" : "http://localhost:8082/app/getItemById"
    "description" : it returns item based on id provided, throws ItemNotFound if that item is not present in Item
    
3. "url" : "http://localhost:8082/app/addItem"
    "description" : it adds Item
    
4. "url" : "http://localhost:8082/app/updateItem"
    "description" : it updates Item
    
5. "url" : "http://localhost:8082/app/deleteItem"
    "description" : it deletes item with provided Id, throws ItemNotFound if that item is not present in Item
    
6. "url" : "http://localhost:8082/app/getAllOrders"
   "description" : it returns all orders, throws OrderNotFound if no orders present in Order
   
7. "url" : "http://localhost:8082/app/addOrder"
    "description" : it will add order and it throws OutOfStock if order has more quantity than the quantity of that item, it throws                             ItemNotFound if that item is not present in Item
    
