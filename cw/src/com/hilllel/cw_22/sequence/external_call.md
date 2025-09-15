```mermaid
sequenceDiagram
    actor User
    participant Device
    participant Internal_System

    User->>Device: 1: Open Application
    activate Device
    Device->>Device: 2: Access Webcam
    Internal_System-->>Device: 3: Hardware Failure
    deactivate Device
    destroy Device

    

    
    
```

