```mermaid
sequenceDiagram
    participant User 
    create participant Order 
   
    
    User ->> Order: 1 : New order
    Order -->> Order: 1.1 : Process order
    activate Order
    Order-->> User: 2 : Order created
    destroy Order
    
    
```

