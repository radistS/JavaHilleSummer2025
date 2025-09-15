```mermaid
sequenceDiagram
    actor User
    participant Device
    
    User->>Device: Open Application
    activate Device
    Device->>Device: Access Webcam
    
    alt Webcam works
    Device-->>User: Webcam stream
    else Hardware failure
    Device-->>User: Error: Hardware Failure
    destroy Device
    end
    deactivate Device
```
