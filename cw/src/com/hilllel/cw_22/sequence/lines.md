```mermaid
sequenceDiagram
    actor Customer as Alex
    participant Bank as "Bank System"
   
    
    Customer->> Bank: 1 : check balance
    activate Bank
    Bank-->> Customer: 2 : return balance
    deactivate Bank
    
    
```

```mermaid
sequenceDiagram
    participant Server 
    participant Device
   
    Device-->> Server: reatime data
    activate Server
    deactivate Server
    
    
```
