# ITI 1521 - Lab 04

## Soumission

Veuillez lire les [instructions junit](JUNIT.fr.md) pour obtenir
de l'aide avec l'exécution des tests pour ce laboratoire.

Veuillez lire attentivement les [Directives de soumission](SUBMISSION.fr.md).
Les erreurs de soumission affecteront vos notes.

Soumettez les réponses aux

* Post.java
* PhotoPost .java
* TextPost.java
* NewsFeed.java **tableau statique**

Vous n'avez pas besoin de soumettre votre
solution à la base facultative de NewsFeed.java
avec les **tableaux dynamiques**.

### Objectifs d'apprentissage

* **Appliquer** le concept d'héritage pour concevoir une application.
* **Concevoir** une classe qui réalise une interface.

## 1 - Héritage et polymorphisme

* Une classe (enfant) est dite **dérivée** d'une autre **si elle hérite** de cette classe (mère).
* Le mot clé **extends** est utilisé pour signifier qu'une classe hérite de la classe spécifiée.
* Lorsqu'une classe est dérivée d'une autre, elle peut accéder toutes les **méthodes** ou **variables d'instance** déclarées **public** ou **protected**.
* L'héritage utilise le **polymorphisme**. Il est possible d'appeler une méthode d'une classe parent en utilisant le mot clé **super**.

Le mot **polymorphisme** provient de « poly » qui signifie « plusieurs » et « morphes » qui signifie « formes ». En Java, le **polymorphisme** signifie qu'une **instance d'une classe** (un objet) peut être utilisée comme si elle avait plusieurs types, ayant ainsi de **nombreux comportements**. Par plusieurs types, on entend ici qu'elle **dérive** d'une autre classe ou d'autres interfaces.

## 2 - Les interfaces

Vous pouvez utiliser les **interfaces** en Java afin de démontrer le principe de polymorphisme.

```java
public interface GreetingsInterface {

  // An interface cannot contain an implementation
  // of the method, only the signature
  public abstract void sayGreetings();

}
```

Vous pouvez déclarer des constantes (**static** et **final**) dans une interface, mais en général, il ne s'agit **pas d'une pratique recommandée**. Nous essayons plutôt d'éviter de mettre des constantes dans les interfaces.

Les **méthodes** doivent **être implémentées** par les classes **avant** qu'il soit possible de les accéder. Notez que **toutes** les **méthodes** d'une interface sont **publiques**, et ce, même si vous omettez de mettre le mot clé « public ».

Pour faire usage d'une interface, vous devez **implémenter** (« implement ») cette dernière dans une **classe Java**.

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

