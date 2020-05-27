
# ITI 1121 - Lab 04

## Submission

Please read the [junit instructions](JUNIT.en.md) for help
running the tests for this lab.

Please read the [Submission Guidelines](SUBMISSION.en.md) carefully.
Errors in submitting will affect your grades.

Submit your answers to

* Post.java
* PhotoPost .java
* TextPost.java
* NewsFeed.java **Using static array**

You do not need to submit your
solution to the Optional NewsFeed.java based
on **Using dynamic array**

## Objectives

* **Apply** the concept of inheritance to design an application.
* **Design** a class that makes use of an interface.


## 1 - Inheritance and polymorphism

* A class (child) is said to be **derived** from another **if it inherits** from that class (parent).
* The key word **extends** is used to signifiy that a class inherits from the given class.
* When a class is derived from another, this class can access all the **methods** or **instance variables** that are declared **public** or **protected**.
* Inheritance makes use of **polymorphism**. It is possible to call a method of a parent class using the key word **super**.

The word **polymorphism** derives from the words _poly_ meaning "many", and _morphism_ meaning "behaviour". In Java, **polymorphism** means that an **instance of a class** (an object) can be used as if it were of different types, thus having **many behaviours**. Here, a type means a class is **derived** from another **class** or an **interface.**

## 2 - Interfaces

You can use **interfaces** in Java as a way to achieve **polymorphism**.

```java
public interface GreetingsInterface {

  // An interface cannot contain an implementation
  // of the method, only the signature
  public abstract void sayGreetings();

}
```

Although the language allows you to declare constants in an interface, the **general best practice** is to avoid placing constants in interfaces and to only declare abstract methods.

The **methods** however need to be **implemented** by some class **before** you can execute them. All the **methods** in an interface are **public** and **abstract**, even if you leave out the "public" and "abstract" keywords.

To use an interface you must **implement** that interface in some Java **class**.

```java
// The key word implements signals to the compiler
// that the SpanishGreetings class implements the
// GreetingsInterface interface
public class SpanishGreetings implements GreetingsInterface {

  // A class that implements an interface must implement
  // all the methods declared in the interface
  public void sayGreetings() {
    System.out.println("Hola");
  }
}

public class JapaneseGreetings implements GreetingsInterface {
  public void sayGreetings() {
    System.out.println(“Konnichiwa”);
  }
}
```

Once a class **implements** an **interface** you safe the reference of an instance of that class in a reference variable whose type is the name of the **interface**. Here is an example of a main method:

```java
public static void main(String[] args){

  // The variable is declared of interface type GreetingsInterface,
  // the object created is of type SpanishGreetings
  GreetingsInterface myGreetings = new SpanishGreetings();
  myGreetings.sayGreetings();

  // The variable is declared of interface type GreetingsInterface,
  // the object created is of type JapaneseGreetings
  myGreetings = new JapaneseGreetings();
  myGreetings.sayGreetings();

}
```


### Question 2.1:

What gets printed to the console after executing the method main?

If you omit implementing one of the methods that is part of the interface, an error message will occur. Let us take the example from above but this time **SpanishGreetings** does not implement **sayGreetings()** method.

```java
public class SpanishGreetings implements GreetingsInterface {
  /*public void sayGreetings() {
      System.out.println(GreetingsInterface.greetings);
  }*/
}
```
After compiling the **SpanishGreetings** class, we get the following:

```java
SpanishGreetings.java:1: error:
SpanishGreetings is not abstract and does not override abstract method sayGreetings() in GreetingsInterface
public class SpanishGreetings implements GreetingsInterface {
       ^
1 error
```

The error message shows us that we **haven't defined** the method **sayGreetings()** in **GreetingsInterface**. Again, once more time, we remind you the imporance to **read carefully** the error messages. This last error is quite precises as to the nature of your error.

To continue, a class can implement **multiple** Java interfaces.

