package org.dominisoft.scrumdev.claro2020;

import org.junit.Assert;
import org.junit.Test;

public final class ValidateCedulaTest {

    @Test
    public void when_Length_Equals_Eleven() {
        Cedula cedula = new Cedula("40228269151");
        Assert.assertEquals(cedula.validateLength(), true);
    }

    @Test
    public void when_Cedula_Is_Not_Valid() {
        Cedula cedula = new Cedula("40228269141");
        Assert.assertEquals(cedula.validateCedula(), false);
    }

    @Test
    public void when_Cedula_Is_Valid() {
        Cedula cedula = new Cedula("40228269151");
        Assert.assertEquals(cedula.validateCedula(), true);
    }
}