Lorsqu'une classe **réalise** une **interface**, vous pouvez déclarer une **variable référence** dont le type est nom de l'**interface** (une variable référence dont le type est le nom de l'interface désigne un objet dont la classe réalise cette interface). Voici un exemple d'une méthode **main** :

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

Qu'est-ce qui sera imprimé sur la console lors de l'exécution de la méthode main?

Si on omet d'implémenter une méthode faisant partie de l'interface, nous obtiendrons un message d'erreur. Repronons l'exemple ci-haut, mais cettre fois **SpanishGreetings** n'implémente pas la méthode **sayGreetings()**.

```java
public class SpanishGreetings implements GreetingsInterface {
  /*public void sayGreetings() {
      System.out.println(GreetingsInterface.greetings);
  }*/
}
```

À la compilation de la classe **SpanishGreetings**, nous obtiendrons alors:

```java
SpanishGreetings.java:1: error:
SpanishGreetings is not abstract and does not override abstract method sayGreetings() in GreetingsInterface
public class SpanishGreetings implements GreetingsInterface {
       ^
1 error
```

Le message d'erreur nous mentionne que nous n'avons **pas redéfinit** la **méthode abstraite sayGreetings()** dans **GreetingsInterface**. Encore une fois, nous vous rappelons l'importance de **bien lire** les messages d'erreurs. Ces derniers sont toujours précis sur la nature de votre erreur.

Par ailleurs, une **classe** peut réaliser (implémenter) **plusieurs interfaces** en Java.

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

Qu'est-ce qui sera imprimé à la console?

Il est possible pour une **interface** d'hériter d'une **autre interface** tout comme les classes peuvent hériter d'une autre. Vous utiliserez le même mot clé « **extends** » pour déclarer que votre interface dérive d'une autre. Contrairement aux classes, les **interfaces** peuvent dériver de **multiples** « superinterface ». Pour ce faire, vous devez énumérer chacune des **interfaces mères** en les séparant par des **virgules**. Voici un exemple simple d'héritage multiple d'une interface:

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

Qu'est-ce qui sera imprimé à la console lors de l'exécution de HamletTalking?


#### En résumé:

* Une interface ne contient que des **méthodes abstraites**. Une méthode est abstraite si elle ne possède pas d'implémentation.
* Le mot clé **implements** est utilisé pour signifier qu'une classe réalise une interface donnée.
* Lorsqu'une classe réalise une interface, il s'agit en quelque sorte d'un **contrat** à l'effet que la classe devra implémenter **chacune des méthodes** de l'interface.
* Vous ne pouvez **pas créer une instance d'une interface**. Vous devez créer créer une instance de la classe qui implémente cette interface et référencer cette instance à une variable référence dont le type est le nom de l'interface.
* Une **classe** peut réaliser (« implements ») plusieurs **interfaces**
* Une **interface** peut étendre (« extends ») plusieurs **interfaces**

## 3 - Les "Super" classes

Le mot clé « super » est utilisé pour appeler le constructeur, les méthodes et les propriétés de la classe parent. Si votre méthode remplace (« override ») l'une des méthodes de sa **super classe**, vous pouvez quand même appeler la méthode remplacée, et ce, en utilisant le mot-clé « **super** ». Voici des exemples de l'utilisation du mot clé :

* **super()** appelle le constructeur de la classe parent sans arguments
* **super (argument1)** est un appel au constructeur de la classe parent qui accepte 1 paramètre du **type** de « argument1 » (notez que ce constructeur doit exister).
* **super** peut être utilisé pour appeler les **méthodes** de la classe parent à savoir **super.aMethod ()**
* **super** peut être utilisé pour utiliser les **variables** de la classe parent à savoir super.aVariable

**Important**: si l'on veut faire un appel au contructeur de la méthode parent « super() » doit être appelé comme **première instruction** du constructeur de la classe enfant.

Regardez l'exemple ci-dessous dans lequel **Frog** est dérivé (« extends ») de la classe **Animal** et fait deux types de bruit, « Ribbit » et « Bark ».

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

Si vous créez un nouvel objet de la classe Frog, qu'est-ce qui sera imprimé sur la console?


## Exercise

Vous allez soumettre cet exercice.

La compagnie Gazouillis veut implémenter un logiciel pour échanger des messages textes et des photos. On vous demande de créer l’implémentation initiale qui sera montrée aux investisseurs de la compagnie.

Le diagramme de classes UML ci-dessous donne une vue d’ensemble de l’application. Suivez les instructions suivantes :

![UMLdiargram ](lab4_img1_NewsFeed2.png "Diagramme UML de l'application NewsFeed")

**Figure 1 : Diagramme UML de l'application NewsFeed**

### 1- Likeable

Concevez l’**interface Likeable**. L’interface déclare deux méthodes : **like()** et **int getLikes()**.

### 2- Post

Écrivez l’implémentation de la **classe Post**. Elle implémente toutes les caractéristiques qui sont communes à ses sous-classes, soit **TextPost** et **PhotoPost**.

* **Post** réalise l’**interface Likeable**.
* Tous les **Post** ont un **nom d’utilisateur**, une **étiquette de temps** (time stamp) (de type java.util.Date), en plus d’un **compteur** pour garder le nombre de « likes ».
* La valeur de l’étiquette de temps est **automatiquement assignée** lorsqu’un objet est crée. Utilisez « java.util.Calendar.getInstance().getTime() » pour obtenir un objet Date représentant le temps actuel. L’objet Date a une méthode toString() qui convertit la date en une chaîne de caractères (String).

```java
Date rightNow = Calendar.getInstance().getTime();
System.out.println(rightNow);
```

* Chaque appel à la **méthode like()** incrémente le nombre de « likes » pour ce message.
* **Post** réalise l’**interface Comparable**. Cette interface vous permettra de comparer deux **Post** selon un critère choisi. Dans notre cas, il s'agira de la **date** de la publication. Pour davatange d'information sur cette interface, référez-vous à la [documentation](https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html).
* Ajoutez une méthode nommée **isPopular()**. Cette méthode retourne true si la publication est considérée populaire (plus de 100 likes), false autrement.
* N'oubliez pas la méthode **toString()**!

### 3- PhotoPost

Donnez l’implémentation de la **classe PhotoPost**. La classe PhotoPost est **dérivée de la classe Post**. Cette classe utilise deux variables d’instance afin de sauvegarder le **nom du fichier** et la **légende**. Surdéfinissez la méthode **toString()** en faisant usage du mot clé « super » dans votre implémentation.

### 4- TextPost

Donnez l’implémentation de la **classe TextPost**. Cette dernière est **dérivée de la classe Post**. Elle **sauvegarde un message texte** (String). Surdéfinissez aussi la méthode **toString()** en faisant usage du mot clé « super » dans votre implémentation. Un **TextPost** est pour sa partconsidéré **populaire** si la publication a plus de **50 likes**.

### 5- NewsFeed

Donnez l’implémentation de la **classe NewsFeed**. Un objet NewsFeed sauvegarde un ensemble d’objets de type Post.

* Le **constructeur** ne reçoit aucun paramètre. Il doit initialiser un **tableau de taille fixe** d'une taille constante **MAX_SIZE** pour **sauvegarder les messages Post**. Pour cette implémentation accepter jusqu'à **25 ** messages Post.
* Cette classe a une méthode **add** pour **ajouter un message Post**. Le message doit être ajouté **à la suite** du dernier message ajouté.
* Elle a une méthode **sort** qui classe les **Post** au sein du **NewsFeed** du plus ancien au plus récent.
* Elle a une méthode **Post get(int index)** qui **retourne le message** trouvé à l’index donné.
* Elle a une méthode **size** qui retourne le **nombre de messages actuellement** sauvegardés.
* Elle a une méthode **getPhotoPost** qui retourne un nouvel objet de type **NewsFeed** contenant **uniquement les PhotoPost** sauvegardés.
* Elle a une méthode d'instance **plus** qui n'a qu'un paramètre formel, de type **NewsFeed**. La méthode retourne un nouvel objet **NewsFeed** qui représente la combinaison des deux **NewsFeed**. Les **Post** du **NewsFeed** doivent être classés du plus ancien au plus récent dans le nouveau NewsFeed.

### Optionnel

Vous n'avez pas besoin de soumettre votre
solution à cette version de NewsFeed.java

* L’implémentation de la classe **NewsFeed** utilise maintenant un **tableau dynamique** (tableau adapté automatiquement selon la taille des donnéees) pour **sauvegarder les messages Post**, au lieu d'utiliser un tableau de taille fixe.
* Le constructeur prend deux paramètres, la **capacité initiale du tableau** et l’**incrément de la capacité**, c'est-à-dire le nombre de nouveaux messages que l'on veut ajouter à la taille du tableau plein précédent.
* Chaque fois que le tableau est plein, l’implémentation doit **créer un nouveau tableau** dont la taille sera déterminée par l’incrément (taille du nouveau tableau = taille de l'ancien tableau + incrément). Utiliser une méthode **increaseSize** qui sera appelée à chaque fois que le tableau est plein.

Ajoutez tous les constructeurs nécessaires. Chaque attribut (variable d'instance) doit avoir un accesseur (getter).

Voici un programme principal pour illustrer l’usage des classes de cette application. Adaptez-le afin de bien tester vos fonctionnalités. Ne soumettez pas cet fichier (NewsFeedMainApplication.java) !

* NewsFeedMainApplication.java

#### Resources

* [https://docs.oracle.com/javase/tutorial/getStarted/application/index.html](https://docs.oracle.com/javase/tutorial/getStarted/application/index.html)
* [https://docs.oracle.com/javase/tutorial/getStarted/cupojava/win32.html](https://docs.oracle.com/javase/tutorial/getStarted/cupojava/win32.html)
* [https://docs.oracle.com/javase/tutorial/getStarted/cupojava/unix.html](https://docs.oracle.com/javase/tutorial/getStarted/cupojava/unix.html)
* [https://docs.oracle.com/javase/tutorial/getStarted/problems/index.html](https://docs.oracle.com/javase/tutorial/getStarted/problems/index.html)
