```mermaid
classDiagram
    class A

class B
B --|> A

class C {
-String name
+String getName()
    }
C --|> B
C ..|> I
C ..|> I1


```