```java
public interface PartingsInterface {
  public void sayPartings();
}

// List the names of the interfaces
// to implement separated by a comma.
public class SchwarzeneggerPhrases implements GreetingsInterface, PartingsInterface {

  public void sayGreeting() {
    System.out.println("I’ll be back");
  }

  // The class must still implement all the
  // methods declared in all the interfaces
  public void sayParting() {
    System.out.println("Hasta la vista");
  }

  public static void main(String[] args){
    GreetingsInterface myGreetings = new SchwarzeneggerPhrases();
    myGreetings.sayGreetings();

    PartingsInterface myPartings = new SchwarzeneggerPhrases();
    myPartings.sayPartings();
  }
}
```

## Question 2.2:

What gets printed to the console after executing the method main?

It is possible for an **interface** to inherit from **another interface**, just like classes can inherit from other classes. You specify inheritance using the "**extends**" keyword to declare your interface derives from another. Unlike classes, **interfaces** can inherit from multiple superinterfaces. You specify that by listing the names of all **parent interfaces** to inherit from, separated by **comma**. Here is a simple interface inheritance example:

```java
// TalkingInterface inherits all field and methods
// from GreetingsInterface and PartingsInterface .
public interface TalkingInterface extends GreetingsInterface, PartingsInterface {
    public void sayItAll();
}

// A class implementing an interface which inherits
// from multiple interfaces must implement all methods
// from the interface and its superinterfaces
public class HamletTalking implements TalkingInterface {

  public void sayGreetings() {
    System.out.println("To be or not to be");
  }

  public void sayPartings() {
    System.out.println("That is the question");
  }

  public void sayItAll() {
    sayGreetings();
    sayPartings();
  }

  // We create an instance of HamletTalking in main method
  public static void main(String[] args){
    TalkingInterface myTalking = new HamletTalking();
    myTalking.sayItAll();
  }
}
```

### Question 2.3:

What gets printed to the console after executing the method main?


### In short:

* An interface contains **only** **abstract methods**. An abstract method does not have an implementation.
* The keyword **implements** is used to express the relationship between the class and the interface.
* When a class implements an interface, this is a sort of **contract** that means that the class will have to implement **all the methods** of the interface.
* You cannot **create instances of an interface by itself**. You must create an instance of a class that implements the interface, and reference this instance using a reference variable whose type is the name of the interface
* A **class** can implement ("**implements**") several **interfaces**
* An **interface** extend ("**extends**") several **interfaces**

## 3 - "Super" classes

The keyword "**super**" is used to call the constructor, methods, and properties of a **parent class**. If your method **overrides** one of its **parent class’s** methods, you can invoke the overridden method through the use of the keyword **super**. Here are some examples of how the keyword super is used:

* **super()** calls the **parent class** constructor with no arguments.
* It can also be used with arguments. i.e. **super(argument1)**, and it will call the constructor that accepts 1 parameter of the type of argument1 (if it exists).
* Also it can be used to call methods from the parent i.e. **super.aMethod()**
* and variables from the parent i.e. **super.aVariable**

**Important note**: the constructor call super() must be the **first statement** in a constructor.

Consider the following example where **Frog** is derived ("**extends**") from the class **Animal** and makes two types of noises, “Ribbit” and “Bark”.

```java
public class Animal {
  protected final String noise;

  protected Animal() {
    this.noise = "silent";
  }

  protected Animal(String noise) {
    this.noise = noise;
  }

  public void makeNoise() {
    System.out.println(noise);
  }
}

public class Frog extends Animal {
  private final String noise;

  public Frog() {
    // constructor call super() must be the
    // first statement in a constructor
    super("Ribbit"); // call parent constructor

    super.makeNoise(); // call parent method

    this.noise = "Bark";

    // call parent variable and compare to class variable
    if (!super.noise.equals(this.noise)) {
        makeNoise(); // call class method
    }
  }

  public void makeNoise() {
      System.out.println(noise);
  }
}
```

### Question 3:

If you were to create a new object Frog with a constructor call, what would be printed to the console?


## Exercise

You will hand in this exercise.

A start-up company named _Gazouillis_ wants to implement a breakthrough software system to exchange text and photographic messages. You have been tasked to create the prototype implementation that will be demonstrated to the investors.

