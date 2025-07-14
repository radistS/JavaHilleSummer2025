## Задачі по темі "Робота з рядками" (Java)

### 1. Сжатий рядок (Compression)

**Завдання:** Реалізуй метод:

```java
String compress(String input);
```

Приклад:

```
compress("aaabccdddda") → "a3bc2d4a"
```

Якщо символ зустрічається один раз — не додавати цифру.

---

### 2. Сума чисел у рядку

**Завдання:** Метод повинен знайти всі числа у рядку та повернути їхню суму.

```java
int sumNumbers(String input);
```

Приклад:

```
sumNumbers("abc12de3f100") → 115
```

---

### 3. Виділити ім'я файлу та розширення

**Завдання:** Реалізуй метод:

```java
FileInfo parseFilePath(String path);
```

Приклад:

```
"/home/user/docs/report.pdf" → name: "report", ext: "pdf"
```

---

### 4. Валідація email-адреси

**Завдання:** Реалізуй метод:

```java
boolean isValidEmail(String email);
```

Перевірка має відбуватись за допомогою регулярного виразу.

---

### 5. Пошук email-адрес у тексті

**Завдання:** Реалізуй метод:

```java
List<String> extractEmails(String text);
```

Витягни всі email-адреси з тексту.

---

### 6. Пошук IP-адрес у тексті (IPv4)

**Завдання:** Реалізуй метод:

```java
List<String> extractIps(String text);
```

Використай регулярний вираз, щоб знайти IPv4-адреси.

---

### 7. Маскування особистих даних

**Завдання:** Реалізуй метод:

```java
String maskSensitive(String input);
```

Приклад:

```
"Card number: 1234-5678-9876-5432" → "Card number: ****-****-****-5432"
```

---

### 8. Безпечне обрізання рядка

**Завдання:**

```java
String smartTrim(String input, int maxLength);
```

Обрізати рядок до `maxLength`, не обриваючи слова. Додати "..." у кінець, якщо є обрізання. Приклад:

```
smartTrim("Java is great", 7) → "Java is..."
```

---

### 9. Конвертація стилю строки

**Завдання:**

```java
String convertNaming(String input, CaseStyle from, CaseStyle to);
```

Підтримка стилів:

- camelCase
- snake\_case
- kebab-case

---

### 10. Зіставлення версій

**Завдання:**

```java
int compareVersions(String v1, String v2);
```

Повертає:

- `-1`, якщо `v1 < v2`
- `0`, якщо рівні
- `1`, якщо `v1 > v2`

Приклад:

```
"1.10.2" > "1.2.9"
```

---

### 11. Валідація IBAN

**Завдання:**

```java
boolean isValidIban(String iban);
```

Реалізуй перевірку IBAN за алгоритмом мод-97.

---

