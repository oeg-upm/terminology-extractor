# Terminology Extractor. Spanish Extension of JATE 2.0


## To install

### First Step  (trying to fix):

Clone or download JATE: https://github.com/ziqizhang/jate

Compile

> mvn clean

> mvn install

Copy jate/target/jate-2.0-beta.11-jar-with-dependencies.jar to  terminology-extractor/solr-5.3.0/contrib/jate/lib/jate-2.0-beta.11-jar-with-dependencies.jar



### Second step


Clean and install with mvn this repo

> mvn clean install


## To Init

To start Solr server use: 
> start_solr_server


## To execute

To add files stored in Corpus folder and add them to the Solr SpanishCore 

> java -cp target/terminology-extractor-1.0-jar-with-dependencies.jar org.upm.oeg.terminology.extractor.Populator -c Corpus -i SpanishCore

For commodity, use

> AddSpanishCorpus.bat


## To retrieve terminology 

To retrieve a json file with terminology. Cvalue from SpanishCore

> curl -X POST http://localhost:8983/solr/SpanishCore/cvalue


TTF-IDF from SpanishCore

> curl -X POST http://localhost:8983/solr/SpanishCore/ttfidf


Also can be queried from the web interface
>  http://localhost:8983/solr/#/SpanishCore/query

and put /cvalue or /ttfidf in the Request-Handler

## To close

To stop Solr server use (remember to do):
 
> stop_solr_server

# Acknowledges
This work contains the library JATE 2.0  and an extension to work with Spanish documents

Zhang, Z., Gao, J., Ciravegna, F. 2016. JATE 2.0: Java Automatic Term Extraction with Apache Solr. In The Proceedings of the 10th Language Resources and Evaluation Conference, May 2016, Portorož, Slovenia


This work contains the latest Spanish POS models for OpenNLP via: https://github.com/utcompling/OpenNLP-Models