This UML diagrams give you an overview of this application. Follow the instructions below:

![UMLdiargram ](lab4_img1_NewsFeed2.png "Diagramme UML de l'application NewsFeed")

**Figure 1:** UML diagram for the application NewsFeed

### 1- Likeable

Implement the interface Likeable. It declares two methods: **like()** and **int getLikes()**.

### 2- Post

Write the implementation of the class Post. It implements the characteristics that are common to its sub-classes, here **TextPost** and **PhotoPost**.

* **Post** implements the **interface Likeable**.
* All the **Post** messages have a user name, a time stamp (of type **java.util.Date**), as well as a **count** for the number of **likes**.
* The value of the time stamp is automatically assigned when an object is created. Use **java.util.Calendar.getInstance().getTime()** to obtain a **Date** object representing the current time. A **Date** object has a method **toString()** that converts this date to a **String**

```java
Date rightNow = Calendar.getInstance().getTime();
System.out.println(rightNow);
```

* Each call to the method **like()** increases the number of likes for this message.
* **Post** implements the **interface Comparable**. This interface allows you to compare two **Post** according to specific criteria. In this case the criteria will be the **date** of the post. For more information, refer to the [documentation](https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html).
* Add the method isPopular. This method returns true if the post is considered popular (more than 100 likes), false otherwise.
* Do not forget the method **toString()**!

### 3- PhotoPost

Implement the class **PhotoPost**. A **PhotoPost** is a specialized **Post**. It stores a **file name** and a **caption**. Override the method **toString()** by using the keyword **"super"** in your implementation.

### 4- TextPost

Implement the class **TextPost**. A **TextPost** is a specialized **Post**. It stores a **text message** (String). Override the method **toString** using the keyword **“super”** in your implementation. A **TextPost** is considered popular if the post gets more than **50 likes**.

### 5- NewsFeed

Write the implementation of the class **NewsFeed**. A **NewsFeed** object stores **Post** messages

* It uses a fixed size array of some constant size **MAX_SIZE** to **store Post messages** . For this implementation will only accept up to **25** Post messages.
* It has a method for **adding a Post message**. The message is added after the last message added.
* It has a method **sort** in which the Post are sorted from the oldest to the most recent.
* It has a method for returning the message found at a given index, **Post get(int index)**.
* It has a method **size** that returns the number of messages currently stored.
* It has a method **getPhotoPost** that returns a new object of type **NewsFeed** containing only the **PhotoPost**
* It has an instance method **plus** that has one formal parameter of type **NewsFeed**. This method returns a new object of type **NewsFeed** that represents the **combination of the two NewsFeed**. The **Post** of the **new NewsFeed** have to be **sorted** from the oldest to the most recent one.

### Optional

You do not need to submit your
solution to this version of NewsFeed.java

* Write the implementation of the class **NewsFeed** using a **dynamic** array (array that automatically changes size) to store Post messages, instead of a fixed size array.
* The constructor has two parameters, the **initial capacity of the array** and **the capacity increment**
* Each time the array is full, the implementation should **create a new array** larger by the capacity increment.

Implement all the necessary **constructors**. Each attribute must have a **getter** method.

Here is a main program illustrating the use of these classes. Adapt it to make sure that all methods are implemented correctly. **You must not submit this file: NewsFeedMainApplication.java.**

* NewsFeedMainApplication.java

## Resources

* [https://docs.oracle.com/javase/tutorial/getStarted/application/index.html](https://docs.oracle.com/javase/tutorial/getStarted/application/index.html)
* [https://docs.oracle.com/javase/tutorial/getStarted/cupojava/win32.html](https://docs.oracle.com/javase/tutorial/getStarted/cupojava/win32.html)
* [https://docs.oracle.com/javase/tutorial/getStarted/cupojava/unix.html](https://docs.oracle.com/javase/tutorial/getStarted/cupojava/unix.html)
* [https://docs.oracle.com/javase/tutorial/getStarted/problems/index.html](https://docs.oracle.com/javase/tutorial/getStarted/problems/index.html)

