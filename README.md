## Projet socle job Dataflow
Dans ce repo un projet socle de job Dataflow qui utilise le concept de programmation Apache Beam.

### Dataflow
--- 
Un traitement des données par flux et par lot sans serveur, à la fois rapide, unifié et économique.
- Un service de traitement des données entièrement géré
- Gestion et provisionnement automatisés des ressources de traitement
- Autoscaling horizontal des ressources de nœuds de calcul pour une utilisation optimale des ressources
- Innovation impulsée par la communauté dans la création de logiciels Open Source avec le SDK Apache Beam
- Traitement "exactement une fois" fiable et cohérent

### Technologies
---
- Java 11
- Spring Boot 2.7.7
- Apache Beam 2.43.0

### Commande création et lancement de la Template
---
1. Activer le SA google cloud storage
2. Compiler le projet : mvn compile exec:java -Dexec.mainClass=com.poc.MainApplication -Dexec.args="--runner=DataflowRunner --region= --zone= --project= --stagingLocation= --templateLocation= --gcpTempLocation=" 
3. Activer le SA google cloud dataflow
4. Lancer le job : gcloud dataflow jobs run df-socle-ingest-id --disable-public-ips --region= --worker-zone= --project= --staging-location= --gcs-location=  --network= + TOUS les paramètres utilisés par le job

### Ressources pour apprendre Dataflow
---
- Apache Beam - https://beam.apache.org/documentation/
- Dataflow - https://cloud.google.com/dataflow?hl=fr
