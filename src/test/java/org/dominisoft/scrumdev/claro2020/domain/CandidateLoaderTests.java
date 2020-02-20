package org.dominisoft.scrumdev.claro2020.domain;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CandidateLoaderTests {

  /*
   * CandidateLoader: <filename>.csv => List<Candidate> 1. If csv is empty =>
   * List<Candidate> empty 2. If csv is null => NullPointerException
   */

  @Test(expected = NullPointerException.class)
  public void with_null_csv_return_NullPointerException() {
    String filePath = null;
    new CandidateLoader(filePath);
  }

  @Test
  public void with_empty_csv_return_empty_Candidate_list() {
    String filePath = "candidatesEmpty.csv";
    CandidateLoader loader = new CandidateLoader(filePath);
    List<Candidate> candidates = loader.getCandidates();

    Assert.assertEquals(0, candidates.size());
  }

  @Test
  public void with_not_empty_csv_return_empty_Candidate_list() {
    String filePath = "candidates.csv";
    CandidateLoader loader = new CandidateLoader(filePath);
    List<Candidate> candidates = loader.getCandidates();

    Assert.assertNotEquals(0, candidates.size());
  }

}
