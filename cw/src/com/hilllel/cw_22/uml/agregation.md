```mermaid
classDiagram
    direction LR

class Company{
-String name
+String getName()
    }
    
class Employee

    Company "1"  o-- "n" Employee : aggregation
```

