```mermaid
classDiagram
    direction LR

class Account

class CreaditAccount
class DebitAccount
class SavingsAccount
class VirtualAccount

    Account <|-- CreaditAccount
    Account <|-- DebitAccount
    Account <|-- SavingsAccount
    DebitAccount <|-- VirtualAccount
    
    
```

