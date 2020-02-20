package org.dominisoft.scrumdev.claro2020.domain;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public final class DopNationalIdentificationNumberTests {

  public static class ConstructorMessageTests {

    @Test(expected = NullPointerException.class)
    public void rejects_null() {
      new DopNationalIdentificationNumber(null);
    }

//		@Test(expected = IllegalArgumentException.class)
//		public void rejects_white_space_only() {
//			new DopNationalIdentificationNumber("           ");
//		}
  }
}
