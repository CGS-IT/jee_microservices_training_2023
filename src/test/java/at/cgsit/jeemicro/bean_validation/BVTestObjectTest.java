package at.cgsit.jeemicro.bean_validation;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class BVTestObjectTest {

    @Inject
    Validator validator;

    @Test
    void isChatMessageAllowed() {
        Set<ConstraintViolation<BVTestObject>> validate = validator.validate(createTestObject());
        validate.forEach(v -> System.out.println(v.getMessage()));
        assertEquals(validate.size(),1);
    }

    private BVTestObject createTestObject() {
        BVTestObject bvTestObject = new BVTestObject();
        bvTestObject.setName("chris");
        bvTestObject.setDescription("description");
        bvTestObject.setAmount(new BigDecimal(50));
        bvTestObject.setPercent(50);
        bvTestObject .setEmail("office@cgs.at");
        return bvTestObject;
    }

}