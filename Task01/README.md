## 01. Clean Code

### 01. Именование переменных

* `camelCase`

```
int c; // плохо
int count; // хороший
int steps_count; // не надо
int stepsCount; // идеально
```

* Можно называть однобуквенно, если это часть цикла - `for (int i ...)`, `for (int j ...)`

### 02. Именование и структура методов

* Метод делает только то, что отражено в его названии

```
publiv static void sort(int array[]) {
    for (...) {
        for (...) {
        }
    }
    
    System.out.println(Arrays.toString(array)); // плохо, разрешено при отладочном выводе
}
```

* Если внутри метода слишком много кода, возможно, имеет смысл выделить еще один метод

* Примеры

```
public int func(int a, int b) { ... } // плохо

public boolean isActive() { ... } // хороший

public double getAverage(int ages[]) { ... } // хорошо, если метод работает за O(1)

public double calcAverage(int ages[]) { ... } // идеально
```


### 03. Структура и именование классов, интерфейсов и абстрактных классов

* `PascalCase`
* Интерфейсы именуем без `I`, `IReader` -> `Reader`
* Название абстрактных классов начинаем со слова `Abstract` -> `AbstractReader` 

* Структура класса:

```
class SomeClass {
    // константы
    public static final int MAX_SIZE = 10;
    
    // вложенные и внутренние классы
    private static class NestedClass {
        ...
    }
    
    private class InnerClass {
        ...
    }
    
    // поля - всегда приватные
    private int size;
    
    // конструкторы
    public SomeClass() {
        // ...
    }
    
    // методы и/или getter-setters
```

* Класс не должен иметь большой ответственности, делает только то, что должен:

```
public class UserService { 

    public void authenticate(String username, String password) {
        ...
    }
    
    public void printLogsAndStackTrace() { // плохо
        ...
    }
```

### 04. Что значит хороший код?

* Гибкость - легко что-то заменить
* Масштабируемость - легко что-то добавить