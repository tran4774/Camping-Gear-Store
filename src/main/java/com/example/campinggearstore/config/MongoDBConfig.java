package com.example.campinggearstore.config;

import com.example.campinggearstore.entity.BaseEntity;
import com.mongodb.client.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ReadPreference;
import com.mongodb.client.MongoClients;
import dev.morphia.Datastore;
import dev.morphia.Morphia;
public class MongoDBConfig {

//    public static final String DB_HOST = "127.0.0.1";
//    public static final int DB_PORT = 27017;
//    public static final String DB_NAME = "morphia_demo";

//    private static final Logger LOG = Logger.getLogger(MongoDBConfig.class.getName());

    private static MongoDBConfig mongoDBConfig;
    private static Datastore datastore;
    public MongoDBConfig() {
        MongoClientOptions mongoOptions = MongoClientOptions.builder()
                .socketTimeout(60000) // Wait 1m for a query to finish, https://jira.mongodb.org/browse/JAVA-1076
                .connectTimeout(15000) // Try the initial connection for 15s, http://blog.mongolab.com/2013/10/do-you-want-a-timeout/
                .maxConnectionIdleTime(600000) // Keep idle connections for 10m, so we discard failed connections quickly
                .readPreference(ReadPreference.primaryPreferred()) // Read from the primary, if not available use a secondary
                .build();
        MongoClient mongoClient = MongoClients.create(System.getenv("MONGO_URI"));
        datastore = Morphia.createDatastore(mongoClient, System.getenv("DBNAME"));
        datastore.getMapper().mapPackage(BaseEntity.class.getPackage().getName());
        datastore.ensureIndexes();
        datastore.ensureCaps();
        //LOG.info("Connection to database '" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME + "' initialized");
        //LOG.info("Connection to database initialized");
    }

    public static MongoDBConfig getInstance(){
        if(mongoDBConfig == null)
            mongoDBConfig = new MongoDBConfig();
        return mongoDBConfig;
    }

    public Datastore getDatabase() {
        return datastore;
    }
}