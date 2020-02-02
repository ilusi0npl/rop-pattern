package io.swagger.pet.store.tests.framework.methods.pet;

import io.swagger.pet.store.tests.framework.client.PetApiEndpoint;
import io.swagger.petstore.model.Pet;
import org.apache.http.HttpStatus;

import java.lang.reflect.Type;
import java.util.function.Function;

public class PostPetApiRequest extends PetApiEndpoint<PostPetApiRequest, Pet> {

    private Pet pet;

    public PostPetApiRequest pet(Pet pet) {
        this.pet = pet;
        return this;
    }

    @Override
    public PostPetApiRequest sendRequest() {
        response = getServiceApi()
                .addPet()
                .body(pet)
                .execute(Function.identity());
        return this;
    }

    @Override
    protected int getSuccessStatusCode() {
        return HttpStatus.SC_OK;
    }

    @Override
    protected Type getModelType() {
        return Pet.class;
    }

}