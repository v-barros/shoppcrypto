package com.shoppcrypto.shoppcrypto.config.mongo;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.shoppcrypto.shoppcrypto.config.ConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import static java.util.Collections.singletonList;

@Configuration
public class ApplicationContextEventTestsAppConfig extends AbstractMongoClientConfiguration {

    @Override
    public String getDatabaseName() {
        return "shoppcrypto_dev";
    }

    @Autowired
    private ConfigProperties configProperties;
    @Override
    protected void configureClientSettings(MongoClientSettings.Builder builder) {

        builder
                .credential(MongoCredential.createCredential(
                        configProperties.getConfigValue("spring.data.mongodb.username"),
                        configProperties.getConfigValue("spring.data.mongodb.database"),
                        configProperties.getConfigValue("spring.data.mongodb.password").toCharArray()))
                .applyToClusterSettings(settings  -> {
                    settings.hosts(singletonList(new ServerAddress(
                            configProperties.getConfigValue("spring.data.mongodb.host"),
                            Integer.parseInt(configProperties.getConfigValue("spring.data.mongodb.port")))));
                });
    }
}