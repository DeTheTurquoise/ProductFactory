package dmm.productfactory.applicationData;

public final class StringArrays {

    public static String[] getPlayForChildren(){
        return new String[] {
                "Zabawa w skojarzenia",
                "Poszukiwanie skarbów",
                "Gry planszowe",
                "Skoki przez płaską drabinkę (np. z gazety)",
                "Skoki przez linkę",
                "Kto wyżej podskoczy i narysuje linię",
                "Spacer na niby (wymyślamy co widzimy i co robimy)",
                "Przeciąganie liny",
                "Raz, dwa, trzy – baba jaga patrzy",
                "Ciuciubabka",
                "Baloniku mój malutki",
                "Gra w klasy",
                "Celowanie",
                "Rowerek bez pedałów",
                "Hulajnoga, rower, rolki",
                "Tor przeszkód",
                "Slalom",
                "Kalambury",
                "Tworzenie zwierzątek z rolek po papierze toaletowym",
                "Kto dalej popchnie mały przedmiot",
                "Kto dalej rzuci piłkę",
                "Origami",
                "Samoloty z papieru",
                "Pieczenie ciasteczek",
                "Podlewanie kwiatów",
                "Zabawa w ciepło – zimno",
                "Zabawa w zgaduj zgadula",
                "Zabawa w pomidora",
                "Figurki z masy solnej",
                "Piasek kinetyczny",
                "Klocki",
                "Ciastolina",
                "Odbijanie balonów",
                "Puszczanie baniek mydlanych",
                "Odrysowywanie cieni",
                "Okazjonalne ozdoby lub kartki",
                "Rysowanie po kartce pokrytej wzorem z białej świecy",
                "Rysowanie po kartce położonej na wypukłym motywie np. monecie",
                "Czytanie książki",
                "Wspólne wymyślanie historii",
                "Zabawa w chowanego",
                "Skakanie na piłce",
                "Wycinanie obrazków z gazet",
                "Malowanie farbami",
                "Pieczątki",
                "Budowanie wysokiej wieży (nie koniecznie z klocków",
                "Wyścigi małych samochodzików",
                "Puzzle",
                "Śpiewanie",
                "Tańczenie",
                "Turlanie",
                "Zawijanie w koc (naleśnik)",
                "Huśtanie",
                "Rysowanie stopami",
                "Rowerek",
                "Samolot",
                "Wymyślanie rymowanek",
                "Rozpoznawanie przedmiotów z worka po dotyku"

        };
    }
    public static String[] getThingsToDo(){
        return new String[] {
                "Rozmarz się o swoim nowym projekcie",
                "Zaplanuj ubranie na jakąś okazję",
                "Obejrzyj ubrania w swoim ulubionym sklepie",
                "Tańcz do spokojnej muzyki",
                "Tańcz do wesołej muzyki",
                "Przeczytaj fragment Biblii",
                "Pomaluj paznokcie",
                "Przeczytaj fragment książki, która jest aktualnie otwarta w Kindle",
                "Obejrzyj film",
                "Dodaj coś do kodu swojej aplikacji",
                "Zrób notatkę wizualną do aktualnie słuchanego podcastu",
                "Zrób lekcję języka obcego",
                "Przeczytaj fragment książki branżowej",
                "Wypij filiżankę słodkiej herbaty",
                "Wypij kubek mleka",
                "Wypij szklankę wody",
                "Wypij filiżankę ziołowej herbaty",
                "Zrób lekcję aktualnego kursu online",
                "Przygotuj koktajl owocowy",
                "Zaprojekuj przestrzeń w swoim mieszkaniu",
                "Sprawdź porządek w szafie",
                "Sprawdź porządek w aneksie",
                "Sprawdź porządek w salonie",
                "Sprawdź porządek w łazience",
                "Sprawdź porządek na korytarzu",
                "Przeczytaj zalegające maile",
                "Sprawdź stan butów",
                "Posłuchaj muzyki musicalowej",
                "Posłuchaj muzyki filmowej",
                "Posłuchaj poezji śpiewanej",
                "Posłuchaj muzyki tanecznej",
                "Przytul się",
                "Przeczytaj fragment beletrystyki",
                "Przejrzyj zabawki dzieci",
                "Pomyśl o nowych zabawkach dla dzieci",
                "Dodaj zdjęcie na Instagram",
                "Przeczytaj artykuł z zakładek",
                "Zrób kilka ćwiczeń rozciągających",
                "Zaśpiewaj bardzo głośno radosną piosenkę",
                "Zaśpiewaj wiersz",
                "Pomódl się",
                "Zrób listę filmów do obejrzenia",
                "Zrób listę książek do przeczytania",
                "Uporządkuj książki",
                "Pokoloruj kolorowankę",
                "Pomaluj kolorowankę",
                "Narysuj to, co widzisz",
                "Namaluj to, co widzisz",
                "Znajdź przyjemny zapach",
                "Napisz list",
                "Przygotuj kartkę okolicznościową",
                "Zapisz zdanie, które od dawna chodzi Ci po głowie",
                "Posłuchaj podcastu",
                "Przeczytaj artykół z bloga Domowe Zawirowania",
                "Zadbaj o swoje dłonie",
                "Zadbaj o swoje stopy",

        };
    }
    public static String[] javaBestPractices(){
        return new String[] {
          "Prefer returning Empty Collections instead of Null",
          "If a program is returning a collection which does not have any value, make sure an Empty collection is returned rather than Null elements",
          "Use Strings carefully",
                "If two Strings are concatenated using “+” operator in a “for” loop, then it creates a new String Object, every time",
                "String good = \"Yet another string object\"\n - while instantiating a String Object, constructors should be avoided and instantiation should happen directly",
                "Avoid unnecessary Objects",
                "One of the most expensive operations (in terms of Memory Utilization) in Java is Object Creation",
                "Thus it is recommended that Objects should only be created or initialized if necessary",
                "Arrays have fixed size but ArrayLists have variable sizes",
                "Since the size of Array is fixed, the memory gets allocated at the time of declaration of Array type variable",
                "Arrays are very fast",
                "ArrayList is More data will lead to ArrayOutOfBoundException and less data will cause wastage of storage space",
                "It is much easier to Add or Remove elements from ArrayList than Array",
                "Array can be multi-dimensional but ArrayList can be only one dimension",
                "System.exit halts execution of all the running threads including the current one",
                "Even finally block does not get executed after try when exit is executed",
                "When System.exit is called, JVM performs two cleanup tasks before shut down\n-  it executes all the shutdown hooks which have been registered with Runtime.addShutdownHook. This is very useful because it releases the resources external to JVM\n- System.runFinalizersOnExit or Runtime.runFinalizersOnExit. The use of finalizers has been deprecated from a long time. Finalizers can run on live objects while they are being manipulated by other threads.This results in undesirable results or even in a deadlock",
                "Check Oddity - Consider a negative Odd number, use\n- return (num & 1) != 0;\n",
                "Arithmetic and Logical operations are much faster compared to division and multiplication",
                "In case of single quotes, the char -valued operands ( ‘H’ and ‘a’ ) to int values through a process known as widening primitive conversion. After integer conversion, the numbers are added and return 169",
                "Always release database connections when querying is complete",
                "Try to use Finally block as often possible",
                "Release instances stored in Static Tables",
                "Normally deadlocks occur when one synchronized object is waiting for lock on resources locked by another synchronized object",
                "Reserve memory for Java - some applications generally run slow because of a high RAM requirement - in order to improve performance, RAM is reserved for Java \nexport JAVA_OPTS=\"$JAVA_OPTS -Xms5000m -Xmx6000m -XX:PermSize=1024m -XX:MaxPermSize=2048m\"\n",
                "System.currentTimeMillis takes somewhere between 1/1000th of a second to 15/1000th of a second (depending on the system) but System.nanoTime() takes around 1/1000,000th of a second (1,000 nanos)",
                "System.currentTimeMillis takes a few clock cycles to perform Read Operation. On the other hand, System.nanoTime() takes 100+ clock cycles",
                "System.currentTimeMillis reflects Absolute Time (Number of millis since 1 Jan 1970 00:00 (Epoch Time)) but System.nanoTime() does not necessarily represent any reference point",
                "Double is often preferred over float in software where precision is important because most processors take nearly the same amount of processing time to perform operations on Float and Double - double offers far more precision in the same amount of computation time",
                "Math.pow should be used ONLY when necessary - Math.pow() method is typically around 300-600 times slower than a multiplication",
                "Handle Null Pointer Exceptions - it’s a good idea to check Nulls early so that they can be eliminated",
                "Encode in JSON - an easier-to-use alternative to XML",
                "Simple String Search -  indexOf(), this method is used with String Object and it returns the position of index of desired string",
                "Listing content of a directory - File file = new File(\"//home//user//Documents/\");\nString[] files = file.list();\n\nSystem.out.println(\"Listing contents of \" + file.getPath());\nfor(int i=0 ; i < files.length ; i++)\n{\nSystem.out.println(files[i]);\n}",
                "In order to read from a file and write to a file, Java offers FileInputStream and FileOutputStream Classes",
                "Java offers Runtime class to execute Shell Commands",
                "Using Regex - Regular Expression Constructs",
                "With the help of Java Swing GUI can be created. Java offers Javax which contains “swing”. The GUI using swing begin with extending JFrame. Boxes are added so they can contain GUI components like Button, Radio Button, Text box, etc. These boxes are set on top of Container.",
                "PDF Export - itextpdf",
                "Play a sound with Java - javax.sound.sampled.*",
                "Sending Email - install Java Mail Jar and set its path in our program’s classpath",
                "Rescale Image - AffineTransform",
                "Capturing Mouse Hover Coordinates - MouseMotionListner",
                "FileOutputStream is meant for writing streams of raw bytes such as image data. For writing streams of characters, consider using FileWriter",
                "Use Collections - Vector, Stack, Hashtable, Array",
                "Use of collections makes the code reusable and interoperable",
                "Collections make the code more structured, easier to understand and maintainable",
                "Out of the box collection classes are well tested so the quality of code is good",
                "10-50-500 Rule - \nNo package can have more than 10 classes\nNo method can have more than 50 lines of code\nNo class can have more than 500 lines of code",
                "Single responsibility principle - A class should have one and only one task/responsibility. If class is performing more than one task, it leads to confusion",
                "Open/closed principle - The developers should focus more on extending the software entities rather than modifying them",
                "Liskov substitution principle - It should be possible to substitute the derived class with base class",
                "Interface segregation principle - It’s like Single Responsibility Principle but applicable to interfaces. Each interface should be responsible for a specific task. The developers should need to implement methods which he/she doesn’t need",
                "Dependency inversion principle - Depend upon Abstractions- but not on concretions. This means that each module should be separated from other using an abstract layer which binds them together",
                "Design patterns help developers to incorporate best Software Design Principles in their software. They also provide common platform for developers across the globe. They provide standard terminology which makes developers to collaborate and easier to communicate to each other.",
                "Never just start writing code. Strategize, Prepare, Document, Review and Implementation. First of all, jot down your requirements. Prepare a design document. Mention assumptions properly. Get the documents peer reviewed and take a sign off on them.",
                "Use Equals over == - == compares object references, it checks to see if the two operands point to the same object (not equivalent objects, the same object).On the other hand, “equals” perform actual comparison of two strings",
                "Avoid Floating Point Numbers - Floating point numbers should be used only if they are absolutely necessary. For example, representing Rupees and Paise using Floating Point numbers can be Problematic – BigDecimal should instead be preferred. Floating point numbers are more useful in measurements.",
                "Avoid String Concatenation in a Large Loop - good example:\nStringBuilder sb = new StringBuilder();\nfor (String s : largeArray) {\nsb.append(s);\n}\nString output = sb.toString();",
                "",
        };
    }
}
