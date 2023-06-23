package at.cgsit.jeemicro.bean_validation;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class BVTestObjectTest {

    @Inject
    Validator validator;

    @Test
    void isBVTest2Valid() {
        BVTestObject2 bvTestObject2 = new BVTestObject2();
        Set<ConstraintViolation<BVTestObject2>> validate = validator.validate(bvTestObject2);
        validate.forEach(v -> System.out.println("failed: " + v.getPropertyPath() + " message: " + v.getMessage()));
        assertEquals(1, validate.size());
    }

    @Test
    void isChatMessageAllowed() {
        BVTestObject testObject = createTestObject();
        Set<ConstraintViolation<BVTestObject>> validate = validator.validate(testObject);
                validate.forEach(v -> System.out.println("failed: " + v.getPropertyPath() + " message: " + v.getMessage()));
        assertEquals(2, validate.size());
    }

    private BVTestObject createTestObject() {
        BVTestObject bvTestObject = new BVTestObject();
        bvTestObject.setName("chris");
        bvTestObject.setDescription("description");
        bvTestObject.setAmount(new BigDecimal(50));
        bvTestObject.setPercent(50);
        bvTestObject .setEmail("office@cgs.at");

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);
        bvTestObject.setFutureDate(cal);

        bvTestObject.setReferenceObject(new BVTestObject2());

        return bvTestObject;
    }

}