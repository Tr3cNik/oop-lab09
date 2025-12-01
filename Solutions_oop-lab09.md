# oop-lab09 - Teoria

## Dipendenze di Librerie di Terze Parti

All'interno di un progetto Java può servire l'utilizzo di librerie per utilizzare del codice già fatto da altri.

Queste librerie a loro volta sono dipendenti da altre, e così via.

Queste librerie dipendenti sono chiamate transitive e sono la maggioranza all'interno di un progetto serio.



Per trovare tali librerie Java non fornisce uno standard per i nomi delle librerie, ma solo per i classpath, che risultano lunghi e complicati da utilizzare con tutta la serie di dipendenze delle librerie.



Per risolvere tale mancanza di standard viene in nostro aiuto il build system **Apache Maven**, che ha elaborato una propria convenzione oramai divenuta standard.



Una libreria Java scritta in convenzione Maven si compone di:

* `groupID`, un identificatore per il progetto o il gruppo di lavoro.
  Di base è un URL invertito.
* `artifactID`, un identificatore per una specifica libreria o modulo di progetto.
  Di base è un nome in `kebab-case`.
* `version`, un identificatore per una specifica versione di libreria.



Le librerie si possono trovare su una repository open-source definita da Maven, cioè **Sonatype OSSRH**.
All'interno si trovano molte librerie e sono documentate le dipendenze di esse.



Invece, per la gestione delle dipendenze si utilizza Gradle.



Per preparare il necessario per un progetto Java e configurare come repository per le librerie Maven Central basta configurare `build.gradle.kts` nella seguente maniera:

`plugins { java }`

`repositories { mavenCentral() }`



Una volta trovata da Maven Central la libreria che si ritiene utile, Gradle consente di specificare il suo "scope" (il suo utilizzo).
Tra gli scope ci sono:

* `implementation`: libreria usata sia per compilare sia per eseguire
* `testImplementation`: libreria usata per compilare ed eseguire test
* `testRuntimeOnly`: libreria usata per eseguire i test (non compilare)



Una volta specificato lo scope, si inserisce la libreria nel blocco `dependencies` di Gradle:

`dependencies {`

`implementation("com.omertron:API-OMDB:1.5")`

`}`



Quindi, all'utilizzo di `compileJava`, Gradle si occupa di:

* Scaricare la libreria
* Salvarla nella cartella dell'utente per uso futuro
* Includerla nel classpath di compilazione



Tra le librerie conosciute ci sono:

* Google Guava
* Apache Commons
* Static Logger Facade for Java



Esiste una lista delle più comuni, diffuse e stabili librerie usate per Java: **Awesome Java**.
È consigliato usarle DOPO aver progettato il modello di dominio della propria applicazione.



## Caricamento di Risorse dal Classpath

Con **risorsa** s'intende qualsiasi cosa che è necessaria al corretto funzionamento del programma, ma che non sia una liberia o un file sorgente.



Fin'ora le risorse sono sempre state caricate dal classpath, ma per caricare tali risorse da delle posizioni diverse al classpath si utilizza `ClassLoader.getSystemResource()`, che prende in argomento il nome di una risorsa usato dal system class loader per cercare la risorsa come un path a partire dall'inizio del classpath.



*Attenzione*: le risorse caricate dal classpath sono in sola lettura



(c'è anche qualcosa sull'installazione delle impostazioni per utente)



## Programmazione Multipiattaforma

Si ottiene il cosiddetto "write once, run anywhere" se:

* Viene adottato un approccio di programmazione adeguato
* Viene predisposto un packaging efficace



Per accedere ai file system di sistemi operativi differenti vengono rivelati alcuni problemi:

* I separatori per i path cambiano
* La struttura del file system cambia
* I diritti di lettura e scrittura cambiano con la configurazione



Per accedere a proprietà di sistema Java fornisce la classe System con:

* `getProperty(String p)`
* `file.separator`
* `java.home`
* `user.dir`
* `user.home`
* `user.name`



Java fornisce inoltre delle proprietà per identificareOS, versione e JVM corrente. Tali proprietà sono relative al sistema operativo:

* `java.version`
* `os.arch`
* `os.name`
* `os.version`



Per quanto riguarda le GUI:

* La dimensione di default della finestra va calcolata in base alla dimensione dello schermo
* È opportuno specificare la dimensione della finestra in termini relativi rispetto al container
* Stessa cosa per la dimensione dei font



(c'è qualcosa scritta per supporto multilingua e multipiattaforma)



### Come fare la clone

`git clone https://github.com/unibo-oop/lab##.git`

`cd lab##`

`git remote remove origin`

(Crea la repo su github (aggiungi un `.gitignore` almeno si capisce qualcosa))

`git remote add origin https://github.com/Tr3cNik/oop-lab##.git`

`git push -u origin exercises`

(rimuovi `main branch` dalla repo e metti di defualt `exercises`)

