package io.swagger.pet.store.tests.framework.client;

import io.swagger.pet.store.tests.framework.base.BaseEndpoint;
import io.swagger.pet.store.tests.framework.base.ConfigurationBuilder;
import io.swagger.pet.store.tests.framework.service.RestService;
import io.swagger.petstore.client.PetApi;


public abstract class PetApiEndpoint<E, M> extends BaseEndpoint<E, M> implements RestService<PetApi> {

    @Override
    public PetApi getServiceApi() {
        return PetApi.pet(new ConfigurationBuilder().getRequestSpecBuilder());
    }

}