package io.swagger.pet.store.tests.framework.tests;

import io.swagger.pet.store.tests.framework.methods.pet.GetPetApiRequest;
import io.swagger.pet.store.tests.framework.methods.pet.PostPetApiRequest;
import io.swagger.petstore.model.Category;
import io.swagger.petstore.model.Pet;
import org.testng.annotations.Test;

import java.util.Arrays;

import static io.swagger.petstore.model.Pet.StatusEnum.AVAILABLE;
import static org.assertj.core.api.Assertions.assertThat;

public class PetTest {

    @Test
    public void getPetTest() {
        Pet pet = new GetPetApiRequest()
                .pet("123")
                .sendRequest()
                .assertRequestSuccess()
                .getResponseModel();

        assertThat(pet.getId()).isEqualTo(123L);
    }

    @Test
    public void postPetTest() {
        Pet petToBeAdded = getTestPet();

        Pet createdPet = new PostPetApiRequest()
                .pet(petToBeAdded)
                .sendRequest()
                .assertRequestSuccess()
                .getResponseModel();

        assertThat(createdPet.getId()).isEqualTo(petToBeAdded.getId());
    }

    private Pet getTestPet() {
        return new Pet().id(TestUtils.nextId()).name("alex").status(AVAILABLE)
                .category(new Category().id(TestUtils.nextId()).name("dog"))
                .photoUrls(Arrays.asList("http://foo.bar.com/1"));
    }

}